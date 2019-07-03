package com.payzing.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.payzing.ui.HomePageUI;

import CommonPage.commonFunction;

public class HomePage extends commonFunction {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	public void clickDropDown_CumMayChu(WebElement ele) {
		waitVisible(HomePageUI.DROPDOWN_CUMMAYCHU);
		ele.click();
	}

	public void selectDropdown_CumMayChu(WebElement ele, String locator) {
		waitVisible(locator);
		selectCombobox_Special(ele, locator);
	}

	//
	public void clickDropDown_MayChu(WebElement ele) {
		waitVisible(HomePageUI.DROPDOWN_MAYCHU);
		ele.click();
	}

	public void selectDropdown_MayChu(WebElement ele, String locator) {
		waitVisible(locator);
		selectCombobox_Special(ele, locator);
	}

	//
	public void clickDropDown_NhanVat(WebElement ele) {
		ele.click();
	}

	public void selectDropdown_NhanVat(WebElement ele, String locator) {
		waitVisible(locator);
		selectCombobox_Special(ele, locator);
	}
	
	public String getText_Title_Game() {
		waitVisible(HomePageUI.TITLEGAME_LBL);
		return getText(HomePageUI.TITLEGAME_LBL);
	}
	
	public void clickBTT_XacNhan()
	{
		waitVisible(HomePageUI.BTT_XACNHAN);
		click(HomePageUI.BTT_XACNHAN);
	}
	
	public void clickPOPUP_XacNhan()
	{
		waitVisible(HomePageUI.POPUP_XACNHAN);
		click(HomePageUI.POPUP_XACNHAN);
	}
	
	public void clickPackage50()
	{
		waitVisible(HomePageUI.PACKAGE_50POINT);
		click(HomePageUI.PACKAGE_50POINT);
	}
	
	public void clickXacNhan_ChonPack()
	{
		waitVisible(HomePageUI.POPUP_XACNHAN_PACKAGE);
		click(HomePageUI.POPUP_XACNHAN_PACKAGE);
	}
	
	public void inputSoTienThanhToan_TXT_ZaloPay(String value)
	{
		waitVisible(HomePageUI.OPTION_ZaloPay_SOTIENTHANHTOAN_TXT);
		input(HomePageUI.OPTION_ZaloPay_SOTIENTHANHTOAN_TXT, value);
	}
	
	public void clearSoTienThanhToan_TXT_ZaloPay()
	{
		waitVisible(HomePageUI.OPTION_ZaloPay_SOTIENTHANHTOAN_TXT);
		clear(HomePageUI.OPTION_ZaloPay_SOTIENTHANHTOAN_TXT);
	}
	
	
	public void clickXacNhan_ZaloPay()
	{
		waitVisible(HomePageUI.ZALOPAY_XACNHAN_BTT);
		click(HomePageUI.ZALOPAY_XACNHAN_BTT);
	}
	
	public void clickKiemTraKetQuaGiaoDich_ZaloPay()
	{
		waitVisible(HomePageUI.ZALOPAY_KIEMTRAKETQUAGIAODICH_BTT);
		click(HomePageUI.ZALOPAY_KIEMTRAKETQUAGIAODICH_BTT);
	}
	
	public String getText_MaGiaoDich_ZaloPay()
	{
		waitVisible(HomePageUI.MAGIAODICH_LBL);
		return getText(HomePageUI.MAGIAODICH_LBL);
	}
	
	public void clickTiepTucThanhToan()
	{
		waitVisible(HomePageUI.HREF_TIEPTUCTHANHTOAN);
		click(HomePageUI.HREF_TIEPTUCTHANHTOAN);
	}
	
	public void clickKiemTraKetQuaGiaoDich()
	{
		waitVisible(HomePageUI.BTT_KIEMTRAKETQUAGIAODICH);
		click(HomePageUI.BTT_KIEMTRAKETQUAGIAODICH);
	}
	
	public void clickPhuongThuc_ZingCard()
	{
		waitVisible(HomePageUI.OPTION_ZINGCARD);
		click(HomePageUI.OPTION_ZINGCARD);
	}
	
	public void clickXacNhan_ZingCard()
	{
		waitVisible(HomePageUI.ZINGCARD_XACNHAN_BTT);
		click(HomePageUI.ZINGCARD_XACNHAN_BTT);
	}
	
	public void inputSoSeri_ZingCard(String value)
	{
		waitVisible(HomePageUI.ZINGCARD_SOTHE_TXT);
		input(HomePageUI.ZINGCARD_SOTHE_TXT, value);
	}
	
	public void inputMaThe_ZingCard(String value)
	{
		waitVisible(HomePageUI.ZINGCARD_MAPIN_TXT);
		input(HomePageUI.ZINGCARD_MAPIN_TXT, value);
	}
	
