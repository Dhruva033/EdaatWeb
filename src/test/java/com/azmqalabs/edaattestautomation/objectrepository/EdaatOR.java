package com.azmqalabs.edaattestautomation.objectrepository;

public class EdaatOR {

//Biller Module
	// Login Page for All
	public final static String LoginPage_Username = "//input[@name='UserName']";
	public final static String LoginPage_Password = "//input[@name='Password']";
	public final static String LoginPage_LogIn = "//button[@id='btnlogin']";
	public final static String LoginPage_Invalid_LogIn = "//span[text()='Invalid username or password']";
	public final static String LoginPage_send = "//button[@id='btnSendRequest']";
	public final static String LoginPage_confirmation = "//label[@id='Message' and contains(text(),'please check your email and reset the password.')]";
	
	public final static String LoginPage_Changelanguage = "//li[@class='nav-item d-none d-lg-flex ml-2']//a[text()='EN']";
	public final static String Logout = "(//a[text()='Logout'])[1]";
	public final static String LoginPage_Error ="//span[@style='display: block;' and text()='Invalid username or password']";
	public final static String LoginPage_Error_Invalid ="//span[@style='display: block;' and text()='Your account needs to be activated']";
	public final static String LoginPage_Forgetlink = "//a[text()='Forgot password?']";
	// Biller Home page
	public final static String Biller_HomePage_Main = "//h6[text()='Main Page']";
	public final static String Biller_Link = "//a[text()='Biller Login']";
	//public final static String Client_Link = "//a[text()='Client Login' and @class='btn btn-accent2']";
	public final static String EdaatLogo = "//img[@class='img-en']";
	public final static String HomePage = "(//h1[@class='display-3 animated zoomIn mb-3 w-100'])[1]";
    //Client Home Page
    public final static String Client_Link = "//a[text()='Client Login']";
    public final static String ArabicClient_Link = "//a[@class='btn btn-accent2']";
    public final static String Changelanguagebtn = "(//a[text()='EN'])[2]";
    public final static String Clientloginbtn = "//h5[text()='Login']";
	//public final static String Client_Link = "(//a[text()='Client Login'])[1]";

    //Client Forgot Password 
    public final static String Client_forgotpwd_Btn = "//a[text()='Forgot password?']";
    public final static String Client_forgotpwd_verify = "//h5[text()='Reset your password']";
    public final static String Client_Username_efield = "//input[@id='UserName']";
    public final static String Client_Username_sendbtn = "//button[@id='btnSendRequest']";
    public final static String Client_Username_confirm_verify = "//h5[text()='Confirm']";
    public final static String Client_Username_close = "//button[text()='Close']";
	public final static String Client_SignUp_Btn = "//a[contains(@href,'CustomerSignUp')]";
	public final static String Client_FirstName_eField = "//input[@id='FirstName']";
	public final static String Client_FirstName_eField_error = "//span[@id='FirstName-error']";
	public final static String Client_SecName_eField = "//input[@id='FatherName']";
	public final static String Client_SecName_eField_error = "//span[@id='FatherName-error']";
	public final static String Client_ThriName_eField = "//input[@id='GrandFatherName']";
	public final static String Client_ThriName_eField_error = "//span[@id='GrandFatherName-error']";
	public final static String Client_LastName_eField = "//input[@id='LastName']";
	public final static String Client_LastName_eField_error= "//span[@id='LastName-error']";
	public final static String Client_NationalID_eField = "//input[@id='NationalID']";
	public final static String Client_NationalID_eField_error = "//span[@id='NationalID-error']";
	public final static String Client_DateOfBirthHijri_eField = "//input[@id='DateOfBirthHijri']";
	public final static String Client_DateOfBirthHijri_eField_error= "//span[@id='DateOfBirthHijri-error']";
	public final static String Client_RegistDate_Issuedate = "(//tr[td[a[contains(@class,'calendars-today')]]]//following-sibling::td)[5]";
	public final static String Client_ExperyDate_eField = "//input[@id='DateOfBirth']";
	public final static String Client_ExperyDate_eField_error = "//span[@id='DateOfBirth-error']";
	public final static String Client_RegistDate_exprDate= "//a[contains(@class,'calendars-today')]";
	public final static String Client_IDAttachment_eField= "//input[@id='IBANAttachment']";
	public final static String Client_PhNo_eField = "//input[@id='MobileNo']";
	public final static String Client_PhNo_eField_error = "//span[@id='MobileNo-error']";
	public final static String Client_EmailID_eField = "//input[@id='Email']";
	public final static String Client_EmailID_eField_error = "//span[@id='Email-error']";
	public final static String Client_Password_eField = "//input[@id='Password']";
	public final static String Client_Password_eField_error = "//span[@id='Password-error']";
	public final static String Client_ConfPawd_eField= "//input[@id='ConfirmPassword']";
	public final static String Client_ConfPawd_eField_error= "//span[@id='ConfirmPassword-error']";
	public final static String Client_Terms_CheckBox = "//input[@id='Confirmation']";
	public final static String Client_Registration_btn = "//input[@id='btnSignUpWithoutOTP']";
	public final static String Client_Registrationconfmmsg = "//h4[contains(text(),'Registration completed successfully')]";
	public final static String Client_HelloClient_Main = "//a[@class='nav-link background-primary-mid text-white text-center']";
	public final static String Client_EmailValidatonMessage = "//h5[text()='Email Already Exists']";
	public final static String Client_EmailCloseButton = "//button[text()='Close']";

	//Client Login Page errorMessage
	public final static String  ClientLoginPage_EmailError= "//span[@id='UserName-error']";
	public final static String  ClientLoginPage_PasswordError= "//span[@id='Password-error']";
	
	//Client Reset your password Page errorMessage

	public final static String  ForgotPasswordPage_EmailError= "//span[@id='UserRequired']";
	public final static String  ForgotPasswordPage_invalidEmailError= "//span[@id='EmailValidation']";
	// Biller Add Individual Client Page
	public final static String Biller_Client = "//a[@id='lnkMyClients2']";
	public final static String Biller_Dashboard = "//h6[text()='Dashboard']";
	public final static String Biller_TrackerName = "//input[@type='search']";
	public final static String Biller_Dashboardmenu = "//a[@id='lnkDashbord2']";
	public final static String Biller_Total_no_bills="//h1[@id='billCount']";
	public final static String Biller_BillsList_page="//div/h6[text()='Bills List']";
	public final static String Biller_MyBalance="//div/h6[text()=' My Balance']";
	public final static String Biller_Warningmsg_BalanceDetails="//div[@class='TotalAmountAlert ']";
	public final static String Biller_Totalamt_Transfer="//div/h6[text()=' Total Amounts Transferred']";
	public final static String Biller_TotalamtPaid_text="//td[text()='Total Amounts Paid']";
	public final static String Biller_InvoicesVolumeStatus="//canvas[@id='chBillStatusCount']";
	public final static String Biller_InvoicesValueStatus="//canvas[@id='chBillStatusAmount']";
	public final static String Biller_Corporate = "//h6[text()='Corporate Info']";
	public final static String Systemmgmt_Menu = "//a[@id='lnkSystemMangement2']";
	public final static String Systemmgmt_NotApproved_Menu = "//a[@id='lnkUnderApprovedBillerList2']";
	public final static String Systemmgmt_NotApproved_Edit= "//td[9]";
	public final static String Systemmgmt_Approved_Menu = "//a[@id='lnkApprovedBillerList2']";
	public final static String Systemmgmt_InvoiceTemplate = "//a[@id='lnkInvoiceSetting2']";
	public final static String Systemmgmt_NonApprovedCloseBtn = "//button[@class='btn btn-link']";
	public final static String Systemmgmt_NonApproved_SadadBtn = "//input[@id='pm_2']/parent::div/label";
	public final static String Systemmgmt_NonApproved_MadaBtn = "//input[@id='pm_3']/parent::div/label";
	public final static String Systemmgmt_NonApproved_VisaBtn = "//input[@id='pm_4']/parent::div/label";
	public final static String Systemmgmt_NonApproved_MasterCardBtn = "//input[@id='pm_5']/parent::div/label";
	public final static String Systemmgmt_NonApproved_ApplePayBtn = "//input[@id='pm_6']/parent::div/label";
	
	//Biller API document Page
	public final static String Biller_ApiDoc= "//h6[text()='API Document']";
	public final static String Biller_ApiDocPageLink = "//a[@id='ApiDocument']";
	public final static String Biller_ApiDocDownload = "//a[@role='button']";



	
	//Biller Receivables paid outside page
	public final static String Biller_PaidOutside = "//h6[text()='Paid Outside EDAAT']";
	public final static String Biller_PaidOutsidePage = "//a[@id='lnkPayCashList2']";
	public final static String Biller_BillNo = "//input[@id='BillNo']";
	public final static String Biller_DocumentNo = "//input[@id='VoucherNo']";
//   public final static String Biller_SubBillerType = "//select[@id='SubBillerType']";
	//public final static String Biller_SubBillerName = "//span[@id='select2-SubBillerId-container']";
	public final static String Biller_SubBillerCname = "(//span[@id='select2-InterpriseSubBillerId-container']";
	public final static String Biller_SearchBtn = "//button[@id='btnSearch']";
	//public final static String Biller_SearchBtn = "//button[@id='btnSearch']";
	
	//Biller Receivables paid outside page
	public final static String Biller_BalanceDetailsPage = "//a[@id='lnkWalletDetails2']";
	public final static String Biller_BalanceDetailsViewBtn = "(//a[@title='View Contract'])[1]";
	public final static String Biller_InvoiceDetails = "//h6[text()='Invoice Details']";
	//Biller Import Clients Data
	public final static String Biller_Clients_link= "//a[@id='lnkMyClients2']";
	public final static String Biller_ImportClientdata= "//h6[text()='Import Clients Data']";
	public final static String Biller_ImportClientsData_Link= "//a[@id='lnkImportClients2']";
	public final static String Biller_Corporate_type_select= "//label[@for='rdCompany']";
	public final static String Biller_Individual_type_select= "//label[@for='rdCustomer']";
	public final static String Biller_Corporate_type_verify= "(//span[@id='lblImageName2'])[2]";
	public final static String Biller_Individual_type_verify= "(//span[@id='lblImageName2'])[1]";
	
	

	//Biller Settings Price List
	public final static String Biller_settings_Price = "//a[@id='lnkPriceList2']";
	public final static String Biller_settings_efield = "//input[@id='Name']";
	public final static String Biller_settings_sbtn = "//button[text()=' Search']";
	public final static String Biller_settings_Pricebtn = "//button[@onclick='Update(this);']";
	public final static String Biller_settings_Priceverify = "//h6[text()='Update price list']";
	public final static String Biller_settings_Pricenameverify= "(//div/label)[2]";
	//Biller Discount Management
	public final static String Biller_settings_Discount = "//a[@id='lnkDiscountList2']";
	public final static String Biller_settings_Discount_addbtn = "//button[@id='btnAddDiscount']";
	public final static String Biller_settings_Discount_engefield = "//input[@id='NameEn']";
	public final static String Biller_settings_Discount_arabicefield = "//input[@id='NameAr']";
	public final static String Biller_settings_Discount_perefield = "//input[@id='Value']";
	public final static String Biller_settings_Discount_adddiscbtn = "//button[text()='Add Discount']";
	public final static String Biller_settings_Discount_srch = "//input[@id='DiscountName']";
	public final static String Biller_settings_Discount_srchbtn = "//button[text()='Search']";
	public final static String Biller_settings_Discount_confyesbtn = "//button[@id='btnConfirmActivation']";
	public final static String Biller_settings_Discount_togelexists = "//table[@id='tblDiscounts']//span";
	public final static String Biller_settings_Discount_Confacti= "//h5[text()='Confirm activation?']";
	public final static String Biller_settings_Discount_Cancelacti= "//h5[text()='Cancel activation?']";
	
	//Biller Corporate Subbiller add
	public final static String Biller_subbiller= "//a[@id='lnkSubBillers2']";
	public final static String Biller_subbiller_Corp= "//a[@id='lnkSubBillersComanyList2']";
	public final static String Biller_subbiller_Corpaddbtn= "//button[@id='btnAddSubBiller']";
	public final static String Biller_subbiller_Corpname= "//input[@id='CompanyNameAr']";
	public final static String Biller_subbiller_Corpcrnum= "//input[@id='RegistrationNo']";
	public final static String Biller_subbiller_Corpiban= "//input[@id='IBAN']";
	public final static String Biller_subbiller_Corpbenfname= "//input[@id='BeneficiaryName']";
	public final static String Biller_subbiller_Corptaxnum= "//input[@id='VATNo']";
	public final static String Biller_subbiller_Corpfees= "//label[@for='HasInvoiceFees']";
	public final static String Biller_subbiller_Corpfixedvalue= "//label[@for='HasOperationalFees']";
	public final static String Biller_subbiller_Corpfixedefield= "//input[@id='OperationalFees']";
	public final static String Biller_subbiller_Corpperc= "//label[@for='HasOperationalFeesPercentage']";
	public final static String Biller_subbiller_Corpperefield= "//input[@id='OperationalFeesPercentage']";
	public final static String Biller_subbiller_Corpdistname= "//input[@id='District']";
	public final static String Biller_subbiller_Corpstreetefield= "//input[@id='Street']";
	public final static String Biller_subbiller_Corpzipcode= "//input[@id='PostalCode']";
	public final static String Biller_subbiller_Corpbuildno= "//input[@id='BuildingNo']";
	public final static String Biller_subbiller_Corpempname= "//input[@id='EmployeeName']";
	public final static String Biller_subbiller_Corpempemail= "//input[@id='EmployeeEmail']";
	public final static String Biller_subbiller_Corpempmobile= "//input[@id='EmployeeMobileNo']";
	public final static String Biller_subbiller_Corpadd= "//input[@id='btnAdd']";
	public final static String Biller_subbiller_Corpverify= "//h6[text()='Add Corporate Sub Biller']";
	public final static String Biller_subbiller_Ibanclick= "//input[@id='IBANAttachment']";
	public final static String Biller_subbiller_corpcity= "//span[text()='Select City']";
	public final static String Biller_subbiller_crattach= "//input[@id='RegistrationAttachment']";
	public final static String Biller_subbiller_srch= "//input[@id='Name']";
	public final static String Biller_subbiller_crsrch= "//input[@id='RegistrationNumber']";
	public final static String Biller_subbiller_srcclick= "//button[text()='Search']";
	public final static String Biller_subbiller_Nodata= "//td[contains(text(),'No data available in table')]";
	public final static String Biller_subbiller_nameverify= "//table[@id='tblSubBillers']//td[1]";
	public final static String Biller_subbiller_crverify= "//button[text()='Search']";
	public final static String Biller_subbiller_Product= "//label[@for='HasProductFees']";
	public final static String Biller_subbiller_corpaddProduct= "//a[@id='btnNewProduct']";
	public final static String Biller_subbiller_corpaddProduct_ProductID="//select[@name='ProductId']";
	public final static String Biller_AddsubBiller_ProductPer="//input[@id='txtProductPercentage']";
	public final static String Billersubbiller_productIBAN="//input[@id='txtProductIBAN']";
	public final static String Billersubbiller_product_BenName="//input[@id='txtProductBeneficiaryName']";
	public final static String Biller_subbiller_Productcrattach="//input[@id='ProductIBANAttachment']";
	public final static String Biller_Subbiller_ProductAddBtn="//button[.='Add']";
	public final static String Biller_Subbiller_transferfrmsubiller="//label[@for='DeductTransferFeesFromSubBiller']";

	
	
	public final static String Systemmgmt_table = "//table[@id='dtBasicExample']";
	public final static String Systemmgmt_table_approved = "//table[@id='dtApprovedBillers']";
	public final static String Systemmgmt_table_Invoice = "//div[@id='DataTables_Table_0_wrapper']";
	public final static String Systemmgmt_toggle = "//input[@class='switch']";
	public final static String Admin_SystemMgm_BillerActivateButton="(//a[contains(@href,'BillerActivation')])";
	
	//Biller Receivables Corporate Sub biller page
	public final static String Biller_CorporateSubBillerPage = "//a[@id='lnkSubBillersComanyList2']";
	public final static String Biller_CorporateSubBillerGrid = "//table[@id='tblSubBillers']";
	public final static String Biller_CorporateSubBiller_BillerName= "//input[@id='Name']";
	public final static String Biller_CorporateSubBiller_searchBtn= "//button[text()='Search']";
	public final static String Biller_CorporateSubBiller_Name= "//a[contains(text(),'Chandan')]";
	public final static String Biller_CorporateSubBiller_Back= "//a[text()='Back']";
	
		//Biller Receivables Individual Sub biller page
				public final static String Biller_IndividualSubBillerPage = "//a[@id='lnkSubBillersIndividualList2']";
				public final static String Biller_IndividualToggle = "//input[@class='switch']";
				public final static String Biller_Individual_NationalID= "//input[@id='NationalId']";
				public final static String Biller_Individual_searchBtn= "//button[text()='Search']";
				public final static String Biller_YesBtn= "//button[@id='btnConfirmActivation']";
				public final static String Biller_ConfirmationPopupMessage= "//h5[@id='ConfirmActivationMessage']";
				
	//Biller Settings Bills Cancellation
 public final static String Biller_BillsCancellation = "//a[@id='lnkCancelBills2']";				
 public final static String Biller_AttachExcel = "//input[@id='ExcelFile']";				
 public final static String Biller_ProcessBtn = "//button[@id='btnProcessingExcelFile']";				
 public final static String Biller_SuccessfulMsg = "//span[@id='spnUnderProcessing']";				
				
				
				
	//Biller Settings price lists
    public final static String Biller_PricingList = "//a[@id='lnkPriceList2']";
    public final static String Biller_AddBtn = "//button[@id='btnAddPriceList']";
    public final static String Biller_PriceNameAr = "//input[@id='NameAr']";
    public final static String Biller_PriceNameEn = "//input[@id='NameEn']";
    public final static String Biller_Ratio = "//input[@id='Value']";
    public final static String Biller_FromCalendar = "//input[@id='FromDate']";
    public final static String Biller_FromYear = "(//select[@class='calendars-month-year'])[2]";
    public final static String Biller_FromMonth = "(//select[@class='calendars-month-year'])[1]";
    public final static String Biller_ToCalendar = "//input[@id='ToDate']";
    public final static String Biller_AddPriceBtn = "//button[@id='btnAdd']";
    public final static String Biller_SearchName = "//input[@id='Name']";
    public final static String Biller_RadioBtn= "(//input[@name='RoundingTypeID'])[1]";
    public final static String Biller_SearchButton= "//button[text()=' Search']";
	public final static String Biller_Add_Individualclient = "//a[@id='lnkCustomerList2']";
	public final static String Biller_Add_client = "//a[@id='lnkCustomerList2']";
	public final static String Biller_Add_Companyclient = "//a[@id='lnkCompanyList2']";
	public final static String Biller_Sub_Individualclient = "//a[@id='lnkSubBillers2']";
	public final static String Biller_Sub_IndividualsubBiller = "//a[@id='lnkSubBillersIndividualList2']";
	public final static String Biller_Settings = "//a[@id='lnkMySettings']";
	public final static String Biller_Settings_contentMng = "//a[@id='lnkContentManagement2']";
	public final static String Biller_Individualclient_sname = "//input[@id='SecondName']";
	public final static String Biller_Add_Individualclient_Button = "//button[@id='btnAddCustomer']";
	public final static String Biller_Add_Invoice_Button = "//button[@id='btnAddTemplate']";
	public final static String Biller_Add_Prod_Buttonbtn="//[button[@id='AddProduct']";
	public final static String Biller_Add_Invoice_template = "//a[@id='lnkInvoiceSetting2']";
	public final static String Biller_Add_Product = "//a[text()='Products Management']";
	public final static String Biller_Invoice_TemplateArabic = "//input[@id='NameAr']";
	public final static String Biller_Prod_NameArabic = "(//input[@id='Name'])[2]";
	public final static String Biller_Invoice_TemplateEng= "//input[@id='NameEn']";
	public final static String Biller_Prod_Price= "//input[@id='Price']";
	public final static String Biller_ProdReferenceCode= "//input[@id='Code']";
	public final static String Biller_Prod_Addbutton="//button[@id='btnAddProduct']";
	public final static String Biller_Individualclient_fname = "//input[@id='FirstName']";
	public final static String Biller_Individualclient_Cname = "//input[@id='Name']";
	public final static String Biller_Maxlimit = "//input[@id='Limit']";
	public final static String Biller_TransferDuration = "//input[@id='TransferDuration']";
	public final static String Biller_AzimFee = "//input[@id='AzimFee']";
	public final static String Biller_sadadFee = "//input[@id='sadadFee']";
	public final static String Biller_BillerAliasNameEn = "//input[@id='BillerAliasNameEn']";
	public final static String Biller_MaximumInvoiceAmount = "//input[@id='MaximumInvoiceAmount']";
	public final static String Biller_Imgdownload = "//a[@class='text-white']";
	public final static String Biller_Pricelistsym = "//h6[text()='Pricing List']";
	public final static String Biller_Pricelistgrid = "//table";
	public final static String Biller_Settings_Content_src = "//button[@id='btnProcessingExcelFile2']";
	//Change Name//public final static String Biller_InvoiceName= "(//tr[2]|//td[2])[1]";
	public final static String Biller_InvoiceName= "(//td[2])";
	public final static String Biller_Invoice_TemplateDisc= "//textarea[@name='Description']";
	public final static String Biller_Invoice_TemplateRefcode= "//input[@class='form-control animated fadeIn']";
	public final static String Biller_Invoice_Templateactideacti= "//input[@class='switch']";
	public final static String Biller_Invoice_TemplateBillpay= "(//input[@type='checkbox'])[5]";
	public final static String Biller_Invoice_TemplateVeriable= "(//input[@type='checkbox'])[8]";

	
	public final static String Biller_Individualclient_tname = "//input[@id='ThirdName']";
	public final static String Biller_Individualclient_lname = "//input[@id='LastName']";
	public final static String Biller_Individualclient_IdNumber = "//input[@id='IdNumber']";
	public final static String Biller_Subbiller_NId="//input[@id='NationalId']";
	public final static String Biller_Individualclient_Name = "//input[@id='Name']";
	public final static String Biller_Individualclient_CustomerRefNumber = "//input[@id='CustomerRefNumber']";
	public final static String Biller_Individualclient_DateOfBirth = "//input[@id='DateOfBirth']";
	public final static String Biller_Invoice_Templatetype_Rec= "//input[@id='BillType_16']";
	public final static String Biller_Invoice_Templatetype_Chkboxes= "//div[@class='form-group mb-4']/div//input[@type='checkbox']";
	public final static String Biller_Individualclient_refno = "//input[@name='CustomerRefNumber']";
	public final static String Biller_Individualclient_togle ="//label[@for='status']";
	
	public final static String Biller_Invoice_Select="(//select[@id='ServiceId'])[2]";
	public final static String Biller_Individualclient_DateOfYear = "//select[@title='Change the year']";
	public final static String Biller_Dashboard_Fromyear = "//select[@title='Change the year']";
	public final static String Biller_Dashboard_Toyear = "//select[@title='Change the year']";
	public final static String Biller_Dashboard_FromDate = "//input[@id='FromDate']";
	public final static String Biller_Dashboard_TODate = "//input[@id='ToDate']";
	public final static String Biller_Individualclient_DateOfMonth = "//select[@title='Change the month']";
	public final static String Biller_Dashboard_FromMonth = "//select[@title='Change the month']";
	public final static String Biller_Dashboard_ToMonth = "//select[@title='Change the month']";
	public final static String Biller_DashboardSearchBtn = "//button[@id='btnSearch']";
	public final static String Biller_Individualclient_MobileNo = "//input[@id='MobileNo']";
	public final static String Biller_Individualclient_Add = "//input[@type='submit']";
	public final static String Biller_Invoice_Add = "//button[@id='btnAdd']";
	public final static String Biller_Save = "//input[@id='btnSave']";
	public final static String Biller_Save_Yes = "//button[@id='btnConfirmSaveBillerInfo']";
	public final static String Biller_Save_Yesclose = "//button[@id='btnCloseSendInformationToChecker']";
	
	public final static String Biller_Invoice_Delete = "//select[@onchange='SelectAction(this)']";
	public final static String Biller_Invoice_Reason ="//li[text()='End Service']";
	public final static String Biller_Invoice_view ="(//a[@title='View Contract'])[1]";
	public final static String Biller_Invoice_form ="//form[@action='ePayment-ar4.html']";
	
	public final static String Biller_Invoice_Deletebtn = "//button[@id='btnConfirmDelete']";
	public final static String Biller_Invoice_Reasontxt="//input[@type='search']";
	public final static String Biller_Invoice_Deletechkbox="//label[@for='Deleted']";
	public final static String Biller_Invoice_table="//table[@id='tblCustomers']";
	public final static String Biller_Invoice_Templatetype= "//input[@id='BillType_16']";
	public final static String Biller_Invoice_Templatetype_One= "//input[@id='BillType_15']";
	public final static String Admin_TaxEng= "//input[@id='TaxName']";
	public final static String Admin_Tax_Search ="//button[text()='Search']";
	public final static String Admin_Tax_Nodata ="//td[text()='No data available in table']";
	public final static String Biller_Individualclient_Email = "//input[@id='Email']";
	public final static String Biller_Individualclient_Refno = "//input[@id='CustomerRefNumber']";
	public final static String Biller_Individualclient_Search = "//button[@id='btnSearch']";
	public final static String Biller_Individualclient_SearchBtn = "//button[@id='btnSearch']";
	public final static String Biller_Individualclient_Edit = "	//td[9]";
	public final static String Biller_Edit = "(//a[@class='mx-1 action bg-accent'])[1]";
	public final static String Biller_Individualclient_Searchname = "(//span[contains(text(),'CorporateOne')])[1]";
	public final static String Biller_Corpclient_Searchname = "(//span[contains(text(),'FullNameOne')])[1]";
	public final static String Biller_Individualclient_SearchByname = "//input[@id='Name']";
	public final static String Biller_Individualclient_SearchByNationalID = "//input[@id='IdNumber']";
	public final static String Biller_Subbiller_Search ="//button[text()='Search']";	
	public final static String Biller_Individualclient_Back ="//a[text()='Back']";
	public final static String Biller_Individualclient_Deactivate ="(//input[@type='checkbox'])[3]";
	public final static String Biller_Individualclient_button="//button[@id='btnConfirmActivation']";
	public final static String Biller_Confirm_toggle="//button[@id='btnConfirmActivation']";
	
	//public final static String Biller_Individualclient_button="//button[@id='btnConfirmApproveBillerInfo']";
	//public final static String Biller_Confirm_toggle="//button[@id='btnConfirmActivation']";	
	public final static String Biller_ApprovedMgm_Menu="//a[@id='lnkApprovedBillerList2']";
	public final static String Biller_Individualclient_export="//a[@id='btnExport']";
	public final static String Biller_Individualclient_Corponame = "(//input[@type='text'])[1]";
	public final static String Biller_Individualclient_Customercrnum = "//input[@id='RegistrationNo']";


	//Corporate
	public final static String Biller_Corporateclient_commissioner_Mobile = "//input[@id='CommissionerMobileNo']";
	public final static String Biller_Corporateclient_commissioner_Email = "//input[@id='CommissionerEmail']";
	public final static String Biller_Corporateclient_commissioner_Crno = "//input[@id='CustomerRefNumber']";
	public final static String Biller_Corporateclient_name = "//input[@id='NameAr']";
	public final static String Biller_Corporateclient_Rno = "//input[@id='RegistrationNo']";
	public final static String Biller_Corporateclient_lang = "//label[text()='English']";
	public final static String Biller_Corporateclient_commissioner = "//input[@id='CommissionerNameAr']";
	public final static String Biller_Corporateclient_commissionerID = "//input[@id='CommissionerNationalId']";
	public final static String Biller_Corporateclient_Name = "//input[@id='CompanyName']";
	public final static String Biller_Corporateclient_Save = "//input[@id='btnUpdate']";
	public final static String Biller_Corporateclient_tbl = "//table[@id='tblCompanies']";
	public final static String Biller_Corporateclient_search = "//input[@id='CompanyName']";
	public final static String Biller_CorporateReportBillerName = "//div[text()='ENGLISH BILLER']";
	public final static String Biller_CorporateReport = "//iframe";
    public final static String Biller_Corpoclient_CustomerRefNumber = "//input[@id='CustomerRefNumber']";

	//signup

	public final static String Biller_NationalAttmnt_eField = "//input[@name='NationalAddressProofAttachment']";
	public final static String Biller_SignUp_Btn ="//a[contains(@href,'BillerCompanySignUp')]";
	public final static String Biller_CompanyName_eField ="//input[@name='CompanyNameAr']";
	public final static String Biller_EconomySector_List ="//select[@name='EconomicSectorID']";
	public final static String Biller_Country_List ="//select[@name='CountryID']";
	public final static String Biller_City_List ="//select[@name='CityID']";
	public final static String Biller_District_eField ="//input[@name='District']";
	public final static String Biller_Street_eField ="//input[@name='Street']";
	public final static String Biller_BuildNo_eField ="//input[@name='BuildingNo']";
	public final static String Biller_PostalCode_eField ="//input[@name='PostalCode']";
	public final static String Biller_MailBox_eField ="//input[@name='MailBox']";
	public final static String Biller_OfficNo_eField ="//input[@name='OfficeNo']";
	public final static String Biller_EmplyName_eField ="//input[@name='EmployeeName']";
	public final static String Biller_EmplyJobTitle_eField ="//input[@name='EmployeeJobTitle']";
	public final static String Biller_EmplyMobileNumber_eField ="//input[@name='EmployeeMobileNo']";
	public final static String Biller_EmplyEmail_eField ="//input[@name='EmployeeEmail']";
	public final static String Biller_CustomerSupPhNo_eField ="//input[@name='CustomerSupportPhoneNo']";
	public final static String Biller_IBANum_eField ="//input[@name='IBAN']";
	public final static String Biller_IBANAttmnt_eField ="//input[@name='IBANAttachment']";
	public final static String Biller_BankCountryType_List ="//select[@name='BankAccountTypeId']";
	public final static String Biller_BankCertAttmnt_eField ="//input[@name='BankCertificateAttachment']";
	public final static String Biller_CRNumber_eField ="//input[@name='RegistrationNo']";
	public final static String Biller_RegiAttachment_eField ="//input[@name='RegistrationAttachment']";
    public final static String Biller_SubName ="//input[@id='BillerSubName']";
	public final static String Biller_confirmCheckbox ="//input[@id='BillerSubNameConfirmation']";
	public final static String Biller_RegistDate_eField ="//input[@name='RegistrationDateHijri']";
	public final static String Biller_RegistDate_Issuedate ="(//tr[td[a[contains(@class,'calendars-today')]]]//following-sibling::td)[5]";
	public final static String Biller_RegistDate_exprDate ="//a[contains(@class,'calendars-today')]";
	public final static String Biller_ExperyDate_eField ="//input[@name='ExpiredRegistrationDateHijri']";
	public final static String Biller_Taxno_eField ="//input[@name='TaxNo']";
	public final static String Biller_IsTaxable_RadBtn ="//div[label[contains(text(),'Taxable')]]/input[@name='IsTaxable']";
	public final static String Biller_NoTaxable_RadBtn ="//div[label[contains(text(),'Non-Taxable')]]/input[@name='Taxable']";
	public final static String Biller_TaxRegisAttmnt_eField ="//input[@name='TaxRegistrationAttachment']";
	public final static String Biller_FirstName_eField ="//input[@name='FirstNameAr']";
	public final static String Biller_SurName_eField ="//input[@name='FatherNameAr']";
	public final static String Biller_GradFatherName_eField ="//input[@name='GrandFatherNameAr']";
	public final static String Biller_LastName_eField ="//input[@name='LastNameAr']";
	public final static String Biller_NationalID_eField ="//input[@name='NationalID']";
	public final static String Biller_CommisionIdentyAttmnt_eField ="//input[@name='CommissionerIdentityAttachment']";
	public final static String Biller_MemDumAssoAttmnt_eField ="//input[@name='MemorandumOfAssociationAttachment']";
	public final static String Biller_AuthLterTemltAttmnt_eField ="//span[@id='lblAuthorizationLetterTemplateAttachment']";
	public final static String Biller_CommisionPhNo_eField ="//input[@name='CommissionerPhoneNo']";
	public final static String Biller_CommisionEmail_eField ="//input[@name='CommissionerEmail']";
	public final static String Biller_UserID_eField ="//input[@name='Username']";
	public final static String Biller_Password_eField ="//input[@name='Password']";
	public final static String Biller_ConfPawd_eField ="//input[@name='ConfirmPassword']";
	public final static String Biller_Confirmation_CheckBox="//input[@name='Confirmation']";
	public final static String Biller_ReCatchBox_eField ="//iframe[@title='reCAPTCHA']";
	public final static String Biller_CatchBox_eField ="//span[@id='recaptcha-anchor']";
	public final static String Biller_SignUp_btn="//input[@id='btnSignUp']";
	public final static String Biller_confirmpassoword="//span[@id='ConfirmPassword-error']";
	public final static String Biller_RegisterComp_btn ="//h4[contains(text(),'Registration completed successfully')]";
	public final static String Biller_Close_btn ="//button[text()='Close']";
	public final static String Biller_AuthTempl_Link ="//a[text()='Authorization Letter Sample']";
  public final static String Biller_AttachetedImage_Link1="(//h6)[2]";
  public final static String Biller_AttachetedImage_Link="//input[contains(@accept,'image') and (@name='IBANAttachment')]";

