package com.oakwood.service.login;

import java.util.List;
import java.util.Optional;

import com.oakwood.dto.user.UserLoginDto;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
public interface LoginService {

	Optional<UserLoginDto> loginByUsername(final String username);
	
	List<String> getPermissionsByAccountId(final int accountId);

}
