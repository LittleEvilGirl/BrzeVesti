package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrzeVestiPage extends AdminPage{
    
    
    BrzeVestiPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    
    public String getPanelTitle() {
        return driver.getTitle();
    }
    
}
