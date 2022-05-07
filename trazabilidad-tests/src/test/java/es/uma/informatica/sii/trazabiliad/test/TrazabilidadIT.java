package es.uma.informatica.sii.trazabiliad.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
// Generated by Selenium IDE
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TrazabilidadIT {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	private static String baseURL;

	@BeforeClass
	public static void setupClass() {
		String server="localhost";
		try (InputStream is = TrazabilidadIT.class.getClassLoader().getResourceAsStream("pom.properties")) {
			Properties pomProperties = new Properties();
			pomProperties.load(is);
			server=pomProperties.getProperty("server.host");
		} catch (IOException e) {
			e.printStackTrace();
		}
		baseURL="http://"+server+":8080/trazabilidad-war/";
	}

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}
	@After
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void inicio() {
		driver.get(baseURL);
		driver.manage().window().setSize(new Dimension(1280, 777));
		driver.findElement(By.cssSelector("h1")).click();
		driver.findElement(By.cssSelector("h1")).click();
		{
			WebElement element = driver.findElement(By.cssSelector("h1"));
			Actions builder = new Actions(driver);
			builder.doubleClick(element).perform();
		}
		assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Hola mundo"));
	}
}
