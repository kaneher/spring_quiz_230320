package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.dao.SitesMapper;
import com.quiz.lesson06.domain.Sites;

@Service
public class SitesBO {
	@Autowired
	private SitesMapper sitesMapper;
	
	public void addSites(String subject, String address) {
		sitesMapper.insertSites(subject, address);
	}
	
	public List<Sites> getSites() {
		return sitesMapper.selectSites();
	}
}
