package test;

import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

import pages.BasePage;

public class BaseTest extends BasePage {

	@BeforeClass
	public void initP() {
		initDriver();
	}

	@AfterClass
	public void tearDownP() {
		tearDown();
	}

}
