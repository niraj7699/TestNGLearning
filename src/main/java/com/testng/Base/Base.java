package com.testng.Base;

import com.testng.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


public class Base {
    protected  WebDriver driver;

    public void launchBrowser(){
        ConfigReader.loadProperties();
        String browser=ConfigReader.getProperty("browser");
        switch (browser.toLowerCase()){
            case "chrome":
                driver=new ChromeDriver();
                break;
            case "firefox":
                driver=new FirefoxDriver();
                break;
            case "edge":
                driver=new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser is not Supported: "+browser);
        }

    }


    @BeforeClass
    public void setUp(){
        ConfigReader.loadProperties();
        WebDriverManager.chromedriver().setup();
        launchBrowser();
        String baseURL=ConfigReader.getProperty("baseURL");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(baseURL);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

   public static void enterText(String text, WebElement element){
        element.sendKeys(text);
   }

    public static void click(WebElement element){
        element.click();
    }

    public static void clearContent(WebElement element){
        element.clear();
    }

    public static String getText(WebElement element){
        return element.getText();
    }

    public static String getAttribute(WebElement element,String attributeName){
        return element.getAttribute(attributeName);
    }

    public static boolean isDisplayed(WebElement element){
        return element.isDisplayed();
    }

    public static boolean isEnabled(WebElement element){
        return element.isEnabled();
    }

    public static boolean isSelected(WebElement element){
        return element.isSelected();
    }

    public static void selectByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public static void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static List<String> getAllDropdownOptions(WebElement element) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        List<String> optionTexts = new ArrayList<>();
        for (WebElement option : options) {
            optionTexts.add(option.getText());
        }
        return optionTexts;
    }

    // Accept the alert (click OK)
    public static void acceptAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    // Dismiss the alert (click Cancel)
    public static void dismissAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    // Get text from the alert
    public static String getAlertText(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    // Send text to the alert (for prompt alerts)
    public static void sendTextToAlert(WebDriver driver, String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
    }

    // Check if alert is present (optional utility method)
    public static boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Hover over an element
    public static void hoverOverElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    // Double click on an element
    public static void doubleClickElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    // Right click (context click) on an element
    public static void rightClickElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    // Drag and drop from source to target
    public static void dragAndDropElement(WebDriver driver, WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }

    // Send keyboard key (e.g. ENTER, TAB, ESC)
    public static void pressKey(WebDriver driver, Keys key) {
        Actions actions = new Actions(driver);
        actions.sendKeys(key).perform();
    }

    // Click and hold an element
    public static void clickAndHold(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).perform();
    }

    // Release held mouse button
    public static void releaseMouse(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.release().perform();
    }

    public static void setImplicitWait(WebDriver driver, int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public static WebElement waitForElementVisible(WebDriver driver, By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static boolean waitForInvisibilityOfElement(WebDriver driver, By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementClickable(WebDriver driver, By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForTitleContains(WebDriver driver, String titlePart, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.titleContains(titlePart));
    }

    public static WebElement fluentWaitForElement(WebDriver driver, By locator, int timeoutSeconds, int pollingSeconds) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofSeconds(pollingSeconds))
                .ignoring(Exception.class);

        return wait.until(driver1 -> driver1.findElement(locator));
    }

    // Switch to window by title
    public static void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(title)) {
                break;
            }
        }
    }

    // Switch to newly opened window
    public static void switchToNewWindow(WebDriver driver) {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    // Close all other windows except the main one
    public static void closeAllOtherWindows(WebDriver driver) {
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
    }

    // Switch to frame by index
    public static void switchToFrameByIndex(WebDriver driver, int index) {
        driver.switchTo().frame(index);
    }

    // Switch to frame by name or ID
    public static void switchToFrameByNameOrId(WebDriver driver, String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    // Switch to frame by WebElement
    public static void switchToFrameByElement(WebDriver driver, WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    // Switch back to default content
    public static void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public static void takeScreenshot(WebDriver driver, String filePath) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(filePath);
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot saved at: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    public static void takeScreenshotWithTimestamp(WebDriver driver, String folderPath, String fileNamePrefix) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fullPath = folderPath + File.separator + fileNamePrefix + "_" + timestamp + ".png";
        takeScreenshot(driver, fullPath);
    }

    public static void scrollByPixels(WebDriver driver, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void clickElementByJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }


}
