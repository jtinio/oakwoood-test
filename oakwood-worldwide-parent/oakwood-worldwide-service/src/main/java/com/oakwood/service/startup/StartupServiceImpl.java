package com.oakwood.service.startup;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.oakwood.model.role.Role;
import com.oakwood.model.user.User;
import com.oakwood.repository.role.RoleRepository;
import com.oakwood.repository.user.UserRepository;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
@Service
public class StartupServiceImpl implements StartupService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	public StartupServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Transactional
	@Override
	public void createDefaultAdminIfNotFound() {
		if (!userRepository.existsByUsername("admin")) {
			final Role role = roleRepository.findOne(1);
			final User user = new User();
			user.setUsername("admin");
			user.setPassword(BCrypt.hashpw("Oak123!", BCrypt.gensalt()).getBytes());
			user.setFirstName("Admin");
			user.setLastName("Admin");
			user.setEmail("jtinio@oakwood.com");
			user.setRoles(Arrays.asList(role));
			userRepository.save(user);
		}
	}

}
