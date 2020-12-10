package web_tests;

import org.openqa.selenium.WebDriver;

import keywords.Excel_Keywords;
import keywords.Repository;
import web_pages.New_Brnach_Creation;
import web_pages.RanfordHome;

public class DD_Admin_Tests extends Repository
{
	WebDriver driver;
	
	public DD_Admin_Tests(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	public void Create_A_Branch(String brachName,String Add1, String Zcode,String Cntry,String State,String City)
	{
		
		Excel_Keywords.get_workbook("InputData", "Sheet1");
		RanfordHome home=new RanfordHome(driver);
		home.Enter_Admin_Banker_Login("Admin", "M1ndq");
		
		New_Brnach_Creation NB=new New_Brnach_Creation(driver);
		Type_text(NB.Branch_Name, Excel_Keywords.get_cell_Data(1, 0));
		
	}

}
