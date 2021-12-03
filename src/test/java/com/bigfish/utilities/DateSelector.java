package com.bigfish.utilities;

import com.bigfish.pom.common.BasePage;
import com.bigfish.pom.common.ContextSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DateSelector extends BasePage {
    WebDriver driver;
    public DateSelector(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    public static void selectDate(WebDriver driver, String date, String datePickerValue) throws Exception {

        Thread.sleep(2000);
        switch (datePickerValue){
            case "start_dts": driver.findElement(By.xpath("//input[@formcontrolname=\"startDate\"]")).click(); break;
            case "end_dts": driver.findElement(By.xpath("//input[@formcontrolname=\"endDate\"]")).click(); break;
            default:
                System.out.println("Invalid datepicker value provided");
        }
	
        String monthYearTextLocator = "//*[@class=\"bs-datepicker-head\"]//button";
        String nextButton = "//*[@class=\"bs-datepicker-head\"]//button[4]";
        String allRowsLocator = "//*[@class=\"bs-datepicker-body\"]/table/tbody/tr";
        String[] values = date.split(" ");
        String day = values[0];
        String monthYear = values[1] + " " + values[2];
        String monthYearOnCalendar = driver.findElement(By.xpath(monthYearTextLocator)).getText();
        System.out.println("day: " + day);
        System.out.println("monthyear: " + monthYear);
        System.out.println("monthoncalendar: " + monthYearOnCalendar );

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
