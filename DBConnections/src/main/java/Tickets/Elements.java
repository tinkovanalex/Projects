package Tickets;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Alex on 19.01.2017.
 */
public class Elements {

        Elements elements = new Elements();

        @FindBy(xpath = "//div[@id='stations_from' and @klass='autosuggest']")
        private WebElement autosuggest;
}
