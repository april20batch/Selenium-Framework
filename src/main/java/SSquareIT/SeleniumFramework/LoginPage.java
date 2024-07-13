package SSquareIT.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	static WebDriver driver;
	
//	driver.findElement(By.id("input-email")).sendKeys("kidovo5318@em2lab.com");
//	driver.findElement(By.id("input-password")).sendKeys("QAFOX@123");
//	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	@FindBy(id = "input-email")
	private WebElement username;
	
	@FindBy(id = "input-password")
	private WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage LoginAction(String userEmail, String userPassword) {
		username.sendKeys(userEmail);
		password.sendKeys(userPassword);
		submitButton.click();
		HomePage hp = new HomePage(driver);
		return hp;
	}

}
