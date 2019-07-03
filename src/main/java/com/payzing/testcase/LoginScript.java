package com.payzing.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.payzing.actions.LogInPage;

import CommonPage.CommonTestcase;

public class LoginScript extends CommonTestcase {
	WebDriver driver;

	LogInPage loginPage;

	@Parameters({ "browser", "version", "url" })

	@BeforeClass

	public void beforeClass(String browser, String version, String url) {

		inititalReport("NhutBM_Webpay_TestCase_Login.html");
		driver = openMultiBrowser(browser, version, url);

		loginPage = PageFactory.initElements(driver, LogInPage.class);

	}

//	@BeforeMethod

	public void beforeMethod() throws InterruptedException {
		loginPage.openUrl("https://pay.zing.vn/");

		loginPage.inputTXT_TIMKIEMGAME("vo lam truyen ky mobile");

		Thread.sleep(3000);

		loginPage.clickKETQUA_TIMKIEM();

	}

	@Test
	public void testcase_01_Dont_input_username_password() throws InterruptedException {

		logTestCase("ZingID: Don't input username + password");

		loginPage.openUrl("https://pay.zing.vn/");

		loginPage.inputTXT_TIMKIEMGAME("vo lam truyen ky mobile");

		Thread.sleep(3000);

		loginPage.clickKETQUA_TIMKIEM();

		loginPage.clickBTT_DangNhap();

		verifyEqual(loginPage.getText_Null_UserName_Password(), "Vui lòng nhập tài khoản ZingID");
	}

	@Test
	public void testcase_02_Only_Type_Input_UserName() {

		logTestCase("ZingID: Only input username");

		loginPage.input_Username_TXT("giinboo1");

		loginPage.clickBTT_DangNhap();

		verifyEqual(loginPage.getText_OnlyType_Username(), "Vui lòng nhập mật khẩu");

		loginPage.clearByJs("$('input#u').val(\"\")");
	}

	@Test
	public void testcase_03_Only_Type_Input_Password() {

		logTestCase("ZingID: Only input password");

		loginPage.input_Password_TXT("Aa123456!");

		loginPage.clickBTT_DangNhap();

		verifyEqual(loginPage.getText_OnlyType_Password(), "Vui lòng nhập tài khoản ZingID");

		loginPage.clearByJs("$('input#p').val(\"\")");
	}

	@Test
	public void testcase_04_Type_Invalid_Account() throws InterruptedException {

		logTestCase("ZingID: Login with invalid account");

		loginPage.input_Username_TXT("giinboo123456");

		loginPage.input_Password_TXT("Aa123456!");

		loginPage.clickBTT_DangNhap();

		Thread.sleep(3000);

		verifyEqual(loginPage.getText_Invalid_Account(), "Thông tin đăng nhập không chính xác");

		loginPage.clearByJs("$('input#u').val(\"\")");

		loginPage.clearByJs("$('input#p').val(\"\")");

	}

