package pageObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.windows.WindowsDriver;

public class EcranListeEtablissement {

	public void focusTableau(WindowsDriver<RemoteWebElement> driver) {
		
	}
	
	public List<String> verifSolutionEtabilssement (WindowsDriver<RemoteWebElement> driver, WebDriverWait wait) {
		int i= 0;

		List<RemoteWebElement> tableau = driver.findElementsByXPath("//Text[@Name='00035']/../..//Text[@Name]");
				//driver.findElementsByXPath("//Table/Custom/DataItem/Custom/Text[@Name]");
		List<String> listvaleur = new ArrayList<String>();
		//List<String> v2 = tableau.stream().map(RemoteWebElement::getAttribute("Name")).collect(Collector.toList());
		for (RemoteWebElement azerty1 : tableau) {
			listvaleur.add(azerty1.getAttribute("Name")) ;
			System.out.println(i);
			i++;
		}
		return listvaleur;
		
	}
	public List<String> tutu(WindowsDriver<RemoteWebElement> driver){
		

	int i= 0;

	List<RemoteWebElement> tableau = driver.findElementsByXPath("//*[@Name]");
			//driver.findElementsByXPath("//Table/Custom/DataItem/Custom/Text[@Name]");
	List<String> listvaleur = new ArrayList<String>();
	//List<String> v2 = tableau.stream().map(RemoteWebElement::getAttribute("Name")).collect(Collector.toList());
	for (RemoteWebElement azerty1 : tableau) {
		listvaleur.add(azerty1.getAttribute("Name")) ;
		System.out.println(i);
		i++;
	}
	for (String azertyuiop : listvaleur) {
		System.out.println(azertyuiop);
	}
	return listvaleur;
	}
	public void selectionnerConfigurer(WindowsDriver<RemoteWebElement> driver, WebDriverWait wait) {
		WebElement toto = wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//Button[@Name='Configurer']")));
		toto.click();
	}

}
