package utilities;

import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTime extends DriverUntility{
    public static WebDriverWait wait = new WebDriverWait(driver,30);
}
