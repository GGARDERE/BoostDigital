package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.windows.WindowsDriver;
import utils.SessionFactory;

public class LaunchBoostDigialRec {
	private static final String REMOTE_URL ="http://127.0.0.1:4723";
	
	private static final SessionFactory SESSION_HELPER = new SessionFactory(REMOTE_URL);
	
	private RemoteWebDriver desktopSession = null;
	
	@Test
	public void run () throws MalformedURLException, InterruptedException {

		DesiredCapabilities appCapabilities = new DesiredCapabilities();
		appCapabilities.setCapability("app", "Root");
		desktopSession = new WindowsDriver<RemoteWebElement>(new URL(REMOTE_URL), appCapabilities);
		desktopSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Assert.assertNotNull(desktopSession);
		desktopSession.getKeyboard().sendKeys(Keys.META + "s" + Keys.META);
		String tata = desktopSession.getWindowHandle();
		System.out.println(tata);
		WebElement cortanaWindow = desktopSession.findElementByName("Cortana");
		//WebElement cortanaWindow = desktopSession.findElementByName("Recherche");
		WindowsDriver<RemoteWebElement> cortanaSession = SESSION_HELPER.getSession(cortanaWindow);
		WebElement toto =cortanaSession.findElementByAccessibilityId("SearchTextBox");
		toto.sendKeys("Boost Digital Recette Globale");
		cortanaSession.getKeyboard().pressKey(Keys.ENTER );
		
		WebElement chevronIconeCache = desktopSession.findElementByName("Chevron de notification");
		
		chevronIconeCache.click();
		
		WebDriverWait wait = new WebDriverWait(desktopSession, 10);
		WebElement iconeBoostDigital = wait.until(ExpectedConditions.elementToBeClickable(desktopSession.findElementByName("BoostDigitalRec")));
		Actions actions = new Actions(desktopSession);
		actions.contextClick(iconeBoostDigital).perform();
		Thread.sleep(2000);
		desktopSession.findElementByName("Ouvrir").click();
		Thread.sleep(2000);
		
		WebElement solocalWindow = desktopSession.findElementByName("BoostDigitalRec");
		
		/////////
		///test//
		/////////
//		String fenetreThunderBirdTopLevelWindowHandle = solocalWindow.getAttribute("NativeWindowHandle");
//		System.out.println(Integer.toHexString(Integer.parseInt(fenetreThunderBirdTopLevelWindowHandle)));
//		
//		 
//		DesiredCapabilities apCapabilities4 = new DesiredCapabilities();
//		apCapabilities4.setCapability("appTopLevelWindow", Integer.toHexString(Integer.parseInt(fenetreThunderBirdTopLevelWindowHandle)));
//		WindowsDriver<RemoteWebElement> soLocalSession = new WindowsDriver<RemoteWebElement>(new URL ("http://127.0.0.1:4723"), apCapabilities4);

		
		/////////
		///test//
		/////////
		
		
		
		
		
		WindowsDriver<RemoteWebElement> soLocalSession = SESSION_HELPER.getSession(solocalWindow);
		Assert.assertNotNull(soLocalSession);
		Thread.sleep(3000);
		//soLocalSession.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement boutonMeConnecter = soLocalSession.findElementByName(" Me connecter");
		wait.until(ExpectedConditions.elementToBeClickable(boutonMeConnecter));
		WebElement champLogin =soLocalSession.findElementByXPath("//Edit[@Name='Login']");
		wait.until(ExpectedConditions.elementToBeClickable(champLogin));
		
				//soLocalSession.findElementByXPath("//Edit[@Name='Login']");
		champLogin.sendKeys("newsirg13");
		WebElement champPassword = soLocalSession.findElementByXPath("//Edit[@Name='Mot de passe']");
		champPassword.sendKeys("jaunes12345!");
		
		//WebElement boutonMeConnecter = soLocalSession.findElementByName(" Me connecter");
		
		boutonMeConnecter.click();
		//soLocalSession.findElementByXPath("//input[@Name='user_login']").sendKeys("newsirg13");
		//soLocalSession.findElementByXPath("//Edit[@Name='Mot de passe']").sendKeys("jaunes12345!");
		//soLocalSession.findElementByName("Login").sendKeys("newsirg13");
		//soLocalSession.findElementByName("Mot de passe").sendKeys("jaunes12345!");
		Thread.sleep(2000);
		WebElement champEPJ = soLocalSession.findElementByName("Veuillez indiquer un numéro d'EPJ");
		champEPJ.sendKeys("7816098");
		
		WebElement boutonContinuer = soLocalSession.findElementByName("Continuer");
		boutonContinuer.click();
		 
		
	}
}
