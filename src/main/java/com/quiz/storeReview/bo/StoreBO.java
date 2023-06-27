package com.quiz.storeReview.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.storeReview.dao.StoreMapper;
import com.quiz.storeReview.domain.Store;

@Service
public class StoreBO {
	
	@Autowired
	private StoreMapper storeMapper;
	
	public List<Store> getStore() {
		return storeMapper.selectStore();
	}

}
