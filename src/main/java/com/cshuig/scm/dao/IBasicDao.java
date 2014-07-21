package com.cshuig.scm.dao;

import com.cshuig.scm.common.Pager;
import com.cshuig.scm.exception.DaoException;
import org.hibernate.Query;

import java.util.List;
import java.util.Map;

/**
 * 基于Hibernate的：通用DAO接口类
 * 其中包含了使用HQL和SQL的常用查询
 * 
 * @author Administrator
 * @since 2014/03/15 18:50
 * @param <T>
 */
public interface IBasicDao<T> {

	/**
	 * 使用hibernate：添加一个实体对象
	 * @param t
	 * @return
	 */
	public T addObject(T t) throws DaoException;
	
	/**
	 * 使用hibernate：删除一个实体对象，实际开发中,物理删除很少使用,一般都是使用update将对象置为无效
	 * @param id
	 */
	public void deleteObject(int id) throws DaoException;
	
	/**
	 * 使用hibernate：修改一个实体对象
	 * @param t
	 * @return
	 */
	public T updateObject(T t) throws DaoException;
	
	/**
	 * 使用hibernate：通过ID,得到一个实体对象
	 * @param id
	 * @return
	 */
	public T getObjectById(int id) throws DaoException;

    /**
     * 使用hibernate：
     * 使用HQL,进行不分页查询
     * @param hql
     * @param arguments		数组：多个非别名参数(hql带 '?')
     * @param aliases		数组：多个别名参数(hql带':aliases')
     * @return
     */
    public List<T> listByHql(String hql, Object[] arguments, Map<String, Object> aliases) throws DaoException;

    /**
     * 使用hibernate：
     * 使用HQL,进行分页查询
     * @param hql
     * @param arguments	数组：多个非别名参数(hql带 '?')
     * @param aliases	数组：多个别名参数(hql带':aliases')
     * @return
     */
    public Pager<T> pagerListByHql(String hql, Object[] arguments, Map<String, Object> aliases) throws DaoException;

    /**
     * 使用hibernate：
     * 使用HQL，获取一个对象
     * @param hql
     * @param arguments	数组：多个非别名参数(hql带 '?')
     * @param aliases	数组：多个别名参数(hql带':aliases')
     * @return
     */
    public Object queryObjectByHql(String hql, Object[] arguments, Map<String, Object> aliases) throws DaoException;

    /**
     * 使用hibernate：
     * 使用HQL，更新一个对象
     * @param hql
     * @param arguments	数组：多个非别名参数(hql带 '?')
     * @param aliases	数组：多个别名参数(hql带':aliases')
     * @return
     */
    public void updateObjectByHql(String hql, Object[] arguments, Map<String, Object> aliases) throws DaoException;

    /**
     * 使用hibernate：
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
    public <T> List<T> listBySql(String sql, Object[] arguments, Map<String, Object> aliases, Class<T> clz, boolean hasEntity) throws DaoException;

    /**
     * 使用hibernate：
     * 使用原生SQL语句，进行分页查询
     * @param sql
     * @param arguments	数组：多个非别名参数(hql带 '?')
     * @param aliases	数组：多个别名参数(hql带':aliases')
     * @param clz	返回的集合中的对象类型
     * @param hasEntity	是否hibernate所管理的实体
     * @return
     */
    public <T> Pager<T> pagerListBySql(String sql, Object[] arguments, Map<String, Object> aliases, Class<T> clz, boolean hasEntity) throws DaoException;

    /**
     * 使用mybatis：添加一个实体对象
     * @param t
     * @return
     */
    public T addObject(String statementId, T t) throws DaoException;

    /**
     * 使用mybatis：删除一个实体对象，实际开发中,物理删除很少使用,一般都是使用update将对象置为无效
     * @param id
     */
    public void deleteObject(String statementId, int id) throws DaoException;

    /**
     * 使用mybatis：修改一个实体对象
     * @param statementId mapper中的namespace.id
     * @param t
     * @return
     */
    public T updateObject(String statementId, T t) throws DaoException;

    /**
     * 使用mybatis：通过ID,得到一个实体对象
     * @param statementId mapper中的namespace.id
     * @param id
     * @return
     */
    public T getObjectById(String statementId, int id) throws DaoException;

    /**
     * 使用mybatis：通过map参数,得到一个实体对象
     * @param statementId mapper中的namespace.id
     * @param params
     * @return
     * @throws DaoException
     */
    public T queryObjectByMap(String statementId, Map params) throws DaoException;



}
