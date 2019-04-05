package com.example.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Ad;
import com.example.mapper.AdMapper;
import com.example.utils.ResultData;

/**
 * 轮播广告
 * @author zrs
 *
 */
@Controller
@RequestMapping(value="ad",produces="text/plain;charset=UTF-8")
public class AdController {

	@Resource
	private AdMapper adMapper;

	/***
	 * 获取广告列表
	 */
	@RequestMapping(value = "getAds", produces = { "application/json;charset=UTF-8" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<Ad>> getAds() throws Exception {
		int []ad=new int[4];
		ad[0]=1;ad[1]=2;ad[2]=3;ad[3]=4;
		List<Ad> ads = adMapper.selectAds(ad);
		ResultData<List<Ad>> resultData = new ResultData<>();
		resultData.setData(ads);
		resultData.setCode(200);
		resultData.setMsg("请求成功");
		return resultData;
	}
	
}
