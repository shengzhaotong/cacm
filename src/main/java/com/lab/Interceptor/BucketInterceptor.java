package com.lab.Interceptor;

import com.lab.Annotation.BucketAnnotation;
import com.lab.Exception.APIException;
import com.lab.utils.BucketUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class BucketInterceptor implements HandlerInterceptor {

    // 预处理回调方法，在接口调用之前使用  true代表放行  false代表不放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        BucketAnnotation methodAnnotation = method.getAnnotation(BucketAnnotation.class);
        if (methodAnnotation!=null){
            // 在名为：bucket的令牌桶里取令牌 取到即放行 未取到即抛出异常
            if(BucketUtil.buckets.get("bucket").getToken()){
                return true;
            }
            else{
                throw new APIException("用户访问量过大，触发限流");
            }
        }else {
            return true;
        }
    }
    // 接口调用之后，返回之前 使用
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    // 整个请求完成后，在视图渲染前使用
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }

}
