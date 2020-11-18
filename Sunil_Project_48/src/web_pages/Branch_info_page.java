package web_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Branch_info_page 
{

	WebDriver driver;
	public Branch_info_page(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='BtnNewBR']")
	public WebElement New_Branch;
	
	
	
	public boolean Is_Ranford_Branches_Page_Opened(String title)
	{
		String Runtime_title=driver.getTitle();
		boolean flag=Runtime_title.contains(title);
		return flag;
	}
	
	public void Click_on_New_Branch()
	{
		New_Branch.click();
	}
	

}
