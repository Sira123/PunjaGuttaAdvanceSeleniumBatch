package com.actitime.tasks_scripts;

import org.testng.annotations.Test;

import com.actitime.webpages.AddNewTasksPage;
import com.actitime.webpages.OpenTasksPage;

public class CreateTask extends com.actitime.utilities.BaseClass {
	@Test
	public void testCreateTask() {
	OpenTasksPage otp=new OpenTasksPage();
	otp.AddNewTasksButton();
	log.info("Clicked on add new Task button.....");
	AddNewTasksPage antp=new AddNewTasksPage();
	antp.SelectCustomerToAddTasksDropdown("shashank");
	log.info("customer name is selected to add task");
	antp.SelectProjectToAddTasksDropdown("from");
	log.info("Customer project is selected");
	antp.TaskNameTextfield("Testing");
	log.info("Task is assigned to customer");
	antp.CreateTasksButton();
	log.info(".....Task is assigned to the customer.......");
}

}
