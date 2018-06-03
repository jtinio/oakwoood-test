package com.oakwood.repository.permission;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oakwood.model.permission.Permission;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {

	@Query("SELECT DISTINCT(p.name) FROM Permission p INNER JOIN p.roles r INNER JOIN r.users u WHERE u.id = ?1")
	List<String> findPermissionNamesByAccountId(final int accountId);
}
