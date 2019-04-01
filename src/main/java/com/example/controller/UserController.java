package com.example.controller;

import com.example.entity.User;

import com.example.service.UserService;
import com.example.service.impl.UserServiceimpl;
import com.example.utils.ImgUtil;
import com.example.utils.ResultData;
import com.example.utils.TimeUtil;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
 
/**
 * @Author:zrs
 * @Date: 2019/3/31
 * @Time: 15：13
 */
 
@RestController
@RequestMapping("/user")
public class UserController {
 
    @Autowired
    private UserService userService;
    
    //注册书荒号
    @ResponseBody
    @RequestMapping(value="/register", method = RequestMethod.POST) 
    ResultData<User> register(
    		@RequestParam(value = "accid", required = true) String accid,
    		@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password
			) {
		
		ResultData<User> resultData = new ResultData<>();
		
		//先判断书荒号是否已经被注册
		if(userService.isAlreadyRegistered(accid)){
			resultData.setCode(300);
			resultData.setMsg("此书荒号已经被注册");
			resultData.setSuccess(false);
			return resultData;
		}
		try {
			resultData = userService.register( accid,username,password);
		} catch (Exception e) {
			e.printStackTrace();
			//LogUtils.error(e.toString());
			resultData.setCode(-200);
			resultData.setMsg("处理异常");
			resultData.setSuccess(true);
			return resultData;
		}
		return resultData;
	}
    
    //登陆书荒号
    /** 登录 */
	@RequestMapping(value = "login", produces = { "application/json;charset=UTF-8" },
			method = RequestMethod.POST)
	public @ResponseBody
	ResultData<User> login(
			@RequestParam(value = "accid", required = true) String accid,
			@RequestParam(value = "password", required = true) String password
			) {
		ResultData<User> resultData = new ResultData<>();
		try {
			resultData = userService.login(accid, password);
		} catch (Exception e) {
			e.printStackTrace();
			//LogUtils.error(e.toString());
			resultData.setCode(-200);
			resultData.setMsg("处理异常");
			System.out.println(resultData);
			return resultData;
		}

		return resultData;
	}
	
	@RequestMapping(value = "update", produces = { "application/json;charset=UTF-8" },
			method = RequestMethod.POST)
	public @ResponseBody
	ResultData<User> updateUser(
			@RequestParam(value = "id", required = true) int id,//用户表中存储id
			@RequestParam(value = "accid", required = true) String accid,//用户名			
			@RequestParam(value = "password", required = true) String password,//密码
			@RequestParam(value = "username", required = false) String username,//用户昵称
			
			@RequestParam(value = "sex", required = false) String sex,//性别
			@RequestParam(value = "birthday", required = false) String birthday,//生日
			@RequestParam(value = "phone", required = false) String phone,//生日
			@RequestParam(value = "province", required = false) String province,//省份
			@RequestParam(value = "city", required = false) String city,//城市
			@RequestParam(value = "signDesc", required = false) String signDesc,//个性签名
			@RequestParam(value = "email", required = false) String email//邮箱
			) {
		ResultData<User> resultData= new ResultData<>();
		try {
			resultData = userService.updateUser(id,accid,password,username,
					sex,birthday,phone,province,city,signDesc,email);
		} catch (Exception e) {
			e.printStackTrace();
			//LogUtils.error(e.toString());
			resultData.setCode(-200);
			resultData.setMsg("处理异常");
			System.out.println(resultData);
			return resultData;
		}
		return resultData;
	}
	
}

