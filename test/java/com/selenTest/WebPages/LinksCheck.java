package com.selenTest.WebPages;

import static com.selenPrep.Intro.Driver.get;
import static com.selenPrep.Intro.Driver.getDriver;
import static com.selenPrep.Intro.Driver.waitForAllElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LinksCheck {
	WebDriver driver;
	
	private static final String WEBSITE_URL = HomePage.HOME_URL;
	private static final By ALL_LINKS = By.tagName("a");
	String url = "";
    HttpURLConnection huc = null;
    int respCode = 200;
    
	@Given("^Open site$")
	public static void open_site() {
	    // Write code here that turns the phrase above into concrete actions
			get(WEBSITE_URL);
			getDriver().manage().window().maximize();
	} 
	@When("^Check all links$")
	public void check_all_links() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		Iterator<WebElement> it = waitForAllElements(ALL_LINKS).iterator();
		
		while(it.hasNext()){
			
	            url = it.next().getAttribute("href");
	            
	            System.out.println(url);
	        
	            if(url == null || url.isEmpty()){
	System.out.println("URL is either not configured for anchor tag or it is empty");
	                continue;
	            }
	            
	            if(!url.startsWith(WEBSITE_URL)){
	          //      System.out.println("URL belongs to another domain, skipping it.");
	                continue;
	            }
	            
	            try {
	                huc = (HttpURLConnection)(new URL(url).openConnection());
	                
	                huc.setRequestMethod("HEAD");
	                
	                huc.connect();
	                
	                respCode = huc.getResponseCode();
	                
	                if(respCode >= 400){
	                    System.out.println(url+" is a broken link");
	                }
	                else{
	                    System.out.println(url+" is a valid link");
	                }
	                    
	            } catch (MalformedURLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        
	}

	@Then("^All links should be successful$")
	public void all_links_should_be_successful() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	System.out.println("sfdfhsdgjflsdkjg");
	}
}
