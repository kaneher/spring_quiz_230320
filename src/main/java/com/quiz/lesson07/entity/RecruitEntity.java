package com.quiz.lesson07.entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString // toString override 값 예쁘게 출력
@AllArgsConstructor // 모든 필드를 인자값으로 받는 생성자
@NoArgsConstructor // 파라미터 없는 기본 생성자
@Builder(toBuilder = true) // setter 대용
@Getter // getter
@Table(name = "recruit") // 테이블명에 언더바 붙어있을 때 꼭 추가한다.
@Entity(name = "recruit") // 이 클래스는 Entity다
public class RecruitEntity {
	@Id // pk
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	private int id;
	
	@Column(name = "companyId") // 카멜케이스 필드인 경우 반드시 명시
	private int companyId;
	
	private String position;
	
	private String responsibilities;
	
	private String qualification;
	
	private String type;
	
	private String region;
	
	private int salary;
	
	private LocalDate deadline; // 시분초 없음
	
	@UpdateTimestamp // createdAt이 null이면 현재 시간으로 자동으로 입력
	@Column(name = "createdAt", updatable = false) // 카멜케이스 필드인 경우 반드시 명시
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp // updatedAt이 null이면 현재 시간으로 자동으로 입력
	@Column(name = "updatedAt") // 카멜케이스 필드인 경우 반드시 명시
	private ZonedDateTime updatedAt;
}
