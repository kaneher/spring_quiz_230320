package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.dao.StoreMapper;
import com.quiz.lesson02.domain.Store;

@Service
public class StoreBO {
	
	// 필드
	@Autowired
	private StoreMapper storeMapper; // Spring bean을 주입받는다. DI(=Dependency Injection)
	
	// input : X
	// output : storeList => 컨트롤러한테 돌려준다.
	public List<Store> getStoreList() {
		List<Store> storeList = storeMapper.selectStoreList();
		return storeList;
	}
}
