package com.actitime.utilities;

import org.testng.Assert;

public class ValidationOperation {
	
	public static boolean validateTestScript(String exp,String act)
	{
	  try {
		  Assert.assertEquals(exp,act);
		  return true;
	  }
	  catch(AssertionError rv)
	  {
		  return false;
	  }
		
	}

}
