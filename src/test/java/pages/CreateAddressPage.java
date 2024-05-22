package pages;

import Utils.BaseDriverClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAddressPage extends BaseDriverClass {

    @FindBy(xpath = "//button[@class='delivery-container-desktop']")
    WebElement btnDeliveryMethod;

    @FindBy(xpath = "//a[@class='new-link'][.='crea una dirección']")
    WebElement btnAddress;

    @FindBy(xpath = "//input[contains(@placeholder,'Calle y número, comuna o referencia')]")
    WebElement inputStreetAndNumber;

    @FindBy(xpath = "//div[@class='pac-item']/span[@class='pac-item-query']\n")
    WebElement btnFirstSuggestion;

    @FindBy(xpath = "//input[contains(@placeholder,'Ej: 208')]")
    WebElement inputHouseNumber;

    @FindBy(xpath = "//input[contains(@placeholder,'Ej: casa mamá')]")
    WebElement inputNameAddress;

    @FindBy(xpath = "//textarea[contains(@type,'text')]")
    WebElement inputInstructions;

    @FindBy(xpath = "//button[contains(.,'Agregar dirección')]")
    WebElement btnSave;

    @FindBy(xpath = "(//input[contains(@class,'input-radio-button')])[1]")
    WebElement inputRadioButton;

    @FindBy(xpath = "//button[contains(.,'Confirmar')]")
    WebElement btnConfirm;

    @FindBy(xpath = "//p[@class='deliver-address'][contains(.,'Bombero Guillermo Greb...')]")
    WebElement getBtnDelivery;

    public CreateAddressPage(WebDriver driver, WebDriverWait wait) {
        super (driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void goToWebpage(String url) {redirectTo(url);}

    public void clickDeliveryMethodBtn() { btnDeliveryMethod.click();}

    public void clickAddressBtn() {btnAddress.click();}

    public void writeAddressForm(String txtAddress) {
        inputStreetAndNumber.click();
        inputStreetAndNumber.sendKeys(txtAddress);
        btnFirstSuggestion.click();
        pressEnterKey();
    }

    public void addNumberHouse(String txtNumberHouse){
        inputHouseNumber.click();
        inputHouseNumber.sendKeys(txtNumberHouse);
    }

    public void AddNameAddress(String txtNameAddress){
        inputNameAddress.click();
        inputNameAddress.sendKeys(txtNameAddress);
    }

    public void addInstructions(String txtAddInstructions){
        inputInstructions.click();
        inputInstructions.sendKeys(txtAddInstructions);
    }

    public void clickSaveBtn (){
        btnSave.click();
    }

    public void selectAddAddress(){
        inputRadioButton.click();
    }

    public void clickConfirmBtn() {
        btnConfirm.click();
    }

    public String validateDeliveryAddress(){
        waitUntilElementVisible(getBtnDelivery);
        return getBtnDelivery.getText();
    }


}
