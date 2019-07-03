package com.payzing.testcase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.payzing.actions.HomePage;
import com.payzing.actions.LogInPage;

import CommonPage.CommonTestcase;

public class HomePageScript_Game_Convert extends CommonTestcase {

	WebDriver driver;

	LogInPage loginPage;

	HomePage homePage;

	@Parameters({ "browser", "version", "url" })

	@BeforeClass

	public void beforeClass(String browser, String version, String url) throws InterruptedException {

		inititalReport("Nhutbm_Webpay_Convert_10062019.html");

		driver = openMultiBrowser(browser, version, url);

		loginPage = PageFactory.initElements(driver, LogInPage.class);

		loginPage.openUrl("https://pay.zing.vn/");

		loginPage.inputTXT_TIMKIEMGAME("crossfire");

		Thread.sleep(3000);

		loginPage.clickKETQUA_TIMKIEM();

		loginPage.input_Username_TXT("giinboo1");

		loginPage.input_Password_TXT("Aa123456!");

		homePage = loginPage.clickBTT_DangNhap();

		Thread.sleep(3000);

//		verifyEqual(homePage.getText_Title_Game(), "Võ Lâm Truyền Kỳ Mobile");

		// get all Selector

		/*
		 * List<WebElement> list = driver.findElements(By.
		 * xpath("//div[contains(@class,'am-selected am-dropdown')]")); WebElement
		 * eleCumMayChu = null; WebElement eleMayChu = null; WebElement eleNhanVat =
		 * null;
		 * 
		 * if (list.size() == 3) { eleCumMayChu = list.get(0); eleMayChu = list.get(1);
		 * eleNhanVat = list.get(2); } else if (list.size() == 2) { eleMayChu =
		 * list.get(0); eleNhanVat = list.get(1); } else { eleNhanVat = list.get(0); }
		 * 
		 * if (eleCumMayChu != null) { homePage.clickDropDown_CumMayChu(eleCumMayChu);
		 * Thread.sleep(500); String locator =
		 * String.format(HomePageUI.LIST_ITEM_CUMMAYCHU, "Cụm máy chủ 1 - 10");
		 * homePage.selectDropdown_CumMayChu(eleCumMayChu, locator); }
		 * 
		 * Thread.sleep(1000);
		 * 
		 * if (eleMayChu != null) { homePage.clickDropDown_MayChu(eleMayChu);
		 * Thread.sleep(500); String locator =
		 * String.format(HomePageUI.LIST_ITEM_MAYCHU, "MUS30");
		 * homePage.selectDropdown_MayChu(eleMayChu, locator); }
		 * 
		 * Thread.sleep(2000);
		 * 
		 * if (eleNhanVat != null) {
		 * 
		 * homePage.clickDropDown_NhanVat(eleNhanVat); Thread.sleep(500); String locator
		 * = String.format(HomePageUI.LIST_ITEM_NHANVAT, "GiinArcher | Level: 426");
		 * homePage.selectDropdown_NhanVat(eleNhanVat, locator);
		 * 
		 * }
		 * 
		 * Thread.sleep(2000);
		 * 
		 * homePage.clickBTT_XacNhan();
		 * 
		 * homePage.clickPOPUP_XacNhan();
		 */

	}

//	@BeforeMethod

	public void beforeMethod() throws InterruptedException {

		homePage.openUrl("https://pay.zing.vn/mobile/mum/#/pay");

		Thread.sleep(1000);

		List<WebElement> listPkg = driver.findElements(By.xpath("//div[@class='am-tab-panel am-active am-in']//input"));

		if (listPkg == null || listPkg.isEmpty()) {
			listPkg = driver.findElements(By.xpath("//div[@class='am-tab-panel am-active']//input"));

		}
		List<String> lstPkgId = new ArrayList();
		for (WebElement elementList : listPkg) {
			String idPkg = elementList.getAttribute("id");
			if (idPkg != null) {
				lstPkgId.add(idPkg);
			}
		}

		Random rand = new Random();

		Long limitPrice = Long.valueOf(0);

		int rndPkgId;
		do {

			rndPkgId = rand.nextInt(lstPkgId.size());
			String dataInput = driver.findElement(By.xpath("//input[@id='" + lstPkgId.get(rndPkgId) + "']"))
					.getAttribute("data-price");
			if (dataInput != null && dataInput != "") {
				limitPrice = Long.valueOf(dataInput);
			}
		} while (limitPrice < 50000 && limitPrice >= 5000000);// ngc lai so can

//		System.out.println(limitPrice + " - " + lstPkgId.get(rndPkgId));

		homePage.click("//img[@id='img" + lstPkgId.get(rndPkgId).substring(4) + "']");

		Thread.sleep(1000);

		homePage.clickXacNhan_ChonPack();

		Thread.sleep(2000);

	}

