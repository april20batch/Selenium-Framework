package SSquareIT.stepDefinitions;

import static testComponenets.BaseTest.driver;

import java.io.IOException;

import org.testng.Assert;

import SSquareIT.SeleniumFramework.CartPage;
import SSquareIT.SeleniumFramework.CheckOutPage;
import SSquareIT.SeleniumFramework.HomePage;
import SSquareIT.SeleniumFramework.LandingPage;
import SSquareIT.SeleniumFramework.LoginPage;
import SSquareIT.SeleniumFramework.ProductDetails;
import SSquareIT.SeleniumFramework.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testComponenets.BaseTest;

public class E2ESteps extends BaseTest {

	LoginPage login;
	HomePage hp;
	ProductPage pp;
	CheckOutPage checkOutPage;

	@Given("Navigate to baseUrl")
	public void Navigate_to_baseUrl() throws IOException {
		initBrowser();
		LandingPage lp = new LandingPage(driver);
		login = lp.NavigateToLoginPage();
	}

	@Given("^Login with username (.+) and password (.+)$")
	public void Login_with_username_and_password(String name, String password) {
		hp = login.LoginAction(name, password);
	}

	@When("^added product (.+) to cart and checkout$")
	public void added_product_to_cart_and_checkout(String product) {
		pp = hp.clickOnCameraTab();
		ProductDetails productDetails = pp.addProductToCart(product);
		Assert.assertEquals(productDetails.getPrice(), "$98.00");
		CartPage cartPage = productDetails.setQuantity("2");
		checkOutPage = cartPage.goToCheckOutPage();
		checkOutPage.clickToCheckOut();
	}

	@Then("verify the details {string}")
	public void verify_the_details(String string) {
		checkOutPage.closeErrorMessage();
		boolean isSuccess = checkOutPage.getSuccessMessage().equalsIgnoreCase("***");
		Assert.assertTrue(isSuccess);
		tearDown();
	}

}
