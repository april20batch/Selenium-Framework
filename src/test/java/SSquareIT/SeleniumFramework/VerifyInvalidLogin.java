package SSquareIT.SeleniumFramework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testComponenets.BaseTest;
import testComponenets.RetryTest;

public class VerifyInvalidLogin extends BaseTest {
	
	@Test
	public void verifyLoginWithInvalidCreds() throws IOException {
		WebDriver driver = initBrowser();
		LandingPage lp = new LandingPage(driver);
		LoginPage login = lp.NavigateToLoginPage();
		HomePage hp = login.LoginAction("vo5318@em2lab.com", "FOX@123");
		SoftAssert sa = new SoftAssert();
		String actual = driver.getCurrentUrl();
		String expected = "https://tutorialsninja.com/demo/index.php?route=account/account";
		sa.assertEquals(actual, expected);
		tearDown();
		sa.assertAll();
	}

}
