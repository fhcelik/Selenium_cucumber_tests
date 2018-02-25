package com.selenTest.WebPages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static com.selenPrep.Intro.Driver.waitForElement;
import static org.junit.Assert.fail;
import static com.selenPrep.Intro.Driver.get;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class SendMessage {
WebDriver driver;
private static final String WEBSITE_URL = HomePage.HOME_URL + "/contact-us";

private static final By NAME = By.xpath(".//*[@id='field1']");
private static final By EMAIL= By.xpath(".//*[@id='field2']");
private static final By MESSAGE = By.xpath(".//*[@id='i0mfd001fieldMessage']");
private static final By SENDBUTTON = By.xpath(".//*[@id='i0mfd001submit']");
private static final By RESULT = By.id("i0mfd001notifications");

	@Given("^Open GoogleChrome and enter site$")
	public static void open_GoogleChrome_and_enter_site() {
	    // Write code here that turns the phrase above into concrete actions
		
		get(WEBSITE_URL);
			
	} 
	
	@When("^Enter valid data on the page$")
	public void enter_valid_data_on_the_page(DataTable values) throws Throwable {
	   List<List<String>> messageValues = values.raw(); 
	   
	   waitForElement(NAME).sendKeys(messageValues.get(1).get(1));
	   waitForElement(EMAIL).sendKeys(messageValues.get(2).get(1));
	   waitForElement(MESSAGE).sendKeys(messageValues.get(3).get(1)); 
	   waitForElement(SENDBUTTON).click();
       
	   
	}

	
	@Then("^Message sending should be successful$")
	public void message_sending_should_be_successful() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   WebElement textMessage = waitForElement(RESULT);
	   String text = textMessage.getAttribute("class"); 
	  
		   Assert.assertTrue(text.equals("cf1_success cf1notifications"));
	   
	   
	}

}
