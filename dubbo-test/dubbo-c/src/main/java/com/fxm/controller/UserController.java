package com.fxm.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fxm.pojo.User;
import com.fxm.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {
	
	//check表示检查服务提供者是否启动.如果没有服务提供者则报错.
	@Reference(timeout=3000,check=false,loadbalance="consistenthash")
	private UserService userService;

	@RequestMapping("/findAll")
	public List<User> findAll(){
		System.out.println(userService.getClass());
		return userService.findAll();
	}
	
	@RequestMapping("/saveUser/{name}/{age}/{sex}")
	public String saveUser(User user) {
		userService.saveUser(user);
		return "用户入库成功!!!";
	}
}
