package com.quiz.weather;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.weather.bo.WeatherHistoryBO;
import com.quiz.weather.domain.WeatherHistory;

@Controller
@RequestMapping("/weather")
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	@GetMapping("/weather_history_view")
	public String weatherHistoryView(Model model) {
		List<WeatherHistory> weatherHistory = weatherHistoryBO.getWeatherHistory();
		model.addAttribute("weatherHistory", weatherHistory);
		return "weather/weatherHistory";
	}

}