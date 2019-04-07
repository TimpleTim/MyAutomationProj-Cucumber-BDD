package StepFiles;

import POMFiles.Hooks;
import POMFiles.SignInPOM;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchStepFile extends Hooks{
	
	SignInPOM SI=new SignInPOM(driver);
	
	//Just for reference
	/*
	@When("^user enters keyword as (.*) author as (.*) Book title as (.*) volume as (.*) issue as (.*) pages as (.*) in text fields.$")
	public void user_enters(String keyword, String authorname, String Booktitle, String volume, String issue, String pages)  {
	    
		SI.searchOption(keyword, authorname, Booktitle, volume, issue, pages);
	}
	*/
	
	@When("^user enters keyword as \"([^\"]*)\" author name as \"([^\"]*)\" Book title as \"([^\"]*)\" volume as \"([^\"]*)\" issue as \"([^\"]*)\" pages as \"([^\"]*)\" in text fields\\.$")
	public void user_enters_keyword_as_author_name_as_Book_title_as_volume_as_issue_as_pages_as_in_text_fields(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
		SI.searchOption(arg1,arg2,arg3,arg4,arg5,arg6);
	}

	@Then("^user clicks the search button$")
	public void user_clicks_the_search_button()  {
	   
		SI.clickSearch();
	}

	@Then("^user verfies the entry made$")
	public void user_verfies_the_entry_made()  {
	    SI.searchResultsPage();
		//System.out.println("verified");
	}
	
	
	@When("^User enters the string inside the volume field$")
	public void user_enters_the_string_inside_the_volume_field()  {
	    SI.enterVolumeInString();
	}

	@Then("^User should get error message for entering string$")
	public void user_should_get_error_message_for_entering_string()  {
	    SI.errorForString();
	}
}
