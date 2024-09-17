package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;
import com.example.demo.Enums.UserRole;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 Optional<User> findFirstByEmail(String email);

	    User findByUserRole(UserRole userRole);
}
