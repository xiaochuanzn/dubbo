package com.fxm.service;

import com.fxm.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserService {
	
	//查询全部的用户信息
	List<User> findAll();
	//新增用户入库操作.
	@Transactional
	void saveUser(User user);
}
