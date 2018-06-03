package com.oakwood.repository.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.oakwood.repository.role.RoleRepositoryTest;
import com.oakwood.repostiory.permission.PermissionRepositoryTest;
import com.oakwood.repostiory.user.UserRepositoryTest;

/**
 * 
 * @author Johnlery
 * @since 06/02/2018
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ UserRepositoryTest.class, RoleRepositoryTest.class, PermissionRepositoryTest.class })
public class RepositoryTestSuite {

}
