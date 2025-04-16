package utils;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.TimeZone;

 
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
 
 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
 
 
public class ReportGenerator extends Root {
    public static TakesScreenshot ts;
 
    private static Properties prop;
    private static ExtentReports extentReport;
 
    /**
     * Description: Generates an extent report
     * Author: Radhika
     * @param reportName
     * @return
     */
    public static ExtentReports generateExtentReport(String reportName) {
        if (extentReport == null) {
            extentReport = createReport(reportName);
        }
        return extentReport;
    }
 
    /**
     * Description: Creates an extent report
     * Author: Radhika
     * @param reportName
     * @return
     */
    private static ExtentReports createReport(String reportName) {
        ExtentReports extentReport = new ExtentReports();
 
        String filepath = System.getProperty("user.dir") + "/config/browser.properties";
        try {
            FileInputStream file = new FileInputStream(filepath);
            prop = new Properties();
            prop.load(file);
        } catch (Exception e) {
            LogHelper.error(e.getMessage());
        }
 
 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        TimeZone istTimeZone = TimeZone.getTimeZone("Asia/Kolkata"); // IST timezone
        dateFormat.setTimeZone(istTimeZone);
 
   
        String reportFilePath = System.getProperty("user.dir") + "/reports/";
        if (reportName == null || reportName.isEmpty()) {
            reportName = "Test Report";
        }
        reportFilePath += reportName + ".html";
 
        File extentReportFile = new File(reportFilePath);
 
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
 
        sparkReporter.config().setTimeStampFormat("yyyy.MM.dd.HH.mm.ss");
 
        extentReport.attachReporter(sparkReporter);
 
 
        return extentReport;
    }
 
    /**
     * Description: Captures the screenshot for attaching it to the report
     * Author: Radhika
     * @param filename
     * @return
     */  
    public static String captureScreenShot(String filename) {
        ts = (TakesScreenshot) driver;
        String file = ts.getScreenshotAs(OutputType.BASE64);
        return file;
    }
 
    /**
     * Description: Attaches the screenshot to report
     * Author: Radhika
     * @param filename
     * @param test
     * @param description
     */
    public static void addScreenshotToReport(String filename, ExtentTest test, String description) {
        try {
            test.log(Status.PASS, description, MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreenShot(filename)).build());
        } catch (Exception e) {
            LogHelper.error(e.getMessage());
        }
   
   
    }
 
} 