	@Test
	public void testcase_05_Login_account_ZingID_success() throws InterruptedException {

		logTestCase("ZingID: Login successfully");

		loginPage.input_Username_TXT("giinboo1");

		loginPage.input_Password_TXT("Aa123456!");

		loginPage.clickBTT_DangNhap();

		Thread.sleep(4000);

//		verifyEqual(loginPage.getText_Title_Game(), "Võ Lâm Truyền Kỳ Mobile");

//		Thread.sleep(1000);

		loginPage.clickBTT_Thoat();
	}

//		// get all Selector
//		List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'am-selected am-dropdown')]"));
//		WebElement eleCumMayChu = null;
//		WebElement eleMayChu = null;
//		WebElement eleNhanVat = null;
//
//		if (list.size() == 3) {
//			eleCumMayChu = list.get(0);
//			eleMayChu = list.get(1);
//			eleNhanVat = list.get(2);
//		} else if (list.size() == 2) {
//			eleMayChu = list.get(0);
//			eleNhanVat = list.get(1);
//		} else {
//			eleNhanVat = list.get(0);
//		}
//
//		if (eleCumMayChu != null) {
//			loginPage.clickDropDown_CumMayChu(eleCumMayChu);
//			Thread.sleep(500);
//			String locator = String.format(LogInPageUI.LIST_ITEM_CUMMAYCHU, "Cụm máy chủ 41 - 50");
//			loginPage.selectDropdown_CumMayChu(eleCumMayChu, locator);
//		}
//
//		Thread.sleep(1000);
//
//		if (eleMayChu != null) {
//			loginPage.clickDropDown_MayChu(eleMayChu);
//			Thread.sleep(500);
//			String locator = String.format(LogInPageUI.LIST_ITEM_MAYCHU, "S44-Bắc Sơn");
//			loginPage.selectDropdown_MayChu(eleMayChu, locator);
//		}
//
//		Thread.sleep(2000);
//
//		if (eleNhanVat != null) {
//
//			loginPage.clickDropDown_NhanVat(eleNhanVat);
//			Thread.sleep(500);
//			String locator = String.format(LogInPageUI.LIST_ITEM_NHANVAT, "GiinVD");
//			loginPage.selectDropdown_NhanVat(eleNhanVat, locator);
//		}

	@Test
	public void testcase_06_select_quicklogin() {

		logTestCase("Email: Select login by email");

		loginPage.clickQuickLogin_Icon();
	}

	@Test
	public void testcase_07_QuickLogin_Dont_type_Username_and_password() {

		logTestCase("Email: Don't input username + password");

		loginPage.clickBTT_DangNhap();

		verifyEqual(loginPage.getText_Null_UserName_Password(), "Vui lòng nhập email bảo vệ tài khoản");
	}

	@Test
	public void testcase_08_QuickLogin_Only_type_Username() {

		logTestCase("Email: Only input username ");

		loginPage.input_Username_TXT("nhutne123456@gmail.com");

		loginPage.clickBTT_DangNhap();

		verifyEqual(loginPage.getText_OnlyType_Username(), "Vui lòng nhập mật khẩu");

		loginPage.clearByJs("$('input#u').val(\"\")");

	}

	@Test
	public void testcase_09_QuickLogin_Only_type_Password() {

		logTestCase("Email: Only input password ");

		loginPage.input_Password_TXT("1234534646");

		loginPage.clickBTT_DangNhap();

		verifyEqual(loginPage.getText_OnlyType_Password(), "Vui lòng nhập email bảo vệ tài khoản");

		loginPage.clearByJs("$('input#p').val(\"\")");
	}

	@Test
	public void testcase_10_QuickLogin_Login_account_invalid() throws InterruptedException {

		logTestCase("Email: Login with invalid account");

		loginPage.input_Username_TXT("nhutneTVXQ@gmail.com");

		loginPage.input_Password_TXT("1234534646");

		loginPage.clickBTT_DangNhap();

		Thread.sleep(2000);

		verifyEqual(loginPage.getText_Invalid_Account(), "Thông tin đăng nhập không chính xác");
		
	}

	@Test
	public void testcase_11_QuickLogin_Login_success() throws InterruptedException {
		
		logTestCase("Email: Login success");
		
		loginPage.clearByJs("$('input#u').val(\"\")");
		
		loginPage.clearByJs("$('input#p').val(\"\")");

		loginPage.input_Username_TXT("nhutne555@gmail.com");

		loginPage.input_Password_TXT("Aa123456!");

		loginPage.clickBTT_DangNhap();

		Thread.sleep(2000);

		loginPage.clickBTT_Thoat();
	}
	
	@Test
	public void testcase_12_Login_By_Zalo() throws InterruptedException {

		logTestCase("Zalo: Direct screen login by zalo");
		
		Thread.sleep(2000);
		
		loginPage.clickZalo_Icon();
		
		loginPage.backToPage();
	}
	
