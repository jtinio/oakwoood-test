package com.oakwood.web.security.oauth;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.oakwood.utility.constants.OAuthConstants;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	private final JwtAccessTokenConverter jwtAccessTokenConverter;
	private final TokenStore tokenStore;
	private final AuthenticationManager authenticationManager;
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;

	public AuthorizationServerConfiguration(JwtAccessTokenConverter jwtAccessTokenConverter, TokenStore tokenStore,
			AuthenticationManager authenticationManager, UserDetailsService userDetailsService,
			PasswordEncoder passwordEncoder) {
		super();
		this.jwtAccessTokenConverter = jwtAccessTokenConverter;
		this.tokenStore = tokenStore;
		this.authenticationManager = authenticationManager;
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess("isAnonymous() || permitAll()").checkTokenAccess("permitAll()");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
		enhancerChain.setTokenEnhancers(Arrays.asList(jwtAccessTokenConverter));
		endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager).tokenEnhancer(enhancerChain)
				.userDetailsService(userDetailsService);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient(OAuthConstants.CLIENT)
				.authorizedGrantTypes(OAuthConstants.GRANT_TYPE_PASSWORD, OAuthConstants.GRANT_TYPE_REFRESH_TOKEN)
				.scopes(OAuthConstants.SCOPE_READ, OAuthConstants.SCOPE_WRITE)
				.resourceIds(OAuthConstants.RESOURCE_ID)
				.secret(passwordEncoder.encode(OAuthConstants.SECRET))
				.accessTokenValiditySeconds(OAuthConstants.ACCESS_TOKEN_VALIDITY_IN_SECONDS);
//				.redirectUris("/login");
	}

}
