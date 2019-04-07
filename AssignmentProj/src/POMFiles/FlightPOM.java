package POMFiles;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightPOM {
	
	WebDriver driver;
	String resultPlaceName;
	
	String a,b;
	
	@FindBy(id="destinationSearch")
	WebElement place;
	
	@FindBy(xpath="//*[@id=\"autocomplete\"]/ul")
	WebElement placeSelect;
	
	@FindBy(css="#search-bar-form > div.form-group.col-md-offset-4.col-sm-offset-4.col-sm-4.col-md-4.search-button-wrapper > button")
	WebElement searchButton;
	
	@FindBy(xpath="//*[@id=\"search-bar-form\"]/div[2]/button")
	WebElement date;
	
	@FindBy(xpath="//*[@id=\"msPopup2\"]/div/div/div/div/div[1]/div[2]/table/tbody")
	WebElement dateSearchLeft;
	
	@FindBy(xpath="//*[@id=\"msPopup2\"]/div/div/div/div/div[2]/div[2]/table/tbody")
	WebElement dateSearchRight;
	
	@FindBy(xpath="//*[@id=\"msPopup2\"]/div/div/div/div/div[3]/div/div[1]")
	WebElement error;
	
	@FindBy(xpath="//*[@id=\"msPopup2\"]/div/h2/span/i")
	WebElement dateCloseWindow;
	
	@FindBy(xpath="//*[@id=\"msPopup2\"]/div/div/div/div/div[3]/div/button[2]")
	WebElement confirm;
	
	@FindBy(xpath="//*[@id=\"search-bar-form\"]/div[3]/div/select")
	WebElement number;
	
	@FindBy(xpath="/html/body/section[2]/div[2]/form/div[2]/section[2]/header/h1")
    WebElement resultPage;	
	
	@FindBy(xpath="/html/body/section[2]/div[2]/form/div[2]/section[2]/header/div")
	WebElement resultLine;
	
	@FindBy(xpath="//*[@id=\"msPopup1\"]/div/div[1]/div/div[1]/div[2]/div/select")
	WebElement childrenCount;
	
	@FindBy(xpath="//*[@id=\"msPopup1\"]/div/div[2]/button[2]")
	WebElement confirmChildren;
	
	public FlightPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterDetails(String places, String fullPlaceName) {
		resultPlaceName=fullPlaceName;
		place.clear();
		place.sendKeys(places);
		if(fullPlaceName.isEmpty()) 
		{
			System.out.println("post code or city name has been entered");
		}
		else 
		{
		WebElement placePicker= placeSelect;
		List<WebElement> options = placePicker.findElements(By.tagName("li"));
		
		for(WebElement option: options)
		{
			//System.out.println("***********"+option.getText());
			
			if(option.getText().contains(fullPlaceName)) 
			{
				option.click();
				break;
			}
		}
		}
	}
	
	public void datefunction(String checkInDate, String checkOutDate) {
		a=checkInDate;
		b=checkOutDate;
		
		date.click();
		WebElement dateWidget=dateSearchLeft;
		List<WebElement> columns =dateWidget.findElements(By.tagName("td"));

		for (WebElement cell: columns){
			//System.out.println("***********"+cell.getText());
		   if (cell.getText().equals(checkInDate))
		   {
		      cell.click();
		      break;
		   }
		}
		
		WebElement dateWidget1=dateSearchRight;
		List<WebElement> columns2 =dateWidget1.findElements(By.tagName("td"));
		
		if(checkOutDate.isEmpty()) {
			System.out.println("Didnt u plan your checkout date yet?\n");
			confirm.click();
			assertEquals("You haven't selected a check-out date",error.getText());
			System.out.println("error displayed as "+error.getText()+"\n");
			dateCloseWindow.click();
			System.out.println("\n Search results with be displayed for today to tomorrow as you had not selected the date.\n");
		}
		else 
		{
		for (WebElement cell1: columns2)
		{
			//System.out.println("***********"+cell.getText());
		   if (cell1.getText().equals(checkOutDate))
		   {
		      cell1.click();
		      confirm.click();
		      break;
		   }
		}
		}
		
		
		
	}
	
	public void numberOfPerson(String numberOfTravelling) 
	{
		new Select(number).selectByVisibleText(numberOfTravelling);
		
		if(numberOfTravelling.equals("more options")) 
		{	
			//new Select(number).selectByVisibleText(numberOfTravelling);
			new Select(childrenCount).selectByVisibleText("2");
			confirmChildren.click();
			
		}
//		else{
//			new Select(number).selectByVisibleText(numberOfTravelling);
//		}
	}
	
	
	public void search() {
		searchButton.click();
	}
	
	public void resultPageCompare() {
		//assertEquals(result+" Hotels",resultPage.getText());
		System.out.println(resultPage.getText()+"\n" +resultLine.getText());
	}
	
	//the below method is the negative scenario which is not used yet..Writing it for future reference
	public void dateNotCorrect() throws ParseException {
		//get current date time with Date()
		 Date date = new Date();
		 //Format the date
		 SimpleDateFormat formatter = new SimpleDateFormat("MMMM yyyy");  
		 String strDate = formatter.format(date);
		 strDate = formatter.format(date); 
		  //Print the Date
		 System.out.println("Date Format with dd MMMM yyyy :\n "+strDate);
//		 String sDate1="31/12/1998";
//		 SimpleDateFormat formatter1 =new SimpleDateFormat("dd/MM/yyyy");
//		 Date date1=formatter1.parse(sDate1);  
//		 System.out.println(date1);
	}
}
