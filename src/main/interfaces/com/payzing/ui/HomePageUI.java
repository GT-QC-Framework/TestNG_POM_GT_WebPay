package com.payzing.ui;

public class HomePageUI {

	public static final String DROPDOWN_CUMMAYCHU = "//span[contains(text(),'Chọn cụm máy chủ')]/parent::button";

	public static final String DROPDOWN_MAYCHU = "//span[contains(text(),'Chọn máy chủ')]/parent::button";

//	public static final String DROPDOWN_NHANVAT = "//button";

//	public static final String LIST_ITEM_CUMMAYCHU = "//li[@data-value]/span";
	//public static final String LIST_ITEM_CUMMAYCHU = "//li[@data-value]//span[contains(text(),'%s')]";
	
	public static final String LIST_ITEM_CUMMAYCHU = "//span[contains(text(),'%s')]/parent::li";

//	public static final String LIST_ITEM_MAYCHU="//li[@data-value]/span[not(contains(text(),'Cụm máy chủ'))]";
//	public static final String LIST_ITEM_MAYCHU = "//li[@data-value]//span[contains(text(),'%s')]";
	public static final String LIST_ITEM_MAYCHU = "//span[contains(text(),'%s')]/parent::li";

//	public static final String LIST_ITEM_NHANVAT="//li[@data-value]//span[not(contains(text(),'Cụm máy chủ')) and not(contains(text(),'Sơn')) and not(contains(text(),'Giang'))]";
//	public static final String LIST_ITEM_NHANVAT = "//li[@data-value]//span[contains(text(),'%s')]";
	public static final String LIST_ITEM_NHANVAT = "//span[contains(text(),'%s')]/parent::li";
	
	public static final String BTT_XACNHAN = "//button[@id='authBtnSubmit']";
	
	public static final String TITLEGAME_LBL = "//h1[contains(@class,'header')]";
	
	public static final String POPUP_XACNHAN = "//div[@id='alertPoint']//span[contains(text(),'Xác nhận')]";
	
	//
	
	public static final String PACKAGE_50POINT = "//img[@id='img-g-1-com-vng-jxm-item-2']";
	
	
	public static final String POPUP_XACNHAN_PACKAGE = "//span[@id='popupProductConfirm']";
	
	public static final String OPTION_ZaloPay_SOTIENTHANHTOAN_TXT  = "//input[@id='txtAmountDynamicInputzalopay']";
	
	public static final String ZALOPAY_XACNHAN_BTT = "//button[@id='btnSubmitPaymentElementzalopay']";

	public static final String ZALOPAY_KIEMTRAKETQUAGIAODICH_BTT = "//button[@id='btnGetPaymentResult']//span[contains(text(),'Kiểm tra kết quả')]";
 
	public static final String MAGIAODICH_LBL = "//span[@id='txtPaymentID']";
	
	public static final String TRANGTHAIGIAODICH_LBL = "//p[@id='txtErrorReason']";
	
	public static final String OPTION_ZINGCARD  = "//h4[@id='txtpaymentMethodcard']";
	
	public static final String ZINGCARD_SOTHE_TXT  = "//input[@id='txtCardSerialcard']";
	
	public static final String ZINGCARD_MAPIN_TXT  = "//input[@id='txtCardPincard']";
	
	public static final String ZINGCARD_XACNHAN_BTT  = "//button[@id='btnSubmitPaymentElementcard']";
	
	public static final String ZINGCARD_MESSAGE  = "//div[@id='txtSubmitErrorMessage']";
	
	
	
	//button chuyen trang o form payment = atm + cc
	
	public static final String ATM_TRANS_CHUYENTRANG_BTT  = "//a[@class='redirect-im']";
	
//	public static final String ZINGCARD_MESSAGE_WRONGFORMAT  = "";
	
	public static final String OPTION_ATM  = "//h4[@id='txtpaymentMethodbank']";
	
	public static final String OPTION_ATM_SOTIENTHANHTOAN_TXT  = "//input[@id='txtAmountDynamicInputbank']";

	public static final String ATM_TRANS_GATE_NAPAS  = "//div[@id='1tpb']";
		
	public static final String ATM_TRANS_GATE_ZALOPAY  = "//div[@id='1vtb']";
	
	public static final String ATM_TRANS_GATE_BANKWEB  = "//div[@id='1vcb']";
	
