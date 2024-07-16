package com.TestCases;
import com.Utilities.ReadConfig;
import com.aventstack.extentreports.utils.FileUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseClass {

    ReadConfig readconfig = new ReadConfig();
    public String baseURL = readconfig.getApplicationURL();
    public String username = readconfig.getUsername();
    public String password = readconfig.getPassword();
    public static WebDriver driver;
    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(String br){
        logger = Logger.getLogger("autoTesting");
        PropertyConfigurator.configure("log4j.properties");

        if(br.equals("chrome")){
        System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
//        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();

        } else if (br.equals("firefox")) {
            System.setProperty("webdriver.firefox.driver",readconfig.getChromepath());
            driver =new FirefoxDriver();
        } else if (br.equals("edge")) {
            System.setProperty("webdriver.edge.driver",readconfig.getEdgepath());
            driver =new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
        logger.info("URL is opened");
        }

        @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public  void captureScreenshot(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
        FileUtils.copyFile(source, target);
        System.out.println("screenshot taken");
    }
    public static String randomString(){
        String genratedString = RandomStringUtils.randomAlphabetic(8);
        return(genratedString);
    }
    public static String randomNum() {
        String genratedNumber = RandomStringUtils.randomNumeric(6);
        return (genratedNumber);
    }
}