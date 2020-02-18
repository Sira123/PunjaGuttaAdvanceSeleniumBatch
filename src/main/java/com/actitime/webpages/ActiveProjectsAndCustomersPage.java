package com.actitime.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.BaseClass;



public class ActiveProjectsAndCustomersPage {
	@FindBy(xpath="//input[@value='Add New Customer']")
	private WebElement AddNewCustomerButton;
	
	@FindBy(xpath="//input[@value='Add New Project']")
	private WebElement AddNewProjectButton;
	
	@FindBy(className="successmsg")
	private WebElement Successmsg;
	
	public ActiveProjectsAndCustomersPage()
	{
		PageFactory.initElements(BaseClass.driver,this);
	}
	
	public void AddNewCustomerButton() {
		AddNewCustomerButton.click();
	}
	
	public void AddNewProjectButton()
	{
		AddNewProjectButton.click();
	}
	public String RetriveSuccessMsg() {
		String s=Successmsg.getText();
		return s;
	}

}
