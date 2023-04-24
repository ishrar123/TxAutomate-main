package pageobjects;

import org.openqa.selenium.By;

public class CBAPage {

    public static By informative_page = By.xpath("//div[@class='services-modal']");

    public static By something_wrong_all_Sevices = By.xpath("(//div[@class='landing-services-section-grid']) [2]");

    public static By common_service_all_service = By.xpath("//div[@class='landing-services-section-grid']) [1]");

    public static By common_service_i_button = By.xpath("(//div[@class='landing-services-section-top']/button[@class='info-button']) [1]");



    public static By stay_and_wait = By.xpath("//button[@class='dropoff-icon']/p[text()='Stay and Wait']");


    public static By drop_and_vehicle = By.xpath("//p[text()='Drop Off Vehicle']");

    public static By stay_and_wait_informative_page = By.xpath("//div[text()='Stay & Wait Available']");



    public static By textareaError = By.xpath("//textarea[@class='landing-other-field landing-other-error']");
    public static By textareaErrorMsg = By.xpath("//p[text()='You’ve selected ‘Other’, please add a comment before continuing']");
    public static By dropoffIcon = By.xpath("//p[text()='Drop Off Vehicle']//parent::button[@class='dropoff-icon selected']");
    public static By commonServicesHeader = By.xpath("//h2[text()='Common Services']");
    public static By dateTimeScreen = By.xpath("//h1[text()='What day and time work best for you?']");
    public static By services = By.xpath("//h2[text()='Common Services']//ancestor::section[@class='landing-services-section']//p[@class='service-text']");
    public static By closeButton = By.xpath("//button[contains(@class,'modal-close')]");
    public static By stayAndWaitIcon = By.xpath("//p[text()='Stay and Wait']//parent::button");
    public static By stayAndWaitIconSelected = By.xpath("//p[text()='Stay and Wait']//parent::button[@class='dropoff-icon selected']");
    public static By shuttleServiceText = By.xpath("//p[text()='Shuttle Service is unavailable for Stay & Wait or After Hours Dropoff.']");
    public static By slotsInADay = By.xpath("//p[@class='datepicker-times-available ' and contains(text(),'available')]//ancestor::div[2]//button[contains(text(),':')]");
    public static By slotsDates = By.xpath("//p[@class='datepicker-times-available ' and contains(text(),'available')]");
    public static By afterHoursModal = By.xpath("//div[@class='after-hours-modal']");
    public static By whatsNext = By.xpath("//p[@class='whats-next']");

    public static By Calender_View = By.xpath("(//button[@class='datetime-button-link']) [1]");

    public static By current_month = By.xpath("//div[@class='react-datepicker__current-month']");


    public static By Something_s_wrong_services = By.xpath("//h2[text()=\"Something's Wrong\"]//ancestor::section[@class='landing-services-section']//p[@class='service-text']");



    public static By chair_icon = By.xpath("(//*[name()='svg'][@id='Layer_1'])");



    public static By week_view = By.xpath("//button[@class='datetime-button-link']");
    public static By date_time_toggle_icon = By.xpath("(//div[@class='toggle-icon']) [1]");

    public static By all_time_slots = By.xpath("//div[@class='datepicker-button-container']");
    public static By calendarViewButton = By.className("datetime-button-link");
    public static By calendarViewOpened = By.className("react-datepicker__month-container");

    public static By date = By.xpath("//p[@class='datepicker-date']");

    public static By close_button_common_services = By.xpath("//div[@class = 'services-modal']//button[@class='services-modal-close']");


    public static By time_slots = By.xpath("//div[@class='datepicker-button-container']/button[@class='datepicker-btn ']");

    public static By know_more = By.xpath("//p[text()='We would love to know more...']");


    public static By all_tool = By.xpath("//div[@class='breadcrumbs-container']//*[name()='svg']");



    public static By dropdown = By.xpath("//div[@id='year-select']//div[@role='option']");
    public static By Year = By.xpath("//div[@id='year-select']");

    public static By make = By.xpath("//div[@id='make-select']");

    public static By model = By.xpath("//div[@id='model-select']");

    public static By make_list = By.xpath("//div[@id='make-select']//div[@role='option']");

    public static By model_list = By.xpath("//div[@id='model-select']//div[@role='option']");

    public static By info_page = By.xpath("//div[@class='personal-info']//h1[text()='Almost there! Just need a little more info about you.']");



