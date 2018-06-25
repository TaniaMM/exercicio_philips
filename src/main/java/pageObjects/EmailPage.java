package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailPage {
	
	public WebDriver driver;
	
	By compose = By.cssSelector("#\\3a 3e > div > div");
	By receiver = By.name("to");
	By subject = By.name("subjectbox");
	By mailbody = By.cssSelector("div table tbody tr td div div.editable");	
	By send = By.cssSelector("table tbody tr td div div div table tbody tr.btC td div.btA");
	By msgItem = By.xpath("//*[@id=\":52\"]");	
	By refreshEmail = By.xpath("//*[@id=\":5\"]/div/div[1]/div[1]/div/div/div[4]/div");
	By emailTitle = By.cssSelector("#\\3a 8w");
	By emailSender = By.className("go");
	By bodyMsg = By.xpath("//*[@id=\":82\"]/div[1]");
	By btnDelete = By.xpath("//*[@id=\":5\"]/div[2]/div[1]/div/div[2]/div[3]");
	By sendAlert = By.xpath("/html/body/div[7]/div[3]/div/div[1]/div[5]/div[1]/div/div[3]/div/div/div[2]");
	By deleteAlert = By.xpath("/html/body/div[7]/div[3]/div/div[1]/div[5]/div[1]/div/div[3]/div/div/div[2]/span/span[1]");
	By iconProfile = By.xpath("//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[5]/div[1]/a/span");
	By btnSignOut = By.xpath("//*[@id=\"gb_71\"]");
	By noEmailMsg = By.cssSelector("div.Kj-JD:nth-child(50) > div:nth-child(2)");
	By btnOkMsgErr= By.cssSelector("div[role=\"alertdialog\"] div button[name=\"ok\"]:only-child");	
	By btnDiscardDraft = By.cssSelector("table tbody tr td div div div[role=\"button\"][data-tooltip=\"Discard draft\"]");
	By bodyMsgInvalidRecipient = By.cssSelector("div.adn.ads div.gs div div.ii.gt div");
	By discardedMsg = By.xpath("/html/body/div[7]/div[3]/div/div[1]/div[5]/div[1]/div/div[3]/div/div/div[2]/span/span[1]");
	
	public EmailPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public By getCompose() {
		return compose;
	}
	
	public By getReceiver() {
		return receiver;
	}
	
	public By getMsgItem() {
		return msgItem;
	}
	
	public By getSendAlert() {
		return sendAlert;
	}
	
	public By getDeleteAlert() {
		return deleteAlert;
	}
	
	public By getBtnSignOut() {
		return btnSignOut;
	}
	
	public By getNoEmailMsg() {
		return noEmailMsg;
	}
		
	public By getDicardedMsg() {
		return discardedMsg;
	}
	
	public By getBtnOkMsgErr() {
		return btnOkMsgErr;
	}
	
	public By getBtnDiscardDraft() {
		return btnDiscardDraft;
	}
		
	public WebElement compose() {		
		return driver.findElement(compose);
	}
	
	public WebElement receiver() {		
		return driver.findElement(receiver);
	}
	
	public WebElement subject() {		
		return driver.findElement(subject);
	}
	
	public WebElement mailbody() {		
		return driver.findElement(mailbody);
	}
	
	public WebElement send() {		
		return driver.findElement(send);
	}
	
	public WebElement refershEmail() {		
		return driver.findElement(refreshEmail);
	}
	
	public WebElement msgItem() {		
		return driver.findElement(msgItem);
	}
	
	public WebElement emailTitle() {		
		return driver.findElement(emailTitle);
	}
	
	public WebElement emailSender() {		
		return driver.findElement(emailSender);
	}
	
	public WebElement bodyMsg() {		
		return driver.findElement(bodyMsg);
	}
	
	public WebElement btnDelete() {		
		return driver.findElement(btnDelete);
	}
	
	public WebElement sendAlert() {		
		return driver.findElement(sendAlert);
	}

	public WebElement deleteAlert() {		
		return driver.findElement(deleteAlert);
	}
	
	public WebElement iconProfile() {		
		return driver.findElement(iconProfile);
	}
	
	public WebElement btnSignOut() {		
		return driver.findElement(btnSignOut);
	}
	
	
	public WebElement bodyMsgInvalidRecipient() {		
		return driver.findElement(bodyMsgInvalidRecipient);
	}
	
		
	public WebElement noEmailMsg() {		
		return driver.findElement(noEmailMsg);
	}
	
	public WebElement btnOkMsgErr() {		
		return driver.findElement(btnOkMsgErr);
	}
	
	public WebElement btnDiscardDraft() {		
		return driver.findElement(btnDiscardDraft);
	}
	
	public WebElement dicardedMsg() {		
		return driver.findElement(discardedMsg);
	}
	
}
