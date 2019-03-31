package com.example.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.service.UserService;
import com.example.utils.ResultData;
import com.example.utils.StringUtils;
import com.example.utils.TimeUtil;
import com.example.entity.User;

import com.example.mapper.UserMapper;

@Service
public class UserServiceimpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	
	//@Resource
	//private FriendMapper friendMapper;

	@Override//检查用户名是否存在
	public ResultData<User> checkUsername(String username) throws Exception {
		ResultData<User> resultData = new ResultData<>();
		List<User> user = getUserUsername(username);
		if (user == null||user.size()==0) {
			resultData.setCode(0);
			resultData.setMsg("用户名不存在");
		} else {
			resultData.setCode(1);
			resultData.setMsg("用户名已存在");
		}
		return resultData;
	}
	
	@Override//检查用户是否注册
	public Boolean isAlreadyRegistered(String accid) {
		User user =getUserAccid(accid);
		if(user==null) {
			return false;
		}
		else
			return true;
	}
	
	public ResultData<User> register(String accid, String username,
			String password) throws Exception {
		ResultData<User> resultData = new ResultData<>();
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			resultData.setCode(-100);
			resultData.setMsg("请求参数不能为空");
			resultData.setSuccess(false);
			return resultData;
		}
		
		List<User> haveuser = getUserUsername(username);
		if (haveuser != null) {
			// 用户名已经存在
			resultData.setCode(0);
			resultData.setMsg("用户名已经存在");
			resultData.setSuccess(false);
			return resultData;
		}
		
		User user = new User();
		//user.setHomeid(homeid);
		//user.setPhone(phone);
		user.setPassword(password);
		user.setUsername(username);
		user.setAccid(accid);
		//user.setToken(password);
		//user.setUserPhoto(userphoto);
		//user.setSex(sex);
		//user.setBirthday(birthday);
		//user.setAddress(address);
		//user.setSignDesc(describe);
		//user.setCreateTime(TimeUtil.getCurrentTimeString());
		userMapper.insert(user);// 插入到数据库
		
		resultData.setData(user);
		resultData.setCode(1);
		resultData.setMsg("注册成功");
		resultData.setSuccess(true);
		return resultData;
		
	}
	 
	private User getUserAccid(String accid) {//获取用户id
		User user=new User();
		user=userMapper.selectAccid(accid);
		return user;
	}
	
	private List<User> getUserUsername(String username) {//获取用户名列表
		List<User> user=userMapper.selectUsername(username);
		return user;
	}
}
