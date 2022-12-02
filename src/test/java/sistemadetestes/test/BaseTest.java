package sistemadetestes.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BaseTest{
	
	protected static WebDriver driver;
	private static final String URL_BASE_GOOGLE = "https://www.google.com";
	private static final String URL_BASE_SISTEMA = "http://127.0.0.1:5500/sistema/login.html";
	// private static final String URL_BASE = "file:///home/esc/eclipse-workspace/selenium-lab/sistema/login.html";
	private static final String PATH_DRIVE = "src/test/resources/chromedriver";
	
	@BeforeClass()
	public static void iniciar() {
		
		System.setProperty("webdriver.chrome.driver", PATH_DRIVE);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(URL_BASE_SISTEMA);
		
	}
	
	@AfterClass
	public static void finalizar() {
		driver.quit();
	}
	
}