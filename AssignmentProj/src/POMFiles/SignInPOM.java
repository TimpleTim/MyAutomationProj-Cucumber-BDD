package POMFiles;
import static org.junit.Assert.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPOM {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"gh-signin-btn\"]/span")
	WebElement signInButton;
	
	@FindBy(id="reg-userid")
	WebElement userName;
	
	@FindBy(id="reg-password")
	WebElement passwordEnter;
	
	@FindBy(xpath="//*[@id=\"react-root\"]/div/div/div[2]/div[1]/div[1]/form/div[6]/button")
	WebElement signInSubmitButton;
	
	@FindBy(xpath="//*[@id=\"react-root\"]/div/div/div[2]/div[1]/div[1]/form/div[2]/div/p")
	WebElement errorForInvalid;
	
	@FindBy(id="reg-username-error")
	WebElement nullUsernameError;
	
	@FindBy(id="reg-password-error")
	WebElement nullPasswordError;
	
	
	@FindBy(xpath="//*[@id=\"popover-trigger-gh-profile-dropdown\"]/button/span/span")
	WebElement validMsg;
	
	
	@FindBy(xpath="//*[@id=\"popover-content-gh-profile-dropdown\"]/div/div[2]/a[2]")
	WebElement SignOut;
	
	//for search functionality elements are as follows:
	
	
	@FindBy(name="qs")
	WebElement keywordName;
	
	@FindBy(name="authors")
	WebElement authorName;
	
	@FindBy(name="pub")
	WebElement bookName;
	
	@FindBy(name="volume")
	WebElement volumeName;
	
	@FindBy(name="issue")
	WebElement issueNumber;
	
	@FindBy(name="page")
	WebElement PagesNumber;
	
	@FindBy(css="#aa-srp-search-submit-button > button")
	WebElement searchClick;
	
	@FindBy(xpath="//*[@id=\"facets\"]/div[1]/h1")
	WebElement searchResults;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/div/div/div/form/div/div[1]/div/div[4]/div/div/div/div/div[2]/div[1]")
	WebElement errorForStringEntered;
	
	public SignInPOM(WebDriver driver)
	{
		this.driver=driver;
	    PageFactory.initElements(driver, this);
	}
	 
	public void signInClick()
	{
//		System.out.println("tessst" + driver);
//		driver.findElement(By.xpath("//*[@id=\"els-header-user-sign-in\"]/span")).click();
		signInButton.click();
	}
	 
	public void enterDetails(String name, String password)
	{
		userName.clear();
		userName.sendKeys(name);
		passwordEnter.clear();
		passwordEnter.sendKeys(password);
		
		
	}
	
	public void enterOnlyUserName() {
		userName.clear();
		userName.sendKeys("test@test.com");
		
	}
	
	public void enterOnlyPassword() {
		
		passwordEnter.clear();
		passwordEnter.sendKeys("qwert");
	}
	
	public void enterNullValue()
	{
		userName.clear();
		userName.sendKeys(" ");
		passwordEnter.clear();
		passwordEnter.sendKeys("");
	}
	
	public void oneValueEntered() {
		
		System.out.println("******  "+userName.getAttribute("value"));
		System.out.println("******  "+passwordEnter.getAttribute("value"));
		
		if((userName.getAttribute("value").isEmpty()) && !(passwordEnter.getAttribute("value").isEmpty())) 
		{
			
			assertEquals("Enter a username",nullUsernameError.getText());
			System.out.println("error message displayed to enter username");
			//assertEquals("Enter a password",nullPasswordError.getText());
			
		}
		else if(!(userName.getAttribute("value").isEmpty())&& (passwordEnter.getAttribute("value").isEmpty())) 
		{
			
			//assertEquals("Enter a user name",nullUsernameError.getText());
			assertEquals("Enter a password",nullPasswordError.getText());
			System.out.println("error message displayed to enter password");
		}
	}
	public void submit() {
		signInSubmitButton.click();
	}
	
	public void validDataEntry() {
		
		assertEquals("Timple Raju",validMsg.getText());
		validMsg.click();
		SignOut.click();
		System.out.println("Logged in successfully and logged out too");
	}
	
	public void invalidErrorMessage() {
		assertEquals("We can't find this username/password",errorForInvalid.getText());
		System.out.println("Invalid credentials error message verified");
	}
	
	public void shortPasswordError() {
		assertEquals("Password must be at least 5 characters long",nullPasswordError.getText());
		System.out.println("short password error verified");
	}
	
	public void nullValuesError() {
		assertEquals("Enter a username",nullUsernameError.getText());
		assertEquals("Enter a password",nullPasswordError.getText());
		System.out.println("null credentials error messages verified");
	}
	
	//For search functionality, methods are
	
	public void searchOption(String keyword,String name,String title,String volume,String issue,String pages) {
		keywordName.clear();
		keywordName.sendKeys(keyword);
		authorName.clear();
		authorName.sendKeys(name);
		bookName.clear();
		bookName.sendKeys(title);
		volumeName.clear();
		volumeName.sendKeys(volume);
		issueNumber.clear();
		issueNumber.sendKeys(issue);
		PagesNumber.clear();
		PagesNumber.sendKeys(pages);
		
		
	}
	
	public void clickSearch() {
		searchClick.click();
		
	}
	
	public void searchResultsPage() {
		//System.out.println(" search results " + searchResults.isEnabled());
//		if(searchResults.isDisplayed()) {
//			System.out.println(searchResults.getText());
//		}
//		else {
//			System.out.println("No results found");
//		}
		
		
		try {
			System.out.println(searchResults.getText());
		} catch(NoSuchElementException e) {
			System.out.println("No results found");
			System.out.println("Please edit your search query to find results.");
		}
	}
		
	public void enterVolumeInString() {
		volumeName.clear();
		volumeName.sendKeys("st");
	}
	
	public void errorForString() {
		System.out.println(errorForStringEntered.getText());
	}
}
