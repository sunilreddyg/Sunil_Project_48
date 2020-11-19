package keywords;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;


public class Repository 
{
	WebDriver driver;
	Robot robot;
	String Screen_filepath="C:\\Users\\SUNIL\\git\\Sunil_Project_48\\Sunil_Project_48\\screens\\";
	
	public Repository(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	
	/*
	 * keyword:==> Method verify alert presented at webpage and return boolean
	 * 				value true/false.
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
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
	
	
	/*
	 * keyword:==> Method Close alert after verifying alert presented at webpage
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
	 */
	public void close_Alert()
	{
		if(is_AlertPresent())
			driver.switchTo().alert().accept();
		else
			System.out.println("Alert not presented");
	}
	
	/*
	 * keyword:==> Method verify expected alert message presented
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
	 */
	
	public boolean Verify_Alert_message(String Exp_message)
	{
		try {
			return driver.switchTo().alert().getText().contains(Exp_message);
		} catch (Exception e) {
			return false;
		}
	
	}
	
	/*
	 * keyword:==> Capture screen on alert presented
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
	 */
	public void Screen_Capture_At_Alert() throws Exception
	{
		Dimension scree_size=Toolkit.getDefaultToolkit().getScreenSize();
		robot=new Robot();
		BufferedImage Bimage=robot.createScreenCapture(new Rectangle(scree_size));
		ImageIO.write(Bimage, "PNG", new File(Screen_filepath+"filename"+".png"));
	}
	

}
