package basePackage;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.util.concurrent.Service.State;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePo {
	public static WebDriver driver;
	
	    public static final String DOWNLOAD_PATH = Paths.get("../../downloads/Chrome").toAbsolutePath().toString();
	    public static final String LOCAL_STORAGE_PATH = "storage/Chrome";
	    public static final String UPLOAD_TEST_DATA_PATH = "../../../testData/uploadTestData/";

	public void browserLaunch() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Adjust the timeout as needed

	}

	public void closeBrowser() {
		driver.quit();
	}


}
