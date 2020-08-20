package testrunner;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import constants.Browserlaunch;
import functionlib.Functions;
import utils.XLutils;

public class runner extends constants.Browserlaunch {

	WebDriver driver;

	@Test
	public void booking() throws Exception {
		Functions fn = new Functions();
		int msterrow = XLutils.getRow("MasterSheet");
		System.out.println(msterrow);
		// Loop for master sheet
		for (int i = 1; i <= XLutils.getRow("MasterSheet"); i++) {
			String tobeTest = XLutils.getData("MasterSheet", i, 2);
			String testsce = XLutils.getData("MasterSheet", i, 1);
			if (tobeTest.equalsIgnoreCase("Y")) {

				// Loop for individual modules
				for (int j = 1; j <= XLutils.getRow(testsce); j++) {

					String description = XLutils.getData(testsce, j, 1);
					String testfunName = XLutils.getData(testsce, j, 2);
					String attType = XLutils.getData(testsce, j, 3);
					String attValue = XLutils.getData(testsce, j, 4);
					String data = XLutils.getData(testsce, j, 5);
					try {
						// Executing individual test steps
						if (testfunName.equalsIgnoreCase("startbrowser")) {
							driver = Browserlaunch.startBrowser();

						} else if (testfunName.equalsIgnoreCase("launchapp")) {
							Browserlaunch.launchApp();

						} else if (testfunName.equalsIgnoreCase("waitForElement")) {
							fn.waitForElement(driver, attType, attValue, data);
							System.out.println("Wait for Element " + description);
							
						} else if (testfunName.equalsIgnoreCase("scrollDown")) {
							fn.scrollDown(driver);
//						mouse action
						} else if (testfunName.equalsIgnoreCase("mouseaction")) {
							fn.mouseaction(driver, attType, attValue);
						
														
						} else if (testfunName.equalsIgnoreCase("clickAction")) {
							fn.clickAction(driver, attType, attValue);

						} else if (testfunName.equalsIgnoreCase("typeAction")) {
							fn.typeAction(driver, attType, attValue, data);

						} else if (testfunName.equalsIgnoreCase("takeScreen")) {
							File sc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//
							FileUtils.copyFile(sc, new File(".\\screenshots\\" + description + "_" + ".png"));
						} else if (testfunName.equalsIgnoreCase("closeBrowser")) {
							// Browserlaunch.closeBrowser();
						}
						// updating the status of current test step
						XLutils.setData(testsce, j, 6, "PASS");
						// if test fails this block executes
						// this block updates test status as FAIL and takes
						// screen shoot of the failed test Case
					} catch (Exception e) {
						XLutils.setData(testsce, j, 6, "FAIL");

						File sc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
						FileUtils.copyFile(sc, new File(".\\screenshots\\" + description + "_" + ".png"));
						Functions.closeBrowser();
						XLutils.setData("MasterSheet", i, 3, "FAIL");
						break;
					}
					// updating the status of current Test Case as PASS
					XLutils.setData("MasterSheet", i, 3, "PASS");
				}
			}
		}
	}
}
