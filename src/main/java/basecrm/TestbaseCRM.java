package basecrm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilitycrm.Testutilcrm;

public class TestbaseCRM {
	
   public static  WebDriver driver;
   public  static Properties prop;
    public void Testbase() throws IOException {
    	
    		prop= new Properties();
    	FileInputStream ip = new FileInputStream("D:\\QA\\selenium_Workspace\\CRMmavenProject\\src\\main\\java\\propertiescrm\\config.properties");
    	prop.load(ip);
  
    }
    	
    	public static void initialization(){
    	String browsername = prop.getProperty("Browser");

    		if(browsername.equals("Firefox"))
    		{
    		        System.setProperty("webdriver.gecko.driver", "D:\\QA\\seleniumjars\\geckodriver.exe");
    				driver=new FirefoxDriver();
    		}
    		
    		else
    		{
    				System.setProperty("webdriver.chrome.driver", "D:\\QA\\seleniumjars\\chromedriver.exe");
    				driver=new ChromeDriver();
    		}
    		driver.manage().window().maximize();
    		driver.manage().deleteAllCookies();
    		driver.manage().timeouts().implicitlyWait(Testutilcrm.implicit_wait,TimeUnit.SECONDS);
    		driver.get(prop.getProperty("url"));
    		
    	}
    	
    }
    

