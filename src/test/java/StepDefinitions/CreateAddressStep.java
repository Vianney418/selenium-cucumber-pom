package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CreateAddressPage;

import java.time.Duration;

public class CreateAddressStep {
    private final CreateAddressPage createAddressPage;

    public CreateAddressStep() throws Exception{
        WebDriver driver = Hooks.driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        createAddressPage = new CreateAddressPage(driver, wait);
    }


    @Given("login to the jumbo website {string}")
    public void starBrowser (String url) {createAddressPage.goToWebpage(url);}

    @When("Click on: Select a delivery method")
    public void clickDeliveryMethodBtn() {createAddressPage.clickDeliveryMethodBtn();}

    @And("Click on: Create an address")
    public void clickAddressBtn() {createAddressPage.clickAddressBtn();}

    @And("Write address {string}")
    public void writeFormAddress(String txtAddress) {createAddressPage.writeAddressForm(txtAddress);}

    @And("Write house number {string}")
    public void addNumberHouse(String txtNumberHouse) {createAddressPage.addNumberHouse(txtNumberHouse);}

    @And("White name the address {string}")
    public void AddNameAddress (String txtNameAddress) {createAddressPage.AddNameAddress(txtNameAddress);}

    @And("White additional instructions {string}")
    public void addInstructions (String txtAddInstructions) {createAddressPage.addInstructions(txtAddInstructions);}

    @And("Click on: Add Address button")
    public void clickSaveBtn() {createAddressPage.clickSaveBtn();}

    @And("Select Added Address")
    public void selectAddAddress() {createAddressPage.selectAddAddress();}

    @And("Click on: the confirm button")
    public void clickConfirmBtn() {createAddressPage.clickConfirmBtn();}

    @Then("validate that the address is on the button {string}")
    public void validateDeliveryAddress(String txtResultadoEsperado){
        Assertions.assertEquals(txtResultadoEsperado, createAddressPage.validateDeliveryAddress());
    }

}
