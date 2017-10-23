package reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extent_Reports 
{
	public WebDriver driver;
	
	@Test
	public void extent()
	{
		ExtentReports er=new ExtentReports("E:\\Neon_Projects\\ExtentReport.html");
		ExtentTest et=er.startTest("Extent_Reports");
		
		
		driver =new FirefoxDriver();
		driver.navigate().to("https://www.google.com");
		
		et.log(LogStatus.PASS, "Test Passed");
		
		driver.manage().window().maximize();
		driver.findElement(By.id("lst-ib")).sendKeys("Extent Reports in Selenium");
		
		et.log(LogStatus.FAIL,"TestFailed");
		
		// To end Test
		er.endTest(et);
		
		// To save the result
		er.flush();
		
		//To display result automatically
		driver.get("file:///E:\\Neon_Projects\\ExtentReport.html");
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
