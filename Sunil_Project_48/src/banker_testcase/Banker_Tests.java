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
	
	public void Verify_DD_Doposit_Valid_Transaction(String Enter_Cash,String AccountNum,String Account_Name) throws Exception
	{
		
		Receipts_DD_Deposit_using_Valid_AccoutNumber(AccountNum, Account_Name);
		Receipts receipts=new Receipts(driver);
		String Before_Bal=Get_editbox_input(receipts.Account_Bal_Editbox);
		double B_bal=Double.parseDouble(Before_Bal);
		System.out.println(B_bal);
		
		Type_text(receipts.Ammout_Entry_EB, Enter_Cash);
		Thread.sleep(2000);
		Type_text(receipts.Check_OR_DD_CREDIT_EB, "123456");
		click_element(receipts.Submit_btn);
		//Assert.assertTrue(Verify_Alert_message("Transaction Has been posted"));
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Receipts_DD_Deposit_using_Valid_AccoutNumber(AccountNum, Account_Name);
		
		String After_Bal=Get_editbox_input(receipts.Account_Bal_Editbox);
		double A_bal=Double.parseDouble(After_Bal); 
		System.out.println(A_bal);
		
		double total=A_bal-B_bal;
		double E_cash=Double.parseDouble(Enter_Cash);
		Assert.assertEquals(total, E_cash);
		System.out.println("Transaction completed ammout Debited from account");
		
	}
	

}
