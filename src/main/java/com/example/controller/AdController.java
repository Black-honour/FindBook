package com.example.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Ad;
import com.example.mapper.AdMapper;
import com.example.utils.ImgUtil;
import com.example.utils.ResultData;
import com.example.utils.TimeUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
	@RequestMapping(value = "getAds", produces = { "application/json;charset=UTF-8" }, 
			method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<Ad>> getAds() throws Exception {
		List<Ad> ads = adMapper.selectAds();
		ResultData<List<Ad>> resultData = new ResultData<>();
		resultData.setData(ads);
		resultData.setCode(200);
		resultData.setMsg("请求成功");
		return resultData;
	}
	
	/**
	 * 插入广告
	 */
	@RequestMapping(value = "/insertAd", produces = { "application/json;charset=UTF-8" }, 
			method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Ad> insertAd(
			@RequestParam(value = "img", required = true) String img,
			@RequestParam(value = "url", required = true) String url,
			HttpServletRequest request,
			@RequestParam(value="timg",required = false)List<MultipartFile> timg
			) throws Exception{
		System.out.println(img);
		System.out.println(url);
		Ad ad =new Ad();
		if(timg != null){
			String path = "";
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject;
			int i = 1;
			for(MultipartFile f : timg){
				jsonObject = new JSONObject();
				jsonObject.put("id", i);
				path = ImgUtil.saveImgInUserFolder(request, f, f.getOriginalFilename(), 
						"/upload/img/"+TimeUtil.getWeeksOneDate());
				jsonObject.put("path", path);
				jsonArray.add(jsonObject);
				i++;
			}
			ad.setImg(jsonArray.toString());
		}
		ad.setUrl(url);
		
		System.out.println(ad);
		adMapper.insert(ad);
		Ad resultAd=adMapper.select(ad.getId());
		
		ResultData<Ad> resultData = new ResultData<>();
		resultData.setData(resultAd);
		resultData.setCode(200);
		resultData.setMsg("插入成功");
		System.out.println("返回数据:"+resultData.toString());
		return resultData;
	}
	
	
	/**
	 * 删除广告
	 */
	@RequestMapping(value = "deleteAd", produces = { "application/json;charset=UTF-8" }, 
			method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Ad> deleteAd(
			@RequestParam(value = "id", required = true) Integer id
			) throws Exception{
		Ad ad =adMapper.select(id);
		adMapper.delete(id);
		
		ResultData<Ad> resultData = new ResultData<>();
		resultData.setData(ad);
		resultData.setCode(200);
		resultData.setMsg("删除成功");
		System.out.println("返回数据:"+resultData.toString());
		return resultData;
	}
	
	/**
	 * 更新广告
	 */
	@RequestMapping(value = "updateAd", produces = { "application/json;charset=UTF-8" }, 
			method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Ad> updateAd(
			@RequestParam(value = "id", required = true) Integer id,
			@RequestParam(value = "img", required = true) String img,
			@RequestParam(value = "url", required = true) String url,
			HttpServletRequest request,
			@RequestParam(value="timg",required = false)List<MultipartFile> timg
			) throws Exception{
		Ad ad =new Ad();
		if(timg != null){
			String path = "";
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject;
			int i = 1;
			for(MultipartFile f : timg){
				jsonObject = new JSONObject();
				jsonObject.put("id", i);
				path = ImgUtil.saveImgInUserFolder(request, f, f.getOriginalFilename(), 
						"/upload/img/"+TimeUtil.getWeeksOneDate());
				jsonObject.put("path", path);
				jsonArray.add(jsonObject);
				i++;
			}
			ad.setImg(jsonArray.toString());
		}
		
		ad.setId(id);
		ad.setUrl(url);
		
		adMapper.update(ad);
		
		ResultData<Ad> resultData = new ResultData<>();
		resultData.setData(ad);
		resultData.setCode(200);
		resultData.setMsg("更新成功");
		System.out.println("返回数据:"+resultData.toString());
		return resultData;
	}
	
}
