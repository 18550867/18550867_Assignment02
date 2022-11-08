package First_framework;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Testcase4 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "E:\\HomeWork\\Java\\giz\\Libraries\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testRegister() throws Exception {
    driver.get("http://demo.actitime.com/");
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("pwd")).click();
    driver.findElement(By.name("pwd")).clear();
    driver.findElement(By.name("pwd")).sendKeys("manager");
    driver.findElement(By.name("userSelectorButton")).click();
    new Select(driver.findElement(By.name("userName"))).selectByVisibleText("Moreno, Andrew");
    driver.findElement(By.name("fromDateSelector")).click();
    new Select(driver.findElement(By.name("fromDateSelector"))).selectByVisibleText("Nov 07");
    driver.findElement(By.name("fromDateSelector")).click();
    new Select(driver.findElement(By.name("fromDateSelector"))).selectByVisibleText("Nov 13");
    driver.findElement(By.linkText("new")).click();
    new Select(driver.findElement(By.linkText("new"))).selectByVisibleText("New");
    driver.findElement(By.name("searchItemList")).click();
    new Select(driver.findElement(By.name("searchItemList"))).selectByVisibleText("Galaxy Corporation");
    driver.findElement(By.name("searchItemList")).click();
    new Select(driver.findElement(By.name("searchItemList"))).selectByVisibleText("Android Testing");
    driver.findElement(By.name("taskname")).click();
    driver.findElement(By.name("taskname")).clear();
    driver.findElement(By.name("taskname")).sendKeys("Create Meeting");
    driver.findElement(By.name("estimate")).click();
    driver.findElement(By.name("estimate")).clear();
    driver.findElement(By.name("estimate")).sendKeys("100:00");
    driver.findElement(By.id("deadline")).click();
    new Select(driver.findElement(By.id("deadline"))).selectByVisibleText("Nov 11");
    driver.findElement(By.id("type")).click();
    new Select(driver.findElement(By.id("type"))).selectByVisibleText("Engineering");
    driver.findElement(By.name("createTask")).click();
    driver.findElement(By.linkText("SubmitTTButton")).click();
    driver.findElement(By.linkText("logoutLink")).click(); 
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
