package com.oakwood.service.user;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.oakwood.dto.user.UserDto;
import com.oakwood.dto.user.UserRegistrationDto;
import com.oakwood.model.user.User;
import com.oakwood.repository.user.UserRepository;
import com.oakwood.utility.exception.EmailExistException;
import com.oakwood.utility.exception.UsernameExistException;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public Optional<Integer> createUser(final UserRegistrationDto userRegistrationDto)
			throws UsernameExistException, EmailExistException {
		validateUsernameAndEmail(userRegistrationDto);
		User user = new User();
		user.setUsername(userRegistrationDto.getUsername());
		user.setPassword(BCrypt.hashpw(userRegistrationDto.getPassword(), BCrypt.gensalt()).getBytes());
		user.setFirstName(userRegistrationDto.getFirstName());
		user.setLastName(userRegistrationDto.getLastName());
		user.setEmail(userRegistrationDto.getEmail());
		user = userRepository.save(user);
		return Optional.ofNullable(user.getId());
	}

	private void validateUsernameAndEmail(final UserRegistrationDto userRegistrationDto)
			throws UsernameExistException, EmailExistException {
		if (userRepository.existsByUsername(userRegistrationDto.getUsername())) {
			throw new UsernameExistException("Username already exist");
		} else if (userRepository.existsByEmail(userRegistrationDto.getEmail())) {
			throw new EmailExistException("Email already exist");
		}
	}

	@Override
	public boolean existsByUsername(final String username) {
		return userRepository.existsByUsername(username);
	}

	@Override
	public boolean existsByEmail(final String email) {
		return userRepository.existsByEmail(email);
	}

	@Override
	public Optional<UserDto> getUserById(final int id) {
		return userRepository.findUserById(id);
	}

}
