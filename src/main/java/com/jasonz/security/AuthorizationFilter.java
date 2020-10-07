package com.jasonz.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 *	 访问授权-过滤服务类
 * @author Kaizhi Zhuang
 * @date 2020-9-6
 */
public class AuthorizationFilter extends BasicAuthenticationFilter
{

	public AuthorizationFilter(AuthenticationManager authenticationManager)
	{
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException
	{
	}
}

