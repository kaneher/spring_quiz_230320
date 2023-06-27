package com.quiz.storeReview.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.storeReview.domain.Store;

@Repository
public interface StoreMapper {
	
	public List<Store> selectStore();

}
