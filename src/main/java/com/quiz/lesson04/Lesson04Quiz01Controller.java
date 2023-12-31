package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	
	@Autowired
	private SellerBO sellerBO;
	
	// view 판매자 추가 페이지
	@RequestMapping(path = "/add_seller_view", method = RequestMethod.GET)
	public String addSellerView() {
		// /WEB-INF/jsp/          .jsp
		return "lesson04/addSeller";
	}
	
	// 추가 action      input태그에 아무것도 입력하지 않았으면 null이 아니라 ""로 들어온다
	@RequestMapping(path = "/add_seller", method = RequestMethod.POST)
	public String addSeller(
			@RequestParam(value = "nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam(value = "temperature") double temperature
			) {
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		return "lesson04/afterAddSeller";
	}
	
	// 최근 가입자 정보 페이지
	@GetMapping("/seller_info")
	public String sellerInfoView(
			@RequestParam(value = "id", required = false) Integer id,
			Model model
			) {
		
		Seller seller = null;
		
		if (id != null) {
			seller = sellerBO.getSellerInfoById(id);
		} else {
			seller = sellerBO.getLatestSellerInfo();
		}
		
		model.addAttribute("result", seller);
		model.addAttribute("title", "가입자 정보");
		return "lesson04/getSellerInfo";
	}
}
