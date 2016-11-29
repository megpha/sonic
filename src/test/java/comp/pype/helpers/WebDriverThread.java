package comp.pype.helpers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverThread {
	private WebDriver webdriver;

	protected final boolean isLocalExecution = EnvConst.IS_LOCAL;

	public WebDriver getDriver() throws Exception {
		if (null == webdriver) {
			webdriver = this.initDriver();
		}

		return webdriver;
	}

	public void quitDriver() {
		if (null != webdriver) {
			webdriver.quit();
			webdriver = null;
		}
	}

	private static DesiredCapabilities getChrome() {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		return caps;
	}

	private WebDriver initDriver() throws MalformedURLException {
		WebDriver driver = isLocalExecution ? (new ChromeDriver())
				: (new RemoteWebDriver(new URL(EnvConst.SELENIUM_GRID_URL), getChrome()));
		driver.get(EnvConst.BASE_URL);
		return driver;
	}
}