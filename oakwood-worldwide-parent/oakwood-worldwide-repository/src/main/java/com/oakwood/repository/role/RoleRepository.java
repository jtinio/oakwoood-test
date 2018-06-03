package com.oakwood.repository.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oakwood.model.role.Role;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
