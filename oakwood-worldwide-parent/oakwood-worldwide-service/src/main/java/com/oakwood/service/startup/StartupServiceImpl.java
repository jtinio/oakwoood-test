package com.oakwood.service.startup;

import java.util.Arrays;
import java.util.Optional;

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
			final Optional<Role> role = roleRepository.findById(1);
			final User user = new User();
			user.setUsername("admin");
			user.setPassword(BCrypt.hashpw("admin", BCrypt.gensalt()).getBytes());
			user.setFirstName("Admin");
			user.setLastName("Admin");
			user.setEmail("jtinio@oakwood.com");
			if(role.isPresent()) {
				user.setRoles(Arrays.asList(role.get()));
			}
			userRepository.save(user);
		}
	}

}
