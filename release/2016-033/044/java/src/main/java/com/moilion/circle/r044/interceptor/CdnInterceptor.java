package com.moilion.circle.r044.interceptor;

import com.moilion.circle.r044.interceptor.cdn.CdnConfig;
import com.moilion.circle.r044.interceptor.cdn.CdnFunction;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 在 Request中注入 `cdn` 对象 和 REMOTE_IP 字符串
 * 对于有 cdn version特征的文件，进行拦截，返回真实资源。
 *
 * @author trydofor
 * @since 2016-10-24
 */
public class CdnInterceptor extends HandlerInterceptorAdapter {

    private CdnConfig cdnConfig;

    public void setCdnConfig(CdnConfig cdnConfig) {
        this.cdnConfig = cdnConfig;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String version = cdnConfig.getVersion();

        // 如果是cdnVersion，则脱version后缀，forward
        if (version != null && version.length() > 0) {
            String uri = request.getRequestURI(); // /
            if (uri.endsWith(version)) {
                String newUri = uri.substring(0, uri.length() - version.length());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(newUri);
                requestDispatcher.forward(request, response);
                return false;
            }
        }

        // 注册cdn.url(String)方法

        String remoteIp = request.getRemoteAddr();
        // nginx


        CdnFunction cdnFun = new CdnFunction(cdnConfig, remoteIp);
        request.setAttribute("cdn", cdnFun);

        // 默认处理
        return super.preHandle(request, response, handler);
    }

}
