package com.oakwood.web.security.userdetails;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.oakwood.dto.user.UserLoginDto;
import com.oakwood.service.login.LoginService;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

	private final LoginService loginService;

	public DomainUserDetailsService(LoginService loginService) {
		super();
		this.loginService = loginService;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		final Optional<UserLoginDto> userLoginDto = loginService.loginByUsername(username);
		if (userLoginDto.isPresent()) {
			final List<String> permissions = loginService.getPermissionsByAccountId(userLoginDto.get().getId());
			final List<GrantedAuthority> grantedAuths = permissions.stream()
					.map(permission -> new SimpleGrantedAuthority(permission)).collect(Collectors.toList());
			return new User(username, userLoginDto.get().getPassword(), grantedAuths);
		}
		return null;
	}

}
