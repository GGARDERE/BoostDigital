package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.windows.WindowsDriver;

public class SessionFactory {

	private final Map<WebElement, WindowsDriver<RemoteWebElement>> windowsSession = new HashMap<WebElement, WindowsDriver<RemoteWebElement>>();
	
	private final String remoteURL; 
	
	public SessionFactory(String remoteURL) {
		this.remoteURL=remoteURL;
	}
	
	public WindowsDriver<RemoteWebElement> getSession(WebElement window) throws MalformedURLException, InterruptedException {
		if (!windowsSession.containsKey(window)) {
			Thread.sleep(2000);
			String windowTopLevelWindowHandle = window.getAttribute("NativeWindowHandle");
			//windowTopLevelWindowHandle = Integer.toHexString(Integer.parseInt(windowTopLevelWindowHandle));
			System.out.println(windowTopLevelWindowHandle);
			DesiredCapabilities apCapabilities3 = new DesiredCapabilities();
			Thread.sleep(2000);
			apCapabilities3.setCapability("appTopLevelWindow", Integer.toHexString(Integer.parseInt(windowTopLevelWindowHandle)));
			WindowsDriver<RemoteWebElement> windowSession = new WindowsDriver<RemoteWebElement>(
					new URL(remoteURL), apCapabilities3);
			Thread.sleep(2000);
			windowsSession.put(window, windowSession);
		}
		return windowsSession.get(window);
	}
}
