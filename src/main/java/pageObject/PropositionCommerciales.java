package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.windows.WindowsDriver;

public class PropositionCommerciales {

	
	public CatalogueProduits selectionBoutonPlus(WindowsDriver<RemoteWebElement> driver,WebDriverWait wait, String nom_Propal) {
		
		WebElement boutonPlus = wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//Button[@Name='C']/following-sibling::Button")));
		boutonPlus.click();
		
		WebElement champNomPropalCommerciale = wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//Edit[@Name='Nom de la nouvelle proposition commerciale']")));
				//driver.findElementByName("Nom de la nouvelle proposition commerciale");
		champNomPropalCommerciale.sendKeys(nom_Propal);
		
		RemoteWebElement boutonValider = driver.findElementByXPath("//Edit[@Name='Nom de la nouvelle proposition commerciale']/following::Button[@Name='Valider']");
		boutonValider.click();
		return new CatalogueProduits();
	}
}
