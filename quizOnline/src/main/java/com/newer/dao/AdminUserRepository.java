package com.newer.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.newer.entity.AdminUser;

@Repository
public interface AdminUserRepository extends MongoRepository<AdminUser, String>{

	@Query("{'adminUserName':?0}")
	AdminUser findByAdminUserName(String adminUserName);
}
