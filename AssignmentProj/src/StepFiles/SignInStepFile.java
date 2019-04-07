package StepFiles;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import POMFiles.Hooks;
import POMFiles.SignInPOM;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignInStepFile extends Hooks{
	
	
	SignInPOM SIP;
	
	@Given("^User is on the chrome browser$")
	public void user_is_on_the_chrome_browser()  {
		System.setProperty("webdriver.chrome.driver", "CHROMEDRIVER PATH");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	
	@Given("^User is presented in the application$")
	public void user_is_preseted_in_the_application()  {
	    driver.get("https://www.sciencedirect.com/");
	}

	
	
	@Given("^User click the sign In$")
	public void user_click_the_sign_In()  {
		SIP= new SignInPOM(driver);
	    SIP.signInClick();
	}

	@When("^User enters the credentials (.*) and (.*)$")
	public void user_enters_the_credentials(String name,String password) {
		SIP.enterDetails(name, password);
	}

	@When("^Clicks the sign in button$")
	public void clicks_the_sign_in_button()  {
	    SIP.submit();
	}

	@Then("^User should be logged in$")
	public void user_should_be_logged_in()  {
	    SIP.validDataEntry();
		
	}
	
	@Then("^Browser closes$")
	public void browser_closes()  {
	    driver.quit();
	}
	
	@Then("^User should get error message$")
	public void user_should_get_error_message()  {
	    SIP.invalidErrorMessage();
	    
	}
	
	@When("^User enters the null values$")
	public void user_enters_the_null_values() {
		SIP.enterNullValue();
	}
	
	@Then("^User should get error message for null values entered$")
	public void user_should_get_error_message_for_null_values_entered() {
	    SIP.nullValuesError();
	    
	}
	
	
	@When("^User enters only the username$")
	public void user_enters_only_the_username()  {
	    SIP.enterOnlyUserName();
	    
	}
	
	@When("^User enters only password$")
	public void user_enters_only_the_password()  {
	    SIP.enterOnlyPassword();
	    
	}
	
	@Then("^User should get error message to enter the missing textfield$")
	public void user_should_get_error_message_to_enter_password()  {
		SIP.oneValueEntered();
		
	}

	@Then("^User should get error message for password length$")
	public void user_should_get_error_message_for_password_length() {
	    SIP.shortPasswordError();
	}
	
	
	
}
