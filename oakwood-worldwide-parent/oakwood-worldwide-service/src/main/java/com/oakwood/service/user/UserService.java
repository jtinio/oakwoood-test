package com.oakwood.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

	List<UserDto> getAllUsers();

	Page<UserDto> getUserDatasource(final Pageable pageable);

	Page<UserDto> getUserDatasourceWithSearch(final String search, final Pageable pageable);
}
