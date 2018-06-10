package com.oakwood.repository.user;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

	@Query(nativeQuery = true)
	List<UserDto> findAllUsers();

	@Query(value = "SELECT u.id, u.firstName, u.lastName, u.email FROM User u", countQuery = "SELECT COUNT(u.id) FROM User u")
	Page<Object[]> findUserByPageable(final Pageable pageable);

	@Query(value = "SELECT u.id, u.firstName, u.lastName, u.email FROM User u WHERE u.firstName LIKE %:search% OR u.lastName LIKE %:search% OR u.email LIKE %:search%", 
			countQuery = "SELECT COUNT(u.id) FROM User u WHERE u.firstName LIKE %:search% OR u.lastName LIKE %:search% OR u.email LIKE %:search%")
	Page<Object[]> findUserBySearchAndPageable(final @Param("search") String search, final Pageable pageable);

}
