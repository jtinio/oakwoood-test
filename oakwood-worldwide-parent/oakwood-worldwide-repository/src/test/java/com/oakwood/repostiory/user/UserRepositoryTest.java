package com.oakwood.repostiory.user;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oakwood.dto.user.UserDto;
import com.oakwood.repository.testsuite.BaseRepositoryTest;
import com.oakwood.repository.user.UserRepository;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
public class UserRepositoryTest extends BaseRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void isUsernameExist() {
		final boolean isUsernameExist = userRepository.existsByUsername("Sample Username");
		Assert.assertFalse(isUsernameExist);
	}

	@Test
	public void isEmailExist() {
		final boolean isEmailExist = userRepository.existsByEmail("sample@test.com");
		Assert.assertFalse(isEmailExist);
	}
	
	@Test
	public void findUserById() {
		final Optional<UserDto> user = userRepository.findUserById(3);
		Assert.assertTrue(user.isPresent());
		System.out.println(user.get().getUsername());
	}
}
