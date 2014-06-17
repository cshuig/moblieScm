package com.cshuig.framework.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Administrator on 2014/6/17.
 * 初始化整改个系统的名称，存放在全局环境变量：servletContext中,每个界面可以直接使用：${systemName}
 */
public class SystemInitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("systemName",servletContextEvent.getServletContext().getInitParameter("systemName"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
