package ExerciseEmail;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.EmailPage;
import resources.BaseTest;

public class TestNoMailReceiver extends BaseLogInOut {

	public static Logger log = LogManager.getLogger(BaseTest.class.getName());

	@Test
	public void testAllFieldsInformed1() {

		String emailTitle = "Ut enim ad minim veniam",
				emailText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

		WebDriverWait wait;

		log.info("Abriu a tela de e-mail");
		EmailPage ep = new EmailPage(driver);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ep.getCompose()));
		ep.compose().click();
		log.info("Clicou no botão Compose");

		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ep.getReceiver()));

		ep.subject().sendKeys(emailTitle);
		log.info("Informou o assunto do e-mail");
		ep.mailbody().sendKeys(emailText);
		log.info("Informou o texto do e-mail");
		ep.send().click();
		log.info("Clicou em enviar");

		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ep.getBtnOkMsgErr()));
		ep.btnOkMsgErr().click();
		log.info("Clicou em OK na mensagem de erro");

		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ep.getBtnDiscardDraft()));
		ep.btnDiscardDraft().click();
		log.info("Clicou no botão Discard Draft");

		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ep.getDicardedMsg()));
		assertEquals(ep.dicardedMsg().getText(), "Your message has been discarded.");
		log.info("Apareceu a mensagem de e-mail enviado");
	}

}
