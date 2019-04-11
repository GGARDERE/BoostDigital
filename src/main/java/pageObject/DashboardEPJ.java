package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.windows.WindowsDriver;

public class DashboardEPJ {
	
	public PropositionCommerciales voirPropositions(WindowsDriver<RemoteWebElement> driver, WebDriverWait wait) {
		WebElement boutonVoirProposition = wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByName("Voir les propositions")));
		boutonVoirProposition.click();
		return new PropositionCommerciales();
		
	}

}