	@Test
	public void testcase_01_ZaloPay_Verify_message_when_delete_price() throws InterruptedException {

//		homePage.clickPackage50();

		logTestCase("ZaloPay: Verify message when delete price");

		Thread.sleep(1000);

		homePage.clearSoTienThanhToan_TXT_ZaloPay();

		verifyEqual(homePage.getText_Error_ZingCard(), "Số tiền thanh toán không hợp lệ.");
	}

	@Test
	public void testcase_02_ZaloPay_Verify_message_when_input_invalid_price() throws InterruptedException {

		logTestCase("ZaloPay: Verify message when input invalid price");

		Thread.sleep(1000);

		homePage.inputSoTienThanhToan_TXT_ZaloPay("4900");

		verifyEqual(homePage.getText_Error_ZingCard(), "Số tiền thanh toán không hợp lệ.");

		Thread.sleep(1000);

		homePage.clearSoTienThanhToan_TXT_ZaloPay();

		homePage.inputSoTienThanhToan_TXT_ZaloPay("5100");

		verifyEqual(homePage.getText_Error_ZingCard(), "Số tiền thanh toán không hợp lệ.");

		Thread.sleep(1000);

		homePage.clearSoTienThanhToan_TXT_ZaloPay();

		homePage.inputSoTienThanhToan_TXT_ZaloPay("99999");

		verifyEqual(homePage.getText_Error_ZingCard(), "Số tiền thanh toán không hợp lệ.");

		Thread.sleep(1000);

		homePage.clearSoTienThanhToan_TXT_ZaloPay();

		homePage.inputSoTienThanhToan_TXT_ZaloPay("19876500");

		verifyEqual(homePage.getText_Error_ZingCard(), "Số tiền thanh toán không hợp lệ.");
	}

	@Test
	public void testcase_03_ZaloPay_Verify_message_when_input_valid_price() throws InterruptedException {
		
		logTestCase("ZaloPay: Verify message when input valid price");
		
		System.out.println("----ZaloPay-----");

		homePage.clearSoTienThanhToan_TXT_ZaloPay();

		homePage.inputSoTienThanhToan_TXT_ZaloPay("100000");
		
		Thread.sleep(1000);

		homePage.clickXacNhan_ZaloPay();

		homePage.clickKiemTraKetQuaGiaoDich_ZaloPay();

		Thread.sleep(1500);

		System.out.println("	- Ma giao dich ZaloPay: " + homePage.getText_MaGiaoDich_ZaloPay());

		homePage.clickTiepTucThanhToan();

	}

	@Test
	public void testcase_04_ZingCard_Verify_display_form_input_information_card() throws InterruptedException {

		logTestCase("ZingID: Verify display form input information card");

		System.out.println("-----ZingCard-----");

		Thread.sleep(1000);

		homePage.clickPhuongThuc_ZingCard();

	}

	@Test
	public void testcase_05_ZingCard_Verify_display_message_when_dont_input_Seri_and_Pin_card()
			throws InterruptedException {

		logTestCase("ZingID: Verify display message when don't input Seri + Pin card ");

		Thread.sleep(1000);


		homePage.clickXacNhan_ZingCard();

		verifyEqual(homePage.getText_Error_ZingCard(), "Vui lòng nhập đúng thông tin trên thẻ");

		System.out.println("	- Khong nhap Seri + Pin: " + homePage.getText_Error_ZingCard());
	}

	@Test
	public void testcase_06_ZingCard_Verify_display_message_when_only_input_Seri() throws InterruptedException {

		logTestCase("ZingID: Verify display message when only input Seri");

		Thread.sleep(1000);


		homePage.inputSoSeri_ZingCard("Why did i fall in love with you");

		homePage.clickXacNhan_ZingCard();

		Thread.sleep(1500);

		verifyEqual(homePage.getText_Error_ZingCard(), "Sai định dạng thẻ. Vui lòng nhập lại");

		System.out.println("	- Chi nhap Seri Card: " + homePage.getText_Error_ZingCard());

	}

