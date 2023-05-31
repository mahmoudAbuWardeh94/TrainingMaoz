import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.ClosingFuture.Peeker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MaozTestCases {
	public static WebDriver driver;

	@BeforeTest()
	public void before_test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/form/div[2]/input"))
				.sendKeys("admin@maoz.com");

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/form/div[3]/div[1]/input"))
				.sendKeys("Hh12@@12");

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/form/button[2]")).click();
	}

	@Test(priority = 0)
	public void create_plan() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[1]/div[2]/button")).click(); // create
																												// plan
		Thread.sleep(1000);
		// plan
		driver.findElement(
				By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[3]/div[2]/div[1]/div[1]/div[1]/input"))
				.sendKeys("plan1"); // plan name
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/input"))
				.sendKeys("222"); // plan number
		Thread.sleep(1000);

		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[3]/div[2]/div[2]/div/div/textarea"))
				.sendKeys("this is a new plan"); // plan details
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[3]/div[2]/div[3]/div/span/div/div"))
				.click();
		driver.findElement(By.id("react-select-2-input")).sendKeys("א" + Keys.ARROW_DOWN);
		driver.findElement(By.id("react-select-2-input")).sendKeys(Keys.ENTER);

		driver.findElement(
				By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[3]/div[2]/div[4]/div[1]/div[1]/input"))
				.sendKeys("mahmoud");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[3]/div[3]/button[1]")).click();
	}

	@Test(priority = 1)
	public void add_actors_admin() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[2]/div/div/a[2]/div")).click(); // tab_button
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[3]/div[2]/div[1]/button")).click(); // add_users_button
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[1]/input"))
				.sendKeys("Ali"); // first name
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div[2]/div[2]/div/input"))
				.sendKeys("Abu Ali"); // last name
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div[2]/div[3]/div/input"))
				.sendKeys("mahmoud.abuwardeh@nadsoft.net"); // email
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[3]/button[1]")).click();

		Thread.sleep(3000);
		// -------------------------------Admin----------------------------.

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[3]/div[2]/div[1]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[1]/input"))
				.sendKeys("awn"); // first name
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div[2]/div[2]/div/input"))
				.sendKeys("Abu awn"); // last name
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div[2]/div[3]/div/input"))
				.sendKeys("awn@gmail.net"); // email

		driver.findElement(By.className("sc-dIouRR")).click();

		driver.findElement(By.id("downshift-8-item-1")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[3]/button[1]")).click();
		Thread.sleep(3000);
		// --------------------------------------Editor---------------------.
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[3]/div[2]/div[1]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[1]/input"))
				.sendKeys("Sami"); // first name
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div[2]/div[2]/div/input"))
				.sendKeys("Abu Sami"); // last name
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div[2]/div[3]/div/input"))
				.sendKeys("Sami@gmail.net"); // email

		driver.findElement(By.className("sc-dIouRR")).click();

		driver.findElement(By.id("downshift-16-item-2")).click();

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[3]/button[1]")).click();
		Thread.sleep(2000);

	}

	@Test(priority = 2)
	public void addFactors() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("Group_2780")).click(); // tab
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[4]/div/div[1]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[3]/div/table/tbody/tr[1]/td[1]/div/input"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[3]/div/table/tbody/tr[2]/td[1]/div/input"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[4]/div/button")).click();

		driver.findElement(
				By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[4]/div/div[1]/div[2]/div/div[2]/div/input"))
				.sendKeys("1.1");
		driver.findElement(
				By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[4]/div/div[1]/div[3]/div/div[2]/div/input"))
				.sendKeys("1.5");

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[4]/div/div[2]/button")).click();
		driver.findElement(
				By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[4]/div/div[2]/div[2]/div[1]/div/input"))
				.sendKeys("foog aljabal");
		driver.findElement(
				By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[4]/div/div[2]/div[2]/div[2]/div/input"))
				.sendKeys("1.1");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[4]/div/div[2]/button")).click();
		driver.findElement(
				By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[4]/div/div[2]/div[3]/div[1]/div/input"))
				.sendKeys("t7t aljabal");
		driver.findElement(
				By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[4]/div/div[2]/div[3]/div[2]/div/input"))
				.sendKeys("1.5");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[5]/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[3]/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[5]/button[2]")).click();
		driver.findElement(By.className("sc-ivTmOn")).click();
		
	}

	
	
	@Test(priority = 3)
	public void add_wadkharej() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);

		// delete it for execution all test cases

//		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div[2]")).click();
		// delete it for execution all test cases

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[1]/nav/div[2]/div[3]/button")).click();// setting button
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/button[2]")).click(); //second item
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[2]/div/div/a[3]/div/p")).click();
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[3]/div/div[2]/a")).click(); // kharej
		

//		---------------------------------الوضع الخارج---------------------------
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[4]/div/div[1]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div[3]/div/table/tbody/tr[1]/td[1]/div/input"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div[3]/div/table/tbody/tr[2]/td[1]/div/input"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div[4]/div/button")).click();
		driver.findElement(
				By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[4]/div/div[2]/div[1]/div[2]/div/div/div/input"))
				.sendKeys("20");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[5]/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div[3]/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[5]/button[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div[3]/button[1]")).click();
		

	}

	@Test(priority = 4)
	public void add_map_gov() throws IOException, InterruptedException, AWTException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[2]/div[1]/div/label/div")).click();

		Robot rb = new Robot();
		StringSelection str = new StringSelection("C:\\Users\\Lenovo\\Desktop\\Maoz\\sampledxf.dxf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

	}

	@Test(priority = 4)
	public void search_blocks_items() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// lazm ashelha to execute all test cases
//		driver.findElement(By.className("sc-djUGQo")).click();
		Thread.sleep(5000);

		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		Thread.sleep(3000);
	
		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div[2]/main/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div/span/div/div"))
				.click();

		driver.findElement(By.id("react-select-2-input")).sendKeys("17530");
		Thread.sleep(1000);

		driver.findElement(By.id("react-select-2-input")).sendKeys(Keys.ENTER);
		driver.findElement(
				By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[3]/button"))
				.click();

		Thread.sleep(1000);

		driver.findElement(By.id("react-select-2-input")).sendKeys(Keys.DELETE);

		driver.findElement(
				By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[3]/button"))
				.click();
	}

	

	@Test(priority = 6)
	public void add_awners_for_all_blocks() throws InterruptedException, AWTException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// delete it when execute all test cases
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div[2]/div/div/div[1]/div")).click();
		// delete it when execute all test cases

		Thread.sleep(5000);

		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		Thread.sleep(5000);

		clicksAllBlocks();
		driver.findElement(By.className("sc-khBlLl")).click();

		pageUpThreeTimes();

		String[] firstName = { "Mahmoud", "Awnee", "Sami", "Abdullah", "Ali", "Ahmad", "Mohammed", "Hameed", "Ziad" };
		String[] secondName = { "Ahmad", "Osama", "Esmaeel", "Anas", "Hassan", "Belal", "Othman", "Tayseer", "Anas" };
		String[] familyName = { "Abu Mahmoud", "Abu Awnee", "Abu Sami", "Abu Abdullah", "Abu Ali", "Abu Ahmad",
				"AbuMohammed", "Abu Hameed", "Abu Ziad", "Abu Anas" };


        
		String[] idnumber = { "1411191131", "0030770000", "2139272222", "3334334333", "6139646666", "1137244784",
				"1201478341", "1478145434", "1031955065", "1233614787", "1314610240", "7839110147", "1233685421",
				"9696297351", "1245430236", "1831973258", "4731964177", "0346414487", "0234028152" };

		List<WebElement> pieces = driver.findElements(By.className("sc-fDwvOK"));
		
		System.out.println("***********");
		System.out.println(pieces.size());

		System.out.println("***********");
		


		Random random = new Random();
		int indexOfFirstName = random.nextInt(8);
		int indexOfSecondName = random.nextInt(8);
		int indexOfFamilyName = random.nextInt(8);
		int indexIdNumber = random.nextInt(18);
		
		Thread.sleep(1000);

		
		long randomNumber = (long) (random.nextInt() * Math.pow(10, 10));

        System.out.println("Random Number: " + randomNumber);
        
		for (int k = 0; k < pieces.size(); k++) {
			pieces.get(k).click();
			
			System.out.println("TTTEXT");
			System.out.println(pieces.get(k).getText());
			System.out.println("TTTEXT");


			Thread.sleep(1000);
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
			Thread.sleep(1000);

			driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div[2]/main/div[2]/div/div/div[2]/div[2]/div[2]/div[5]/div/div[1]/button"))
					.click();

			driver.findElement(
					By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[1]/div/div/input"))
					.sendKeys(firstName[indexOfFirstName]); // firstname
			driver.findElement(
					By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/input"))
					.sendKeys(secondName[indexOfSecondName]); // fathername
			driver.findElement(
					By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[3]/div/div/input"))
					.sendKeys(familyName[indexOfFamilyName]); // lastname
			driver.findElement(
					By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[4]/div/div/input"))
					.sendKeys(idnumber[indexIdNumber]); // ID number
			driver.findElement(By.className("sc-fIavCj")).sendKeys("1");

			driver.findElement(By.className("sc-fIavCj")).sendKeys(Keys.TAB + "1");
			driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div[2]/div[3]/div[1]/div/input"))
					.sendKeys("0599587898");
			driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[3]/button[1]")).click();
			Thread.sleep(2000);

			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div[2]/div/div/div[1]/div/button[1]/div/div[1]"))
					.click();
			Thread.sleep(2000);
			clicksAllBlocks();
			Thread.sleep(2000);

			pageUpTwoTimes();
		}
	}

	@Test(priority = 7)
	public void search_plans() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//*[@id=\"Group_99\"]")).click(); // logo button

		driver.findElement(By.id("downshift-0-input")).click();
		driver.findElement(By.id("downshift-0-input")).sendKeys("if");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"downshift-0-toggle-button\"]/button")).click();
		Thread.sleep(1000);

	}

	private static void pageUpThreeTimes() throws AWTException, InterruptedException {
		Thread.sleep(1000);
		Robot upThree = new Robot();
		upThree.keyPress(KeyEvent.VK_PAGE_UP);
		upThree.keyRelease(KeyEvent.VK_PAGE_UP);
		Thread.sleep(500);

		upThree.keyPress(KeyEvent.VK_PAGE_UP);
		upThree.keyRelease(KeyEvent.VK_PAGE_UP);
		Thread.sleep(500);

		upThree.keyPress(KeyEvent.VK_PAGE_UP);
		upThree.keyRelease(KeyEvent.VK_PAGE_UP);
	}

	private static void pageUpTwoTimes() throws AWTException, InterruptedException {
		Robot upThree = new Robot();
		upThree.keyPress(KeyEvent.VK_PAGE_UP);
		upThree.keyRelease(KeyEvent.VK_PAGE_UP);

		Thread.sleep(500);
		upThree.keyPress(KeyEvent.VK_PAGE_UP);
		upThree.keyRelease(KeyEvent.VK_PAGE_UP);
	}

	private static void pageDownTwoTimes() throws AWTException {
		Robot upThree = new Robot();
		upThree.keyPress(KeyEvent.VK_PAGE_DOWN);
		upThree.keyRelease(KeyEvent.VK_PAGE_DOWN);

		upThree.keyPress(KeyEvent.VK_PAGE_DOWN);
		upThree.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}

	private static void pageDownThreeTimes() throws AWTException {
		Robot upThree = new Robot();
		upThree.keyPress(KeyEvent.VK_PAGE_DOWN);
		upThree.keyRelease(KeyEvent.VK_PAGE_DOWN);

		upThree.keyPress(KeyEvent.VK_PAGE_DOWN);
		upThree.keyRelease(KeyEvent.VK_PAGE_DOWN);

		upThree.keyPress(KeyEvent.VK_PAGE_DOWN);
		upThree.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}

	private static void clicksAllBlocks() {
		List<WebElement> blocks = driver.findElements(By.className("sc-khBlLl"));

		for (int i = 0; i < blocks.size(); i++) {

			blocks.get(i).click();
			System.out.println(blocks.get(i).getText());

		}
	}
}
