package com.example.mapper;


import com.example.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
 
/**
 * @Author:wjup
 * @Date: 2018/9/26 0026
 * @Time: 15:20
 */
@Repository
public interface UserMapper {
	User selectAccid(String accid);//查询用户名
	
	User selectId(int id);//查询用户id
	
	List<User> selectUsername(String username);//查询用户昵称

	void insert(User user);

	void updateUser(User user);
      
}