	public final static String Biller_Receivable_Link="//a[contains(text(),'Receivables')]";
	public final static String Biller_Balance_Link="//a[@id='lnkWalletDetails2']";
	public final static String Biller_Update_btn="//button[@data-target='#updateAliasModal']";
	public final static String Biller_Wallet_efield="//input[@id='Alias']";
	public final static String Biller_Wallet_yesbtn="//button[@id='btnUpdateAlias']";
	public final static String Biller_updated_Wallet="//h6[@id='hdrAlias']";
	public final static String Biller_ExportBill_Link="(//a[contains(text(),'Exported Bills')])[2]";
	public final static String Biller_ExportBill_Header="//h6[text()='Bills List']";
	public final static String Biller_AddInvoice_btn="//button[@id='btnAddInvoice']";
	public final static String Biller_AddInvoice_Header="//h6[text()='Create Invoice']";
	public final static String Biller_Invoice_IndividualRdv="//input[@id='rdIndividual']";
	public final static String Biller_Invoice_CopoRdv="//input[@id='rdCompany']";
//	public final static String Biller_Invoice_IndividualRdv="//label[@for='rdIndividual']";
//	public final static String Biller_Invoice_CopoRdv="//label[@for='rdCompany']";
	public final static String Biller_Invoice_CustIDListindi="//select[@name='CustomerId']/following-sibling::span//span[@class='select2-selection__arrow']";
	public final static String Biller_Invoice_CustIDListcorpo="//select[@name='CompanyId']/following-sibling::span//span[@class='select2-selection__arrow']";
	public final static String Biller_Invoice_SBilIdList="//select[@name='SubBillerId']/following-sibling::span//span[contains(@class,'arrow')]";
	public final static String Biller_Invoice_SBilShareamountFil="//input[@id='SubBillerShareAmount']";
	public final static String Biller_Invoice_SBilSharePerFil="//input[@id='SubBillerSharePercentage']";
	public final static String Biller_Invoice_TemplateList="//select[@id='InvoiceTemplateId']";
	public final static String Biller_Invoice_Create="//button[@id='btnCreateInvoice']";
	public final static String Biller_Invoice_AddProductBtn="//a[@id='btnAddProductModal']";
	public final static String Biller_Invoice_Subbill="//input[@id='rdSubbillerIndividual']";
	public final static String Biller_Invoice_TaxPric="//input[@id='tbxPrice']";
	public final static String Biller_Invoice_ProductID="//select[@name='ProductId']";
	public final static String Biller_Invoice_AddBtn="//button[.='Add']";
	public final static String Biller_Invoice_DateInvoc="//input[@name='IssueDate']";
	public final static String Biller_Invoice_DurationID="//select[@id='DurationTypeId']";
	public final static String Biller_Invoice_MinTax="//input[@name='MinLimit']";
	public final static String Biller_Invoice_CreateReapeat="//button[@id='btnCreateRepeatInvoice']";
	public final static String Biller_Invoice_Conditon="//textarea[@id='txtConditions']";
	public final static String Biller_Invoice_Conditonbtn="//div[@id='divTerms']//input";
	public final static String Biller_Invoice_Descript="//textarea[@id='txtBillDescription']";
	public final static String Biller_Invoice_Descript1="//textarea[@id='txtDescription_1']";
//	public final static String Biller_Invoice_SaveButton="//button[@id='btnUpdateBill']";
	public final static String Biller_Invoice_SaveButton="//button[@id='btnCreateInvoice']";
	public final static String Biller_Invoice_ExportButton="//button[@id='btnUpdateBill']";
	public final static String Biller_Invoice_Exportandcreatebtn="//button[@id='btnExportInvoice']";
	public final static String Biller_Invoice_Billnumber="//input[@id='billNo']";
	public final static String Biller_Invoice_Searchbtn="//button[@id='btnSearch']";
	public final static String Biller_Invoice_Count="(//table[@id='tblBillList']//tbody/tr[@role='row'])";
	public final static String Biller_Invoice_AfteraddCount="(//table[@id='tblInvoiceList']//tbody/tr[@role='row'])";
	public final static String Biller_Invoice_AfteraddInvoice="(//table[@id='tblBillList']//tbody/tr[@role='row'])";
	public final static String Biller_ExportExcel="//a[@id='btnExport']";
	public final static String Biller_ConformExportExcel="//span[@id='spnUnderProcessing']";
	public final static String Biller_InvoiceLastCheckBox="(//table[@id='tblBillList']//tbody/tr[@role='row'])//input[@type='checkbox'][last()]";
	public final static String Biller_Export_CancellationBtn="//button[@id='btnCancelSelected']";
	public final static String Biller_Export_PayOutsideBtn="//button[@id='btnPayCashSelected']";
	public final static String Biller_Export_ViewContactBtn="(//table[@id='tblBillList']//tbody/tr[@role='row'])//a[@title='View Contract'][last()]";
	public final static String Biller_Receivables_Bill_Status="//tbody//td[6]";
	public final static String Biller_Invoice_ClientRoleId="//li[@role='treeitem']";
	public final static String Biller_Invoice_NextBtn="//a[text()='Next']";
	public final static String Biller_Invoice_Next="//li[a[text()='Next']][contains(@class,'next disabled')]";
	public final static String Biller_Invoice_GetBilId="(//td[contains(text(),' Bill Number')]/span)[1]";
	public final static String Biller_Invoice_BillNo="//a[contains(@href,'billNo')]";
	public final static String Biller_Invoice_BillerNumber="//label[contains(text(),'Bill Number')]/h6";
	public final static String Biller_Invoice_PrintButton="//button[@id='btnPrintInvoice']";
	public final static String Biller_Invoice_ViewInsButton="//a[text()='View Installments']";
	public final static String Biller_Invoice_ContractNumber="//label[text()='Contract Number:']";
	public final static String Biller_ExportContact_Link="//a[contains(text(),'Exported Contracts')]";
	public final static String Biller_ExportContact_InvID="//a[contains(@href,'invoiceId')]";
	public final static String Biller_Invoice_GetContactId="(//td[contains(text(),' Bill Number')]/span)[1]";
	public final static String Biller_ExportContact_ContactHeader="//label[contains(text(),'Contract Number')]/following-sibling::span";
	public final static String Biller_ExportContact_InvoiceDetails="//h6[text()='Invoice Details']";
	public final static String Biller_Tamplate_Table="(//table[contains(@id,'DataTables_Table')]//tbody/tr[@role='row'])";
	public final static String Biller_Tamplate_UpdateBtn="//button[contains(@id,'btnUpdate')]";
	public final static String Biller_Tamplate_UpdateTitleHdr="//h5[@id='exampleModalLongTitle']";
	public final static String Biller_Tamplate_UpdateDesHdr="//label[text()='Description']";
	public final static String Biller_Tamplate_UpdateInVTyeHdr="//label[text()='Invoice Type']";
	public final static String Biller_Tamplate_AddTitleHdr="//h5[@id='exampleModalLongTitle']";
	public final static String Biller_Tamplate_AddTemplNameArbicHdr="//label[text()='Template Name in Arabic']";
	public final static String Biller_Tamplate_AddTemplNameEngHdr="//label[text()='Template Name in English']";
	public final static String Biller_Tamplate_AddRefercodeHdr="(//label[text()='Reference Code'])";
	public final static String Biller_Tamplate_AddActDdeacHdr="(//label[text()='Activate/Deactivate'])[1]";
	public final static String Biller_Tamplate_AddBillPaymentyHdr="(//label[text()='Bill Payment'])";
	public final static String Biller_Tamplate_DeleteBtn="//button[contains(@id,'btnDelete')]";
	public final static String Biller_Tamplate_DeletePop="//h5[@id='ConfirmActivationMessage']";
	public final static String Biller_Tamplate_DeleteConfBtn="// button[@id='btnConfirm']";
	public final static String Biller_Tamplate_DeleteNoBtn="// button[text()='No']";
	public final static String Biller_Product_Table="(//table[@id='tblProducts']//tbody/tr[@role='row'])";
	public final static String Biller_Product_PName="(//table[@id='tblProducts']//tbody/tr[@role='row'])[1]/td[3]";
	public final static String Biller_Product_PCate="(//table[@id='tblProducts']//tbody/tr[@role='row'])[1]/td[4]";
	public final static String Biller_Product_NameInput="//input[@id='Name']";
	public final static String Biller_Product_SearchIDlist="//select[@id='ServiceId']";
	public final static String Biller_Product_SeachBtn="//button[@id='btnSearch']";
	public final static String Biller_Product_NoData="//td[contains(text(),'No data available in table')]";
	public final static String Biller_Product_ToggleBtn="(//table[@id='tblProducts']//tbody/tr[@role='row'])[1]//input[@class='switch']";
	public final static String Biller_Product_ActivePop="//h5[@id='ConfirmActivationMessage']";
	public final static String Biller_Product_ActiveConfbtn="//button[@id='btnConfirmActivation']";
	public final static String Biller_Menu_Discount ="//a[text()='Discounts Management']";
	public final static String Biller_Discount_AddBtn ="//button[@id='btnAddDiscount']";
	public final static String Biller_Discount_EngInp ="//input[@id='NameEn']";
	public final static String Biller_Discount_AtrabInp ="//input[@id='NameAr']";
	public final static String Biller_Discount_Percent ="//input[@id='Value']";
	public final static String Biller_Discount_toggle ="//label[@for='status']";
	public final static String Biller_Discount_Verify ="//table[@id='tblDiscounts']//td[1]";
	public final static String Biller_Discount_Deactivatetgl="//span[@class='switch switch-sm']";
	public final static String Biller_Discount_Deact_confirm="//h5[text()='Cancel activation?']";
	public final static String Biller_Discount_Canyes="//button[@id='btnConfirmActivation']";
	public final static String Biller_Discount_AddDiscBtn ="//button[contains(text(),'Add Discount')]";
	//public final static String Biller_Discount_AddDiscBtn ="//button[contains(text(),'Add Discount')]";
	public final static String Biller_Discount_DiscName ="//input[@id='DiscountName']";
	public final static String Biller_Discount_Name ="//table/tbody/tr/td[1]";
	public final static String Biller_Discount_SearchBtn ="//button[contains(text(),'Search')]";
	public final static String Biller_Discount_DeleteBtn ="//a[@class='mx-1 action bg-danger deleteItem']";	
	public final static String Biller_User_DeleteBtn ="//a[@class='mx-1 action bg-danger']";	
	public final static String Biller_User_ConfirmDeleteBtn ="//button[@class='btn btn-danger']";	
	
	public final static String Biller_Tamplate_ConfirmDeletePop="//h5[@id='ConfirmDeleteMessage']";
	public final static String Biller_Discount_YesConfBtn ="//button[@id='btnConfirmDelete']";
	public final static String Biller_Systemmgmt_TempBenificaryName = "//input[@name='TempBenificaryName']";
	public final static String Biller_Systemmgmt_BillerCode = "//input[@name='BillerCode']";
	public final static String Biller_Systemmgmt_TransferDuration = "//input[@name='TransferDuration']";
	public final static String Biller_Systemmgmt_BillerAliasNameAr = "//input[@name='BillerAliasNameAr']";
	public final static String Biller_Systemmgmt_BillerAliasNameEn = "//input[@name='BillerAliasNameEn']";
	public final static String Biller_Systemmgmt_BillingCatgeoryType = "//select[@id='BillerCategoryId']";
	public final static String Biller_Systemmgmt_HasSubBillers = "(//input[@name='HasSubBillers'])[1]";
	public final static String Biller_Systemmgmt_HasIndividualSubBillers = "(//input[@name='HasIndividualSubBillers'])[1]";
	public final static String Biller_Systemmgmt_HasEnterpriseSubBillers= "(//input[@name='HasEnterpriseSubBillers'])[1]";
	public final static String Biller_Systemmgmt_IsUrgentBillUploader= "(//input[@name='IsUrgentBillUploader'])[1]";
	public final static String Biller_Systemmgmt_HasMaximumInvoiceNumberPerDay= "(//input[@name='HasMaximumInvoiceNumberPerDay'])[1]";
	public final static String Biller_Systemmgmt_MaximumInvoiceNumber= "//input[@name='MaximumInvoiceNumber']";
	public final static String Biller_Systemmgmt_HasMaximumInvoiceAmountPerDay= "(//input[@name='HasMaximumInvoiceAmountPerDay'])[1]";
	public final static String Biller_Systemmgmt_Btnapprove= "//button[@id='btnApprove']";
	public final static String Biller_Systemmgmt_MaximumInvoiceAmount= "(//input[@name='MaximumInvoiceAmount'])[1]";
	public final static String Biller_Systemmgmt_Super= "(//input[@name='IsSuperBiller'])[1]";
	public final static String Biller_Systemmgmt_Tracker= "(//input[@name='IsTrackedBiller'])[1]";
	public final static String Biller_Systemmgmt_Confirm= "//button[@id='btnConfirmSetAsSuperBiller']";
	public final static String Biller_Systemmgmt_NewSuperBiller= "//select[@name='NewSuperBillerId']";
	
	public final static String Biller_Systemmgmt_ConfirmApprove= "//button[@id='btnConfirmApproveBillerInfo']";
	public final static String Biller_Systemmgmt_RejectButton= "//button[@id='btnReject']";
	public final static String Biller_Systemmgmt_ConfirmReject= "//button[@id='btnConfirmRejectBillerInfo']";

	
	public final static String Biller_Menu_UserManagement ="//a[text()='Groups Management']";
	public final static String Biller_Menu_UserList ="//a[text()='Users List']";
	public final static String Biller_UserList_AddUserBt ="//button[@id='btnAddUser']";
	public final static String Biller_UserListAdd_NameInput ="//input[@id='NameAR']";
	public final static String Biller_UserListAdd_EmailInput ="//input[@id='EMail']";
	public final static String Biller_UserListAdd_PhoneInput ="//input[@id='Phone']";
	public final static String Biller_UserListAdd_GroupCheckBox ="//div[@id='GroupsListDiv']//input";
	public final static String Biller_UserListAdd_GroupCheckBox2 ="//input[@id=75]";
	public final static String Biller_UserListAdd_AddUserBtPop ="//button[@id='btnAddUser']";
	public final static String Biller_UserListSearch_NameBt ="//input[@id='Name']";
	public final static String Biller_UserListSearch_EmailBt ="//input[@id='Email']";
	public final static String Biller_UserListSearch_SaerchBt ="//button[@id='btnSearch']";
	public final static String Biller_UserList_DeleteBtn ="//a[contains(@id,'btndelete')]";	
	public final static String Biller_UserList_ConfirmDeletePop="(//h5[@id='ConfirmActivationMessage'])[3]";
	public final static String Biller_UserList_YesConfBtn ="//button[@id='btnConfirmDelete']";
	public final static String Biller_Individualclient_Invoice="//input[@id='rdIndividual']";
//	public final static String Biller_Individualclient_Invoice_cName="//span[@id='select2-CustomerId-container']";
	public final static String Biller_Individualclient_Invoice_ChooseName="//select[@id='CustomerId']";
	public final static String Biller_Invoice_Fixed="//input[@name='SubBillerShareAmount']";
	public final static String Biller_Invoice_Percentage="//input[@name='SubBillerSharePercentage']";
	public final static String Biller_PriceListpagetxt = "//h6[@class='justify-content-start align-middle align-self-center']";
	public final static String Biller_PriceList="//a[@id='lnkPriceList2']";
	public final static String Biller_PriceListsfield="//input[@id='Name']";
	public final static String Biller_PriceListSeacrchbtn="//button[@class='btn btn-primary']";
	public final static String Biller_Settings_Invoice_template = "//a[@id='lnkInvoiceSetting2']";
	public final static String Biller_Invoice_Templategridview = "//table[@id='DataTables_Table_0']";
	public final static String Biller_ReportMenu = "//a[@id='lnkMyReports']";
	public final static String Biller_ClientsInvoicesReport = "(//a[@class='nav-link'])[18]";
	//public final static String Biller_ReceivablesReportsbtn = "//a[@class='dropdown-toggle collapsed']";
	public final static String Biller_ReceivablesReportsbtn = "//a[@id='refReceiptsSub22']";
	public final static String Biller_ClientsInvoicesReportMenu = "//a[@id='lnkExportedInvoicesReport2']";
	public final static String Biller_SettingContentMngVerifyNationalid ="(//tr[@role='row']//td[4])[1]";
	public final static String Biller_SettingContentMngVerifyRefnoid ="(//tr[@role='row']//td[7])[1]";
	public final static String Admin_customReconcillation_PaymentMethod="//span[@id='select2-PaymentTypeId-container']";
	public final static String Admin_customReconcillation_BillerName="//table//tr[1]//td[6]";
	public final static String Admin_customReconcillation_PaymentMethodValues="//li[@role='treeitem' and @aria-selected='false']";

	public final static String Biller_CorporateClientReport = "//a[@id='lnkBillerCompanyClientsReport']";
	public final static String Biller_Clientreport_FromDate = "//input[@id='FromDate']";
    public final static String Biller_Clientreport_Fromyear = "//select[@title='Change the year']";
    public final static String Biller_Clientreport_FromMonth = "//select[@title='Change the month']";
    public final static String Biller_Clientreport_TODate = "//input[@id='ToDate']";
    public final static String Biller_Clientreport_Toyear = "(//select[@class='calendars-month-year'])[2]";
    public final static String Biller_Clientreport_ToMonth = "(//select[@class='calendars-month-year'])[1]";
    public final static String Biller_ClientType = "//select[@id='ClientTypeId']";
    public final static String Biller_ClientNamearro = "(//span[@class='select2-selection__arrow'])[1]";
    public final static String Biller_ClientNametextbox= "//input[@type='search']";
   // public final static String Biller_ClientNametextbox= "(//span[@role='combobox'])[1]";
    public final static String Biller_ClientNameoption= "//ul[@role='tree']/li[1]";
    public final static String Biller_ClientNametext= "//li[@role='treeitem']";
    public final static String Biller_BillStatus = "(//span[@role='combobox'])[2]";
    public final static String Biller_IdorCR = "//input[@id='ClientRefNumber']";
    public final static String Biller_SubBillerType = "//select[@id='SubBillerType']";
    public final static String Biller_clientSubBillerName = "//span[text()='- Select Sub Biller -']";

    public final static String Biller_SubBillerNamearro = "(//span[@role='presentation'])[4]";
    public final static String Biller_Clientstatus= "(//span[@role='combobox'])[2]";
    public final static String Biller_SubBillerNametxtbox = "//input[@type='search']";
    public final static String Biller_SubbillerNameoption = "//ul[@role='tree']/li[1]";
    public final static String Biller_Generatebtn = "//button[@id='btnSearch']";
    public final static String Biller_invoiceReport = "//a[@tabindex='1']";
    public final static String Biller_Exporttoexcelbtn = "//button[@id='btnExport']";
    public final static String Biller_exportedmsg = "//div[@id='dvUnderProcessing']";
    public final static String Biller_Termsmanagementsym="//h6[text()='Terms Management']";
    public final static String Biller_Settingbtn="//a[@id='lnkMySettings']";
    public final static String Biller_Termsmanagementbtn="(//a[text()='Terms Management'])[2]";
    public final static String Biller_Termsnameinarabic="//tr/th[text()='Term Name in Arabic']";    
    public final static String Biller_AddTermbtn="//button[@id='btnAddTerm']";    
    public final static String Biller_Arebicname="//input[@id='NameAr']";    
    public final static String Biller_Englishname="//input[@id='NameEn']";    
    public final static String Biller_Termarebicname="//textarea[@id='DescriptionAr']";    
    public final static String Biller_TermEnglishname="//textarea[@id='DescriptionEn']";    
    public final static String Biller_TermpopupActivebtn="//input[@id='status']";    
    public final static String Biller_Termpopupsavebtn="(//button[@class='btn btn-primary'])[3]";    
    public final static String Biller_searchtxtfield="//input[@id='TermName']";    
    public static final String Biller_TermsManagement_Editbtn = "(//button[@onclick='Update(this);'])[1]";	
	public static final String Biller_TermsManagement_updatetxt = "//h6[@class='modal-title']";	
   // public final static String Biller_Searchbtn="(//button[@class='btn btn-primary'])[1]";    

    public final static String Biller_PaidOutsidemenu="//a[text()='Paid Outside EDAAT Bills'][1]";    
    public final static String Biller_Attachfile="//input[@id='ExcelFile']";    
    public final static String Biller_Proccesbtn="//button[@id='btnProcessingExcelFile']";    
    public final static String Biller_successmsg="//span[@id='spnUnderProcessing']";    
     //Biller Reports Sub biller Report
    public final static String Biller_SubBillerReportLink="//a[@id='lnkSubBillersInfoReport2']";    
    public final static String Biller_SubBillerNationalID="//input[@id='NationalId']";    
    public final static String Biller_SubBillerGenerateReport="//button[@id='btnSearch']";    
    public final static String Biller_SubBillerCRNumber="//input[@id='RegistrationNumber']";    
    public final static String Biller_SubBillerIndividual="//input[@id='rdSubbillerIndividual']";    
    public final static String Biller_SubBillerCorporate="//label[text()='Corporate']";    
	
	//Receivables Sadad payment Transaction report
	public final static String Biller_Receivables_Sadadpaybtn = "//a[@id='lnkSadadPaymentsTransactionsReport']";
	public final static String Biller_Receivables_SadadpayInvoicetype = "//select[@id='InvoiceTypeId']";
	public final static String Biller_Receivables_SadadpayInvoiceno= "//input[@id='InvoiceNumber']";
	public final static String Biller_Receivables_SadadpayClienttype = "//select[@id='InvoiceTypeId']";
	public final static String Biller_Receivables_SadadpayClientname= "//span[@id='select2-ClientId-container']";
	public final static String Biller_Receivables_SadadpayClientselect= "//span[@id='select2-ClientId-container']";
	public final static String Biller_Receivables_Sadadpay_FromMonth="//select[@title='Change the month']";
	public final static String Biller_Receivables_Sadadpay_FromYear="//select[@title='Change the year']";
	public final static String Biller_Receivables_Sadadpay_ToMonth="//select[@title='Change the month']";
	public final static String Biller_Receivables_Sadadpay_ToYear="//select[@title='Change the year']";
	public final static String Biller_Receivables_Sadadpay_FromCalender="//input[@id='FromDate']";
	public final static String Biller_Receivables_Sadadpay_ToCalender="//input[@id='ToDate']";
	public final static String Biller_Receivables_Sadadpay_product="//span[text()='Select Product']";
	public final static String Biller_Receivables_Sadadpay_generatebtn="//button[@id='btnSearch']";
	public final static String Biller_Receivables_Sadadpay_frame="//iframe";
	public final static String Biller_Receivables_Sadadpay_Verify="//div[text()='Sadad Payment Transactions Report']";
	
	//Receivable Super Biller Report	
   
    public final static String Biller_OverDueBillesTrackedBiller = "//input[@class='select2-search__field']";
    public final static String Biller_OverDueBillsReportPage = "(//a[@href='/SuperReport/ClientDelayedBillsReport'])[2]";
    // Biller SuperBiller SubBiller
    public final static String Biller_SuperBiller_subBillerbtn = "//a[@id='lnkSubBillersInfoTrackReport2']";
	public final static String Biller_SuperBiller_SubBiller_selectInd = "//label[text()='Individual']";
	public final static String Biller_SuperBiller_SubBiller_selectCorp= "//label[text()='Corporate']";
	public final static String Biller_SuperBiller_SubBiller_Nationalefield= "//input[@name='NationalId']";
	public final static String Biller_SuperBiller_SubBiller_Crnumberefield= "//input[@name='RegistrationNumber']";
	public final static String Biller_SuperBiller_SubBiller_trackbill= "//input[@role='textbox']";
	public final static String Biller_SuperBiller_SubBiller_generatebtn= "//button[@id='btnSearch']";
	public final static String Biller_SuperBiller_SubBiller_frame= "//iframe";
	public final static String Biller_SuperBiller_SubBiller_indVerify= "//div[contains(text(),'Individual Sub Billers')]";
	public final static String Biller_SuperBiller_SubBiller_CorpVerify= "//div[text()='Corporate Sub Billers Report']";
	
	//Biller  individual client error Message
	public final static String Biller_FirstNameErrorMsg="//span[@id='FirstName-error']";
	public final static String Biller_SecondNameErrorMsg="//span[@id='SecondName-error']";
	public final static String Biller_ThirdNameErrorMsg="//span[@id='ThirdName-error']";
	public final static String Biller_LastNameErrorMsg="//span[@id='LastName-error']";
	public final static String Biller_NationalIDErrorMsg="//span[@id='IdNumber-error']";
	public final static String Biller_MobileNoErrorMsg="//span[@id='MobileNo-error']";
	public final static String Biller_AlertMsg="//div[@id='alert-error']";
	public final static String Biller_ClientRefExistsAlertMsg="//div[text()='Client Reference Number already exists']";
	public final static String Biller_NationalIDExistsAlertMsg="//div[text()='The client with the national ID number entered is already registered']";
	public final static String Biller_MandatoryErrorMsg="(//span[text()='This Field Is Required'])[1]";
	public final static String Biller_NationalIDStartsError="//span[@id='spanIdError']";
	public final static String Biller_DeleteClientErrMsg="//span[@id='Reason-invalid']";
	public final static String Biller_Invoice_DeleteFrstRow = "(//select[@onchange='SelectAction(this)'])[1]";
	public final static String Biller_RequiredFieldsErrMsg="(//span[text()='This Field Is Required'])[1]";
	public final static String Biller_RequiredCorpNameErrMsg="//span[@id='NameAr-error']";
	public final static String Biller_RequiredCRNoErrMsg="//span[@id='RegistrationNo-error']";
	public final static String Biller_RequiredAuthNameErrMsg="//span[@id='CommissionerNameAr-error']";
	public final static String Biller_RequiredAuthIDErrMsg="//span[@id='CommissionerNationalId-error']";
	public final static String Biller_RequiredAuthMobileNoErrMsg="//span[@id='CommissionerMobileNo-error']";


	
	//public final static String Admin_Receivable_Link="//a[contains(text(),'Receivables')]";
	public final static String Admin_Receivable_Link="//a[@id='lnkReceipts2']";
	public final static String Admin_Billerno_search="//input[@id='billNo']";
	public final static String Admin_Billerno_button="//button[@id='btnSearch']";
   //public final static String Admin_ExportBill_Link="//a[contains(text(),'Exported Bills')]";
	public final static String Admin_ExportBill_Link="//a[@id='lnkInvoiceList2']";
	public final static String Admin_AddInvoice_btn="//button[@id='btnAddInvoice']";
	public final static String Admin_AddInvoice_Header="//h6[text()='Create Invoice']";
	public final static String Admin_Invoice_IndividualRdv="//input[@id='rdIndividual']";
	public final static String Admin_Invoice_CopoRdv="//input[@id='rdCompany']";
	public final static String Admin_Invoice_ComCustIDList="//select[@name='CompanyId']/following-sibling::span//span[@class='select2-selection__arrow']";
	public final static String Admin_Invoice_CustIDList="//select[@name='CustomerId']/following-sibling::span//span[@class='select2-selection__arrow']";
	public final static String Admin_Invoice_SBilIdList="//select[@name='SubBillerId']/following-sibling::span//span[@class='select2-selection__arrow']";
	public final static String Admin_Invoice_SBilShareamountFil="//input[@id='SubAdminShareAmount']";
	public final static String Admin_Invoice_SBilSharePerFil="//input[@id='SubAdminSharePercentage']";
	public final static String Admin_Invoice_TemplateList="//select[@id='InvoiceTemplateId']";
	public final static String Admin_Invoice_Create="//button[@id='btnCreateInvoice']";
	public final static String Admin_Invoice_AddProductBtn="//a[@id='btnAddProductModal']";
	public final static String Admin_Invoice_Subbill="//input[@id='rdSubAdminIndividual']";
	public final static String Admin_Invoice_TaxPric="//input[@id='tbxPrice']";
	public final static String Admin_Invoice_ProductID="//select[@name='ProductId']";
	public final static String Admin_Invoice_AddBtn="//div[@class='modal-footer']/button[@id='btnAddProduct']";
	public final static String Admin_Invoice_DateInvoc="//input[@id='IssueDate']";
	public final static String Admin_Invoice_DurationID="//select[@name='DurationTypeId']";
	public final static String Admin_Invoice_MinTax="//input[@name='MinLimit']";
	public final static String Admin_Invoice_CreateReapeat="//button[@id='btnCreateRepeatInvoice']";
	public final static String Admin_Invoice_Conditon="//textarea[@id='txtConditions']";
	public final static String Admin_Invoice_Conditonbtn="(//div[@id='divTerms']//input)[1]";
	public final static String Admin_Invoice_Descript="//textarea[@id='txtBillDescription']";
	public final static String Admin_Invoice_Descript1="//textarea[@id='txtDescription_1']";
	public final static String Admin_Invoice_SaveButton="//button[@id='btnUpdateBill']";
	public final static String Admin_Invoice_ExportButton="//button[@id='btnUpdateBill']";
	public final static String Admin_Invoice_Exportandcreatebtn="//button[@id='btnExportInvoice']";
	public final static String Admin_Invoice_Exportandcreatebtn1="//button[text()=' Create and export']";
	public final static String Admin_Invoice_installmentButton="//button[@id='btnCreateRepeatInvoice']";
	public final static String Admin_Invoice_Count="(//table[@id='tblBillList']//tbody/tr[@role='row'])";
	public final static String Admin_Invoice_AfteraddCount="(//table[@id='tblInvoiceList']//tbody/tr[@role='row'])";
	public final static String Admin_Invoice_AfteraddInvoice="(//table[@id='tblBillList']//tbody/tr[@role='row'])";
	public final static String Admin_Invoice_ClientRoleId="(//li[@role='treeitem'])";
	public final static String Admin_RegistDate_exprDate ="//a[contains(@class,'calendars-today')]";
	public final static String Admin_InvoiceLastCheckBox="(//table[@id='tblBillList']//tbody/tr[@role='row'])//input[@type='checkbox'][last()]";
	public final static String Admin_Invoice_GetBilId="(//td[contains(text(),' Bill Number')]/span)[1]";
	public final static String Admin_ExportContact_Link="//a[contains(text(),'Exported Contracts')]";
	public final static String Admin_Invoice_GetContactId="(//td[contains(text(),' Bill Number')]/span)[1]";
	public final static String Admin_Invoice_NextBtn="//a[text()='Next']";
	public final static String Admin_Invoice_Next="//li[a[text()='Next']][contains(@class,'next disabled')]";
	public final static String Admin_Invoice_NextPrevLink="(//li[a[text()='Next']]/preceding-sibling::li)[last()]/a";
	public final static String Admin_Export_CancellationBtn="//button[@id='btnCancelSelected']";
	public final static String Admin_Export_PayOutsideBtn="//button[@id='btnPayCashSelected']";
	public final static String Admin_Export_ViewContactBtn="(//table[@id='tblBillList']//tbody/tr[@role='row'])//a[@title='View Contract'][last()]";
	public final static String Admin_ExportExcel="//a[@id='btnExport']";
	public final static String Admin_ExportExcel_Verify="//span[@id='spnUnderProcessing']";
	public final static String Admin_Invoice_BillNo="//a[contains(@href,'billNo')]";
	public final static String Admin_Invoice_BillerNumber="//label[contains(text(),'Bill Number')]/h6";
	public final static String Admin_Invoice_PrintButton="//button[@id='btnPrintInvoice']";
	public final static String Admin_ExportContact_InvID="//a[contains(@href,'invoiceId')]";
	public final static String Admin_ExportContact_ContactHeader="//label[contains(text(),'Contract Number')]/following-sibling::span";
	public final static String Admin_ExportContact_InvoiceDetails="//h6[text()='Invoice Details']";
	public final static String Admin_ExportBills_Date="//table[@id='tblBillList']//tbody//tr[1]//td[3]";
	public final static String Admin_ExportBills_Status="//table[@id='tblBillList']//tbody//tr[1]//td[6]";
	
	public final static String Admin_Client = "//a[@id='lnkMyClients2']";
	public final static String Admin_Add_Individualclient = "//a[@id='lnkCustomerList2']";
	public final static String Admin_Add_Individualclient_Button = "//button[@id='btnAddCustomer']";
	public final static String Admin_Corporate_Name = "//input[@id='CompanyName']";
	public final static String Admin_ClientName = "//input[@id='Name']";
	public final static String Admin_CorporateName = "//input[@id='CompanyName']";
	public final static String Admin_CR_Number= "//input[@id='RegistrationNo']";
	public final static String Admin_IN_nationalID= "//input[@id='IdNumber']";
	public final static String Admin_ClientRef_Number= "//input[@id='CustomerRefNumber']";
	public final static String Admin_IN_ClientRef_Number= "//input[@id='CustomerRefNumber']";
	public final static String Admin_ClientSearch_button= "//button[@id='btnSearch']";
	public final static String Admin_Individualclient_fname = "//input[@id='FirstName']";
	public final static String Admin_Individualclient_sname = "//input[@id='SecondName']";
	public final static String Admin_Individualclient_tname = "//input[@id='ThirdName']";
	public final static String Admin_Individualclient_lname = "//input[@id='LastName']";
	public final static String Admin_Individualclient_IdNumber = "//input[@id='IdNumber']";
	public final static String Admin_Individualclient_DateOfBirth = "//input[@id='DateOfBirthHijri']";
	public final static String Admin_Individualclient_DateOfYear = "//select[@title='Change the year']";
	public final static String Admin_Individualclient_DateOfMonth = "//select[@title='Change the month']";
	public final static String Admin_Individualclient_Email = "//input[@id='Email']";
	public final static String Admin_Individualclient_Refno = "//input[@id='CustomerRefNumber']";
	public final static String Admin_Individualclient_MobileNo = "//input[@id='MobileNo']";
	public final static String Admin_Individualclient_ClientRefNo = "//input[@id='CustomerRefNumber']";
	public final static String Admin_Individualclient_Add = "//input[@id='btnAdd']";
	
	public final static String Admin_Settings = "//a[@id='lnkMySettings']";
	public final static String Admin_Individualclient_Name = "//input[@id='Name']";
	public final static String Admin_Invoice_Search ="//button[text()='Search']";
	public final static String Admin_Add_Invoice_template = "//a[@id='lnkInvoiceSetting2']";
	public final static String Admin_Add_Invoice_Button = "//button[@id='btnAddTemplate']";
	public final static String Admin_Invoice_TemplateArabic = "//input[@id='NameAr']";
	public final static String Admin_Invoice_TemplateEng= "//input[@id='NameEn']";
	public final static String Admin_Invoice_Templatetype= "//input[@id='BillType_16']";
	public final static String Admin_Invoice_Templatetype_One= "//input[@id='BillType_15']";
	public final static String Admin_Invoice_Add = "//button[@id='btnAdd']";
	public final static String Admin_Tamplate_AddTitleHdr="//h5[@id='exampleModalLongTitle']";
	public final static String Admin_Tamplate_AddTemplNameArbicHdr="//label[text()='Template Name in Arabic']";
	public final static String Admin_Tamplate_AddTemplNameEngHdr="//label[text()='Template Name in English']";
	public final static String Admin_Tamplate_AddRefercodeHdr="//label[text()='Reference Code']";
	public final static String Admin_Tamplate_AddActDdeacHdr="(//label[text()='Activate/Deactivate'])[1]";
	public final static String Admin_Tamplate_AddBillPaymentyHdr="//label[text()='Bill Payment']";
	
	
	public final static String Admin_Tamplate_Table="(//table[contains(@id,'DataTables_Table')]//tbody/tr[@role='row'])";
	public final static String Admin_Tamplate_UpdateBtn="//button[contains(@id,'btnUpdate')]";
	public final static String Admin_Tamplate_UpdateTitleHdr="//h5[@id='exampleModalLongTitle']";
	public final static String Admin_Tamplate_UpdateDesHdr="//label[text()='Description']";
	public final static String Admin_Tamplate_UpdateInVTyeHdr="//label[text()='Invoice Type']";
	public final static String Admin_Tamplate_DeleteBtn="//button[contains(@id,'btnDelete')]";
	public final static String Admin_Tamplate_DeletePop="//h5[@id='ConfirmActivationMessage']";
	public final static String Admin_Tamplate_DeleteConfBtn="// button[@id='btnConfirm']";
	public final static String Admin_Tamplate_DeleteNoBtn="// button[text()='No']";
	
	public final static String Admin_Prod_NameArabic = "(//input[@id='Name'])[2]";
	public final static String Admin_Prod_Ref = "//input[@id='Code']";
	public final static String Admin_Prod_Description = "//textarea[@id='Description']";
	public final static String Admin_Invoice_TemplateEnglish= "//input[@id='NameEn']";
	public final static String Admin_Prod_Price= "//input[@id='Price']";
	public final static String Admin_Prod_MaxPrice= "//input[@id='MaxPrice']";
	
