package com.quiz.storeReview;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.storeReview.bo.StoreBO;
import com.quiz.storeReview.domain.Store;

@Controller
@RequestMapping("/storeReview")
public class StoreReviewController {
	
	@Autowired
	private StoreBO storeBO;
	
	@GetMapping("/store_view")
	public String storeView(Model model) {
		
		List<Store> storeList = storeBO.getStore();
		model.addAttribute("storeList", storeList);
		return "storeReview/storeView";
	}
}
