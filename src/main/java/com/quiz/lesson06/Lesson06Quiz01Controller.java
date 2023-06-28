package com.quiz.lesson06;

import java.util.List;

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

	@GetMapping("/add_sites_view")
	public String addSitesView() {
		return "lesson06/addSites";
	}
	
	@PostMapping("/add_sites")
	@ResponseBody
	public String addSites(
			@RequestParam("subject") String subject,
			@RequestParam("address") String address) {
		// db insert
		sitesBO.addSites(subject, address);
		
		// return string
		return "추가 성공!!!";
	}
	
	@GetMapping("/after_add_sites_view")
	public String afterAddSitesView(Model model) {
		// select DB
		List<Sites> sitesList = sitesBO.getSites();
		model.addAttribute(sitesList);
		
		return "lesson06/afterAddSites";
	}
}