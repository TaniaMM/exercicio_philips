package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By username = By.cssSelector("#identifierId");
	By next = By.cssSelector("#identifierNext > content > span");		
	By password = By.cssSelector("#password > div > div > div > input");	
	By next2 = By.cssSelector("#passwordNext");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement EmailId() {		
		return driver.findElement(username);
	}
	
	public WebElement bottomNext1() {		
		return driver.findElement(next);
	}
	
	public WebElement password() {		
		return driver.findElement(password);
	}
	
	public WebElement bottomNext2() {		
		return driver.findElement(next2);
	}
	
	public By getPassword() {
		return password;
	}

}
