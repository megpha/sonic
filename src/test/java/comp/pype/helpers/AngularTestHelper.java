package comp.pype.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AngularTestHelper {
	private static ExpectedCondition<Boolean> finishedLoading = new ExpectedCondition<Boolean>() {
		public Boolean apply(WebDriver driver) {
			return Boolean.valueOf(((JavascriptExecutor) driver)
					.executeScript(
							"return (window.angular !== undefined) && (angular.element(document).injector() !== undefined) && (angular.element(document).injector().get('$http').pendingRequests.length === 0)")
					.toString());
		}
	};

	public static void waitUntilPageLoads(final WebDriver driver) {
		(new WebDriverWait(driver, 20)).until(finishedLoading);
	}
}
