package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@Controller
@RequestMapping("/lesson04/quiz02")
public class Lesson04Quiz02Controller {

	@Autowired
	private RealtorBO realtorBO;
	
	// view
	@GetMapping("/add_realtor_view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	@PostMapping("/add_realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor,
			Model model
			) {
		// insert DB
		realtorBO.addRealtor(realtor);
		// realtor.getId();
		
		// select DB
		Realtor latestRealtor = realtorBO.getRealtorById(realtor.getId());
		model.addAttribute("result", latestRealtor);
		
		return "lesson04/afterAddRealtor";
	}
}
