package pageObject;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.AcceuilPage;

import io.appium.java_client.windows.WindowsDriver;

public class EcranConnection {

	public AcceuilPage seconnecter (WindowsDriver<RemoteWebElement> driver, String login, String password) {
		WebElement champLogin = driver.findElementByXPath("//Edit[@Name='Login']");
		WebElement champPassword = driver.findElementByXPath("//Edit[@Name='Mot de passe']");
		WebElement boutonMeConnecter = driver.findElementByName(" Me connecter");
		
		champLogin.sendKeys(login);
		champPassword.sendKeys(password);
		boutonMeConnecter.click();
		
		return new AcceuilPage();
	}
	
	

}
