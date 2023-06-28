package com.quiz.lesson06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.domain.Sites;

@Repository
public interface SitesMapper {
	public void insertSites(
			@Param("subject") String subject,
			@Param("address") String address);
	
	public List<Sites> selectSites();
}
