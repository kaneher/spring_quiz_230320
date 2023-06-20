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
	
	// view
	@RequestMapping(path = "/add_seller_view", method = RequestMethod.GET)
	public String addSellerView() {
		// /WEB-INF/jsp/          .jsp
		return "lesson04/addSeller";
	}
	
	@RequestMapping(path = "/add_seller", method = RequestMethod.POST)
	public String addSeller(
			@RequestParam(value = "nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam(value = "temperature", required = false) String temperature) {
		
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		return "lesson04/afterAddSeller";
	}
	
	@GetMapping("/seller_info")
	public String sellerInfoView(Model model,
			@RequestParam(value = "id", required = false) Integer id) {
		if (id != null) {
			Seller seller = sellerBO.getSellerInfo(id);
			model.addAttribute("result", seller);
			model.addAttribute("title", "판매자 정보");
			return "lesson04/getSellerInfo";
		} else {
			Seller seller = sellerBO.getLatestSellerInfo();
			model.addAttribute("result", seller);
			model.addAttribute("title", "판매자 정보");
			return "lesson04/getSellerInfo";
		}
	}
}
