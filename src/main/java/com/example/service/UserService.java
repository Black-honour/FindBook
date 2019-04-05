package com.example.service;
 
//import com.example.entity.LoginReturnData;
import com.example.entity.User;

import com.example.mapper.UserMapper;
import com.example.utils.ResultData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
/**
 * @Author:wjup
 * @Date: 2018/9/26 0026
 * @Time: 15:23
 */
@Service
public interface UserService {
   
	/**
	 * 检查用户名是否存在
	 * @param username 用户名
	 * @return
	 */
	ResultData<User> checkUsername(String username) throws Exception;
	
	/**
	 * 注册
	 * @param session
	 * @param username 用户名
	 * @param password 密码
	 * @param nickName 昵称
	 * @return
	 */
	ResultData<User> register(String accid,String username, String password) throws Exception;
	
	/**
	 * 判断书荒号是否已经被注册了
	 * @param accid
	 * @return
	 */
	Boolean isAlreadyRegistered(String accid);
	
	/**
	 * 登录
	 * @param session
	 * @param username 用户名
	 * @param password 密码
	 * @param checkCode 验证码
	 * @return
	 * @throws Exception
	 */
	ResultData<User> login(String accid, String password) throws Exception;
	
	/**
	 * 更新用户资料
	 * 
	 */
	ResultData<User> updateUser(int id,String accid,String password,
			String username,String sex,String birthday,String phone,
			String province,String city,String signDesc,String email)throws Exception;

}