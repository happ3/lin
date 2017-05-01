package com.ssm.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ssm.common.Code;
import com.ssm.common.StringUtil;

public class SessionFilter implements Filter {
	
	
    private static Logger logger = LoggerFactory.getLogger(SessionFilter.class);
    private String loginUrl; //允许的路径
    private List<String> allowUrls; //允许的路径
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		loginUrl = "login.html";
		
		allowUrls = new ArrayList<>();
	    allowUrls.add("/login");
	    allowUrls.add("/websocket");
	    allowUrls.add("/upgrade");
	    allowUrls.add("/api/payResultNotify");
	    allowUrls.add("/isv/getTokenByAuthCode");
	    allowUrls.add("/isv/getNameByCustomerId");
	    allowUrls.add("/api/meituan/notify/accessToken");
	    
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	    HttpServletRequest servletRequest = (HttpServletRequest) request;
//        HttpServletResponse servletResponse = (HttpServletResponse) response;
        
        if (null != allowUrls && allowUrls.size() > 0) {
            String requestUrl = servletRequest.getRequestURI().replace(servletRequest.getContextPath(), "");
            logger.debug("****** URI ****** " + requestUrl);
            for (String url : allowUrls) {
                if (StringUtil.stringEquals(requestUrl,url)) {//页面请求路径  与允许路径进行判断
                    chain.doFilter(request, response);
                    return;
                }
            }
        }
        
        
//        Object userId = "";
        
//        if (null == userId || userId.toString().equals("")) {
//            logger.info("未登录");
//            ajaxRequest(servletResponse);
//            return;
//        }
        
        chain.doFilter(request, response);
	}

//	private void ajaxRequest(HttpServletResponse servletResponse) throws IOException {
//        servletResponse.setHeader("Session-Status", "Session-Out");   //在响应头设置session状态
//        servletResponse.setHeader("Redirect-Url", loginUrl);//在响应头设置跳转URL
//        servletResponse.setContentType("application/json;charset=UTF-8");
//        String strJsonFormat = "{\"code\":%d,\"message\": \"%s\"}";
//        PrintWriter out = servletResponse.getWriter();
//        out.println(String.format(strJsonFormat, Code.REDIRECT.code, "登录超时，请重新登录"));
//    }
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
