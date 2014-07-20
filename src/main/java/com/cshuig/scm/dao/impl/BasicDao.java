/**
 * 
 */
package com.cshuig.scm.dao.impl;

import com.cshuig.scm.common.Pager;
import com.cshuig.scm.common.SystemContext;
import com.cshuig.scm.dao.IBasicDao;
import com.cshuig.scm.exception.DaoException;
import org.apache.ibatis.session.SqlSession;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.xml.bind.PropertyException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.*;

/**
 *  类的功能说明：
 *  创建者：Administrator
 *  创建时间:2014年3月15日 下午9:08:50
 */
@SuppressWarnings("unchecked")
@Repository
public class BasicDao<T> implements IBasicDao<T> {
	
	/**
	 * 1、spring3中没有为hibernate4提供：HibernateDaoSupport类，但是从spring4开始就有提供
	 * 2、在spring4中没有为Hibernate4提供：AnnotationSessionFactoryBean 这个类(只有hibernate3才有,如下)
	 * 			org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean
	 * 
	 * 
	 * 3、由于使用了maven进行模块开发，所以对于此模块(basic-hibernate)来说,最好不和其他框架(如：spring)产生依赖(解耦合),
	 * 	 所以不继承spring提供的hibernate支持(即：extends HibernateDaoSupport)，
	 * 	         而使用hibernate自己的：SessionFactory
	 */
	
	/** Hibernate的*/
	private SessionFactory sessionFactory;
    /** mybatis的，
     * 从MyBatis3.X开始，对mapper中的namespace属性新增了一个特性：
     * 可以指定具体的接口来作为持久化操作类，在接口中定义与映射文件中id属性值相同的方法，
     * MyBatis会自动去绑定和执行对应的SQL语句。这种接口实现方式，
     * 需要为每个Mapper创建一个接口，如果系统做大了，维护这些类会比较麻烦，
     * 个人比较喜欢:基础服务式的Dao实现类
     * */
    private SqlSession sqlSession;

	@Inject
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    @Inject
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Session getSession(){
		/**
		 * 以下写法会报一个打开两个session的异常：
		 * 		org.hibernate.HibernateException: illegally attempted to associate a proxy with two open Sessions
		 * 原因是：session已经交给spring来管理，不能每次都打开一个新的,必须每次都是获取当前的session
		 * return sessionFactory.openSession();
		 */
		return sessionFactory.getCurrentSession();
		
	}
	/**
	 * 添加一个实体对象
	 * @param t
	 * @return
	 */
	@Override
	public T addObject(T t)  throws DaoException {
		this.getSession().save(t);
		return t;
	}

	/**
	 * 删除一个实体对象，实际开发中,物理删除很少使用,一般都是使用update将对象置为无效
	 * @param id
	 */
	@Override
	public void deleteObject(int id) throws DaoException {
		this.getSession().delete(this.getObjectById(id));
	}

	/**
	 * 修改一个实体对象
	 * @param t
	 * @return
	 */
	@Override
	public T updateObject(T t)  throws DaoException{
		this.getSession().update(t);
		return t;
	}

	/**
	 * 通过ID,得到一个实体对象
	 * @param id
	 * @return
	 */
	@Override
	public T getObjectById(int id)  throws DaoException{
		//此时由于不知道T的具体实体类,所以必须先获取T的类型
		return (T) this.getSession().load(this.getClz(), id);
	}


	/**
	 * 使用HQL,进行不分页查询
	 * @param hql
	 * @param arguments		数组：多个非别名参数(hql带 '?')
	 * @param aliases		数组：多个别名参数(hql带':aliases')
	 * @return
	 */
	public List<T> listByHql(String hql, Object[] arguments, Map<String, Object> aliases)  throws DaoException{
		//设置排序
		hql = this.setOrder(hql);
		Query query = this.getSession().createQuery(hql);
		this.setParameters(query, arguments, aliases);
		return query.list();
	}

