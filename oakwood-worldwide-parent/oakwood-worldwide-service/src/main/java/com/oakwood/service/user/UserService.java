package com.oakwood.service.user;

import java.util.Optional;

import com.oakwood.dto.user.UserDto;
import com.oakwood.dto.user.UserRegistrationDto;
import com.oakwood.utility.exception.EmailExistException;
import com.oakwood.utility.exception.UsernameExistException;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
public interface UserService {

	Optional<Integer> createUser(final UserRegistrationDto userRegistrationDto)
			throws UsernameExistException, EmailExistException;

	boolean existsByUsername(final String username);

	boolean existsByEmail(final String email);
	
	Optional<UserDto> getUserById(final int id);
}
