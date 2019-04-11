package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.windows.WindowsDriver;

public class AcceuilPage {

public DashboardEPJ selectionEPJ (WindowsDriver<RemoteWebElement> driver, String EPJ) {
	
	WebElement champEPJ = driver.findElementByName("Veuillez indiquer un numéro d'EPJ");
	champEPJ.sendKeys(EPJ);
	
	WebElement boutonContinuer = driver.findElementByName("Continuer");
	boutonContinuer.click();
	return new DashboardEPJ();
	
}

}
