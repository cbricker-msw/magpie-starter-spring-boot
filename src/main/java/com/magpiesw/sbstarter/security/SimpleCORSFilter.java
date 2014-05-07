package com.magpiesw.sbstarter.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class SimpleCORSFilter extends OncePerRequestFilter
{
    private static final Logger LOG = LoggerFactory.getLogger(SimpleCORSFilter.class);
    
    private static final String OPTIONS = "OPTIONS";
    private static final String AC_REQUEST_METHOD = "Access-Control-Request-Method";
    
    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, PATCH");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type, Accept, Authorization");
            
        if (isOriginRequest(request))
        {
            try
            {
                response.getWriter().print("OK");
                response.getWriter().flush();
            }
            catch (IOException e)
            {
                LOG.info("Unable to write ORIGIN response", e);
            }
            return;
        }
        
        chain.doFilter(request, response);            
    }
    
    private boolean isOriginRequest(HttpServletRequest request)
    {
        return request.getHeader(AC_REQUEST_METHOD) != null &&
            OPTIONS.equalsIgnoreCase(request.getMethod());
    }
}
