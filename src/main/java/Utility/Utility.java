package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class Utility extends TestBase{
	
	public static String readPropertyFile(String value) throws Exception {
		Properties p = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\amard\\eclipse-workspace2\\Project2\\TestData\\config.properties");
		p.load(file);
		return p.getProperty(value);
	}
	public static String readExcelData(int row, int col) throws Exception {
		FileInputStream file = new FileInputStream("C:\\Users\\amard\\eclipse-workspace2\\Project2\\TestData\\Data1.xlsx");
		org.apache.poi.ss.usermodel.Sheet excel = WorkbookFactory.create(file).getSheet("Sheet1");
		String value= excel.getRow(row).getCell(col).getStringCellValue();
		return value;
	}
	
	public static void selectClass(WebElement element, String option) {
		Select s = new Select(element);
		s.selectByVisibleText(option);
	}
	
	public static void captureScreenshot(String name) throws Exception {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\amard\\eclipse-workspace2\\Project2\\Screenshot/"+name+".jpeg");
		
		FileHandler.copy(source, dest);
	}
	

}