	@Test
	public void testcase_07_ZingCard_Verify_display_message_when_only_input_Pin() throws InterruptedException {

		logTestCase("ZingID: Verify display message when only input Pin");

		Thread.sleep(1000);

		homePage.cleanSoSeri_ZingCard();

		Thread.sleep(1000);

		homePage.inputMaThe_ZingCard("Toki wo tomete");

		homePage.clickXacNhan_ZingCard();

		Thread.sleep(1500);

		verifyEqual(homePage.getText_Error_ZingCard(), "Sai định dạng thẻ. Vui lòng nhập lại");

		System.out.println("	- Chi nhap Pin Card: " + homePage.getText_Error_ZingCard());

	}
//
	@Test
	public void testcase_08_ZingCard_Verify_display_message_when_input_card_invalid() throws InterruptedException {

		logTestCase("ZingID: Verify display message when input card invalid");

		Thread.sleep(1000);

		homePage.cleanSoSeri_ZingCard();

		homePage.cleanMaThe_ZingCard();

		homePage.inputSoSeri_ZingCard("yc0053605711");

		homePage.inputMaThe_ZingCard("dz2bmbj93");

		homePage.clickXacNhan_ZingCard();

		Thread.sleep(1500);

		verifyEqual(homePage.getText_Error_ZingCard(), "Thông tin thẻ không đúng, giao dịch thất bại!");

		System.out.println("	- Nhap sai thong tin the: " + homePage.getText_Error_ZingCard());

	}
//
	@Test
	public void testcase_09_ZingCard_Verify_display_message_when_input_card_had_used() throws InterruptedException {

		logTestCase("ZingID: Verify display message when input card had used");

		Thread.sleep(1000);


		homePage.cleanSoSeri_ZingCard();

		homePage.cleanMaThe_ZingCard();

		homePage.inputSoSeri_ZingCard("yc0053605718");

		homePage.inputMaThe_ZingCard("dz2bmbj94");

		homePage.clickXacNhan_ZingCard();

		Thread.sleep(1500);

		verifyEqual(homePage.getText_Error_ZingCard(), "Thẻ đã được sử dụng, vui lòng không dùng lại nhiều lần!");

		System.out.println("	- Nhap the dung roi: " + homePage.getText_Error_ZingCard());

	}

	@Test
	public void testcase_10_ATM_Verify_message_when_delete_price() throws InterruptedException {

		logTestCase("ATM: Verify message when delete price");

		homePage.clickPhuongThuc_ATM();

		homePage.clearSoTienThanhToan_TXT_ATM();

		verifyEqual(homePage.getText_Error_ZingCard(), "Số tiền thanh toán không hợp lệ.");
	}

	@Test
	public void testcase_11_ATM_Verify_message_when_input_invalid_price() throws InterruptedException {

		logTestCase("ATM: Verify message when input invalid price");

		homePage.inputSoTienThanhToan_TXT_ATM("49000");

		verifyEqual(homePage.getText_Error_ZingCard(), "Số tiền thanh toán không hợp lệ.");

		homePage.clearSoTienThanhToan_TXT_ATM();

		Thread.sleep(1000);

		homePage.inputSoTienThanhToan_TXT_ATM("51000");

		verifyEqual(homePage.getText_Error_ZingCard(), "Số tiền thanh toán không hợp lệ.");

		homePage.clearSoTienThanhToan_TXT_ATM();

		Thread.sleep(1000);

		homePage.inputSoTienThanhToan_TXT_ATM("99999");

		verifyEqual(homePage.getText_Error_ZingCard(), "Số tiền thanh toán không hợp lệ.");

		homePage.clearSoTienThanhToan_TXT_ATM();

		Thread.sleep(1000);

		homePage.inputSoTienThanhToan_TXT_ATM("19785000");

		verifyEqual(homePage.getText_Error_ZingCard(), "Số tiền thanh toán không hợp lệ.");

	}
//
//
//
	@Test
	public void testcase_12_ATM_Transfer_Napas() throws InterruptedException {

		logTestCase("ATM > Napas: Verify display message when cancel payment");

		System.out.println("-----ATM-----");

		System.out.println("	- Direct sang Napas ");

		homePage.clearSoTienThanhToan_TXT_ATM();

		Thread.sleep(1000);

		homePage.inputSoTienThanhToan_TXT_ATM("150000");

		homePage.click_Bank_Tranfers_NAPAS();
		
		Thread.sleep(1000);

		homePage.clickXacNhan_ATM();

		Thread.sleep(6000);

		verifyEqual(homePage.getTitle_Bank_Tranfers_NAPAS(), "Cổng thanh toán NAPAS");

		homePage.inputBank_Tranfers_NAPAS_TenChuThe("kim jae joong");

		homePage.inputBank_Tranfers_NAPAS_SoThe("1176217");

		homePage.cleanBank_Tranfers_NAPAS_TenChuThe();

		homePage.cleanBank_Tranfers_NAPAS_SoThe();

		homePage.inputBank_Tranfers_NAPAS_TenChuThe("bui minh nhut");

		homePage.inputBank_Tranfers_NAPAS_SoThe("6711647966227194");
		//
		homePage.clickBank_Tranfers_NAPAS_BTT_Huy();

		Thread.sleep(2000);

		homePage.clickBank_Tranfers_ZALOPAY_Huy_Icon_PopUp_XacNhan_BTT_QuayVe_BTT();

		homePage.clickKiemTraKetQuaGiaoDich();

		System.out.println("		+ Huy giao dich ");

		System.out.println("			> Ma giao dich ATM: " + homePage.getText_MaGiaoDich_ATM());

//		System.out.println("			> Trang thai giao dich ATM: " + homePage.getText_TrangThaiGiaoDich_ATM());

		homePage.clickTiepTucThanhToan();
	}

