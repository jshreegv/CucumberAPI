package com.test.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/APIFeature.Feature"},
glue= {"com.test.stepdefinitions"})

public class TestRunner extends AbstractTestNGCucumberTests {

	
}
