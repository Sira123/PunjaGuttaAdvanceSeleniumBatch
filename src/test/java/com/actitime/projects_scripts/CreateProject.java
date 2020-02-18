package com.actitime.projects_scripts;

import org.testng.annotations.Test;

import com.actitime.webpages.ActiveProjectsAndCustomersPage;
import com.actitime.webpages.AddNewProjectPage;
import com.actitime.webpages.OpenTasksPage;

public class CreateProject extends com.actitime.utilities.BaseClass{

	@Test
	public void testCreateProject()
	{
		OpenTasksPage otp=new OpenTasksPage();
		otp.ClickProjectsAndCustomersLink();
		log.info("Projects and customers link opened.....");
		ActiveProjectsAndCustomersPage apcp=new ActiveProjectsAndCustomersPage();
		apcp.AddNewProjectButton();
		log.info("clicked on add new customer button.....");
		AddNewProjectPage anpp=new AddNewProjectPage();
		anpp.CustomerDropdown("shashank");
		log.info("Customername selected from dropdown");
		anpp.ProjectNameTextfield("Autmation132165tttt");
		log.info("CustomerProject details entered");
		anpp.CreateProjectButton();
		log.info("..Project created successfully......");
}
}