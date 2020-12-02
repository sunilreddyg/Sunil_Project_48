package banker_testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import banker_pages.Receipts;
import keywords.Repository;
import web_pages.RanfordHome;

public class Banker_Tests extends Repository
{
	
	WebDriver driver;

	public Banker_Tests(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}




	
	

	public void banker_login(String BranchName,String username,String password,String Exp_title)
	{
		
		RanfordHome RHP=new RanfordHome(driver);
		Select_Drodpown(RHP.BankerSelection_Dropdown, BranchName);
		Type_text(RHP.Admin_Banker_username, username);
		Type_text(RHP.Admin_Banker_password, password);
		click_element(RHP.Login_btn);
		Assert.assertTrue(Is_title_presented(Exp_title));
	}
	


	public void Receipts_DD_Deposit_using_Valid_AccoutNumber(String AccoutNumber,String Accout_Name)
	{
		Receipts receipts=new Receipts(driver);
		click_element(receipts.Receipts_btn);
		Type_text(receipts.Account_number_Editbox, AccoutNumber);
		Select_Drodpown(receipts.Dropdown_Transaction_type, "dd deposite(+)");
		Assert.assertTrue(wait_and_verify_element_visible(receipts.Act_holder_name_EB));
		Assert.assertTrue(Verify_input_Value(receipts.Act_holder_name_EB, Accout_Name));
		
	}
	
	
	public void Receipts_DD_Deposit_using_InValid_AccoutNumber(String AccoutNumber)
	{
		
		
	}
	

}
