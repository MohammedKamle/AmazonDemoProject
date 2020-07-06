package com.amazon.general;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	protected AppiumDriverLocalService service;
	protected  AndroidDriver<AndroidElement> driver;

	@BeforeClass()
	public void beforeClass() throws IOException, InterruptedException {
		service = startServer();
		driver = capabilities("AmazonApp");
	}

	public AppiumDriverLocalService startServer() {
		boolean flag = checkIfServerIsRunnning(4723);
		if (!flag) {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}

	public  AndroidDriver<AndroidElement> getDriver() {
		return driver;
	}

	public static void startEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime()
				.exec(System.getProperty("user.dir") + "\\src\\main\\java\\com\\resources\\startEmulator.bat");
		Thread.sleep(6000);
	}

	public static boolean checkIfServerIsRunnning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		AndroidDriver<AndroidElement> driver;
		File appDir = new File("src");
		File app = new File(appDir, (String) prop.get(appName));
		String device = (String) prop.get("deviceName");
		if (device.contains("emulator")) {
			startEmulator();
		}
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("udid", prop.get("udid"));
		capabilities.setCapability("appPackage", prop.get("appPackage"));
		capabilities.setCapability("appActivity", prop.get("appActivity"));
		driver = new AndroidDriver<>(new URL((String) prop.get("url")), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}


	@AfterClass()
	public void afterClass() {
		service.stop();
	}
}