	/**
	 * 使用HQL,进行分页查询
	 * @param hql
	 * @param arguments	数组：多个非别名参数(hql带 '?')
	 * @param aliases	数组：多个别名参数(hql带':aliases')
	 * @return
	 */
	public Pager<T> pagerListByHql(String hql, Object[] arguments, Map<String, Object> aliases)  throws DaoException{
		hql = this.setOrder(hql);
		Query queryForList = this.getSession().createQuery(hql);
		Query queryForCount = this.getSession().createQuery(this.getCountHql(hql, true));
		
		this.setParameters(queryForList, arguments, aliases);
		this.setParameters(queryForCount, arguments, aliases);
		
		Pager<T> pager = new Pager<T>();
		Integer pageIndex = SystemContext.getPageIndex();
		Integer pageSize = SystemContext.getPageSize();
		if(pageIndex==null || pageIndex<0) pageIndex=0;	//默认从第一页第一条记录开始
		if(pageSize==null || pageSize<0) pageSize=15;	//默认每页显示15条记录
		pager.setPageIndex(pageIndex);
		pager.setPageSize(pageSize);
		
		queryForList.setFirstResult(pageIndex).setMaxResults(pageSize);
		pager.setPageDatas(queryForList.list());
		pager.setTotalRecord((Long)queryForCount.uniqueResult());
		return pager;
	}



	/**
	 * 使用HQL，获取一个对象
	 * @param hql
	 * @param arguments	数组：多个非别名参数(hql带 '?')
	 * @param aliases	数组：多个别名参数(hql带':aliases')
	 * @return
	 */
	public Object queryObjectByHql(String hql, Object[] arguments, Map<String, Object> aliases)  throws DaoException{
		Query query = this.getSession().createQuery(hql);
		this.setParameters(query, arguments, aliases);
		return query.uniqueResult();
	}

	/**
	 * 使用HQL，更新一个对象
	 * @param hql
	 * @param arguments	数组：多个非别名参数(hql带 '?')
	 * @param aliases	数组：多个别名参数(hql带':aliases')
	 * @return
	 */
	public void updateObjectByHql(String hql, Object[] arguments, Map<String, Object> aliases)  throws DaoException{
		Query query = this.getSession().createQuery(hql);
		this.setParameters(query, arguments, aliases);
		query.executeUpdate();
	}

    /**
     * 使用原生SQL语句,进行不分页查询
     * 使用原生的SQL语句查询
     * 泛型限制使用方法：
     * 		<T extends Collection>这里的限定使用关键字extends，后面可以是类、也可以是接口。
     * 			但这里的extends已经不是继承的含义了，
     * 			应该理解为T类型是实现Collection接口的类型，或者T是继承了XX类的类型。
	 * @param sql
	 * @param arguments	数组：多个非别名参数(hql带 '?')
	 * @param aliases	数组：多个别名参数(hql带':aliases')
	 * @param clz	返回的集合中的对象类型
	 * @param hasEntity	是否hibernate所管理的实体
	 * @return
	 */
	public <T> List<T> listBySql(String sql, Object[] arguments, Map<String, Object> aliases, Class<T> clz, boolean hasEntity)  throws DaoException{
		
		SQLQuery sqlQuery = this.getSession().createSQLQuery(sql);
		this.setOrder(sql);
		this.setParameters(sqlQuery, arguments, aliases);
		if(hasEntity){
			sqlQuery.addEntity(clz);
		}else{
			sqlQuery.setResultTransformer(Transformers.aliasToBean(clz));
		}
		return sqlQuery.list();
	}

	/**
	 * 使用原生SQL语句，进行分页查询
	 * @param sql
	 * @param arguments	数组：多个非别名参数(hql带 '?')
	 * @param aliases	数组：多个别名参数(hql带':aliases')
	 * @param clz	返回的集合中的对象类型
	 * @param hasEntity	是否hibernate所管理的实体
	 * @return
	 */
	public <T> Pager<T> pagerListBySql(String sql, Object[] arguments,
			Map<String, Object> aliases, Class<T> clz, boolean hasEntity)  throws DaoException{
		
		sql = this.setOrder(sql);
		SQLQuery queryForList = this.getSession().createSQLQuery(sql);
		SQLQuery queryForCount = this.getSession().createSQLQuery(this.getCountHql(sql, false));
		
		this.setParameters(queryForList, arguments, aliases);
		this.setParameters(queryForCount, arguments, aliases);
		
		Pager<T> pagers = new Pager<T>();
		Integer pageIndex = SystemContext.getPageIndex();
		Integer pageSize = SystemContext.getPageSize();
		if(pageIndex==null || pageIndex<0) pageIndex = 0;	//默认从第一页第一条记录开始
		if(pageSize==null || pageSize<0) pageSize=15;		//默认每页显示15条
		queryForList.setFirstResult(pageIndex).setMaxResults(pageSize);
		if(hasEntity){
			queryForList.addEntity(clz);
		}else{
			queryForList.setResultTransformer(Transformers.aliasToBean(clz));
		}
		pagers.setPageIndex(pageIndex);
		pagers.setPageSize(pageSize);
		pagers.setPageDatas(queryForList.list());
		pagers.setTotalRecord(((BigInteger)queryForCount.uniqueResult()).longValue());
		
		return pagers;
	}