	public final static String Admin_Prod_MinPrice= "//input[@id='MinPrice']";
	public final static String Admin_Prod_Addbutton="//button[@id='btnAddProduct']";
	public final static String Admin_Individualclient_fistname = "//input[@id='FirstName']";
	public final static String Admin_Maxlimit = "//input[@id='Limit']";
	public final static String Admin_TransferDuration = "//input[@id='TransferDuration']";
	public final static String Admin_AzimFee = "//input[@id='AzimFee']";
	public final static String Admin_sadadFee = "//input[@id='sadadFee']";
	public final static String Admin_AdminAliasNameEn = "//input[@id='AdminAliasNameEn']";
	public final static String Admin_MaximumInvoiceAmount = "//input[@id='MaximumInvoiceAmount']";
	public final static String Admin_Imgdownload = "//a[@class='text-white']";
	public final static String Admin_InvoiceName= "//a[contains(@href,'ViewIndividualCustomer')]";
	public final static String Admin_Invoice_Select="(//select[@id='ServiceId'])[2]";
    //Admin settings Discount Management
	public final static String Admin_Menu_Discount ="//a[text()='Discounts Management']";
	public final static String Admin_DiscountNameEn="//input[@id='NameEn']";
	public final static String Admin_DiscountNameAr="//input[@id='NameAr']";
	public final static String Admin_DiscPercentage="//input[@id='Value']";
	public final static String Admin_AddDiscountBtn="//button[text()='Add Discount']";
	public final static String Admin_SearchDiscountBtn="//button[text()='Search']";
	public final static String Admin_SearchDiscountName="//input[@id='DiscountName']";
	public final static String Admin_AddDiscount="//button[@id='btnAddDiscount']";
	public final static String Admin_DiscountStatusToggle="(//input[@class='switch'])[1]";
	public final static String Admin_confirmationMsg="//h5[@id='ConfirmActivationMessage']";
	public final static String Admin_Activate="//button[@id='btnConfirmActivation']";
    public final static String Admin_Discount_DeleteBtn ="//a[@class='mx-1 action bg-danger deleteItem']";	
	public final static String Admin_User_DeleteBtn ="//a[@class='mx-1 action bg-danger']";	
	public final static String Admin_User_ConfirmDeleteBtn ="//button[@class='btn btn-danger']";	
	public final static String Admin_Product_noData="//td[contains(text(),'No data available in table')]";
	public final static String Admin_Discount_YesConfBtn ="//button[@id='btnConfirmDelete']";
	public final static String Admin_Tamplate_ConfirmDeletePop="//h5[@id='ConfirmDeleteMessage']";
	
	//public final static String Admin_Individualclient_Search = "//button[@id='btnSearch']";
	public final static String Admin_Individualclient_Search = "//button[@id='btnSearch']";
	public final static String Admin_Invoice_Delete = "//select[@onchange='SelectAction(this)']";
	public final static String Admin_Invoice_DeleteFrstRow = "(//select[@onchange='SelectAction(this)'])[1]";
	public final static String Admin_InvoiceDelete = "(//select[@onchange='SelectAction(this)'])[1]";
	public final static String Admin_Invoice_Reasontxt="//input[@type='search']";
	public final static String Admin_Invoice_Deletebtn = "//button[@id='btnConfirmDelete']";
	public final static String Admin_Invoice_Deletechkbox="//label[@for='Deleted']";
	public final static String Admin_Invoice_table="//table[@id='tblCustomers']";
	public final static String Admin_Individualclient_SearchByname = "//input[@id='Name']";
	public final static String Admin_Corpclient_Searchname = "(//span[contains(text(),'client')])[1]";
	public final static String Admin_Corpclient_SearchName = "(//span[contains(text(),'FullNameOne')])[1]";
	public final static String Admin_Individualclient_Back ="//a[text()='Back']";
	public final static String Admin_Invoice_Fixed="//input[@name='SubBillerShareAmount']";
	public final static String Admin_Invoice_Percentage="//input[@name='SubBillerSharePercentage']";
	
//	public final static String AdminSystem_Individual="//h6[text()='Individual Clients Management']";
//    public final static String AdminSystem_Individual_link="//a[@id='lnkActivateClients2']";
//    public final static String AdminSystem_IndividualClient_Name="//input[@id='CustomerName']";
//    public final static String AdminSystem_Individual_national="//input[@id='NationalID']";
//    public final static String AdminSystem_Individual_Search="//button[@id='btnSearch']";
//    public final static String AdminSystem_Individual_verify="//h6[@class='justify-content-start align-middle align-self-center mb-3']";
//	
	
	
	
	
	
	public final static String Admin_Add_Companyclient = "//a[@id='lnkCompanyList2']";
	public final static String Admin_Corporateclient_name = "//input[@id='NameAr']";
	public final static String Admin_CorporateclientName= "//input[@id='CompanyName']";
	public final static String Admin_Corporateclient_Rno = "//input[@id='RegistrationNo']";
	public final static String Admin_Corporateclient_lang = "//label[text()='English']";
	public final static String Admin_Corporateclient_commissioner = "//input[@id='CommissionerNameAr']";
	public final static String Admin_Corporateclient_commissionerID = "//input[@id='CommissionerNationalId']";
	public final static String Admin_Corporateclient_commissioner_Mobile = "//input[@id='CommissionerMobileNo']";
	public final static String Admin_Corporateclient_commissioner_Email = "//input[@id='CommissionerEmail']";
	public final static String Admin_Corporateclient_commissioner_Crno = "//input[@id='CustomerRefNumber']";
	



	//Admin Clients Indidvidual clients
	public final static String Admin_Individualclient_CustomerRefNumber = "//input[@id='CustomerRefNumber']";
	public final static String Admin_Individualclient_Companyname = "//input[@id='CompanyName']";
	public final static String Admin_Corporateclient_tbl = "//table[@id='tblCompanies']";
	public final static String Admin_Corporateclient_search = "//input[@id='CompanyName']";
	public final static String Admin_Individualclient_Searchname = "//span[contains(text(),'comp')]";
	public final static String Admin_Corporateclient_Save = "//input[@id='btnUpdate']";
	public final static String Admin_Individualclient_Deactivate ="(//input[@type='checkbox'])[3]";
	public final static String Admin_Individualclient_button="//button[text()='Yes']";
	public final static String Admin_Company_ToggleBtn="(//table[@id='tblCompanies']//tbody/tr[@role='row'])[1]//input[@class='switch']";
	public final static String Admin_Company_ToggleButton="(//table[@id='tblCustomers']//tbody/tr[@role='row'])[1]//input[@class='switch']";
	public final static String Admin_Company_Togglebtn="//label[@class='mb-0']";
	public final static String Admin_Compan_ActivePop="//h5[@id='ConfirmActivationMessage']";
	public final static String Admin_Compan_ActiveConfbtn="// button[@id='btnConfirmActivation']";
	public final static String Admin_Individualclient_export="//a[@id='btnExport']";
	public final static String Admin_Invoice_form ="//form[@action='ePayment-ar4.html']";
	public final static String Admin_Invoice_view ="(//a[@title='View Contract'])[1]";
	public final static String Admin_FirstNameErrorMsg="//span[@id='FirstName-error']";
	public final static String Admin_SecondNameErrorMsg="//span[@id='SecondName-error']";
	public final static String Client_SecondNameErrorMsg="//span[@id='FatherName-error']";
	public final static String Client_ThirdNameErrorMsg="//span[@id='GrandFatherName-error']";
	public final static String Admin_ThirdNameErrorMsg="//span[@id='ThirdName-error']";
	public final static String Admin_LastNameErrorMsg="//span[@id='LastName-error']";
	public final static String Admin_NationalIDErrorMsg="//span[@id='IdNumber-error']";
	public final static String Client_NationalIDErrMsg="//span[@id='NationalID-error']";
	public final static String Client_DOBErrMsg="//span[@id='DateOfBirth-error']";
	public final static String Admin_MobileNoErrorMsg="//span[@id='MobileNo-error']";
	public final static String Client_EmailErrorMsg="//span[@id='Email-error']";
	public final static String Client_PasswordErrMsg="//span[@id='Password-error']";
	public final static String Client_ConfirmPasswordErrMsg="//span[@id='ConfirmPassword-error']";
	public final static String Client_FullNameErrMsg="(//span[text()='Please use only characters'])[1]";
	public final static String Admin_AlertMsg="//div[@id='alert-error']";
	public final static String Admin_NationalIDExistsAlertMsg="//div[text()='The client with the national ID number entered is already registered']";
	public final static String Admin_MandatoryErrorMsg="(//span[text()='This Field Is Required'])[1]";
	public final static String Admin_NationalIDStartsError="//span[@id='spanIdError']";
	public final static String Admin_ClientRefExistsAlertMsg="//div[text()='Client Reference Number already exists']";
	public final static String Client_NationaIDDigitErrMsg="//span[text()='Please enter a 10-digit number']";
	public final static String Client_NationaIDStartsErrMsg="//span[text()='National ID must start with 1 or 2']";
	public final static String Client_NationaIDExistsErrMsg="//h5[text()='The client with the national ID number entered is already registered']";
	public final static String Client_EmailExistsErrMsg="//h5[text()='Email Already Exists']";
	public final static String Admin_DeleteClientErrMsg="//span[@id='Reason-invalid']";
	
	//Admin Clients Corporate clients
	public final static String Admin_RequiredFieldsErrMsg="(//span[text()='This Field Is Required'])[1]";
	public final static String Admin_RequiredCorpNameErrMsg="//span[@id='NameAr-error']";
	public final static String Admin_RequiredCRNoErrMsg="//span[@id='RegistrationNo-error']";
	public final static String Admin_RequiredAuthNameErrMsg="//span[@id='CommissionerNameAr-error']";
	public final static String Admin_RequiredAuthIDErrMsg="//span[@id='CommissionerNationalId-error']";
	public final static String Admin_RequiredAuthMobileNoErrMsg="//span[@id='CommissionerMobileNo-error']";


	// Admin settings Invoice templates, product management
	public final static String Admin_InvoiceTemplateArNameErrMsg="//span[@id='NameAr-error']";
	public final static String Admin_InvoiceTemplateEnNameErrMsg="//span[@id='NameEn-error']";
	public final static String Admin_InvoiceTypeErrMsg="//span[@id='BillTypeID-error']";
	public final static String Admin_PercentageReqErrorMsg="//span[@id='Value-error']";
	public final static String Admin_ProductNameArErrorMsg="//span[@id='Name-error']";
	public final static String Admin_ProductNameEnErrorMsg="//span[@id='NameEn-error']";
	public final static String Admin_ProductCategoryErrorMsg="//span[@id='ServiceId-error']";
	public final static String Admin_ProductPriceErrorMsg="//span[@id='Price-error']";
	public final static String Admin_RefCodeErrorMsg="//span[@id='codeCustomAlreadyUsedError']";
	
	
	//Admin Settings 
	public final static String Admin_ArNameErrorMsg="//span[@id='NameAr-error']";
	public final static String Admin_EnNameErrorMsg="//span[@id='NameEn-error']";
	public final static String Admin_ArDescErrorMsg="//span[@id='DescriptionAr-error']";
	public final static String Admin_RatioErrorMsg="//span[@id='Value-error']";
	public final static String Admin_FromDateErrorMsg="//span[@id='FromDate-error']";
	public final static String Admin_ToDateErrorMsg="//span[@id='ToDate-error']";
	public final static String Admin_RoundingErrorMsg="//span[@id='RoundingTypeID-error']";
	
	public final static String Admin_Product_ActivePop="//h5[@id='ConfirmActivationMessage']";
	public final static String Admin_Product_ActiveConfbtn="// button[@id='btnConfirmActivation']";
	public final static String Admin_Product_ToggleBtn="(//table[@id='tblProducts']//tbody/tr[@role='row'])[1]//input[@class='switch']";
	public final static String Admin_Product_ToggleButton="(//input[@class='switch'])[1]";
	public final static String Admin_Systemmgmt_AddProductBtn="//button[@id='btnAddProduct']";
	public final static String Admin_AddBtn="//div[@class='modal-footer']/button[@id='btnAddProduct']";
	public final static String Admin_Add_Product = "//a[text()='Products Management']";
	public final static String Admin_Add_Cat = "//button[text()='Add']";
	public final static String Admin_Add_tax = "(//button[text()='Add Tax'])[2]";
	public final static String Admin_Add_RefError = "//span[contains(text(),' already')]";
	public final static String Admin_Add_TaxErrorMsg = "//span[@id='NameEn-error']";
	public final static String Admin_Add_TaxErrorMsgArabic = "//span[@id='NameAr-error']";
	public final static String Admin_TaxMngRefrenceCodeUseError = "//span[@data-valmsg-for='Code']//following-sibling::span";
	public final static String Admin_TaxMngRefrenceCodeError = "//span[@id='Code-error']";
	public final static String Admin_TaxMngPercentageError = "//span[@data-valmsg-for='Value']";

	public final static String Admin_Status = "//input[@id='status']";
	public final static String Admin_Cat_Addbtn = "//button[@id='btnAddService']";
	public final static String Admin_Prod_CatArabic = "(//input[@id='Name'])[2]";
	public final static String Admin_taxArabic = "//input[@id='NameAr']";
	public final static String Admin_PercentageValue = "//input[@id='Value']";
	public final static String Admin_Prod_CatEng= "//input[@id='NameEn']";
	public final static String Admin_Prod_CatEngError= "(//span[@id='Name-error'])[1]";
	public final static String Admin_Prod_CatArError= "(//span[@id='Name-error'])[2]";
	public final static String Admin_Prod_CatArInvalidError= "(//span[text()='Please use numbers and letters only'])[2]";
	public final static String Admin_SearchCat ="//button[text()='Search']";	
	public final static String Admin_Updatebtn ="//button[@onclick='Update(this);']";
	public final static String Admin_UpdateSearch ="//input[@id='Name']";
	public final static String Admin_Prod_CatEnglish ="(//input[@id='Name'])[1]";
    public final static String Admin_Prod_CatSrch ="//button[text()='Search']";
	public final static String Admin_Prod_Nodata ="//td[text()='No data available in table']";
	public final static String Admin_CatTable ="//table[@id='DataTables_Table_0']";
	public final static String Admin_UpdateCat = "//button[text()='Save Changes']";
	public final static String Admin_Tax_Addbtn = "//button[@id='btnAddTax']";
	public final static String Admin_Prod_Category="//a[@id='lnkServiceList2']";
	public final static String Admin_Prod_Category_header="//h6[text()='Products Categories']";
	public final static String Admin_Tax_Mgmt="//a[@id='lnkTaxList2']";
	public final static String Admin_Tax_ToggleBtn="(//table[@id='tblTaxes']//tbody/tr[@role='row'])[1]//input[@class='switch']";
    public final static String Admin_Tax_TaxEngError="//span[@id='NameEn-error']";
	public final static String Admin_Tax_TaxArbError="//span[@id='NameAr-error']";
	public final static String Admin_Tax_PercenError="//span[@id='Value-error']";
	public final static String Admin_Tax_RefcodeError="//span[@id='Code-error']";
	public final static String Admin_Tax_RefcodeExistsError="//span[@id='codeCustomAlreadyUsedError']";
	
	
	public final static String Admin_system_subBlr_header="//h6[text()='Sub Billers']";
	public final static String ClientsPayablesIncomingBillsHeader ="//h3[text()='Incoming Bills']";
	public final static String Admin_SysMgm_ApprovedBillers_Header="//h6[text()='Approved Billers']";

	//Admin SAMA Integration
	public final static String Admin_SystemMng_SamaIntegration="//a[@id='lnkSAMAIntegration2']";
	public final static String Admin_SystemMng_SamaIntegration_history="//a[@id='lnkSAMAIntegration2_History']";
	public final static String Admin_SystemMng_SamaIntegration_historytype="//select[@id='historyType']";
	public final static String Admin_SystemMng_SamaIntegrationFromdate="//input[@id='from']";
	public final static String Admin_SystemMng_SamaIntegrationTodate="//input[@id='to']";
	public final static String Admin_SystemMng_SamaIntegrationFromYear="//select[@title='Change the year']";
	public final static String Admin_SystemMng_SamaIntegrationFromMonth="//select[@title='Change the month']";
	public final static String Admin_SystemMng_SamaIntegrationToyear="//select[@title='Change the year']";
	public final static String Admin_SystemMng_SamaIntegrationToMonth="//select[@title='Change the month']";
	public final static String Admin_SystemMng_SamaIntegrationsrcbtn="//button[@id='searchBtn']";

	public final static String Admin_Prod_Pricelist= "//li[@class='select2-search select2-search--inline']";
	public final static String Admin_Pricelist= "//li[contains(text(),'price')]";
	public final static String Admin_Search ="//button[text()='Search']";	
	public final static String Admin_Sytemmanagement = "//a[@id='lnkSystemMangement2']";
	public final static String Admin_Sytemmanagement_tax = "//h6[text()='Taxes Management']";
	public final static String Admin_Sytemmanagement_BillerMgm = "//a[@id='lnkBillersManagement2']";
	public final static String Admin_Sytemmanagement_Billers_Management = "//a[@id='lnkBillersManagement2']";
	public final static String Admin_Sytemmanagement_PaymentProviders_Management = "//a[@id='lnkVendor']";
	public final static String Admin_Update = "//button[@id='btnUpdate']";
	public final static String Admin_Product_EditLink="(//table[contains(@id,'tblProducts')]//tbody/tr[@role='row']/td/a)[1]";
	
	//Payment Providers management
	public final static String Admin_SystemMng_PaymentProviderMng_Page="//h6[text()='Payment Providers Management']";
	
	//Payment Method management
	public final static String Admin_SystemMng_PaymentMethodMng="//a[@id='lnkPaymentMethod']";
	public final static String Admin_SystemMng_PaymentMethodPage_Header="//h6[text()='Payment Methods Management']";
	public final static String Admin_SystemMng_PaymentMethodMng_EnglishName_Column="//th[contains(@aria-label,'English Name')]";
	public final static String Admin_SystemMng_PaymentMethodMng_ArabicName_Column="//th[contains(@aria-label,'Arabic Name')]";
	public final static String Admin_SystemMng_PaymentMethodMng_StartDate_Column="//th[contains(@aria-label,'Start Date')]";
	public final static String Admin_SystemMng_PaymentMethodMng_EndDate_Column="//th[contains(@aria-label,'End Date')]";
	public final static String Admin_SystemMng_PaymentMethodMng_Fees_Column="//th[contains(@aria-label,'Fees')]";
	public final static String Admin_SystemMng_PaymentMethodMng_Status_Column="//th[contains(@aria-label,'Status')]";
	public final static String Admin_SystemMng_PaymentMethodMng_FeesActivation_Column="//th[contains(@aria-label,'Fees Activation')]";
	public final static String Admin_SystemMng_PaymentMethodMng_PaymentProvider_Column="//th[contains(@aria-label,'Payment Provider')]";
	public final static String Admin_SystemMng_PaymentMethodMng_EditPaymentMethod_Column="//th[contains(@aria-label,'Edit Payment Method')]";
	public final static String Admin_SystemMng_PaymentMethodMng_FeesByInvoicebtn="//input[@value='AddNewPaymentMethodWithInvoiceAmountBasedFees']";
//	public final static String Admin_SystemMng_ApprovedBillersMng_FeesByInvoicebtn="//input[@value='AddNewPaymentMethodWithInvoiceAmountBasedFees']/parent::div/child::label";
	public final static String Admin_SystemMng_PaymentMethodMng_FeesByTransactionbtn="//input[@value='AddNewPaymentMethodWithTransactionsQuantityBasedFees']";
//	public final static String Admin_SystemMng_ApprovedBillersMng_FeesByTransactionbtn="//input[@value='AddNewPaymentMethodWithTransactionsQuantityBasedFees']/parent::div/child::label";
	public final static String Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTrans="//div[@id='switchModalFromAmountToTrans']//h5";
	public final static String Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTrans_Yesbtn="//div[@id='switchModalFromAmountToTrans']//button[@onclick='onCategoryTypeChange()']";
	public final static String Admin_SystemMng_PaymentMethodMng_SwitchBtwTransToInvoice="//div[@id='switchModalFromTransToAmount']//h5";
	public final static String Admin_SystemMng_PaymentMethodMng_SwitchBtwTransToInvoice_Yesbtn="//div[@id='switchModalFromTransToAmount']//button[@onclick='onCategoryTypeChange()']";
	public final static String Admin_SystemMng_PaymentMethodMng_AddInvoicebtn="//input[@id='addTransactionBasedFeesBtn']";
	public final static String Admin_SystemMng_PaymentMethodMng_AddTransactionbtn="//input[@id='addAmountBasedFeesBtn']";
	public final static String Admin_SystemMng_PaymentMethodMng_Invoice_FromAmnt="//input[@id='IA_FromAmount']";
	public final static String Admin_SystemMng_PaymentMethodMng_Invoice_ToAmnt="//input[@id='IA_ToAmount']";
	public final static String Admin_SystemMng_PaymentMethodMng_Invoice_FixedFeesCheckbox="//input[@id='IA_HasFixedFees']";
	public final static String Admin_SystemMng_PaymentMethodMng_Invoice_FixedFees_efield="//input[@id='IA_FixedFees']";
	public final static String Admin_SystemMng_PaymentMethodMng_Invoice_PercentageFees_efield="//input[@id='IA_PercentageFees']";
	public final static String Admin_SystemMng_PaymentMethodMng_Invoice_PercentageFeesCheckbox="//input[@id='IA_HasFixedFeesPercentage']";
	public final static String Admin_SystemMng_PaymentMethodMng_Invoice_Addbtn="//button[@id='addFeesBasedOnAmountBtn']";
	public final static String Admin_SystemMng_PaymentMethodMng_Transc_Fromtrans="//input[@id='TR_FromQuantity']";
	public final static String Admin_SystemMng_PaymentMethodMng_Transc_Totrans="//input[@id='TR_ToQuantity']";
	public final static String Admin_SystemMng_PaymentMethodMng_Transc_FixedFeesCheckbox="//input[@id='TR_HasFixedFees']";
	public final static String Admin_SystemMng_PaymentMethodMng_Transc_FixedFees_efield="//input[@id='TR_FixedFees']";
	public final static String Admin_SystemMng_PaymentMethodMng_Transc_PercentageFees_efield="//input[@id='TR_PercentageFees']";
	public final static String Admin_SystemMng_PaymentMethodMng_Transc_PercentageFeesCheckbox="//input[@id='TR_HasFixedFeesPercentage']";
	public final static String Admin_SystemMng_PaymentMethodMng_Transc_Addbtn="//button[@id='addFeesBasedOnTransactionBtn']";
	public final static String Admin_SystemMng_PaymentMethodMng_Transc_Error="//div[@id='alert-error']";
	
	//Payment Providers Management
	public final static String Admin_SystemMng_PaymentProvidersMng_EnglishName_Column="//table//th[contains(text(),'English Name')]";
	public final static String Admin_SystemMng_PaymentProvidersMng_ArabicName_Column="//table//th[contains(text(),'Arabic Name')]";
	public final static String Admin_SystemMng_PaymentProvidersMng_Contact_Column="//table//th[contains(text(),'Contact')]";
	public final static String Admin_SystemMng_PaymentProvidersMng_CrNumber_Column="//table//th[contains(text(),'CR Number')]";
	public final static String Admin_SystemMng_PaymentProvidersMng_Code_Column="//table//th[contains(text(),'Code')]";
	public final static String Admin_SystemMng_PaymentProvidersMng_PaymentProvider_efield="//input[@placeholder='Enter Payment Provider Name']";
	public final static String Admin_SystemMng_PaymentProvidersMng_Crnumber_efield="//input[@name='RegistrationNumber']";
	public final static String Admin_SystemMng_PaymentProvidersMng_Code_efield="//input[@name='Code']";
	public final static String Admin_SystemMng_PaymentProvidersMng_Search_btn="//button[text()='Search']";
	public final static String Admin_SystemMng_PaymentProvidersMng_paymentproviderName="//table[@id='tblPaymentProvider']//td[2]";


	

    //corporate clients management
//	public final static String Admin_CorporateClient_addbtn ="//a[@id='lnkActivateCompanies2']";
//	public final static String Admin_CorporateClient_crefield ="//input[@id='RegistrationNo']";
//	public final static String Admin_Corporatename_efield ="//input[@id='CompanyName']";
//	public final static String Admin_Corporateclient_srchbtn ="//button[@id='btnSearch']";
	
	
	public final static String Admin_SignUp_Btn ="//a[contains(@href,'BillerCompanySignUp')]";
	public final static String Admin_CompanyName_eField ="//input[@name='CompanyNameAr']";
	public final static String Admin_CompanyName_eField_error ="//span[@id='CompanyNameAr-error']";
	public final static String Admin_EconomySector_List ="//select[@name='EconomicSectorID']";
	public final static String Admin_EconomySector_List_error ="//span[@id='EconomicSectorID-error']";
	public final static String Admin_Country_List ="//select[@name='CountryID']";
	public final static String Admin_City_List ="//select[@name='CityID']";
	public final static String Admin_City_List_error ="//span[@id='CityID-error']";
	public final static String Admin_District_eField ="//input[@name='District']";
	public final static String Admin_Street_eField ="//input[@name='Street']";
	public final static String Admin_BuildNo_eField ="//input[@name='BuildingNo']";
	public final static String Admin_PostalCode_eField ="//input[@name='PostalCode']";
	public final static String Admin_MailBox_eField ="//input[@name='MailBox']";
	public final static String Admin_OfficNo_eField ="//input[@name='OfficeNo']";
	public final static String Admin_EmplyName_eField ="//input[@name='EmployeeName']";
	public final static String Admin_EmplyName_eField_error ="//span[@id='EmployeeName-error']";
	public final static String Admin_EmplyJobTitle_eField ="//input[@name='EmployeeJobTitle']";
	public final static String Admin_EmplyJobTitle_eField_error ="//span[@id='EmployeeJobTitle-error']";
	public final static String Admin_EmplyMobileNumber_eField ="//input[@name='EmployeeMobileNo']";
	public final static String Admin_EmplyMobileNumber_eField_error ="//span[@id='EmployeeMobileNo-error']";
	public final static String Admin_EmplyEmail_eField ="//input[@name='EmployeeEmail']";
	public final static String Admin_EmplyEmail_eField_error ="//span[@id='EmployeeEmail-error']";
	public final static String Admin_CustomerSupPhNo_eField ="//input[@name='CustomerSupportPhoneNo']";
	public final static String Admin_CustomerSupPhNo_eField_errror ="//span[@id='CustomerSupportPhoneNo-error']";
	public final static String Admin_IBANum_eField ="//input[@name='IBAN']";
	public final static String Admin_IBANum_eField_error ="//span[@id='IBAN-error']";
	public final static String Admin_IBANAttmnt_eField ="//input[@name='IBANAttachment']";
	public final static String Admin_BankCountryType_List ="//select[@name='BankAccountTypeId']";
	public final static String Admin_BankCountryType_List_error ="//span[@id='BankAccountTypeId-error']";
	public final static String Admin_BankCertAttmnt_eField ="//input[@name='BankCertificateAttachment']";
	public final static String Admin_CRNumber_eField ="//input[@name='RegistrationNo']";
	public final static String Admin_CRNumber_eField_error ="//span[@id='RegistrationNo-error']";
	public final static String Admin_RegiAttachment_eField ="//input[@name='RegistrationAttachment']";
	public final static String Admin_RegistDate_eField ="//input[@name='RegistrationDateHijri']";
	public final static String Admin_RegistDate_eField_error ="//span[@id='RegistrationDateHijri-error']";
	public final static String Admin_RegistDate_Issuedate ="(//tr[td[a[contains(@class,'calendars-today')]]]//following-sibling::td)[4]";
	public final static String Admin_ExperyDate_eField ="//input[@name='ExpiredRegistrationDateHijri']";
	public final static String Admin_ExperyDate_eField_error ="//span[@id='ExpiredRegistrationDateHijri-error']";
	public final static String Admin_Taxno_eField ="//input[@name='TaxNo']";
	public final static String Admin_Taxno_eField_error ="//span[@id='TaxNo-error']";
	public final static String Admin_IsTaxable_RadBtn ="//div[label[contains(text(),'Taxable')]]/input[@name='IsTaxable']";
	public final static String Admin_NoTaxable_RadBtn ="//div[label[contains(text(),'Non-Taxable')]]/input[@name='Taxable']";
	public final static String Admin_TaxRegisAttmnt_eField ="//input[@name='TaxRegistrationAttachment']";
	public final static String Admin_NationalAttmnt_eField ="//input[@name='NationalAddressProofAttachment']";
	public final static String Admin_FirstName_eField ="//input[@name='FirstNameAr']";
	public final static String Admin_FirstName_eField_error="//input[@name='FirstNameAr']";
	public final static String Admin_SurName_eField ="//input[@name='FatherNameAr']";
	public final static String Admin_SurName_eField_error ="//span[@id='FatherNameAr-error']";
	public final static String Admin_GradFatherName_eField ="//input[@name='GrandFatherNameAr']";
	public final static String Admin_GradFatherName_eField_error="//span[@id='GrandFatherNameAr-error']";
	public final static String Admin_LastName_eField ="//input[@name='LastNameAr']";
	public final static String Admin_LastName_eField_error="//span[@id='LastNameAr-error']";
	public final static String Admin_NationalID_eField ="//input[@name='NationalID']";
	public final static String Admin_NationalID_eField_error ="//span[@id='NationalID-error']";
	public final static String Admin_CommisionIdentyAttmnt_eField ="//input[@name='CommissionerIdentityAttachment']";
	public final static String Admin_MemDumAssoAttmnt_eField ="//input[@name='MemorandumOfAssociationAttachment']";
	public final static String Admin_AuthLterTemltAttmnt_eField ="//span[@id='lblAuthorizationLetterTemplateAttachment']";
	public final static String Admin_CommisionPhNo_eField ="//input[@name='CommissionerPhoneNo']";
	public final static String Admin_CommisionPhNo_eField_error ="//span[@id='CommissionerPhoneNo-error']";
	public final static String Admin_CommisionEmail_eField ="//input[@name='CommissionerEmail']";
	public final static String Admin_CommisionEmail_eField_error="//span[@id='CommissionerEmail-error']";
	public final static String Admin_UserID_eField ="//input[@name='Username']";
	public final static String Admin_UserID_eField_error ="//span[@id='Username-error']";
	public final static String Admin_Password_eField ="//input[@name='Password']";
	public final static String Admin_Password_eField_error ="//span[@id='Password-error']";
	public final static String Admin_ConfPawd_eField ="//input[@name='ConfirmPassword']";
	public final static String Admin_ConfPawd_eField_error ="//span[@id='ConfirmPassword-error']";
	public final static String Admin_Confirmation_CheckBox="//input[@name='Confirmation']";
	public final static String Admin_ReCatchBox_eField ="//iframe[@title='reCAPTCHA']";
	public final static String Admin_CatchBox_eField ="//span[@id='recaptcha-anchor']";
	public final static String Admin_SignUp_btn="//input[@id='btnSignUp']";
	public final static String Admin_Close_btn ="//button[text()='Close']";
	public final static String Admin_AttachetedImage_Link="//input[contains(@accept,'image') and (@name='IBANAttachment')]";
	public final static String Admin_RegisterComp_btn ="//h4[contains(text(),'Registration completed successfully')]";
	public final static String Admin_Link = "//a[text()='Biller Login']";
	public final static String Admin_NoAppBillerMangm="//a[@id='lnkUnderApprovedBillerList2']";
	public final static String Admin_NoAppBillerMangm_Header="//h6[text()='Billers Under Activation']";
	public final static String Admin_SystemMgm_SearchItem="//input[@name='Name']";
	public final static String Admin_SystemMgm_Searchbtn="//button[@id='btnSearch']";
	public final static String Admin_SystemMgm_BillerAliasName="//input[@name='BillerAliasNameAr']";
	public final static String Admin_SystemMgm_BillerActivateBtn="(//a[contains(@href,'BillerActivation')])[1]";
	public final static String Admin_PaymentMng_FreeActivationPopupMessage= "//h5[@id='active_fees']";
	public final static String Admin_SystemMng_PaymentMng_FreeActivationYesBtn="//button[@id='btnConfirmActivationFees']";
	public final static String Admin_SystemMng_PaymentMng_FreeActivationNoBtn="//button[@id='btnConfirmActivationFees']/parent::div//button[@type='button']";
	public final static String Admin_SystemMgm_TransferRemarkCheckbox="//input[@id='HasTransferRemarks']";
	public final static String Admin_SystemMgm_TransferRemarkCheckbox_Label="//label[@for='HasTransferRemarks']";
	public final static String Admin_SystemMgm_BillerAliasEnName="//input[@name='BillerAliasNameEn']";
	public final static String Admin_SystemMgm_IsBiller="(//input[@name='IsSuperBiller'])/preceding-sibling::input";
	public final static String Admin_SystemMgm_SubBiller_Checkbox="//input[@id='HasSubBillers' and @type='checkbox']";
	public final static String Admin_SystemMgm_IsBillerYesBtn="(//button[@id='btnConfirmSetAsSuperBiller'])";
	public final static String Admin_SystemMgm_SavesBtn="(//input[@id='btnSave'])";
	public final static String Admin_SystemMgm_SaveYesBtn="(//button[@id='btnConfirmSaveBillerInfo'])";
	public final static String Admin_SystemMgm_BillerCode="//input[@name='BillerCode']";
	public final static String Admin_SystemMgm_Biller_SuperBillerErrormsg="//span[@id='NewSuperBillerIdError']";
	public final static String Admin_SystemMgm_Biller_TransferErrormsg="//span[@id='TransferDuration-error']";
	public final static String Admin_SystemMgm_BillerTemBenificary="//input[@name='TempBenificaryName']";
	public final static String Admin_SystemMgm_Biller_Azmfees="//button[@id='btnAddOperationalFees']";
	public final static String Admin_SystemMgm_Biller_sadadfees="//input[@id='sadadFee']";
	public final static String Admin_SystemMgm_Biller_Azimfees="//input[@id='AzimFee']";
	public final static String Admin_SystemMgm_Biller_sadadfeesError="//span[@id='sadadFee-error']";
	public final static String Admin_SystemMgm_Biller_sadadfeestaxerror="//span[@id='BankRatio-error']";
	public final static String Admin_SystemMgm_Biller_Azmfeestaxerror="//span[@id='OperatorRatio-error']";
	public final static String Admin_SystemMgm_Biller_AzimfeesError="//span[@id='AzimFee-error']";
	public final static String Admin_SystemMgm_Biller_BenificaryError="//span[@id='BeneficiaryName-error']";
	public final static String Admin_SystemMgm_Biller_idError="//span[@id='BillerCode-error']";
	public final static String Admin_SystemMgm_Biller_Durationerror="//span[@id='TransferDuration-error']";
	public final static String Admin_SystemMgm_Biller_CrpArbError="//span[@id='BillerAliasNameAr-error']";
	public final static String Admin_SystemMgm_Biller_CrpEngError="//span[@id='BillerAliasNameEn-error']";
	public final static String Admin_SystemMgm_Biller_BillerCatgError="//span[@id='BillerCategoryId-error']";
	public final static String Admin_SystemMgm_BillerTransferDura="//input[@name='TransferDuration']";
	public final static String Admin_SystemMgm_BillerCategoryID="//select[@name='BillerCategoryId']";
	public final static String Admin_SystemMgm_ApprovalBtn="//button[contains(text(),'Approval')]";
	public final static String Admin_SystemMgm_ApprovalBtn_ConfirmAct="//h5[normalize-space(text())='Confirm Activation']";
	public final static String Admin_SystemMgm_NotApproval_AddMinimum_Invoice_Checkbox="//input[@name='HasMinimumInvoiceAmount' and @type='checkbox' and not(@checked)]";
	public final static String Admin_SystemMgm_ApprovalYesBtn="//button[@id='btnConfirmApproveBillerInfo']";
	public final static String Admin_SystemMgm_ApprovalCloseBtn="//button[text()='Close']";
	public final static String Admin_SystemMgm_RecordNotApproved="(//table[@id='dtBasicExample']//tbody/tr[@role='row'])";
	public final static String Admin_SystemMgm_ErrorMeesage="//div[@id='alert-error']";
	public final static String Admin_ApproveBillerMangm="//a[@id='lnkApprovedBillerList2']";
	public final static String Admin_ApproveBillerMangm_Header="//h6[text()='Approved Billers']";
	public final static String Admin_NotApproveBillerMangm_Benif_Error="//span[@id='BeneficiaryName-error']";
	public final static String Admin_NotApproveBillerMangm_Code_Error="//span[@id='BillerCode-error']";
	public final static String Admin_NotApproveBillerMangm_trns_Error="//span[@id='TransferDuration-error']";
	public final static String Admin_NotApproveBillerMangm_BillerArabic_Error="//span[@id='BillerAliasNameAr-error']";
	public final static String Admin_NotApproveBillerMangm_BillerEng_Error="//span[@id='BillerAliasNameEn-error']";
	public final static String Admin_NotApproveBillerMangm_BilCtg_Error="//span[@id='BillerCategoryId-error']";
	public final static String Admin_NotApproveBillerMangm_Alerrt_Error="//div[@id='alert-error']";
	public final static String Admin_RejectButton="//button[@id='btnReject']";
	public final static String Admin_RejectConfiMessage="//div[@id='modalRejectBillerInfo']//div[@class='modal-body text-center']/h6";
	public final static String Admin_RejectYesButton="//button[@id='btnConfirmRejectBillerInfo']";
	public final static String Admin_SystemMgm_RecordApproved="(//table[@id='dtApprovedBillers']//tbody/tr[@role='row'])";
	public final static String Admin_SystemMng_notApprovedBiller_SubBillerCheckBox="//input[@id='HasSubBillers']";
	public final static String Admin_SystemMng_notApprovedBiller_SubBillerCheckBox_Label="//label[@for='HasSubBillers']";
	public final static String Admin_SystemMgm_RecordUnclickable="//input[@class='switch unclickable']";
	public final static String Admin_SystemMgm_RecordNotFound="//td[text()='No data available in table']";
	public final static String Admin_SystemMgm_CorpName="(//table[@id='dtBasicExample']//tbody/tr[@role='row'])//td[2]";
	public final static String Admin_SystemMgm_CorpType="(//table[@id='dtBasicExample']//tbody/tr[@role='row'])//td[4]";
	public final static String Admin_SystemMgm_EmailConf="(//table[@id='dtBasicExample']//tbody/tr[@role='row'])//label[1]";
	public final static String Admin_SystemMgm_EyeIcon="((//table[@id='dtBasicExample']//tbody/tr[@role='row'])//a)[4]";
	public final static String Admin_SystemMgm_trackerEyeIcon="((//table[@id='dtApprovedBillers']//tbody/tr[@role='row'])//a)[4]";
	public final static String Admin_SystemMgm_EyeIcon_view="((//table[@id='dtBasicExample']//tbody/tr[@role='row'])//a)[4]";
	public final static String Admin_SystemMgm_EyeIconView="((//table[@id='dtApprovedBillers']//tbody/tr[@role='row'])[1]//a[@class='mx-1 action bg-accent'])[2]";
	public final static String Admin_ApproveMgn_ToggleBtn="(//table[@id='dtApprovedBillers']//tbody/tr[@role='row'])[1]//input[@class='switch']";
	public final static String Admin_ApprovedMgm_BillerName="(//table[@id='dtApprovedBillers']//tbody/tr[@role='row'])//td[2]";
	public final static String Admin_ApprovedMgm_BillerID="(//table[@id='dtApprovedBillers']//tbody/tr[@role='row'])//td[3]";
	public final static String Admin_ApprovedMgm_BillerType="(//table[@id='dtApprovedBillers']//tbody/tr[@role='row'])//td[4]";
	public final static String Admin_ApprovedMgm_EmailConf="(//table[@id='dtApprovedBillers']//tbody/tr[@role='row'])//label[1]";
	public final static String Admin_ApprovedMgm_EyeIcon="((//table[@id='dtApprovedBillers']//tbody/tr[@role='row'])//a)[4]";
	public final static String Admin_NotAppmMgm_IsTrackerBiller="(//input[@name='IsTrackedBiller'])[2]/preceding-sibling::input";
	public final static String Admin_NotAppmMgm_IsTrackerBillerYesbtn="(//button[@id='btnConfirmSetAsTrackedBiller'])";
	public final static String Admin_TrackerBillerMangm="//a[@id='lnkActiveTrackedBillers2']";
	public final static String Admin_TrackerBillerMangm_Header="//h6[text()='Tracked Billers']";
	public final static String Admin_TrackerBillerMangm_Record="(//table[@id='dtApprovedBillers']//tbody/tr[@role='row'])";
	public final static String Admin_TrackerBillerMangm_CorpName="(//table[@id='dtApprovedBillers']//tbody/tr[@role='row'])//td[2]";
	public final static String Admin_TrackerBillerMangm_CorpType="(//table[@id='dtApprovedBillers']//tbody/tr[@role='row'])//td[5]";
	public final static String Admin_TrackerBillerMangm_Corpotype="(//table[@id='dtApprovedBillers']//tbody/tr[@role='row'])//td[5]";
	public final static String Admin_TrackerBillerMangm_EmailConf="(//table[@id='dtApprovedBillers']//tbody/tr[@role='row'])//label[1]";
	public final static String Admin_TrackerBillerMangm_EyeIcon="((//table[@id='dtApprovedBillers']//tbody/tr[@role='row'])//a)[4]";
	public final static String Admin_TrackerBillerMangm_ToggleBtn="(//table[@id='dtApprovedBillers']//tbody/tr[@role='row'])[1]//input[@class='switch']";
	public final static String Admin_TrackerBillerMangm_SelectNewSuper="//select[@id='NewSuperBillerId']";
	public final static String Admin_TrackerBillerMangm_IndiviClenteID="((//table[@id='dtApprovedBillers']//tbody/tr[@role='row'])[1]//a[contains(@href,'BillerClients')])[1]";
	public final static String Admin_TrackerBillerMangm_CopoClientID="((//table[@id='dtApprovedBillers']//tbody/tr[@role='row'])[1]//a[contains(@href,'BillerClients')])[2]";
	public final static String Admin_IndividualClient_RowCount="(//table[@id='tblBillerClients']//tbody/tr[@role='row'])";
	public final static String Admin_ExportBille_InvoiceID="(//table[@id='tblBillList']//tbody/tr[@role='row'])[1]//a";
	//public final static String Admin_ExportBille_InvoiceID="((//table[@id='tblBillList']//tbody/tr[@role='row'])[1]//td/a)[1]";
	public final static String Admin_MyBill_Button="//a[text()='My Bills']";
	public final static String Admin_MyBill_BillNumberField="//input[@id='txtBillNo']";
	public final static String Admin_MyBill_ViewButton="//button[@id='btnViewInvoice']";
	public final static String Admin_MyBill_InvalidNumber="//span[@id='BillNo-invalid']";
	public final static String Admin_MyBill_BillNumber="//label[contains(text(),'Bill Number')]/h6";
	public final static String Admin_MyBill_BillStatus="//label[contains(text(),'Invoice Status:')]/h6";
	public final static String Admin_MyBill_DetailsHeader="//h3[contains(text(),'Invoice Details')]";
	public final static String MyBills_Sadad_PaymentMethod="//img[contains(@src,'Sadad.png')]";
	public final static String MyBills_Mada_PaymentMethod="//img[contains(@src,'Mada.png')]";
	public final static String MyBills_Visa_PaymentMethod="//img[contains(@src,'Visa.png')]";
	public final static String MyBills_MasterCard_PaymentMethod="//img[contains(@src,'MasterCard.png')]";
	public final static String MyBills_Paybtn="//a[@id='PayModelBtn']";
	public final static String MyBills_Clientpopup_Header="//div[@id='modalConfirmLogin']//h6";
	public final static String MyBills_Invalid="//span[@id='BillNo-invalid']";
	public final static String MyBills_Clientpopup_LoginBtn="//a[contains(@href,'/Customer/Login')]";
	public final static String MyBills_Client_ClientName="//a[@href='#']/span[contains(text(),'test')]";
	
