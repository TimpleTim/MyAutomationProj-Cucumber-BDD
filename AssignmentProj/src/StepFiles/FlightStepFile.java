package StepFiles;


import POMFiles.FlightPOM;
import POMFiles.Hooks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class FlightStepFile extends Hooks{
	
	FlightPOM FP=new FlightPOM(driver);
	@Given("^User go to the flight application$")
	public void user_go_to_the_flight_application()  {
	    
	    driver.get("https://www.laterooms.com/");
	    
	}

	@When("^User enters the details as \"([^\"]*)\" and selects as \"([^\"]*)\" into the fields$")
	public void user_enters_the_details_as_and_selects_as_into_the_fields(String arg1, String arg2)  {
		
		FP.enterDetails(arg1,arg2);

	}

	@When("^User selects the date as \"([^\"]*)\" and date as \"([^\"]*)\" date$")
	public void user_selects_the_date_as_and_date_as_date(String arg1, String arg2)  {
	    FP.datefunction(arg1,arg2);
	}

	@When("^User selects the \"([^\"]*)\" for number of person$")
	public void user_selects_the_for_number_of_person(String arg1)  {
	    FP.numberOfPerson(arg1);
	}

	@Then("^User clicks the search$")
	public void user_clicks_the_search_for_flight_button()  {
	    FP.search();
	}

	@Then("^Checks the page$")
	public void checks_the_page() {
		
		System.out.println("Verified with result showing as: ");
		FP.resultPageCompare();
		
		
	}
	
	
}
