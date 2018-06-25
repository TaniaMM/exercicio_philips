package ExerciseEmail;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.EmailPage;
import pageObjects.LoginPage;
import resources.BaseTest;

public class BaseLogInOut extends BaseTest{
	
	public static Logger log = LogManager.getLogger(BaseTest.class.getName());
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver inicializado");
		driver.get(prop.getProperty("url"));
		log.info("Página acessada");
		
		LoginPage lp = new LoginPage(driver);
		lp.EmailId().sendKeys("exerciciophilips@gmail.com");
		log.info("Username informado");
		lp.bottomNext1().click();
		log.info("Clicou no botão Next");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lp.getPassword()));
		lp.password().sendKeys("teste@12345");		
		log.info("Senha informada");
		lp.bottomNext2().click();	
		log.info("Clicou no botão Next");
		
	}
	
			
	@AfterMethod
	public void teardown() {
		
		EmailPage ep = new EmailPage(driver);
		
		ep.iconProfile().click();
		log.info("Clicou no botão ícone do perfil");
		WebDriverWait wait7 = new WebDriverWait(driver, 5);
		wait7.until(ExpectedConditions.visibilityOfElementLocated(ep.getBtnSignOut()));
		ep.btnSignOut().click();
		log.info("Clicou no botão Sign Out");
		
		driver.close();
		log.info("Fechou o driver");
		
	}
	
		
}
