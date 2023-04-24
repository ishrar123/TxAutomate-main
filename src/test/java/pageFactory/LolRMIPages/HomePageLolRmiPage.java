package pageFactory.LolRMIPages;

import org.openqa.selenium.By;

public class HomePageLolRmiPage {


        public static By homePage_Username = By.className("header_profilename__1dmve");
        public static By homePage_Producers_Sections = By.xpath("//span[contains(text(),'Producers')]");
        public static By homePage_Years_Sections = By.xpath("//span[contains(text(),'Years')]");
        public static By homePage_Cop_Sections = By.xpath("//span[contains(text(),'Cost of Production')]");
        public static By homePage_RiskManagement_Sections = By.xpath("//span[contains(text(),'Risk Management')]");
        public static By homePage_Search_Dropdown = By.xpath("//div[@class='producers_dropdownContainer__t6fAs']/div/div[@data-testid='selectComp']/div[@aria-haspopup='listbox']");
        public static By homePage_Search_Dropdown_Select_Producers = By.xpath("//ul[@role='listbox']/li[@data-value='PRODUCER']");
        public static By homePage_Search_Dropdown_Select_FarmID = By.xpath("//ul[@role='listbox']/li[@data-value='FARM ID']");
        public static By homePage_Search_Dropdown_Select_MilkShed = By.xpath("//ul[@role='listbox']/li[@data-value='MILK SHED']");


        public static By homePage_Search_Producers = By.xpath("//input[@id='Searchproducer']");
        public static By homePage_First_Tile_FarmID = By.xpath("//DIV[@CLASS='producers_contentcontainer__32pDM']/DIV/DIV[1]/div/div[1]/div/div/h2[1]");
        public static By homePage_First_Tile_Label = By.xpath("//DIV[@CLASS='producers_contentcontainer__32pDM']/DIV/DIV[1]/div/div[1]/div/div/h2[2]");
        public static By homePage_First_Tile_Menu = By.xpath("//DIV[@CLASS='producers_contentcontainer__32pDM']/DIV/DIV[1]/div/div[1]/span");
        public static By homePage_First_Tile_TakeOffline = By.xpath("//DIV[@CLASS='producers_contentcontainer__32pDM']/DIV/DIV[1]/div/div[2]/div/div/h2[text()='Take Offline']");
        public static By homePage_First_Tile_TakeOffline_Modal = By.xpath("//div[contains(text(),'Take Offline')]");

        public static By editCOP_ProducerTiles_2021 = By.xpath("//div[contains(@class, 'performance-year_contentcontainer')]/div/div/div/div/div/div/div/h2[text() = '2021']//parent::div/following-sibling::div[contains(@class, 'performance-year_cardbtn')]/button[text()='Edit COP']");
        public static By editRM_ProducerTiles_2021 = By.xpath("//div[contains(@class, 'performance-year_contentcontainer')]/div/div/div/div/div/div/div/h2[text() = '2021']//parent::div/following-sibling::div[contains(@class, 'performance-year_cardbtn')]/button[text()='Edit RM']");

        //        Herd Information - Financial Data Form

        public static By editCOP_PageHeader_FinData_Form = By.xpath("//h1[contains(@class, 'cop_moduleHeader')]");

        public static By editCOP_NumberOfMatureCowsAvg_FinData_Form = By.xpath("//input[@data-automate-id='Number Of Mature Cows (Avg)']");
        public static By editCOP_NumberOfReplacementsAvg_FinData_Form = By.xpath("//input[@data-automate-id='Number of Replacements (AVG)']");
        public static By editCOP_MilkVolumeSold_FinData_Form = By.xpath("//input[@data-automate-id='Milk Volume Sold (CWT)']");

