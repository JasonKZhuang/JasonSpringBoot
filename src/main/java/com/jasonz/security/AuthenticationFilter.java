package com.jasonz.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
    *   身份认证- 过滤服务
 * @author Kaizhi Zhuang
 * @date 2020-10-6
 */
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter
{
	private final AuthenticationManager authenticationManager;

	public AuthenticationFilter(AuthenticationManager authenticationManager)
	{
		this.authenticationManager = authenticationManager;
		//this.setFilterProcessesUrl(SecurityConstants.PUBLIC_REQUEST_SIGN_IN_URL);
	}
	

	/**
	 * user click login button and post a url '/user/login', and attempt to get
	 * authentication
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException
	{
		Authentication retValue = null;
		try
		{
//			UserLoginRequestModel userLoginRequestModel = new ObjectMapper().readValue(request.getInputStream(),
//					UserLoginRequestModel.class);
//			String email = userLoginRequestModel.getEmail();
//			String password = userLoginRequestModel.getPassword();
//
//			UsernamePasswordAuthenticationToken upAuthenticationToken = new UsernamePasswordAuthenticationToken(email,
//					password, new ArrayList<>());
//
//			retValue = authenticationManager.authenticate(upAuthenticationToken);

			return retValue;

		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(
			HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult
	) throws IOException, ServletException
	{

	}

	@Override
	protected void unsuccessfulAuthentication(
			HttpServletRequest request, HttpServletResponse response, AuthenticationException failed
	) throws IOException, ServletException
	{
		super.unsuccessfulAuthentication(request, response, failed);
	}

}
