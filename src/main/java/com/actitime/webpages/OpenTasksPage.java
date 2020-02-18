package com.actitime.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.BaseClass;


public class OpenTasksPage {
	@FindBy(linkText="Projects & Customers")
	private WebElement ProjectsAndCustomersLink;
	
	@FindBy(xpath="//input[@value='Add New Tasks']")
	private WebElement AddNewTasksButton;
	
	public OpenTasksPage() {
		PageFactory.initElements(BaseClass.driver,this);
	}
	public void ClickProjectsAndCustomersLink()
	{
		ProjectsAndCustomersLink.click();
	}
	public void AddNewTasksButton()
	{
		AddNewTasksButton.click();
	}
}
