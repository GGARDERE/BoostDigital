package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.optional.Cab;
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
import pageObject.AcceuilPage;
import pageObject.CatalogueProduits;
import pageObject.DashboardEPJ;
import pageObject.EcranConnection;
import pageObject.EcranListeEtablissement;
import pageObject.PropositionCommerciales;
import utils.ParseFile;
import utils.SessionFactory;


public class PageObjectLaunchBoost {
	private static final String REMOTE_URL ="http://127.0.0.1:4723";
	
	private static final SessionFactory SESSION_HELPER = new SessionFactory(REMOTE_URL);
	private static ParseFile parseFile= new ParseFile();
	private RemoteWebDriver desktopSession = null;
	@Test
	public void run () throws MalformedURLException, InterruptedException, FileNotFoundException {
String login="newsirg13";
String password="jaunes12345!";
String EPJ="53611670";
String nom_Propal="Propal_TestAuto";
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
		

		WindowsDriver<RemoteWebElement> soLocalSession = SESSION_HELPER.getSession(solocalWindow);
		WebDriverWait wait1 = new WebDriverWait(soLocalSession, 10);
		
		EcranConnection ecranConnection = new EcranConnection();
		AcceuilPage acceuil =ecranConnection.seconnecter(soLocalSession, login, password);
		Thread.sleep(3000);
		DashboardEPJ dashboard =acceuil.selectionEPJ(soLocalSession, EPJ);
		Thread.sleep(3000);
		PropositionCommerciales propositionCommerciales = dashboard.voirPropositions(soLocalSession, wait1);
		CatalogueProduits catalogueProduits = propositionCommerciales.selectionBoutonPlus(soLocalSession, wait1,  nom_Propal);
		Thread.sleep(5000);
		catalogueProduits.selectionnerProduit(soLocalSession, wait1, "Présence et Référencement prioritaire (3)", "Solutions Présence et Référencement prioritaire ");
		EcranListeEtablissement ecranListeEtablissement = catalogueProduits.selectionnerChoisirCetteOffre(soLocalSession);
//		Thread.sleep(10000);
//		List<RemoteWebElement> tutu = soLocalSession.findElementsByXPath("//Text[@Name='00035']/../..//Text[@Name]");
//		List<String> listvaleur = new ArrayList<String>();
//		int i=0;
//		//List<String> v2 = tableau.stream().map(RemoteWebElement::getAttribute("Name")).collect(Collector.toList());
//		for (RemoteWebElement azerty1 : tutu) {
//			listvaleur.add(azerty1.getAttribute("Name")) ;
//			System.out.println(i);
//			i++;
//		}
//		
//
////		List<String> listeElementRecup = ecranListeEtablissement.verifSolutionEtabilssement(soLocalSession, wait1);
//		List<String> listeRef = parseFile.loadFile("src/main/resources/filesRessources/liste1JDD1");
//		
//		Assert.assertEquals(listeRef, tutu);
//	
//	
		ecranListeEtablissement.selectionnerConfigurer(soLocalSession, wait1);
		
		
		}
}
