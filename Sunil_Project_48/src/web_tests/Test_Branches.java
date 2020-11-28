package web_tests;


import org.testng.annotations.Test;

import keywords.Repository;
import web_pages.RanfordHome;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.lang.reflect.Method;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class Test_Branches
{
	
	WebDriver driver;
	String Driver_Path="Drivers\\chromedriver.exe";
	String screen_path="C:\\Users\\SUNIL\\git\\Sunil_Project_48\\Sunil_Project_48\\screens\\";
	
	RanfordHome RHP;
	Repository user_action;
	

	@Test(priority=0)
	public void Tc001_Admin_login_Invalid_Password()
	{
		RHP=new RanfordHome(driver);
		Assert.assertTrue(RHP.Is_Ranford_Homepage_Opened());
		RHP.Type_Admin_Banker_username(RHP.Username);
		RHP.Type_Admin_Banker_password(RHP.password);
		RHP.Click_login_btn();
		
		Assert.assertTrue(RHP.is_AlertPresent());
		RHP.close_Alert();
		
	}
	
	
	@Test(priority=1)
	public void Tc001_Admin_login_Invalid_Username()
	{
		RHP=new RanfordHome(driver);
		Assert.assertTrue(RHP.Is_Ranford_Homepage_Opened());
		RHP.Type_Admin_Banker_username("dfjfj");
		RHP.Type_Admin_Banker_password("M1ndq");
		RHP.Click_login_btn();
		
		Assert.assertTrue(RHP.is_AlertPresent());
		RHP.close_Alert();
	}
	

  @AfterMethod//Invoke every @Test annotation after.
  public void afterMethod(Method method) throws Exception 
  {
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileHandler.copy(src, new File(screen_path+method.getName()+".png"));
  }

  @BeforeClass//Invoke once before execution of all @Test annotations
  public void beforeClass() 
  {
	  System.setProperty("webdriver.chrome.driver", Driver_Path);
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();  
	  
  }

  @AfterClass //Invoke once after execution of all @Test annotations
  public void afterClass() throws Exception 
  {
	  Thread.sleep(10000);
	  driver.close();
  }

}