        //        Acreage Information
        public static By editCOP_CornForages_FinData_Form = By.xpath("//input[@data-automate-id='Corn Forages']");
        public static By editCOP_CornGrain_FinData_Form = By.xpath("//input[@data-automate-id='Corn Grain']");
        public static By editCOP_Alfalfa_FinData_Form = By.xpath("//input[@data-automate-id='Alfalfa']");
        public static By editCOP_OtherForage_FinData_Form = By.xpath("//input[@data-automate-id='Other Forage']");
        public static By editCOP_OtherCashGrain_FinData_Form = By.xpath("//input[@data-automate-id='Other Cash Grain']");
        public static By editCOP_SaveAndClose_Btn_FinData_Form = By.xpath("//button[text()='Save and Close']");
        public static By editCOP_SaveSuccessMessage_FinData_Form = By.xpath("//div[@class='MuiSnackbar-root MuiSnackbar-anchorOriginTopCenter']/div/div[@class='MuiAlert-message'][text()='Data saved Successfully']");

//        General Assumptions
        public static By editCOP_GrossPayrollMilkRevenue_FinData_Form = By.xpath("//input[@data-automate-id='Gross Payroll Milk Revenue']");
        public static By editCOP_RiskMgmnt_FinData_Form = By.xpath("//input[@data-automate-id='Risk Mgmnt/Contracting']");
        public static By editCOP_TotalMilk_FinData_Form = By.xpath("//tr[contains(@class, 'cop-income-expense_nestedTableNetIncomeRow')]/td[2]/span");
        public static By editCOP_CullCows_FinData_Form = By.xpath("//input[@data-automate-id='Cull Cows']");
        public static By editCOP_Calves_FinData_Form = By.xpath("//input[@data-automate-id='Calves']");
        public static By editCOP_OtherLivestock_FinData_Form = By.xpath("//input[@data-automate-id='Other Livestock']");
        public static By editCOP_CustomWork_FinData_Form = By.xpath("//input[@data-automate-id='Custom Work']");
        public static By editCOP_GovPayments_FinData_Form = By.xpath("//input[@data-automate-id='Gov Payments']");
        public static By editCOP_Other_FinData_Form = By.xpath("//input[@data-automate-id='Other ']");
        public static By editCOP_TotalIncome_FinData_Form = By.xpath("//table[contains(@class, 'cop-income-expense_responsiveInomeTable')]/tbody/tr[contains(@class, 'cop-income-expense_netDataDisplayRow')]/td[2]/span");




        //        Summary Report
        public static By editCOP_SummaryReport_Tab = By.xpath("//span[@class='MuiTab-wrapper'][text()='SUMMARY REPORT']");
        public static By cOP_Year_SummaryReport_Tab = By.xpath("//p[text()='2021']");

        //        Herd Information - SummaryReport Tab
        public static By cOP_NumberOfMatureCowsAvg_SummaryReport_Tab = By.xpath("//span[contains(@class, 'cop-summary_headerText')][text()='AVG NO OF MATURE COWS']/parent::div/span[1]");
        public static By cOP_NumberOfReplacementsAvg_SummaryReport_Tab = By.xpath("//span[contains(@class, 'cop-summary_headerText')][text()='AVG NO OF REPLACEMENT IN INVENTORY']/parent::div/span[1]");
        public static By cOP_MilkVolumeSold_SummaryReport_Tab = By.xpath("//span[contains(@class, 'cop-summary_headerText')][text()='VOLUME OF MILK SOLD(CWTS)']/parent::div/span[1]");

        //        Acreage Information - Summary report
        public static By cOP_CornForages_SummaryReport_Tab = By.xpath("//span[contains(@class, 'cop-summary_headerText')][text()='CORN FORAGE ACRES']/parent::div/span[1]");
        public static By cOP_CornGrain_SummaryReport_Tab = By.xpath("//span[contains(@class, 'cop-summary_headerText')][text()='CORN GRAIN ACRES']/parent::div/span[1]");
        public static By cOP_Alfalfa_SummaryReport_Tab = By.xpath("//span[contains(@class, 'cop-summary_headerText')][text()='ALFALFA ACRES']/parent::div/span[1]");
        public static By cOP_OtherForage_SummaryReport_Tab = By.xpath("//span[contains(@class, 'cop-summary_headerText')][text()='OTHER FORAGE ACRES']/parent::div/span[1]");
        public static By cOP_OtherCashGrain_SummaryReport_Tab = By.xpath("//span[contains(@class, 'cop-summary_headerText')][text()='OTHER CASH GRAIN ACRES']/parent::div/span[1]");
        public static By cOP_TotalIncome_SummaryReport_Tab = By.xpath("(//td[@data-automate-id='Total Income Farm'])[4]");






}
