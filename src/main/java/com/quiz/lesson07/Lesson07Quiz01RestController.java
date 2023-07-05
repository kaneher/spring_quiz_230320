package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.CompanyBO;
import com.quiz.lesson07.entity.CompanyEntity;

@RestController
@RequestMapping("/lesson07/quiz01")
public class Lesson07Quiz01RestController {
	
	@Autowired
	private CompanyBO companyBO;
	// CRUD
	
	// C : Create
	@GetMapping("/save1")
	public CompanyEntity create1() {
		String name = "넥손";
		String business = "컨텐츠 게임";
		String scale = "대기업";
		int headcount = 3585;
		
		CompanyEntity company = companyBO.addCompany(name, business, scale, headcount);
		return company;
	}
	
	@GetMapping("/save2")
	public CompanyEntity create2() {
		String name = "버블팡";
		String business = "여신 금융업";
		String scale = "대기업";
		int headcount = 6834;
		
		CompanyEntity company = companyBO.addCompany(name, business, scale, headcount);
		return company;
	}
	
	// U : Update
	@GetMapping("/update")
	public CompanyEntity update() {
		// id : 8, scale : 중소기업, headcount : 34명
		return companyBO.updateCompanyById(8, "중소기업", 34);
	}
	
	// D : Delete
	@GetMapping("/delete")
	public String delete() {
		// id : 8
		companyBO.deleteCompanyById(8);
		return "수행 완료";
	}
}
