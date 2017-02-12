package AdminPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Alex on 22.12.2016.
 */
public class TaxRegistryPage {
    TaxRegistryPage taxRegistryPage = new TaxRegistryPage();

    @FindBy (id = "ddd")
    private WebElement taxRadioButton;

}
