package com.newer.service;

import com.newer.entity.AdminUser;

/**
 * 
 * @author kai
 *
 */
public interface AdminUserService {
	
	void add(AdminUser adminUser);

	AdminUser login(AdminUser adminUser);
}
