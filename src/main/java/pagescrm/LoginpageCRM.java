package pagescrm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basecrm.TestbaseCRM;

public class LoginpageCRM extends TestbaseCRM{
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbutton;
	
	@FindBy(xpath="//[text()='Sign Up']")
	WebElement signup;
	
	@FindBy(xpath="//img[contains(@class='img-responsive')]")
	WebElement CRMlogo;
	
	public LoginpageCRM() {
		
		PageFactory.initElements(driver,this);
	}
	
	public String validateloginpage() {

		return driver.getTitle();
	}
	
	  public boolean validatelogo() {
		  return CRMlogo.isDisplayed();
	  }
	  public HomepageCRM login(String un,String pw) {
		  username.sendKeys(un);
		  password.sendKeys(pw);
		  loginbutton.click();
		  return new HomepageCRM();
	  }
	
	
	
	
	
}
