package com.oakwood.utility.constants;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
public final class OAuthConstants {

	public static final String RESOURCE_ID = "OAKWOOD";
	public static final String CLIENT = "OakwoodWeb";
	public static final String GRANT_TYPE_PASSWORD = "password";
	public static final String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";
	public static final String SCOPE_READ = "read";
	public static final String SCOPE_WRITE = "write";
	public static final String SECRET = "OakwoodWorldwide";
	public static final int ACCESS_TOKEN_VALIDITY_IN_SECONDS = 600;

	private OAuthConstants() {
	}
}