    public static By inline_error = By.xpath("//p[@class='personal-info-error']");


    public static By yes_button = By.xpath("(//div[@class='personal-info-radio']//div[@class='radio-button']//span[@class='radio-button-checkmark'])[1]");
    public static By no_button = By.xpath("(//div[@class='personal-info-radio']//div[@class='radio-button'])[2]");

    public static By first_question = By.xpath("//p[@class='first-time-question']");


    public static By nextday = By.xpath("//button[contains(text(),'Next day')]");
    public static By slots = By.xpath("//button[@class='datepicker-btn ']");

    public static By color = By.xpath("//div[@id='color-select']");
    public static By make_disable = By.xpath("//div[@class='ui disabled search selection dropdown']//following-sibling::div[contains(text(),'Make')]");
    public static By model_disable = By.xpath("//div[@class='ui disabled search selection dropdown']//following-sibling::div[contains(text(),'Model')]");
    public static By color_disable = By.xpath("//div[@class='ui disabled search selection dropdown']//following-sibling::div[contains(text(),'Color')]");
    public static By stepper_mark = By.xpath("//header/div[3]/div[1]/div[5]/*[1]");


    public static By previousday = By.xpath("//button[contains(text(),'Prev day')]");

    public static By checked_icon = By.xpath("//*[name()='circle' and contains(@cx,'12')]");

    public static By review_service = By.xpath("//ul[@class='review-services']");


    public static By clickOnDate = By.xpath("//button[not(@disabled)][1]");
    public static By current_date = By.xpath("//p[@class='datepicker-date']");


    public static By what_type_vehicle_do_you_have = By.xpath("//h1[contains(text(),'What type of vehicle do you have?')]");
    public static By gettextonvehicleinfopageyeardropdown = By.xpath("//div[contains(text(),'2021')]");


    public static By make_list_acura = By.xpath("//span[contains(text(),'Acura')]");


    public static By after_hours_done_button = By.xpath("//button[@class='done-button']");

    public static By dropicon_i_button = By.xpath("//button[@class='dropoff-info-button']");

    public static By textbox_area = By.xpath("//textarea[@placeholder='Please provide any information about your vehicle concerns that you think would be helpful.']");

    public static By review_other_text = By.xpath("//span[@class='review-other-text']");

    public static By spec_service = By.xpath("//div[@class='review-text']//div[contains (text(),'Dropoff')]");

    public static By phone_number = By.xpath("//a[@class='review-tel']");

    public static By hover_shuttle = By.xpath("//div[@class='shuttle-right']");


    public static By Shuttle_service_button = By.xpath("//div[@class='shuttle-left']//button[@id='shuttle-radio-button']");


    public static By dates = By.xpath("//div[@class='react-datepicker__month']//child::div[@aria-disabled='false']");

    public static By calender_sun_day = By.xpath("//div[contains(text(),'Su')]");
    public static By calender_mon_day = By.xpath("//div[contains(text(),'Mo')]");
    public static By calender_tue_day = By.xpath("//div[contains(text(),'Tu')]");
    public static By calender_wed_day = By.xpath("//div[contains(text(),'We')]");
    public static By calender_thu_day = By.xpath("//div[contains(text(),'Th')]");
    public static By calender_fri_day = By.xpath("//div[contains(text(),'Fr')]");
    public static By calender_sat_day = By.xpath("//div[contains(text(),'Sa')]");

    public static By sun_day = By.xpath("//h2[contains(text(),'SUN')]");
    public static By mon_day = By.xpath("//h2[contains(text(),'MON')]");
    public static By tue_day = By.xpath("//h2[contains(text(),'TUE')]");
    public static By wed_day = By.xpath("//h2[contains(text(),'WED')]");
    public static By thu_day = By.xpath("//h2[contains(text(),'THU')]");
    public static By fri_day = By.xpath("//h2[contains(text(),'FRI')]");
    public static By sat_day = By.xpath("//h2[contains(text(),'SAT')]");

    public static By color_list = By.xpath("//div[@id='color-select']//div[@role='option']");

