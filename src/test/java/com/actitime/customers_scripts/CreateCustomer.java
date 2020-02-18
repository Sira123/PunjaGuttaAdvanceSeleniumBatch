package com.actitime.customers_scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.actitime.utilities.ExcelOperation;
import com.actitime.webpages.ActiveProjectsAndCustomersPage;
import com.actitime.webpages.AddNewCustomerPage;
import com.actitime.webpages.OpenTasksPage;
 
public class CreateCustomer extends com.actitime.utilities.BaseClass {
	@Test
	public void testCreateCustomer() throws EncryptedDocumentException, InvalidFormatException, IOException {
		String customername=ExcelOperation.readData("Sheet1", 0, 0);
		OpenTasksPage otp=new OpenTasksPage();
		otp.ClickProjectsAndCustomersLink();
		log.info("Projects and customers link opened.....");
		ActiveProjectsAndCustomersPage apcp=new ActiveProjectsAndCustomersPage();
		apcp.AddNewCustomerButton();
		log.info("clicked on add new customer button.....");
		AddNewCustomerPage ancp=new AddNewCustomerPage();
		ancp.EnterCustomerName(customername);
		log.info("Customername entered");
		ancp.clickOnCreateCustomerButton();
		log.info("clicked on create customer button...");
		String s=apcp.RetriveSuccessMsg();
		System.out.print(s);
		log.info(".....Customer created successfully.........");
	}


}
