package ru.kpfu.shop.filters;

/**
 * Created by etovladislav on 05.05.16.
 */

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CrossScriptingFilter implements Filter {
    private static Logger logger = Logger.getLogger(CrossScriptingFilter.class);
    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
        this.filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("In doFilter CrossScriptingFilter  ...............");
        chain.doFilter(new RequestWrapper((HttpServletRequest) request), response);
        logger.info("Out doFilter CrossScriptingFilter ...............");
    }
}