package com.Miaplaza.stepdefinitions;


import com.Miaplaza.utilities.ConfigurationReader;
import com.Miaplaza.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.util.concurrent.TimeUnit;

public class Hooks {



    @Before
    public void setUp(){
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Before("@database")
    public void setUpDBCOnn(){
        System.out.println("Setting up DB connection");
    }

    @After
    public void tearDown(Scenario scenario){

        // check if the scenario is failed
        if (scenario.isFailed()){
            // take that screenshot
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            // attach the scenario to the report
            scenario.attach(screenshot, "image/png", scenario.getName() + "_screenshot");
           // scenario.embed(screenshot, "image/png");
        }
        Driver.closeDriver();
    }

    @After("@database")
    public void tearDownConnection(){
        System.out.println("Closing DB connection");
    }
}