	@Test
	public void testcase_13_ATM_Transfer_BANK_WEB() throws InterruptedException {
		
		logTestCase("ATM > Bank Web: Verify direct to corresponding with bank had chosen");
		
		System.out.println("	- Direct sang bank web ");

		homePage.clickPhuongThuc_ATM();
		
		Thread.sleep(1000);
		
		homePage.clearSoTienThanhToan_TXT_ATM();
		
		homePage.inputSoTienThanhToan_TXT_ATM("990000");
		
		Thread.sleep(1000);

		homePage.click_Bank_Tranfers_BANKWEB();

		homePage.clickXacNhan_ATM();

		Thread.sleep(6000);

		homePage.backToPage();

		Thread.sleep(1000);

		homePage.clickBank_Tranfers_ZALOPAY_Huy_Icon_PopUp_XacNhan_BTT_QuayVe_BTT();

		System.out.println("			> Ma giao dich ATM: " + homePage.getText_MaGiaoDich_ATM());

		homePage.clickTiepTucThanhToan();

	}

	@Test
	public void testcase_14_ATM_Transfer_ZaloPay_Verify_display_transactionID() throws InterruptedException {

		logTestCase("ATM > ZaloPay: Verify display transactionId when cancel");
	
		homePage.clickPhuongThuc_ATM();
		
		Thread.sleep(1000);
		
		homePage.click_Bank_Tranfers_ZALOPAY();
		
		homePage.clearSoTienThanhToan_TXT_ATM();
		
		homePage.inputSoTienThanhToan_TXT_ATM("15000000");
		
		Thread.sleep(1000);

		homePage.clickXacNhan_ATM();
		
		homePage.inputBank_Tranfers_ZALOPAY_SoThe("486231486431");

		homePage.inputBank_Tranfers_ZALOPAY_TenChuThe("ABDEFGWEGWW");

		homePage.inputBank_Tranfers_ZALOPAY_NgayPhatHanh("1218");

		Thread.sleep(2000);

		// input[@id='inputCardNo']

		homePage.clearByJS("$('input#inputCardNo').val('')");

		Thread.sleep(1000);

		// So the
		homePage.inputByJS("$('input#inputCardNo').val('1234678910')");

		homePage.clearByJS("$('input#inputCardHo').val('')");

		Thread.sleep(1000);

		homePage.inputByJS("$('input#inputCardHo').val('Clear va nhap lai')");

		homePage.clearByJS("$('input#inputCardVa').val('')");

		Thread.sleep(1000);

		homePage.inputByJS("$('input#inputCardVa').val('1234')");

		Thread.sleep(2000);

		homePage.clickBank_Tranfers_ZALOPAY_Huy_Icon();
		
		Thread.sleep(2000);

		homePage.clickBank_Tranfers_ZALOPAY_Huy_Icon_PopUp_Huy_BTT();

		homePage.clickBank_Tranfers_ZALOPAY_Huy_Icon();
		
		Thread.sleep(2000);

		homePage.clickBank_Tranfers_ZALOPAY_Huy_Icon_PopUp_XacNhan_BTT();

		homePage.clickBank_Tranfers_ZALOPAY_Huy_Icon_PopUp_XacNhan_BTT_QuayVe_BTT();

		homePage.clickKiemTraKetQuaGiaoDich();

		System.out.println("		+ Huy giao dich ");

		System.out.println("			> Ma giao dich ATM: " + homePage.getText_MaGiaoDich_ATM());

		System.out.println("			> Trang thai giao dich ATM: " + homePage.getText_TrangThaiGiaoDich_ATM());

		homePage.clickTiepTucThanhToan();
	}
//
	@Test
	public void testcase_15_Credit_Card_Verify_message_when_delete_price() throws InterruptedException {

		logTestCase("CreditCard: Verify message when delete price");

		System.out.println("-----Credit Card-----");

		homePage.clickPhuongThuc_CreditCard();

		homePage.clearSoTienThanhToan_TXT_CreditCard();

		verifyEqual(homePage.getText_Error_ZingCard(), "Số tiền thanh toán không hợp lệ.");
	}

