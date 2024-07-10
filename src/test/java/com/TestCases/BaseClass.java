package com.TestCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    public String baseURL = "https://www.naukrigulf.com/";
    public String username = "tejatalam1994@gmail.com";
    public String password = "Teja@15517";
    public static WebDriver driver;

    @BeforeClass
    public void setup(String br){
        if(br.equals("chrome")){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
        driver =new ChromeDriver();
    }   else if (br.equals("firefox")) {
            System.setProperty("webdriver.firefox.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
            driver =new FirefoxDriver();
        } else if (br.equals("edge")) {
            System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"//Drivers//msedgedriver.exe");
            driver =new EdgeDriver();
        }
        }

        @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
