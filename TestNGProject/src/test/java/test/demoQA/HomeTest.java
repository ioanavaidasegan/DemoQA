package test.demoQA;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.demoQA.HomePage;
import test.BaseTest;

public class HomeTest extends BaseTest {

	@Test
	public void validationTextOnTab3Test() {
		navigateTo("https://demoqa.com/");
		HomePage hp = new HomePage();
		hp.verifyTextOnTab3();
		Assert.assertTrue(hp.verifyTextOnTab3().contains("Tab 3"));
	}
}
