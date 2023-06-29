package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.SitesBO;
import com.quiz.lesson06.domain.Sites;

@Controller
@RequestMapping("/lesson06/quiz01")
public class Lesson06Quiz01Controller {
	
	@Autowired
	private SitesBO sitesBO;

	// 문제1 : 즐겨찾기 추가 화면
	@GetMapping("/add_sites_view")
	public String addSitesView() {
		return "lesson06/addSites";
	}
	
	// 문제1 : AJAX의 요청
	@ResponseBody
	@PostMapping("/add_sites")
	public Map<String, Object> addSites(
			@RequestParam("subject") String subject,
			@RequestParam("address") String address) {
		
		// db insert
		sitesBO.addSites(subject, address);
		
		// 응답
		// {"code":1, "result":"성공"}     JSON String
		Map<String, Object> result = new HashMap<>();
		result.put("code", 1);
		result.put("result", "성공");
		
		return result;
	}
	
	// 문제2 : 즐겨찾기 목록 화면
	@GetMapping("/after_add_sites_view")
	public String afterAddSitesView(Model model) {
		// select DB
		List<Sites> sitesList = sitesBO.getSites();
		model.addAttribute(sitesList);
		
		return "lesson06/afterAddSites";
	}
}