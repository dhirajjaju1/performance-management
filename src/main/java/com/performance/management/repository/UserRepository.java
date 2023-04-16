package com.performance.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.performance.management.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	Optional<User> findByUserName(String userName);

	Optional<User> findByEmployeeId(String employeeId);

	Boolean existsByUserName(String userName);

	Boolean existsByEmail(String email);

	Long deleteByEmployeeId(String employeeId);
	
	List<User> findByEmployeeIdOrUserName(String employeeId, String userName);
		
	List<User> findByManagersId(String managersId);
}