	@Test
	public void testcase_13_Login_By_Facebook() throws InterruptedException {

		logTestCase("Facebook: Direct screen login by Facebook");
		
		Thread.sleep(2000);
		
		loginPage.clickFaceBook_Icon();
		
		loginPage.backToPage();
	}

	@Test
	public void testcase_14_Role_Ingame_Verify_display_srceen_login() throws InterruptedException {

		logTestCase("Role Ingame: Verify display srceen login");

		Thread.sleep(2000);

		loginPage.openUrl("https://pay.zing.vn/");

		Thread.sleep(2000);

		loginPage.inputTXT_TIMKIEMGAME("rules of survival");

		Thread.sleep(1500);

		loginPage.clickKETQUA_TIMKIEM();

		Thread.sleep(1500);

		loginPage.clickXacNhan_ID_NHANVAT();

	}

	@Test
	public void testcase_15_Login_By_Name_Ingame_Verify_message_when_null_information() throws InterruptedException {

		logTestCase("Role Ingame: Verify message when click button Xac Nhan");

		Thread.sleep(1500);

		loginPage.clickIDNHANVAT_FORM_BTT_XACNHAN();

		verifyEqual(loginPage.getText_IDNHANVAT_FORM_MESS(), "Vui lòng chọn máy chủ");
	}

	@Test
	public void testcase_16_Login_By_Name_Ingame_Verify_message_when_only_input_Name() throws InterruptedException {
		logTestCase("Role Ingame: Verify message when only input Ten nhan vat");

		Thread.sleep(1500);

		loginPage.inputIDNHANVAT_FORM_TXT_NHANVAT("Wasurenaide");

		Thread.sleep(1000);

		loginPage.cleanIDNHANVAT_FORM_TXT_NHANVAT();

		loginPage.inputIDNHANVAT_FORM_TXT_NHANVAT("Xoa va nhap lai");

		loginPage.clickIDNHANVAT_FORM_BTT_XACNHAN();

		verifyEqual(loginPage.getText_IDNHANVAT_FORM_MESS(), "Vui lòng chọn máy chủ");

	}

	@Test
	public void testcase_17_Login_By_Name_Ingame_Verify_message_when_only_select_Server() throws InterruptedException {

		logTestCase("Role Ingame: Verify message when only select server");

		Thread.sleep(1500);

		loginPage.cleanIDNHANVAT_FORM_TXT_NHANVAT();

		loginPage.clickIDNHANVAT_FORM_DROPDOWN_MAYCHU();

		Thread.sleep(1000);

		loginPage.selectIDNHANVAT_FORM_DROPDOWN_OPTION_MAYCHU("Asia");

		Thread.sleep(1000);

		loginPage.clickIDNHANVAT_FORM_BTT_XACNHAN();

		verifyEqual(loginPage.getText_IDNHANVAT_FORM_MESS(), "Vui lòng nhập tên nhân vật");
	}

	@Test
	public void testcase_18_Login_By_Name_Ingame_Verify_message_when_input_invalid_information()
			throws InterruptedException {
		logTestCase("Role Ingame: Verify message when input invalid information");

		Thread.sleep(1000);

		loginPage.clickIDNHANVAT_FORM_DROPDOWN_MAYCHU();

		Thread.sleep(1000);

		loginPage.selectIDNHANVAT_FORM_DROPDOWN_OPTION_MAYCHU("Japan");

		Thread.sleep(1000);

		loginPage.inputIDNHANVAT_FORM_TXT_NHANVAT("GiinTHSK");

		Thread.sleep(1000);

		loginPage.clickIDNHANVAT_FORM_BTT_XACNHAN();

		verifyEqual(loginPage.getText_IDNHANVAT_FORM_MESS(), "Thông tin nhân vật không tìm thấy");

		Thread.sleep(1000);

		loginPage.cleanIDNHANVAT_FORM_TXT_NHANVAT();

		Thread.sleep(500);

		loginPage.inputIDNHANVAT_FORM_TXT_NHANVAT("550403 ");
		
		Thread.sleep(500);

		loginPage.clickIDNHANVAT_FORM_BTT_XACNHAN();
		
		verifyEqual(loginPage.getText_IDNHANVAT_FORM_MESS(), "Tên nhân vật phải có độ dài từ 1 đến 16 ký tự");

	}