    //Admin Reports Super biller reports
//	public final static String Admin_Reports_superbiller="//h6[text()='Super Billers Report']";
//	public final static String Admin_ReportsSuperbiller="//a[@id='lnkAggregatorSuperBillersReport2']";
//	public final static String Admin_Reports="//a[@id='lnkMyReports']";
//	public final static String Admin_ReportsAdmin="//a[@id='lnkSystemMangementSub22']";
//	public final static String Admin_BillerNameDropdwn="//span[@id='select2-SuperBillers-container']";
//	public final static String Admin_TrackedBillerDropdwn="//span[@id='select2-TrackedBillers-container']";
//	public final static String Admin_GenerateReportBtn="//button[@id='btnSearch']";
    //Admin Reports Outside paid edaat paymnets  reports
		public final static String Admin_ReportsOutsidePaid="//a[@id='lnkBillCashReport2']";
		public final static String Admin_ReportsFromCalender="//input[@id='FromDate']";
		public final static String Admin_ReportsFromYear="(//select[@class='calendars-month-year'])[2]";
		public final static String Admin_ReportsFromMonth="(//select[@class='calendars-month-year'])[1]";
		public final static String Admin_ReportsToCalender="//input[@id='ToDate']";
		public final static String Admin_ReportBillerName="//span[@id='select2-BillerId-container']";
		public final static String Admin_GenerateReport="//button[@id='btnSearch']";
	//Admin Reports Biller transaction report
		public final static String Admin_BillerTransaction="//a[@id='lnkBillTransReport2']";
		public final static String Admin_Ticketsize="//a[@id='lnkAggregatorTicketSizeReport2']";
		public final static String Admin_FromMonth="//select[@id='FromMonth']";
		public final static String Admin_FromYear="//select[@id='FromYear']";
		public final static String Admin_ToMonth="//select[@id='ToMonth']";
		public final static String Admin_ToYear="//select[@id='ToYear']";
		public final static String Admin_clientType="//select[@id='ClientTypeId']";
		public final static String Admin_MainBiller="//span[@id='select2-BillerId-container']";
		public final static String Admin_Generatereport="//button[@id='btnSearch']";
		public final static String Admin_ReportImage="//img[@class='A67037c61e82b4cb580e95868d1093d6924']";
		public final static String Admin_ClickTicketsize="//select[@id='TicketSizeId']";
		public final static String Admin_ReportVerify="//div[text()='Billers Transactions']";
		public final static String Admin_TicketReportVerify="//div[text()='Ticket Size Report']";
		public final static String Admin_ReportImageVerify="//img[@usemap='#P8cfea8274cd542b0afde078162ea1e29_1_Map7iT0']";
        public final static String Admin_ReportPaymentMethod="//span[@id='select2-PaymentMethod-container']";
		public final static String Admin_ReportClientTypePaymentMethod="//select[@id='PaymentMethod']";
		public final static String Admin_RecievableReports_selectAll_checkbox="//label[@for='select-all-chbox']";
		public final static String Admin_RecievableReports_pagination_dropdown="//select[@id='ddlPageLengthShown']";
		public final static String Admin_RecievableReports_pagination_options="//select[@id='ddlPageLengthShown']/option";

	public final static String Admin_ClientTypeReporttext="//div[text()='Clients Type Report']";
	
       public final static String Admin_ImportclientsData_IndividualDataForm ="//a[@href='/Content/Files/ClientsData-Template.xlsx']";
       
     //
	//Admin System management Individual client
//         public final static String AdminSystem_Individual="//h6[text()='Individual Clients Management']";
//	     public final static String AdminSystem_Individual_link="//a[@id='lnkActivateClients2']";
//	     public final static String AdminSystem_IndividualClient_Name="//input[@id='CustomerName']";
//	     public final static String AdminSystem_Individual_national="//input[@id='NationalID']";
//	     public final static String AdminSystem_Individual_Search="//button[@id='btnSearch']";
//	     public final static String AdminSystem_Individual_verify="//h6[@class='justify-content-start align-middle align-self-center mb-3']";
	     public final static String AdminSystem_IndividualClientStatus="//select[@id='Types']";
	  
//Admin Usermanagement userlist
	public final static String Admin_Usermanagement_Userlist = "//h6[text()='Users List']";
	public final static String Admin_Menu_UserManagement ="//a[text()='Groups Management']";
	public final static String Admin_Menu_UserList ="//a[text()='Users List']";
	public final static String Admin_UserList_AddUserBt ="//button[@id='btnAddUser']";
	public final static String Admin_UserListAdd_NameInput ="//input[@id='NameAR']";
	public final static String Admin_UserListAdd_EmailInput ="//input[@id='EMail']";
	public final static String Admin_UserListAdd_PhoneInput ="//input[@id='Phone']";
	public final static String Admin_UserListAdd_GroupCheckBox ="//div[@id='GroupsListDiv']//input";
	public final static String Admin_UserListAdd_GroupCheckbox ="(//div[@id='GroupsListDiv']//input)[1]";
	public final static String Admin_UserListAdd_AddUserBtPop ="//button[@id='btnAddUser']";
	public final static String Admin_UserListSearch_NameBt ="//input[@id='Name']";
	public final static String Admin_UserListSearch_EmailBt ="//input[@id='Email']";
	public final static String Admin_UserListSearch_SaerchBt ="//button[@id='btnSearch']";
	public final static String Admin_UserList_DeleteBtn ="//a[contains(@id,'btndelete')]";	
	public final static String Admin_UserList_ConfirmDeletePop="//h5[@id='ConfirmDeleteMessage']";
	public final static String Admin_UserList_YesConfBtn ="//button[@id='btnConfirmDelete']";
	public final static String Admin_Product_NoData="//td[contains(text(),'No data available in table')]";
	public final static String Admin_UsserList_NoData="//td[contains(text(),'No data available in table')]";
	public final static String Admin_UserList_UserName="(//table[@id='tblUsers']//tbody/tr[@role='row'])[1]//a/span";
	public final static String Admin_UserList_UserEmail="((//table[@id='tblUsers']//tbody/tr[@role='row'])//td[3])[1]";
	public final static String Admin_UserList_dltcheck="//label[text()='Deleted Users']";
	public final static String Admin_UserList_dltVerify="//div[@id='tblUsers_wrapper']//tr//td[3]";
	public final static String Admin_UserMgm_UsersList_Editbtn="(//a[@onclick='Update(this)'])[1]";
	public final static String Admin_UserMgm_UsersList_Savechange="//button[@id='btnUpdate']";
	public final static String Admin_UserMgm_UsersList_Deletebtn="(//a[@onclick='Delete(this)'])[1]";
	public final static String Admin_UserMgm_UsersList_YesDeletebtn="//button[@id='btnConfirmDelete']";
	public final static String Admin_UserMgm_UsersList_DeletedCheckbox="//label[@for='Deleted']";
	public final static String Admin_UserList_Email="//table[@id='tblUsers']//tbody//td[3]";
	public final static String Admin_UserList_UserNameClick="//a[@class='mx-1']";
	public final static String Admin_UserList_ViewUserInfoNameTxt="//h6[text()='View User Info']";
	public final static String Admin_UserList_NameErrorMsg="//span[@id='NameAR-error']";
	public final static String Admin_UserList_NameErrorMessg="//span[text()='Please use numbers and letters only']";
	public final static String Admin_UserList_EmailErrorMsg="//span[@id='EMail-error']";
	public final static String Admin_UserList_EmailExistsErrorMsg="//span[@id='emaileCustomError']";
	public final static String Admin_UserList_PhonenoErrorMsg="//span[@id='Phone-error']";
	public final static String Admin_UserList_GroupErrorMsg="//span[@id='groupError']";
	
		//Client Forgot Password 
    public final static String Admin_forgotpwd_Btn = "//a[text()='Forgot password?']";
    public final static String Admin_forgotpwd_verify = "//h5[text()='Reset your password']";
    public final static String Admin_Username_efield = "//input[@id='UserName']";
    public final static String Admin_Username_sendbtn = "//button[@id='btnSendRequest']";
    public final static String Admin_Username_confirm_verify = "//h5[text()='Confirm']";
    public final static String Admin_Username_close = "//button[text()='Close']";
	
//    
// System management sub biller
//    public final static String Admin_system_sublink="//a[@id='lnkSubBillerList2']";
//    public final static String Admin_system_subBlr_verif="//h6[text()='Sub Billers Management']";
//    public final static String Admin_system_subBlr_Edit="(//div[@id='dtCompanies_wrapper']//tr//td[9])[1]";
//    public final static String Admin_system_subBlr_Edit_verif="//h6[text()='General Info']";

     //Admin User Management Groups Management
    public final static String Admin_GroupMgm_Header="//h6[text()='Groups Management']";
	public final static String Admin_GroupMgm_SearchGrpName="//input[@id='groupName']";
	public final static String Admin_GroupMgm_SearchCode="//input[@name='Code']";
	public final static String Admin_GroupMgm_SearchButton="//button[text()='Search']";
	public final static String Admin_GroupMgm_AddGrpBtn="//button[@id='btnAddGroup']";
	public final static String Admin_AddGroupMgm_ArabicName="//input[@name='NameAr']";
	public final static String Admin_AddGroupMgm_Name="//input[@name='Name']";
	public final static String Admin_AddGroupMgm_Description="//input[@name='Description']";
	public final static String Admin_AddGroupMgm_GroupCode="//input[@name='GroupCode']";
	public final static String Admin_AddGroupMgm_AddBtn="//button[@id='btnAdd']";
	public final static String Admin_AddGroupMgm_TwoFactorAuthentication="//label[@for='HasTwoFactorAuth']";
	public final static String Admin_GroupMgm_UsersBtn="//button[@onclick='GroupUsers(this);']";
	public final static String Admin_GroupMgm_ViewUser="(//button[@onclick='GroupUsers(this);'])[1]";
	public final static String Admin_GroupMgm_Userspopup="//h6[@id='exampleModalLongTitle']";
	public final static String Admin_SearchGroupMgm_GrpName="(//table[@id='tblGroups']//tbody/tr[@role='row'])[1]//td[1]/a";
	public final static String Admin_SearchGroupMgm_Code="(//table[@id='tblGroups']//tbody/tr[@role='row'])[1]//td[2]";
	public final static String Admin_UserManagement="//a[contains(@id,'lnkUserAccount2')]";
	public final static String Admin_GropManagment="(//a[text()='Groups Management'])[last()]";
	public final static String Admin_SearchGroupMgm_EditIcon="(//table[@id='tblGroups']//tbody/tr[@role='row'])[1]//td[3]/button[contains(@id,'btnUpdatePermission')]";
	public final static String Admin_EditGroup_Receivable="//input[@id='2Receivables']";
	public final static String Admin_EditGroup_UpdateBtn="//button[@id='btnUpdate']";
	public final static String Admin_SearchGroupMgm_DeleteBtn="//tbody/tr/td[7]/a";
	public final static String Admin_SearchGroupMgm_YesDeleteBtn="//button[@id='btnConfirmDelete']";
	public final static String Admin_SearchGroupMgm_Nodata="//td[text()='No data available in table']";
	public final static String Admin_SearchGroupMgm_PermissuionPOp="//h6[@id='exampleModalLongTitle']";
	public final static String Admin_Usermng_groups="//div[@id='GroupsListDiv']//label[@class='custom-control-label']";
	public final static String Admin_Usermng_nodata="//td[text()='No data available in table']";
	public final static String Admin_Usermng_viewgrp="//h6[text()='View Group']";
	public final static String Admin_Usermng_viewClose="//button[text()='Close']";
	public final static String Admin_Usermng_Verifygroup="//td[text()='No data available in table']";
	public final static String Admin_GrpMgm_GrpPermissionbtn="(//button[@onclick='UpdatePermission(this);'])[1]";
	public final static String Admin_GrpMgm_GrpEditbtn="//a[@onclick='UpdateTwoFactor(this)']";
	public final static String Admin_GrpMgm_DistributionPermission="(//label[@class='custom-control-label'])[1]";
	public final static String Admin_GrpMgm_ReceivablesPermission="(//label[@class='custom-control-label'])[23]";
	public final static String Admin_GrpMgm_SavePermission="//button[@id='btnUpdate']";
	public final static String Admin_GrpMgm_SaveChangesbtn="//button[@id='updateButton']";
	public final static String Admin_GrpMgm_ViewPermission="(//button[@onclick='ViewPermission(this);'])[1]";
	public final static String Admin_GrpMgm_ViewDistributionPermission="//a[@id='1Distribution']";
	public final static String Admin_GrpMgm_ViewReceivablesPermission="//a[@href='#_Receivables']";
	public final static String Admin_GrpMgm_GrpCodeError="//span[@id='GroupCode-error']";
	public final static String Admin_GrpMgm_GrpNameEngError="//span[@id='Name-error']";
	public final static String Admin_GrpMgm_GrpNameArbError="//span[@id='NameAr-error']";
	public final static String Admin_GrpMgm_GrpNameEngErrorMsg="//span[@id='spn-NameError']";
	public final static String Admin_GrpMgm_GrpNameEngInvErrorMsg="//span[text()='يجب ادخال حروف  انجليزية مناسبة ']";
	public final static String Admin_GrpMgm_GrpNameArbErrorMsg="//span[@id='spn-NameArError']";
	public final static String Admin_GrpMgm_GrpNameArbInvErrorMsg="//span[text()='يجب ادخال حروف   عربية مناسبة ']";
	public final static String Admin_GrpMgm_GrpCodeErrorMsg="//span[@id='spn-CodeError']";
	public final static String Admin_Usermng_eyebtn="(//td/button[@onclick='ViewPermission(this);'])[1]";
	public final static String Admin_Usermng_viewpermision="//h6[text()='View Group Permission']";
	public final static String Admin_UserList_statustg="(//label)[4]";
	public final static String Admin_SearchGroupMgm_SubjectTwoAuthenticateCheck="//input[@id='HasTwoFactorAuth']";
	public final static String Admin_SearchGroupMgm_SendSMSValue="//label[@for='SendTwoFactorAuthBySMS']";
	public final static String Admin_SearchGroupMgm_SendEmailValue="//label[@for='SendTwoFactorAuthByEmail']";
	public final static String Admin_AddGroupMgm_Hour="//input[@id='TwoFactorAuthValidForPerHour']";
	
	//Admin Reports Biller Monitoring report
	 public final static String Admin_BillerMonitoring="//a[@id='lnkBillerMonitoringReport2']";
	 public final static String Admin_Reorts_monitor_Fromd="//input[@id='FromDate']";
	 public final static String Admin_Reorts_monitor_Fromyear="//select[ @title='Change the year']";
	 public final static String Admin_Reorts_monitor_Fromon="//select[@title='Change the month']"; 
	 public final static String Admin_Reorts_monitor_Tod="//input[@id='ToDate']";
	 public final static String Admin_Reorts_monitor_Toyear="//select[@title='Change the year']";
	 public final static String Admin_Reorts_monitor_omon="//select[@title='Change the month']";
	 public final static String Admin_Reorts_monitor_srcbtn="//button[@id='btnSearch']";
	 public final static String Admin_Reorts_monitor_BillerName="//span[@role='textbox']";	
	 public final static String Admin_Reorts_monitor_verify="//div[text()='ENGLISH BILLER']";
	 public final static String Admin_Report_PaymentID="//input[@id='ReportViewer1_ctl04_ctl03_txtValue']";
	 public final static String Admin_Report_VerifyPID="//input[@id='ReportViewer1_ctl04_ctl00']";
	 public final static String Admin_Report_VerifyBillerMonitoringReport="//div[text()='Biller Transactions Monitoring']";
	 public final static String Admin_Report_VerifyClientTypeReport="//div[text()='Clients Type Report']";
	 
	//Admin Settings Bills Cancellation
	 public final static String Admin_BillsCancellation = "//a[@id='lnkCancelBills2']";				
 	 public final static String Admin_PaidOutsideEdaatBills = "//a[@id='lnkPayCashBills2']";
	 public final static String Admin_AttachExcel = "//input[@id='ExcelFile']";				
	 public final static String Admin_ProcessBtn = "//button[@id='btnProcessingExcelFile']";				
	 public final static String Admin_SuccessfulMsg = "//span[@id='spnUnderProcessing']";				
					
	 
	//Admin Reports Corporate Billers Reports
	 public final static String Admin_Corporate_Billers_Report="//a[@id='lnkAggregatorBillersReport2']";
	 public final static String Admin_Corporate_verifyReport="//div[text()='Corporate Billers List']";
	 public final static String Admin_Corporate_Report="//iframe";
	 public final static String Admin_Reports_TotalInvoicePaid="//div[text()='test2023']/parent::td/following-sibling::td[2]";
	 public final static String Admin_Reports_OperationFees="//div[text()='test2023']/parent::td/following-sibling::td[5]";
	 public final static String Admin_SubBiller_Report="//a[@id='lnkSubBillersInforAggregatorReport']";
	 public final static String Admin_IndividualClient_Report="//a[@id='lnkIndividualClientsReport2']";
	 public final static String Admin_CorporateClient_Report="//a[@id='lnkCompanyClientsReport2']";
	 public final static String Admin_OutsideEdaatPayment_Report="//a[@id='lnkBillCashReport2']";
	 public final static String Admin_BillerTransaction_Report="//a[@id='lnkBillTransReport2']";
	 public final static String Admin_ClientType_Report="//a[@id='lnkAggregatorCustomersTypeReport2']";
	 public final static String Admin_TicketSize_Report="//a[@id='lnkAggregatorTicketSizeReport2']";
	 public final static String Admin_PaymentTransaction_Report="//a[@id='lnkPaymentsTransactionsReport2']";
	 public final static String Admin_BillerMonitoring_Report="//a[@id='lnkBillerMonitoringReport2']";
	 public final static String Admin_ClientAccount_Report="//a[@id='lnkCustomerAccount2']";
	 public final static String Admin_Generate_ReportBTn="//button[@id='btnSearch']";
	 public final static String Admin_Search_ReportBTn="//button[@class='btn btn-primary']";
	 public final static String Admin_MandatoryFeild_ReportErrMsg="//span[@id='BillerId-error']";
	 public final static String Admin_Report_FromMonthErrMsg="//span[@id='FromMonth-error']";
	 public final static String Admin_Report_FromDateErrMsg="//span[@id='FromDate-error']";
	 public final static String Admin_Report_FromYearErrMsg="//span[@id='FromYear-error']";
	 public final static String Admin_Report_ToMonthErrMsg="//span[@id='ToMonth-error']";
	 public final static String Admin_Report_ToYearErrMsg="//span[@id='ToYear-error']";
	 public final static String Admin_Report_ClientTypeErrMsg="//span[@id='ClientTypeId-error']";
	 public final static String Admin_Report_ClientIDErrMsg="//span[@id='ClientId-error']";
	 public final static String Admin_Report_TicketSizeErrMsg="//span[@id='TicketSizeId-error']";
	 public final static String Admin_Report_PaymentTransactionErrMsg="//span[@id='BillerId-error']";
		
	 //Admin Reports Blocked Individual Client Reports
	 public final static String Admin_Rport_Blocked_IndivReport="//a[@id='lnkBlockedSystemCustomersReport2']";
	 public final static String Admin_Rport_Blocked_IndivReportframe="//iframe";
	 public final static String Admin_Rport_Blocked_IndivReportverify="//div[contains(text(),'Blocked Individual Clients')]";
	 
	 //Admin Reports Individual Client Reports
	 public final static String Admin_IndivReport="//a[@id='lnkIndividualClientsReport2']";
	 public final static String Admin_Reorts_Indiv_BillerName="//span[@role='textbox']";	
	 public final static String Admin_Reorts_Indiv_NationalityName="//select[@id='NationalityId']";
	 public final static String Admin_Reorts_Indiv_srcbtn="//button[@id='btnSearch']";
	
    public static final String Admin_TermsManagement_Editbtn = "(//button[@onclick='Update(this);'])[1]";
	public static final String Admin_TermsManagement_updatetxt = "//h6[@class='modal-title']";	

   
  
    public final static String Admin_MyAccount_PushNotificationstoggelBTN="(//input[@type='checkbox'])[1]";
	
	
	public final static String Biller_GroupMgm_SearchGrpName="//input[@id='groupName']";
	public final static String Biller_GroupMgm_Header="//h6[text()='Groups Management']";
	//public final static String Biller_GroupMgm_SearchGrpName="//input[@id='groupName']";
	public final static String Biller_GroupMgm_SearchCode="//input[@name='Code']";
	public final static String Biller_GroupMgm_SearchButton="//button[text()='Search']";
	public final static String Biller_GroupMgm_AddGrpBtn="//button[@id='btnAddGroup']";
	public final static String Biller_AddGroupMgm_ArabicName="//input[@name='NameAr']";
	public final static String Biller_AddGroupMgm_Name="//input[@name='Name']";
	public final static String Biller_AddGroupMgm_Description="//input[@name='Description']";
	public final static String Biller_AddGroupMgm_GroupCode="//input[@name='GroupCode']";
	public final static String Biller_AddGroupMgm_AddBtn="//button[@id='btnAdd']";
	public final static String Biller_GroupMgm_UsersBtn="//button[@onclick='GroupUsers(this);']";
	public final static String Biller_GroupMgm_Userspopup="//h6[@id='exampleModalLongTitle']";
	public final static String Biller_SearchGroupMgm_GrpName="(//table[@id='tblGroups']//tbody/tr[@role='row'])[1]//td[1]/a";
	public final static String Biller_SearchGroupMgm_Code="(//table[@id='tblGroups']//tbody/tr[@role='row'])[1]//td[2]";
	public final static String Biller_UserManagement="//a[contains(@id,'lnkUserAccount2')]";
	public final static String Biller_GropManagment="(//a[text()='Groups Management'])[last()]";
	public final static String Biller_SearchGroupMgm_EditIcon="(//table[@id='tblGroups']//tbody/tr[@role='row'])[1]//td[3]/button[contains(@id,'btnUpdatePermission')]";
	public final static String Biller_EditGroup_Receivable="//input[@id='2Receivables']";
	public final static String Biller_EditGroup_UpdateBtn="//button[@id='btnUpdate']";
	public final static String Biller_SearchGroupMgm_DeleteBtn="(//table[@id='tblGroups']//tbody/tr[@role='row'])[1]//td[7]/a";
	public final static String Biller_SearchGroupMgm_YesDeleteBtn="//button[@id='btnConfirmDelete']";
	public final static String Biller_SearchGroupMgm_Nodata="//td[text()='No data available in table']";
	public final static String Biller_SearchGroupMgm_PermissuionPOp="//h6[@id='exampleModalLongTitle']";
	public final static String Biller_Userlist_groups="//div[@id='GroupsListDiv']//label[@class='custom-control-label']";
	
	public final static String Admin_TaxSearch ="//input[@id='TaxName']";
	public final static String Admin_taxTable ="//table[@id='tblTaxes']";
	public final static String Admin_SubBiller_CorporatePage="//h6[text()='Corporate Sub Billers']";
	public final static String Admin_SubBiller_BillerName="//input[@id='Name']";
	public final static String Admin_SubBiller_CRnumber="//input[@id='RegistrationNumber']";
	public final static String Admin_SubBiller_SearchBtn="//button[text()='Search']";
    //admin System management Individual client management
	public final static String AdminSystem_Individual="//h6[text()='Individual Clients']";
	public final static String AdminSystem_Individual_link="//a[@id='lnkActivateClients2']";
	public final static String AdminSystem_IndividualClient_Name="//input[@id='CustomerName']";
	public final static String AdminSystem_Individual_national="//input[@id='NationalID']";
	public final static String Admin_System_Individual_clientstatus="//Select[@id='Types']";
	public final static String AdminSystem_Individual_Search="//button[@id='btnSearch']";
	public final static String AdminSystem_Individual_grid="//table[@id='dtCustomers']";
 //public final static String AdminSystem_Individual_verify="//h6[@class='justify-content-start align-middle align-self-center mb-3']";
//	public final static String Admin_System_Individual_clientstatus="//Select[@id='Types']";
	public final static String Admin_SymIndividua_statustoggle="//span[@class='switch switch-sm']";
    public final static String Admin_SymIndividual_statustoggletextarea ="//textarea[@id='submit_activationNotesText']";
    public final static String Admin_SymIndividual_Statustoggleyesbtn ="//button[text()='Yes' and @id='submit_btnConfirmActivation']";
    public final static String Admin_SymIndividual_statustoggleconformactivation ="//button[@id='submit_btnConfirmActivation']";
   
    public final static String Admin_SymIndividua_RequestRecordBtn ="//button[@class='btn']";
    public final static String Admin_SymIndividual_Historypage ="//h5[@class='modal-title']";	
	public final static String AdminNationalIDVerify="//tbody//td[4]";

	public final static String AdminSystem_Individual_verify="//a[@href='/ClientManagement/ClientDetails?ClientId=196267']";
	public final static String AdminSystem_Individuaul_SettingsBTN="//a[@class='mx-1 action bg-accent']";
	public final static String AdminSystem_Individuaul_SuspendradioBTN="//input[@id='AccountStatusId_1100']";
	public final static String AdminSystem_Individuaul_SettingConirmBTN="//button[@id='btnConfirmSetting']";
	public final static String AdminSystem_Individuaul_SuspendPermradioBTN="//input[@id='AccountStatusId_1101']";
	public final static String AdminSystem_Individuaul_SuspendReason="//span[@role='combobox']";
	public final static String AdminSystem_Individuaul_SuspendReason_Error="//span[@id='Reason-invalid']";
	public final static String AdminSystem_Coporate_SuspendReason_Error="//span[@id='Reason-invalid']";

	public final static String AdminSystem_Individuaul_Accountstatuserrormsg="//span[text()='Please choose a proper action']";
	public final static String AdminSystem_Individuaul_SuspendReasonerrormsg="//span[@id='Reason-invalid']";
	public final static String AdminSystem_Individuaul_cancelbtn="//button[@id='btnCancelSetting']";
	
	
	//public final static String AdminSystem_Individual_verify="//h6[@class='justify-content-start align-middle align-self-center mb-3']";
	public final static String AdminSystem_Individual_Clientstatus="//select[@id='Types']";
	public final static String AdminSystem_Individual_Clientstatus_Verify="(//table[@id='dtCustomers']//td[7])[1]";
	
	
	 //Admin Reports Super biller reports
	
    //Admin Reports Super biller reports
	public final static String Admin_Reports_superbiller="//h6[text()='Super Billers Report']";
    public final static String Admin_ReportsSuperbiller="//a[@id='lnkAggregatorSuperBillersReport2']";
    public final static String Admin_Reports="//a[@id='lnkMyReports']";
    public final static String Admin_ReportsAdmin="//a[@id='lnkSystemMangementSub22']";
    public final static String Admin_BillerNameDropdwn="//span[@id='select2-SuperBillers-container']";
    public final static String Admin_TrackedBillerDropdwn="//span[@id='select2-TrackedBillers-container']";
    public final static String Admin_GenerateReportBtn="//button[@id='btnSearch']";
    public final static String Admin_IndClientReport="//div[text()='Individual Clients List ']";
    public final static String Admin_SuperBillerReport="//div[text()='Super Billers List']";
//Admin Biller Categories Management
  
    
    public final static String Admin_SystmMng_BillerCategoryEditBtn="(//a[@onclick='EditBillerCategory(this)'])[1]";
    public final static String Admin_SystmMng_BillerCategoryGrid="//table[@id='tblBillerCategoriesList']";
    public final static String Admin_SystmMng_BillerEditCategoryARfield="//input[@id='CategoryNameAR']";
    public final static String Admin_SystmMng_BillerEditCategoryENfield="//input[@id='CategoryNameEN']";
  
 public final static String Admin_SystmMng_BillerEditCategorySaveBtn="//button[@type='submit']";
 //Admin Reports Receivable Individual Client Report
    
    public final static String Admin_individual_Report=" //a[@id='lnkBillerIndividualClientsReport']";
    public final static String Admin_individualclient_List="//div[text()='Individual Clients List']";
    public final static String Admin_ReportsMenu="//a[@id='lnkMyReports']";
    public final static String Admin_Recevible_ReportMenu="//a[@id='refReceiptsSub22']";
    public final static String Admin_Recevible_Reportframe="//iframe";
    public final static String Admin_Recevible_Report_IndVerify="//div[contains(text(),'Individual Clients List')]";

