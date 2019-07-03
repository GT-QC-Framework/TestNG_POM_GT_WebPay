package com.payzing.ui;

public class LogInPageUI {

	public static final String TIMKIEMGAME_TXT = "//input[@type='text']";

	public static final String TIMKIEM_RESULT = "//li[contains(@id,'autocomplete')]";

	public static final String USERNAME_TXT = "//input[@id='u']";

	public static final String PASSWORD_TXT = "//input[@id='p']";

	public static final String ERROR_MESSAGE = "//p[@id='login_error_msg']";

	public static final String DANGNHAP_BTT = "//button[@id='login_submit_btn']";

	public static final String TITLEGAME_LBL = "//h1[contains(@class,'header')]";

	public static final String EMAIL_ICON = "//a[@id='other_email']";

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
	
	public static final String THOAT_BTT = "//div[contains(@class,'header-right')]";

	public static final String ZALO_ICON = "//a[@id='other_zalo']";
	
	public static final String FACEBOOK_ICON = "//a[@id='other_facebook']";
	
	public static final String ID_NHANVAT_BTT = "//div[@id='login_link']";
	
	public static final String IDNHANVAT_FORM_DROPDOWN_MAYCHU = "//button[@type='button']";
	
	public static final String IDNHANVAT_FORM_DROPDOWN_OPTION_MAYCHU = "//li[@data-group]//span";

	public static final String IDNHANVAT_FORM_TXT_NHANVAT = "//input[@id='authTxtRoleInfo']";
	
	public static final String IDNHANVAT_FORM_BTT_XACNHAN = "//button[@id='authBtnSubmit']";
	
	public static final String IDNHANVAT_FORM_MESS_ERROR = "//div[@id='authTextErrMessage']";
	
	public static final String IDNHANVAT_FORM_BTT_ROLE_ID = "//label[contains(text(),'role ID')]";
	
	public static final String IDNHANVAT_FORM_POPUP_BTT_XACNHAN = "//div[contains(@class,'footer')]//span[contains(text(),'Xác nhận')]"; 
	
	public static final String IDNHANVAT_FORM_POPUP_BTT_HUY = "//div[contains(@class,'footer')]//span[contains(text(),'Hủy')]";

	
	
}
