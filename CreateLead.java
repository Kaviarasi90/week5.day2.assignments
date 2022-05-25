package week5.day1;


	import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.ReadExcelData;

	public class CreateLead extends ProjectSpecificMethods{
		@Test(dataProvider = "testData")

		public void runCreateLead(String uname,String pwd,String Cname,String fname,String lname) {
			
			driver.findElement(By.id("username")).sendKeys(uname);
			driver.findElement(By.id("password")).sendKeys(pwd);
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(Cname);
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
			driver.findElement(By.name("submitButton")).click();
			//driver.close();
	}
		@DataProvider
		public String[][] testData() throws IOException {
			
			String[][] data = ReadExcelData.readData("tc001");
			return data;
		}
		
/*		@DataProvider
		public String[][] testData() {  
			String[][] array=new String[2][5];         //2d array created
			
			array[0][0]="DemoSalesManager";
			array[0][1]="crmsfa";
			array[0][2]="TestLeaf";
			array[0][3]="Hari";
			array[0][4]="R";
			
			array[1][0]="DemoCSR";
			array[1][1]="crmsfa";
			array[1][2]="TestLeaf";
			array[1][3]="Babu";
			array[1][4]="M";
			
			return array;
			
	}*/
}









