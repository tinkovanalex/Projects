package AdminPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Alex on 23.12.2016.
 */
public class LoginPage {
    LoginPage loginPage = new LoginPage();

    @FindBy (id = "loginForm:j_username")
    private WebElement loginField;

    @FindBy (id = "loginForm:j_password")
    private WebElement passwordField;

    @FindBy (id = "loginForm:submitForm")
    private WebElement loginButton;

}
