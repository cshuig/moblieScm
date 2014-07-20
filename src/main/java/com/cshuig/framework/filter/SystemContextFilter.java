package com.cshuig.framework.filter;

import com.cshuig.scm.common.SystemContext;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 2014/7/20.
 */
public class SystemContextFilter implements Filter{

    private Integer pageSize;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        pageSize = Integer.parseInt(filterConfig.getInitParameter("pageSize"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        try {
            Integer startPage = 0;
            startPage = Integer.parseInt(request.getParameter("startPage"));

            SystemContext.setOrder(request.getParameter("order"));
            SystemContext.setPageSize(pageSize);
            SystemContext.setOrderField(request.getParameter("sortField"));
            SystemContext.setPageIndex(startPage);
            filterChain.doFilter(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            SystemContext.removeOrder();
            SystemContext.removePageSize();
            SystemContext.removePageIndex();
            SystemContext.removeOrderField();
        }
    }

    @Override
    public void destroy() {

    }
}