	public String getText_Error_ZingCard()
	{
		waitVisible(HomePageUI.ZINGCARD_MESSAGE);
		
		return getText(HomePageUI.ZINGCARD_MESSAGE);
	}
	
	public void cleanSoSeri_ZingCard()
	{
		waitVisible(HomePageUI.ZINGCARD_SOTHE_TXT);
		clear(HomePageUI.ZINGCARD_SOTHE_TXT);
	}
	
	public void cleanMaThe_ZingCard()
	{
		waitVisible(HomePageUI.ZINGCARD_MAPIN_TXT);
		clear(HomePageUI.ZINGCARD_MAPIN_TXT);
	}
	
	public void clickPhuongThuc_ATM()
	{
		waitVisible(HomePageUI.OPTION_ATM);
		click(HomePageUI.OPTION_ATM);
	}
	
	public void inputSoTienThanhToan_TXT_ATM(String value)
	{
		waitVisible(HomePageUI.OPTION_ATM_SOTIENTHANHTOAN_TXT);
		input(HomePageUI.OPTION_ATM_SOTIENTHANHTOAN_TXT, value);
	}
	
	public void clearSoTienThanhToan_TXT_ATM()
	{
		waitVisible(HomePageUI.OPTION_ATM_SOTIENTHANHTOAN_TXT);
		clear(HomePageUI.OPTION_ATM_SOTIENTHANHTOAN_TXT);
	}
	
	public void clickXacNhan_ATM()
	{
		waitVisible(HomePageUI.ATM_XACNHAN_BTT);
		click(HomePageUI.ATM_XACNHAN_BTT);
	}
	
	public void click_Bank_Tranfers_NAPAS()
	{
		waitVisible(HomePageUI.ATM_TRANS_GATE_NAPAS);
		click(HomePageUI.ATM_TRANS_GATE_NAPAS);
	}
	
	public void click_Bank_Tranfers_CHUYENTRANG_BTT()
	{
		waitVisible(HomePageUI.ATM_TRANS_CHUYENTRANG_BTT);
		click(HomePageUI.ATM_TRANS_CHUYENTRANG_BTT);
	}
	
	public void click_Bank_Tranfers_BANKWEB()
	{
		waitVisible(HomePageUI.ATM_TRANS_GATE_BANKWEB);
		click(HomePageUI.ATM_TRANS_GATE_BANKWEB);
	}
	
	public void click_Bank_Tranfers_ZALOPAY()
	{
		waitVisible(HomePageUI.ATM_TRANS_GATE_ZALOPAY);
		click(HomePageUI.ATM_TRANS_GATE_ZALOPAY);
	}
	
	public void inputBank_Tranfers_NAPAS_TenChuThe(String value)
	{
		waitVisible(HomePageUI.ATM_TRANS_GATE_NAPAS_TENCHUTHE_TXT);
		input(HomePageUI.ATM_TRANS_GATE_NAPAS_TENCHUTHE_TXT, value);
	}
	
	public void inputBank_Tranfers_NAPAS_SoThe(String value)
	{
		waitVisible(HomePageUI.ATM_TRANS_GATE_NAPAS_SOTHE_TXT);
		input(HomePageUI.ATM_TRANS_GATE_NAPAS_SOTHE_TXT, value);
	}
	
	public void clickBank_Tranfers_NAPAS_BTT_ThanhToan()
	{
		waitVisible(HomePageUI.ATM_TRANS_GATE_NAPAS_THANHTOAN_BTT);
		click(HomePageUI.ATM_TRANS_GATE_NAPAS_THANHTOAN_BTT);
	}
	
	public void clickBank_Tranfers_NAPAS_BTT_Huy()
	{
		waitVisible(HomePageUI.ATM_TRANS_GATE_NAPAS_HUY_BTT);
		click(HomePageUI.ATM_TRANS_GATE_NAPAS_HUY_BTT);
	}
	
	public String getTextBank_Tranfers_NAPAS_Mess()
	{
		waitVisible(HomePageUI.ATM_TRANS_GATE_NAPAS_MESS_KHONGNHAP);
		
		return getText(HomePageUI.ATM_TRANS_GATE_NAPAS_MESS_KHONGNHAP);
	}
	
	public String getTitle_Bank_Tranfers_NAPAS()
	{
		
		return getTitle();
	}
	
	public void cleanBank_Tranfers_NAPAS_TenChuThe()
	{
		waitVisible(HomePageUI.ATM_TRANS_GATE_NAPAS_TENCHUTHE_TXT);
		clear(HomePageUI.ATM_TRANS_GATE_NAPAS_TENCHUTHE_TXT);
	}
	
