package com.actitime.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public static ChromeDriver driver;
	public static Logger log;
	
	
	@BeforeTest
	public void OpenBrowser() throws IOException {
		log=log.getLogger(BaseClass.class);
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
	driver=new ChromeDriver();
	log.info("Browser opened...........");
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/App.properties");
	Properties p1=new Properties();
	p1.load(fis);
	driver.get(p1.getProperty("url"));
	log.info("url entered successfully.....");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	log.info("Browser maximized...");
	}

    @AfterTest
    public void CloseBrowser() {
    	driver.close();
    	log.info("Browser Closed...");
    	
    }
    @BeforeClass
    public void Login() throws IOException {
    	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/App.properties");
    	Properties p1=new Properties();
    	p1.load(fis);
    driver.findElement(By.name("username")).sendKeys(p1.getProperty("username"));
    log.info("User name entered Successfully......");
    driver.findElement(By.name("pwd")).sendKeys(p1.getProperty("password"));
    log.info("Password entered successfully......");
    driver.findElement(By.xpath("//input[@type='submit']")).click();
    log.info("Login button clicked...");
}
    @AfterClass
    public void Logout() {
    	driver.findElement(By.className("logoutImg")).click();
    	log.info("logged out successfully.....");
    }

}
