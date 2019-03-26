package com.newer.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newer.entity.AdminUser;
import com.newer.service.AdminUserService;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminUserController {

	@Autowired
	private AdminUserService adminUserService;
	
	@GetMapping("/add")
	public String add() {
		AdminUser adminUser = new AdminUser("admin", "123456");
		adminUserService.add(adminUser);
		return "addd";
	}
	
	@PostMapping("/login")
	public int login(@RequestBody AdminUser adminUser) {
		System.out.println(adminUser);
		AdminUser temp = adminUserService.login(adminUser);
		System.out.println("adminUser：" + temp);
		if(temp == null) {
			return 0;
		}else {
			return 1;
		}
	}
	
	@PostMapping("/test")
	public String test(@RequestParam String adminUserName, @RequestParam String adminPassword) {
		System.out.println(adminUserName);
		System.out.println(adminPassword);
		return "asas";
	}
	
}
