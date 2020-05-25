package remoteTesting;


import com.google.common.collect.Streams;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ChromeGridTest1 {

    @BeforeTest
    public void startDocker() throws IOException, InterruptedException {
        StartDocker start = new StartDocker();
        start.startDockerStart();
    }

    @Test
    public void test1() throws MalformedURLException {

        //With platform
//        DesiredCapabilities dc = new DesiredCapabilities();
//        dc.setPlatform(Platform.WINDOWS);
//        dc.setBrowserName("Chrome");

        DesiredCapabilities cap = DesiredCapabilities.chrome();
        URL url = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, cap);
        driver.get("http://google.com");
        System.out.println(driver.getTitle());
        driver.quit();

        Long intStream = Stream.of(1, 2, 3, 4).filter(integer -> integer > 2).count();
    }

    @AfterTest
    public void stopDocker() throws IOException, InterruptedException {
        StopDocker stop = new StopDocker();
        stop.stopFile();
    }

}
