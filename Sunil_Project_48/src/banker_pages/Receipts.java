package banker_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Receipts 
{

	public Receipts(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//img[@src='images/Receipts_but.jpg']")
	public WebElement Receipts_btn;
	
	@FindBy(xpath = "//input[@id='TxtaccNO']")
	public WebElement Account_number_Editbox;
	
	@FindBy(id="lstTransType")
	public WebElement Dropdown_Transaction_type;
	
	@FindBy(id="TxtCname")
	public WebElement Act_holder_name_EB;
	
	@FindBy(id="txtCqueNO")
	public WebElement Check_OR_DD_CREDIT_EB;
	
	@FindBy(id="btnSubmit")
	public WebElement Submit_btn;
	
	@FindBy(id="txtBalans")
	public WebElement Account_Bal_Editbox;
	
	@FindBy(id="txtamount")
	public WebElement Ammout_Entry_EB;
}