    //public final static String AdminSystem_Individual_verify="//h6[@class='justify-content-start align-middle align-self-center mb-3']";
	public final static String Biller_UserList_savebtn ="//button[@id='btnUpdate']";
	public final static String Biller_UserList_UserName="(//table[@id='tblUsers']//tbody/tr[@role='row'])[1]//a/span";
	public final static String Biller_UserList_IsDeletChekckbox="//input[@id='Deleted']";
	public final static String Biller_Invoice_ComCustIDList="//select[@name='CompanyId']/following-sibling::span//span[@class='select2-selection__arrow']";
	public final static String Biller_Invoice_NextPrevLink="(//li[a[text()='Next']]/preceding-sibling::li)[last()]/a";
	public final static String Biller_ExportBille_InvoiceID="(//table[@id='tblBillList']//tbody/tr[@role='row'])[1]//a";
	public final static String Biller_Invoice_CustIDList="//select[@name='CustomerId']/following-sibling::span//span[@class='select2-selection__arrow']";
	public final static String Biller_Invoice_subIndividualRdv="//input[@id='rdSubbillerIndividual']";
	public final static String Biller_Invoice_Createandsave="//button[@id='btnCreateInvoice']";
	public final static String Biller_Invoice_installmentButton="//button[@id='btnCreateRepeatInvoice']";
	public final static String Biller_Invoice_SaveINSTALButton="//button[@id='btnUpdateBill']";
	public final static String Biller_Invoice_ExportinastallButton="//button[text()='Export']";
	public final static String Biller_Invoice_pymtEle="//h6[text()='Payments invoices']";
	public final static String Biller_Receivables_Template="//select[@id='InvoiceTemplateId']";
	public final static String Biller_Receivables_Invoiceduedate="//input[@id='IssueDate']";
	public final static String Biller_Receivables_Invoiceduedate_month="//select[@title='Change the month']";
	public final static String Biller_Receivables_Invoiceduedate_year="//select[@title='Change the year']";
	public final static String Biller_Receivables_CreateExport="//button[@id='btnExportInvoice']";
	public final static String Biller_Receivables_billnumber="(//td[text()='client test client test']//ancestor::tr)[last()]//span";

	//Client Module
	 public final static String Biller_nonapproved_Afteradd="(//div[@class='card-body table-responsive']//tbody/tr[@role='row'])";
	 public final static String AppBiller_Name="//td[2]";
	 public final static String Userlist_close="//button[text()='Close']";
	 //BillerPayables
	 public final static String Biller_Payables="//a[@id='lnkPayments2']";
	 public final static String Biller_Incomingbills="//h6[text()='Incoming Bills']";
	 public final static String Biller_Incomingbills_PaymentMethod="//select[@id='PaymentTypeId']";
	 public final static String Biller_Incomingbills_PrintButton="//button[@id='btnPrintInvoice']";
	 public final static String Biller_Incomingbills_PaymentMethod_Type="//img[contains(@src,'Sadad')]";
	 public final static String Biller_Incomingbills_PaymentMethod_Sadad="//div[@id='lnkSadad']";
	 public final static String Biller_Incomingbills_PaymentMethod_Mada="//div[@id='MADALnk']";
	 public final static String Biller_Incomingbills_PaymentMethod_Visa="//div[@id='VISALnk']";
	 public final static String Biller_Incomingbills_PaymentMethod_MasterCard="//div[@id='MASTERLnk']";
	 public final static String Biller_IncomingbillsBtn="(//a[text()='Incoming Bills'])[2]";
	 public final static String Biller_BillNumber="//input[@name='billNo']";
	 public final static String Biller_BillerName="//input[@name='billerName']";
	 public final static String Biller_Status="//select[@name='BillStatusId']";
	 public final static String Biller_ContractNo="//input[@name='InvoiceNo']";
	 public final static String Biller_Searchbtn="//button[@id='btnSearch']";
	 public final static String Biller_Billsrow="(//tr[@role='row'])[1]";
 public final static String Biller_BillsGrid="//table";
	 public final static String Biller_BillsVerify="//td/a/span";
       //importclientdata
	 // public final static String Biller_importclientsym="//h6[text()='Import Clients Data']";
	  public final static String Biller_Clientbtn="//a[@id='lnkMyClients2']";
      public final static String Biller_ImportClientbtn="//a[text()='Import Clients Data' and @class='nav-link']";
      //public final static String Biller_ImportClientbtn="//a[text()='Import Clients Data' and @class='nav-link active']";

	  public final static String Biller_IndivRdnBtn="//label[@class='custom-control-label' and @for='rdCustomer']";
	  public final static String Biller_CarpoRdnBtn="//label[@class='custom-control-label' and @for='rdCompany']";
	  public final static String Biller_IndDownimg="//span[contains(text(),'Individual Data Form')]";
	  public final static String Biller_CorpDownimg="//span[contains(text(),'Corporate Data Form')]";
	  public static final String Biller_importclientsym ="//h6[text()='Import Clients Data']";
	  public static final String Biller_import_AttachFile ="//input[@id='ExcelFile']";
	  public final static String Biller_ClientProcessButton ="//button[@id='btnProcessingExcelFile']";
      public final static String Biller_ClientConfirmUploadButton ="//button[@id='btnConfirmUpload']";
//Pricelist
	//public final static String Biller_PriceListpagetxt = "//h6[@class='justify-content-start align-middle align-self-center']";
	//    public final static String Biller_PriceList="//a[@id='lnkPriceList2']";
	 //   public final static String Biller_PriceListsfield="//input[@id='Name']";
	   // public final static String Biller_PriceListSeacrchbtn="//button[@class='btn btn-primary']";
	    public final static String Biller_PriceListDeletebtn="//a[@class='mx-1 action bg-danger deleteItem']";
	    public final static String Biller_PriceListDeleteConformbtn="//button[@id='btnConfirmDelete']";
	    public final static String Biller_PriceListNodata="//td[text()='No data available in table']";
	    public final static String Biller_Searchpresent="//td[text()='No data available in table']";
	    public final static String Biller_AddPricelistbtn="//button[text()='Add price list +']";
	    public final static String Biller_Pricelistnameinarabic="//input[@id='NameAr']";
	    public final static String Biller_PricelistnameinEnglish="//input[@id='NameEn']";
	    public final static String Biller_Pricelistbtn="//input[@id='Value']";
	    public final static String Biller_Pricelistincradiobtn="//label[contains(text(),'Increase Price')]";
	    public final static String Biller_Pricelistdscradiobtn="//label[contains(text(),'Decrease Price')]";
	    public final static String Biller_Pricelistdescriptionbtn="//textarea[@id='Description']";
	    public final static String Biller_AddPricelistbtn2="//button[@id='btnAdd']";
	    public final static String Biller_AddPriceFromdate="//input[@id='FromDate']";
	    public final static String Biller_AddPriceTodate="//input[@id='ToDate']";
	    public final static String Biller_AddPriceFromYear="//select[@title='Change the year']";
	    public final static String Biller_AddPriceFromMonth="//select[@title='Change the month']";
	    public final static String Biller_AddPriceToyear="//select[@title='Change the year']";
	    public final static String Biller_AddPriceToMonth="//select[@title='Change the month']";
	    public final static String Biller_Roundinguprdn="//label[contains(text(),'Rounding Up')]";
	    public final static String Biller_Roundingdownrdn="//label[contains(text(),'Rounding Down')]";
	    public final static String Biller_RoundingNordn="//label[contains(text(),'No Rounding')]";
	    public final static String Biller_ActiveCheckbox="//label[contains(text(),'Activate/Deactivate')]";
//Termsmanagement
	//    public final static String Biller_Termsmanagementsym="//h6[text()='Terms Management']";
	 //   public final static String Biller_Settingbtn="//a[@id='lnkMySettings']";
	  //  public final static String Biller_Termsmanagementbtn="(//a[text()='Terms Management'])[2]";
	   // public final static String Biller_Termsnameinarabic="//tr/th[text()='Term Name in Arabic']";
	    //My Account
	    public final static String Biller_Notificationsym="//h6[text()='Notification Settings']";
	    public final static String Biller_MyAccountbtn="//a[@id='ulNotificationTypeList']";
		//public static String Biller_MyAccountbtn="//a[@id='ulNotificationTypeList']";
		public static String Biller_Notificationbtn="(//a[text()='Notification Settings'])[2]";
		public static String Biller_SMSTogglebtn="//td[contains(text(),'Send SMS')]/..//label";
		public static String Biller_CancalTogglebtn="//button[text()='Yes']";
		public static String Biller_ActiveTogglebtn="//button[text()='Yes']";
		public static String Biller_CancalActivationpop="//h5[text()='Cancel activation?']";
		public static String Biller_ConformActivationpop="//h5[text()='Confirm activation?']";
public static String Biller_MyAccount_pushNotificationtoggelbtn="//label[@for='1']";
		public static String Biller_MyAccount_pushNotification_Confirmbtn="//button[@id='btnConfirmActivation']";
		
		//Subbiller
		public final static String Biller_SubBiller_Edit="//a[@class='mx-1 action bg-accent']";
	    public final static String Biller_SubBiller_Invoice_Total_AMT_ChkBox="//input[@id='HasInvoiceFees']";
	    public final static String Biller_SubBiller_FixedValue_ChkBox="//input[@id='HasOperationalFees']";
	    public final static String Biller_SubBiller_Percentage_ChkBox="//input[@id='HasOperationalFeesPercentage']";
	    public final static String Biller_SubBiller_FixedValue_Amt="//input[@id='OperationalFees']";
	    public final static String Biller_SubBiller_Percentage_Val="//input[@id='OperationalFeesPercentage']";
	    public final static String Biller_SubBiller_Trans_Fee_Deduct_ChxBox="//input[@id='DeductTransferFeesFromSubBiller']";
	    public final static String Biller_SubBiller_Save="//input[@id='btnUpdate']";
	    public final static String Biller_AddSubBilleer="//button[@id='btnAddSubBiller']";
	    public final static String Biller_SubBillerName="//input[@id='IndividualNameAr']";
	    public final static String Biller_SubBiller_IBAN="//input[@id='IBAN']";
	    public final static String Biller_SubBiller_Benificary="//input[@id='BeneficiaryName']";
	    public final static String Biller_SubBillerAddButton="//input[@id='btnAdd']";
	    public final static String Biller_SubBiller_MOB="//input[@id='MobileNo']";
	    public final static String Biller_SubBiller_Email="//input[@id='Email']";
	    //reports
	   // public final static String Biller_ReportMenu = "//a[@id='lnkMyReports']";
	   // public final static String Biller_ReceivablesReportsbtn = "//a[@class='dropdown-toggle collapsed']";
	    public final static String Biller_ReportClientaccountsym ="//h6[text()='Client Account Statement']";
	    public final static String Biller_ReportClientaccountbtn ="//a[@id='lnkCustomerAccount2']";
	   // public final static String Biller_ClientType ="//select[@name='ClientTypeId']";
	    public final static String Biller_ClientTypeindvidutial ="(//select/option[text()='Individual'])[1]";
	    public final static String Biller_SubbillerTypeindvidutial ="//select[@id='SubBillerType']";
	   // public final static String Biller_SubbillerTypeindvidutial ="//select[@id='SubBillerType' and @name='SubBillerType']";
	    public final static String Biller_ClientTypeCorporate ="(//select/option[text()='Corporate'])[1]";
	    public final static String Biller_SubbillerTypeCorporate ="(//select/option[text()='Corporate'])[1]";
	    public final static String Biller_ClientName ="//span[@id='select2-ClientId-container']";
	    public final static String Biller_SelectClientName ="(//li[@role='treeitem'])";
	    public final static String Biller_SelectSubbillertype ="//select[@name='SubBillerType']";
	    //public final static String Biller_SelectSubbillerName ="(//span[@role='combobox'])[2]";

	    //public final static String Biller_SubbillerTypeCorporate ="(//option[text()='Corporate'])[1]";

	    public final static String Biller_SelectSubbillerName ="(//span[text()='- Select Sub Biller -'])[2]";
	    public final static String Biller_SelectSubbillerName1 ="(//li[@role='treeitem'])";
	    public final static String Biller_Invoicecontract ="//input[@id='InvoiceNumber']";
	   
	    public final static String Biller_ReportFromdate="//input[@id='FromDate']";
	    public final static String Biller_ReportTodate="//input[@id='ToDate']";
	    public final static String Biller_reportFromYear="//select[@title='Change the year']";
	    public final static String Biller_reportFromMonth="//select[@title='Change the month']";
	    public final static String Biller_reportToyear="//select[@title='Change the year']";
	    public final static String Biller_reportToMonth="//select[@title='Change the month']";
	    public final static String Biller_reportsearchbutton="//button[text()=' Search']";
	    public final static String Biller_report="//div[text()='Client Account Statement']";
	    public final static String Biller_reportframe="//iframe";
	    //Userlist
	    public final static String Biller_Userlisttoggledisable="//td/span";
	  //Term Management

	    public final static String Biller_Terms_menu="//a[@id='lnkTermList2']";
	    public final static String Biller_AddTerm_Btn="//button[@id='btnAddTerm']";
	    public final static String Biller_TermName_Arabic="//input[@id='NameAr']";
	    public final static String Biller_TermName_ENG="//input[@id='NameEn']";
	    public final static String Biller_TermText_Arabic="//textarea[@id='DescriptionAr']";
	    public final static String Biller_TermText_Eng="//textarea[@id='DescriptionEn']";
	    public final static String Biller_TermToggle="//label[@for='status']";
	    public final static String Biller_TermSave_BTN="//button[text()='Save']";
	    public final static String Biller_TermTXT_Field="//input[@id='TermName']";
	    public final static String Biller_Term_SearchBTN="//button[text()='Search']";
	    public final static String Biller_TermStatusToggle="//label[@class='mb-0']";
	    public final static String Biller_TermConfirmBTN="//button[@id='btnConfirmActivation']";
	    public final static String Biller_TermNoDataAvilableTxt="//td[text()='No data available in table']";
	  //Product Management

	    public final static String Biller_Product_RefCode="//input[@id='Code']";
	    public final static String Biller_Product_Description="//textarea[@id='Description']";
	    public final static String Biller_Product_MinPrice="//input[@id='MinPrice']";
	    public final static String Biller_Product_MaxPrice="//input[@id='MaxPrice']";
	    public final static String Biller_Product_SingleToggle="//input[@id='single']";
	    public final static String Biller_Product_SaveChangesBtn="//button[@id='btnUpdate']";
	    public final static String Biller_Product_EditBtn="//a[@class='mx-1 action bg-accent']";
	 
	  //Client My Account page
    public final static String ClientMyAccountMenu ="//a[@id='lnkBillerAccount2']";
    public final static String ClientMyAccUpdateProfileMenu ="//a[@id='lnkUpdateCustomerData2']";
    public final static String ClientMyAccUpdateProfileSecondName ="//input[@id='SecondName']";
    public final static String ClientMyAccUpdateProfileThirdName ="//input[@id='ThirdName']";
    public final static String ClientMyAccUpdateProfileLastName ="//input[@id='LastName']";
    public final static String ClientMyAccUpdateProfileMobNumber ="//input[@id='MobileNo' and @name='MobileNo' ]";
    public final static String ClientMyAccUpdateProfileSaveChangesBTN ="//input[@id='btnAdd']";
    public final static String ClientMyAccUpdateProfileCancelbtn="//a[text()='Cancel']";
    public final static String ClientMyAccUpdateClientLogininfo="//a[@id='UpdateCustomerLoginInfo2']";
    public final static String ClientMyAccUpdateClientLogin_oldpwd="//input[@id='OldPassword']";
    public final static String ClientMyAccUpdateClientLogin_newpwd="//input[@id='NewPassword']";
    public final static String ClientMyAccUpdateClientLogin_confirmpwd="//input[@id='ConfirmPassword']";
    public final static String ClientMyAccUpdateClientLogin_savebtn="//input[@id='btnAdd']";
	  //report

	    public final static String Biller_individual_Report=" //a[@id='lnkBillerIndividualClientsReport']";
	    public final static String Biller_individualclient_List="//div[text()='Individual Clients List']";
	    public final static String Biller_ReportsMenu="//a[@id='lnkMyReports']";
	    public final static String Biller_Recevible_ReportMenu="//a[@id='refReceiptsSub22']";
	   
//Biller ReceivablesPaidOutSideEddat
	 public final static String Biller_PaidOustSideEdaat="//h6[text()='Paid Outside EDAAT']";
	 public final static String Biller_PaidOustSideEdaat_link="//a[@id='lnkPayCashList2']";
	 public final static String Biller_Receivables_link="//a[@id='lnkReceipts2']";
	 public final static String Biller_Receivables_PaidOutside_Table="//div[@id='tblReceiptVouchers_wrapper']";

	 //BillerSubBillerIndividual
	 public final static String Biller_subBiller="//a[@id='lnkSubBillers2']";
	 public final static String Biller_subBiller_individual="//h6[text()='Individual Sub Billers']";
	 public final static String Biller_subBiller_individual_link="//a[@id='lnkSubBillersIndividualList2']";
	 public final static String Biller_subBiller_individual_grid="//div[@id='tblSubBillers_wrapper']";

	 //BillerSubBillerAddIndividual
	 public final static String Biller_AddsubBiller_btn="//button[text()=' Add Sub Billers+']";
	 public final static String Biller_AddsubBiller_name="//input[@id='IndividualNameAr']";
	 public final static String Biller_AddsubBiller_National="//input[@name='NationalId']";
	 public final static String Biller_AddsubBiller_IBAN="//input[@id='IBAN']";
	 public final static String Biller_AddsubBiller_Beneficiary="//input[@id='BeneficiaryName']";
	 public final static String Biller_AddsubBiller_Iban="//input[@id='IBANAttachment']";
	 public final static String Biller_AddsubBiller_Fees="//label[text()='Fees Deduction Based on Product']";
	 public final static String Biller_AddsubBiller_mbl="//input[@id='MobileNo']";
	 public final static String Biller_AddsubBiller_Email="//input[@id='Email']";
	 public final static String Biller_AddsubBiller_addbtn="//input[@id='btnAdd']";
	 public final static String Biller_AddsubBiller_addprod="//a[@id='btnNewProduct']";
	 public final static String Biller_AddsubBiller_prodname="//select[@id='ProductId']";
	 public final static String Biller_AddsubBiller_fixed="//input[@id='txtProductFixedValue']";
	 public final static String Biller_AddsubBiller_per="//input[@id='txtProductPercentage']";
	 public final static String Biller_AddsubBiller_prodiban="//input[@id='txtProductIBAN']";
	 public final static String Biller_AddsubBiller_prodbene="//input[@id='txtProductBeneficiaryName']";
	 public final static String Biller_AddsubBiller_prodatch="//input[@id='ProductIBANAttachment']";
	 public final static String Biller_AddsubBiller_prodaddbt="//button[text()='Add']";
	 public final static String Biller_AddsubBiller_verify="//table[@id='tblSubBillers']//tr//td[2]";
	 public final static String Biller_AddsubBiller_SeaName="//input[@id='Name']";
	 public final static String Biller_AddsubBiller_SeaNation="//input[@id='NationalId']";
	 public final static String Biller_AddsubBiller_Search="//button[text()='Search']";
	 public final static String Biller_AddsubBiller_check="//label[text()='Transfer Fees Deduction from Sub Biller Share']";
	 
	//Biller Receivables My balance
	 public final static String Biller_Receivables_balance="//h6[text()='Search228']";
	 public final static String Biller_Rcv_balFromd="//input[@id='FromDate']";
	 public final static String Biller_Rcv_balFromyear="//select[ @title='Change the year']";
	 public final static String Biller_Rcv_balFromon="//select[@title='Change the month']"; 
	 public final static String Biller_Rcv_balTod="//input[@id='ToDate']";
	 public final static String Biller_Rcv_balToyear="//select[@title='Change the year']";
	 public final static String Biller_Rcv_balTomon="//select[@title='Change the month']";
	 public final static String Biller_Rcv_balancelink="//a[text()='Balance Details']";
	 
	
		
	 
	 public final static String Biller_Rcv_balContract="//input[@id='InvoiceNumber']";
	 public final static String Biller_Rcv_balsubBiller="//select[@id='SubBillerType']";
	 public final static String Biller_Rcv_balsubBillername="//span[@id='select2-InterpriseSubBillerId-container'] ";
	 public final static String Biller_Rcv_balSearch="//button[@id='btnSearch']";
	 public final static String Biller_Rcv_balverifyContract="//table[@id='tblWallets']//tr[1]//td[3]";
	 public final static String Biller_Rcv_BalanceTotalAmountPaid="//td[text()='Total Amounts Paid']/following-sibling::td";
	 public final static String Biller_Rcv_BalanceTotalOperationFees="//td[text()='Total Operation Fees (Inclusive VAT)']/following-sibling::td";
	 public final static String Biller_Rcv_balverifyAmountPaid="//td[text()='Pay Invoice']//parent::tr//span";
	 public final static String Biller_Rcv_balverifyOperationalFees="//td[text()='Operational Fees']//parent::tr//span";
	 public final static String Biller_Rcv_balverifyPaymentMethod="(//table//td[10])[1]";
	 
	//Biller login footer
	 public final static String Biller_loginverify="//h5[text()='Login']";
	 public final static String Biller_About_Edaat="//a[text()='About Edaat']";
	 public final static String Biller_About_verify="//img[@class='w-100 fit-contain img-en']";
	 //Biller signup error messege
	 public final static String LoginPage_UserError ="//span[@id='UserName-error']";
	 public final static String LoginPage_PasswordError ="//span[@id='Password-error']";
	 
	 //Biller Forgot error message
	 public final static String Biller_ForgotPasswordlink ="//a[@href='/RecoveryPassword/RecoveryPassword']";
	 public final static String ResetPasswordPage_Usernamefield ="//input[@id='UserName']";
	 public final static String ResetPasswordPage_SendBtn = "//button[@id='btnSendRequest']";
	 public final static String ResetPasswordPage_UsernameError ="//span[@id='UserRequired']";
	 
	 //Registration Page Error Message
	 public final static String RegistrationPage_CorporateNameError ="//span[@id='CompanyNameAr-error']";
	 public final static String RegistrationPage_CountryError ="//span[@id='CountryID-error']";
	 public final static String RegistrationPage_CityError ="//span[@id='CityID-error']";
	 public final static String RegistrationPage_DistrictNameError ="//span[@id='District-error']";
	 public final static String RegistrationPage_StreetError ="//span[@id='Street-error']";
	 public final static String RegistrationPage_BuildingNoError ="//span[@id='BuildingNo-error']";
	 public final static String RegistrationPage_ZipCodeError ="//span[@id='PostalCode-error']";
	 public final static String RegistrationPage_AdditionalNumberError ="//span[@id='MailBox-error']";
	 public final static String RegistrationPage_UnitNumberError ="//span[@id='OfficeNo-error']";
	 public final static String RegistrationPage_EmployeeNameError ="//span[@id='EmployeeName-error']";
	 public final static String RegistrationPage_EmployeePositionError ="//span[@id='EmployeeJobTitle-error']";
	 public final static String RegistrationPage_EmployeeMobileNumberError ="//span[@id='EmployeeMobileNo-error']";
	 public final static String RegistrationPage_EmployeeEmailError ="//span[@id='EmployeeEmail-error']";
	 public final static String RegistrationPage_ClientSupportPhoneNumberError ="//span[@id='CustomerSupportPhoneNo-error']";
	 public final static String RegistrationPage_IBANNumberError ="//span[@id='IBAN-error']";
	 public final static String RegistrationPage_BankAccountTypeError ="//span[@id='BankAccountTypeId-error']";
	 public final static String RegistrationPage_CRNumberError ="//span[@id='RegistrationNo-error']";
	 public final static String RegistrationPage_BillerSubNameError ="//span[@id='BillerSubName-error']";
	 public final static String RegistrationPage_CRIssueDateError ="//span[@id='RegistrationDateHijri-error']";
	 public final static String RegistrationPage_CRExpieryDateError ="//span[@id='ExpiredRegistrationDateHijri-error']";
	 public final static String RegistrationPage_TaxNumberError ="//span[@id='TaxNo-error']";
	 public final static String RegistrationPage_AuthorizedPersonFirstNameError ="//span[@id='FirstNameAr-error']";
	 public final static String RegistrationPage_AuthorizedPersonSecondNameError ="//span[@id='FatherNameAr-error']";
	 public final static String RegistrationPage_AuthorizedPersonThirdNameError ="//span[@id='GrandFatherNameAr-error']";
	 public final static String RegistrationPage_AuthorizedPersonLastNameError ="//span[@id='LastNameAr-error']";
	 public final static String RegistrationPage_AuthorizedPersonIDError ="//span[@id='NationalID-error']";
	 public final static String RegistrationPage_MobileNoError ="//span[@id='CommissionerPhoneNo-error']";
	 public final static String RegistrationPage_EmailError ="//span[@id='CommissionerEmail-error']";
	 public final static String RegistrationPage_UserNameError ="//span[@id='Username-error']";
	 public final static String RegistrationPage_PasswordError ="//span[@id='Password-error']";
	 public final static String RegistrationPage_ConfirmPasswordError ="//span[@id='ConfirmPassword-error']";
	 //invalid
	 public final static String RegistrationPage_CorporateNameInvalidError ="(//span[@class='text-danger field-validation-error'])[1]";
	 public final static String RegistrationPage_DistrictNameInvalidError ="(//span[@class='text-danger field-validation-error'])[2]";
	 public final static String RegistrationPage_StreetInvaidError ="(//span[@class='text-danger field-validation-error'])[1]";
	 public final static String RegistrationPage_EmployeeNameInvaidError ="(//span[@class='text-danger field-validation-error'])[1]";
	 public final static String RegistrationPage_EmployeePositionInvaidError ="(//span[@class='text-danger field-validation-error'])[2]";
	 public final static String RegistrationPage_EmployeeMobileNumberInvaidError ="//span[@id='EmployeeMobileNo-error']";
	 public final static String RegistrationPage_EmployeeEmailInvaidError ="//span[@id='EmployeeEmail-error']";
	 public final static String RegistrationPage_ClientSupportPhoneNumberInvalidError="//span[@id='CustomerSupportPhoneNoErrorMessage']";
	 public final static String RegistrationPage_IBANNumberInvalidError="//span[@id='IBAN-error']";
	 public final static String RegistrationPage_CRNumberInvalidError="(//span[.='Please enter a 10-digit number'])[2]";
	 public final static String RegistrationPage_TaxNumberInvalidError="(//span[.='Validation'])[2]";
	 public final static String RegistrationPage_AuthorizedPersonFirstNameInvalidError="//span[@id=' ']";
	 public final static String RegistrationPage_AuthorizedPersonSecondNameInvalidError="(//span[text()='Please use only characters'])[2]";
	 public final static String RegistrationPage_AuthorizedPersonThirdNameInvalidError="(//span[text()='Please use only characters'])[3]";
	 public final static String RegistrationPage_AuthorizedPersonLastNameInvalidError="(//span[text()='Please use only characters'])[4]";
	 public final static String RegistrationPage_MobileNoInvalidError="//span[text()='The mobile number entered is incorrect']";
	 public final static String RegistrationPage_EmailInvalidError="//span[text()='Invalid email']";
	 public final static String RegistrationPage_UserNameInvalidError="//span[text()='Please enter valid username contains at least 8 characters']";
	 public final static String RegistrationPage_PasswordInvalidError="//span[@id='Password-error']";
	 public final static String RegistrationPage_ConfirmPasswordInvalidError="//span[text()='تأكيد كلمة المرور غير مطابق لكلمة المرور']";
	 public final static String BillerImportClientdataError="//span[@id='ExcelFile-invalid']";
     	 //Admin Distribution
	 public final static String Admin_DistRecordofpostingsym ="//h6[text()='Record of Posting']";
     public final static String Admin_SysMng ="//a[@id='lnkSystemMangement2']";
     public final static String Admin_DistBtn ="//a[text()='Distribution' and @id='refWalletManagementSub2']";
     public final static String Admin_DistRecordofposting ="//a[text()='Record of Posting' and @id='lnkRecordPostings2']";
     public final static String Admin_DistRecordofpostinggridview ="//table[@id='tblBillList']";
     public final static String Admin_BatchNo ="//input[@id='batchNo']";
     public final static String Admin_ClickFromdate ="//input[@id='FromDate']";
     public final static String Admin_ClickTodate ="//input[@id='ToDate']";
     public final static String Admin_ClickFromyear ="//select[@title='Change the year']";
     public final static String Admin_ClickToyear ="//select[@title='Change the year']";
     public final static String Admin_ClickFrommonth ="//select[@title='Change the month']";
     public final static String Admin_ClickTomonth ="//select[@title='Change the month']";
     public final static String Admin_Button ="//button[@id='btnSearch']";     
     public final static String Admin_Dist_DailyfileExporting ="//a[@id='lnDailyFile2']";
     public final static String Admin_Dist_ExportFromd="//input[@id='DateFrom']";
	 public final static String Admin_Dist_ExportFromyear="//select[ @title='Change the year']";
	 public final static String Admin_Dist_ExportFromon="//select[@title='Change the month']"; 
	 public final static String Admin_Dist_ExportTod="//input[@id='DateTo']";
	 public final static String Admin_Dist_ExportToyear="//select[@title='Change the year']";
	 public final static String Admin_Dist_Exportomon="//select[@title='Change the month']";
	 public final static String Admin_Dist_BillerName="//span[@role='textbox']";
	 public final static String Admin_Dist_TransferStatus="//select[@id='InvoicePostingId']";
	 public final static String Admin_Dist_Export_srcbtn="//button[@id='btnSearch']";
	 public final static String Admin_DistDailyfileExportingHyper="//a[@id='lnDailyFilePayment2']";
	 public final static String Admin_DailyFileExportingHyperPayHeader= "//h6[text()='Daily File Exporting (Hyper Pay)']";
     public final static String Admin_RecordOfPostingTbleBtchNo="//tbody//a/span";


     
     
     
  
  //Admin System management distribution management
 	//public final static String Admin_DistRecordofpostingsym ="//h6[text()='Record of Posting']";
    // public final static String Admin_SysMng ="//a[@id='lnkSystemMangement2']";
     //public final static String Admin_DistBtn ="//a[text()='Distribution' and @id='refWalletManagementSub2']";
    // public final static Strincordofposting ="//a[text()='Record of Posting' and @id='lnkRecordPostings2']";
     //public final static String Admin_DistRecordofpostinggridview ="//table[@id='tblBillList']";
 		
      //Distribution Daily transfer requests
     public final static String Admin_DistDailyTransferPage ="//a[@id='lnkTransferManagement2']";
     public final static String Admin_DistDailyTransfer_Header ="//h6[text()='Daily Transfer Requests']";
     public final static String Admin_DistEODSettlement_Header ="//h6[text()='EoD Settlement Report']";
     public final static String Admin_AddTransferRequest ="//button[@id='btnAddTransferRequest']";
     public final static String Admin_DailyTransReconciledCalender ="//input[@id='ReconciledDate']";
     public final static String Admin_ReconciledMonth ="(//select[@class='calendars-month-year'])[1]";
     public final static String Admin_ReconciledYear ="(//select[@class='calendars-month-year'])[2]";
     public final static String Admin_ReconciledSearchBtn ="//button[text()='Search']";
     public final static String Admin_B2BCheckbox ="(//label[text()='B2B Transfer'])[1]";
     public final static String Admin_ManualCheckbox ="//label[text()='Manual Transfer']";
     public final static String Admin_SendTransferRequestBTn="//button[@id='sendTransferRequest']";
     public final static String Admin_SaveButton="//button[@id='ManualSave']";
     public final static String Admin_DistReason="//div[@id='ReasonError']";
     public final static String Admin_DistDate="//div[@id='ManualDateError']";
     public final static String Admin_DistAttachment="//div[@id='file-input-msg']";
     public final static String Admin_TransferRequestYesBTn="//button[@id='btnConfirmSendRequest']";
     //public final static String Admin_viewRequest="//table[@id='tblTransferRequestsList']//tr[1]//td[6]";
     public final static String Admin_viewRequest="//table[@id='tblTransferRequestsList']//button[1]";
     public final static String Admin_CloseRequest="//button[@class='btn btn-link']";
     //Admin Distribution EOD Settlement
     public final static String Admin_Dist_EODSettlement="//a[@id='lnkBankTransferSettlementReport2']";
     public final static String Admin_Dist_EODSettlementSearchbtn="//button[@id='btnSearchDate']";
     public final static String Admin_Dist_EODSettlementErrorMsg="//a[@id='empty']";

	 
	 //Admin corporate clients management
	 public final static String Admin_CorporateClient_addbtn ="//a[@id='lnkActivateCompanies2']";
	 public final static String Admin_CorporateClient_crefield ="//input[@id='RegistrationNo']";
	 public final static String Admin_CorporateClient_Header ="//h6[text()='Corporate Clients']";
	 public final static String Admin_Corporatename_efield ="//input[@id='CompanyName']";
	 public final static String Admin_Corporateclient_srchbtn ="//button[@id='btnSearch']";
	 public final static String Admin_SysMgmClient_CorpoclientMgmMenu="//a[@id='lnkActivateCompanies2']";
	 public final static String Admin_SysMgm_CorpoclientDetails ="//table[@id='dtCompanies']";



	//Admin SubBillers management
	  public final static String Admin_system_sublink="//a[@id='lnkSubBillerList2']";
	  public final static String Admin_system_subBlr_verif="//h6[text()='Sub Billers Management']";
	  public final static String Admin_system_subBlr_Edit="(//div[@id='dtCompanies_wrapper']//tr//td[9])[1]";
	  public final static String Admin_system_subBlr_Edit_verif="//h6[text()='General Info']";
      public final static String Admin_system_subBlr_Table="//table[@id='dtCompanies']";
	  public final static String Admin_system_subBlr_MainBiller="//span[@id='select2-selectedBillerId-container']";
	  public final static String Admin_system_subBlr_SearchBtn="//button[@id='btnSearch']";
	  public final static String Admin_system_subBlr_Grid="//td[text()='No data available in table']";
	  public final static String Admin_system_subBlr_Grid_View="//table[@id='dtCompanies']";
      public final static String Admin_system_subBlr_click="//span[@role='textbox']";
	  public final static String Admin_system_subBlr_indiv="//label[@for='rdSubbillerIndividual']";
	  public final static String Admin_system_subBlr_Corp="//label[@for='rdSubbillerCompany']";
	  public final static String Admin_system_subBlr_srcbtn="//button[@id='btnSearch']";
	
	  
	  public final static String Admin_Corporateclient_RecordBtn ="//button[@class='btn']";
	  public final static String Admin_Corporateclient_HistoryPopup ="//h5[@class='modal-title']";
	 
	 
	 //Admin Receivable Report Client Account Statement
	    public final static String Admin_ReportClientaccountsym ="//h6[text()='Client Account Statement']";
	    public final static String Admin_ClientType = "//select[@id='ClientTypeId']";
	    public final static String Admin_ReportClientaccountbtn ="//a[@id='lnkCustomerAccount2']";
	    public final static String Admin_ClientTypeindvidutial ="(//select/option[text()='Individual'])[1]";
	    public final static String Admin_Client_name ="(//span[@role='combobox'])[1]";
 		public final static String Admin_Client_name_Option ="(//li[@role='treeitem'])[1]";
	    public final static String Admin_Reports_SubBiller_name ="(//span[@role='combobox'])[2]";
	    public final static String Admin_ClientTypeCorporate ="(//select/option[text()='Corporate'])[1]";
	    public final static String Admin_SubbillerTypeCorporate ="(//select/option[text()='Corporate'])[1]";	   
	    public final static String Admin_SelectSubbillertype ="//select[@name='SubBillerType']";
	    public final static String Admin_SelectSubbillerName1 ="(//li[@role='treeitem'])";
	    public final static String Admin_Invoicecontract ="//input[@id='InvoiceNumber']";	   
	    public final static String Admin_ReportFromdate="//input[@id='FromDate']";
	    public final static String Admin_ReportTodate="//input[@id='ToDate']";
	    public final static String Admin_reportFromYear="//select[@title='Change the year']";
	    public final static String Admin_reportFromMonth="//select[@title='Change the month']";
	    public final static String Admin_reportToyear="//select[@title='Change the year']";
	    public final static String Admin_reportToMonth="//select[@title='Change the month']";
	    public final static String Admin_reportsearchbutton="//button[text()=' Search']";
	    public final static String Admin_report="//div[text()='Client Account Statement']";
	    public final static String Admin_reportframe="//iframe";
	  
