package com.example.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Remark;
import com.example.service.RemarkService;
import com.example.utils.ResultData;
import com.example.utils.TimeUtil;

@Controller
@RequestMapping(value="remark",produces="text/plain;charset=UTF-8")
public class RemarkController {

	@Resource
	private RemarkService remarkService;

	/***
	 * 创建评论
	 */
	@RequestMapping(value = "/createRemark", produces = { "application/json;charset=UTF-8" },
			method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Remark> createPost(
			@RequestParam(value = "accid", required = true) String accid,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "userphoto", required = true) String userphoto,
			@RequestParam(value = "content", required = true) String content,
			@RequestParam(value = "currentPosition", required = false) String currentPosition,
			@RequestParam(value = "forumId", required = true) Integer forumId,
			@RequestParam(value = "star", required = true) Integer star
			) throws Exception {
		
		Remark remark = new Remark();
		
		remark.setAccid(accid);
		remark.setUsername(username);
		remark.setUserphoto(userphoto);
		remark.setStar(star);
		remark.setContent(content);
		remark.setCurrentPosition(currentPosition);
		remark.setCreateTime(TimeUtil.getCurrentTimeString());
		remark.setForumId(forumId);
		
		
		remarkService.insert(remark);
		int remarkid = remark.getId();
		Remark returnremark = remarkService.selectByPrimaryKey(remarkid);
		
		ResultData<Remark> resultData = new ResultData<>();
		resultData.setData(returnremark);
		resultData.setCode(200);
		resultData.setMsg("插入成功");
		System.out.println("返回数据:"+resultData.toString());
		return resultData;
	}
	
	/***
	 * 返回帖子
	 */
	@RequestMapping(value = "getRemarks", produces = { "application/json;charset=UTF-8" },
			method = RequestMethod.POST)
	@ResponseBody
	public ResultData<List<Remark>> getRemarks(
			@RequestParam(value = "forumid", required = true) Integer forumid,//乡吧id
			@RequestParam(value = "page", required = true) Integer page,//当前页数
			@RequestParam(value = "num", required = true) Integer num//每页记录数
			) throws Exception {
		
		ResultData<List<Remark>> resultData = new ResultData<>();
		resultData = remarkService.selectRemarks(page, 10, forumid);
		resultData.setCode(200);
		resultData.setMsg("查询成功");
		resultData.setSuccess(true);
		return resultData;
	}
	
	
	/***
	 * 根据id查询评论
	 */
	@RequestMapping(value = "getRemarkById", produces = { "application/json;charset=UTF-8" },
			method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Remark> getPostById(
			@RequestParam(value = "id", required = true) Integer id
			) throws Exception {
		
		ResultData<Remark> resultData = new ResultData<>();
		Remark remark = remarkService.selectByPrimaryKey(id);
		resultData.setData(remark);
		resultData.setCode(200);
		resultData.setMsg("查询成功");
		return resultData;
	}
	
	//更新帖子
	@RequestMapping(value = "updateRemark", produces = { "application/json;charset=UTF-8" },
			method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Remark> updatePost(
			@RequestParam(value = "id", required = true) Integer id,
			@RequestParam(value = "content", required = true) String content,
			@RequestParam(value = "currentPosition", required = false) String currentPosition,
			@RequestParam(value = "woundful", required = true) Integer woundful,
			@RequestParam(value = "star", required = true) Integer star,
			@RequestParam(value = "stamp", required = true) Integer stamp
			) throws Exception {
		
		Remark remark = new Remark();
		remark=remarkService.selectByPrimaryKey(id);
		
		remark.setContent(content);
		remark.setWoundful(woundful);
		remark.setStamp(stamp);
		remark.setStar(star);
		remark.setCurrentPosition(currentPosition);
		remark.setCreateTime(TimeUtil.getCurrentTimeString());		
		
		remarkService.update(remark);
		Remark returnremark = remarkService.selectByPrimaryKey(id);
		
		ResultData<Remark> resultData = new ResultData<>();
		resultData.setData(returnremark);
		resultData.setCode(200);
		resultData.setMsg("更新成功");
		System.out.println("返回数据:"+resultData.toString());
		return resultData;		
	}
	
	//删除帖子
	@RequestMapping(value = "deleteRemark", produces = { "application/json;charset=UTF-8" },
			method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Remark> deletePost(
			@RequestParam(value = "id", required = true) Integer id
			){
		ResultData<Remark> resultData=new ResultData<>();
		Remark remark=remarkService.selectByPrimaryKey(id);
		remarkService.deleteByPrimaryKey(id);	
		resultData.setData(remark);
		resultData.setCode(1);
		resultData.setMsg("删除成功");
		resultData.setSuccess(true);
		return resultData;
	}
}