	public void cleanBank_Tranfers_NAPAS_SoThe()
	{
		waitVisible(HomePageUI.ATM_TRANS_GATE_NAPAS_SOTHE_TXT);
		clear(HomePageUI.ATM_TRANS_GATE_NAPAS_SOTHE_TXT);
	}
	
	public String getText_MaGiaoDich_ATM()
	{
		waitVisible(HomePageUI.MAGIAODICH_LBL);
		return getText(HomePageUI.MAGIAODICH_LBL);
	}
	
	public String getText_TrangThaiGiaoDich_ATM()
	{
		waitVisible(HomePageUI.TRANGTHAIGIAODICH_LBL);
		return getText(HomePageUI.TRANGTHAIGIAODICH_LBL);
	}
	
	public void inputBank_Tranfers_ZALOPAY_SoThe(String value)
	{
		waitVisible(HomePageUI.ATM_TRANS_GATE_ZALOPAY_SOTHE_TXT);
		input(HomePageUI.ATM_TRANS_GATE_ZALOPAY_SOTHE_TXT, value);
	}
	
	public void inputBank_Tranfers_ZALOPAY_TenChuThe(String value)
	{
		waitVisible(HomePageUI.ATM_TRANS_GATE_ZALOPAY_TENCHUTHE_TXT);
		input(HomePageUI.ATM_TRANS_GATE_ZALOPAY_TENCHUTHE_TXT, value);
	}
	
	public void inputBank_Tranfers_ZALOPAY_NgayPhatHanh(String value)
	{
		waitVisible(HomePageUI.ATM_TRANS_GATE_ZALOPAY_NGAYPHATHANH_TXT);
		input(HomePageUI.ATM_TRANS_GATE_ZALOPAY_NGAYPHATHANH_TXT, value);
	}
	
	public void clickBank_Tranfers_ZALOPAY_Huy_Icon()
	{
		waitVisible(HomePageUI.ATM_TRANS_GATE_ZALOPAY_HUY_ICON);
		click(HomePageUI.ATM_TRANS_GATE_ZALOPAY_HUY_ICON);
		
	}
	
		
	public void clearBank_Tranfers_ZALOPAY_SoThe()
	{
		waitVisible(HomePageUI.ATM_TRANS_GATE_ZALOPAY_SOTHE_TXT);
		clear(HomePageUI.ATM_TRANS_GATE_ZALOPAY_SOTHE_TXT);
	}
//	
//	public void clearBank_Tranfers_ZALOPAY_TenChuThe()
//	{
//		waitVisible(HomePageUI.ATM_TRANS_GATE_ZALOPAY_TENCHUTHE_TXT);
//		clear(HomePageUI.ATM_TRANS_GATE_ZALOPAY_TENCHUTHE_TXT);
//	}
//	
//	public void clearBank_Tranfers_ZALOPAY_NgayPhatHanh()
//	{
//		waitVisible(HomePageUI.ATM_TRANS_GATE_ZALOPAY_NGAYPHATHANH_TXT);
//		clear(HomePageUI.ATM_TRANS_GATE_ZALOPAY_NGAYPHATHANH_TXT);
//	}
	
	public void clearByJS(String value)
	{
		executeScriptBrowser(value);
	}
	
	public void inputByJS(String value)
	{
		executeScriptBrowser(value);
	}
	
	public void clickBank_Tranfers_ZALOPAY_Huy_Icon_PopUp_Huy_BTT()
	{
		waitVisible(HomePageUI.ATM_TRANS_GATE_ZALOPAY_HUY_ICON_POPUP_HUY_BTT);
		click(HomePageUI.ATM_TRANS_GATE_ZALOPAY_HUY_ICON_POPUP_HUY_BTT);
	}
	
	public void clickBank_Tranfers_ZALOPAY_Huy_Icon_PopUp_XacNhan_BTT()
	{
		waitVisible(HomePageUI.ATM_TRANS_GATE_ZALOPAY_HUY_ICON_POPUP_XACNHAN_BTT);
		click(HomePageUI.ATM_TRANS_GATE_ZALOPAY_HUY_ICON_POPUP_XACNHAN_BTT);
	}
	
	public void clickBank_Tranfers_ZALOPAY_Huy_Icon_PopUp_XacNhan_BTT_QuayVe_BTT()
	{
		waitVisible(HomePageUI.ATM_TRANS_GATE_ZALOPAY_HUY_ICON_POPUP_XACNHAN_BTT_QUAYVE_BTT);
		click(HomePageUI.ATM_TRANS_GATE_ZALOPAY_HUY_ICON_POPUP_XACNHAN_BTT_QUAYVE_BTT);
	
	}
	
