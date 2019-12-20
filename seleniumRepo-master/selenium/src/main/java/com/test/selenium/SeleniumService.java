package com.test.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumService {

	public static String T24_URL = "http://localhost:9089/BrowserWeb";
	public static WebDriver driver = null;
	public static String[] T24_FIELDS = { "MNEMONIC", "SHORT.NAME-1", "NAME.1-1", "ADDRESS-1.1", "SECTOR", "LANGUAGE",
			"ACCOUNT.OFFICER", "INDUSTRY", "TARGET", "NATIONALITY", "CUSTOMER.STATUS" };
	public static String[] VALUES = { "TEST", "TEST1,TEST2,TEST3", "TEST",
			"ADR1.1;ADR1.2,ADR2.1;ADR2.2", "1000", "2", "1", "1000", "1", "TN", "1" };
	public static String VERSION = "CUSTOMER,";
	public static WebDriverWait wait = null;
	public static String USERNAME = "KHALILAR";
	public static String PASSWORD = "123456";
	public static long WAIT_TIME_SIGN_IN = 3000;
	public static String MAIN_WINDOW;
	public static String MV_DELIMITER = ",";
	public static String SV_DELIMITER = ";";

	/**
	 * Initializing Web Driver and navigating to T24 login page
	 */
	public static void initializeDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//options.setHeadless(true);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		driver.navigate().to(T24_URL);

	}

	/**
	 * Signing in to the T24 system
	 * 
	 * @return true if sign in is successful
	 */
	public static boolean signIn() {
		driver.findElement(new ByIdOrName("signOnName")).sendKeys(USERNAME);
		driver.findElement(new ByIdOrName("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("sign-in")).click();
		// In case of javascript alert
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
		}
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		} catch (Exception e) {
			return false;
		}

		if (driver.getTitle().equals("T24 - Model Bank")) {
			MAIN_WINDOW = driver.getWindowHandle();
			return true;
		}
		return false;
	}

	/**
	 * Closes all T24 windows
	 */
	public static void closeAllWindows() {
		driver.getWindowHandles().forEach(elt -> {
			driver.switchTo().window(elt).close();
		});
	}
	
	public static void closeAllWindowsExceptMainWindow() {
		driver.getWindowHandles().forEach(elt -> {
			if(!elt.equals(MAIN_WINDOW))
			driver.switchTo().window(elt).close();
		});
	}

	/**
	 * Signing Off
	 * 
	 * @return
	 */
	public static boolean signOff() {
		try {
			driver.findElements(By.tagName("a")).stream().filter(obj -> obj.getAttribute("title").equals("Sign off"))
					.findFirst().orElse(null).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Switches driver's location to VERSION Application.
	 */
	public static void switchToVersionApplication() {
		WebElement input = driver.findElement(By.id("commandValue"));
		input.clear();
		input.sendKeys("VERSION");
		driver.findElement(By.id("cmdline_img")).click();

		String parentWinHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles)
			if (!handle.equals(parentWinHandle))
				driver.switchTo().window(handle);
	}

	/**
	 * Switches driver's location to the version specified in the static field
	 * VERSION
	 */
	public static void switchToVersion() {

		driver.findElement(By.id("commandValue")).clear();
		driver.findElement(By.id("commandValue")).sendKeys(VERSION);
		driver.findElement(By.id("cmdline_img")).click();
		String parentWinHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles)
			if (!handle.equals(parentWinHandle))
				driver.switchTo().window(handle);
	}
	
	
	public static void switchBackToVersion() {
		driver.findElements(By.tagName("a")).stream()
		.filter(obj -> obj.getAttribute("title") != null
				&& obj.getAttribute("title").equals("Return to application screen"))
		.findFirst().orElse(null).click();
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
		}
	}

	
	/**
	 * Switches back the driver to the main page
	 */
	public static void switchBackToMainWindow() {
		driver.switchTo().window(MAIN_WINDOW);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));

	}

	/**
	 * Switches back the driver to the VERSION Application
	 */
	public static void switchBacktoVersionApplication() {
		driver.findElements(By.tagName("a")).stream()
				.filter(obj -> obj.getAttribute("title") != null
						&& obj.getAttribute("title").equals("Return to application screen"))
				.findFirst().orElse(null).click();

	}

	/**
	 * Validates a new VERSION record using the two static arrays T24_FIELDS as
	 * field names and VALUES as the values to be inserted
	 * 
	 * @return true if the record is validated
	 */
	public static boolean addNewDeal() {
		try {
			driver.findElements(By.tagName("a")).stream().filter(obj -> obj.getAttribute("title").equals("New Deal"))
					.findFirst().orElse(null).click(); // Click on new deal link
			for (int i = 0; i < T24_FIELDS.length; i++) // loop field names FM (Separator between fields)
				// Case of multi_value field with subValues
				if (T24_FIELDS[i].endsWith("-1.1")) {
					String[] mvalues = VALUES[i].split(MV_DELIMITER);
					for (int j = 0; j < mvalues.length; j++) {
						String[] svalues = mvalues[j].split(SV_DELIMITER);
						for (int k = 0; k < svalues.length; k++) // i for FM j for VM and k for SM
						{
							JavascriptExecutor executer = (JavascriptExecutor) driver;
							WebElement inputElement = driver.findElement(
									By.id("fieldName:" + T24_FIELDS[i].substring(0, T24_FIELDS[i].length() - 4) + ":"
											+ (j + 1) + ":" + (k + 1)));
							inputElement.sendKeys(svalues[k]);
							if (k == svalues.length - 1)
								break;
							WebElement td = (WebElement) executer.executeScript("return arguments[0].parentNode;",
									inputElement);
							String sv = td.getAttribute("svdetails");
							driver.findElements(By.tagName("a")).stream()
									.filter(obj -> obj.getAttribute("href") != null && obj.getAttribute("href")
											.equals("javascript:svExpandClient('" + sv + "')"))
									.findFirst().orElse(null).click();
						}

						JavascriptExecutor executer = (JavascriptExecutor) driver;
						WebElement inputElement = driver.findElement(By.id("fieldName:"
								+ T24_FIELDS[i].substring(0, T24_FIELDS[i].length() - 4) + ":" + (j + 1) + ":1"));
						if (j == mvalues.length - 1)
							break;
						WebElement td = (WebElement) executer.executeScript("return arguments[0].parentNode;",
								inputElement);
						String mv = td.getAttribute("mvdetails");
						driver.findElements(By.tagName("a")).stream()
								.filter(obj -> obj.getAttribute("href") != null
										&& obj.getAttribute("href").equals("javascript:mvExpandClient('" + mv + "')"))
								.findFirst().orElse(null).click();

					}

				}

				// Case of multi_value field
				else if (T24_FIELDS[i].endsWith("-1")) {
					String[] values = VALUES[i].split(MV_DELIMITER);
					for (int j = 0; j < values.length; j++) {
						JavascriptExecutor executer = (JavascriptExecutor) driver;
						WebElement inputElement = driver.findElement(By.id(
								"fieldName:" + T24_FIELDS[i].substring(0, T24_FIELDS[i].length() - 2) + ":" + (j + 1)));
						inputElement.sendKeys(values[j]);
						if (j == values.length - 1)
							break;
						WebElement td = (WebElement) executer.executeScript("return arguments[0].parentNode;",
								inputElement);
						String mv = td.getAttribute("mvdetails");
						driver.findElements(By.tagName("a")).stream()
								.filter(obj -> obj.getAttribute("href") != null
										&& obj.getAttribute("href").equals("javascript:mvExpandClient('" + mv + "')"))
								.findFirst().orElse(null).click();

					}

				}

				// Case of simple field
				else
					driver.findElement(By.id("fieldName:" + T24_FIELDS[i])).sendKeys(VALUES[i]);

			driver.findElements(By.tagName("a")).stream()
					.filter(obj -> obj.getAttribute("title").equals("Validate a deal")).findFirst().orElse(null)
					.click();

			driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
			if (SeleniumService.exist(driver, "errorImg"))
			{
				driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
				return false;
			}
			else
			{	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
				return true;
			}
				
			

		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Verifies if a web element is present in the current frame.
	 * 
	 * @param driver The Web Driver
	 * @param id     ID of the element
	 * @return true if the element exists
	 */
	public static boolean exist(WebDriver driver, String id) {
		try {
			driver.findElement(By.id(id));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Retrieves the associated versions of the version stored in the static field
	 * VERSION.
	 * 
	 * @return List of the associated versions.
	 */
	public static List<String> getAssociatedVersions() {

		List<String> fields = new ArrayList<String>();
//		WebElement input = driver.findElements(By.id("transactionId")).stream()
//				.filter(obj -> obj.getAttribute("type").equals("text")).findFirst().orElse(null);
//		input.clear();
//		input.sendKeys(VERSION);
//		driver.findElements(By.tagName("a")).stream().filter(obj -> obj.getAttribute("title").equals("View a contract"))
//				.findFirst().orElse(null).click();

		List<WebElement> elements = driver.findElements(By.tagName("a"));
		List<WebElement> elements2 = new ArrayList<WebElement>();
		for (WebElement webElement : elements)
			if (webElement.getAttribute("id").equals("fieldCaption:ASSOC.VERSION"))
				elements2.add(webElement);

		List<WebElement> trElements = new ArrayList<WebElement>();
		for (WebElement webElement : elements2) {
			WebElement label = (WebElement) ((JavascriptExecutor) driver)
					.executeScript("return arguments[0].parentNode;", webElement);
			WebElement td = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode;",
					label);
			WebElement tr = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode;",
					td);
			trElements.add(tr);
		}

		for (WebElement webElement : trElements)
			fields.add(webElement.findElements(By.tagName("span")).get(0).getText());

		return fields;

	}

	/**
	 * Retrieves field names of a version (Without considering the associated ones).
	 * 
	 * @param version
	 * @return List of field names.
	 */
	public static List<String> getFieldsFromMainVersion(String version) {

		List<String> fields = new ArrayList<String>();

		WebElement input = driver.findElements(By.id("transactionId")).stream()
				.filter(obj -> obj.getAttribute("type").equals("text")).findFirst().orElse(null);
		input.clear();
		input.sendKeys(version);
		driver.findElements(By.tagName("a")).stream().filter(obj -> obj.getAttribute("title").equals("View a contract"))
				.findFirst().orElse(null).click();

		List<WebElement> elements = driver.findElements(By.tagName("a"));
		List<WebElement> elements2 = new ArrayList<WebElement>();
		for (WebElement webElement : elements)
			if (webElement.getAttribute("id").equals("fieldCaption:FIELD.NO"))
				elements2.add(webElement);

		List<WebElement> trElements = new ArrayList<WebElement>();
		for (WebElement webElement : elements2) {
			WebElement label = (WebElement) ((JavascriptExecutor) driver)
					.executeScript("return arguments[0].parentNode;", webElement);
			WebElement td = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode;",
					label);
			WebElement tr = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode;",
					td);
			trElements.add(tr);
		}

		for (WebElement webElement : trElements)
			fields.add(webElement.findElements(By.tagName("span")).get(0).getText());

		return fields;

	}

	/**
	 * Retrieves all field names of the version stored in the static field VERSION
	 * (Including associated versions).
	 * 
	 * @return List of field names.
	 */
	public static List<String> getFieldsFromVersion() {
		List<String> fields = getFieldsFromMainVersion(VERSION);
		//switchBacktoVersionApplication();
		for (String assocVersion : getAssociatedVersions()) {
			switchBacktoVersionApplication();
			fields.addAll(getFieldsFromMainVersion(assocVersion));
		}

		fields.removeIf(obj -> obj.equals("*"));
		return fields;

	}

	/**
	 * Switches the web driver to the first frame of the page.
	 * 
	 * @return true if the driver is correctly located.
	 */
	public static boolean switchToFrame() {
		try {
			driver.switchTo().frame(0);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}

	}
	
	public static String[] convertListToArray(List<String> list)
	{
		String[] res=new String[list.size()];
		for(int i=0; i<list.size();i++)
			res[i]=list.get(i);
		return res;
	}

}
