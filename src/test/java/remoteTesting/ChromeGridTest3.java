package remoteTesting;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeGridTest3 {

    @Test
    public void test3() throws MalformedURLException {
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        URL url = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, cap);
        driver.get("https://www.bbc.co.uk/");
        System.out.println(driver.getTitle());
        driver.quit();
    }


}
