package banker_testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Rrun_Banker_Testcase extends Banker_Tests
{
	  

	  public Rrun_Banker_Testcase(WebDriver driver) 
	  {
		super(driver);
		// TODO Auto-generated constructor stub
	  }

	  String Driver_Path="Drivers\\chromedriver.exe";
	  String screen_path="C:\\Users\\SUNIL\\git\\Sunil_Project_48\\Sunil_Project_48\\screens\\";
	  String property_file_path="C:\\Users\\SUNIL\\git\\Sunil_Project_48\\Sunil_Project_48\\src\\banker_testcase\\banker_input.properties";
	  FileInputStream fi;
	  Properties properties;
	  WebDriver driver;
	  Banker_Tests banker;

	  @Test
	  public void Login_As_Banker()
	  {
		  String Banker_page_url=properties.getProperty("banker_page_url");
		  String BranchName=properties.getProperty("BrnachName");
		  String Banker_Name=properties.getProperty("BankerName");
		  String Banker_pwd=properties.getProperty("BankerPwd");
		  String exp_banker_page_title=properties.getProperty("banker_page_title");
		  
		  driver.get(Banker_page_url);
		  banker=new Banker_Tests(driver);
		  banker.banker_login(BranchName, Banker_Name, Banker_pwd, exp_banker_page_title);
		
	  }
	  
	  
	 
	
	
	  @AfterMethod//Invoke every @Test annotation after.
	  public void afterMethod(Method method) throws Exception 
	  {
		  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(src, new File(screen_path+method.getName()+".png"));
	  }

	  @BeforeClass//Invoke once before execution of all @Test annotations
	  public void beforeClass() throws IOException 
	  {
		  System.setProperty("webdriver.chrome.driver", Driver_Path);
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();  
		  
		  fi=new FileInputStream(property_file_path);
		  properties=new Properties();
		  properties.load(fi);
		 	 
	  }

	  @AfterClass //Invoke once after execution of all @Test annotations
	  public void afterClass() throws Exception 
	  {
		  Thread.sleep(10000);
		  driver.close();
	  }

}
