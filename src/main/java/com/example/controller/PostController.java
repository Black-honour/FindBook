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

import com.example.entity.Post;
import com.example.service.PostService;
import com.example.utils.ImgUtil;
import com.example.utils.ResultData;
import com.example.utils.TimeUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="post",produces="text/plain;charset=UTF-8")
public class PostController {

	@Resource
	private PostService postService;

	/***
	 * 创建帖子
	 */
	@RequestMapping(value = "/createPost", produces = { "application/json;charset=UTF-8" },
			method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Post> createPost(
			@RequestParam(value = "accid", required = true) String accid,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "userphoto", required = true) String userphoto,
			@RequestParam(value = "title", required = true) String title,
			@RequestParam(value = "content", required = true) String content,
			@RequestParam(value = "contentImg", required = true) String contentImg,
			@RequestParam(value = "currentPosition", required = true) String currentPosition,
			@RequestParam(value = "forumId", required = true) Integer forumId,
			HttpServletRequest request,
			@RequestParam(value="img",required = false)List<MultipartFile> img
			) throws Exception {
		
		Post post = new Post();
		
		if(img != null){
			String path = "";
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject;
			int i = 1;
			for(MultipartFile f : img){
				jsonObject = new JSONObject();
				jsonObject.put("id", i);
				path = ImgUtil.saveImgInUserFolder(request, f, f.getOriginalFilename(), 
						"/upload/img/"+TimeUtil.getWeeksOneDate());
				jsonObject.put("path", path);
				jsonArray.add(jsonObject);
				i++;
			}
			post.setContentImg(jsonArray.toString());
		}
		post.setAccid(accid);
		post.setUsername(username);
		post.setUserphoto(userphoto);
		post.setTitle(title);
		post.setContent(content);
		post.setCommentNum("0");
		post.setCurrentPosition(currentPosition);
		post.setCreateTime(TimeUtil.getCurrentTimeString());
		post.setForumId(forumId);
		
		
		postService.insert(post);
		int postid = post.getId();
		Post returnpost = postService.selectByPrimaryKey(postid);
		
		ResultData<Post> resultData = new ResultData<>();
		resultData.setData(returnpost);
		resultData.setCode(200);
		resultData.setMsg("插入成功");
		System.out.println("返回数据:"+resultData.toString());
		return resultData;
	}
	
	/***
	 * 返回帖子
	 */
	@RequestMapping(value = "getPosts", produces = { "application/json;charset=UTF-8" },
			method = RequestMethod.POST)
	@ResponseBody
	public ResultData<List<Post>> getPosts(
			@RequestParam(value = "forumid", required = true) Integer forumid,//乡吧id
			@RequestParam(value = "page", required = true) Integer page,//当前页数
			@RequestParam(value = "num", required = true) Integer num//每页记录数
			) throws Exception {
		
		ResultData<List<Post>> resultData = new ResultData<>();
		resultData = postService.selectPosts(page, 10, forumid);
		resultData.setCode(200);
		resultData.setMsg("查询成功");
		resultData.setSuccess(true);
		return resultData;
	}
	
	
	/***
	 * 根据id查询帖子
	 */
	@RequestMapping(value = "getPostById", produces = { "application/json;charset=UTF-8" },
			method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Post> getPostById(
			@RequestParam(value = "id", required = true) Integer id
			) throws Exception {
		
		ResultData<Post> resultData = new ResultData<>();
		Post post = postService.selectByPrimaryKey(id);
		resultData.setData(post);
		resultData.setCode(200);
		resultData.setMsg("查询成功");
		return resultData;
	}
	
	//更新帖子
	@RequestMapping(value = "updatePost", produces = { "application/json;charset=UTF-8" },
			method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Post> updatePost(
			@RequestParam(value = "id", required = true) Integer id,
			@RequestParam(value = "title", required = true) String title,
			@RequestParam(value = "content", required = true) String content,
			@RequestParam(value = "contentImg", required = true) String contentImg,
			@RequestParam(value = "currentPosition", required = true) String currentPosition,
			HttpServletRequest request,
			@RequestParam(value="img",required = false)List<MultipartFile> img
			) throws Exception {
		
		Post post = new Post();
		
		if(img != null){
			String path = "";
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject;
			int i = 1;
			for(MultipartFile f : img){
				jsonObject = new JSONObject();
				jsonObject.put("id", i);
				path = ImgUtil.saveImgInUserFolder(request, f, f.getOriginalFilename(), 
						"/upload/img/"+TimeUtil.getWeeksOneDate());
				jsonObject.put("path", path);
				jsonArray.add(jsonObject);
				i++;
			}
			post.setContentImg(jsonArray.toString());
		}
		post.setTitle(title);
		post.setContent(content);
		post.setCurrentPosition(currentPosition);
		post.setCreateTime(TimeUtil.getCurrentTimeString());
		
		postService.update(post);
		Post returnpost = postService.selectByPrimaryKey(id);
		
		ResultData<Post> resultData = new ResultData<>();
		resultData.setData(returnpost);
		resultData.setCode(200);
		resultData.setMsg("更新成功");
		System.out.println("返回数据:"+resultData.toString());
		return resultData;		
	}
	
	//删除帖子
	@RequestMapping(value = "deletePost", produces = { "application/json;charset=UTF-8" },
			method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Post> deletePost(
			@RequestParam(value = "id", required = true) Integer id
			){
		ResultData<Post> resultData=new ResultData<>();
		postService.deleteByPrimaryKey(id);
		Post post=postService.selectByPrimaryKey(id);
		resultData.setData(post);
		resultData.setCode(1);
		resultData.setMsg("删除成功");
		resultData.setSuccess(true);
		return resultData;
	}
	
}
