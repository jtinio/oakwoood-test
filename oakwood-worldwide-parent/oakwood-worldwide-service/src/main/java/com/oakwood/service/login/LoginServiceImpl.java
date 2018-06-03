package com.oakwood.service.login;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.oakwood.dto.user.UserLoginDto;
import com.oakwood.repository.permission.PermissionRepository;
import com.oakwood.repository.user.UserRepository;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
@Service
public class LoginServiceImpl implements LoginService {

	private final UserRepository userRepository;
	private final PermissionRepository permissionRepository;

	public LoginServiceImpl(UserRepository userRepository, PermissionRepository permissionRepository) {
		super();
		this.userRepository = userRepository;
		this.permissionRepository = permissionRepository;
	}

	@Override
	public Optional<UserLoginDto> loginByUsername(final String username) {
		return userRepository.findAccountIdAndPasswordByUsername(username, new PageRequest(0, 1))
				.map(result -> extractAccountIdAndPasswordResult(result)).findFirst();
	}

	private UserLoginDto extractAccountIdAndPasswordResult(final Object[] result) {
		final int accountIdResultIndex = 0;
		final int passwordResultIndex = 1;
		final byte[] passwordByte = (byte[]) result[passwordResultIndex];
		String userPassword = new String(passwordByte);
		return new UserLoginDto((int) result[accountIdResultIndex], userPassword);
	}

	@Override
	public List<String> getPermissionsByAccountId(final int accountId) {
		return permissionRepository.findPermissionNamesByAccountId(accountId);
	}

}
