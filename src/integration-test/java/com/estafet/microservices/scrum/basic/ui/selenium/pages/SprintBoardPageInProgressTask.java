package com.estafet.microservices.scrum.basic.ui.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SprintBoardPageInProgressTask {

	WebElement task;
	WebDriver driver;

	public SprintBoardPageInProgressTask(WebElement task, WebDriver driver) {
		this.task = task;
		this.driver = driver;
	}
		
	public SprintBoardPage complete() {
		return null;
	}
	
	public UpdateTaskHoursPage updateHours() {
		task.findElement(By.xpath(".//a")).click();
		return new UpdateTaskHoursPage(driver);
	}
	
	public String hours() {
		return task.findElement(By.xpath(".//a")).getText().trim().replaceAll("\\[", "").replaceAll("\\]", "");
	}
	
	public String name() {
		return task.findElement(By.xpath(".//span")).getText();
	}
}