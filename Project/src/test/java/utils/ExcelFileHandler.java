package utils;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelFileHandler {
    public static XSSFWorkbook workbook;
   
    /**
     * Author: Raja
     * Description: Return data present inside cell based on cell location
     * @param excelPath
     * @param sheetName
     * @param rowNumber
     * @param cellNumber
     * @return
     */
    public static String getCellData(String excelPath,String sheetName,int rowNumber,int cellNumber){
        try{
        FileInputStream file=new FileInputStream(excelPath);
        workbook=new XSSFWorkbook(file);
        XSSFSheet sheet=workbook.getSheet(sheetName);
        XSSFRow row=sheet.getRow(rowNumber);
        XSSFCell cell=row.getCell(cellNumber);
        return cell.toString();
    }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
}
    }

 