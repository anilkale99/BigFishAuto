package com.bigfish.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableUtilites {
	
	TableUtilites table;
	int tableIndex;
	String tableLoc;
		
	public TableUtilites(int i){
		tableIndex = i;
		tableLoc = "//table["+i+"]";
	}
	
	public int getTableRowsCount(WebDriver driver){
		List<WebElement> rows = driver.findElements(By.xpath(tableLoc+"//tr"));
		return rows.size();
	}
	
	public int getTableColsCount(WebDriver driver){
		List<WebElement> rows = driver.findElements(By.xpath(tableLoc+"//tr[1]/td"));
		return rows.size();
	}
	
	public List<String> getTableColumnValuesByIndex(WebDriver driver, int colIndex){
		List<WebElement> eles = driver.findElements(By.xpath(tableLoc+"//tr//td["+colIndex+"]"));
		List<String> colValues = new ArrayList<String>();
		for (WebElement webElement : eles) {
			colValues.add(webElement.getText());
		}
		return colValues;
	}
	
	
	

}