	//Admin SubBiller Corporate subBillers
	  public final static String Admin_CorpSubBiller="//h6[text()='Corporate Sub Billers']";
	  public final static String Admin_CorpSubBillerlnk="//a[@id='lnkSubBillersComanyList2']";
	  public final static String Admin_SubBillers="//a[@id='lnkSubBillers2']";
	  public final static String Admin_CorpSubBillerGrid="//table[@id='tblSubBillers']";
	  public final static String Admin_CorpSubBillerPageVerify="//h6[text()='Corporate Sub Billers']";
	//Admin Settings Pricing List
	  public final static String Admin_Setting_pricelistpageVerify="//h6[text()='Pricing List']";
	  public final static String Admin_Setting_pricelistlnk="//a[@id='lnkPriceList2']";
	  public final static String Admin_Setting_pricelistlnk2="//a[@id='lnkPriceList2']";
	  public final static String Admin_Settings_PriceFromd="//input[@id='FromDate']";
	  public final static String Admin_Settings_PriceFromyear="//select[ @title='Change the year']";
	  public final static String Admin_Settings_PriceFromon="//select[@title='Change the month']"; 
	  public final static String Admin_Settings_PriceTod="//input[@id='ToDate']";
	  public final static String Admin_Settings_PriceToyear="//select[@title='Change the year']";
	  public final static String Admin_Settings_TodayDate="//a[contains(@class,'calendars-today')]";
	  public final static String Admin_Settings_Priceomon="//select[@title='Change the month']";
	  public final static String Admin_Settings_Addpricelistbtn="//button[text()='Add price list +']";
	  public final static String Admin_Settings_PricelistArabicName="//input[@id='NameAr']";
	  public final static String Admin_Settings_PricelistEnglishName="//input[@id='NameEn']";
	  public final static String Admin_Settings_Pricelistbtn="//input[@id='Value']";
	  public final static String Admin_Settings_Pricelistincradiobtn="//label[contains(text(),'Increase Price')]";
	  public final static String Admin_Settings_Pricelistdscradiobtn="//label[contains(text(),'Decrease Price')]";
	  public final static String Admin_Settings_descriptionbtn="//textarea[@id='Description']";
	  public final static String Admin_Settings_AddPricelistbtn2="//button[@id='btnAdd']";
	  public final static String Admin_Settings_ActivateCheckbox="//label[contains(text(),'Activate/Deactivate')]";
	  public final static String Admin_Settings_Roundinguprdn="//label[contains(text(),'Rounding Up')]";
	  public final static String Admin_Settings_RoundingNordn="//label[contains(text(),'No Rounding')]";
	  public final static String Admin_Settings_Roundingdownrdn="//label[contains(text(),'Rounding Down')]";
      public final static String Admin_Settings_PriceListsfield="//input[@id='Name']";
  	  public final static String Admin_Settings_PriceListSeacrchbtn="//button[@class='btn btn-primary']";
  	  public final static String Admin_Settings_PriceListnameverify="//div[@id='GridView']//tr//td[2]";
      public final static String Admin_Settings_PriceList_nodata="//td[text()='No data available in table']";
  	  public final static String Admin_Settings_PriceList_DeleteBtn="(//tr/td[7]/a[@class='mx-1 action bg-danger deleteItem'])[1]";
  	  public final static String Admin_Settings_PriceList_yesDeleteBtn="//button[@id='btnConfirmDelete']";
	  public final static String Admin_Settings_PriceListsym="//h6[text()='Pricing List']";
  	  public final static String Admin_Settings_PriceListtable="//table";
  	  public final static String Admin_Settings_PriceListUpdateBtn="//button[@id='btnUpdate_3110']";
  	  public final static String Admin_Settings_PriceListUpdate="//h6[text()='Update price list']";
		//Admin Module
    
  	//Admin Contacts Management
  	  public final static String Admin_SymCorpoName ="//input[@id='CompanyName']";
	  public final static String Admin_ContactsMGMToggle ="(//span[@class='switch switch-sm'])[1]";
	  public final static String Admin_ContactsManagement="//a[@id='lnkContacts2']";
	  public final static String Admin_ContactsManagement_Header="//h6[text()='Contacts Management']";
	  public final static String Admin_ContactsManagement_NoData="//td[text()='No data available in table']";
	  public final static String Admin_ContactsMGM_SenderName="//input[@id='name']";
	  public final static String Admin_ContactsMGM_SubjectDrop="//select[@id='subjectId']";
	  public final static String Admin_ContactsMGM_StatusDrop="//select[@id='statusId']";
	  public final static String Admin_ContactsMGM_SenderTypeDrop="//select[@id='SenderTypeId']";
	  public final static String Admin_ContactsMGM_SearchButton="//button[@id='btnSearch']";
	  public final static String Admin_ContactsMGM_Viewmessage="//a[@id='view_15827']";
	  public final static String Admin_ContactsMGM_message="(//div[@id='tblContacts_wrapper']//tr//td[8])[1]";
	  public final static String Admin_ContactsMGM_Replybtn="(//button[text()='Reply'])[1]";
	  public final static String Admin_ContactsMGM_TextMsg="(//textarea[@id='BillerMessage'])[1]";
	  public final static String Admin_ContactsMGM_SendReply="(//button[text()='Send reply'])[1]";
	  public final static String Admin_ContactsMGM_MsgDetails_verify="//h5[@id='exampleModalLongTitle']";
	  public final static String Admin_ContactsMGM_MsgDetails_Closebtn="//button[text()='Close']";
	 // public final static String Admin_SymCorpoName ="//input[@name='CompanyName']";
	 // public final static String Admin_ContactsMGM_message="(//div[@id='tblContacts_wrapper']//tr//td[8])[1]";
	  public final static String Admin_ContactsMgm_SenderStatus ="";
	  //public final static String Admin_ContactsMGM_message="(//div[@id='tblContacts_wrapper']//tr//td[8])[1]";

	   public final static String Admin_SymCorptable ="//table[@id='tblContacts']";

       public final static String Admin_SymCorpoCrNumber ="//input[@id='RegistrationNo']";
       public final static String Admin_SymCorpoClientstatus ="//select[@id='Types']";
       public final static String Admin_Symstatustogglebutton ="//label[@for='1']";
       public final static String Admin_Symstatustoggleyesbtn ="//button[text()='Yes' and @id='submit_btnConfirmActivation']";
       public final static String Admin_Symstatustoggletextarea ="//textarea[@id='submit_activationNotesText']";
       public final static String Admin_Symstatustoggleconformactivation ="//button[@id='submit_btnConfirmActivation']";
       public final static String Admin_Symstatustogglecancelbtn ="//button[text()='No']";

       //Admin Receivables Paid Outside Edaat
       public final static String Admin_Receivables_Menu="//a[@id='lnkReceipts2']";
       public final static String Admin_Receivables_PaidoutsideMenu="(//a[@href='/PayCashManagement/PayCash'])[2]";
       public final static String Admin_PaidoutsideEdaat_BillNo="//input[@id='BillNo']";
       public final static String Admin_PaidOutsideEdaat_DocumentNo="//input[@id='VoucherNo']";
       public final static String Admin_PaidoutsideEdaat_SubBillerName="//span[@class='select2-selection__arrow']";
       public final static String Admin_PaidoutsideEdaat_Searchbtn="//button[@id='btnSearch']";

       //contract
       public final static String Admin_Symcontactsym ="//h6[text()='Contacts Management']";
	   //individal client admin
       public final static String Admin_SymIndivClientname ="//input[@id='CustomerName']"; 
       public final static String Admin_SymIndivNIDname ="//input[@id='NationalID']"; 
       public final static String Admin_SymIndivClientstatus ="//select[@id='Types']";
       public final static String Admin_Individualclient_srchbtn ="//button[@id='btnSearch']";
       public final static String Admin_Individualdownload ="(//td//a)[2]";
     //Admin subbiller
       public final static String Admin_subbillerbtn ="//a[@id='lnkSubBillers2']";
       public final static String Admin_CarpoSubbillerdatabtn ="(//a[text()='Corporate Sub Billers'])[2]";
       public final static String Admin_Carpoaddsubbiller ="//button[@id='btnAddSubBiller']";
       public final static String Admin_subbillerName ="//input[@id='CompanyNameAr']";
       public final static String Admin_subbillerCRNumber ="//input[@id='RegistrationNo']";
       public final static String Admin_subbillerCRNCertificate ="//input[@id='RegistrationAttachment']";
       public final static String Admin_subbillerIban ="//input[@id='IBAN']";
       public final static String Admin_subbillerBenfName ="//input[@id='BeneficiaryName']";
       public final static String Admin_subbillerAttachIban ="//input[@id='IBANAttachment']";
       public final static String Admin_subbillerTaxNumber ="//input[@id='VATNo']";
       public final static String Admin_subbillerTotalAmountCheck ="//label[text()='Fees Deduction from Invoice Total Amount']";
       public final static String Admin_subbillerFixedValue ="//label[@for='HasOperationalFees']";
       public final static String Admin_subbillerPercentage ="//label[@for='HasOperationalFeesPercentage']";
       public final static String Admin_subbillerEnterFixedValue ="//input[@id='OperationalFees']";
       public final static String Admin_subbillerEnterPercentValue ="//input[@id='OperationalFeesPercentage']";
       public final static String Admin_subbillerCity ="//span[text()='Select City']";
       public final static String Admin_subbillerDisctictName ="//input[@id='District']";
       public final static String Admin_subbillerStreetName ="//input[@id='Street']";
       public final static String Admin_subbillerPostalName ="//input[@id='PostalCode']";
       public final static String Admin_subbillerBuildName ="//input[@id='BuildingNo']";
       public final static String Admin_subbillerEmployName ="//input[@id='EmployeeName']";
       public final static String Admin_subbillerEmpleyEmail ="//input[@id='EmployeeEmail']";
       public final static String Admin_subbillerEmpleyNumber ="//input[@id='EmployeeMobileNo']";
       public final static String Admin_subbillerAddbtn ="//input[@id='btnAdd']";
       public final static String Admin_subbillerBillerName ="//input[@id='Name']";
       public final static String Admin_subbillerCrNumber ="//input[@id='RegistrationNumber']";
       public final static String Admin_subbillerSearchBtn ="//button[text()='Search']";
	   public final static String Admin_ReceviablesPaidOutsideEddatLink ="//a[@id='lnkPayCashList2']";
       public final static String Admin_ReceviablesPaidOutsideEddatGridView ="//th[text()='Bill Number']";	
      
       //Admin Settings Content Management          
       public final static String Admin_SettingContentMngVerifyNationalid ="(//tr[@role='row']//td[4])[1]";    
       public final static String Admin_SettingContentMngVerifyRefnoid ="(//tr[@role='row']//td[7])[1]";
       public final static String Admin_Product_NameInput="//input[@id='Name']";
	   public final static String Admin_Product_SearchIDlist="//select[@id='ServiceId']";
	   public final static String Admin_Product_SeachBtn="//button[@id='btnSearch']";


              
       // Admin Corporate SubBiller
       public final static String Admin_CorpoSubBiller ="//a[@id='lnkSubBillersComanyList2']";
       public final static String Admin_CorpoSubBillerAddBTN ="//button[@id='btnAddSubBiller']";
       public final static String Admin_CorpoSubBillerName="//input[@id='CompanyNameAr']";
       public final static String Admin_CorpoSubBillerCRNum="//input[@id='RegistrationNo']";
       public final static String Admin_CorpoSubBillerCRAttach="//input[@id='RegistrationAttachment']";
       public final static String Admin_CorpoSubBillerIBAN="//input[@id='IBAN']";
       public final static String Admin_CorpoSubBillerIBANAttach="//input[@id='IBANAttachment']";
       public final static String Admin_CorpoSubBillerProductIBANAttach="//input[@id='ProductIBANAttachment']";
       public final static String Admin_CorpoSubBillerBeneficaryName="//input[@id='BeneficiaryName']";
       public final static String Admin_CorpoSubBillerTaxNum="//input[@id='VATNo']";
       public final static String Admin_CorpoSubBillerFeeDeductonProductCHXbox="//input[@id='HasProductFees']";
       public final static String Admin_CorpoSubBillerAddProduct="//a[@id='btnNewProduct']";
       public final static String Admin_CorpoSubBillerSelectProduct="//select[@id='ProductId']";
       public final static String Admin_CorpoSubBillerProFixedValue="//input[@id='txtProductFixedValue']";
       public final static String Admin_CorpoSubBillerProPercentage="//input[@id='txtProductPercentage']";
       public final static String Admin_CorpoSubBillerProductIBAN="//input[@id='txtProductIBAN']";
       public final static String Admin_CorpoSubBillerProductBeneficaryName="//input[@id='txtProductBeneficiaryName']";
       public final static String Admin_CorpoSubBillerProductAddBTN="//button[@id='btnAddProduct']";
       public final static String Admin_CorpoSubBillerAddButton="//input[@id='btnAdd']";
       public final static String Admin_CorpoSubBillerCityList="//span[@id='select2-CityID-container']";
       public final static String Admin_CorpoSubBillerVerfiy1="(//table[@id='tblSubBillers']//tr//td)[2]";
       public final static String Admin_CorpoSubBillerVerfiy2="(//table[@id='tblSubBillers']//tr//td)[3]";
       
 		//Admin Corporate Client Report
       
       public final static String Admin_CorporateClientReportBTN ="//a[@id='lnkCompanyClientsReport2']";
       public final static String Admin_CorporateClientBillerNameDropDown ="//span[@id='select2-BillerId-container']";
       public final static String Admin_CorporateClientGenerateReportBTN ="//button[@id='btnSearch']";
       public final static String Admin_CorporateClientReportTXT ="//td[@id='P4b860c0bb2974421aafaf099a8d411e0_1_oReportCell']";
       public final static String Admin_CorporateClientReport ="//div[text()='Corporate Clients List']";
       
       //Admin Receviebales Paid OutSide Edaat
       
       //Admin Import Clients Data
       public final static String Admin_ImportClientdatasym ="//h6[text()='Import Clients Data']";
       public final static String Admin_ImportClientdatabtm ="//a[@id='lnkMyClients2']";
       public final static String Admin_ImportClientdata ="//a[@id='lnkImportClients2']";
       public final static String Admin_ImportCorporateradiobtn ="//label[@for='rdCompany']";
       public final static String Admin_ImportCorporateradioImg ="//span[contains(text(),'Corporate Data Form')]";
       public final static String Admin_ImportIndividualradioImg ="//span[contains(text(),'Individual Data Form')]";
       public final static String Admin_ImportIndividualradiobtn ="//label[@for='rdCustomer']";
       public final static String Admin_ImportAttachExelFileBTN ="//input[@id='ExcelFile']";
       public final static String Admin_ClientProcessButton ="//button[@id='btnProcessingExcelFile']";
       public final static String Admin_ClientConfirmUploadButton ="//button[@id='btnConfirmUpload']";
       public final static String Admin_ClientUploadButtonErrMsg ="//span[@id='ExcelFile-invalid']";
       
     
       
       //admin indiv report
       public final static String Admin_IndivClientReport ="//a[@id='lnkIndividualClientsReport2']";
       public final static String Admin_ClickBillerName ="//span[@role='textbox']";
       public final static String Admin_SelectBillerName ="//li[@role='treeitem']";
       
       //Admin Reports Sub biller reports
       public final static String Admin_Reports_SubbillerReportMenu="//a[@id='lnkSubBillersInforAggregatorReport']";
       public final static String Admin_SubbillerReport_BillerNameDropdwn="//span[@id='select2-BillerId-container']";
       public final static String Admin_SubbillerReport_CRNumberfield="//input[@id='RegistrationNumber']";
       public final static String Admin_SubbillerReport_GenerateReportBtn="//button[@id='btnSearch']";
       public final static String Admin_SubbillerReportverify="//div[text()='Corporate Sub Billers']";
     
       //Admin Reports Clients Type reports
       public final static String Admin_Reports_ClientsTypeReportMenu="//a[@id='lnkAggregatorCustomersTypeReport2']";

     
       //Admin Settings Discount Management status toggle   
      public final static String Admin_SettingDis_Activatebtn ="//label[@for='status']";
     
      //Admin Reports PaymentTransaction and Operation fees
      public final static String Admin_Reports_PaymntTransaction_MainBlr="//span[@id='select2-BillerId-container']";
      public final static String Admin_Reports_PaymntTransaction_generate="//button[text()='Generate Report']";
      public final static String Admin_Reports_PaymntTransaction_report="//div[text()='ENGLISH BILLER']";
      public final static String Admin_Reports_PaymntTransactionlink="//a[@id='lnkPaymentsTransactionsReport2']";
      public final static String Admin_Reports_PaymntTransactionReport="//div[text()='Payment Transactions and Operations Fees Report']";

    //Admin Reports Blocked Corporate Client report
      public final static String Admin_Reports_Blockedcorporatelnk="//a[@id='lnkBlockedSystemCompaniesReport2']";
      public final static String Admin_Reports_BlockedcorporateVerify="//div[text()='Blocked Corporate Clients']";
  
    //Admin Receivables Balance search
      public final static String Admin_Receievable_Balance = "//h6[@id='hdrAlias']";
      public final static String Admin_Receievable_link = "//a[@id='lnkReceipts2']";
      public final static String Admin_BalanceDetailsPage = "//a[@id='lnkWalletDetails2']";
      public final static String Admin_Rcv_balFromd="//input[@id='FromDate']";
      public final static String Admin_Rcv_balFromyear="//select[ @title='Change the year']";
      public final static String Admin_Rcv_balFromon="//select[@title='Change the month']";
      public final static String Admin_Rcv_balTod="//input[@id='ToDate']";
      public final static String Admin_Rcv_balToyear="//select[@title='Change the year']";
      public final static String Admin_Rcv_balTomon="//select[@title='Change the month']";
      public final static String Admin_Rcv_balancelink="//a[text()='Balance Details']";
      public final static String Admin_Rcv_balContract="//input[@id='InvoiceNumber']";
      public final static String Admin_Rcv_balSearch="//button[@id='btnSearch']";
      public final static String Admin_Rcv_subbiler="//span[@id='select2-SubBillerId-container']";
      public final static String Admin_BalanceDetailsViewBtn = "(//a[@title='View Contract'])[1]";
      public final static String Admin_InvoiceDetails = "//h6[text()='Invoice Details']";
      public final static String Admin_Update_btn="//button[@data-target='#updateAliasModal']";
      public final static String Admin_Wallet_efield="//input[@id='Alias']";
      public final static String Admin_Wallet_yesbtn="//button[@id='btnUpdateAlias']";
      public final static String Admin_updated_Wallet="//h6[@id='hdrAlias']";
      public final static String Admin_RcvBalanceSearch_Verify="//div[@id='tblWallets_wrapper']//tr[1]//td[3]";
      
      //Admin Corporate client management
      public final static String AdminSystem_Corporate_Clientstatus="//select[@id='Types']";
      public final static String Admin_Sys_CorpVerify="(//div[@class='dataTables_wrapper dt-bootstrap4 no-footer']//tr//td)[7]";
      public final static String AdminSystem_Corporate_Searchbtn="//button[@id='btnSearch']";

      //Admin system management Daily transfered record
      public final static String Admin_DistRecordoftransferlink ="//a[@id='lnkTransferRequestsHistory2']";
      public final static String Admin_DistRecordoftransferPageHeader ="//h6[text()='Daily Transfer Record']";
      public final static String AdminSys_Distri_recordsearchtbRnoData="//tr//td[2]";
      public final static String AdminSys_Distri_record_Recnum="//input[@id='RequestNo']";
      public final static String AdminSys_Distri_Reqd="//input[@id='Date']";
      public final static String AdminSys_Distri_Reqyear="//select[ @title='Change the year']";
      public final static String AdminSys_Distri_ReqMon="//select[@title='Change the month']";
      public final static String AdminSys_Distri_Recond="//input[@id='ReconciledDate']";
      public final static String AdminSys_Distri_Recon_Toyear="//select[@title='Change the year']";
      public final static String AdminSys_Distri_Recon_Tomon="//select[@title='Change the month']";
      public final static String Admin_DistribtiontranferRecordTextBoxes ="//input[@type='text']";

      //public final static String AdminSys_Distri_Recon_Fromdclick="//select[@title='Change the month']";
      public final static String AdminSys_Distri_Requeststatus="//select[@id='BulkTransferRequestStatuses']";
      public final static String AdminSys_Distri_Transferstatus="//select[@id='BulkTransferRequestBillerStatuses']";
      public final static String AdminSys_Distri_recordsearchbtn="//button[text()='Search']";
      public final static String AdminSys_Distri_recordsearch_verify="(//div[@id='tblTransferRequestsHistory_wrapper']//tr//td)[2]";
   	  public static String Admin_ClickNationalityName ="//select[@id='NationalityId']";
  
   
     public final static String Admin_CorpMGMSettingBtn ="//table[@id='dtCompanies']//tr[1]/td[9]/a";
     public final static String Admin_CorpMGMSuspendRadioBtn ="(//div[@class='custom-control custom-radio'])[1]";
     public final static String Admin_CorpMGMSuspendBtn ="//input[@id='AccountStatusId_1100']";
     public final static String Admin_CorpMGMSuspendPermanentyBtn ="//input[@id='AccountStatusId_1101']";
     public final static String Admin_CorpMGMSuspendReasonDrop="//span[@class='select2-selection select2-selection--multiple']";
     public final static String Admin_CorpMGMSuspendReason="(//li[@class='select2-results__option'])[1]";
     public final static String Admin_CorpMGMSuspendYesBtn ="//button[@id='btnConfirmSetting']";
     public final static String AdminSystem_Corporate_Accountstatuserrormsg="//span[text()='Please choose a proper action']";
     public final static String AdminSystem_Corporate_SuspendReasonerrormsg="//span[@id='Reason-invalid']";
     public final static String AdminSystem_Corporate_cancelbtn="//button[@id='btnCancelSetting']";
 
      // public final static String Admin_CorpMGMSettingBtn ="//table[@id='dtCompanies']//tr[1]/td[9]/a";

//client Payables Incoming Bills Page
       public final static String ClientIncomingBills ="//h3[text()='Incoming Bills']";
       public final static String ClientPayablesMenu ="//a[@class='nav-link dropdown-toggle active collapsed']";
       public final static String ClientsIncomingBillsBillnumber1 ="(//a[@title='View Bill Details'])[1]";
       public final static String ClientsIncomingBillPrintBtn ="//button[@id='btnPrintInvoice']";
//Client Payables Installments bills page
      public final static String Client_Payables_InstallmentsPage_verify="//h3[text()='Installment Bills']";
      public final static String Client_Payables_InstallmentsPage_lnk="//a[@id='lnkCustomerInvoices2']";
      public final static String Client_Payables_Installments_Contractnum="//input[@id='InvoiceNo']";
      public final static String Client_Payables_Installments_billername="//input[@id='billerName']";
      public final static String Client_Payables_Installments_Search="//button[text()='Search']";
      public final static String Client_Payables_Installments_Contract_Verify="//div[@id='tblBillList_wrapper']//tr/td[1]";

 
   //Client Payables Installments bills page

      
       public final static String Client_Payables_Installments_Contract_Click="//td/a";
       public final static String ClientsPayables_InstallmentsGrid ="//table[@id='tblBillList']";

      //Client IncomingBills
       public final static String ClientPayablesIncomingBillsGrid="//div[@id='tblBillList_wrapper']";

       public final static String ClientsPayablesIncomingBillsBTN ="//a[@id='lnkIncomingBillsList2']";
       public final static String ClientsPayablesIncomingBills_Header ="//h3[text()='Incoming Bills']";
       public final static String ClientsPayablesInvoiceNumberTextField ="//input[@name='billNo']";
       public final static String ClientsPayablesBillerNameDropdown ="//select[@id='billerId']";
       //public final static String ClientsPayablesBillerNameDropdown ="//select[@data-val-number='The field BillerId must be a number.']";
       public final static String ClientsPayablesPaymentStatusDropdown ="//select[@id='IsPaid']";
       public final static String ClientsPayablesIncomingBillSerach ="//button[@class='btn btn-primary w-100 w-md-auto']";
       public final static String ClientsPayablesIncomInvoiceDetailsText ="//h3";
       public final static String ClientsPayablesIncomInvoiceDetailsHeader ="//h3[text()='Invoice Details']";
       public final static String ClientsPayablesIncomingBillsPay="//a[text()='Pay']";
       public final static String ClientsPayablesIncomingBills_Sadad_Link="//a[@id='lnkSadad']";
       public final static String ClientsPayablesIncomingBills_Mada_Link="//a[@id='MADALnk']";
       public final static String ClientsPayablesIncomingBills_Visa_Link="//a[@id='VISALnk']";
       public final static String ClientsPayablesIncomingBills_MasterCard_Link="//a[@id='MASTERLnk']";
       public final static String ClientsPayablesIncomingBills_ApplePay_Link="//a[@id='ApplePayLnk']";
       public final static String ClientsPayablesIncomingBillsPaysadad="//a[@id='lnkSadad']";
       public final static String ClientsPayablesIncomingBillsfollowpay="//button[@id='btnConfirmSadad']";
       public final static String ClientsPayablesIncomingBillspayverify="//label[@id='hSubTitle']";
       //public final static String ClientsPayablesIncomInvoiceDetailsText ="//h3[contains(text(),'Invoice')]";

       public static final String ClientAccountStatementtext = "//h3[text()='Client Account Statement']";
	   public static final String Client_ClientAccountStatementMenu = "//a[@id='lnkCustomerClearanceReport']";
	   public static final String Client_ClientAccountStatement_BillerName = "//select[@id='BillerId']";
	   public final static String Client_ClientAccountStatement_Fromyear = "//select[@title='Change the year']";
	   public final static String Client_ClientAccountStatement_FromDate = "//input[@id='FromDate']";
	   public final static String Client_ClientAccountStatement_FromMonth = "//select[@title='Change the month']";
	   public final static String Client_ClientAccountStatement_ToMonth = "//select[@title='Change the month']";
	   public final static String Client_ClientAccountStatement_Toyear = "//select[@title='Change the year']";
	   public final static String Client_ClientAccountStatement_TODate = "//input[@id='ToDate']";
	   public static final String Client_ClientAccountStatement_InvoiceContactfield = "//input[@id='InvoiceNumber']";
	   public static final String Client_ClientAccountStatement_SearchBtn = "//button[text()='Search']";
	   public static final String Client_ClientAccountStatement_FromerrorMsg = "//span[@id='FromDate-error' and text()='This Field Is Required']";
	   public static final String Client_ClientAccountStatement_ToerrorMsg = "//span[@id='ToDate-error' and text()='This Field Is Required']";
	   public static final String Client_ClientAccountStatement_BillernameerrorMsg = "//span[@id='BillerId-error' and text()='This Field Is Required']";
	  //public static final String Client_ClientAccountStatement_Reportclientname = "//div[text()='client test']";
	  //public static final String Client_ClientAccountStatement_Reportclientname = "//div[text()='عميل فرد']";
	  //public static final String Client_ClientAccountStatement_Reportclientname = "//div[text()='test2023']";
	   public static final String Client_ClientAccountStatement_Reportclientname = "//div[text()='clientOne EdaatTest']";
	   public static final String Client_reportFrame = "//iframe[@src='/ReportViewerWebForm.aspx']";
	   

       
       //Client Footer Links
       public final static String ClientLoginAboutEdaatLink="//a[text()='About Edaat']";
       public final static String ClientLoginAboutEdaatText="//img[@class='w-100 fit-contain img-en']";
       public final static String ClientLoginOurServicesLink="//a[text()='Our Services']";
       public final static String ClientLoginOurServicesEdaatFeaturesTXT="//h1[@class='display-4 text-primary mt-3 aos-init aos-animate']";
       public final static String ClientLoginOurClientsLink="//a[text()='Our Clients']";
       public final static String ClientLoginOurClientsTXT="//h1[text()='Our Clients']";
       public final static String ClientLoginAZMFintechLink="//a[text()='About AZM Fintech']";
       public final static String ClientLoginBillInquiryLink="//a[text()='Bill Inquiry']";
       public final static String ClientLoginEnterInvoiceNumTXT="//p[text()='Enter Invoice Number']";
       public final static String ClientLoginClientRegistrationLink="//a[text()='Client Registeration']";
       public final static String ClientLoginNewClientRegistrationTXT="//h5[text()='New Client Registration']";
       public final static String ClientLoginBillerRegistrationLink="//a[text()='Biller Registeration']";
       public final static String ClientLoginNewBillerRegistrationTXT="//h5[text()='New Biller Registration']";
       public final static String ClientLoginContactUSLink="//a[text()='Contact Us']";
       public final static String ClientLoginContactusTXT="//h2[@class='h2 h2-responsive text-primary font-weight-bold animated slideInDown']";
       public final static String ClientLoginFAQLink="//a[text()='FAQ']";
       public final static String ClientLoginFAQ_TXT="//h2[@class='h2 h2-responsive text-dark font-weight-bold mt-4 animated slideInDown']";
       public final static String ClientLoginTermsandConditionLink="//a[text()='Terms and Conditions']";
       public final static String ClientLoginTermsandConditionTXT="//h2[@class='h2 h2-responsive text-dark font-weight-bold mt-4 animated slideInDown']";
       public final static String ClientLoginPrivacyandPolicyLink="//a[text()='Privacy Policy']";
       public final static String ClientLoginPrivacyandPolicyTXT="//h2[@class='h2 h2-responsive text-dark font-weight-bold mt-4 animated slideInDown']";
       
       
   

       //Biller Receivable Report OverDue
       public static final String Biller_OverDueBillsReport = "//a[@id='lnkBillsDelayedReport2']";
       public static final String Biller_OverDueBillsReportClientType = "//select[@id='ClientTypeId']";
       public static final String Biller_OverDueBillsReportClientName = "//span[@id='select2-ClientId-container']";
       public static final String Biller_OverDueBillsReportSubBillerType = "//select[@id='SubBillerType']";
       public static final String Biller_OverDueBillsReportSubBillerName = "//span[@id='select2-InterpriseSubBillerId-container']";
       public static final String Biller_OverDueBillsGenerateReportBTN = "//button[@id='btnSearch']";
       public static final String Biller_OverDueBillClientNameinReport = "//div[text()='client 1 client 1 client 1']";
       public static final String Biller_OverDueBillsReportFrame = "//iframe[@src='/ReportViewerWebForm.aspx']";
       public static final String Biller_OverDueBillsReportclientNameTxtField = "//input[@class='select2-search__field']";
       
       public final static String Biller_AR_LoginBtn="//a[@class='btn btn-accent1']";
  	 public final static String Biller_Login_ChangeLanguage="(//a[@id='English'])[2]";
	   
       public final static String Biller_Trackedbiller="//input[@type='search']";
       public final static String Biller_clientinvoicebtn="(//a[text()='Clients Invoices Report'])[4]";
       public final static String Biller_frameclientinvoice="//table[@id='ReportViewer1_fixedTable']";
       public final static String Biller_clientinvoice="//div[text()='Clients Invoices Report']";
	
	 //Biller Receivable Report super biller OverDue
       public static final String Biller_SuperBillerOverDueBillsReport = "//a[@id='lnkBillsDelayedReport2']";
       public static final String Biller_SuperBillerOverDueBillsReportClientName = "//span[@id='select2-ClientId-container']";
       public static final String Biller_SuperBillerOverDueBillsReportSubBillerType = "//select[@id='SubBillerType']";
       public static final String Biller_SuperBillerOverDueBillsReportSubBillerName = "(//span[@role='combobox'])[3]";
       public static final String Biller_SuperBillerOverDueBillsGenerateReportBTN = "//button[@id='btnSearch']";
       public static final String Biller_SuperBillerOverDueBillClientNameinReport = "//div[text()='client 1 client 1 client 1']";
       public static final String Biller_SuperBillerOverDueBillsReportFrame = "//iframe[@src='/ReportViewerWebForm.aspx']";
       public static final String Biller_SuperBillerOverDueBillsReportclientNameTxtField = "(//span[@role='combobox'])[1]";
       public static final String Biller_SuperBillerOverDueBillesTrackedBiller = "//input[@class='select2-search__field']";
       public static final String Biller_SuperBillerOverDueBillsReportClientType = "//select[@id='ClientTypeId']";
       public static final String Biller_SuperBillerOverDueBillsReportPage = "(//a[@href='/SuperReport/ClientDelayedBillsReport'])[2]";
       
       
       
       
       //Receivable reports for super biller Sadad payments
       public static final String Biller_SadadPaymentsReportLink = "//a[@id='lnkSadadPaymentsTransactionsTrackReport2']";
       public static final String Biller_SadadReportInvoiceType= "//select[@id='InvoiceTypeId']";
       public static final String Biller_SadadReportInvoiceNo= "//input[@id='InvoiceNumber']";
       public static final String Biller_SadadReportClientType= "//select[@id='ClientTypeId']";
       public static final String Biller_SadadReportTrackerBiller= "//ul[@class='select2-selection__rendered']";
       public static final String Biller_SadadReportClientName= "//span[@id='select2-ClientId-container']";
       public static final String Biller_SadadReportSearchBtn= "//button[@id='btnSearch']";
       public static final String Biller_SadadReportVerify= "//div[text()='Sadad Payment Transactions Report']";
       public static final String Biller_FromDateCalendar= "//input[@id='FromDate']";
       public static final String Biller_ToDateCalendar= "//input[@id='ToDate']";
       public static final String Biller_Products= "//span[@id='select2-ProductId-container']";

     
   //Client My account Update Client Login Info save
     public final static String ClientMyAccUpdateLoginInfo="//a[@id='UpdateCustomerLoginInfo2']";
     public final static String ClientLogininfoOldPassword="//input[@id='OldPassword']";
     public final static String ClientLogininfoNewPassword="//input[@id='NewPassword']";
     public final static String ClientLogininfoConfirmPassword="//input[@id='ConfirmPassword']";
     public final static String ClientLogininfoSaveBtn="//input[@id='btnAdd']";
     public final static String ClientLogininfoCancelBtn="//a[text()='Cancel']";
     public final static String ClientLogininfoyesbtn="//button[text()='Yes']";
     public final static String ClientLogininfoSave_Verify="//h5[contains(text(),'updating')]";
     public final static String ClientLogininfoOldPasswordError="//span[@id='OldPassword-error']";
     public final static String ClientLogininfoNewPasswordError="//span[@id='NewPassword-error']";
     public final static String ClientLogininfoConfiPasswordError="//span[@id='ConfirmPassword-error']";
     public final static String ClientLogininfoOldPasswordInvalid="//span[@id='oldpasswordCustomError']";
     
