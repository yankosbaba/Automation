package springpagetest;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import springerpage.SpringerSearchPage;

import org.junit.Assert;

public class SpringerSearchPageStep {
	
	
	SpringerSearchPage search = new SpringerSearchPage();
	//Happy path
	
	@Given("^that I am on Springer Link search page$")
	public void that_I_am_on_Springer_Link_search_page() throws Throwable {
		search.setUp();
	Assert.assertTrue(search.assetURL());
	}

	@When("^I enter books name$")
	public void i_enter_books_name() throws Throwable {
		search.testSearchEngine();
	}

	@Then("^I should see books results$")
	public void i_should_see_books_results() throws Throwable {
		
		Assert.assertTrue(search.checkSearchResult());
		search.shutDown();
	}
	
	//UnHappy Path; 

	@When("^I enter wrong books name$")
	public void i_enter_wrong_books_name() throws Throwable {
	
		search.testNegativeSearch();
	}

	@Then("^I should see an error message$")
	public void i_should_see_an_error_message() throws Throwable {
		search.testNegativeAssert();
		search.shutDown();
	}


}
