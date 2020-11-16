package web_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class New_Brnach_Creation 
{	
	WebDriver driver;

	public New_Brnach_Creation(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
