package SwagLabs;

import SwagLabs.Pages.Home_Page;
import SwagLabs.Pages.Login_Page;
import SwagLabs.Test_Case.Home_Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Base_Class {
    public static WebDriver WDrver;
    public XSSFWorkbook xbook;
    public XSSFSheet xsheet;
    public static String UserValue, PassValue;
    public static Home_Page HP;


    // @AfterMethod(alwaysRun = true)

    @BeforeMethod(groups = {"products"})
    public void InitialSetup() {
        WDrver = new ChromeDriver();
        WDrver.get("https://www.saucedemo.com/v1/index.html");
        WDrver.manage().window().maximize();
        WDrver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @AfterMethod(groups = {"products"})
    public void tearDown() throws Exception
    {
        Thread.sleep(2000);
        WDrver.quit();
    }
    public void Tsleep()throws Exception
    {
        Thread.sleep(1000);
    }
    public void fetch_data(int Uvalue, int PValue) {
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("UDetail.csv"));
            while ((line = br.readLine()) != null) {
                String[] employee = line.split(splitBy);
                UserValue = employee[Uvalue];
                PassValue = employee[PValue];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}