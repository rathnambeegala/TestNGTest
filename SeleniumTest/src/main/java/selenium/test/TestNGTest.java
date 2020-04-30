package selenium.test;

import java.lang.ref.PhantomReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;


public class TestNGTest {

	@Test
	public void downloadFile() throws Exception {
		WebDriver driver=null;
		System.setProperty("webdriver.chrome.driver", "./browsers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.prompt_for_download", false);
		prefs.put("download.default_directory", "C:\\Users\\SHYAM ALLAM\\Documents\\Delete");
		
		options.setExperimentalOption("prefs", prefs);
		
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));    
		
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();


		driver.get("https://chromedriver.storage.googleapis.com/index.html?path=79.0.3945.36/");
		Thread.sleep(2000);
		WebElement btnDownload = driver.findElement(By.xpath(".//a[text()='chromedriver_win32.zip']"));
		//btnDownload.click();
		
		Thread.sleep(7000);
		driver.quit();
	}
	
	@Test
	public void headLessBrowser() throws Exception {
		WebDriver driver=null;
		System.setProperty("phantomjs.binary.path", "./browsers\\phantomjs.exe");
		driver = new PhantomJSDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.quit();
	}
	
	@Test
	public void scrollUpAndDown() {
		WebDriver driver=null;
		System.setProperty("webdriver.chrome.driver", "./browsers/chromedriver.exe");
		driver = new ChromeDriver();
		Dimension d = new Dimension(300,700);
		driver.manage().window().setSize(d);
		
		driver.get("https://www.amazon.in/");
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,1000)");
		 js.executeScript("window.scrollBy(1000,0)");
		 driver.quit();
	}
}
