package com.actitime.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.BaseClass;


public class AddNewCustomerPage {
	@FindBy(name="name")
	private WebElement CustomerNameTextField;
	
	@FindBy(name="createCustomerSubmit")
	private WebElement CreateCustomerButton;
	
	public AddNewCustomerPage(){
		PageFactory.initElements(BaseClass.driver, this);
	}
	public void EnterCustomerName(String customername) {
		CustomerNameTextField.sendKeys(customername);
	}
	public void clickOnCreateCustomerButton() {
		CreateCustomerButton.click();
	}

}
