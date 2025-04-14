package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class ScreenCapture {
   public static TakesScreenshot ts;

   /**
    * Description: Handle the execution of Screenshot
    * Author: Suhansh Bagre
    * @param elementLocator
    * @param fileName
    * @return
    */
   public static String executeScreenShot(String filename, File file) {
      try {
         String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
         String name = "/" + filename + timestamp + ".png";
         File target = new File(System.getProperty("user.dir") + "/screenshots");
         if (!target.exists()) {
            target.mkdirs();
         }
         FileHandler.copy(file, new File(target.toString() + name));
         return "." + name;
      } catch (Exception e) {
         LogHelper.error(e.getMessage());
      }
      return null;
   }
   
   /**
    * Description: take screenshot of the whole page
    * Author: suhansh bagre
    * @param filename
    * @return
    */
   public static String takePageScreenShot(String filename) {
      TakesScreenshot ts = (TakesScreenshot) Root.driver;
      File file = ts.getScreenshotAs(OutputType.FILE);
      return executeScreenShot(filename, file);
   }

  
   public static String takeElementScreenShot(By elementLocator, String fileName) {
      WebElement elementParam = Root.driver.findElement(elementLocator);
      File file = elementParam.getScreenshotAs(OutputType.FILE);
      return executeScreenShot(fileName, file);
   }

  

}