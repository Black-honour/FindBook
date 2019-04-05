package com.example.mapper;

import java.util.List;

import com.example.entity.Ad;

public interface AdMapper {

    int delete(Integer id);

    int insert(Ad record);

    Ad select(Integer id);
    
    List<Ad> selectAds(int[] ad);

    int update(Ad record);
}
