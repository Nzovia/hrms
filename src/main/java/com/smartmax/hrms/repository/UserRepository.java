package com.smartmax.hrms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartmax.hrms.entities.User;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User,Integer> {
	Optional<User>findByUsername(String username);

	@Query(value="SELECT * FROM user INNER JOIN reminder ON user.id =  reminder.user_id AND reminder.id = ?",nativeQuery=true)
    Optional<User> findByReminderId(int id);
}
