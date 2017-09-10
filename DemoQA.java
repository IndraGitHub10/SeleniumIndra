package Assignment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DemoQA {

	
	public static void setClipboardData(String string) {
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
	
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		
		//launch chrome brower and open the following webpage
		//int x=0;
		//while(x<10){
		 
		WebDriver driver=new ChromeDriver();
		String url="http://demoqa.com/";
		driver.get(url);
		driver.manage().window().maximize();
		
		//click on registration link
		WebElement register=driver.findElement(By.linkText("Registration"));
		register.click();
	   Thread.sleep(5000);
	    //Input First Name, last Name, Hobby
	  
		   
	    driver.findElement(By.name("first_name")).sendKeys("Test");
	    driver.findElement(By.name("last_name")).sendKeys("Test1");
	    driver.findElement(By.xpath(".//*[@id='pie_register']/li[2]/div/div/input[2]")).click();
	    driver.findElement(By.xpath(".//*[@id='pie_register']/li[3]/div/div/input[2]")).click();
	    //select the country
	    Select dropDown=new Select(driver.findElement(By.id("dropdown_7")));
	    dropDown.selectByVisibleText("India");
	    //select month, day, year
	    Select dropMonth=new Select(driver.findElement(By.id("mm_date_8")));
	    dropMonth.selectByVisibleText("8");
	    Select dropDay=new Select(driver.findElement(By.id("dd_date_8")));
	    dropDay.selectByVisibleText("20");
	    Select dropYear=new Select(driver.findElement(By.id("yy_date_8")));
	    dropYear.selectByVisibleText("2014");
	    
	    driver.findElement(By.id("phone_9")).sendKeys("91234523212");
	    //create random username
	   
	    String randomUsername= RandomStringUtils.randomAlphabetic(8);
	    driver.findElement(By.id("username")).sendKeys("a"+randomUsername);
	    //create random email address
	    Random randomGenerator1=new Random();
	    int randomInt1=randomGenerator1.nextInt(500);
	    driver.findElement(By.id("email_1")).sendKeys("abc"+randomInt1+"@gmail.com");
	    //set the path for the image
	   	   
	    driver.findElement(By.name("profile_pic_10")).click();
	   uploadImage("C:\\Users\\Indrapc\\Pictures\\2016\\indra.jpg");
	    /*setClipboardData("C:\\Users\\Indrapc\\Pictures\\2016\\indra.jpg");
	    Thread.sleep(500);
	  //native key strokes for CTRL, V and ENTER keys
	  Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_CONTROL);
	  robot.keyPress(KeyEvent.VK_V);
	  robot.keyRelease(KeyEvent.VK_V);
	  robot.keyRelease(KeyEvent.VK_CONTROL);
	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);
	  robot.delay(500);*/
	  	    
	    driver.findElement(By.id("description")).sendKeys("This is my first selenium page");
	    driver.findElement(By.id("password_2")).sendKeys("aaa111aaa");
	    driver.findElement(By.id("confirm_password_password_2")).sendKeys("aaa111aaa");
	    driver.findElement(By.xpath(".//*[@id='piereg_passwordStrength']")).click();
	    driver.findElement(By.name("pie_submit")).click();
	    Thread.sleep(5000);
	    
	      if(driver.getPageSource().contains("Thank you for your registration"))
	    		{
	    	System.out.println("Test case Passed");
	    		}
	    else
	    {
	    	System.out.println("Test Case failed");
	    
	    		}
	   
	   
	      driver.close();
	      //x=x+1;
	    
		//}
	}


	
		public static void uploadImage(String imagelocation){
		      
		          try{
		              //Setting clipboard with image location
		              setClipboardData(imagelocation);
		            //Some sleep time to detect the window popup
		              Thread.sleep(500);
		              //native key strokes for CTRL, V and ENTER keys
		              Robot robot =  new Robot();
		              robot.keyPress(KeyEvent.VK_CONTROL);
		              robot.keyPress(KeyEvent.VK_V);
		              robot.keyRelease(KeyEvent.VK_V);
		              robot.keyRelease(KeyEvent.VK_CONTROL);
		            //To Click on the "Open" button to upload files
		              robot.keyPress(KeyEvent.VK_ENTER);
		              robot.keyRelease(KeyEvent.VK_ENTER);
		              robot.delay(500);
		          } catch (Exception exp) {
		              exp.printStackTrace();
		          }
		    	
	}

}
