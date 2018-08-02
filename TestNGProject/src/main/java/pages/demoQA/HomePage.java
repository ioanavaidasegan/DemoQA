package pages.demoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.BasePage;

public class HomePage extends BasePage {

	public String verifyTextOnTab3() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("li.menu-item-66")));
		clickOnFindElem("li.menu-item-66", "css", true);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("li.menu-item-153")));
		clickOnFindElem("li.menu-item-153", "css", true);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("a#ui-id-3")));
		clickOnFindElem("a#ui-id-3", "css", true);
		String tab3 = findElem("a#ui-id-3", "css", true).getText();
		return tab3;
	}

}
