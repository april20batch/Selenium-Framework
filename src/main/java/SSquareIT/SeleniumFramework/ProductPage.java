package SSquareIT.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BasePageClass;


public class ProductPage extends BasePageClass {
	
	static WebDriver driver;
	
	@FindBy(css = "div.product-grid")
	private List<WebElement> products;
	
	By producLocation =  By.cssSelector("div h4");
	By cartProduct = By.cssSelector("a");

	
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public List<WebElement> getProducts() {
		visibilityOfElementLocated(producLocation);
		return products;
	}
	
	public WebElement getProductByName(String prodName) {
		WebElement prodCamera = null;
		for(WebElement product: products) {
			WebElement targetProduct = product.findElement(producLocation);
			String productName = targetProduct.getText();
			System.out.println(productName);
			if(productName.equalsIgnoreCase(prodName)) {
				prodCamera = targetProduct.findElement(cartProduct);
				return prodCamera;
			}
		}
		return prodCamera;
	}
	
	public ProductDetails addProductToCart(String prodName) {
		WebElement prod = getProductByName(prodName);
		prod.click();	
		ProductDetails productDetails = new ProductDetails(driver);
		return productDetails;
	}
	

}
