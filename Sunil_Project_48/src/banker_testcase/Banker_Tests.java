package banker_testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import keywords.Repository;
import web_pages.RanfordHome;

public class Banker_Tests extends Repository
{
	
	

	public Banker_Tests(WebDriver driver) {
		super(driver);
	}



	WebDriver driver;
	Repository obj;
	
	

	public void banker_login(String BranchName,String username,String password,String Exp_title)
	{
		
		RanfordHome RHP=new RanfordHome(driver);
		Select_Drodpown(RHP.BankerSelection_Dropdown, BranchName);
		Type_text(RHP.Admin_Banker_username, username);
		Type_text(RHP.Admin_Banker_password, password);
		click_element(RHP.Login_btn);
		Assert.assertTrue(Is_title_presented(Exp_title));
	}
	


	public void Receipts_DD_Deposit_using_Valid_AccoutNumber(String AccoutNumber)
	{
		
		
	}
	
	
	public void Receipts_DD_Deposit_using_InValid_AccoutNumber(String AccoutNumber)
	{
		
		
	}
	

}
