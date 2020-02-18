package com.actitime.webpages;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.actitime.utilities.BaseClass;

public class AddNewProjectPage {
	
	@FindBy(name="customerId")
	private WebElement CustomerDropdown;
	
	@FindBy(name="name")
	private WebElement ProjectNameTextfield;
	
	@FindBy(name="createProjectSubmit")
	private WebElement CreateProjectButton;
	
	public AddNewProjectPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void CustomerDropdown(String dd1)
	{
		Select s1=new Select(CustomerDropdown);
		s1.selectByVisibleText(dd1);
	}
	
	public void ProjectNameTextfield(String text)
	{
		ProjectNameTextfield.sendKeys(text);
	}
	
	public void CreateProjectButton()
	{
		CreateProjectButton.click();
	}
}
