package stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.EmailUtility;
import utils.HelperUtility;
import utils.LogHelper;
import utils.ReportGenerator;
import utils.Root;

public class Hooks extends Root {
    public static ExtentReports extentreports;
    public static ExtentTest extentTest;
    public HelperUtility helper;

    @Before
    public void preConditions(Scenario sc) {
        if (driver == null || driver.toString().contains("null")) {
            launchBrowser();
            this.helper = new HelperUtility(driver);
            extentTest = extentreports.createTest(sc.getName());
        }

    }

    @BeforeAll
    public static void generateReport() {
        extentreports = ReportGenerator.generateExtentReport("madeinchina");

    }

    @After
    public void postConditions() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterAll
    public static void deleteReport() {
        extentreports.flush();
        // String reportPath=Root.prop.getProperty("reportPath");
        // String receipentEmail=Root.prop.getProperty("receiverEmail1");
        // EmailUtility.sendEmailWithReport(reportPath, receipentEmail);
        // LogHelper.info("Email sent successfully !");
    }

}
