package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.windows.WindowsDriver;

public class CatalogueProduits {

	public void selectionnerProduit(WindowsDriver<RemoteWebElement> driver, WebDriverWait wait, String filtre, String produit) {
		
		WebElement boutonFiltre = driver.findElementByXPath("//Text[@Name='"+filtre+"']/..");
		// wait.until(ExpectedConditions.elementToBeClickable( ));
		//("//Text[@Name='Gammes']/../..//Text[contains(@Name, '"+filtre+"')]")
		boutonFiltre.click();
		
		WebElement boutonProduit = wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByName(produit)));
		
	//;
		boutonProduit.click();
	}
	
	public EcranListeEtablissement  selectionnerChoisirCetteOffre(WindowsDriver<RemoteWebElement> driver) {
		WebElement boutonChoisirCetteOffre = driver.findElementByName("Choisir cette offre");
		boutonChoisirCetteOffre.click();
		return new EcranListeEtablissement();
	}
	
}
