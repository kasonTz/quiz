package com.newer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.dao.AdminUserRepository;
import com.newer.entity.AdminUser;
import com.newer.service.AdminUserService;

@Service
public class AdminUserServiceImpl implements AdminUserService{

	@Autowired
	private AdminUserRepository adminUserRepository;
	
	@Override
	public AdminUser login(AdminUser temp) {
		String adminUserName = temp.getAdminUserName();
		AdminUser adminUser = adminUserRepository.findByAdminUserName(adminUserName);
		System.out.println(adminUser);
		if(adminUser == null) {
			System.out.println("用户名不存在");
			return null;
		}
		System.out.println(adminUser.getAdminPassword() + "+++" + temp.getAdminPassword());
		if(!adminUser.getAdminPassword().equals(temp.getAdminPassword())) {
			System.out.println("密码错误");
			return null;
		}
		System.out.println("登陆成功");
		return adminUser;
	}

	@Override
	public void add(AdminUser adminUser) {
		AdminUser insert = adminUserRepository.insert(adminUser);
		System.out.println("insert: " + insert);
	}

}
