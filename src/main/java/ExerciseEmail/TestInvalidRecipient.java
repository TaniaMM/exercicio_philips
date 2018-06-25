package ExerciseEmail;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.EmailPage;
import resources.BaseTest;


public class TestInvalidRecipient extends BaseLogInOut {

	public static Logger log = LogManager.getLogger(BaseTest.class.getName());

	@Test
	public void TestInvalidRecipient1() {

		String emailAddress = "teste@testegmail.com", emailTitle = "Ut enim ad minim veniam",
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
		ep.receiver().sendKeys(emailAddress);
		log.info("Informou o e-mail do destinatário");

		ep.subject().sendKeys(emailTitle);
		log.info("Informou o assunto do e-mail");
		ep.mailbody().sendKeys(emailText);
		log.info("Informou o texto do e-mail");
		ep.send().click();
		log.info("Clicou em enviar");

		// validação mensagem de e-mail enviado
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ep.getSendAlert()));
		assertEquals(ep.sendAlert().getText(), "Your message has been sent. View message");
		log.info("Apareceu a mensagem de e-mail enviado");

		ep.refershEmail().click();
		log.info("Clicou no botão Refresh");

		wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ep.getMsgItem()));
		ep.msgItem().click();
		log.info("Clicou na mensagem de e-mail da caixa de entrada");

		log.info("Clicou no e-mail da caixa de entrada");
		assertEquals(ep.emailTitle().getText(), emailTitle);
		log.info("Verificou o título do e-mail");
		assertEquals(ep.emailSender().getText(), "<mailer-daemon@googlemail.com>");
		log.info("Verificou o destinatário do e-mail");

		String elementBody = ep.bodyMsgInvalidRecipient().getText();
		assertTrue(elementBody.contains("Address not found"));
		assertTrue(elementBody.contains(
				"Your message wasn't delivered to teste@testegmail.com because the domain testegmail.com couldn't be found."));
		log.info("Verificou o texto do e-mail");
		ep.btnDelete().click();
		log.info("Clicou no botão Delete");

		// validação da mensagem de e-mail apagado
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ep.getDeleteAlert()));
		assertEquals(ep.deleteAlert().getText(), "The conversation has been moved to the Trash.");
		log.info("Verificou a mensagem de Email enviado para a Lixeira");

	}
}
