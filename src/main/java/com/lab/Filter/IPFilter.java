package com.lab.Filter;

import com.lab.Exception.IPException;
import com.lab.utils.IPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@WebFilter("/**")
@Component
public class IPFilter implements Filter {

    @Autowired
    private IPUtil ipUtil;


    /**
     * 默认限制时间（单位：ms）3600000,3600(s),
     */
    private static final long LIMITED_TIME_MILLIS = 120 * 1000;

    /**
     * 用户连续访问最高阀值，超过该值则认定为恶意操作的IP，进行限制
     */
    private static final int LIMIT_NUMBER = 10;

    /**
     * 用户访问最小安全时间，在该时间内如果访问次数大于阀值，则记录为恶意IP，否则视为正常访问
     */
    private static final int MIN_SAFE_TIME = 1500;

    private FilterConfig config;

    private final HandlerExceptionResolver resolver;

    @Autowired
    public IPFilter(@Qualifier("handlerExceptionResolver") HandlerExceptionResolver resolver) {
        this.resolver = resolver;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;  //设置属性filterConfig
    }

    @SuppressWarnings("unchecked")
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        ServletContext context = config.getServletContext();

        ConcurrentHashMap<String ,Long> limitedIpMap = (ConcurrentHashMap<String, Long>) context.getAttribute("limitedIpMap");

        filterLimitedIpMap(limitedIpMap);

        String ip = ipUtil.getRemoteIpAddr(request);


        if (isLimitedIP(limitedIpMap, ip)) {
            long limitedTime = limitedIpMap.get(ip) - System.currentTimeMillis();
            request.setAttribute("remainingTime", ((limitedTime / 1000) + (limitedTime % 1000 > 0 ? 1 : 0)));
            resolver.resolveException(request,response,null,new IPException(ip+"ip访问过于频繁"));
        }


        ConcurrentHashMap<String, Long[]> ipMap = (ConcurrentHashMap<String, Long[]>) context.getAttribute("ipMap");
        if (ipMap.containsKey(ip)) {
            Long[] ipInfo = ipMap.get(ip);
            ipInfo[0] = ipInfo[0] + 1;
            if (ipInfo[0] > LIMIT_NUMBER) {
                Long ipAccessTime = ipInfo[1];
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ipAccessTime <= MIN_SAFE_TIME) {
                    limitedIpMap.put(ip, currentTimeMillis + LIMITED_TIME_MILLIS);
                    request.setAttribute("remainingTime", LIMITED_TIME_MILLIS);
                    resolver.resolveException(request,response,null,new IPException(ip+"ip访问过于频繁"));
                } else {
                    initIpVisitsNumber(ipMap, ip);
                }
            }
        } else {
            initIpVisitsNumber(ipMap, ip);
        }
        context.setAttribute("ipMap", ipMap);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    private void filterLimitedIpMap(ConcurrentHashMap<String, Long> limitedIpMap) {
        if (limitedIpMap == null) {
            return;
        }
        Set<String> keys = limitedIpMap.keySet();
        Iterator<String> keyIt = keys.iterator();
        long currentTimeMillis = System.currentTimeMillis();
        while (keyIt.hasNext()) {
            long expireTimeMillis = limitedIpMap.get(keyIt.next());
            if (expireTimeMillis <= currentTimeMillis) {
                keyIt.remove();
            }
        }
    }

    /**
     * @Description 是否是被限制的IP
     * @param limitedIpMap
     * @param ip
     * @return true : 被限制 | false : 正常
     */
    private boolean isLimitedIP(ConcurrentHashMap<String, Long> limitedIpMap, String ip) {
        if (limitedIpMap == null || ip == null) {
            return false;
        } else return limitedIpMap.containsKey(ip);
    }

    /**
     * 初始化用户访问次数和访问时间
     *
     * @param ipMap
     * @param ip
     */
    private void initIpVisitsNumber(ConcurrentHashMap<String, Long[]> ipMap, String ip) {
        Long[] ipInfo = new Long[2];
        ipInfo[0] = 0L;// 访问次数
        ipInfo[1] = System.currentTimeMillis();// 初次访问时间
        ipMap.put(ip, ipInfo);
    }

}
