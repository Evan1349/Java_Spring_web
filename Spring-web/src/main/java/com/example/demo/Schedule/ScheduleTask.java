package com.example.demo.Schedule;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {
	
	@Value("${fixedRate}")
	private Long fixedRate;
	
	@Scheduled(fixedRateString = "${fixedRate}")
	public void task1() {
		System.out.println("Task done! Good job!");
	}
}