   //Biller login footer
   //public final static String Biller_loginverify="//h5[text()='Login']";
   // public final static String Biller_About_Edaat="//a[text()='About Edaat']";
   //	 public final static String Biller_About_verify="//img[@class='w-100 fit-contain img-en']";
   	 public final static String Biller_OurService="//a[text()='Our Services']";
   	 public final static String Biller_OurService_verif="//a[text()='Our Services']";
   	 public final static String Biller_OurClient="//a[text()='Our Clients']";
   	 public final static String Biller_OurClient_verif="//h1[text()='Our Clients']";
   	 public final static String Biller_fintech="//a[text()='About AZM Fintech']";
   	 public final static String Biller_Enquiry="//a[text()='Bill Inquiry']";
   	 public final static String Biller_Enquiry_verif="//h3[text()='Invoice Details']";
   	 public final static String Biller_Clientreg="//a[text()='Client Registeration']";
   	 public final static String Biller_Clientreg_verif="//h5[text()='New Client Registration']";
   	 public final static String Biller_Clientreg_cancel="//a[text()=' Cancel']";
   	 public final static String Biller_Clientreg_yescancel="//a[text()='Yes Cancel']";
   	 public final static String Biller_registerlnk="//a[text()='Biller Registeration']";
   	 public final static String Biller_registerlnk_verif="//h5[text()='New Biller Registration']";
   	 public final static String Biller_ContactUs="//a[text()='Contact Us']";
   	 public final static String Biller_ContactUs_verif="//a[text()='Contact Us']";
   	 public final static String Biller_FAQ_link="//a[text()='FAQ']";
   	 public final static String Biller_FAQ_Verify="//h2[contains(text(),'Frequently Asked Questions')]";
   	 public final static String Biller_Tearms_link="//a[text()='Terms and Conditions']";
   	 public final static String Biller_Tearms_Verify="//h2[contains(text(),'Terms and Conditions')]";
   	 public final static String Biller_Priavcy_link="//a[text()='Privacy Policy']";
   	 public final static String Biller_Priavcy_verify="//h2[contains(text(), 'Privacy Policy')]";

   	 //Biller settings term management
   	 public final static String Biller_Setting_termMgm_deletebtn_verify="//h5[contains(text(),'Are you exactly who deleted this term?')]";
   	 public final static String Biller_Setting_termMgm_deleteyes="//button[text()='Yes, Delete']";
   	 public final static String Biller_Setting_termMgm_after_delete="//td[text()='No data available in table']";
   	 public final static String Biller_Setting_termMgm_deleteBtn="(//a[@class='mx-1 action bg-danger deleteItem'])[1]";
      
   	//Biller Settings my account Notification Send email toggle
   	// public final static String Biller_MyAccount_sendEmail_togglebtn="(//table[@id='tblNotifications']//tr[2]//td)[3]";
   	 public final static String Biller_MyAccount_sendEmail_togglebtn="(//label[@class='mb-0'])[2]";
   	 public final static String Biller_MyAccount_sendEmail_CancelActive_verify="//h5[text()='Cancel activation?']";
   	 public final static String Biller_MyAccount_sendEmail_CancelActive_yesbtn="//button[text()='Yes']";
   	 public final static String Biller_MyAccount_sendEmail_ConfirmActive_verify="//h5[text()='Confirm activation?']";
   	 public final static String Biller_MyAccount_sendEmail_ConfirmActive_yesbtn="//button[text()='Yes']";

   	 //Biller Receivables report for super biller client account statement
   	//public final static String Biller_ReportsMenu="//a[@id='lnkMyReports']";
   // public final static String Biller_Recevible_ReportMenu="//a[@id='refReceiptsSub22']";
   // public final static String Biller_Recevible_ReportSuperBiller="//a[@id='lnkSuperBillerReports2']";
    public final static String Biller_Recevible_ReportSuperBillerCorporateClient="//a[@id='lnkAggregatorBillersTrackReport2']";
    public final static String Biller_Rece_ReportSupBillerCorpoTrackBillName="//input[@class='select2-search__field']";
    public final static String Biller_Rece_ReportSupBillerGenerateReportBTN="//button[@id='btnSearch']";
    public final static String Biller_SuperBillerCorporateClientframe="//iframe[@src='/ReportViewerWebForm.aspx']";
    public final static String Biller_SuperBillerCorporateReportClientText="//div[text()='Corporate Clients List']";
   
    public final static String Biller_Recevible_ReportSuperBiller="//a[@id='lnkSuperBillerReports2']";
    public final static String Biller_Recevible_ReportSprBiler_ClientAccount="//a[@id='lnkCustomerAccountTrack2']";
    public final static String Biller_ReportSuper_ClientAccount_ClientType="//select[@id='ClientTypeId']";
    //(//option[text()='Corporate'])[1]
    public final static String Biller_ReportSuper_ClientAccount_TrackedBiller="//input[@class='select2-search__field']";
    //li[text()='Happy1'] 
    public final static String Biller_ReportSuper_ClientAccount_subBiller_type="//select[@id='SubBillerType']";
    public final static String Biller_ReportSuper_ClientAccount_subBiller_name="//span[@id='select2-SubBillerId-container']";
   //span[text()='star']
    public final static String Biller_ReportSuper_ClientAccount_search="//button[text()=' Search']";
    public final static String Biller_ReportSuper_ClientAccount_Client="//span[text()='- Select Client Name -']";
    public final static String Biller_Rcv_superbilr_ClientAccount_Fromdate="//input[@id='Date']";
    public final static String Biller_Rcv_superbilr_ClientAccount_Fromyear="//select[ @title='Change the year']";
    public final static String Biller_Rcv_superbilr_ClientAccount_FromMon="//select[@title='Change the month']";
    public final static String Biller_Rcv_superbilr_ClientAccount_Todate="//input[@id='ReconciledDate']";
    public final static String Biller_Rcv_superbilr_ClientAccount_Toyear="//select[@title='Change the year']";
    public final static String Biller_Rcv_superbilr_ClientAccount_Tomon="//select[@title='Change the month']";

   
 	//Biller receivable reports Custom Reconciliation Report
	public static final String Biller_CustomReconciliationReport = "//a[@id='lnkCustomReconciliationReport2']";  
    //over due report
    public final static String Admin_Clienttypedrop="//select[@id='ClientTypeId']";
    public final static String Admin_ClientNamedrop="(//span[@role='combobox'])[1]";
   // public final static String Admin_Subbillerdrop="(//span[@role='combobox'])[2]";
    public final static String Admin_GenerateReportbtn="//button[@id='btnSearch']";
	public static final String Admin_Subbillerdrop = "(//span[@role='combobox'])[2]";
	public static final String Admin_Overduebills = "(//a[text()='Over Due Bills Report'])[2]";
	public final static String Admin_ReceClientName="(//li[@role='treeitem'])";
	public final static String Admin_ReceSubbillerName="(//li[@role='treeitem'])";
	public final static String Admin_Receframe="//iframe";
    public final static String Admin_ReportsOverDueBills="//div[text()='Over Due Bills Report']";
	//Admin saded
	public final static String Admin_ReceSadedPaymentRpt="(//a[text()='Sadad Payments Transactions Report'])[2]";
	public final static String Admin_ReceInvoiceType="(//select[@id='InvoiceTypeId'])";
	public final static String Admin_ReceInvoiceNumber="//input[@id='InvoiceNumber']";
	public final static String Admin_ReceInviceinternalcode="//input[@id='InvoiceInternalCode']";
	public final static String Admin_ReceClienttype="//select[@id='ClientTypeId']";
	public final static String Admin_ReceviableClientName="(//span[@role='combobox'])[1]";
	public final static String Admin_Receviableproducts="(//span[@role='combobox'])[2]";
	public final static String Admin_ReceviableClientNameclick="(//li[@role='treeitem'])";
	public final static String Admin_Receviableproductsclick="(//li[@role='treeitem'])";
	public final static String Admin_ReceSabGenBtn="//button[@id='btnSearch']";
	
	
   
    public final static String Admin_MyAccount_Menu="//a[@id='ulNotificationTypeList']";
    public final static String Admin_TermsNameEng="//th[text()='Term Name in English']";
    public final static String Admin_TermsNameAr="//tr/th[text()='Term Name in Arabic']";

    public final static String Admin_MyAccount_NotificationSettings="//a[@id='lnkNotificationTypeList']";
    public final static String Admin_MyAccount_SendEmailToggelBTN="//input[@id='2']";
    public final static String Admin_MyAcc_SendEmailToggelConfirmCancelActivation="//button[@id='btnConfirmActivation']";
    public final static String Admin_MyAcc_SendSMSToggle="//input[@id='3']";
    public final static String Admin_MyAcc_SendSMSToggleConfirmMsg="//h5[text()='Confirm activation?']";
    public final static String Admin_MyAcc_SendSMSToggleCancelMsg="//h5[text()='Cancel activation?']";

 
	  
	public final static String Admin_SystmMng_BillerCategoryNameAr="//th[text()='Biller Category Name AR']";
	public final static String Admin_SystmMng_BillerCategoryNameEng="//th[text()='Biller Category Name EN']";
	public final static String Biller_Rcv_superbilr_ClientAccount_verify="//div[text()='Client Account Statement']";

    //Admin system management Wathiq Integration CR check
    
    public final static String Admin_SystemMgm_Wathiqlink="//a[@id='lnkWathiqInteg2']";
    public final static String Admin_SystemMgm_lnk="//a[@id='lnkSystemMangement2']";
    public final static String Admin_SystemMgm_Wathiq_CRCheck="//a[@id='lnkWathiqInteg_Search2']";
    public final static String Admin_SystemMgm_Wathiq_CRCheck_CRnumber="//input[@id='regNumber']";
    public final static String Admin_SystemMgm_Wathiq_CRCheck_search="//button[text()='Search']";
    public final static String Admin_SystemMgm_Wathiq_CRCheck_Verify="Admin_SystemMgm_Wathiq_CRCheck_verify";
  //Admin System management wathiq integration History details
    public final static String Admin_SystemMgm_Wathiq_History_CRnumber="//input[@id='regNumber']";
    public final static String Admin_SystemMgm_Wathiq_Historylnk="//a[@id='lnkWathiqInteg_History2']";
    public final static String Admin_SystemMgm_Wathiq_History_Header="//h6[text()='CR Number Search History']";
    public final static String Admin_SystemMgm_Wathiq_CR_Header="//h6[text()='CR Check']";
    public final static String Admin_SystemMgm_Wathiq_History_search="//button[text()='Search']";
    public final static String Admin_SystemMgm_Wathiq_History_Fromdate="//input[@id='from']";
    public final static String Admin_SystemMgm_Wathiq_History_Fromyear="//select[ @title='Change the year']";
    public final static String Admin_SystemMgm_Wathiq_History_FromMon="//select[@title='Change the month']";
    public final static String Admin_SystemMgm_Wathiq_History_Todate="//input[@id='to']";
    public final static String Admin_SystemMgm_Wathiq_History_Toyear="//select[@title='Change the year']";
    public final static String Admin_SystemMgm_Wathiq_History_Tomon="//select[@title='Change the month']";
    public final static String Admin_SystemMgm_Wathiq_History_verify="(//div[@class='card-body table-responsive']//tr//td)[2]";

    //Admin API Document
    public final static String Admin_API_Document="//h6[text()='API Document']";
    public final static String Admin_API_lnk="//a[@id='ApiDocument']";
    public final static String Admin_API_Download="//a[@class='btn-file mt-auto text-center w-100']";
    
  
	   //Admin Clients Report
	   public final static String Admin_ReceivablesReports_ClientInvoice_Fromdate="//input[@id='FromDate']";
	    public final static String Admin_ReceivablesReports_ClientInvoice_Fromyear="//select[ @title='Change the year']";
	    public final static String Admin_ReceivablesReports_ClientInvoice_FromMon="//select[@title='Change the month']";
	    public final static String Admin_ReceivablesReports_ClientInvoice_Todate="//input[@id='ToDate']";
	    public final static String Admin_ReceivablesReports_ClientInvoice_Toyear="//select[@title='Change the year']";
	    public final static String Admin_ReceivablesReports_ClientInvoice_Tomon="//select[@title='Change the month']";
	    public final static String Admin_ReceivablesReports_ClientInvoice_ClientType="//select[@id='ClientTypeId']";
	    public final static String Admin_ReceivablesReports_ClientInvoice_ClientName="//span[@id='select2-ClientId-container']";
	    public final static String Admin_ReceivablesReports_ClientInvoice_Clienttext="//input[@class='select2-search__field']";
	  //li[text()='CorporateTwo']
	    public final static String Admin_ReceivablesReports_ClientInvoice_Billstatus="//span[@id='select2-BillStatusCode-container']";
	  //li[text()='Partially Paid']
	    public final static String Admin_ReceivablesReports_ClientInvoice_SubBillerName="//span[@id='select2-SubBillerId-container']";
	  //li[text()='شركة جديدة']
	    public final static String Admin_ReceivablesReports_ClientInvoice_Generate="//button[text()='Generate Report']";
	    public final static String Admin_ReceivablesReports_ClientInvoice_ID_CR="//input[@id='ClientRefNumber']";
	    public final static String Admin_ReceivablesReports_ClientInvoice_ExportExcel="//button[@id='btnExport']";
	    public final static String Admin_ReceivablesReports_ClientInvoice_Exportverify="//span[@id='spnUnderProcessing']";
	    public final static String Admin_ReceivablesReports_ClientInvoice_reportbtn="//a[@id='lnkExportedInvoicesReport2']";
	    public final static String Admin_ClientNamearro = "(//span[@class='select2-selection__arrow'])[1]";
	    public final static String Admin_ClientNametextbox= "//input[@type='search']";
	    public final static String Admin_ClientNameoption= "//ul[@role='tree']/li[1]";
	    //Admin Receivables Sub Biller Reports
	    public final static String Admin_Receivables_SubBillerReportLink="//a[@id='lnkSubBillersInfoReport2']";   
	    public final static String Admin_Receivables_SubBillerCRNumber="//input[@id='RegistrationNumber']";    
	    public final static String Admin_Receivables_SubBillerGenerateReport="//button[@id='btnSearch']";    
		 public final static String Admin_Receivables_Corporate_Report="//iframe";
	    
	    
	    
	    //Admin Reports Receivable Reports Client Invoice
	    public final static String Admin_Receivables_Reports="//a[@id='refReceiptsSub22']";
	    public final static String Admin_Receivables_Corpo_ClientReports="//a[@id='lnkBillerCompanyClientsReport']";
	    public final static String Admin_Receivables_CorpoClientFrame="//iframe[@src='/ReportViewerWebForm.aspx']";
	    public final static String Admin_Receivables_CorpoClientListTXT="//div[text()='Corporate Clients List']";
	       
	    //Admin settings content management
	    public final static String Admin_settings="//a[@id='lnkMySettings']";
	    public final static String Admin_settings_Contentmgm="//a[@id='lnkContentManagement2']";
	    public final static String Admin_settings_ContentAttach="//span[text()='Attach Excel File']";
	    public final static String Admin_settings_ContentAttach_process="//button[@id='btnProcessingExcelFile2']";
	    public final static String Admin_settings_PaidOusideBillsAttach_process="//button[@id='btnProcessingExcelFile']";
	    public final static String Admin_settings_ContentAttach_verify="//span[@id='spnUnderProcessing']";
	    public final static String Admin_settings_ContentAttachErrorMsg="//span[@id='spnFailedProcessing']";
	    public final static String Admin_settings_PaidOutsideEdaatPage="//a[@id='lnkPayCashBills2']";
	    
	    
	  //Admin Payables incoming bills 
		public final static String Admin_IncomingBillsPage = "//h6[text()='Incoming Bills']";
		public final static String Admin_PayablesMenu = "//a[@id='lnkPayments2']";
    	public final static String Admin_IncomingBillsLink = "//a[@id='lnkIncomingBillsList2']";
		public final static String Admin_IncomingBillsBillerName = "//tr[1]//th[text()='Biller Name']";
		public final static String Admin_IncomingBillsBillerID= "//tr[1]//th[text()='Biller ID']";
		public final static String Admin_IncomingBillsInvoiceStatus= "//tr[1]//th[text()='Invoice Status']";
	
		
		public final static String Admin_Payables_IncomingBillNumber= "//input[@id='billNo']";
		public final static String Admin_Payables_IncomingBillerName= "//input[@id='billerName']";
		public final static String Admin_Payables_IncomingContractNumber= "//input[@id='InvoiceNo']";
		public final static String Admin_Payables_IncomingBillsearch= "//button[text()=' Search']";
		public final static String Admin_Payables_IncomingBillsVerify= "//tr//td[4]";
		//  Admin Terms Managent
    
    public final static String Admin_Termsmanagementsym="//h6[text()='Terms Management']";
    public final static String Admin_SettingsMenu = "//a[@id='lnkMySettings']";
    public final static String Admin_Terms_menu="//a[@id='lnkTermList2']";
    public final static String Admin_Terms_Delete_Button="(//a[contains(@class,'deleteItem')])[1]";
    public final static String Admin_Terms_NoDataText="//td[text()='No data available in table']";
  	public final static String Admin_AddTerm_Btn="//button[@id='btnAddTerm']";
	public final static String Admin_TermName_Arabic="//input[@id='NameAr']";
	public final static String Admin_TermName_ENG="//input[@id='NameEn']";
	public final static String Admin_TermText_Arabic="//textarea[@id='DescriptionAr']";
	public final static String Admin_TermText_Eng="//textarea[@id='DescriptionEn']";
	public final static String Admin_TermToggle="//label[@for='status']";
	public final static String Admin_TermSave_BTN="//button[text()='Save']";
	public final static String Admin_TermTXT_Field="//input[@id='TermName']";
	public final static String Admin_Term_SearchBTN="//button[text()='Search']";
	public final static String Admin_TermStatusToggle="(//input[@class='switch'])[1]";
	public final static String Admin_TermConfirmBTN="//button[@id='btnConfirmActivation']";
	public final static String Admin_TermNoDataAvilableTxt="//td[text()='No data available in table']";
	public final static String Admin_Terms_DeleteconfirmBTN="//button[@id='btnConfirmDelete']";
    public final static String Admin_TermMngConformActive="//h5[text()='Confirm activation?']";

	
	// Admin Biller Categories Management
	  public final static String Admin_BillerCategoryViewBTN="//a[@onclick='ViewBillerCategory(this)']";
	  public final static String Admin_BillerCategory ="//h6[text()='Biller Category']";
	  public final static String Admin_SystmMng_BillerCategory ="//a[@id='lnkBillerCategory2']";
	  public final static String Admin_SystmMng_BillerCategoryNodata ="//td[text()='No data available in table']";
	  public final static String Admin_SystmMng_BillerCategorysrcfield="//input[@id='BillerCategoryName']";
	  public final static String Admin_SystmMng_BillerCategorysrcbtn="//button[@id='btnSearch']";
	  public final static String Admin_SystmMng_BillerCategoryaddbtn="//button[@id='btnAddBillerCategory']";
	  public final static String Admin_SystmMng_BillerCategoryARfield="//input[@id='CategoryNameAR']";
	  public final static String Admin_SystmMng_BillerCategoryENfield="//input[@id='CategoryNameEN']";
	  public final static String Admin_SystmMng_BillerCategorySavebtn="//button[text()='Add']";
	  public final static String Admin_SystmMng_BillerCategoryARErrorMsg="//span[@id='CategoryNameAR-error']";
	  public final static String Admin_SystmMng_BillerCategoryEngErrorMsg="//span[@id='CategoryNameEN-error']";
	

	//AddProduct UI
	  public final static String Biller_Settings_ProArabicNameError="//span[@id='Name-error']";
	  public final static String Biller_Settings_ProEngNameError="//span[@id='NameEn-error']";
	  public final static String Biller_Settings_ProductCategoryError="//span[@id='ServiceId-error']";
	  public final static String Biller_Settings_ProductBasePriceError="//span[@id='Price-error']";
	  public final static String Biller_Settings_ProductReferenceCodeError="//span[@id='codeCustomAlreadyUsedError']";
	  
	  //Add Discount UI
	  public final static String Biller_Settings_DiscEngNameError="//span[@id='NameEn-error']";
	  public final static String Biller_Settings_DiscArabicNameError="//span[@id='NameAr-error']";
	  public final static String Biller_Settings_DiscountPercentageError="//span[@id='Value-error']";
	  
	  //Add PriceList UI
	  public final static String Biller_Settings_PricelistArabicNameError="//span[@id='NameAr-error']";
	  public final static String Biller_Settings_PricelistEngNameError="//span[@id='NameEn-error']";
	  public final static String Biller_Settings_PricelistRatioError="//span[@id='Value-error']";
	  public final static String Biller_Settings_PricelistFromDateError="//span[@id='FromDate-error']";
	  public final static String Biller_Settings_PricelistToDateError="//span[@id='ToDate-error']";
	  public final static String Biller_Settings_PricelistRoundingRadioBTNError="//span[@id='RoundingTypeID-error']";
	  
	  //Add Terms UI
	  public final static String Biller_Settings_TermArabicNameError="//span[@id='NameAr-error']";
	  public final static String Biller_Settings_TermEngNameError="//span[@id='NameEn-error']";
	  public final static String Biller_Settings_TermTextArabicError="//span[@id='DescriptionAr-error']";
	  
	  //Content Management Validation UI
	  public final static String Biller_Settings_ContentMgmInvalidFileError="//span[@id='ExcelFile-invalid']";
	  public final static String Biller_Settings_ContentMgmSelectFileError="//span[@id='spnFailedProcessing']";
	  
	  //Settings Paid Outside UI
	  public final static String Biller_Settings_PaidOutsideEdaatSelectFileError="//span[@id='spnFailedProcessing']";
	  public final static String Biller_Settings_PaidOutsideEdaatInvalidFileError="//span[@id='ExcelFile-invalid']";
	  
	  //BillsCancelation UI
	  public final static String Biller_Settings_BillsCancelationSelectFileError="//span[@id='spnFailedProcessing']";
	  public final static String Biller_Settings_BillsCancelationInvalidFileError="//span[@id='ExcelFile-invalid']";
	  
	  //Add Invoice Template UI
	  public final static String Biller_Settings_TemplateArabicNameError="//span[@id='NameAr-error']";
	  public final static String Biller_Settings_TemplateEngNameError="//span[@id='NameEn-error']";
	  public final static String Biller_Settings_TemplateInvoiceTypeError="//span[@id='BillTypeID-error']";
	  
	  //UserMamagement UI
	  public final static String Biller_UserList_NameErrorMsg="//span[@id='NameAR-error']";
	  public final static String Biller_UserList_EmailErrorMsg="//span[@id='EMail-error']";
	  public final static String Biller_UserList_EmailExistsErrorMsg="//span[@id='emaileCustomError']";
	  public final static String Biller_UserList_PhonenoErrorMsg="//span[@id='Phone-error']";
	  public final static String Biller_UserList_GroupErrorMsg="//span[@id='groupError']";

	  public final static String Biller_GrpMgm_GrpCodeError="//span[@id='GroupCode-error']";
      public final static String Biller_GrpMgm_GrpNameEngError="//span[@id='Name-error']";
	  public final static String Biller_GrpMgm_GrpNameArbError="//span[@id='NameAr-error']";
	  public final static String Biller_GrpMgm_GrpNameEngErrorMsg="//span[@id='spn-NameError']";
	  public final static String Biller_GrpMgm_GrpNameArbErrorMsg="//span[@id='spn-NameArError']";
	  public final static String Biller_GrpMgm_GrpCodeErrorMsg="//span[@id='spn-CodeError']";
	  
	 // Receivables ReportsUI
	  public final static String Biller_Reports_Receiv_ClientAccStm_ClientTypeError="//span[@id='ClientTypeId-error']";
	  public final static String Biller_Reports_Receiv_ClientAccStm_ClientError="//span[@id='ClientId-error']";
	  public final static String Biller_Reports_Receiv_ClientAccStm_FromDateError="//span[@id='FromDate-error']";
	 // public final static String Biller_Reports_Receiv_ClientAccStm_ToDateError="//span[@id='FromDate-error']";
	  
	  //SystemManagement Ui
	   public final static String Biller_SystemMgm_Biller_BenificaryError="//span[@id='BeneficiaryName-error']";
		public final static String Biller_SystemMgm_Biller_idError="//span[@id='BillerCode-error']";
		public final static String Biller_SystemMgm_Biller_Durationerror="//span[@id='TransferDuration-error']";
		public final static String Biller_SystemMgm_Biller_CrpArbError="//span[@id='BillerAliasNameAr-error']";
		public final static String Biller_SystemMgm_Biller_CrpEngError="//span[@id='BillerAliasNameEn-error']";
		public final static String Biller_SystemMgm_Biller_BillerCatgError="//span[@id='BillerCategoryId-error']";
		public final static String Biller_SystemMgm_Biller_SuperBillerErrormsg="//span[@id='NewSuperBillerIdError']";
		public final static String Biller_SystemMgm_Biller_TransferErrormsg="//span[@id='TransferDuration-error']";
		public final static String Biller_SystemMgm_Biller_sadadfeesError="//span[@id='sadadFee-error']";
		public final static String Biller_SystemMgm_Biller_sadadfeestaxerror="//span[@id='BankRatio-error']";
		public final static String Biller_SystemMgm_Biller_Azmfeestaxerror="//span[@id='OperatorRatio-error']";
		public final static String Biller_SystemMgm_Biller_AzimfeesError="//span[@id='AzimFee-error']"; 
		public final static String Biller_SystemMgm_BillerAliasEnName="//input[@name='BillerAliasNameEn']";
		public final static String Biller_SystemMgm_BillerBeneficaryName="//input[@id='BeneficiaryName']";
		public final static String Biller_SystemMgm_BillerAliasArabicName="//input[@name='BillerAliasNameAr']";
		public final static String Biller_SystemMgm_ConfirmTrackedBiller="//button[@id='btnConfirmSetAsTrackedBiller']";
		public final static String Biller_SystemMgm_TrackedBiller="//select[@id='NewSuperBillerId']";
		public final static String Biller_SystemMgm_Biller_sadadfees="//input[@id='sadadFee']";
		public final static String Biller_SystemMgm_Biller_Azimfees="//input[@id='AzimFee']";
		
		//SystemMgm Individual Client Management
		public final static String BillerSystem_IndividualClient_Name="//input[@id='CustomerName']";
		public final static String BillerSystem_Individual_national="//input[@id='NationalID']";
		public final static String Biller_System_Individual_clientstatus="//Select[@id='Types']";
		public final static String BillerSystem_Individual_Search="//button[@id='btnSearch']";
		public final static String BillerSystem_Individual_grid="//table[@id='dtCustomers']";
		public final static String BillerSystem_Individuaul_SettingsBTN="//a[@class='mx-1 action bg-accent']";
		public final static String BillerSystem_Individuaul_SuspendradioBTN="//input[@id='AccountStatusId_1100']";
		public final static String BillerSystem_Individuaul_SettingConirmBTN="//button[@id='btnConfirmSetting']";
		public final static String BillerSystem_Individuaul_SuspendPermradioBTN="//input[@id='AccountStatusId_1101']";
		public final static String BillerSystem_Individuaul_SuspendReason="//span[@role='combobox']";
		public final static String BillerSystem_Individuaul_Accountstatuserrormsg="//span[@id='AccountClosureActions-invalid']";
		public final static String BillerSystem_Individuaul_SuspendReasonerrormsg="//span[@id='Reason-invalid']";
		public final static String BillerSystem_Individuaul_cancelbtn="//button[@id='btnCancelSetting']";
		
		//SystemMgm Corporate Client Management
		public final static String BillerSystem_Corporate_Accountstatuserrormsg="//span[@id='AccountClosureActions-invalid']";
	   	public final static String BillerSystem_Corporate_SuspendReasonerrormsg="//span[@id='Reason-invalid']";
	   	public final static String BillerSystem_Corporate_cancelbtn="//button[@id='btnCancelSetting']";
		public final static String Biller_CorpMGMSettingBtn ="//table[@id='dtCompanies']//tr[1]/td[9]/a";
	    public final static String Biller_CorpMGMSuspendRadioBtn ="(//div[@class='custom-control custom-radio'])[1]";
	    public final static String Biller_CorpMGMSuspendBtn ="//input[@id='AccountStatusId_1100']";
	    public final static String Biller_CorpMGMSuspendPermanentyBtn ="//input[@id='AccountStatusId_1101']";
	    public final static String Biller_CorpMGMSuspendReasonDrop="//span[@class='select2-selection select2-selection--multiple']";
	    public final static String Biller_CorpMGMSuspendReason="(//li[@class='select2-results__option'])[1]";
	    public final static String Biller_CorpMGMSuspendYesBtn ="//button[@id='btnConfirmSetting']";
	    public final static String Biller_SysMgmClient_CorpoclientMgmMenu="//a[@id='lnkActivateCompanies2']";
	    public final static String Biller_SymCorpoClientstatus ="//select[@id='Types']";
	    public final static String Biller_SymCorpoName ="//input[@id='CompanyName']";
	    public final static String Biller_Corporateclient_srchbtn ="//button[@id='btnSearch']";
	    
	    //System ManAgement Distribution
	    public final static String Biller_DistReason="//div[@id='ReasonError']";
	    public final static String Biller_DistDate="//div[@id='ManualDateError']";
	    public final static String Biller_DistAttachment="//div[@id='file-input-msg']";
	    public final static String Biller_Dist_EODSettlementErrorMsg="//a[@id='empty']";
	    public final static String Biller_Dist_EODSettlement="//a[@id='lnkBankTransferSettlementReport2']";
	    public final static String Biller_Dist_EODSettlementSearchbtn="//button[@id='btnSearchDate']";


	    //Client Incoming bills UI
	    public final static String Client_IncomingBills_Pay_Error="//div[@id=\"alert-error\"]";


 //Admin receivables error
	    public final static String Admin_RCV_Create_install= "//button[text()='Create Installments']";
	    public final static String Admin_RCV_IssuedateError= "//span[@id='IssueDate_Invalid']";
	    public final static String Admin_RCV_IssuedateErrorTemplate= "//span[@id='IssueDate_Invalid']";
	    public final static String Admin_RCV_IssuedateErrorCondition= "(//span[@id='Conditions-invalid'])[1]";
	    public final static String Admin_RCV_Addtaxbtn= "//a[@id='btnAddTaxModal']";
	    public final static String Admin_RCV_Addtax= "//button[@id='btnAddTax']";
	    public final static String Admin_RCV_Addtaxerror= "//span[@id='TaxId-error']";
	    public final static String Admin_RCV_Addtaxcancel= "(//button[@type='button' and text()='Cancel'])[2]";
	    public final static String Admin_RCV_Discountbtn= "//a[@id='btnAddDiscountModal']";
	    public final static String Admin_RCV_DiscountAdd= "//button[@id='btnAddDiscount']";
	    public final static String Admin_RCV_Discounterror= "//span[@id='DiscountId-error']";
	    public final static String Admin_RCV_Expiredate= "//input[@id='ExpiryDate']";
	    public final static String Admin_RCV_ExpiredateError= "//span[@id='ExpiryDate_Invalid']";
	    public final static String Admin_RCV_FromHourError= "//span[@id='Message_InvalidFromTime']";
	    public final static String Admin_RCV_FromHour= "//input[@id='FromDurationTime']";
	    public final static String Admin_RCV_ToTimeError= "//span[@id='Message_InvalidToTime']";
	    public final static String Admin_RCV_ToTime= "//input[@id='ToDurationTime']";
	    public final static String Admin_RCV_ClientType= "//div[text()='Please select client type']";
	    public final static String Admin_RCV_MaxMin= "//span[@id='MinLimit-invalid']";
	    public final static String Admin_RCV_DurationError= "//span[@id='DurationTypeId-error']";
		public final static String Admin_Invoice_ExportButton1="//button[text()='Export']";
		public final static String Admin_Invoice_CreateExport="//button[text()=' Create and export']";
		public final static String Admin_Invoice_Condition="//textarea[@id='txtConditions']";
		public final static String Admin_Invoice_ConditionError="(//span[@id='Conditions-invalid'])[1]";
		public final static String Admin_Invoice_ClientNameError="//span[@id='CustomerId-error']";
		public final static String Admin_Invoice_MinLimitError="//span[@id='MinLimit-invalid']";
		public final static String Admin_Invoice_AddtaxVerify="//span[@id='MinLimit-invalid']";

//Admin SubBiller Error  
	    public final static String Admin_SubBillerAdd= "//div[@id='alert-error']";
	    public final static String Admin_SubBillerFixedValueError= "//div[text()='Identify fixed fees']";
	    public final static String Admin_SubBillerFixedValueError2= "//span[text()='The OperationalFees field is required.']";
	    public final static String Admin_SubBillerPercentError= "//div[text()='Identify percent fees']";
	    public final static String Admin_SubBillerPercentError2= "//span[@id='OperationalFeesPercentageErrorMessage']";
	    public final static String Admin_SubBillerInvoiceAmount= "//div[text()='Identify Invoice Operation Fees']";
	    public final static String Admin_SubBillerBasedProductcheck= "//label[text()='Fees Deduction Based on Product']";
	    public final static String Admin_SubBillerSelectproductError= "//label[text()='  - Select Product -']";
	    public final static String Admin_SubBillerProductFixedPer= "//label[text()='Enter Fixed Or Percent Fees or both']";
	    public final static String Admin_SubBillerProductIbanError= "//label[@id='ProductIBANError']";
	    public final static String Admin_SubBillerProductIbanInvalid= "//label[text()='Invalid IBAN']";
	    public final static String Admin_SubBillerProductBeneficiaryError= "//label[@id='ProductBeneficiaryNameError']";
	    public final static String Admin_SubBillerProductIBanAttachError= "//span[@id='ProductIBANAttachment-invalid']";
	    public final static String Admin_SubBillerProductIBAN= "//input[@id='txtProductIBAN']";
	    public final static String Admin_SubBillerProductBeneficiary= "//input[@id='txtProductBeneficiaryName']";
	    
	    public final static String Admin_SubBillerNameError= "//span[@id='CompanyNameAr-error']";
	    public final static String Admin_SubBillerCRError= "//span[@id='RegistrationNo-error']";
	    public final static String Admin_SubBillerIBanError= "//span[@id='IBAN-error']";
	    public final static String Admin_SubBillerIBanInavlid= "//span[text()='Invalid IBAN']";
	    public final static String Admin_SubBillerBeneficiaryNameError= "//span[@id='BeneficiaryName-error']";
	    public final static String Admin_SubBillerTaxNumError= "//span[@id='VATNo-error']";
	    
	    public final static String Admin_SubBillerCityError= "//span[@id='CityID-error']";
	    public final static String Admin_SubBillerDistrictError= "//span[@id='District-error']";
	    public final static String Admin_SubBillerStreetError= "//span[@id='Street-error']";
	    public final static String Admin_SubBillerZipCodeError= "//span[@id='PostalCode-error']";
	    public final static String Admin_SubBillerBuildingNumError= "//span[@id='BuildingNo-error']";
	    public final static String Admin_SubBillerEmployeeError= "//span[@id='EmployeeName-error']";
	    public final static String Admin_SubBillerEmpEmailError= "//span[@id='EmployeeEmail-error']";
	    public final static String Admin_SubBillerEmpMblError= "//span[@id='EmployeeMobileNo-error']";
	    public final static String Admin_SubBillerIBANAttachError= "//span[@id='IBANAttachment-invalid']";
	    public final static String Admin_SubBillerCRAttachError= "//span[@id='RegistrationAttachment-invalid']";
	    
	    //Admin login
	    
