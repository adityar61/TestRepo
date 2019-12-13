package AppiumProject.SampleProject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AppiumSampleScript {

	public static void main(String[] args) throws MalformedURLException {
		
		//Desired Capabilities object is created
		DesiredCapabilities dc = new DesiredCapabilities();
		//Set Desired Capability
		dc.setCapability("app", "C:\\Users\\Aditya\\Desktop\\Appium Class\\EriBank.apk");
		dc.setCapability("appPackage", "com.experitest.ExperiBank");
		dc.setCapability("appActivity", "com.experitest.ExperiBank.LoginActivity");
		dc.setCapability("deviceName", "MyDevice");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		
		dc.setCapability("newCommandTimeout", "120000");
		
		//Create object of Android Driver ad
		AndroidDriver ad = new AndroidDriver(new URL("http://192.168.0.104:4730/wd/hub"),dc);
		
		System.out.println(ad.getSessionId());
		//Write Android Script
		//Enter ID and Password and click on Login button
		ad.findElementById("com.experitest.ExperiBank:id/usernameTextField").sendKeys("company");;
		ad.findElementById("com.experitest.ExperiBank:id/passwordTextField").sendKeys("company");
		ad.findElementById("com.experitest.ExperiBank:id/loginButton").click();
		
		String balance = ad.findElementById("com.experitest.ExperiBank:id/balanceWebView").getText();
		System.out.println("Balance is - "+balance);
		
		ad.findElementById("com.experitest.ExperiBank:id/makePaymentButton").click();
		
		ad.findElementById("com.experitest.ExperiBank:id/phoneTextField").sendKeys("12345");

		
	}

}