	/**
	 * 获取当前的泛型对象T：具体事例对象
	 */
	private Class<T> clz;

	public Class<T> getClz() throws DaoException{
		if(clz == null){
			clz = ((Class<T>)(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}
	
	/**
	 * 获取分页查询中的总记录数的：HQL语句
	 * @param hql
	 * @return
	 */
	public String getCountHql(String hql, boolean hasHql) throws DaoException{
		String countHql = hql.substring(hql.indexOf("from"));
		countHql = "select count(*) " + countHql;
		if(hasHql){
			countHql.replace("fetch", "");
		}
		return countHql;
	}
	
	/**
	 * 为HQL查询语句添加排序信息
	 * @param hql
	 * @return
	 */
	public String setOrder(String hql) throws DaoException{
		String orderField = SystemContext.getOrderField();//排序的字段
		String order = SystemContext.getOrder();//排序方式
		if(orderField!=null && !"".equals(orderField.trim())){
			hql += " order by " + orderField;
			if(null !=order && !"desc".equals(order)){
				hql += " asc";
			}else{
				hql += " desc";
			}
		}
		return hql;
	}
	/**
	 * 为HQL查询语句中的查询条件赋值
	 * @param query
	 * @param arguments	非别名参数
	 * @param aliases	别名参数
	 */
	public void setParameters(Query query, Object[] arguments, Map<String, Object> aliases) throws DaoException{
		//设置参数1:别名参数(:name)
		if(aliases!=null){
			Set<String> keys = aliases.keySet();
			for(String key : keys){
				Object value = (Object) aliases.get(key);
				if(value instanceof Collection){
					//如果是集合的话
					query.setParameterList(key, (Collection)value);
				}else{
					query.setParameter(key, value);
				}
			}
		}
		//设置参数2：非别名(?)
		if(arguments!=null && arguments.length>0){
			int index = 0;//参数从下标0开始遍历赋值
			for(Object value : arguments){
				query.setParameter(index++, value);
			}
		}
	}



    /** Mybatis的Dao方法实现-----------------------------------------------------------------------------------------------*/

    /**
     * 动态切换不同数据库的：分页方法如：mysql使用limit，oracle使用：rownum
     * @param sql
     * @param page
     * @return
     */
    private String generatePageSql(String sql, Pager page) {
        String dialect = this.getDialect();
        if (page != null && (dialect !=null || !dialect.equals(""))) {
            StringBuffer pageSql = new StringBuffer();
            if ("mysql".equals(dialect)) {
                pageSql.append(sql);
                pageSql.append(" limit " + page.getPageIndex() + "," + page.getPageSize());
            } else if ("oracle".equals(dialect)) {
                pageSql.append("select * from (select tmp_tb.*,ROWNUM row_id from (");
                pageSql.append(sql);
                pageSql.append(")  tmp_tb where ROWNUM<=");
                pageSql.append(page.getPageIndex() + page.getPageSize());
                pageSql.append(") where row_id>");
                pageSql.append(page.getPageIndex());
            }
            return pageSql.toString();
        } else {
            return sql;
        }
    }

    /**
     * 获取数据库方言：mysql和oracle
     * @return
     */
    private String getDialect(){
        Properties properties = new Properties();
        InputStream inputStream = this.getClass().getResourceAsStream("/jdbc.properties");
        String dialect = "";
        try {
            properties.load(inputStream);
            if(properties.getProperty("dialect")==null || properties.getProperty("dialect").equals("")){
                throw new PropertyException("jdbc.properties文件中没有配置:dialect属性");
            }
            dialect = properties.getProperty("dialect");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (PropertyException e) {
            e.printStackTrace();
        }
        return dialect;
    }

}
