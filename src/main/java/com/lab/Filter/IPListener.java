package com.lab.Filter;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.ConcurrentHashMap;

@WebListener
public class IPListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        ConcurrentHashMap<String, Long[]> ipMap = new ConcurrentHashMap<>();
        context.setAttribute("ipMap", ipMap);
        ConcurrentHashMap<String, Long> limitedIpMap = new ConcurrentHashMap<String, Long>();
        context.setAttribute("limitedIpMap", limitedIpMap);
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
    }

}
