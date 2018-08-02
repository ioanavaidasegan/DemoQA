package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public String app;
	public String platform;

	public void initDriver() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 5);
	}

	public void tearDown() {
		driver.close();
		if (!driver.equals(null))
			driver.quit();
	}

	public void navigateTo(String url) {
		driver.manage().window().maximize();
		driver.navigate().to(url);

	}

	public WebElement findElem(String name, String type, Boolean mandatory) {
		WebElement element = null;
		try {
		
			if (type == "css")
				element = driver.findElement(By.cssSelector(name));
			else if (type == "id")
				element = driver.findElement(By.id(name));
			else if (type == "xpath")
				element = driver.findElement(By.xpath(name));
			else if (type == "class")
				element = driver.findElement(By.className(name));
		} catch (NoSuchElementException e) {
			System.out.println("Element Not Found");
		}

		if (element != null)
			return element;
		else if (mandatory == null)
			System.out.println("Element not Found: " + name);

		return element;

	}

	public void clickOnFindElem(String name, String type, Boolean mandatory) {
		WebElement element = findElem(name, type, mandatory);
		try {
			if (element.isEnabled()) {
				element.click();
			}

		} catch (Exception e) {
			System.out.println("Element is disable");
		}

	}

	public void sendKeysOnFindElem(String name, String type, Boolean mandatory, String keys) {
		WebElement element = findElem(name, type, mandatory);
		try {
			element.sendKeys(keys);
		} catch (Exception e) {
			System.out.println("Couldn't send keys");
			e.printStackTrace();
		}
	}


	public String getPropertiesOnGetText(String name, String type, Boolean mandatory) {
		WebElement element = findElem(name, type, mandatory);
		String text = element.getText();
		return text;

	}

}