package com.example.mapper;

import java.util.List;

import com.example.entity.Remark;
import com.example.pojo.RemarkCustom;

public interface RemarkCustomMapper {
	List<Remark> selectRemarkpage(RemarkCustom custom) throws Exception;
}