	public void clickPhuongThuc_CreditCard()
	{
		waitVisible(HomePageUI.OPTION_CREDITCARD);
		click(HomePageUI.OPTION_CREDITCARD);
	} 
	
	public void clickXacNhan_CreditCard()
	{
		waitVisible(HomePageUI.CREDIT_XACNHAN_BTT);
		click(HomePageUI.CREDIT_XACNHAN_BTT);
	}
	
	public void inputSoTienThanhToan_TXT_CreditCard(String value)
	{
		waitVisible(HomePageUI.OPTION_CREDITCARD_SOTIENTHANHTOAN_TXT);
		input(HomePageUI.OPTION_CREDITCARD_SOTIENTHANHTOAN_TXT, value);
	}
	
	public void clearSoTienThanhToan_TXT_CreditCard()
	{
		waitVisible(HomePageUI.OPTION_CREDITCARD_SOTIENTHANHTOAN_TXT);
		clear(HomePageUI.OPTION_CREDITCARD_SOTIENTHANHTOAN_TXT);
	}
	
	public void inputCreditCard_FORM_SoThe_TXT(String value)
	{
		waitVisible(HomePageUI.CREDIT_FORM_SOTHE_TXT);
		input(HomePageUI.CREDIT_FORM_SOTHE_TXT, value);
	}
	
	public void inputCreditCard_FORM_TenChuThe_TXT(String value)
	{
		waitVisible(HomePageUI.CREDIT_FORM_TENCHUTHE_TXT);
		input(HomePageUI.CREDIT_FORM_TENCHUTHE_TXT, value);
	}
	
	public void inputCreditCard_FORM_NgayHetHan_TXT(String value)
	{
		waitVisible(HomePageUI.CREDIT_FORM_NGAYHETHAN_TXT);
		input(HomePageUI.CREDIT_FORM_NGAYHETHAN_TXT, value);
	}
	
	public void inputCreditCard_FORM_CVV_TXT(String value)
	{
		waitVisible(HomePageUI.CREDIT_FORM_CVV_TXT);
		input(HomePageUI.CREDIT_FORM_CVV_TXT, value);
	}
	
	public void clickCreditCard_FORM_THANHTOAN_BTT()
	{
		waitVisible(HomePageUI.CREDIT_FORM_THANHTOAN_BTT);
		click(HomePageUI.CREDIT_FORM_THANHTOAN_BTT);
	}
	
	public void clickCreditCard_FORM_HUY_ICON()
	{
		waitVisible(HomePageUI.CREDIT_FORM_HUY_ICON);
		click(HomePageUI.CREDIT_FORM_HUY_ICON);
	}
	
	public void clickCreditCard_FORM_HUY_ICON_HUY_BTT()
	{
		waitVisible(HomePageUI.CREDIT_FORM_HUY_ICON_HUY_BTT);
		click(HomePageUI.CREDIT_FORM_HUY_ICON_HUY_BTT);
	}
	
	public String getText_MaGiaoDich_Credit()
	{
		waitVisible(HomePageUI.MAGIAODICH_LBL);
		return getText(HomePageUI.MAGIAODICH_LBL);
	}
	
	public String getText_TrangThaiGiaoDich_Credit()
	{
		waitVisible(HomePageUI.TRANGTHAIGIAODICH_LBL);
		return getText(HomePageUI.TRANGTHAIGIAODICH_LBL);
	}
	
	
	public void clickPhuongThuc_SMS_HREF()
	{
		waitVisible(HomePageUI.HREF_NAPBANGSMS);
		click(HomePageUI.HREF_NAPBANGSMS);
	} 
	
	public void clickPhuongThuc_SMS_Game_Convert()
	{
		waitVisible(HomePageUI.OPTION_SMS_GAME_CONVERT);
		click(HomePageUI.OPTION_SMS_GAME_CONVERT);
	} 
	
	
	public void clickSoTienThanhToan_DropDown_SMS()
	{
		waitVisible(HomePageUI.SMS_DROPDOWN_SOTIENTHANHTOAN);
		click(HomePageUI.SMS_DROPDOWN_SOTIENTHANHTOAN);
		waitVisible(HomePageUI.SMS_DROPDOWN_OPTION_SOTIENTHANHTOAN);
		clickRandomOptionInCombobox(HomePageUI.SMS_DROPDOWN_OPTION_SOTIENTHANHTOAN);
	}
	
	public void clickXacNhan_SMS()
	{
		waitVisible(HomePageUI.SMS_BTT_XACNHAN);
		click(HomePageUI.SMS_BTT_XACNHAN);
	}
	
	public String getText_MaGiaoDich_SMS()
	{
		waitVisible(HomePageUI.MAGIAODICH_LBL);
		return getText(HomePageUI.MAGIAODICH_LBL);
	}
	
}
