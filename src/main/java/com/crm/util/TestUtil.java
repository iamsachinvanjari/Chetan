package com.crm.util;

import com.crm.base.TestBase;

public class TestUtil extends TestBase{

	public static int implicit_Timeout = 20;
	
	public  void movetoFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
}