	public static final String ATM_XACNHAN_BTT  = "//button[@id='btnSubmitPaymentElementbank']";
	
	public static final String ATM_TRANS_GATE_NAPAS_TENCHUTHE_TXT  = "//input[@id='gateway_CardName']";

	public static final String ATM_TRANS_GATE_NAPAS_SOTHE_TXT  = "//input[@id='gateway_CardNumber']";
	
	public static final String ATM_TRANS_GATE_NAPAS_THANHTOAN_BTT  = "//input[@type='image']";
	
	public static final String ATM_TRANS_GATE_NAPAS_HUY_BTT  = "//img[contains(@src,'huy')]";
	
	public static final String ATM_TRANS_GATE_NAPAS_MESS_KHONGNHAP  = "//span[@class='copyred']";
	
	public static final String BTT_KIEMTRAKETQUAGIAODICH  = "//button[@id='btnRetryGetResult']";
	
	public static final String HREF_TIEPTUCTHANHTOAN  = "//span[contains(text(),'Tiếp tục thanh toán')]";

	public static final String ATM_TRANS_GATE_ZALOPAY_SOTHE_TXT  = "//input[@id='inputCardNo']";
	
	public static final String ATM_TRANS_GATE_ZALOPAY_TENCHUTHE_TXT  = "//input[@id='inputCardHo']";
	
	public static final String ATM_TRANS_GATE_ZALOPAY_NGAYPHATHANH_TXT = "//input[@id='inputCardVa']";
	
	public static final String ATM_TRANS_GATE_ZALOPAY_THANHTOAN_BTT = "//button[@id='btnSubmit']";
	
	public static final String ATM_TRANS_GATE_ZALOPAY_HUY_ICON = "//a[@title='Hủy']";
	
	public static final String ATM_TRANS_GATE_ZALOPAY_HUY_ICON_POPUP_HUY_BTT = "//button[contains(text(),'Hủy')]";
	
	public static final String ATM_TRANS_GATE_ZALOPAY_HUY_ICON_POPUP_XACNHAN_BTT = "//button[contains(text(),'Xác nhận')]";
	
	//
	
	public static final String ATM_TRANS_GATE_ZALOPAY_HUY_ICON_POPUP_XACNHAN_BTT_QUAYVE_BTT = "//a[contains(@class,'back')]";
	
	public static final String OPTION_CREDITCARD  = "//h4[@id='txtpaymentMethodcredit']";
	
	public static final String OPTION_CREDITCARD_SOTIENTHANHTOAN_TXT  = "//input[@id='txtAmountDynamicInputcredit']";

	public static final String CREDIT_XACNHAN_BTT  = "//button[@id='btnSubmitPaymentElementcredit']";
	
	public static final String CREDIT_FORM_SOTHE_TXT  = "//input[@id='inputCCCardNo']";
	
	public static final String CREDIT_FORM_TENCHUTHE_TXT  = "//input[@id='inputCardHo']";

	public static final String CREDIT_FORM_NGAYHETHAN_TXT  = "//input[@id='inputCardVa']";

	public static final String CREDIT_FORM_CVV_TXT  = "//input[@id='inputCardCVV']";
	
	public static final String CREDIT_FORM_THANHTOAN_BTT  = "//button[@id='btnSubmit']";
	
	public static final String CREDIT_FORM_HUY_ICON  = "//a[@title='Hủy']";
	
	public static final String CREDIT_FORM_HUY_ICON_HUY_BTT  = "//button[contains(text(),'Hủy')]";
	
	public static final String CREDIT_FORM_HUY_ICON_XACNHA_BTT  = "//button[contains(text(),'Xác nhận')]";
	
	public static final String OPTION_SMS_GAME_CONVERT  = "//h4[@id='txtpaymentMethodsms']";
	
	public static final String HREF_NAPBANGSMS  = "//a[contains(text(),'SMS')]";
	
	public static final String SMS_DROPDOWN_SOTIENTHANHTOAN  = "//select[@id='amountPmcListsms']";
	
	public static final String SMS_DROPDOWN_OPTION_SOTIENTHANHTOAN  = "//select[@id='amountPmcListsms']/option";

	public static final String SMS_BTT_XACNHAN  = "//button[@id='btnSubmitPaymentElementsms']";


	
	



	
	

	
	


	
	
	
}
