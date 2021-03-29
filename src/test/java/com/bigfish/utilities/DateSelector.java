package com.bigfish.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DateSelector {

    public static void selectDate(WebDriver driver, String date, String datePickerValue) throws Exception {
        
//		try {
//			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//			driver.findElement(By.xpath("//input[@id='start_dts']")).click();
//		} catch (Exception e) {
//			try {
//				driver.findElement(By.xpath("//input[@id='apply_by_dts']")).click();
//			} catch (Exception e1) {
//				driver.findElement(By.xpath("//input[@id='event_dts']")).click();
//			}
//		}finally{
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		}
        Thread.sleep(2000);
        switch (datePickerValue){
            case "start_dts": driver.findElement(By.xpath("//input[@id='start_dts']")).click(); break;
            case "apply_by_dts": driver.findElement(By.xpath("//input[@id='apply_by_dts']")).click(); break;
            case "event_dts": driver.findElement(By.xpath("//input[@id='event_dts']")).click(); break;
            case "expected_payment_date": driver.findElement(By.xpath("//input[@id='expected_payment_date']")).click(); break;
            default:
                System.out.println("Invalid datepicker value provided");
        }
	
        String monthYearTextLocator = "//*[@class='datepicker-days']/table/thead/tr[2]/th[2]";
        String nextButton = "//*[@class='datepicker-days']/table/thead/tr[2]/th[3]";
        String allRowsLocator = "//*[@class='datepicker-days']/table/tbody/tr";
        String[] values = date.split(" ");
        String day = values[0];
        String monthYear = values[1] + " " + values[2];
        String monthYearOnCalendar = driver.findElement(By.xpath(monthYearTextLocator)).getText();
        System.out.println("day: " + day);
        System.out.println("monthyear: " + monthYear);
        System.out.println("monthyearoncalendar: " + monthYearOnCalendar);

        while(! monthYear.equals(monthYearOnCalendar)) {
            driver.findElement(By.xpath(nextButton)).click();
            monthYearOnCalendar = driver.findElement(By.xpath(monthYearTextLocator)).getText();

        }
        List<WebElement> allRows = driver.findElements(By.xpath(allRowsLocator));
        mainLoop:
        for (WebElement row: allRows) {
            List<WebElement> allCols = row.findElements(By.tagName("td"));
            for (WebElement col: allCols) {
                String dayInCol = col.getText();
                if(day.equals(dayInCol)){
                    String attr = col.getAttribute("class");
                    if(attr.equals("day") || attr.equals("active day")){
                        col.click();
                        break mainLoop;
                    }

                }
            }
        }
    }
}
