import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v109.emulation.model.DisplayFeature;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MaozTest {
	public static WebDriver driver;

	@BeforeTest()
	public void before_test() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://awtad.dev/auth/sign_in");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/form/div[2]/input"))
				.sendKeys("admin@maoz.com");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/form/div[3]/div[1]/input"))
				.sendKeys("Hh12@@12");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/form/button[2]")).click();

	}

	@Test()
	public void add_awners_for_all_blocks() throws InterruptedException, AWTException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// delete it when execute all test cases
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[2]/div/div/div[5]/div")).click();
		// delete it when execute all test cases

		Thread.sleep(5000);

		Thread.sleep(10000);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

		Thread.sleep(1000);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

		List<WebElement> blocks = driver.findElements(By.className("sc-khBlLl"));
		List<WebElement> pieces = driver.findElements(By.className("cPUntl"));

		int numOfBlocks = blocks.size();
		int numOfPieces = pieces.size();

		for (int i = 0; i < numOfBlocks; i++) {
			blocks.get(i).click();
			for (int k = 0; k < numOfPieces; k++) {
				pieces.get(k).click();
				Thread.sleep(1000);

				// add owner information
				// add owner information
				// add owner information
				// add owner information

				driver.findElement(
						By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div/div[1]/div/button[1]/div/div[1]"))
						.click(); // تحديد القسائم

				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

				
				//				if (((WebElement) pieces).isDisplayed()) {
//
//					System.out.println("Element is displayed: ");
//				} else {
//					System.out.println("Element is not displayed: ");
//				}
//
			}

		}

	}
}
