package web_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHome 
{
	
	WebDriver driver;

	public AdminHome(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='images/Branches_but.jpg']")
	public WebElement Branches_btn;
	
	
	
	
	public void click_branches_btn()
	{
		Branches_btn.click();
	}
	
	
	

}
