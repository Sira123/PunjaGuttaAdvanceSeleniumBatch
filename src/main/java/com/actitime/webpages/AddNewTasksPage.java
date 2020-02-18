package com.actitime.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.actitime.utilities.BaseClass;

public class AddNewTasksPage {
	
	@FindBy(name="customerId")
	private WebElement SelectCustomerToAddTasksDropdown;
	
	@FindBy(name="projectId")
	private WebElement SelectProjectToAddTasksDropdown;
	@FindBy(name="task[0].name")
	private WebElement TaskNameTextfield;
	@FindBy(xpath="//input[@value='Create Tasks']")
	private WebElement CreateTasksButton;
	
	public AddNewTasksPage()
	{
		PageFactory.initElements(BaseClass.driver, this);
	}
	public void SelectCustomerToAddTasksDropdown(String dd2)
	{
		Select s2=new Select(SelectCustomerToAddTasksDropdown);
		s2.selectByVisibleText(dd2);
	}
	public void SelectProjectToAddTasksDropdown(String dd3)
	{
		Select s3=new Select(SelectProjectToAddTasksDropdown);
		s3.selectByVisibleText(dd3);
	}
	public void TaskNameTextfield(String text)
	{
		TaskNameTextfield.sendKeys(text);
	}
	public void CreateTasksButton()
	{
		CreateTasksButton.click();
	}
}
