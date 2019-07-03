package CommonPage;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonFunction extends BasePage {

	public commonFunction(WebDriver driver) {
		super(driver);
	}

	private int timeouts = 100;

	public void openUrl(String url) {
		driver.get(url);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void click(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void backToPage() {
		driver.navigate().back();
	}

	public void forwardToPage() {
		driver.navigate().forward();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void clear(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
	}

	public void input(String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}
	
	public void selectCombobox(String locator, String value) {
		Select select = new Select(driver.findElement(By.xpath(locator)));

		select.selectByVisibleText(value);

	}

	// Combobox dac biet

	public void selectCombobox_Special(WebElement ele, String locator) {
		WebElement e = ele.findElement(By.xpath(locator));
		e.click();
	}
	
	//Dropdown
	public void selectDropdown(String locator, String value)
	{
		List<WebElement> list = driver.findElements(By.xpath(locator));
    	for (WebElement elementList : list) {
			if (elementList.getText().equals(value)) {
				elementList.click();
				break;
			}
		}
	}

	public String getTextComboboxSelected(String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();
	}

	public String getAtribute(String locator, String attribute) {

		WebElement element = driver.findElement(By.xpath(locator));

		return element.getAttribute(attribute);
	}

	public String getText(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public int getSizeList(String locator) {
		List<WebElement> list = driver.findElements(By.xpath(locator));
		return list.size();
	}

	public boolean isDisplayed(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isSelected(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isEnabled(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getTextAlert() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void inputAlert(String value)

	{
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);

	}

	public void switchWindowByTitle(String title)

	{
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindows : allWindows) {
			driver.switchTo().window(childWindows);
			String childTitle = driver.getTitle();
			if (childTitle.equals(title)) {
				break;
			}
		}

	}

	public String getWindow() {
		return driver.getWindowHandle();// lấy 1 window hiện tại
	}

	public void switchToIframe(String locator) {
		WebElement iframeLookingfor = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(iframeLookingfor);

	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public void hover(String locator) {

		WebElement hoverElement = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(hoverElement).perform();

	}

	public void doubleClick(String locator) {
		WebElement btnDouble = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.doubleClick(btnDouble).perform();

	}

	public void rightClick(String locator) {
		WebElement rightBtn = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver).contextClick(rightBtn);
		action.build().perform();

	}

	public void dragAndDrop(String locatorFrom, String locatorTarget) {
		WebElement dragFrom = driver.findElement(By.xpath(locatorFrom));
		WebElement target = driver.findElement(By.xpath(locatorTarget));
		Actions action = new Actions(driver);
		Action dragAndDrop = action.clickAndHold(dragFrom).moveToElement(target).release(target).build();
		dragAndDrop.perform();

	}

	public void clickAndHold(String locator, int itemFrom, int itemTarget) {
		List<WebElement> listItems = driver.findElements(By.xpath(locator));
		Actions action = new Actions(driver);
		action.clickAndHold(listItems.get(itemFrom)).clickAndHold(listItems.get(itemTarget)).click().perform();
		action.release();

	}

	public void inputKeys(String locator, Keys key) {

		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(key);

	}

	public void inputDoubleKeys(String locator, Keys key1, String key2) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(Keys.chord(key1, key2));
	}

	public void uploadBySendKeys(String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);

	}

	public void uploadByRobot(String locator, String value) throws InterruptedException, Exception {
		StringSelection select = new StringSelection(value);
		WebElement btnBrowse = driver.findElement(By.xpath(locator));
		btnBrowse.click();
		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

		Robot robot = new Robot();
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void executeScriptBrowser(String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(javaScript);

	}

	public void clickByJs(String locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(locator));
		js.executeScript("arguments[0].click();", element);

	}

	public void scrollToBottomPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}

	public void highlight(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style='border: 2px solid; border-color: red'", element);
	}

	public void removeAttribute(String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
	}

	public void waitPresence(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}

	public void waitVisible(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitAlertPresence() {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitVisibleDynamicElement(String locator, String... dynamic) {
		String dynamicLocator = String.format(locator, (Object[]) dynamic);
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicLocator)));
	}

	public void inputDynamicElement(String locator, String value, String... dynamic) {
		String dynamicLocator = String.format(locator, (Object[]) dynamic);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		element.sendKeys(value);
	}

	public void clickDynamicElement(String locator, String... dynamic) {
		String dynamicLocator = String.format(locator, (Object[]) dynamic);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		element.click();
	}

	public String getTextDynamicElement(String locator, String... dynamic) {
		String dynamicLocator = String.format(locator, (Object[]) dynamic);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		return element.getText();

	}

//Random click random option combobox
	public void clickRandomOptionInCombobox(String locator) {

		List<WebElement> selects = driver.findElements(By.xpath(locator));
		Random rand = new Random();
		int list = rand.nextInt(selects.size());
		selects.get(list).click();
	}

//Kiem tra element co hien thi
	public boolean checkElementDisplay(String locator) {
		Boolean isPresent = driver.findElements(By.xpath(locator)).size() > 0;
		return isPresent;
	}
	
	

}
