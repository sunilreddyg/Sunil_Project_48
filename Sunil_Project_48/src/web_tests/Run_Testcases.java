package web_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import web_pages.RanfordHome;

public class Run_Testcases 
{

	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.chrome.driver", "Drivers\\ChromeDriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
		
		RanfordHome RFH=new RanfordHome(driver);
		if(RFH.Is_Ranford_Homepage_Opened())
		{
			System.out.println("title verified");
			RFH.Enter_Admin_Banker_Login("Admin", "M1ndq");
		}
		else
			System.out.println("title mismatch");

	}

}
