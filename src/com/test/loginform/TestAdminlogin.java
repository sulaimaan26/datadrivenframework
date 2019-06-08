package com.test.loginform;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.learndatadriven.Xls_Reader;

public class TestAdminlogin {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		System.setProperty("webdriver.chrome.driver","/home/epage/eclipse-workspace/Learndatadriven/chromedriver");
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.retrafinance.com/admin/customer");
		Xls_Reader reader=new Xls_Reader("/home/epage/eclipse-workspace/Learndatadriven/src/Com/testdat/logincredentials.xlsx");
		String email=reader.getCellData("Sheet1","email",2);
		String password=reader.getCellData("Sheet1","password",2);
	
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		System.out.println(driver.getTitle());
		driver.close();

	}

}
