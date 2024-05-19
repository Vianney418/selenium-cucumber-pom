package definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginDefinition {
    private final LoginPage loginPage;
	private final HomePage homePage;
	
	public LoginDefinition() throws Exception {
        WebDriver driver = Hooks.driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		loginPage = new LoginPage(driver, wait);
		homePage = new HomePage(driver, wait);
	}

	@Given("User is on login page {string}")
	public void loginPage(String url) {
		loginPage.goToWebpage(url);
		Assert.assertTrue(loginPage.verifyOnLoginPage());
	}

	@When("^User submit email and password$")
	public void submitEmailPassword() {
		loginPage.loginToSite("standard_user", "secret_sauce");
	}

	@Then("^User should be able to login sucessfully and new page open$")
	public void successLogin() {
		Assert.assertTrue(homePage.verifyOnHomePage());
	}
}
