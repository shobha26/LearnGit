package functionalities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Reusable {
	
	public static WebDriver dvr;
	
	public static Properties Prop=new Properties();
	
	@BeforeTest
	
	public void setup() throws FileNotFoundException, IOException
	{
		Prop.load(new FileInputStream("../Scenario1722016/Input/flipkart.properties"));
		
	
		dvr=new FirefoxDriver();
		dvr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dvr.manage().window().maximize();
		dvr.get("http://www.flipkart.com");
		
	}
	
	public void promocancel(String element) throws InterruptedException
	{
	try
	{
	dvr.findElement(By.xpath(Prop.getProperty(element))).click();
	}
	
	catch(Exception e)
	{
		System.out.println("Popup not found on page");
		
	}	
	
	}

	public void click(String key)
	{
		dvr.findElement(By.xpath(Prop.getProperty(key))).click();
	}
	
	public void clear(String element)
	{
		dvr.findElement(By.xpath(Prop.getProperty(element))).clear();
	}
	
	public void gettext(String key)
	{
		String s= dvr.findElement(By.xpath(Prop.getProperty(key))).getText().trim();
		System.out.println(dvr.findElement(By.xpath(Prop.getProperty(key))).getText());
		
	}


	public void sendKeys(String element, String text)
	{
		dvr.findElement(By.xpath(Prop.getProperty(element))).sendKeys(text);
		
	}

	public void mousehover(String key) throws InterruptedException
	{
	
		Actions act = new Actions(dvr);
		act.moveToElement(dvr.findElement(By.xpath(Prop.getProperty(key)))).perform();
		act.moveToElement(dvr.findElement(By.xpath(Prop.getProperty(key)))).perform();
	}
	
	public void doubleclick(String element) throws InterruptedException
	{
		Actions act1= new Actions(dvr);
		act1.doubleClick(dvr.findElement(By.xpath(Prop.getProperty(element)))).perform();
		 Thread.sleep(3000);
		    //System.out.println(dvr.getTitle());
	}

	public void capturescreenshot(String Filename) throws IOException
	{
		File f=((TakesScreenshot)dvr).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("../Scenario1722016/Screenshots"+Filename+""));
		
	}

	public void scroll(String element) throws InterruptedException
	{
		/*WebElement element1 = dvr.findElement(By.xpath(element));
		((JavascriptExecutor) dvr).executeScript("arguments[0].scrollIntoView(true);", element1);
		Thread.sleep(500);*/
		/*int yaxis=300;
		dvr.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		for(int i=0; i<5;)
		{
			((JavascriptExecutor)dvr).executeScript("window.scroll(0,"+yaxis+");");
			yaxis=yaxis+300;
			Thread.sleep(1000);
			try
			{
				if(dvr.findElement(By.xpath(element)).isDisplayed());
				{
					System.out.println("Link found");
					dvr.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
					break;
					
				}
			}
			
			catch(Exception e)
			{
				
			}
					
		}
	}*/
		JavascriptExecutor jse = (JavascriptExecutor)dvr;
		jse.executeScript("window.scrollBy(0,150)", ""); 
	}
	
	public void gmailwindow() throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor)dvr;

        jse.executeScript("window.open()", "");

        Set<String> windowHandles = dvr.getWindowHandles();

            dvr.switchTo().window(windowHandles.toArray()[1].toString());

        Thread.sleep(4000);

      dvr.navigate().to("http:www.gmail.com");

        Thread.sleep(4000);
		
	}
	

}
