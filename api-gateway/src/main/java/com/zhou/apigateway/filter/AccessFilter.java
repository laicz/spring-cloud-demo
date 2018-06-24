/**
 * Date:     2018/6/2223:30
 * AUTHOR:   Administrator
 */
package com.zhou.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 2018/6/22  23:30
 * created by zhoumb
 */
public class AccessFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 过滤器类型，可是选择在哪个生命周期执行
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序，当请求在一个阶段中存在多个过滤器时，可以指定过滤器的执行顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否应该执行
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        logger.info("send() request to ()", request.getRequestURL().toString());
        String accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            logger.info("access token is empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            return null;
        }
        return null;
    }
}
