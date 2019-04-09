package newProgram;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
//import static org.testng.Assert.assertEquals;

public class TestProgram extends Hooks {

	//Comments are included here to have a better understanding of the program 
	
	@Test
	public void testToRun() throws InterruptedException {
		int count=0;
		int count1=0;
		String agent = null;
		String mblNumber= null;
		driver.get("https://www.zoopla.co.uk/");
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("London");
		driver.findElement(By.xpath("//*[@id=\"search-submit\"]")).click();
		
		
		//Storing the css selector for the whole "ul" in a WebElement
		WebElement whole= driver.findElement(By.cssSelector("#content > ul"));
		
		//System.out.println("*********!!*"+whole);
		//Storing the "li"blocks in a list
		List<WebElement> options = whole.findElements(By.xpath("li[@class=\"srp clearfix   \"]"));
		
		//To select the 5th Property for sale in "London"
		for(WebElement option: options)
		{
			//System.out.println("***********"+option);
			//System.out.println("@@@@@@@@@@"+options.size());
			
			count++;
			if(count==5)
			{	
				
				option.click();
				option.findElement(By.xpath("div/div[2]/a")).click();
				//this is for a example xpath which is converted as required in above line::://*[@id="listing_48200061"]/div/div[2]/a
				agent=driver.findElement(By.xpath("//*[@id=\"dp-sticky-element\"]/div/div[1]/a/div[2]/h4")).getText();
				mblNumber=driver.findElement(By.xpath("//*[@id=\"dp-sticky-element\"]/div/div[1]/p/a")).getText();
				break;
			}
			
		}
		
		//Select the logo inside the 5th property
		driver.findElement(By.xpath("//*[@id=\"dp-sticky-element\"]/div/div[1]/a/div[1]/img")).click();
		
		System.out.println("Agent name and number are: "+agent+"\n"+mblNumber);
		
		//Select the "see more properties" option below the third property
		driver.findElement(By.xpath("//*[@id=\"tab-overview\"]/div[4]/a")).click();
		
		
		//same as above for-loop
		WebElement inside= driver.findElement(By.cssSelector("#content > ul"));
		List<WebElement> options1 = inside.findElements(By.xpath("li[@class=\"srp clearfix   \"]"));
		
		// Loop the five properties to check if the name and number matches
		for(WebElement cell:options1) 
		{
			//wait for 3 seconds for each iteration
			Thread.sleep(3000);
			
			//Click the "li" block
			cell.click();
			
			//Storing the current window name in parent window string
			String parentWindow= driver.getWindowHandle();
			
			//To Force open the property in a new window
			WebElement L1=cell.findElement(By.xpath("div/div[1]/div/a[1]/img"));
			WebElement link = L1;
			
			count1++;
			Actions newwin = new Actions(driver);
			newwin.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
			
			//Storing all windows open in a set
			Set<String> allWindows = driver.getWindowHandles();
			
			//To switch to the other window opened
			for(String curWindow : allWindows)
			{	
				//System.out.println("!!!!CurHandles@@"+curWindow);
			    driver.switchTo().window(curWindow);
			    
			}
			
			//Comparison of agent name and contact details
			String name=driver.findElement(By.xpath("//*[@id=\"dp-sticky-element\"]/div/div[1]/a/div[2]/h4")).getText();
			String phone=driver.findElement(By.xpath("//*[@id=\"dp-sticky-element\"]/div/div[1]/p/a")).getText();
			if(agent.equals(name) && mblNumber.equals(phone)) {
				System.out.println("\n agent name and Mobile number matched");
			}
			else
			{
				System.out.println("\nEither Agent name or number is mismatched");
			}
			
			System.out.println("For Property: "+driver.findElement(By.xpath("//*[@id=\"dp-sticky-element\"]/article/div[1]/h2")).getText()+"\n");
			
			//Close the child window and switch to parent window
			driver.close();
			driver.switchTo().window(parentWindow);
			
			
			if(count1==5)
			{
				break;
			}
			
		}
		
	
	}
}
