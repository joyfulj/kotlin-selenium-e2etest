package joy.selenium.e2etest.page

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.util.concurrent.TimeUnit

class GitHubHomePageTest {

    lateinit var driver: WebDriver
    private lateinit var gitHubHomePage: GitHubHomePage

    @Before
    fun init() {
        val options = ChromeOptions()
        val rootPath = System.getProperty("user.dir")!!
        val driverPath = "$rootPath/drivers/chromedriver"

        options.addArguments("--start-maximized")

        System.setProperty("webdriver.chrome.driver", driverPath)
        driver = ChromeDriver(options);
        driver?.manage()?.timeouts()?.implicitlyWait(5, TimeUnit.SECONDS)
    }

    @After
    fun close() {
        driver.quit()
    }

    @Test
    internal fun openTest() {
        gitHubHomePage = GitHubHomePage(driver)
        gitHubHomePage.open()

    }


}