	@Test
	public void testcase_19_Login_By_Name_Ingame_Verify_message_when_input_roleID() throws InterruptedException {

		logTestCase("Role Ingame: Verify message when input invalid information");

		Thread.sleep(1000);

		loginPage.clickIDNHANVAT_FORM_DROPDOWN_MAYCHU();

		Thread.sleep(1000);

		loginPage.selectIDNHANVAT_FORM_DROPDOWN_OPTION_MAYCHU("Asia");

		Thread.sleep(1000);

		loginPage.cleanIDNHANVAT_FORM_TXT_NHANVAT();

		Thread.sleep(500);

		loginPage.inputIDNHANVAT_FORM_TXT_NHANVAT("550403");

		Thread.sleep(500);

		loginPage.clickIDNHANVAT_FORM_BTT_XACNHAN();
	}

	@Test
	public void testcase_20_Login_By_Name_Ingame_Verify_login_success() throws InterruptedException {
		logTestCase("Role Ingame: Verify message when input invalid information");

		Thread.sleep(1000);

		loginPage.clickIDNHANVAT_FORM_DROPDOWN_MAYCHU();

		Thread.sleep(1000);

		loginPage.selectIDNHANVAT_FORM_DROPDOWN_OPTION_MAYCHU("Asia");

		Thread.sleep(1000);

		loginPage.cleanIDNHANVAT_FORM_TXT_NHANVAT();

		Thread.sleep(500);

		loginPage.inputIDNHANVAT_FORM_TXT_NHANVAT("Giin");

		Thread.sleep(500);

		loginPage.clickIDNHANVAT_FORM_BTT_XACNHAN();
		
		loginPage.clickIDNHANVAT_FORM_POPUP_BTT_HUY();
	}
	
	@Test
	public void testcase_21_Login_By_Role_Ingame_Verify_message_when_null_information() throws InterruptedException {
		
		logTestCase("Role Ingame: Verify message when click button Xac Nhan");
		
		loginPage.openUrl("https://pay.zing.vn/");

		Thread.sleep(2000);

		loginPage.inputTXT_TIMKIEMGAME("rules of survival");

		Thread.sleep(1500);

		loginPage.clickKETQUA_TIMKIEM();

		Thread.sleep(1500);

		loginPage.clickXacNhan_ID_NHANVAT();
		
		Thread.sleep(2000);
		
		loginPage.clickIDNHANVAT_FORM_ROLE_ID();
		
		Thread.sleep(1500);
		
		loginPage.clickIDNHANVAT_FORM_BTT_XACNHAN();

		verifyEqual(loginPage.getText_IDNHANVAT_FORM_MESS(), "Vui lòng chọn máy chủ");
	}

	@Test
	public void testcase_22_Login_By_Role_Ingame_Verify_message_when_only_input_Name() throws InterruptedException {
		logTestCase("Role Ingame: Verify message when only input Ten nhan vat");

		Thread.sleep(1500);

		loginPage.inputIDNHANVAT_FORM_TXT_NHANVAT("Wasurenaide");

		Thread.sleep(1000);

		loginPage.cleanIDNHANVAT_FORM_TXT_NHANVAT();

		loginPage.inputIDNHANVAT_FORM_TXT_NHANVAT("Xoa va nhap lai");

		loginPage.clickIDNHANVAT_FORM_BTT_XACNHAN();

		verifyEqual(loginPage.getText_IDNHANVAT_FORM_MESS(), "Vui lòng chọn máy chủ");

	}