	    public final static String Admin_UserNameError= "//span[@id='UserName-error']";
	    public final static String Admin_PassError= "//span[@id='Password-error']";
	    public final static String Admin_forgotpasslink= "//a[text()='Forgot password?']";
	    public final static String Admin_forgotSendbtn= "//button[@id='btnSendRequest']";
	    public final static String Admin_forgotError= "//span[@id='UserRequired']";
	
	    //client my account error
	    public final static String ClientMyaccount_= "//span[@id='UserName-error']";
	    public final static String ClientMyaccount_Firstname= "//input[@id='FirstName']";
	    public final static String ClientMyaccount_Dateofbirth= "//input[@id='DateOfBirth']";
	    public final static String ClientMyaccount_DateofbirthHijiri= "//input[@id='DateOfBirthHijri']";
	    public final static String ClientMyaccount_FirstnameError= "//span[@id='FirstName-error']";
	    public final static String ClientMyaccount_SecondnameError= "//span[@id='SecondName-error']";
	    public final static String ClientMyaccount_thirdnameError= "//span[@id='ThirdName-error']";
	    public final static String ClientMyaccount_lastnameError= "//span[@id='LastName-error']";
	    public final static String ClientMyaccount_DateofbirthError= "//span[@id='DateOfBirth-error']";
	    public final static String ClientMyaccount_DateofbirthHijiriError= "//span[@id='DateOfBirthHijri-error']";
	    public final static String ClientMyaccount_MobilenumError= "//span[@id='MobileNo-error']";
	    public final static String ClientMyaccount_birth="//a[contains(@class,'calendars-today')]";
	    public final static String ClientMyaccount_birthHijiri="//a[contains(@class,'calendars-today')]";
//	    public final static String ClientMyaccount_FirstnameError2= "//span[@id='FirstName-error']";
//	    public final static String ClientMyaccount_SecondnameError2= "//span[@id='SecondName-error']";
//	    public final static String ClientMyaccount_thirdnameError2= "//span[@id='ThirdName-error']";
//	    public final static String ClientMyaccount_lastnameError2= "//span[@id='LastName-error']";
	
	//BillerInvalid login
	  
	  public final static String Biller_InvalidloginUserName="//input[@id='UserName']";
	  public final static String Biller_InvalidloginPassword="//input[@id='Password']";
	  public final static String Biller_InvalidloginButton="//button[@id='btnlogin']";
	  public final static String Biller_InvalidloginUserError="//span[@id='UserName-error']";
	  public final static String Biller_InvalidloginUserErrors="//span[@id='UserName-error']";
	  public final static String Biller_InvalidloginPasswordError="//span[@id='Password-error']";
	  public final static String Biller_forgetlinksendbtn="//button[@id='btnSendRequest']";
	  public final static String Biller_Usernamevalidation="//span[@id='UserRequired']";
	  //Subbiller
	  public final static String Biller_MobileNovalidation="//span[text()='This Field Is Required']";
	
	  public final static String Biller_Nationalid="//span[text()='National number Exist']";
	  public final static String Biller_Invalidmobileno="//span[text()='The mobile number entered is incorrect']";
	  public final static String Biller_Invalidiban="//span[text()='Invalid IBAN']";
	  public final static String Biller_Invalidname="//span[text()='Please use only characters']";
	  public final static String Biller_InvalidNationalid="//span[text()='Please enter a 10-digit number']";
	  public final static String Biller_Fixedvaluereq="//span[text()='The OperationalFees field is required.']";
	  public final static String Biller_Ibanerror="//span[@id='IBANNoError']";
	  public final static String Biller_Nameerror="//span[@id='IndividualNameAr-error']";
	  public final static String Biller_Ibanreqerror="//span[@id='IndividualNameAr-error']";
	  public final static String Biller_Benfreqerror="//span[@id='IndividualNameAr-error']";
	  public final static String Biller_Nationalreqerror="//span[@id='IndividualNameAr-error']";
	  public final static String Biller_percentagereqerror="//span[@id='OperationalFeesPercentageErrorMessage']";
	  public final static String Biller_Fixedvaluereqerror="//div[text()='Identify fixed fees']";
	  public final static String Biller_Percentagereqerror="//div[text()='Identify percent fees']";
	  public final static String Biller_Totalamount="//div[text()='Select Operation Fees Deduction Method']";
	  public final static String Biller_Invoicefees="//div[text()='Identify Invoice Operation Fees']";
	  public final static String Biller_Carporatesym="//input[@id='CompanyNameAr']";
	  public final static String Biller_CarpNameerror="//span[text()='This Field Is Required' and @id='CompanyNameAr-error']";
	  public final static String Biller_CarpInvNameerror="//span[text()='Please use numbers and letters only' and @id='CompanyNameAr-error']";
	  public final static String Biller_CarpCrNameerror="//span[text()='This Field Is Required' and @id='RegistrationNo-error']";
	  public final static String Biller_CarpInvCrNameerror="//span[text()='Please enter a 10-digit number' and @id='RegistrationNo-error']";
	  public final static String Biller_CarpIbanerror="//span[text()='This Field Is Required' and @id='IBAN-error']";
	  public final static String Biller_CarpInvIbanerror="//span[text()='Invalid IBAN' and @id='IBAN-error']";
	  public final static String Biller_CarpBenNameerror="//span[text()='This Field Is Required' and @id='BeneficiaryName-error']";
	  public final static String Biller_CarpTaxNoerror="//span[text()='This Field Is Required' and @id='VATNo-error']";
	  public final static String Biller_CarpInvTaxNoerror="//span[text()='Please enter the number consisting of 15 digits' and @id='VATNo-error']";
	  public final static String Biller_CarpCityerror="//span[text()='This Field Is Required' and @id='CityID-error']";
	  public final static String Biller_CarpDisterror="//span[text()='This Field Is Required' and @id='District-error']";
	  public final static String Biller_CarpInvDisterror="//span[text()='Please use numbers and letters only' and @id='District-error']";
	  public final static String Biller_CarpStreeterror="//span[text()='This Field Is Required' and @id='Street-error']";
	  public final static String Biller_CarpInvStreeterror="//span[text()='Please use numbers and letters only' and @id='Street-error']";
	  public final static String Biller_CarpPoatalerror="//span[text()='This Field Is Required' and @id='PostalCode-error']";
	  public final static String Biller_CarpBuildNoerror="//span[text()='This Field Is Required' and @id='BuildingNo-error']";
	  public final static String Biller_CarpEmpNameerror="//span[text()='This Field Is Required' and @id='EmployeeName-error']";
	  public final static String Biller_CarpEmpinvNameerror="//span[text()='Please use numbers and letters only' and @id='EmployeeName-error']";
	  public final static String Biller_CarpEmpEmailerror="//span[text()='This Field Is Required' and @id='EmployeeEmail-error']";
	  public final static String Biller_CarpEmpinvEmailerror="//span[text()='Invalid email' and @id='EmployeeEmail-error']";
	  public final static String Biller_CarpEmpMobNoerror="//span[text()='This Field Is Required' and @id='EmployeeMobileNo-error']";
	  public final static String Biller_CarpEmpinvMobNoerror="//span[text()='The mobile number entered is incorrect' and @id='EmployeeMobileNo-error']";
	  public final static String Biller_CarpEmpinvIbanatcerror="//span[text()='Invalid IBAN Attachment']";
	  public final static String Biller_Carpselectproduct=" //label[text()='  - Select Product -']";
	  public final static String Biller_SelectProductvalidation="//label[text()='Please select at least one product']";
	  public final static String Biller_SelectProducterrormsg="//div[text()='You should add product with fees']";
	  public final static String Biller_entervalueerrormsg="//label[text()='Enter Fixed Or Percent Fees or both']";
	  public final static String Biller_Onlyentervalueerrormsg="//label[text()='Choose a value and/or percentage for the product']";
	  public final static String Biller_Onlyenterpercentageerrormsg="//label[text()='Please enter some percentage from 1-100']";
	  public final static String Biller_OnlyEnterpercentageerrormsg="//span[text()='Please enter some percentage from 1-100']";
	  public final static String Biller_Ibanerrormsg="//label[text()='IBAN of the product must not be the same as the sub biller IBAN']";
	  public final static String Biller_InvalidIbanerrormsg="//label[text()='Invalid IBAN']";
	  public final static String Biller_BenfNameerrormsg="//label[text()='This Field Is Required']";
	  public final static String Biller_Fixedvalue="//input[@name='OperationalFees']";
	  public final static String Biller_moveFixedvalue="//label[@for='DeductTransferFeesFromSubBiller']";
	  public final static String Biller_BenfAtachNameerrormsg="//span[text()='This Field Is Required' and @id='ProductIBANAttachment-invalid']";
	  //Receviables
	  public final static String Biller_CreateandSaveUi="//button[text()='Create and save']";
	  public final static String Biller_InvoiceduedateUi="//span[text()='This field is required' and @id='IssueDate_Invalid']";
	  public final static String Biller_InvoiceFromhourUi="//span[text()='This field is required' and @id='Message_InvalidFromTime']";
	  public final static String Biller_InvoiceTotimeUi="//span[text()='This field is required' and @id='Message_InvalidToTime']";
	  public final static String Biller_InvoiceExpiredateUi="//span[text()='This field is required' and @id='ExpiryDate_Invalid']";
	  public final static String Biller_InvoiceConditionUi="//span[text()='This field is required' and @id='Conditions-invalid']";
	  public final static String Biller_InvoiceDurationUi="//span[text()='This Field Is Required' and @id='DurationTypeId-error']";
	 public final static String Biller_Invoice_Fromyear = "//select[@title='Change the year']";
	 public final static String Biller_Invoice_Toyear = "//select[@title='Change the year']";
	 public final static String Biller_Invoice_DueDate = "//input[@id='IssueDate']";
	 public final static String Biller_Invoice_TODate = "//input[@id='ExpiryDate']";
	  public final static String Biller_Receievables_PaymentMethod = "//th[text()='Payment Method']";
	  public final static String Biller_Receievables_PaymentMethod_Savebtn = "//button[@id='savePms']";
	  public final static String Biller_Receievables_PaymentMethod_Mada = "//input[@id='pm_3' and @type='checkbox']";
	  public final static String Biller_Receievables_PaymentMethod_Visa = "//input[@id='pm_4' and @type='checkbox']";
	  public final static String Biller_Receievables_PaymentMethod_MasterCard = "//input[@id='pm_5' and @type='checkbox']";
	  public final static String Biller_Receievables_PaymentMethod_Mada_Logo = "//img[contains(@src,'Mada')]";
	  public final static String Biller_Receievables_PaymentMethod_Update_PopupHeader = "//h5[@id='exampleModalLongTitle']";
	  public final static String Biller_Receievables_PaymentMethod_Add_Btn = "//button[@id='approveEditingBtn']";
	  public final static String Biller_receivables_BillNumber = "//input[@id='billNo']";
	  public final static String Biller_receivables_SrchBtn = "//button[@id='btnSearch']";
	  public final static String Biller_receivables_SubbillerTransferNotes = "//label[text()='Sub Biller Transfer Notes']";
	  public final static String Biller_Rece_Transfer_Remark_TestArea="//textarea[@id='txtTransferRemarks']";
		
		public final static String Biller_Invoice_FromMonth = "//select[@title='Change the month']";
		public final static String Biller_Invoice_ToMonth = "//select[@title='Change the month']";
		public final static String BillerInternalcode = "//input[@id='ExpiryDate']";
		public final static String Biller_Fromhour = "//input[@id='FromDurationTime']";
		public final static String Biller_Totime = "//input[@id='ToDurationTime']";
		public final static String Biller_Selecttype = "//div[text()='Please select client type']";
		public final static String Biller_Condition = "//textarea[@id='txtConditions']";
		public final static String Biller_Product = "//div[text()='You must add at least one product']";
		public final static String Biller_terms = "//label[text()='Terms']";
		public final static String Biller_Indivbtn = "//label[@for='rdIndividual']";
		public final static String Biller_CreateIns = "//button[text()='Create Installments']";
		public final static String Biller_Invoiceduedateerrormsg = "//span[@id='IssueDate_Invalid']";
		public final static String Biller_Invoiceduration = "//input[@id='txtMinLimit']";
		public final static String Biller_Invoiceexportbtn = "//button[text()='Export']";
		public final static String Biller_Descriptiondetails = "//div[text()='Please fill in all required fields']";
		public final static String Biller_Selectclienttype = "//span[@id='CustomerId-error']";
		public final static String Biller_balanceTodate = "//div[text()='Please select To Date']";
		public final static String Biller_balanceFromdate = "//div[text()='Fill date from']";
		public final static String Biller_conctact = "//td[text()='No data available in table']";
		public final static String Biller_addtax = "//a[@id='btnAddTaxModal']";
		public final static String Biller_adddiscount = "//a[@id='btnAddDiscountModal']";
		public final static String Biller_addbutton = "//button[@id='btnAddTax']";
		public final static String Biller_adddisbutton = "//button[@id='btnAddDiscount']";
		public final static String Biller_taxerrormsg = "//span[text()='This Field Is Required' and @id='TaxId-error']";
		public final static String Biller_discounterrormsg = "//span[text()='This Field Is Required' and @id='DiscountId-error']";

		public final static String Admin_SysMgm_AprBiller_customNotes_checkBox="//input[@name='HasTransferRemarks' and @type='checkbox']";
		public final static String Admin_SysMgm_ApprovedBillers="//a[@id='lnkApprovedBillerList2']";
		public static final String Biller_CustomReconciliationReport_InvoiceAmountField = "//input[@id='ReportFields_ShowBillAmount']";
		public static final String Biller_CustomReconciliationReport_BillNumberField = "//input[@id='ReportFields_ShowBillNo']";
		public static final String Biller_CustomReconciliationReport_ContractNumberField = "//input[@id='ReportFields_ShowInvoiceNo']";
		public static final String Biller_CustomReconciliationReport_PaidAmountField = "//input[@id='ReportFields_ShowBillAmountPaid']";
		public static final String Biller_CustomReconciliationReport_FromDateField = "//input[@id='FromDate']";
		public static final String Biller_CustomReconciliationReport_ToDateField = "//input[@id='ToDate']";
		public final static String Biller_CustomReconciliationReport_FromYearField= "//select[@title='Change the year']";
		public final static String Biller_CustomReconciliationReport_FromMonthField= "//select[@title='Change the month']";
		public static final String Biller_CustomReconciliationReport_ToYearField = "//select[@title='Change the year']";
		public static final String Biller_CustomReconciliationReport_ToMonthField = "//select[@title='Change the month']";
		public static final String Biller_CustomReconciliationReport_SearchButon = "//button[@id='btnSearch']";
		public final static String Admin_ApprovedBiller_AzmFeesActivationError = "//div[@id='alert-error']";
		public static final String Biller_CustomReconciliationReport_SubBillerName_CheckBx = "//input[@id='ReportFields_ShowSubBillerName']";
		public static final String Biller_CustomReconciliationReport_TransferFees_SubBiller_CheckBx = "//input[@id='ReportFields_ShowIsTransferFeesDeductFromSubBiller']";
		public static final String Biller_CustomReconciliationReport_SubBillerShare_CheckBx = "//input[@id='ReportFields_ShowActualSubBillerShare']";

		public final static String Admin_SystemMng_PaymentMethod_PaidOutsideEnglishName="//input[@value='Paid Outside EDAAT']";
		public final static String Admin_SystemMng_PaymentMethod_SadadEnglishName="//input[@value='Sadad']";
		public final static String Admin_SystemMng_PaymentMethod_MadaEnglishName="//input[@value='MADA']";
		public final static String Admin_SystemMng_PaymentMethod_VisaEnglishName="//input[@value='Visa']";
		public final static String Admin_SystemMng_PaymentMethod_MastercardEnglishName="//input[@value='Master Card']";
		public final static String Admin_SystemMng_PaymentMethod_ApplePayEnglishName="//input[@value='ApplePay']";
		
		public final static String Admin_SystemMng_PaymentMethod_PaidOutsideArabicName="//input[@value='دفع خارج النظام']";
		public final static String Admin_SystemMng_PaymentMethod_SadadArabicName="//input[@value='سداد']";
		public final static String Admin_SystemMng_PaymentMethod_MADArabicName="//input[@value='مدى']";
		public final static String Admin_SystemMng_PaymentMethod_VisaArabicName="//input[@value='فيزا']";
		public final static String Admin_SystemMng_PaymentMethod_MasterCardArabicName="//input[@value='ماستر كارد']";
		public final static String Admin_SystemMng_PaymentMethod_ApplepayArabicName="//input[@value='ابل باي']";
		
		public final static String Admin_SystemMng_PaymentMethod_BackButton="//a[text()='Back']";
		public final static String Admin_SystemMng_PaymentMethod_Paidoutside_link="//table[@id='tblPaymentmethod']//tr[1]//td[2]/a";
		public final static String Admin_SystemMng_PaymentMethod_Sadad_link=" //table[@id='tblPaymentmethod']//tr[2]//td[2]/a";
		public final static String Admin_SystemMng_PaymentMethod_MADA_link="//table[@id='tblPaymentmethod']//tr[3]//td[2]/a";
		public final static String Admin_SystemMng_PaymentMethod_Visa_link="//table[@id='tblPaymentmethod']//tr[4]//td[2]/a";
		public final static String Admin_SystemMng_PaymentMethod_MasterCard_link="//table[@id='tblPaymentmethod']//tr[5]//td[2]/a";
		public final static String Admin_SystemMng_PaymentMethod_ApplePay_link="//table[@id='tblPaymentmethod']//tr[6]//td[2]/a";
		
		
		
		public final static String Biller_ExportContact_PaymentMethodLogo_Sadad="//img[contains(@src,'Sadad')]";
		public final static String Biller_ExportContact_PaymentMethodLogo_Mada="//img[contains(@src,'Mada')]";
		public final static String Biller_ExportContact_PaymentMethodLogo_Visa="//img[contains(@src,'Visa')]";
		public final static String Biller_ExportContact_PaymentMethodLogo_MasterCard="//img[contains(@src,'MasterCard')]";
	
		
		public final static String Biller_ExportBills_DefaultPaymentMethod="//input[@id='pm_1' and @checked and @disabled]";
		
		public final static String Admin_Systemmgmt_MinimumInvoiceAmount= "//input[@id='HasMinimumInvoiceAmount' and @type='checkbox']/parent::div";
		public final static String Admin_Systemmgmt_MinimumInvoiceAmount_textfield= "//input[@id='MinimumInvoiceAmount']";
		public final static String Dis_FileExporting_SADAD_Label= "//h6[text()='Daily File Exporting (SADAD)']";
		
		public final static String Systemmgmt_NonApproved_Selected_SadadBtn = "//input[@id='pm_2' and @type='checkbox']";
		public final static String Admin_BillerUnderActivation="//a[@id='lnkUnderApprovedBillerList2']";
	
		public static final String Biller_CustomReconciliationReport_BillNo = "//tr[@role='row']//td[2]";
		public static final String Biller_CustomReconciliationReport_CRNo = "//tr[@role='row']//td[3]";
		public static final String Biller_CustomReconciliationReport_InvoicrAmt = "//tr[@role='row']//td[4]";
		public static final String Biller_CustomReconciliationReport_PaidAmt = "//tr[@role='row']//td[5]";
		
		public static final String Admin_CustomReconciliationReport_DefineAzmFeesButton = "//input[@id=\"pm_2\"]//parent::div//following::div[1]/a[1]";
		public final static String Admin_PaymentMethodMngEditFeesFixedValueAmount="//input[@name='FixedFees']";
		public final static String Admin_PaymentMethodMngEditFeesEnglishName="//input[@id='Name']";
		public final static String Admin_PaymentMethodMngEditFeesPercentageAmount="//input[@name='FixedFeesPercentage']";
		public final static String Admin_PaymentMethodMngEditFeesSaveButton="//input[@type='submit']";
		public final static String Admin_PaymentMethodMngEditFeesFixedValueCheckbox="//label[@for='HasFixedFees']";
		public final static String Admin_PaymentMethodMngEditFeesPercentageCheckbox="//label[@for='HasFixedFeesPercentage']";
		public final static String Biller_Rece_CreateandExportButton="//button[@id='btnExportInvoice']";
		public final static String Biller_Rece_SubillerTransferNotes="//label[contains(text(),'Sub Biller Transfer Notes:')]/parent::div/p";
		public final static String Biller_ExportBills_PayedOutSideEdaatPaymentMethod="//input[@id='pm_1' and @checked and @disabled]/parent::div//label";
		public final static String Biller_ExportBills_SadadPaymentMethod="//input[@id='pm_2' and @type='checkbox']/parent::div//label";
	 
	    public final static String Biller_Payables_IncomingBills_PayButton="//table[@id='tblBillList']//tbody//tr//td[11]";
	    public final static String Biller_Payables_IncomingBills_SadadLogo="//a[@id='lnkSadad']//img";
	    public final static String Biller_Payables_IncomingBills_MadaLogo="//a[@id='MADALnk']//img";
	    public final static String Biller_Payables_IncomingBills_VisaLogo="//a[@id='VISALnk']//img";
	    public final static String Biller_Payables_IncomingBills_MasterCardLogo="//a[@id='MASTERLnk']//img";
		public final static String Biller_ExportBills_MadaPaymentMethod="//input[@id='pm_3' and @type='checkbox']/parent::div//label";
		public final static String Biller_ExportBills_VisaPaymentMethod="//input[@id='pm_4' and @type='checkbox']/parent::div//label";
		public final static String Biller_ExportBills_MasterCardPaymentMethod="//input[@id='pm_5' and @type='checkbox']/parent::div//label";
		public final static String Biller_ExportBills_ApplePaydPaymentMethod="//input[@id='pm_6' and @type='checkbox']/parent::div//label";
		public final static String Biller_ExportBills_error="//div[text()='You should select at least one payment method']";
		public final static String Admin_SystemMng_minimumInvoice_Checkbox="//input[@type='checkbox' and @name='HasMinimumInvoiceAmount']";
		public final static String Admin_SystemMng_minimumInvoice_Textbox="//input[@id='MinimumInvoiceAmount']";
		public final static String Biller_ExportBills_TransferRemarkTextArea="//textarea[@id='txtTransferRemarks']";
		public final static String Biller_DailyReconciliationReportSadad="//a[@id='lnkAggregatorDailyFileSADADReport2']";
		public final static String Admin_SystemMng_PaymentMethodMng_FeesByInvoiceAmount="//input[@value='AddNewPaymentMethodWithInvoiceAmountBasedFees']";
		public final static String Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTransMessage="//div[contains(text(),'Amount-based fees category will be canceled ,and instead transaction-based fees category will be considered')]";
		public final static String Admin_SystemMng_PaymentMethodMng_SwitchBtwTransToInvoiceMessage="//div[contains(text(),'Transaction-based fees category will be canceled ,and instead amount-based fees category will be considered')]	";
		public final static String Admin_Usermng_Viewtwofactauth="(//label[text()='Subject to Two-Factor Authentication'])[1]";
		public final static String Admin_Usermng_AddGroup_EnterHours="//input[@id='TwoFactorAuthValidForPerHour']";
		public final static String Admin_Usermng_AddGroup_SendSMS="//label[@for='SendTwoFactorAuthBySMS']";
		public final static String Admin_Usermng_AddGroup_SendEmail="//label[@for='SendTwoFactorAuthByEmail']";
		public final static String Admin_Usermng_AddGroupViewtwofactauth="(//label[text()='Subject to Two-Factor Authentication'])[2]";
		public final static String Admin_Usermng_AddGroupViewtwofactauthcheckbox="(//input[@id='HasTwoFactorAuth'])[1]";
		public final static String Admin_SystemMgm_AddMinimumInvoiceAmountCheckbox="//label[@for='HasMinimumInvoiceAmount']";
		public final static String Admin_BillerMang="//a[@id='lnkBillersManagement2']";
		public final static String Admin_BillerUnderActivationCorporateName="//label[text()='Corporate Name In English']";
		public final static String Admin_ActivationInfo="//h6[text()='Activation Info']";
		public final static String Admin_ApproveBillerMang="//a[@id='lnkApprovedBillerList2']";
		public final static String Admin_PaymentMethodMngFixedValueCheckbox="//label[@for='Has_Operational_FixedAmount']";
		public final static String Admin_PaymentMethodMngEditFixedValueCheckbox="//label[@for='HasFixedFees']";
		public final static String Admin_PaymentMethodMngFixedValueAmount="//input[@id='Operational_FixedAmount']";
		public final static String Admin_PaymentMethodMngEditFixedValueAmount="//input[@id='FixedFees']";
		public final static String Admin_PaymentMethodMngFixedValueAmountWithTax="//input[@id='Operational_FixedAmount_WithVat']";
		public final static String Admin_PaymentMethodMngEditFixedValueAmountWithTax="//input[@id='FixedFeesWithVat']";
		public final static String Admin_PaymentMethodMngPercentageCheckbox="//label[@for='Has_Operational_PercentageAmount']";
		public final static String Admin_PaymentMethodMngEditPercentageCheckbox="//label[@for='HasFixedFeesPercentage']";
		public final static String Admin_PaymentMethodMngPercentageAmount="//input[@id='Operational_PercentageAmount']";
		public final static String Admin_PaymentMethodMngEditPercentageAmount="//input[@id='FixedFeesPercentage']";
		public final static String Admin_PaymentMethodMngPercentageAmountwithTax="//input[@id='Operational_PercentageAmount_WithVat']";
		public final static String Admin_PaymentMethodMngEditPercentageAmountwithTax="//input[@id='FixedFeesPercentageWithVat']";
		public final static String Admin_PaymentMethodMngSaveButton="//input[@id='Operation_submit_btn']";
		public final static String Admin_PaymentMethodMngEditSaveButton="//input[@type='submit']";
		public final static String Admin_BillerMang_AvailablePaymentMethods="//h6[text()='Available Payment Methods']";
		public final static String Admin_BillerMang_AvailPayMeth_PaidOutsideEDAAT="//label[text()='Paid Outside EDAAT (Edaat)']";
		public final static String Admin_BillerMang_AvailPayMeth_PaidOutsideEDAAT_checkbox="//input[@id='pm_1' and @type='checkbox']";
		public final static String Admin_BillerMang_AvailPayMeth_Disabled_PaidOutsideEDAAT="//input[@id='pm_1']";
		public final static String Admin_BillerMang_AvailPayMeth_Sadad="//label[text()='Sadad (Saudi Payments)']";
		public final static String Admin_BillerMang_AvailPayMeth_Sadad_Checkbox="//input[@id='pm_2' and @type='checkbox']";
		public final static String Admin_BillerMang_AvailPayMeth_Mada="//label[text()='MADA (Hyper Pay)']";
		public final static String Admin_BillerMang_AvailPayMeth_Mada_checkbox="//input[@id='pm_3' and @type='checkbox']";
		public final static String Admin_BillerMang_AvailPayMeth_Visa="//label[text()='Visa (Hyper Pay)']";
		public final static String Admin_BillerMang_AvailPayMeth_Visa_checkbox="//input[@id='pm_4' and @type='checkbox']";
		public final static String Admin_BillerMang_AvailPayMeth_MasterCard="//label[text()='Master Card (Hyper Pay)']";
		public final static String Admin_BillerMang_AvailPayMeth_MasterCard_checbox="//input[@id='pm_5' and @type='checkbox']";
		public final static String Admin_BillerMang_AvailPayMeth_ApplePay="//label[text()='ApplePay (Hyper Pay)']";
		public final static String Admin_BillerMang_AvailPayMeth_ApplePay_checkbox="//input[@id='pm_6' and @type='checkbox']";
		public final static String Admin_BillerMang_BillerActivationSaveBtn="//input[@id='btnSave']";
		public final static String Admin_BillerMang_BillerActivationConformSaveBtn="//button[@id='btnConfirmSaveBillerInfo']";
		public final static String Admin_SystemMng_PaymentMng_YesBtn="//button[@id='btnConfirmActivation']";
		public final static String Admin_SystemMng_PaymentMng_NoBtn="//button[@id='btnConfirmActivation']//following-sibling::button";
		public final static String Admin_PaymentMng_ConfirmationPopupMessage= "//h5[text()='Confirm activation?']";
		public final static String Admin_PaymentMng_CancelPopupMessage= "//h5[text()='Cancel activation?']";
		public final static String Admin_PaymentMng_ArabicPopupMessage= "//h5[@id='payment_msg']";
		public final static String Admin_PaymentMng_ChangetoArabic= "(//a[@id='Arabic'])[2]";
		public final static String Biller_Usermng_GrpPermission_Reports="//a[@href='#_Reports']";
		public final static String Biller_Usermng_GrpPermission_RecievableReports="//a[@href='#__ReceivableReports']";
		public final static String Biller_Usermng_CustomReconciliationReport_GrpPermission="//label[contains(@data-original-title,'Custom Reconciliation Report')]";
		public final static String Biller_Receivables_ContractNumber_Textfeild="//input[@id='InvoiceNo']";
		public final static String Biller_Receivables_exportedContracts_StatusInGrid="//table[@id='tblInvoiceList']//tr[@role='row']/td[10]";
		public final static String Biller_Receivables_exportedContracts_SaveButton="//button[@id='savePms']";
		public final static String Biller_ExportedContract_PaymentMethod= "//th[@aria-label='Payment Method']";
		public final static String Biller_ExportedBills_PaymentMethod= "//th[text()='Payment Method']";
		public final static String Biller_ExportedContract_Page= "//a[@id='lnkInvoiceInstallments2']";
		public final static String Biller_PaymentMethod="//select[@id='PaymentTypeId']";
		public final static String Biller_ExportContact_PaymentMethodOptions="//select[@id='PaymentTypeId']//option";
		public final static String Admin_customReconcillation_ExportToExcelLink="//a[@id='btnExport']";
		public final static String Admin_customReconcillation_ExportedToExcelConMessage="//p[@id='spnUnderProcessing']";
		public final static String Biller_Rece_SubBiller=" //label[text()=' Sub Biller Name: ']";
		public final static String MyBills_LoginAsClientToProcessBtn="//a[contains(text(),'Login')]";
		public final static String MyBills_ClientRegistrationPage="//h5[text()='New Client Registration']";
		public final static String Biller_Rece_Reports_Custom_Rec_Report="//table[@id='tblBillerTransactions']";
		public final static String Biller_Rece_Cus_Rec_Reports_BillerName_GridColumn="//th[@aria-label='Biller Name']";
		public final static String Admin_SystemMng_editPaymentProviderName="//input[@id='VendorName']";
		public final static String Admin_SystemMng_editPaymentProviderHeader="//h6[text()='Edit Payment Provider']";
		public final static String Admin_SystemMng_editPaymentProviderCode="//input[@id='Code']";
		public final static String Admin_SystemMng_editPaymentProviderCR="//input[@id='CrNumber']";
		public final static String Admin_SystemMng_editPaymentProviderAttachements="//input[@name='attachment']";
		public final static String Admin_SystemMng_editPaymentProviderSaveButton="//input[@id='btnAdd']";
		  public final static String Admin_SystemMng_editbuttonforpaymentProvider="//a[@href='/VendorManagement/EditVendor/1']";
		public static final String Biller_CustomReconciliationReportSadad = "//a[@id='lnkAggregatorDailyFileSADADReport2']";
		public final static String Admin_SystemMng_notApprovedBiller_Searchbillername="//input[@id='Name']";
		public final static String Admin_SystemMng_notApprovedBiller_ClickOnSearch="//button[@id='btnSearch']";
		public final static String Admin_SystemMng_notApprovedBiller_EditBTN="//a[@href='/BillerManagement/BillerActivation?ID=5660&IsEdit=true']";
		public final static String Admin_SystemMng_billerAmangement="//a[@id='lnkBillersManagement2']";
		public final static String Admin_SystemMng_billerMgm_notApprovedBiller="//a[@id='lnkUnderApprovedBillerList2']";
		public final static String Admin_SystemMng_notApprovedBiller_PaidOutsideEDAAT="//input[@id= 'pm_1' and @disabled]";             
		public final static String Admin_SystemMng_notApprovedBiller_saveBtn="//input[@id='btnSave']";
		public final static String Admin_SystemMng_notApprovedBiller_ConfirmsaveBtn="//button[@id='btnConfirmSaveBillerInfo']";
		public final static String Admin_SystemMng_notApprovedBiller_AlerteError="//div[@id='alert-error']";
		public final static String Admin_PaymentMethod_AddButton="//input[@id='addTransactionBasedFeesBtn']";
		public final static String Admin_PaymentMethod_InvoiceFeesAddButton="//button[@id='addFeesBasedOnAmountBtn']";
		public final static String Admin_PaymentMethod_AddFromAmountErrorMsg="//div[text()='From (Amount) is required']";
		public final static String Admin_PaymentMethod_FixedAndPercentageErrorMsg="//div[text()='Enter Fixed Or Percent Fees or both']";
		public final static String Admin_PaymentMethod_InvoiceFromAmount="//input[@id='IA_FromAmount']";
		public final static String Admin_PaymentMethod_InvoiceToAmount="//input[@id='IA_ToAmount']";
		public final static String Admin_PaymentMethod_InvoiceAmountFreeFixedValueCheckbox="//label[@for='IA_HasFixedFees']";
		public final static String Admin_PaymentMethod_InvoiceAmountFreeFixedValue="//input[@id='IA_FixedFees']";
		public final static String Biller_ExportBills_SadadLogo="//div[@id='lnkSadad']";
		public final static String Biller_ExportBills_MadaLogo="//div[@id='MADALnk']";
		public final static String Biller_ExportBills_VisaLogo="//div[@id='VISALnk']";
		public final static String Biller_ExportBills_MasterCardLogo="//div[@id='MASTERLnk']";
		public final static String Biller_ExportedContract_Searchbtn="//button[@id='btnSearch']";
		
		public final static String Client_IncomingBillsPaymentMethodColumn="//th[text()='Payment Method']";
		public final static String Client_IncomingBillsPaymentMethodSearchDropdown="//select[@id='PaymentTypeId']";
		public final static String Client_IncomingBillsPayOption="(//th[text()='test2023']/parent::tr//td)[7]";
		public final static String Biller_DailyReconciliationReport_ReconciledDate = "//input[@id='DailyDate']";
		public final static String Biller_DailyReconciliationReport_TransferStatus = "//select[@id='InvoicePostingId']";
		public final static String Biller_ReceivableExportedBills_BillNumber = "//a[contains(@href,'billNo')][1]";
		public final static String Biller_Payables_IncomingBills_PayBtn="(//a[text()='Pay'])[1]";
		public final static String Biller_Payables_IncomingBills_Paymentmethod_Visa="//a[@id='VISALnk']";
		public final static String Biller_Payables_EnterDueAmount="//input[@id='txtEnterPayment']";
		public final static String Biller_Payables_PayNowbtn="//a[@id='btnpay']";
		public final static String Biller_Payables_EnterCardNumber="//input[@name='card.number']";
		public final static String Biller_Payables_EnterExpireDate="//input[@placeholder='MM / YY']";
		public final static String Biller_Payables_EnterCvvNumber="//input[@placeholder='CVV']";
		public final static String Biller_Payables_EnterCardHolderName="//input[@placeholder='Card holder']";
		public final static String Biller_Payables_InvoicePayNowBtn="//button[text()='Pay now']";
		public final static String Biller_Payables_FinalPayBtn="//form//input[@type='submit']";
		public final static String Biller_Payables_FinishBtn="//a[text()='Finish']";
		public final static String Biller_Payables_IncomingBills_Paymentmethod_Sadad="//a[@id='lnkSadad']";
		public final static String Biller_Payables_PayBtn_Sadad="//button[@id='btnConfirmSadad']";
		public final static String Biller_Payables_PaymentMethodStatus_Multipay="//td[text()='Multi Payment']";
		public final static String Biller_SwitchToFrame="//iframe[@name='card.cvv']";
}


	

