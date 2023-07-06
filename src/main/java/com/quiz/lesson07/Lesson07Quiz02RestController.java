package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.dao.RecruitRepository;
import com.quiz.lesson07.entity.RecruitEntity;

@RestController
@RequestMapping("/lesson07/quiz02")
public class Lesson07Quiz02RestController {

	//!!! 프로젝트 전까지만 BO 생략
	@Autowired
	private RecruitRepository recruitRepository;
	
	@GetMapping("/1")
	public List<RecruitEntity> getRecruitList(
//			@RequestParam("companyId") int companyId
			){
		// 1번
//		return recruitRepository.findById(8);
		
		// 2번
//		return recruitRepository.findByCompanyId(companyId);
		
		// 3번
//		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
		
		// 4번
//		return recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
		
		// 5번
//		return recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
		
		// 6번
//		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
		
		// 7번
		return recruitRepository.findByDeadlineAfterAndSalaryAndTypeOrderBySalaryDesc("2026-04-10", 8100, "정규직");
	}
}
