package com.jasonz.security;

public class SecurityConstants
{
	public static final String PUBLIC_REQUEST_SIGN_IN_URL = "/users/signin";
	public static final String PUBLIC_REQUEST_SIGN_UP_URL = "/users/signup";
    public static final String PUBLIC_REQUEST_VERIFICATION_EMAIL_URL = "/users/emailVerification";
	public static final String PUBLIC_REQUEST_PASSWORD_RESET_URL = "/users/passwordReset";
	public static final String HEADER_NAME = "Authorization";
    public static final Long EXPIRATION_TIME = (1*24*60*60 * 1000L); //day*hours*minutes*seconds*1000
    public static final String TOKEN_PREFIX = "zkz_";
}
