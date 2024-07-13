package SSquareIT.SeleniumFramework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testComponenets.BaseTest;

public class E2ETest2 extends BaseTest {
	
	@Test(dataProvider = "getData")
	public void endToEndTest(String username, String password) throws IOException {
		WebDriver driver = initBrowser();
		LandingPage lp = new LandingPage(driver);
		LoginPage login = lp.NavigateToLoginPage();
		HomePage hp = login.LoginAction(username, password);
		ProductPage pp = hp.clickOnCameraTab();
		ProductDetails productDetails = pp.addProductToCart("Nikon D300");
		Assert.assertEquals(productDetails.getPrice(), "$98.00");
		CartPage cartPage = productDetails.setQuantity("2");
//		Assert.assertEquals(cartPage.getPrice(), "$196.00");
		CheckOutPage checkOutPage = cartPage.goToCheckOutPage();
		checkOutPage.clickToCheckOut();
		checkOutPage.closeErrorMessage();
		boolean isSuccess = checkOutPage.getSuccessMessage().equalsIgnoreCase("***");
		Assert.assertTrue(isSuccess);
		tearDown();

	}
	
	@DataProvider(name="getData")
	public Object[][] getData() {
		return new Object[][] {
			{"kidovo5318@em2lab.com", "QAFOX@123"},
			{"xejevo6745@devncie.com", "Xeje@123"}};
	}
	

}
