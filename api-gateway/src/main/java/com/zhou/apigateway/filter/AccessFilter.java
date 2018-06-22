/**
 * Date:     2018/6/2223:30
 * AUTHOR:   Administrator
 */
package com.zhou.apigateway.filter;

import com.netflix.zuul.ZuulFilter;

/**
 * 2018/6/22  23:30
 * created by zhoumb
 */
public class AccessFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
        return null;
    }
}
