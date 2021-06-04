package basecrm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilitycrm.Testutilcrm;

public class TestbaseCRM {
	
   public static WebDriver driver;
   public static Properties prop;
   
   
    public TestbaseCRM() {
    	
    	try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:/Practice_Manali/framework/framework/src/main/java/propertiescrm/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
  
    }
    	
    	public static void initialization(){
    	String browsername = prop.getProperty("Browser");

    		if(browsername.equals("Firefox"))
    		{
    		        WebDriverManager.firefoxdriver().setup();
    				driver=new FirefoxDriver();
    		}
    		
    		else
    		{
    			WebDriverManager.chromedriver().setup();
    				driver=new ChromeDriver();
    		}
    		driver.manage().window().maximize();
    		driver.manage().deleteAllCookies();
    		driver.manage().timeouts().implicitlyWait(Testutilcrm.implicit_wait,TimeUnit.SECONDS);
    		driver.get(prop.getProperty("url"));
    		
    	}
    	
    }
    

