package com.example.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Comment;
import com.example.entity.Post;
import com.example.service.CommentService;
import com.example.service.PostService;
import com.example.utils.ImgUtil;
import com.example.utils.ResultData;
import com.example.utils.TimeUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



@Controller
@RequestMapping(value="/comment",produces="text/plain;charset=UTF-8")
public class CommentController {
	
	@Resource
	private CommentService commentService;
	@Resource
	private PostService postService;

	/***
	 * 评论查询
	 */
	@RequestMapping(value = "getComments", produces = { "application/json;charset=UTF-8" },
			method = RequestMethod.POST)
	@ResponseBody
	public ResultData<List<Comment>> getComments(
			@RequestParam(value = "postid", required = true) Integer postid,
			@RequestParam(value = "page", required = true) Integer page,
			@RequestParam(value = "num", required = true) Integer num
			) throws Exception {
		ResultData<List<Comment>> resultData = new ResultData<>();
		resultData = commentService.selectComments(page, 10, postid);
		resultData.setCode(200);
		resultData.setMsg("查询成功");
		return resultData;
		
	}
	
	/***
	 * 添加评论
	 */
	@RequestMapping(value = "/createComment", produces = { "application/json;charset=UTF-8" }, method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Comment> createComment(
			@RequestParam(value = "userid", required = false) Integer userid,
			@RequestParam(value = "accid", required = true) String accid,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "userphoto", required = true) String userphoto,
			@RequestParam(value = "content", required = true) String content,
			@RequestParam(value = "postid", required = true) Integer postid,
			@RequestParam(value = "floor", required = true) Integer floor,
			HttpServletRequest request,
			@RequestParam(value="img",required = false)List<MultipartFile> img
			) throws Exception {
        Comment comment = new Comment();
        
        System.out.println("content----"+content);
        
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
			System.out.println("图片路径"+jsonArray.toString());
			comment.setContentImg(jsonArray.toString());
		}
        
      //更新评论数
        Post post = postService.selectByPrimaryKey(postid);
        System.out.println(post);
        String commentNumber = post.getCommentNum() ;
        int insertCommentNum = Integer.parseInt(commentNumber) +1;
        post.setCommentNum(insertCommentNum+"");
        postService.update(post);
        
        comment.setUserid(userid);
        comment.setAccid(accid);
        comment.setUsername(username);
        comment.setUserphoto(userphoto);
        comment.setContent(content);
        comment.setPostid(postid);
        comment.setFloor(insertCommentNum);
        comment.setCreateTime(TimeUtil.getCurrentTimeString());
		
		commentService.insert(comment);
		Comment returnComment = commentService.selectByPrimaryKey(comment.getCommentid());
		
		ResultData<Comment> resultData = new ResultData<>();
		resultData.setData(returnComment);
		resultData.setCode(200);
		resultData.setMsg("评论成功");
		return resultData;
	}

	/**
	 *删除评论
	 */
	@RequestMapping(value = "/deleteComment", produces = { "application/json;charset=UTF-8" }, method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Comment> createComment(
			@RequestParam(value = "commentid", required = true) Integer commentid,
			@RequestParam(value = "postid", required = true) Integer postid
			){
		ResultData<Comment> resultData=new ResultData<>();
		Comment resultcomment=commentService.selectByPrimaryKey(commentid);
		commentService.delete(commentid);
		
		Post post = postService.selectByPrimaryKey(postid);
        //System.out.println(post);
        String commentNumber = post.getCommentNum() ;
        int insertCommentNum = Integer.parseInt(commentNumber) -1;
        post.setCommentNum(insertCommentNum+"");
        postService.update(post);
		
		
		resultData.setData(resultcomment);
		resultData.setMsg("删除成功");
		resultData.setCode(1);
		resultData.setSuccess(true);
		return resultData;
	}
}
