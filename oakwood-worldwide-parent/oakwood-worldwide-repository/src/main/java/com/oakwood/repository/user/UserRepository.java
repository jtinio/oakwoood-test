package com.oakwood.repository.user;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oakwood.dto.user.UserDto;
import com.oakwood.model.user.User;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u.id, u.password FROM User u WHERE u.username = ?1")
	Stream<Object[]> findAccountIdAndPasswordByUsername(final String username, final Pageable pageable);

	boolean existsByUsername(final String username);

	boolean existsByEmail(final String email);
	
	@Query(nativeQuery = true)
	Optional<UserDto> findUserById(final int id);
}
