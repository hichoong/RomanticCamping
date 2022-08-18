package com.kh.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/member/*")
public class MemberFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		if(((HttpServletRequest)request).getSession().getAttribute("loginMember") != null) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("/").forward(request, response);
		}
		
	}

}