	@Test
	public void testcase_16_Credit_Card_Verify_message_when_input_invalid_price() throws InterruptedException {

		logTestCase("CreditCard: Verify message when input invalid price");

		Thread.sleep(2000);

		homePage.inputSoTienThanhToan_TXT_CreditCard("49000");

		Thread.sleep(1000);

		homePage.clearSoTienThanhToan_TXT_CreditCard();

		homePage.inputSoTienThanhToan_TXT_CreditCard("51000");

		verifyEqual(homePage.getText_Error_ZingCard(), "Số tiền thanh toán không hợp lệ.");

		Thread.sleep(1000);

		homePage.clearSoTienThanhToan_TXT_CreditCard();

		homePage.inputSoTienThanhToan_TXT_CreditCard("99999");

		verifyEqual(homePage.getText_Error_ZingCard(), "Số tiền thanh toán không hợp lệ.");

		Thread.sleep(1000);

		homePage.clearSoTienThanhToan_TXT_CreditCard();

		homePage.inputSoTienThanhToan_TXT_CreditCard("12345000");

		verifyEqual(homePage.getText_Error_ZingCard(), "Số tiền thanh toán không hợp lệ.");

		Thread.sleep(1000);

		homePage.clearSoTienThanhToan_TXT_CreditCard();

		homePage.clearSoTienThanhToan_TXT_CreditCard();

		homePage.inputSoTienThanhToan_TXT_CreditCard("19999999");

		verifyEqual(homePage.getText_Error_ZingCard(), "Số tiền thanh toán không hợp lệ.");

	}

	@Test
	public void testcase_17_Credit_Card() throws InterruptedException {
		
		logTestCase("CreditCard: Verify message when input valid price");
		
		homePage.clearSoTienThanhToan_TXT_CreditCard();

		homePage.inputSoTienThanhToan_TXT_CreditCard("2500000");
		
		Thread.sleep(1000);
		
		homePage.clickXacNhan_CreditCard();

		homePage.clickCreditCard_FORM_HUY_ICON();

		Thread.sleep(1000);

		homePage.clickCreditCard_FORM_HUY_ICON_HUY_BTT();

		homePage.inputCreditCard_FORM_SoThe_TXT("4111111111111111");

		homePage.inputCreditCard_FORM_TenChuThe_TXT("hero jae joong");

		homePage.inputCreditCard_FORM_NgayHetHan_TXT("0126");

		homePage.inputCreditCard_FORM_CVV_TXT("123");

		homePage.clickCreditCard_FORM_THANHTOAN_BTT();

		Thread.sleep(2000);

		homePage.clickBank_Tranfers_ZALOPAY_Huy_Icon_PopUp_XacNhan_BTT_QuayVe_BTT();

		homePage.clickKiemTraKetQuaGiaoDich();

		System.out.println("			> Ma giao dich ATM: " + homePage.getText_MaGiaoDich_Credit());

		System.out.println("			> Trang thai giao dich ATM: " + homePage.getText_TrangThaiGiaoDich_Credit());

		homePage.clickTiepTucThanhToan();
		//

	}

	@Test
	public void testcase_18_SMS() throws InterruptedException {
		
		logTestCase("SMS: Verify display syntax");

		System.out.println("-----SMS-----");

		homePage.clickPhuongThuc_SMS_Game_Convert();

		Thread.sleep(2000);

		homePage.clickXacNhan_SMS();

		Thread.sleep(500);

		homePage.clickKiemTraKetQuaGiaoDich_ZaloPay();

		System.out.println("	- Ma giao dich SMS: " + homePage.getText_MaGiaoDich_SMS());

		homePage.clickTiepTucThanhToan();

	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		getResult(result);
	}

	@AfterClass
	public void afterClass() {

		exportReport();
		driver.quit();
	}

}