    public static By personal_info_welcome_message = By.xpath("//h1[contains(text(),'Almost there! Just need a little more info about y')]");
    public static By personal_info_first_name = By.xpath("//input[@id='info-firstname']");
    public static By personal_info_last_name = By.xpath("//input[@id='info-lastname']");
    public static By personal_info_email = By.xpath("//input[@id='info-email']");
    public static By personal_info_enter_phone_number = By.xpath("//p[contains(text(),'Please enter a 10 digit phone number')]");
    public static By personal_info_zipcode = By.xpath("//input[@id='info-zip']");


    public static By personal_info_is_this_your_text = By.xpath("//p[@class='first-time-question']");

    public static  By current=By.xpath("//p[normalize-space()='Apr 11']");


    public static By select_color(String color) {
        return By.xpath("//div[@id='color-select']//div[@role='option']//span[text()='" + color + "']");
    }


    public static By selecdateslot(String dateSlot) {

        return (By.xpath("//div[contains(text(),'" + dateSlot + "')]"));


    }

    public static By selectavailbleslot(String dateSlot) {

        return (By.xpath("//button[contains(text(),'" + dateSlot + "')]"));
    }

    public static By selectingthenextdaydate(String dateSlot) {

        return (By.xpath("//div[contains(text(),'" + dateSlot + "')]"));


    }

    public static By i_button(String servicename, int i) {
        return By.xpath("(//button[@class='info-button']) [" + i + "]");
    }

    public static By afterHoursSlot(String slot) {
        return (By.xpath("//button[@class='datepicker-btn ' and text()='" + slot + "']"));

    }

    public static By selecttimeslot(String timeslot) {

        return (By.xpath("//button[normalize-space()='" + timeslot + "']"));

    }


    public static By slotsDatesDropdownArrow(int i) {
        return (By.xpath("(//p[@class='datepicker-times-available ' and contains(text(),'available')]//ancestor::div[2]//div[@class='toggle-icon'])[" + i + "]"));

    }

    public static By slotsDatesDate(int i) {
        return (By.xpath("(//p[@class='datepicker-times-available ' and contains(text(),'available')]//ancestor::div[2]//p[@class='datepicker-date'])[" + i + "]"));

    }


    public static By messageText(String text) {
        return (By.xpath("//*[text()='" + text + "']"));

    }

    public static By subjectLine(String location, String service) {
        return (By.xpath("//h1[text()='I would like to visit the ' and text()=' store for ']//a[text()='" + location + "']//following-sibling::i[contains(text(),'" + service + "')]"));
    }

    public static By subheading(String text) {
        return (By.xpath("//p[@class='dropoff-instructions' and text()='" + text + "']"));
    }


    public static By buttonPresent(String button) {
        return (By.xpath("//button[text()='" + button + "']"));

    }

    public static By buttonPresentDisabled(String button) {
        return (By.xpath("//div[@class='bottom-nav']//button[@disabled and text()='" + button + "']"));

    }

    public static By service(String text) {
        return (By.xpath("//span[@class='service-text' and text()='" + text + "']"));

    }

    public static By serviceSelected(String text) {
        return (By.xpath("//span[@class='service-text' and text()='" + text + "']//parent::button[@aria-checked='true']"));

    }

    public static By serviceNotSelected(String text) {
        return (By.xpath("//p[@class='service-text' and text()='" + text + "']//parent::button[@aria-checked='false']"));

    }

    public static By togglebutton(String servicename, int i) {
        return By.xpath("(//div[@class='landing-services-section-top']/button[@class='collapse-button']) [" + i + "]");
    }

    public static By select_year(String year) {
        return By.xpath("//div[@id='year-select']//div[@role='option']//span[text()='" + year + "']");
    }

    public static By select_make(String make) {
        return By.xpath("//div[@id='make-select']//div[@role='option']//span[text()='" + make + "']");
    }

    public static By select_model(String model) {
        return By.xpath("//div[@id='model-select']//div[@role='option']//span[text()='" + model + "']");
    }

    public static By error_message(String error_message) {
        return By.xpath("//p[text()='" + error_message + "']");
    }

    public static By info_page(String data) {
        return By.xpath("//input[@name='" + data + "']");
    }

    public static By radio_button(String radio_button) {
        return By.xpath("//div[normalize-space()='" + radio_button + "']");
    }

    public static By review_page(String data) {
        return By.xpath("//div[text()='" + data + "']");
    }

    public static By edit_button(int i, String sectionedarea) {
        return By.xpath("(//button[text()='Edit'])[" + i + "]");
    }
}
