package functionalities;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Functionalities extends Reusable {
	@Test
	public void login() throws InterruptedException
	{
		System.out.println(Prop.getProperty("flipkart_login_xpath"));
		WebDriverWait wait = new WebDriverWait(dvr,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Prop.getProperty("flipkart_login_xpath"))));
	
	
	 
		click("flipkart_login_xpath");
		sendKeys("login_email_xpath", "");
		sendKeys("login_password_xpath","");
	      click("login_button_xpath");
	    
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Prop.getProperty("flipkart_myaccounts_xpath"))));
			mousehover("flipkart_myaccounts_xpath");
			Thread.sleep(3000);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(Prop.getProperty("flipkart_myaccounts_accounts_xpath"))));
			Thread.sleep(3000);
			
		click("flipkart_myaccounts_accounts_xpath");
		scroll("flipkart_myaccount_updateemail_xpath");
		/* WebDriverWait wait11 = new WebDriverWait(dvr,60);
			wait11.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Prop.getProperty("flipkart_myaccount_updateemail_xpath"))));*/
		
		
		//wait.until(ExpectedConditions.visibilityOf(By.xpath(Prop.getProperty("flipkart_myaccount_updateemail_xpath"));
		click("flipkart_myaccount_updateemail_xpath");
		click("flipkart_editemail_xpath");
		clear("flipkart_emailclear_xpath");
		sendKeys("flipkart_emailclear_xpath","");
		click("flipkart_emailadd_xpath");
		click("flipkart_vericode_xpath");
		
		
		
		gmailwindow();
		//dvr.close();
		
		  
		 
		  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(Prop.getProperty(("gmail_login_xpath")))));
		  Thread.sleep(3000);
		  
		sendKeys("gmail_login_xpath","");
		click("gmail_next_xpath");
		click("gmail_passwrd_xpath");
		sendKeys("gmail_passwrd_xpath","");
		click("gmail_signin_xpath");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Prop.getProperty("gmail_inbox_xpath"))));
		Thread.sleep(2000);
		click("gmail_inbox_xpath");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Prop.getProperty("gmail_email_xpath"))));
		click("gmail_email_xpath");
		String s= dvr.findElement(By.xpath("((//p[@style='padding:0;margin:0;color:#565656;line-height:20px;font-size:13px'])[1]//strong)[1]")).getText().trim();
		System.out.println(s);
		click("gmail_logout_xpath");
		click("gmail_signoutclick_xpath");
		dvr.close();
		Set<String> windowHandles=dvr.getWindowHandles();
		  dvr.switchTo().window(windowHandles.toArray()[0].toString());
		  String url= dvr.getCurrentUrl();
		  System.out.println(url);
		
		   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Prop.getProperty("flipkart_vericode_xpath"))));
		sendKeys("flipkart_vericode_xpath", s);
		Thread.sleep(2000);
		click("flipkart_savechanges_xpath");

			
			
		
		
		


		
		
		
	}	
}
	

