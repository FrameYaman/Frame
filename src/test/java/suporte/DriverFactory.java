package suporte;

import static suporte.Runner.getDriver;
import static suporte.Runner.initDriver;
import static suporte.Runner.threadDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	
	public static WebDriver driver;
	
	private DriverFactory() {
		
	}
	
	public static void iniciaDriver() {
		//driver = new InternetExplorerDriver();
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//@AfterClass
	public static void fecharDriver() {
		WebDriver driver = initDriver();
		if (driver != null) {
			driver.quit();
			driver = null;
		}
		if (threadDriver != null) {
			threadDriver.remove();
		}
	}
}
