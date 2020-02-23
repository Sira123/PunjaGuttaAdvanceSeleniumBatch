package com.actitime.utilities;

import org.testng.Assert;

public class ValidationOperation {
	
	public static String validateTestScript(String exp,String act)
	{
	  try {
		  Assert.assertEquals(exp,act);
		  return "pass";
	  }
	  catch(AssertionError rv)
	  {
		  return "fail";
	  }
		
	}

}
