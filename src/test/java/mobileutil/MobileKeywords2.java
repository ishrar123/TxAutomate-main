package mobileutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import step_definitions.RunCukesTest;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;
import utilities.LogUtil;

public class MobileKeywords2 {
	public static Class<MobileKeywords2> thisClass = MobileKeywords2.class;
	public static Dimension size;
	public static int fail = 0;
	static WebElement webElement;
	public static String URL = "";
	public static boolean flag1 = false;
	public static String logging_step;
	static int row = 1;
	static Logger errorLogger;
	static Logger normalLogger;
	static FileAppender normalFileApp;
	static FileAppender errorFileApp;
	static ConsoleAppender conApp;
	public static boolean isInit = false;
	public static ExtentTest test = null;
	private static ExtentTest testHist = null;
	static PatternLayout patternLayout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p - %m%n");
	static PatternLayout consolePatternLayout = new PatternLayout("\tLOG-: [%m -  %d{yyyy-MM-dd HH:mm:ss a}] %n");

	public static AndroidDriver<MobileElement> MobileDriver;

	public static boolean isDisplayed;
	public static DesiredCapabilities capabilities = new DesiredCapabilities();

	public static String GetValue(String key) {
		File file = new File(System.getProperty("user.dir") + "/src/main/resources/Config/config.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		try {
			prop.load(fileInput);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String strbaseURL = prop.getProperty(key);
		return strbaseURL;
	}

	public static int GetIntValue(String key) {
		File file = new File(System.getProperty("user.dir") + "/src/main/resources/Config/config.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		try {
			prop.load(fileInput);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String strbaseURL = prop.getProperty(key);
		return Integer.parseInt(strbaseURL);
	}

	public static By locatortype(String type, String value) {

		By locName = null;
		if (type.equalsIgnoreCase("xpath")) {
			locName = By.xpath(value);
		} else if (type.equalsIgnoreCase("id")) {
			locName = By.id(value);
		} else if (type.equalsIgnoreCase("linkText")) {
			locName = By.linkText(value);
		} else if (type.equalsIgnoreCase("classname")) {
			locName = By.className(value);
		} else if (type.equalsIgnoreCase("name")) {
			locName = By.name(value);
		} else
			locName = By.partialLinkText(value);
		return locName;

	}

	public static boolean isWebElementPresent(String path, String type) {
		Boolean flag = false;

		if (GlobalUtil.getMDriver().findElements(MobileBy.xpath(path)).size() > 0) {
			flag = true;
		}
		return flag;
	}

	public static boolean isWebElementVisible(String path, String type) {
		Boolean flag = false;
		if (GlobalUtil.getMDriver().findElements(locatortype(type, path)).size() > 0) {
			flag = true;
		}

		return flag;

	}

	public static boolean isWebElementNotPresent(String path, String type) {

		@SuppressWarnings("unchecked")
		List<AndroidElement> elements = (List<AndroidElement>) GlobalUtil.getMDriver()
				.findElements(locatortype(type, path));

		if (elements.size() > 0) {
			LogUtil.infoLog(thisClass, "Element present");
			return false;
		} else {
			LogUtil.infoLog(thisClass, "Element Not present");
			return true;
		}
	}

	public static boolean writeInInput(String path, String type, String data, String logstep) {
		WebElement element = GlobalUtil.getMDriver().findElement(locatortype(type, path));

		element.sendKeys(data);
		RunCukesTest.logger.log(LogStatus.PASS, logstep);
		LogUtil.infoLog(thisClass, "Test Data entered successfully");
		return true;

	}

	public static boolean setValue(String path, String type, String data, String logstep) {
		MobileElement element = (MobileElement) GlobalUtil.getMDriver().findElement(locatortype(type, path));
		element.sendKeys(data);
		LogUtil.infoLog(thisClass, "Value Entered");
		RunCukesTest.logger.log(LogStatus.PASS, logstep);

		return true;

	}

	public static boolean enter() throws IOException {
		Runtime.getRuntime().exec("adb shell input keyevent 66");
		return true;

	}

	public static boolean clearAppData() throws IOException {
		Runtime.getRuntime().exec("adb shell pm clear com.cloudfmgroup.cloudFMApp");
		return true;

	}

	public static boolean swipeIOS(String path, String type, String data) {
		MobileElement element = (MobileElement) GlobalUtil.getMDriver().findElement(locatortype(type, path));
		element.setValue(data);
		LogUtil.infoLog(thisClass, "Value Entered");
		return true;

	}

	public static boolean enterInput(String path, String type, String data, String logstep) {
		WebElement element = GlobalUtil.getMDriver().findElement(locatortype(type, path));

		((JavascriptExecutor) GlobalUtil.getMDriver()).executeScript("arguments[0].value = arguments[1]", element,
				data);
		LogUtil.infoLog(thisClass, "Value Entered");
		RunCukesTest.logger.log(LogStatus.PASS, logstep);

		return true;

	}

	public static WebElement explicitWaitForElement(String path, String type) {
		WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), GetIntValue("explicit_timeout"));

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locatortype(type, path)));

		return element;

	}

	public static WebElement explicitWaitForElementfor20(String path, String type) {
		WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 15);

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locatortype(type, path)));

		return element;

	}

	public static boolean click(String path, String type, String logstep) {
		executionDelay(1000);
		WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locatortype(type, path)));
		WebElement element = (explicitWaitForElement(path, type));
		GlobalUtil.mdriver.findElement(locatortype(type, path));
		element.click();
		LogUtil.infoLog(thisClass, "Click on element successfully");
		RunCukesTest.logger.log(LogStatus.PASS, logstep);
		return true;
	}

	public static void clickByAcID(String accessibilityId, String logMsg) {
		new WebDriverWait(GlobalUtil.getMDriver(), 20)
				.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId(accessibilityId))).click();
		RunCukesTest.logger.log(LogStatus.PASS, logMsg);
	}

	public static boolean click(By locator, String logStep) {

		WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 20);
		WebElement elm = wait.until(ExpectedConditions.elementToBeClickable(locator));

		KeywordUtil.lastAction = "Click: " + locator.toString();
		LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
		if (elm == null) {
			return false;
		} else {
			elm.click();
			RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

			return true;
		}
	}

	public static void stepInfo(String stepName) {
		test.log(LogStatus.PASS, stepName);
		testHist.log(LogStatus.PASS, stepName);

	}

	public static void executionDelay(long time) {

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public boolean verifyAllVauesOfDropDown(String path, String type, String data) {

		boolean flag = false;
		WebElement element = explicitWaitForElement(path, type);
		List<WebElement> options = element.findElements(By.tagName("option"));
		String temp = data;
		String allElements[] = temp.split(",");
		String actual;
		for (int i = 0; i < allElements.length; i++) {
			LogUtil.infoLog(thisClass, "Actual : " + options.get(i).getText());
			LogUtil.infoLog(thisClass, "Expected: " + allElements[i].trim());
			actual = options.get(i).getText().trim();
			if (actual.equals(allElements[i].trim())) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}

		return flag;

	}

	public boolean verifyCurrentDateInput(String path, String type) {
		boolean flag = false;
		WebElement element = explicitWaitForElement(path, type);
		String actual = element.getAttribute("value").trim();
		DateFormat DtFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		DtFormat.setTimeZone(TimeZone.getTimeZone("US/Central"));
		String expected = DtFormat.format(date).toString().trim();
		if (actual.trim().contains(expected)) {
			flag = true;

		}
		return flag;

	}

	public static Boolean validateNotesInput(String path, String type, String errorMessage) {
		Boolean flag = false;

		WebElement element = explicitWaitForElement(path, type);
		String pattern[] = { "<", ">", "(", ")", "'", "\\" };
		for (int i = 0; i < pattern.length; i++) {
			element.clear();
			element.sendKeys(pattern[i]);
			flag = isWebElementPresent(errorMessage, type);

			if (!flag) {
				break;
			}

		}

		return flag;

	}

	public boolean selectList(final String path, String type, String data, String logstep) {

		Boolean flag = false;

		WebElement select = explicitWaitForElement(path, type);

		List<WebElement> options = select.findElements(By.tagName("option"));
		String expected = data.trim();
		LogUtil.infoLog(thisClass, "Expected: " + expected);
		for (WebElement option : options) {

			String actual = option.getText().trim();
			LogUtil.infoLog(thisClass, "Actual: " + actual);
			if (actual.equals(expected)) {

				option.click();
				RunCukesTest.logger.log(LogStatus.PASS, logstep);

				flag = true;
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return flag;
			}
		}

		return flag;
	}

	public boolean verifyDropdownSelectedValue(String path, String type, String data) {

		Boolean flag = false;
		WebElement select = explicitWaitForElement(path, type);

		Select sel = new Select(select);
		String defSelectedVal = sel.getFirstSelectedOption().getText();

		if (defSelectedVal.trim().equals(data.trim())) {
			flag = true;

			return flag;
		} else {
			return flag;
		}
	}

	public static boolean verifyElementSize(String path, String type, int size) {

		@SuppressWarnings("unchecked")
		List<AndroidElement> elements = (List<AndroidElement>) GlobalUtil.getMDriver()
				.findElements(locatortype(type, path));

		if (elements.size() == size) {
			LogUtil.infoLog(thisClass, "Element is Present " + size + "times");
			return true;
		} else {
			LogUtil.infoLog(thisClass, "Element is not Present with required size");
			return false;
		}
	}

	public static boolean uploadFilesUsingSendKeys(String path, String type, String data) throws InterruptedException {
		WebElement element = GlobalUtil.getMDriver().findElement(locatortype(type, path));
		element.clear();
		element.sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\uploadFiles\\" + data);
		LogUtil.infoLog(thisClass, "Value Entered");
		return true;

	}

	public static boolean writeInInputCharByChar(String path, String type, String data, String logstep)
			throws InterruptedException {
		WebElement element = GlobalUtil.getMDriver().findElement(locatortype(type, path));
		element.clear();
		String b[] = data.split("");

		for (int i = 0; i < b.length; i++) {

			element.sendKeys(b[i]);
			Thread.sleep(1000);

		}
		LogUtil.infoLog(thisClass, "Value Entered");
		RunCukesTest.logger.log(LogStatus.PASS, logstep);
		return true;

	}

	public static boolean isRadioSelected(String path, String type) {

		WebElement element = (explicitWaitForElement(path, type));
		if (element.isSelected()) {
			return true;
		} else {

			return false;
		}
	}

	public static boolean isRadioNotSelected(String path, String type) {

		WebElement element = (explicitWaitForElement(path, type));
		if (element.isSelected()) {
			return false;
		} else {

			return true;
		}
	}

	public static void stepPass(String stepName) {
		String html = "<span style='color:green'><b>" + stepName + "-PASS</b></span>";
		test.log(LogStatus.PASS, html);
		testHist.log(LogStatus.PASS, html);

	}

	public static void stepFail(String stepName) {
		String html = "<span style='color:red'><b>" + stepName + "-FAIL</b></span>";
		test.log(LogStatus.INFO, html);
		testHist.log(LogStatus.INFO, html);

	}

	public static boolean clearInput(String path, String type) {
		WebElement element = GlobalUtil.getMDriver().findElement(locatortype(type, path));

		element.clear();
		LogUtil.infoLog(thisClass, "input field cleared");
		return true;

	}

	public boolean delDirectory() {
		File delDestination = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\downloadFile");
		if (delDestination.exists()) {
			File[] files = delDestination.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					delDirectory();
				} else {
					files[i].delete();
				}
			}
		}
		return (delDestination.delete());
	}

	public boolean verifyCssProperty(String path, String type, String data) {

		String property[] = data.split(":", 2);
		String exp_prop = property[0];
		String exp_value = property[1];
		boolean flag = false;
		String prop = (explicitWaitForElement(path, type)).getCssValue(exp_prop);
		LogUtil.infoLog(thisClass, prop);
		if (prop.trim().equals(exp_value.trim())) {
			flag = true;
			return flag;
		}

		else {
			return flag;

		}

	}

	public static boolean switchContext() {
		boolean colFlag1 = false;
		Set<String> contextNames = GlobalUtil.getMDriver().getContextHandles();
		for (String contextName : contextNames) {
			if (contextName.contains("cloud")) {
				GlobalUtil.getMDriver().context(contextName);
				LogUtil.infoLog(thisClass, "Driver is: " + GlobalUtil.getMDriver().context(contextName));
				Set<String> contextNamesa = GlobalUtil.getMDriver().getContextHandles();
				LogUtil.infoLog(thisClass, "Context name is " + contextNamesa);
				colFlag1 = true;
				break;
			}

		}
		return colFlag1;

	}

	public static boolean switchContext1() {
		boolean colFlag1 = false;
		Set<String> contextNames = GlobalUtil.getMDriver().getContextHandles();
		for (String contextName : contextNames) {
			if (contextName.contains("NATIVE")) {
				GlobalUtil.getMDriver().context(contextName);
				colFlag1 = true;
				break;
			}

		}
		return colFlag1;

	}

	public static boolean changeContext(String data) {
		while (!flag1) {
			try {
				if (data.contains("WEBVIEW")) {
					flag1 = switchContext();
				}

				else {
					flag1 = switchContext1();
				}
			} catch (Exception e) {
				if (e.getMessage().contains("NoSuchContextException")) {
					flag1 = false;
				}
			}

		}
		flag1 = false;
		return true;
	}

	public static String GetTextOfElement(By value) {

		WebElement element = GlobalUtil.getMDriver().findElement(value);

		return element.getText();
	}

	public static String verifyCurrentDate() {

		DateFormat DtFormat = new SimpleDateFormat("MMM dd yyyy");
		Date date = new Date();
		DtFormat.setTimeZone(TimeZone.getTimeZone("BST"));
		String expected = DtFormat.format(date).toString().trim();
		return expected;
	}

	public static String currentdateWithDay() throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date1 = new Date();
		String expected = dateFormat.format(date1).toString().trim();

		String[] dateArray = expected.split("/");

		int year = Integer.parseInt(dateArray[0]);
		int month = Integer.parseInt(dateArray[1]);
		int day = Integer.parseInt(dateArray[2]);

		String dateString = String.format("%d-%d-%d", year, month, day);
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);

		return dayOfWeek;
	}

	public static String TimesheetDayAspercloudfm(String actual) {
		String DayaccordingtoCloudFm;
		String[] date = actual.split(" ");

		if (date[2].contains("th") || date[2].contains("st") || date[2].contains("nd") || date[2].contains("rd")) {
			if (date[2].length() == 3) {
				String str = date[2];
				date[2] = 0 + str.substring(0, 1);
			}
			if (date[2].length() == 4) {
				String str = date[2];
				date[2] = str.substring(0, 2);
			}
			if (date[0].length() > 3) {
				String str = date[0];
				date[0] = str.substring(0, 3);
				date[3] = date[3].substring(0, 4);
			}
		}
		DayaccordingtoCloudFm = date[0] + " " + date[1] + " " + date[2] + " " + date[3];
		return DayaccordingtoCloudFm;
	}

	public static String TimesheetPage1() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		String expecteddate = c.getTime().toString().trim();
		String[] expecteddateArray = expecteddate.split(" ");
		expecteddate = expecteddateArray[0] + " " + expecteddateArray[1] + " " + expecteddateArray[2] + " "
				+ expecteddateArray[5];
		LogUtil.infoLog(thisClass, expecteddate);
		return expecteddate;
	}

	public static String TimesheetPage2() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		String expecteddate = c.getTime().toString().trim();
		String[] expecteddateArray = expecteddate.split(" ");
		expecteddate = expecteddateArray[0] + " " + expecteddateArray[1] + " " + expecteddateArray[2] + " "
				+ expecteddateArray[5];
		LogUtil.infoLog(thisClass, expecteddate);
		return expecteddate;
	}

	public static String TimesheetPage3() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		String expecteddate = c.getTime().toString().trim();
		String[] expecteddateArray = expecteddate.split(" ");
		expecteddate = expecteddateArray[0] + " " + expecteddateArray[1] + " " + expecteddateArray[2] + " "
				+ expecteddateArray[5];
		LogUtil.infoLog(thisClass, expecteddate);
		return expecteddate;
	}

	public static String TimesheetPage4() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		String expecteddate = c.getTime().toString().trim();
		String[] expecteddateArray = expecteddate.split(" ");
		expecteddate = expecteddateArray[0] + " " + expecteddateArray[1] + " " + expecteddateArray[2] + " "
				+ expecteddateArray[5];
		LogUtil.infoLog(thisClass, expecteddate);
		return expecteddate;
	}

	public static String TimesheetPage5() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		String expecteddate = c.getTime().toString().trim();
		String[] expecteddateArray = expecteddate.split(" ");
		expecteddate = expecteddateArray[0] + " " + expecteddateArray[1] + " " + expecteddateArray[2] + " "
				+ expecteddateArray[5];
		LogUtil.infoLog(thisClass, expecteddate);
		return expecteddate;
	}

	public static String TimesheetPage6() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		String expecteddate = c.getTime().toString().trim();
		String[] expecteddateArray = expecteddate.split(" ");
		expecteddate = expecteddateArray[0] + " " + expecteddateArray[1] + " " + expecteddateArray[2] + " "
				+ expecteddateArray[5];
		LogUtil.infoLog(thisClass, expecteddate);
		return expecteddate;
	}

	public static String TimesheetPage7() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		String expecteddate = c.getTime().toString().trim();
		String[] expecteddateArray = expecteddate.split(" ");
		int dt = (Integer.parseInt(expecteddateArray[2])) + 01;
		expecteddateArray[2] = Integer.toString(dt);
		if (expecteddateArray[2].length() <= 1) {
			expecteddateArray[2] = "0" + expecteddateArray[2];
		}
		expecteddateArray[0] = "Sun";
		expecteddate = expecteddateArray[0] + " " + expecteddateArray[1] + " " + expecteddateArray[2] + " "
				+ expecteddateArray[5];
		LogUtil.infoLog(thisClass, expecteddate);
		return expecteddate;
	}

	public String GetCurrentDate(String path, String type) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM d YYYY");
		Date d = new Date();
		String Currentdate = sdf.format(d);
		return Currentdate;
	}

	public static String Gettext(String path, String type) throws InterruptedException {
		Thread.sleep(1500);
		WebElement element = GlobalUtil.getMDriver().findElement(locatortype(type, path));
		String s = element.getText();
		LogUtil.infoLog(thisClass, "Text has copyed in clipboard");
		return s;
	}

	public static String GetAttribute(String path, String type) throws InterruptedException {
		Thread.sleep(1500);
		WebElement element = GlobalUtil.getMDriver().findElement(locatortype(type, path));
		String s = element.getAttribute("name");
		return s;
	}

	public static String GetMondayOfCurrentWeek() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		String expecteddate = c.getTime().toString().trim();
		String[] expecteddateArray = expecteddate.split(" ");
		expecteddate = expecteddateArray[0] + " " + expecteddateArray[1] + " " + expecteddateArray[2] + " "
				+ expecteddateArray[5];
		LogUtil.infoLog(thisClass, "Current Monday of the week: " + expecteddate);
		return expecteddate;
	}

	public static String GetTuesdayOfCurrentWeek() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		String expecteddate = c.getTime().toString().trim();
		String[] expecteddateArray = expecteddate.split(" ");
		expecteddate = expecteddateArray[0] + " " + expecteddateArray[1] + " " + expecteddateArray[2] + " "
				+ expecteddateArray[5];
		LogUtil.infoLog(thisClass, "Current Tuesday of the week: " + expecteddate);
		return expecteddate;
	}

	public static String GetWednesdayOfCurrentWeek() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		String expecteddate = c.getTime().toString().trim();
		String[] expecteddateArray = expecteddate.split(" ");
		expecteddate = expecteddateArray[0] + " " + expecteddateArray[1] + " " + expecteddateArray[2] + " "
				+ expecteddateArray[5];
		LogUtil.infoLog(thisClass, "Current Wednesday of the week: " + expecteddate);
		return expecteddate;
	}

	public static String GetThursdayOfCurrentWeek() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		String expecteddate = c.getTime().toString().trim();
		String[] expecteddateArray = expecteddate.split(" ");
		expecteddate = expecteddateArray[0] + " " + expecteddateArray[1] + " " + expecteddateArray[2] + " "
				+ expecteddateArray[5];
		LogUtil.infoLog(thisClass, "Current Thrusday of the week: " + expecteddate);
		return expecteddate;
	}

	public static String GetFridayOfCurrentWeek() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		String expecteddate = c.getTime().toString().trim();
		String[] expecteddateArray = expecteddate.split(" ");
		expecteddate = expecteddateArray[0] + " " + expecteddateArray[1] + " " + expecteddateArray[2] + " "
				+ expecteddateArray[5];
		LogUtil.infoLog(thisClass, "Current Friday of the week: " + expecteddate);
		return expecteddate;
	}

	public static String GetSaturdayOfCurrentWeek() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		String expecteddate = c.getTime().toString().trim();
		String[] expecteddateArray = expecteddate.split(" ");
		expecteddate = expecteddateArray[0] + " " + expecteddateArray[1] + " " + expecteddateArray[2] + " "
				+ expecteddateArray[5];
		LogUtil.infoLog(thisClass, "Current Saturday of the week: " + expecteddate);
		return expecteddate;
	}

	public static String GetSundayOfCurrentWeek() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		String expecteddate = c.getTime().toString().trim();
		String[] expecteddateArray = expecteddate.split(" ");
		expecteddate = expecteddateArray[0] + " " + expecteddateArray[1] + " " + expecteddateArray[2] + " "
				+ expecteddateArray[5];
		LogUtil.infoLog(thisClass, "Current Sunday of the week: " + expecteddate);
		return expecteddate;
	}

	public static void verifyPastDate(String pastdate) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		String currentDate = verifyCurrentDate();
		LogUtil.infoLog(thisClass, currentDate);

		c1.get(Calendar.YEAR);
		c2.get(Calendar.YEAR);
		c1.get(Calendar.MONTH);
		c2.get(Calendar.MONTH);
		c1.get(Calendar.DAY_OF_MONTH);
		c2.get(Calendar.DAY_OF_MONTH);
	}

	public static void scrollDown() throws TimeoutException, InterruptedException {

		for (int i = 1; i <= 3; i++) {
			scrollscroll();
		}

		int retry = 0;
		while (retry <= 2) {
			try {

				WebElement we = GlobalUtil.mdriver.findElement(By.xpath("//*[@resource-id='add-to-cart-button']"));
				we.click();
				break;
			} catch (org.openqa.selenium.NoSuchElementException e) {
				scrollscroll();
				retry++;
			}
		}

	}

	@SuppressWarnings("rawtypes")
	public static void swipeHorizontal(double startPercentage, double finalPercentage, int duration) {
		Dimension size = GlobalUtil.mdriver.manage().window().getSize();
		int anchor = (int) (size.height * 0.5);
		int startPoint = (int) (size.width * startPercentage);
		int endPoint = (int) (size.width * finalPercentage);
		new TouchAction(GlobalUtil.mdriver).press(PointOption.point(startPoint, anchor))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
				.moveTo(PointOption.point(endPoint, anchor)).release().perform();
	}

	@SuppressWarnings("rawtypes")
	public static void swipeVertical(double startPercentage, double finalPercentage, int duration) {
		Dimension size = GlobalUtil.mdriver.manage().window().getSize();
		int anchor = (int) (size.width * 0.5);
		int startPoint = (int) (size.height * startPercentage);
		int endPoint = (int) (size.height * finalPercentage);
		new TouchAction(GlobalUtil.mdriver).press(PointOption.point(anchor, startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
				.moveTo(PointOption.point(anchor, endPoint)).release().perform();
	}

	public static void verticalSwipeUp() {
		int duration = 750;
		double startPercentage = 0.20;
		double finalPercentage = 0.60;
		swipeVertical(startPercentage, finalPercentage, duration);
	}

	public static void verticalSwipeDown() {
		int duration = 750;
		double startPercentage = 0.60;
		double finalPercentage = 0.20;
		swipeVertical(startPercentage, finalPercentage, duration);
	}

	@SuppressWarnings("rawtypes")
	public static void scrollInMobile() throws IOException, InterruptedException {

		Dimension dim = GlobalUtil.getMDriver().manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width / 2;
		int top_y = (int) (height * 0.80);
		int bottom_y = (int) (height * 0.20);
		LogUtil.infoLog(thisClass, "coordinates :" + x + "  " + top_y + " " + bottom_y);
		TouchAction ts = new TouchAction(GlobalUtil.mdriver);
		ts.longPress(PointOption.point(x, top_y)).moveTo(PointOption.point(x, bottom_y)).release().perform();

		Runtime.getRuntime().exec("adb shell input swipe 500 1000 500 50");
		Runtime.getRuntime().exec("adb shell input swipe 500 1000 500 50");
		Runtime.getRuntime().exec("adb shell input swipe 500 1000 500 50");
		Runtime.getRuntime().exec("adb shell input swipe 500 1000 500 50");
	}

	public static void scrollAndClick(String visibleText) {
		GlobalUtil.mdriver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))")
				.click();
	}

	public static void scrollTillMobileElementDisplayed(int maxNumberOfScrolls)
			throws TimeoutException, InterruptedException {
		boolean isElementDisplayed = false;
		try {
			isElementDisplayed = GlobalUtil.mdriver.findElement(By.xpath("//*[@resource-id='add-to-cart-button']"))
					.isDisplayed();
		} catch (NoSuchElementException e) {
		}

		int i = 5;
		while (!isElementDisplayed) {
			if (i == maxNumberOfScrolls)
				break;
			Thread.sleep(100);
			verticalSwipeDown();
			Thread.sleep(100);
			try {
				isElementDisplayed = GlobalUtil.mdriver.findElement(By.xpath("//*[@resource-id='add-to-cart-button']"))
						.isDisplayed();
			} catch (NoSuchElementException e) {
			}
			i += 1;
		}
	}

	public static void scrollscroll() throws InterruptedException {
		Dimension dim = GlobalUtil.mdriver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		LogUtil.infoLog(thisClass, "Width " + width);
		LogUtil.infoLog(thisClass, "Height" + height);

		int x = width / 2;
		int top_y = (int) (height * 0.80);
		int bottom_y = (int) (height * 0.20);
		@SuppressWarnings("rawtypes")
		TouchAction ts = new TouchAction(GlobalUtil.mdriver);
		ts.longPress(PointOption.point(x, top_y)).moveTo(PointOption.point(x, bottom_y)).release().perform();

	}

	public static void scrollToMobileElement(MobileElement element, int scrollCount) {
		try {
			for (int i = 0; i < scrollCount; i++) {
				if (isElementDisplayed(element)) {
					break;
				} else {
					swipeUp();
				}
			}
		} catch (Exception e) {
			LogUtil.errorLog(thisClass, "Scroll to mobile element failed");
		}
	}

	@SuppressWarnings("rawtypes")
	public static void swipeUp() {
		Dimension dim = GlobalUtil.getMDriver().manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width / 2;
		int top_y = (int) (height * 0.80);
		int bottom_y = (int) (height * 0.20);
		LogUtil.infoLog(thisClass, "coordinates :" + x + "  " + top_y + " " + bottom_y);
		TouchAction ts = new TouchAction(GlobalUtil.getMDriver());
		ts.press(PointOption.point(x, top_y)).moveTo(PointOption.point(x, bottom_y)).release().perform();
	}

	public static boolean isElementDisplayed(MobileElement locator) {
		try {
			if (locator.isDisplayed())
				LogUtil.infoLog(thisClass, "Element present on screen ***********" + locator);
			return true;
		} catch (NoSuchElementException e) {
			LogUtil.errorLog(thisClass, "Element not present on screen **************" + locator);
			return false;
		}
	}

	public static void scrollToId(AndroidDriver<MobileElement> driver, String id) {

		int pressX = driver.manage().window().getSize().width / 2;
		int bottomY = driver.manage().window().getSize().height * 4 / 5;
		int topY = driver.manage().window().getSize().height / 8;

		int i = 0;

		do {

			int kk = GlobalUtil.mdriver.findElements(By.xpath("//*[@resource-id='add-to-cart-button']")).size();
			if (kk > 0) {
				WebElement we = GlobalUtil.mdriver.findElement(By.xpath("//*[@resource-id='add-to-cart-button']"));
				we.click();
				break;
			} else {
				scroll(pressX, bottomY, pressX, topY);
			}
			i++;

		} while (i <= 5);
	}

	@SuppressWarnings("rawtypes")
	private static void scroll(int fromX, int fromY, int toX, int toY) {

		TouchAction touchAction = new TouchAction(GlobalUtil.mdriver);
		touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
	}

	public static void AmazonScroll() {
		try {

			Point value = null;
			value = GlobalUtil.mdriver.findElement(By.xpath("//*[@resource-id='add-to-cart-button']")).getLocation();
			int x = value.x;
			int y = value.y;
			int y1 = value.y + 450;
			Amazonswipe(x, y, x, y1);
		} catch (Exception e) {
			LogUtil.errorLog(thisClass, e.getMessage());
		}
	}

	@SuppressWarnings("rawtypes")
	public static void Amazonswipe(int fromX, int fromY, int toX, int toY) {

		TouchAction action = new TouchAction(GlobalUtil.mdriver);
		action.press(PointOption.point(fromX, fromY))
				.waitAction(new WaitOptions().withDuration(Duration.ofMillis(3000))) // you can change wait durations as
																						// per your requirement
				.moveTo(PointOption.point(toX, toY)).release().perform();
	}

	public static boolean click(String path, String type) {
		executionDelay(1500);
		WebElement element = GlobalUtil.getMDriver().findElement(locatortype(type, path));
		element.click();
		return true;
	}

	public static void AmazonscrollNClick() {

	}

	@SuppressWarnings("rawtypes")
	public static void AAscrollDown() {
		Dimension dimension = GlobalUtil.mdriver.manage().window().getSize();
		int scrollStart = (int) (dimension.getHeight() * 0.5);
		int scrollEnd = (int) (dimension.getHeight() * 0.2);

		new TouchAction((PerformsTouchActions) GlobalUtil.mdriver).press(PointOption.point(0, scrollStart))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(0, scrollEnd))
				.release().perform();
	}

	public static void AmazonscrollAndClick(String visibleText) {
		GlobalUtil.mdriver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))")
				.click();

	}

}