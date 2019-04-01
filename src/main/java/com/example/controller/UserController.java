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
}

