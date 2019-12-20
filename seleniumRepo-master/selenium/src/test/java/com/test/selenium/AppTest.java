package com.test.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ByIdOrName;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testLogin()
    {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver.exe");
//		System.setProperty("phantomjs.binary.path",
//				"C:\\Users\\LENOVO\\Downloads\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		// driver=new ChromeDriver();
		// WebDriver driver = new PhantomJSDriver();
		ChromeOptions options = new ChromeOptions();
		// setting headless mode to true.. so there isn't any ui
		options.setHeadless(true);

		// Create a new instance of the Chrome driver
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// driver.manage().window().maximize();
		driver.navigate().to("http://localhost:9189/BrowserWeb");
		System.out.println(driver.getTitle());

		driver.findElement(new ByIdOrName("signOnName")).sendKeys("KHALILAR");
		driver.findElement(new ByIdOrName("password")).sendKeys("123456");
		driver.findElement(By.id("sign-in")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		catch (NoAlertPresentException e) {
			// TODO: handle exception
			System.out.println("No Alert detected");
		}
		

//    	if(driver.findElement(By.id("error")).getAttribute("sv").equals("true"))
//    		System.out.println("Login Failed");

		System.out.println(driver.getTitle());
		assertEquals("T24 - Model Bank",driver.getTitle());

    }


    public void testAddCustomer() {
    	
    	
    }



}
