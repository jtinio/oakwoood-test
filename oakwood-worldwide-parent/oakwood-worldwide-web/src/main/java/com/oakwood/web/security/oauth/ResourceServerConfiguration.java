package com.oakwood.web.security.oauth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import com.oakwood.utility.constants.OAuthConstants;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	private final TokenStore tokenStore;

	public ResourceServerConfiguration(TokenStore tokenStore) {
		super();
		this.tokenStore = tokenStore;
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(OAuthConstants.RESOURCE_ID).tokenStore(tokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().csrf().disable()
			.httpBasic().disable()
			.authorizeRequests()
			.antMatchers("/","/login**").permitAll()
			.antMatchers("/swagger-ui.html", "/swagger-resources/**", "/v2/**").permitAll()
			.anyRequest()
			.fullyAuthenticated();
//			.and().exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"));
	}

}