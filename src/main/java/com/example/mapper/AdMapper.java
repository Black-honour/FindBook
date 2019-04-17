package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.entity.Ad;

public interface AdMapper {

    int delete(Integer id);

    int insert(Ad record);

    Ad select(Integer id);
    
    List<Ad> selectAds();//获取四条广告

    int update(@Param("record") Ad record);
}
