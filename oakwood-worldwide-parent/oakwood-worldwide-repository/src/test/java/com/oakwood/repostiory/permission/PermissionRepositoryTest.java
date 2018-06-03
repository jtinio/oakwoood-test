package com.oakwood.repostiory.permission;

import org.springframework.beans.factory.annotation.Autowired;

import com.oakwood.repository.permission.PermissionRepository;
import com.oakwood.repository.testsuite.BaseRepositoryTest;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
public class PermissionRepositoryTest extends BaseRepositoryTest {

	@Autowired
	private PermissionRepository permissionRepository;
}
