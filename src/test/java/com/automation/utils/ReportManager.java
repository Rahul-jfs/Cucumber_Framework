package com.automation.utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ReportManager {

    public static Scenario scenario;

    public static void initReporter(Scenario scenario){
        ReportManager.scenario = scenario;
    }

    public static void attackScreenshot(){
        scenario.attach( takeScreenshot(), "image/png", "Failed");
    }

    private static byte[] takeScreenshot() {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }

}
