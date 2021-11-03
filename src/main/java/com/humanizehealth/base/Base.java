package com.humanizehealth.base;


import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentReports;

import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

public class Base {

    public static AppiumDriver<MobileElement> driver;
    public static JSONObject userTestData;
    public static ExtentReports extent;
    public static ExtentTest logger;

    public Base() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @BeforeSuite
    public void beforeSuite() {
        extent = new ExtentReports("Reports/index.html", true);
        extent.addSystemInfo("Tester Name", "Viet Nguyen");
        extent.addSystemInfo("App", "Humanize Health QA");
        extent.addSystemInfo("Test Type", "Regression Test");
        extent.loadConfig(new File("./extent-report.xml"));
    }

    @AfterSuite
    public void afterSuite() {
        extent.flush();
    }

    @BeforeClass
    public void beforeClass() throws FileNotFoundException {
        File testDataFile = new File("src/main/resources/testData.json");
        FileInputStream inputStream = new FileInputStream(testDataFile);
        JSONTokener toker = new JSONTokener(inputStream);
        userTestData = new JSONObject(toker);
    }

    @Parameters({"platformName", "deviceName"})
    @BeforeMethod
    public void launchApp(String platformName, String deviceName, Method method) throws IOException {
        File config = new File("src/main/resources/config.properties");
        FileInputStream inputStream = new FileInputStream(config);
        Properties props = new Properties();
        props.load(inputStream);

        URL appiumServerURL = new URL(props.getProperty("appiumURL"));
        System.out.println(props.getProperty("androidAppWindows"));
        if (platformName.equalsIgnoreCase("android")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
            caps.setCapability(MobileCapabilityType.APP, props.getProperty("androidAppWindows"));
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
            caps.setCapability(MobileCapabilityType.ORIENTATION, "PORTRAIT");
//            caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.fluidity.MainActivity");
//            caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.humanize.heath.qa");

            driver = new AndroidDriver<MobileElement>(appiumServerURL, caps);
        } else {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone");
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS);
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.0");
            caps.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.humanize.health.qa");
            caps.setCapability(IOSMobileCapabilityType.APP_NAME, "HMN_QA");
            caps.setCapability(MobileCapabilityType.UDID, "56B05B33-8806-40C7-A852-6908C91A0298");
//            caps.setCapability(MobileCapabilityType.APP, props.getProperty("iosApp"));

            driver = new IOSDriver<MobileElement>(appiumServerURL, caps);
        }

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        logger = extent.startTest(method.getName());
    }

    @AfterMethod
    public void afterMethod(ITestResult result, Method method) throws IOException {
        File screenshotFile = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("Screenshots/" + method.getName() + ".png"));

        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, "The test case is failed");
            logger.log(LogStatus.FAIL, result.getThrowable());
            logger.log(LogStatus.INFO, logger.addScreenCapture("../Screenshots/" + method.getName() + ".png"));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(LogStatus.PASS, "The test case is passed");
            logger.log(LogStatus.INFO , logger.addScreenCapture("../Screenshots/" + method.getName() + ".png"));
        }
        extent.endTest(logger);
    }

}