	@Test
	public void testcase_23_Login_By_Role_Ingame_Verify_message_when_only_select_Server() throws InterruptedException {

		logTestCase("Role Ingame: Verify message when only select server");

		Thread.sleep(1500);

		loginPage.cleanIDNHANVAT_FORM_TXT_NHANVAT();

		loginPage.clickIDNHANVAT_FORM_DROPDOWN_MAYCHU();

		Thread.sleep(1000);

		loginPage.selectIDNHANVAT_FORM_DROPDOWN_OPTION_MAYCHU("Asia");

		Thread.sleep(1000);

		loginPage.clickIDNHANVAT_FORM_BTT_XACNHAN();

		verifyEqual(loginPage.getText_IDNHANVAT_FORM_MESS(), "Vui lòng nhập tên nhân vật");
	}

	@Test
	public void testcase_24_Login_By_Role_Ingame_Verify_message_when_input_invalid_information()
			throws InterruptedException {
		logTestCase("Role Ingame: Verify message when input invalid information");

		Thread.sleep(1000);

		loginPage.clickIDNHANVAT_FORM_DROPDOWN_MAYCHU();

		Thread.sleep(1000);

		loginPage.selectIDNHANVAT_FORM_DROPDOWN_OPTION_MAYCHU("Japan");

		Thread.sleep(1000);

		loginPage.inputIDNHANVAT_FORM_TXT_NHANVAT("GiinTHSK");

		Thread.sleep(1000);

		loginPage.clickIDNHANVAT_FORM_BTT_XACNHAN();

		verifyEqual(loginPage.getText_IDNHANVAT_FORM_MESS(), "Thông tin nhân vật không tìm thấy");

		Thread.sleep(1000);

		loginPage.cleanIDNHANVAT_FORM_TXT_NHANVAT();

		Thread.sleep(500);

		loginPage.inputIDNHANVAT_FORM_TXT_NHANVAT("550403 ");
		
		Thread.sleep(500);

		loginPage.clickIDNHANVAT_FORM_BTT_XACNHAN();
		
		verifyEqual(loginPage.getText_IDNHANVAT_FORM_MESS(), "Tên nhân vật phải có độ dài từ 1 đến 16 ký tự");

	}

	@Test
	public void testcase_25_Login_By_Role_Ingame_Verify_message_when_input_roleID() throws InterruptedException {

		logTestCase("Role Ingame: Verify message when input invalid information");

		Thread.sleep(1000);

		loginPage.clickIDNHANVAT_FORM_DROPDOWN_MAYCHU();

		Thread.sleep(1000);

		loginPage.selectIDNHANVAT_FORM_DROPDOWN_OPTION_MAYCHU("Asia");

		Thread.sleep(1000);

		loginPage.cleanIDNHANVAT_FORM_TXT_NHANVAT();

		Thread.sleep(500);

		loginPage.inputIDNHANVAT_FORM_TXT_NHANVAT("Giin");

		Thread.sleep(500);

		loginPage.clickIDNHANVAT_FORM_BTT_XACNHAN();
	}

	@Test
	public void testcase_26_Login_By_Role_Ingame_Verify_login_success() throws InterruptedException {
		logTestCase("Role Ingame: Verify message when input invalid information");

		Thread.sleep(1000);

		loginPage.clickIDNHANVAT_FORM_DROPDOWN_MAYCHU();

		Thread.sleep(1000);

		loginPage.selectIDNHANVAT_FORM_DROPDOWN_OPTION_MAYCHU("Asia");

		Thread.sleep(1000);

		loginPage.cleanIDNHANVAT_FORM_TXT_NHANVAT();

		Thread.sleep(500);

		loginPage.inputIDNHANVAT_FORM_TXT_NHANVAT("550403");

		Thread.sleep(500);

		loginPage.clickIDNHANVAT_FORM_BTT_XACNHAN();
		
		Thread.sleep(500);
		
		loginPage.clickIDNHANVAT_FORM_POPUP_BTT_XACNHAN();
		
		verifyEqual(loginPage.getTitle(), "ROS MOBILE");

	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		getResult(result);
	}

	@AfterClass
	public void afterClass() {

		exportReport();
//		driver.quit();
	}
}
