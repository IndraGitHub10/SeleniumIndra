package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FDA_Selenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		
		//launch browser and open the following webpage
       WebDriver driver=new ChromeDriver();
       String url="http://www.fda.gov/";
       driver.get(url);
       
       driver.manage().window().maximize();
       
       //click on Drugs link
       driver.findElement(By.linkText("Drugs")).click();
       Thread.sleep(5000);
       ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)");
       Thread.sleep(5000);
       driver.findElement(By.linkText("Emergency Preparedness")).click();
       Thread.sleep(5000);
       ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)");
       Thread.sleep(5000);
       
       WebElement verifyText1 =driver.findElement(By.xpath(".//*[@id='mp-pusher']/div/div/div/main/div[1]/div[3]/div[1]/article/div[2]/div[1]/h2"));
       System.out.println("Verify Text Present"+verifyText1.getText());
       
       /*       if(driver.getPageSource().contains("Related FDA Resources"))
       {
       System.out.println("Text is Present in the page     ="+verifyText);
       }
       else
       {
    	   System.out.println("Text not Present");
       }
*/       driver.getTitle();
       System.out.println("The title of the page is   "+driver.getTitle());
       ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-250)");
       Thread.sleep(5000);
       
       boolean elementFound=driver.findElement(By.xpath(".//*[@id='Resources_for_You']/div[2]/ul/li/a")).isDisplayed();
       if (elementFound)
       {
    	   System.out.println("Element Present");
       }
       else
       {
    	   System.out.println("Element not present");
       }
       driver.close();
	}

}
