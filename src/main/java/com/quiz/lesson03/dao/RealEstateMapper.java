package com.quiz.lesson03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Repository
public interface RealEstateMapper {
	
	public RealEstate selectRealEstateById(@Param("id") int id);
	
	public List<RealEstate> selectRealEstateByRentPrice(@Param("rent_price") Integer rent_price);
	
	public List<RealEstate> selectRealEstateByAreaAndPrice(@Param("area") int area, @Param("price") int price);
}
