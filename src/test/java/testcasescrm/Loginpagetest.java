package testcasescrm;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pagescrm.HomepageCRM;
import pagescrm.LoginpageCRM;
import basecrm.TestbaseCRM;

public class Loginpagetest extends TestbaseCRM {
	
	LoginpageCRM Lp;
	HomepageCRM Hp;
	
	public Loginpagetest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		
		initialization();
	
		Lp=new LoginpageCRM();
	}
	@Test(priority=1)
	public void titletest() {
		String Title=Lp.validateloginpage();
		Assert.assertEquals(Title,"Free CRM  - CRM software for customer relationship management, sales, and support.");
		
	}
	@Test(priority=2)
	public void crmlogotest() {
		boolean flag=Lp.validatelogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void logintest() {
		Hp=Lp.login(prop.getProperty("username"),prop.getProperty("password"));
	
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}
	

}
