package web_pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RanfordHome 
{

	WebDriver driver;
	private String url="http://122.175.8.158/Ranford2/";
	private String title="MINDQ RANFORD BANK";
	
	public RanfordHome(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.get(url);
	}
	
	
	//Input Data
	public String Username="Admin";
	public String password="Admin";
	
	
	
	
	
	@FindBy(xpath="//a[@href='http://ravinderbasani.com']")
	public WebElement Home_btn;
	
	@FindBy(xpath="href=\"personal_banking.html\"")
	public WebElement Personal_banking_btn;
	
	@FindBy(xpath = "//input[@id='txtuId']")
	public WebElement Admin_Banker_username;
	
	@FindBy(xpath="//input[@name='txtPword']")
	public WebElement Admin_Banker_password;
	
	@FindBy(xpath = "//input[@id='login']")
	public WebElement Login_btn;
	
	
	
	public boolean Is_Ranford_Homepage_Opened()
	{
		String Runtime_title=driver.getTitle();
		boolean flag=Runtime_title.contains(title);
		return flag;
	}
	
	
	
	public void Click_on_Home_btn()
	{
		Home_btn.click();
	}
	
	public void Click_on_Personal_banking_btn()
	{
		Personal_banking_btn.click();
	}
	
	public void Type_Admin_Banker_username(String username)
	{
		Admin_Banker_username.clear();
		Admin_Banker_username.sendKeys(username);
	}
	
	public void Type_Admin_Banker_password(String password)
	{
		Admin_Banker_password.clear();
		Admin_Banker_password.sendKeys(password);
	}
	
	
	public void Click_login_btn()
	{
		Login_btn.click();
	}
	
	
	public void Enter_Admin_Banker_Login(String username,String password)
	{
		Type_Admin_Banker_username(username);
		Type_Admin_Banker_password(password);
		Click_login_btn();
		
	}
	
	
	/*
	 * Method Verify alert presented at webapge and return boolen avalue true/false
	 */
	public boolean is_AlertPresent()
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public void close_Alert()
	{
		if(is_AlertPresent())
			driver.switchTo().alert().accept();
		else
			System.out.println("Alert not presented");
	}
	
	

}
