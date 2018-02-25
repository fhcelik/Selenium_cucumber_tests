package com.selenTest.WebPages;

import static com.selenPrep.Intro.Driver.createFirefoxDriver;
import static com.selenPrep.Intro.Driver.createChromeDriver;
import static com.selenPrep.Intro.Driver.shutdownDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestPreparation {

    @Before
    public void setUp() {
    	
        createChromeDriver();
    }

    @After
    public void tearDown() {
        shutdownDriver();
    }
}
