package com.quiz.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson02.domain.Store;

@Repository
public interface StoreMapper {
	
	// input : X
	// output : List<Store> BO(Service) 한테 돌려준다.
	public List<Store> selectStoreList();
}
