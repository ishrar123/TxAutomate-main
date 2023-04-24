package step_definitions.WEB_CBA_Testcases;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.CBAPage;
import step_definitions.BaseStepDefinitions;
import step_definitions.RunCukesTest;
import utilities.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;



public class CBASteps extends KeywordUtil {

    public WebDriver driver = null;
    public static HashMap<String, String> dataMap;

    public CBASteps() {
        dataMap = BaseStepDefinitions.dataMap;
    }

    String button3 = "";
    WebElement button2;

    @Given("user is on the application")
    public void user_is_on_the_application() {

        String url = ConfigReader.getValue("CBA_URL");
        navigateToUrl(url);
    }

    @When("user clicks on the {string} {string}  button")
    public void uesr_clicks_on_the_i_button(String servicename, String i) throws InterruptedException {
        // driver.findElement(By.xpath("(//div[@class='landing-services-section-top']/button[@class='info-button']) [2]")).click();
        Thread.sleep(7000);
        isWebElementVisible(CBAPage.i_button(servicename, Integer.parseInt(i)));
        hoverOnElement(CBAPage.i_button(servicename, Integer.parseInt(i)));
        click(CBAPage.i_button(servicename, Integer.parseInt(i)), "click on the " + servicename + "  i  button");
    }

    @Then("user is able to see an informative page with description of all the car services")
    public void user_is_able_to_see_an_informative_page_with_description_of_all_the_car_services() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(isWebElementVisible(CBAPage.informative_page));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("An informative page with description of all the car services is present"));

    }

    @When("user clicks on the {string} {string} toggle button")
    public void user_clicks_on_the_toggle_button(String servicename, String togglebutton) throws InterruptedException {
        isWebElementVisible(CBAPage.togglebutton(servicename, Integer.parseInt(togglebutton)));
        hoverOnElement(CBAPage.togglebutton(servicename, Integer.parseInt(togglebutton)));
        click(CBAPage.togglebutton(servicename, Integer.parseInt(togglebutton)), "Click on the " + servicename + " toggle  button");


    }

    @Then("user is not able to see the services in something wrong")
    public void user_is_not_able_to_see_the_services_in_something_wrong() throws InterruptedException {

        if (isWebElementVisible(CBAPage.Something_s_wrong_services)) {
            System.out.println("services are present");
        } else {
            hoverOnElement(CBAPage.know_more);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Something's wrong' options is closed. "));
        }
    }

    @Then("user is able to see the services in the something_s wrongs")
    public void user_is_able_to_see_the_services_in_the_something_s_wrongs() throws InterruptedException {
        List<WebElement> servicesList = getListElements(CBAPage.Something_s_wrong_services, " able to see the list of services in the Something's wrong");

        for (int i = 0; i < servicesList.size(); i++) {
            hoverOnElement(CBAPage.something_wrong_all_Sevices);
            hoverOnElement(CBAPage.know_more);

            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(servicesList.get(i).getText()));

        }
    }

    @Then("user is able to see the services in the common servicess")
    public void user_is_able_to_see_the_services_in_the_common_servicess() {
        List<WebElement> servicesList = getListElements(CBAPage.services, " able to see the list of services in the common services");
        for (int i = 0; i < servicesList.size(); i++) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(servicesList.get(i).getText()));

        }
    }


    @Then("user should be able to see the stay and wait button")
    public void user_should_be_able_to_see_the_stay_and_wait_button() {

        Assert.assertTrue(isWebElementVisible(CBAPage.stayAndWaitIcon), "stay and wait is present");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("stay and wait is present"));

    }


    @And("Common services {string} button should be present")
    public void button_should_be_present(String button) throws InterruptedException {
        waitForVisible(CBAPage.common_service_i_button);
        hoverOnElement(CBAPage.common_service_i_button);

        Assert.assertTrue(isWebElementVisible(CBAPage.common_service_i_button));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(" Common services " + button + " is present"));
    }

    @When("user clicks on the {string} button")
    public void user_clicks_on_the_button(String button) throws InterruptedException {
        waitForVisible(CBAPage.common_service_i_button);
        hoverOnElement(CBAPage.common_service_i_button);
        click(CBAPage.common_service_i_button, "click on the i button");

    }

    @Then("user is able to see the list of all the services")
    public void user_is_able_to_see_the_list_of_all_the_services() {
        waitForVisible(CBAPage.informative_page);
        Assert.assertTrue(isWebElementVisible(CBAPage.informative_page));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("able to see the list of all the services"));


    }

    @And("user click on {string} button")
    public void user_click_on_button(String button) throws InterruptedException {
        Thread.sleep(6000);
        waitForVisible(CBAPage.buttonPresent(button));
        hoverOnElement(CBAPage.buttonPresent(button));
        click(CBAPage.buttonPresent(button), "Clicking on the " + button + " button ");


    }


    @And("stay and wait option should be present")
    public void stay_and_wait_option_should_be_present() {
        isWebElementVisible(CBAPage.stay_and_wait);
    }

    @And("Click Stay and Wait option")
    public void Click_Stay_and_Wait_option() {
        click(CBAPage.stay_and_wait, "click on the stay and wait ");
    }


    @Then("Drop Off Vehicle functionality should be enabled")
    public void Drop_Off_Vehicle_functionality_should_be_enabled() {
        Assert.assertFalse(isWebElementselected(CBAPage.drop_and_vehicle, "drop off functionlity should be enabled"));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Drop off functionality  is enabled"));

    }


    @Then("stay and wait option should be disabled")
    public void Stay_and_Wait_functionality_should_be_disabled() {

        Assert.assertFalse(isWebElementNotPresent(CBAPage.stay_and_wait), "stay and wait option is disabled");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Stay and wait is disabled"));

    }


    @Then("user should be able to see the stay and wait text along with the chair icon")
    public void user_should_be_able_to_see_the_stay_and_wait_text_along_with_the_chair_icon() {


        Assert.assertTrue(isWebElementVisible(CBAPage.stay_and_wait_informative_page));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("stay and wait text is present"));
        Assert.assertTrue(isWebElementVisible(CBAPage.chair_icon));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("chair icon is present"));


    }

    @When("user hovers the {string} services")
    public void user_hovers_the_services(String service) throws InterruptedException {
        waitForVisible(CBAPage.service(service));
        hoverOnElement(CBAPage.service(service));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("hover on the " + service));

    }

    @Then("{string} services should be activated")
    public void services_should_be_activated(String service) {
        isWebElementselected(CBAPage.service(service), service + " is selected");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(service + " is active"));
    }

    @And("all the services in the Something_s wrong is present")
    public void all_the_services_in_the_Something_s_wrong_is_present() {
        List<WebElement> servicesList = getListElements(CBAPage.Something_s_wrong_services, "list of services ");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is able to see the services "));
        for (int i = 0; i < servicesList.size(); i++) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(servicesList.get(i).getText()));

        }
        Assert.assertEquals(servicesList.get(0).getText(), "A/C & Heat");
        Assert.assertEquals(servicesList.get(1).getText(), "Battery / Electrical");
        Assert.assertEquals(servicesList.get(2).getText(), "Brakes");
        Assert.assertEquals(servicesList.get(3).getText(), "Check Engine Light");
        Assert.assertEquals(servicesList.get(4).getText(), "Engine / Driving Trouble");
        Assert.assertEquals(servicesList.get(5).getText(), "Leak");
        Assert.assertEquals(servicesList.get(6).getText(), "Noise");
        Assert.assertEquals(servicesList.get(7).getText(), "Starting Trouble");
        Assert.assertEquals(servicesList.get(8).getText(), "Steering / Suspension");
        Assert.assertEquals(servicesList.get(9).getText(), "Transmission");
        Assert.assertEquals(servicesList.get(10).getText(), "Vibration");
        Assert.assertEquals(servicesList.get(11).getText(), "Other");


    }


    @Then("{string} button is already selected")
    public void vehicle_button_is_already_selected(String service) {
        waitForVisible(CBAPage.drop_and_vehicle);
        isWebElementselected(CBAPage.drop_and_vehicle, "drop and vehicle button is selected");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("drop and vehicle button is already selected"));
    }

    @And("wait for some time to load the page")
    public void wait_for_some_time_to_load_the_page() throws InterruptedException {
        Thread.sleep(6000);
    }


    @And("click on the {string} button")
    public void click_on_the_button(String button) throws InterruptedException {
        isWebElementVisible(CBAPage.buttonPresent(button));
        hoverOnElement(CBAPage.buttonPresent(button));
        click(CBAPage.buttonPresent(button), "click on the " + button + " button ");
    }

    @Then("user is able to see the selected {string}")
    public void user_is_able_to_see_the_selected(String timeslot) throws InterruptedException {
        Thread.sleep(7000);
        isWebElementVisible(CBAPage.selecttimeslot(timeslot));
        hoverOnElement(CBAPage.selecttimeslot(timeslot));
        isWebElementselected(CBAPage.selecttimeslot(timeslot), timeslot + "is selected ");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is able to see the " + timeslot));

    }

    @And("user click on the {string} button")
    public void user_click_on_the_button(String button) throws InterruptedException {
        isWebElementVisible(CBAPage.Calender_View);
        hoverOnElement(CBAPage.Calender_View);
        click(CBAPage.Calender_View, "Click on the Calender View button");
    }

    @Then("user is able to see the monthyear")
    public void user_is_able_to_see_the_monthyear() {
        LocalDate currentdate = LocalDate.now();

        Month currentMonth = currentdate.getMonth();
        System.out.println("Current month: "+currentMonth);
        //getting the current year
        int currentYear = currentdate.getYear();
        System.out.println("Current Year: "+currentYear);
        String currentMonth_currentyear=currentMonth +" "+ currentYear;
        isWebElementVisible(CBAPage.current_month);
        String text = getElementTextWithFindElement(CBAPage.current_month);
        System.out.println(text);
        Assert.assertEquals(text, currentMonth_currentyear);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(text + " is present"));

    }

    @Then("user is able to see the Calender View button")
    public void user_is_able_to_see_the_button() {
        Assert.assertTrue(isWebElementVisible(CBAPage.Calender_View));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is able to see the Calender View button"));


    }

    @Then("user is able to see the current week and shows starting days of week")
    public void user_is_able_to_see_the_current_week_and_shows_starting_days_of_week() {
        List<WebElement> days = getListElements(CBAPage.week_view, "list of days");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.valueOf(days.size())));
        for (int i = 0; i < days.size(); i++) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(days.get(i).getText()));


        }
    }

    @Then("toggle icon is already selected")
    public void toggle_icon_is_already_selected() throws InterruptedException {
        isWebElementVisible(CBAPage.date_time_toggle_icon);
        hoverOnElement(CBAPage.date_time_toggle_icon);
        // Assert.assertTrue(isWebElementselected(CBAPage.date_time_toggle_icon,"toggle icon is already selected"));
        isWebElementselected(CBAPage.date_time_toggle_icon, "toggle icon is already selected");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Toggle icon is already selected"));
    }

    @Then("hover on {string} Option")
    public void user_hover_on_button(String button) throws InterruptedException {
        waitForVisible(CBAPage.stay_and_wait);
        hoverOnElement(CBAPage.stay_and_wait);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(" Stay and wait is in focused state"));
    }

    @Then("user is able to see {string} button")
    public void presenceButton(String button) throws InterruptedException {
        waitForVisible(CBAPage.buttonPresent(button));
        hoverOnElement(CBAPage.buttonPresent(button));
        Assert.assertTrue(isWebElementVisible(CBAPage.buttonPresent(button)));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(button + " button is visible"));
    }

    @Then("verify {string} button is disabled")
    public void presenceButtonDisabled(String button) throws InterruptedException {
        waitForVisible(CBAPage.buttonPresent(button));
        hoverOnElement(CBAPage.buttonPresent(button));
        Assert.assertTrue(isWebElementVisible(CBAPage.buttonPresent(button)));
        Assert.assertTrue(isWebElementVisible(CBAPage.buttonPresentDisabled(button)));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(button + " button is visible and disabled"));
    }

    @Then("user selects {string} in {string}")
    public void SelectService(String service, String type) throws InterruptedException {
        waitForVisible(CBAPage.service(service));
        hoverOnElement(CBAPage.service(service));
        Assert.assertTrue(isWebElementVisible(CBAPage.service(service)));

        click(CBAPage.service(service), "Clicking on the " + service + " in " + type);
       Assert.assertTrue(isWebElementVisible(CBAPage.serviceSelected(service)));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(service + " is selected"));

    }

    @Then("user unselects {string} in {string}")
    public void UnSelectService(String service, String type) throws InterruptedException {
        waitForVisible(CBAPage.service(service));
        hoverOnElement(CBAPage.service(service));
        Assert.assertTrue(isWebElementVisible(CBAPage.serviceSelected(service)));
        Assert.assertTrue(isWebElementVisible(CBAPage.service(service)));
        click(CBAPage.service(service), "Clicking on the " + service + " in " + type);
        Assert.assertTrue(isWebElementVisible(CBAPage.serviceNotSelected(service)));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(service + " is unselected"));

    }

    @Then("verify textbox is enabled and message is being displayed")
    public void textboxBeforeContinue() throws InterruptedException {
        waitForVisible(CBAPage.textareaError);
        hoverOnElement(CBAPage.textareaError);
        Assert.assertTrue(isWebElementVisible(CBAPage.textareaError));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Mandatory textbox is visible"));
        Assert.assertTrue(isWebElementVisible(CBAPage.textareaErrorMsg));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("'You’ve selected ‘Other’, please add a comment before continuing' is visible"));
    }

    @Then("verify textbox is mandatory")
    public void textboxMandatory() throws InterruptedException {
        waitForVisible(CBAPage.textareaError);
        hoverOnElement(CBAPage.textareaError);
        Assert.assertTrue(isWebElementVisible(CBAPage.textareaError));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Mandatory textbox is visible"));
    }

    @Then("click on {string} button")
    public void buttonClick(String button) throws InterruptedException {
        waitForVisible(CBAPage.buttonPresent(button));
        hoverOnElement(CBAPage.buttonPresent(button));
        click(CBAPage.buttonPresent(button), "Clicking on the " + button + " button ");
    }

    @Then("user is navigated to {string} screen")
    public void userIsNavigatedToScreen(String page) {
        if (page.equalsIgnoreCase("dropoff")) {
            waitForURLContains("dropoff");
            Assert.assertTrue(isWebElementVisible(CBAPage.dropoffIcon));
        } else if (page.equalsIgnoreCase("services")) {
            Assert.assertTrue(isWebElementVisible(CBAPage.commonServicesHeader));
        } else if (page.equalsIgnoreCase("date-time")) {
            waitForURLContains("date-time");
            Assert.assertTrue(isWebElementVisible(CBAPage.dateTimeScreen));
        }
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is navigated to the " + page + " screen"));
    }

    @Then("hover on {string} button")
    public void buttonhover(String button) throws InterruptedException {
        waitForVisible(CBAPage.buttonPresent(button));
        hoverOnElement(CBAPage.buttonPresent(button));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(button + " is in focused state"));
    }

    @Then("verify the list of services is displayed in alphabetical order")
    public void verifyTheListOfServicesIsDisplayedInAlphabeticalOrder() {
        List<WebElement> servicesList = getListElements(CBAPage.services, "list of services ");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Services are in the order - "));
        for (int i = 0; i < servicesList.size(); i++) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(servicesList.get(i).getText()));

        }
        Assert.assertEquals(servicesList.get(0).getText(), "Alignment");
        Assert.assertEquals(servicesList.get(1).getText(), "Fluid Service");
        Assert.assertEquals(servicesList.get(2).getText(), "Oil Change");
        Assert.assertEquals(servicesList.get(3).getText(), "Pre-Purchase Inspection");
        Assert.assertEquals(servicesList.get(4).getText(), "State Inspection");
        Assert.assertEquals(servicesList.get(5).getText(), "Tire Rotation");


    }

    @Then("verify {string} in {string} is {string}")
    public void verifyIs(String service, String type, String state) {

        if (state.equalsIgnoreCase("highlighted") || state.equalsIgnoreCase("activated"))
            Assert.assertTrue(isWebElementVisible(CBAPage.serviceSelected(service)));

        else if (state.equalsIgnoreCase("not highlighted") || state.equalsIgnoreCase("not activated"))
            Assert.assertTrue(isWebElementVisible(CBAPage.serviceNotSelected(service)));

        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(service + " in " + type + " is " + state));
    }

    @Then("verify close button is available on the {string} modal pop up")
    public void closeButton(String typeOfPopUp) throws InterruptedException {
        waitForVisible(CBAPage.closeButton);
        Assert.assertTrue(isWebElementVisible(CBAPage.closeButton));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("close button is visible"));
    }

    @Then("click on  close button on the {string} modal pop up")
    public void clickOnCloseButtonOnTheModalPopUp(String TypeOfPopUp) {
        waitForVisible(CBAPage.closeButton);
        click(CBAPage.closeButton, "Clicking on close button");
    }

    @Then("verify the first breadcrumb is highlighted")
    public void dropoffbreadcrumbHighligted() {
        waitForURLContains("dropoff");
        Assert.assertTrue(isWebElementVisible(CBAPage.dropoffIcon));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Drop off breadcrumb is highlighted"));
    }


    @Then("verify subject line - I would like to visit the {string} store for {string} is displayed")
    public void verifySubjectLineIWouldLikeToVisitTheStoreForIsDisplayed(String location, String service) {
        waitForURLContains("dropoff");
        Assert.assertTrue(isWebElementVisible(CBAPage.subjectLine(location, service)));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("I would like to visit the " + location + " store for " + service + " is visible"));
    }


    @Then("the subheading reads {string}")
    public void theSubheadingReads(String message) {
        waitForURLContains("dropoff");
        Assert.assertTrue(isWebElementVisible(CBAPage.subheading(message)));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(message + " is visible"));

    }

    @Then("select stay and wait option")
    public void selectStayAndWaitOption() {
        click(CBAPage.stayAndWaitIcon, "Clicking on stay and wait option");
        Assert.assertTrue(isWebElementVisible(CBAPage.stayAndWaitIconSelected));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("stay and wait option is selected"));


    }

    @Then("verify {string} option is selected")
    public void verifyOption(String option) {
        waitForURLContains("dropoff");

        switch (option) {
            case "stay and wait":
                Assert.assertTrue(isWebElementVisible(CBAPage.stayAndWaitIconSelected));
                break;
            case "drop off":
                Assert.assertTrue(isWebElementVisible(CBAPage.dropoffIcon));
                break;

        }
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(option + " option is selected"));


    }

    @Then("shuttle service option is disabled")
    public void shuttleService() {
        Assert.assertTrue(isWebElementVisible(CBAPage.shuttleServiceText));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Shuttle service is disabled"));
    }

    @Then("verify {string} is displayed")
    public void verifyStringIsDisplayed(String message) {
        if (message.equalsIgnoreCase("What's next?")) {
            Assert.assertTrue(isWebElementVisible(CBAPage.whatsNext));

        } else {
            Assert.assertTrue(isWebElementVisible(CBAPage.messageText(message)));
        }
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(message + " is displayed"));

    }

    @Then("verify the number of time slots available matches the number listed")
    public void verifyTheNumberOfTimeSlotsAvailableMatchesTheNumberListed() throws InterruptedException {

        List<WebElement> datePickerTimes = getListElements(CBAPage.slotsDates, "list of date picker times");
        System.out.println(" DSFG " + datePickerTimes.size());
        int count = 0;
        for (int i = 1; i < datePickerTimes.size(); i++) {
            System.out.println(" IIIII " + i);
            if (i != 1) {
                hoverOnElement(CBAPage.
                        slotsDatesDropdownArrow(i));
                click(CBAPage.slotsDatesDropdownArrow(i), datePickerTimes.get(i).getText() + " for " + getElementText(CBAPage.slotsDatesDate(i)));
            }
            count = Integer.parseInt(datePickerTimes.get(i).getText().split(" available times")[0]);
            List<WebElement> slotsInADayList = getListElements(CBAPage.slotsInADay, "list of slots in a day");
            System.out.println(count + "DFGHJK" + slotsInADayList.size());
            Assert.assertEquals(count, slotsInADayList.size());


        }
    }

    @Then("verify After Hours time slot is {string}")
    public void verifyAfterHoursTimeSlotIs(String state) throws InterruptedException {
        Boolean bool = state.equalsIgnoreCase("available");
        if (bool == true) {
            hoverOnElement(CBAPage.afterHoursSlot("After Hours"));
            Assert.assertTrue(isWebElementVisible(CBAPage.afterHoursSlot("After Hours")));
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("After Hours slot is available"));
        }
        if (bool == false) {
            Assert.assertFalse(isWebElementVisible(CBAPage.afterHoursSlot("After Hours")));
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("After Hours slot is not available"));

        }
    }

    @Then("verify After Hours modal appears")
    public void verifyAfterHoursModalAppears() {
        waitForVisible(CBAPage.afterHoursModal);
        Assert.assertTrue(isWebElementVisible(CBAPage.afterHoursModal));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("After Hours modal is visible"));

    }

    @And("click on {string} time slot")
    public void clickOnAfterHoursTimeSlot(String slot) throws InterruptedException {
        waitForVisible(CBAPage.afterHoursSlot(slot));
        hoverOnElement(CBAPage.afterHoursSlot(slot));
        if (slot.equalsIgnoreCase("After Hours")) {
            click(CBAPage.afterHoursSlot(slot), "Clicking on After Hours slot");
            waitForVisible(CBAPage.afterHoursModal);
        } else {
            click(CBAPage.afterHoursSlot(slot), "Clicking on " + slot + " slot");
        }

    }

    @And("user select the {string} timeslot")
    public void user_select_the_timeslot(String timeslot) throws InterruptedException {
        if (isWebElementVisible(CBAPage.selecttimeslot(timeslot))) {
            waitForVisible(CBAPage.selecttimeslot(timeslot));
            hoverOnElement(CBAPage.selecttimeslot(timeslot));
            click(CBAPage.selecttimeslot(timeslot), timeslot + "is selected");
            //Assert.assertTrue(isWebElementselected(CBAPage.selecttimeslot(timeslot),timeslot +"is selected"));
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(timeslot + "is selected"));
        } else {
            //Assert.assertTrue(isWebElementNotPresent(CBAPage.selecttimeslot(timeslot)));
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(timeslot + "is not selected"));
        }
    }


    @And("click on calender view")
    public void clickOnCalenderView() {
        waitForVisible(CBAPage.calendarViewButton);
        click(CBAPage.calendarViewButton, "Clicking on calendar view");
        waitForVisible(CBAPage.calendarViewOpened);
        Assert.assertTrue(isWebElementVisible(CBAPage.calendarViewOpened));


    }

    @Then("user is able to see the next 7 dates")
    public void user_is_able_to_view_the_next_7_dates() {
        List<WebElement> all_dates = getListElements(CBAPage.date, "getting next 7 dates");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.valueOf(all_dates.size())));
        for (int i = 0; i < all_dates.size(); i++) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(all_dates.get(i).getText()));


        }

    }

//    @Then("user is able to see the previous 7 dates")
//    public void user_is_able_to_view_the_previous_7_dates() {
//        List<WebElement> all_dates = getListElements(CBAPage.date, "getting previous 7 dates");
//        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.valueOf(all_dates.size())));
//        for (int i = 0; i < all_dates.size(); i++) {
//            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(all_dates.get(i).getText()));
//
//
//        }
//
//    }

    @Then("user is able to see the previous 7 dates")
    public void user_is_able_to_view_the_time_slots() {
        List<WebElement> all_dates = getListElements(CBAPage.date, "getting all the list");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.valueOf(all_dates.size())));
        for (int i = 0; i < all_dates.size(); i++) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(all_dates.get(i).getText()));


        }

    }

    @Then("user is not able to see the services in common services")
    public void see_the_services_in_common_services() {
        if (isWebElementVisible(CBAPage.common_service_all_service)) {
            System.out.println("services are present");
        } else {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Common services options is  closed. "));
        }
    }

    @And("user clicks on close button of Informative page")
    public void userClicksOnCloseButtonOfInformativePage() {

        Assert.assertTrue(isWebElementVisible(CBAPage.close_button_common_services));
        click(CBAPage.close_button_common_services, "Click on close button");
    }

    @Then("Informative page closes.")
    public void informativePageCloses() {
        Assert.assertTrue(isWebElementNotPresent(CBAPage.informative_page));
    }

    @And("user is able to see all the tools")
    public void user_is_able_to_see_all_the_tools() {
        List<WebElement> tools = getListElements(CBAPage.all_tool, "toolslist");
        for (int i = 0; i < tools.size(); i++) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(tools.get(i).getCssValue("width")));
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(tools.get(i).getCssValue("height")));

            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(tools.get(i).getCssValue("color")));

        }

        String color = tools.get(0).getCssValue("color");
        Assert.assertEquals(color, "rgba(147, 213, 0, 1)");


    }


    @And("user select the the available timeslot")
    public void user_select_the_the_timeslot() throws InterruptedException {

        List<WebElement> timeslots = getListElements(CBAPage.time_slots, "the selected time slot  : ");
        for (int i = 0; i < timeslots.size(); i++) {
            button2 = timeslots.get(i);

            if (button2.isEnabled()) {

                button3 = button2.getText();
                button2.click();

                Thread.sleep(7000);
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(button3 + " is selected"));
                break;
            }





        }


    }

    @When("user clicks on the year button")
    public void user_clicks_on_the_year_button() throws InterruptedException {
        isWebElementVisible(CBAPage.Year);
        hoverOnElement(CBAPage.Year);
        click(CBAPage.Year, "click on the year dropdown");

    }

    @When("user selects the {string} year")
    public void user_selects_the_year(String year1) throws InterruptedException {
        List<WebElement> year_list = getListElements(CBAPage.dropdown, "getting the selected year");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(year1));
        for (int i = 0; i < year_list.size(); i++) {
            //RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(year_list.get(i).getText()));
            if (year_list.get(i).getText().contains(year1)) {
                isWebElementVisible(CBAPage.select_year(year1));
                hoverOnElement(CBAPage.select_year(year1));
                click(CBAPage.select_year(year1), "select the year");

            }


        }
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(year1 + " is selected"));


    }

    @When("user clicks on the make button")
    public void user_clicks_on_the_make_button() throws InterruptedException {
        isWebElementVisible(CBAPage.make);
        hoverOnElement(CBAPage.make);
        click(CBAPage.make, "click on the make dropdown");
        //RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("make dropdown is clicked"));
    }

    @When("user selects the {string} make")
    public void user_selects_the_make(String make) throws InterruptedException {
        List<WebElement> make_list = getListElements(CBAPage.make_list, "getting the selected make");
        for (int i = 0; i < make_list.size(); i++) {
            // RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(make_list.get(i).getText()));
            if (make_list.get(i).getText().contains(make)) {
                isWebElementVisible(CBAPage.select_make(make));
                hoverOnElement(CBAPage.select_make(make));
                click(CBAPage.select_make(make), "select the make");

            }


        }
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(make + "  is selected"));


    }

    @When("user clicks on the model button")
    public void user_clicks_on_the_model_button() throws InterruptedException {
        isWebElementVisible(CBAPage.model);
        hoverOnElement(CBAPage.model);
        click(CBAPage.model, "click on the model dropdown");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("model dropdown is clicked"));
    }

    @When("user selects the {string} model")
    public void user_selects_the_model(String model) throws InterruptedException {
        List<WebElement> model_list = getListElements(CBAPage.model_list, "getting the selected model");
        for (int i = 0; i < model_list.size(); i++) {
            //RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(model_list.get(i).getText()));
            if (model_list.get(i).getText().contains(model)) {
                isWebElementVisible(CBAPage.select_model(model));
                hoverOnElement(CBAPage.select_model(model));
                click(CBAPage.select_model(model), "select the year");

            }


        }


        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(model + "  is selected"));

    }

    @When("user is on personal info page")
    public void userIsOnPersonalInfoPage() {
        Assert.assertTrue(isWebElementVisible(CBAPage.info_page));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the user is on the personal info page"));
    }

    @And("{string} is present")
    public void firstNameIsPresent(String name) {
        Assert.assertTrue(isWebElementVisible(CBAPage.info_page(name)));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(name + " field is present "));

    }

    @Then("user is able to see error message {string}")
    public void user_message(String message) {
        Assert.assertTrue(isWebElementVisible(CBAPage.error_message(message)));
        String error_message = getElementTextWithFindElement(CBAPage.error_message(message));
        Assert.assertEquals(message, error_message);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is able to see the error " + message));

//     if(isWebElementVisible(CBAPage.error_message(message))){
//         RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("it is required"));
//     }


    }

    @Then("user is not  able to see error message")
    public void user_is_not_able_to_see_error_message() {
        if (isWebElementVisible(CBAPage.error_message("please enter a valid alternate phone no"))) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("it is required"));
        } else {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("it is Optional"));
        }
    }

    @Then("user is able to see the inline error messages")
    public void user_is_able_to_see_the_inline_error_messages() {
        List<WebElement> error_messages = getListElements(CBAPage.inline_error, "getting the list of errors");
        for (int i = 0; i < error_messages.size(); i++) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(error_messages.get(i).getText()));
        }

    }

    @And("user enters an invalid {string} {string}")
    public void user_enters_an_invalid_email_address(String field, String invalid_emailaddress) {
        inputText(CBAPage.info_page(field), invalid_emailaddress, "entering the " + invalid_emailaddress);
    }

    @Then("getting the value of {string}")
    public void value(String data) {
        String value = getElementValueWithVisibility(CBAPage.info_page(data));
        Assert.assertNotEquals(value, "123456789012");

        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(" getting value is " + value));
    }

    @When("user enter {string} as {string}")
    public void user_enter_as(String field, String data) {
        inputText(CBAPage.info_page(field), data, "Enters the " + data + " in the " + field);

    }

    @Then("user is able to see the {string} year {string} make and {string} model")
    public void vehicle_details(String year, String make, String model) {
        isWebElementVisible(CBAPage.Year);
        String gettext = getElementTextWithFindElement(CBAPage.Year);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(gettext + " is present "));
        isWebElementVisible(CBAPage.model_list);
        String gettext1 = getElementTextWithFindElement(CBAPage.model);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(gettext1 + " is present "));
        isWebElementVisible(CBAPage.make);
        String gettext2 = getElementTextWithFindElement(CBAPage.make);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(gettext2 + " is present "));


    }

    @When("user clicked on the yes button")
    public void radio_button() {
        click(CBAPage.yes_button, "clicked on the yes radio button");
    }

    @Then("stepper field has been checked or not")
    public void stepper_field_has_been_checked_or_not() {
        List<WebElement> tools = getListElements(CBAPage.all_tool, "toolslist");
        for (int i = 0; i < tools.size(); i++) {

            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(tools.get(i).getCssValue("color")));

        }


    }

    @And("radio buttons are present")
    public void radioButtonsArePresent() {
        Assert.assertTrue(isWebElementVisible(CBAPage.yes_button));
        Assert.assertTrue(isWebElementVisible(CBAPage.no_button));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(" 'Yes','No' radio buttons are present "));

    }

    @And("Location question is present")
    public void locationQuestionIsPresent() {
        Assert.assertTrue(isWebElementVisible(CBAPage.first_question));
        String text = getElementText(CBAPage.first_question);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(text));
        Assert.assertEquals(text, "Is this your first time visiting our South Sarasota store?*");


    }

    @Then("user is able to see the selected date and verifying the page")
    public void user_is_able_to_see_the_selected_date_and_verifying_the_page() {

        String str = getCurrentDateTime_ddMMMyyyy();
        System.out.print("Current date: " + str);
        String str2 = str.substring(0, 2);

        System.out.print("Current date: " + str2);
        click(CBAPage.selecdateslot(str2), str2 + "is selected");

        //click(By.xpath("//div[contains(text(),'"+str2+"')]"), "Click on the Calender View button");


        isWebElementVisible(CBAPage.current_date);
        String text = getElementTextWithFindElement(CBAPage.current_date);
        Assert.assertEquals(text, "Today");


    }

    @And("user navigates on the {string} button")
    public void user_navigates_on_the_button(String button) throws InterruptedException {
        isWebElementVisible(CBAPage.week_view);
        //hoverOnElement(CBAPage.week_view);
        click(CBAPage.week_view, "Click on the Week View button");
    }

    @And("user able to select date and time and click on {string} button")
    public void user_able_to_select_date_and_time_and_click_on_continue_button(String button) throws InterruptedException {


        List<WebElement> servicesList = getListElements(CBAPage.slots, "list of services");
        for (int i = 0; i < servicesList.size(); i++) {
            System.out.println(servicesList.get(i).getText());
            WebElement button2 = servicesList.get(i);
            String button3 = button2.getText();
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(button3));

            if (button2.isEnabled()) {
                button2.click();
                //RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(button2 + "is selected"));
                break;
            }

        }
        isWebElementVisible(CBAPage.Calender_View);
        hoverOnElement(CBAPage.Calender_View);
        click(CBAPage.Calender_View, "Click on the Calender View button");
        Thread.sleep(5000);
        waitForVisible(CBAPage.buttonPresent(button));
        hoverOnElement(CBAPage.buttonPresent(button));

        Assert.assertTrue(isWebElementVisible(CBAPage.nextday));


        Thread.sleep(5000);
        //Assert.assertTrue(isWebElementVisible(CBAPage.selectavailbleslot(button3)));
        click(CBAPage.buttonPresent(button), "Clicking on the " + button + " button ");
    }

    @And("user navigates on the {string} button and validates next day page")
    public void user_navigates_on_the_button_next_day(String button) throws InterruptedException {
        isWebElementVisible(CBAPage.nextday);
        hoverOnElement(CBAPage.nextday);
        click(CBAPage.nextday, "Click on the Next Day button");
        Thread.sleep(6000);
        DateFormat formatter = new SimpleDateFormat("d/MM/yy");
        Calendar obj = Calendar.getInstance();
        String str = formatter.format(obj.getTime());
        System.out.println("Current Date: "+str );
        // add one day to the date/calendar
        obj.add(Calendar.DAY_OF_YEAR, 1);
        // now get "tomorrow"
        String tomorrow = formatter.format(obj.getTime());
        // print out tomorrow's date
        System.out.println("tomorrow date is : " + tomorrow);
        String str2=tomorrow.substring(0,2);
        isWebElementVisible(CBAPage.current_date);
        String text = getElementTextWithFindElement(CBAPage.current_date);
        System.out.println("Here: " + text);
        String text2 = text.substring(4, 6);
        System.out.println("Here2: " + text2);
        Assert.assertEquals(str2, text2);

    }

    @And("user able to select nextday date in calender and validating")
    public void user_selecting_the_next_day() throws InterruptedException {


        click(CBAPage.nextday, "Click on the Next Day button");
        DateFormat formatter = new SimpleDateFormat("d/MM/yy");
        Calendar obj = Calendar.getInstance();
        String str = formatter.format(obj.getTime());
        System.out.println("Current Date: "+str );
        // add one day to the date/calendar
        obj.add(Calendar.DAY_OF_YEAR, 1);

        // now get "tomorrow"
        String tomorrow = formatter.format(obj.getTime());

        // print out tomorrow's date
        System.out.println("tomorrow date is : " + tomorrow);






//        LocalDate today = LocalDate.now();
//        String tomorrow = (today.plusDays(1)).format(DateTimeFormatter.ISO_DATE);
//        System.out.print("Tomarrow date: " + tomorrow);
//        String str2 = tomorrow.substring(8, 10);
//        System.out.print("tomarrow date: " + str2);
//
//        click(CBAPage.selectingthenextdaydate(str2), str2 + " is selected");
        Thread.sleep(6000);

       // isWebElementVisible(CBAPage.previousday);
       // String text = getElementTextWithFindElement(CBAPage.previousday);
       // Assert.assertEquals(text, "Prev day");

      //  isWebElementVisible(CBAPage.nextday);
        String text1 = getElementTextWithFindElement(CBAPage.nextday);
       // Assert.assertEquals(text1, "Next day");

    }

    @And("user navigates on the {string} button and validates previous day page")
    public void user_navigates_on_the_button_prev_day(String button) throws InterruptedException {
        isWebElementVisible(CBAPage.previousday);
        hoverOnElement(CBAPage.previousday);
        click(CBAPage.previousday, "Click on the Previous day button");

        Thread.sleep(6000);
        isWebElementVisible(CBAPage.current_date);
        String text = getElementTextWithFindElement(CBAPage.current_date);
        Assert.assertEquals(text, "Today");
    }

    @And("user unable to select day that have passed")
    public void user_unable_to_selecting_the_day_that_have_passed() throws InterruptedException {

        LocalDate today = LocalDate.now();
        String yesterday = (today.minusDays(1)).format(DateTimeFormatter.ISO_DATE);
        System.out.print("Yesterday date: " + yesterday);
        String str2 = yesterday.substring(9, 10);
        System.out.print("yesterday date: " + str2);

        click(CBAPage.selectingthenextdaydate(str2), str2 + " is selected");
        Assert.assertFalse(isWebElementNotPresent(CBAPage.selectingthenextdaydate(str2)), "yesterday date is disabled");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is unable to select the " + str2 + " date "));

        Thread.sleep(7000);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is unable to select the " + str2 + " date "));

    }

    @Then("user is able to see the vehicle info page")
    public void user_is_able_to_see_vehicle_info_page() throws InterruptedException {
        Assert.assertTrue(isWebElementVisible(CBAPage.stepper_mark));


        Assert.assertTrue(isWebElementVisible(CBAPage.buttonPresent("Previous")));
        Assert.assertTrue(isWebElementVisible(CBAPage.buttonPresent("Continue")));
        CBAPage.buttonPresentDisabled("Continue");
        //Assert.assertEquals(servicesList.get(11).getText(), "Other");
        //getElementText()
        Assert.assertTrue(isWebElementVisible(CBAPage.what_type_vehicle_do_you_have));
        Thread.sleep(10000);


    }

    @And("Make model colour buttons are not enabled")
    public void Make_model_colour_buttons_are_not_enabled() throws InterruptedException {

        Assert.assertTrue(isWebElementVisible(CBAPage.make_disable));
        Assert.assertTrue(isWebElementVisible(CBAPage.model_disable));
        Assert.assertTrue(isWebElementVisible(CBAPage.color_disable));

        //Assert.assertTrue(isWebElementVisible(CBAPage.make));
        //Assert.assertTrue(isWebElementVisible(CBAPage.model));
        //Assert.assertTrue(isWebElementVisible(CBAPage.color));

    }

    @When("user selects the {string} year and verifies page")
    public void user_selects_the_year_verifies_page(String year1) throws InterruptedException {
        isWebElementVisible(CBAPage.Year);
        String gettext = getElementTextWithFindElement(CBAPage.Year);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(gettext + " is present "));
        isWebElementVisible(CBAPage.model_list);
        String gettext1 = getElementTextWithFindElement(CBAPage.model);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(gettext1 + " is present "));
        isWebElementVisible(CBAPage.make);
        String gettext2 = getElementTextWithFindElement(CBAPage.make);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(gettext2 + " is present "));
        List<WebElement> year_list = getListElements(CBAPage.dropdown, "getting the list");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(year1));
        for (int i = 0; i < year_list.size(); i++) {
//            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(year_list.get(i).getText()));
            if (year_list.get(i).getText().contains(year1)) {
                isWebElementVisible(CBAPage.select_year(year1));
                hoverOnElement(CBAPage.select_year(year1));
                click(CBAPage.select_year(year1), "select the year");


            }
        }
        Assert.assertTrue(isWebElementVisible(CBAPage.make));
        isWebElementVisible(CBAPage.Year);
        String gettext4 = getElementTextWithFindElement(CBAPage.Year);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(gettext4 + " is present "));
        isWebElementVisible(CBAPage.model_list);
        String gettext5 = getElementTextWithFindElement(CBAPage.model);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(gettext5 + " is present "));
        isWebElementVisible(CBAPage.make);
        String gettext6 = getElementTextWithFindElement(CBAPage.make);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(gettext6 + " is present "));



    }

    @When("user selects the {string} make and validating page")
    public void user_selects_the_make_and_validating_page(String make) throws InterruptedException {
        List<WebElement> make_list = getListElements(CBAPage.make_list, "getting the list");
        for (int i = 0; i < make_list.size(); i++) {
//            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(make_list.get(i).getText()));
            if (make_list.get(i).getText().contains(make)) {
                isWebElementVisible(CBAPage.select_make(make));
                hoverOnElement(CBAPage.select_make(make));
                click(CBAPage.select_make(make), "select the make");


            }


        }
        //Assert.assertTrue(isWebElementVisible(CBAPage.make_list_acura));

        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(make + "  is selected"));


    }

    @Then("verify that stepper icon is highlighted")
    public void stepper_icon1() {
        if (isWebElementVisible(CBAPage.checked_icon)) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("icon is checked"));
        } else {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("icon is highlighted"));
        }

    }

    @Then("user sees their selected service in the first sectioned area")
    public void user_sees_their_selected_service_in_the_first_sectioned_area() {
        isWebElementVisible(CBAPage.review_service);
        String Expected_service = getElementTextWithFindElement(CBAPage.review_service);
        Assert.assertEquals(Expected_service, "Alignment");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is able to see the " + Expected_service + " in the first sectioned area"));

    }

    @And("user is able to click on the done button")
    public void done_button() {
        click(CBAPage.after_hours_done_button, "click on the done button");

    }


    @Then("user is able to see the i button in the review page")
    public void i_button_in_the_reveiewpage() {
        Assert.assertTrue(isWebElementVisible(CBAPage.dropicon_i_button));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is able to see the i button"));
    }

    @And("user add {string}")
    public void add_data(String data) {
        inputText(CBAPage.textbox_area, data, "entering the " + data + "in the other");

    }

    @Then("see their additional notes in the first sectioned area")
    public void see_their_additional_notes_in_the_first_sectioned_area() {
        isWebElementVisible(CBAPage.review_other_text);
        String Expected_text = getElementTextWithFindElement(CBAPage.review_other_text);
        Assert.assertEquals(Expected_text, "my vehicle name is Appache");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is able to see the " + Expected_text + " in the first sectioned area"));


    }

    @Then("user click on the i button in the review screen")
    public void user_click_on_the_i_button_in_the_review_screen() {
        isWebElementVisible(CBAPage.dropicon_i_button);
        click(CBAPage.dropicon_i_button, "click on the i button");
    }

    @Then("user is able to see the after model")
    public void user_is_able_to_see_the_after_model() {
        Assert.assertTrue(isWebElementVisible(CBAPage.afterHoursModal));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is able to see the after model "));
    }

    @Then("user sees their Drop off or Sit and Wait service in the first sectioned area")
    public void userSeesTheirDropOffOrSitAndWaitServiceInTheFirstSectionedArea() {
        isWebElementVisible(CBAPage.spec_service);
        String service_sel = getElementTextWithFindElement(CBAPage.spec_service);
        System.out.println("Getting text " + service_sel);
        Assert.assertEquals(service_sel, "Dropoff: Please note we will begin service at our first available opportunity after dropoff.");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is able to see the " + service_sel + " in the first sectioned area"));

    }

    @Then("user is able to see the available timeslot")
    public void able_to_see_the_selected_timeslot() throws InterruptedException {

        Assert.assertTrue(isWebElementEnable(CBAPage.selecttimeslot(button3), button3 + " timezone is selected"));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(button3 + " timezone is selected"));


    }

    @And("user validating the year drop down list")
    public void user_validating_the_year_drop_down_list() throws InterruptedException {
        List<WebElement> yearList = getListElements(CBAPage.dropdown, "list of years ");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is able to see the years "));
        for (int i = 0; i < yearList.size(); i++) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(yearList.get(i).getText()));

        }
        System.out.println(yearList.get(0).getText());
        Assert.assertEquals(yearList.get(0).getText(), "2024");
        Assert.assertEquals(yearList.get(1).getText(), "2023");
        Assert.assertEquals(yearList.get(2).getText(), "2022");
        Assert.assertEquals(yearList.get(3).getText(), "2021");
        Assert.assertEquals(yearList.get(4).getText(), "2020");
        Assert.assertEquals(yearList.get(5).getText(), "2019");
        Assert.assertEquals(yearList.get(6).getText(), "2018");
        Assert.assertEquals(yearList.get(7).getText(), "2017");
        Assert.assertEquals(yearList.get(8).getText(), "2016");
        Assert.assertEquals(yearList.get(9).getText(), "2015");
        Assert.assertEquals(yearList.get(10).getText(), "2014");
        Assert.assertEquals(yearList.get(11).getText(), "2013");
        Assert.assertEquals(yearList.get(12).getText(), "2012");
        Assert.assertEquals(yearList.get(13).getText(), "2011");
        Assert.assertEquals(yearList.get(14).getText(), "2010");
        Assert.assertEquals(yearList.get(15).getText(), "2009");
        Assert.assertEquals(yearList.get(16).getText(), "2008");
        Assert.assertEquals(yearList.get(17).getText(), "2007");
        Assert.assertEquals(yearList.get(18).getText(), "2006");
        Assert.assertEquals(yearList.get(19).getText(), "2005");
        Assert.assertEquals(yearList.get(20).getText(), "2004");
        Assert.assertEquals(yearList.get(21).getText(), "2003");
        Assert.assertEquals(yearList.get(22).getText(), "2002");
        Assert.assertEquals(yearList.get(23).getText(), "2001");
        Assert.assertEquals(yearList.get(24).getText(), "2000");
        Assert.assertEquals(yearList.get(25).getText(), "1999");
        Assert.assertEquals(yearList.get(26).getText(), "1998");
        Assert.assertEquals(yearList.get(27).getText(), "1997");
        Assert.assertEquals(yearList.get(28).getText(), "1996");
        Assert.assertEquals(yearList.get(29).getText(), "1995");
        Assert.assertEquals(yearList.get(30).getText(), "1994");
        Assert.assertEquals(yearList.get(31).getText(), "1993");
        Assert.assertEquals(yearList.get(32).getText(), "1992");
        Assert.assertEquals(yearList.get(33).getText(), "1991");
        Assert.assertEquals(yearList.get(34).getText(), "1990");
        Assert.assertEquals(yearList.get(35).getText(), "1989");
        Assert.assertEquals(yearList.get(36).getText(), "1988");
        Assert.assertEquals(yearList.get(37).getText(), "1987");
        Assert.assertEquals(yearList.get(38).getText(), "1986");
        Assert.assertEquals(yearList.get(39).getText(), "1985");
        Assert.assertEquals(yearList.get(40).getText(), "1984");
        Assert.assertEquals(yearList.get(41).getText(), "1983");
        Assert.assertEquals(yearList.get(42).getText(), "1982");

        Thread.sleep(5000);


    }

    @And("user validating makes drop down list")
    public void user_validating_makes_drop_down_list() {
        List<WebElement> makeList = getListElements(CBAPage.make_list, "list of make brands");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is able to see make brands"));
        for (int i = 0; i < makeList.size(); i++) {
            System.out.println(makeList.get(i).getText());
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(makeList.get(i).getText()));

        }
        Assert.assertEquals(makeList.get(0).getText(), "Acura");
        Assert.assertEquals(makeList.get(1).getText(), "Alfa Romeo");
        Assert.assertEquals(makeList.get(2).getText(), "Aston Martin");
        Assert.assertEquals(makeList.get(3).getText(), "Audi");
        Assert.assertEquals(makeList.get(4).getText(), "BAIC");
        Assert.assertEquals(makeList.get(5).getText(), "Bentley");
        Assert.assertEquals(makeList.get(6).getText(), "BMW");
        Assert.assertEquals(makeList.get(7).getText(), "Bugatti");
        Assert.assertEquals(makeList.get(8).getText(), "Buick");
        Assert.assertEquals(makeList.get(9).getText(), "Cadillac");
        Assert.assertEquals(makeList.get(10).getText(), "Chevrolet");
        Assert.assertEquals(makeList.get(11).getText(), "Chrysler");
        Assert.assertEquals(makeList.get(12).getText(), "Cupra");
        Assert.assertEquals(makeList.get(13).getText(), "Dodge");
        Assert.assertEquals(makeList.get(14).getText(), "Ferrari");
        Assert.assertEquals(makeList.get(15).getText(), "Fiat");
        Assert.assertEquals(makeList.get(16).getText(), "Ford");
        Assert.assertEquals(makeList.get(17).getText(), "Freightliner");
        Assert.assertEquals(makeList.get(18).getText(), "Genesis");
        Assert.assertEquals(makeList.get(19).getText(), "GMC");
        Assert.assertEquals(makeList.get(20).getText(), "Honda");
        Assert.assertEquals(makeList.get(21).getText(), "Hyundai");
        Assert.assertEquals(makeList.get(22).getText(), "INFINITI");
        Assert.assertEquals(makeList.get(23).getText(), "Isuzu");
        Assert.assertEquals(makeList.get(24).getText(), "JAC");
        Assert.assertEquals(makeList.get(25).getText(), "Jaguar");
        Assert.assertEquals(makeList.get(26).getText(), "Jeep");
        Assert.assertEquals(makeList.get(27).getText(), "JMC");
        Assert.assertEquals(makeList.get(28).getText(), "Karma");
        Assert.assertEquals(makeList.get(29).getText(), "Kia");
        Assert.assertEquals(makeList.get(30).getText(), "Lamborghini");
        Assert.assertEquals(makeList.get(31).getText(), "Land Rover");
        Assert.assertEquals(makeList.get(32).getText(), "Lexus");
        Assert.assertEquals(makeList.get(33).getText(), "Lincoln");
        Assert.assertEquals(makeList.get(34).getText(), "Lotus");
        Assert.assertEquals(makeList.get(35).getText(), "Maserati");
        Assert.assertEquals(makeList.get(36).getText(), "Mazda");
        Assert.assertEquals(makeList.get(37).getText(), "McLaren");
        Assert.assertEquals(makeList.get(38).getText(), "Mercedes-Benz");
        Assert.assertEquals(makeList.get(39).getText(), "MG");
        Assert.assertEquals(makeList.get(40).getText(), "Mini");
        Assert.assertEquals(makeList.get(41).getText(), "Mitsubishi");
        Assert.assertEquals(makeList.get(42).getText(), "Nissan");
        Assert.assertEquals(makeList.get(43).getText(), "Peugeot");
        Assert.assertEquals(makeList.get(44).getText(), "Polestar");
        Assert.assertEquals(makeList.get(45).getText(), "Porsche");
        Assert.assertEquals(makeList.get(46).getText(), "Ram");
        Assert.assertEquals(makeList.get(47).getText(), "Renault");
        Assert.assertEquals(makeList.get(48).getText(), "Rolls-Royce");
        Assert.assertEquals(makeList.get(49).getText(), "Seat");
        Assert.assertEquals(makeList.get(50).getText(), "Subaru");
        Assert.assertEquals(makeList.get(51).getText(), "Suzuki");
        Assert.assertEquals(makeList.get(52).getText(), "Tesla");
        Assert.assertEquals(makeList.get(53).getText(), "Toyota");
        Assert.assertEquals(makeList.get(54).getText(), "Volkswagen");
        Assert.assertEquals(makeList.get(55).getText(), "Volvo");
        Assert.assertEquals(makeList.get(56).getText(), "Zacua");


    }

    @Then("user click on  {string} Edit button in {string} area")
    public void edit_button(String i, String area) throws InterruptedException {
        isWebElementVisible(CBAPage.edit_button(Integer.parseInt(i), area));
        hoverOnElement(CBAPage.edit_button(Integer.parseInt(i), area));
        click(CBAPage.edit_button(Integer.parseInt(i), area), "user click on the edit button in the " + area);
    }

    @Then("user is able to see the chosen location's name as {string}, address as {string}, and phone number as {string} in the third sectioned area.")
    public void details_in_third_sectioned_area(String location, String address, String phone) {
        String expected_location = getElementTextWithFindElement(CBAPage.review_page(location));
        Assert.assertEquals(expected_location, location);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is able to see the " + expected_location + " in the third sectioned area"));
        String expeted_address = getElementTextWithFindElement(CBAPage.review_page(address));
        Assert.assertEquals(expeted_address, address);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is able to see the " + expeted_address + " in the third sectioned area"));
        String expected_phone_number = getElementTextWithFindElement(CBAPage.phone_number);
        Assert.assertEquals(phone, expected_phone_number);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is able to see the " + expected_phone_number + " in the third sectioned area"));

    }

    @Then("user see the {string} button is disabled")
    public void disabled_continue(String button) throws InterruptedException {
        isWebElementVisible(CBAPage.buttonPresentDisabled(button));
        hoverOnElement(CBAPage.buttonPresentDisabled(button));
        CBAPage.buttonPresentDisabled(button);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(button + " button  is disbled "));
    }

    @Then("{string} button is Enabled")
    public void continue_button_disabled(String button) {
        Assert.assertTrue(isWebElementEnable(CBAPage.buttonPresent(button), button + " is enabled "));
    }

    @And("user select the the {string} timeslot")
    public void select_timeslot(String timeslot) throws InterruptedException {
        Thread.sleep(7000);
        isWebElementVisible(CBAPage.selecttimeslot(timeslot));
        hoverOnElement(CBAPage.selecttimeslot(timeslot));
        click(CBAPage.selecttimeslot(timeslot), "click on " + timeslot);
    }

    @And("user verifying {string}")
    public void user_selects_in(String service) throws InterruptedException {
        waitForVisible(CBAPage.service(service));
        hoverOnElement(CBAPage.service(service));
        Assert.assertTrue(isWebElementVisible(CBAPage.service(service)));
        Assert.assertTrue(isWebElementVisible(CBAPage.serviceSelected(service)));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(service + " is selected"));

    }

    @Then("shuttle service option should be disabled")
    public void shuttleServiceOptionShouldBeDisabled() throws InterruptedException {
        hoverOnElement(CBAPage.hover_shuttle);

        boolean element_disbale = isWebElementEnable(CBAPage.Shuttle_service_button, "Checking the Shuttle service radio button");
        if (element_disbale) {

            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor("Shuttle service radio button is enabled."));
        } else {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Shuttle service radio button is disabled."));
        }
    }


    @And("user able to select_available date")
    public void user_able_to_select_available_date() throws InterruptedException {

        List<WebElement> listofdates = getListElements(CBAPage.dates, "list of available dates");
        for (int i = 0; i < listofdates.size(); i++) {
            System.out.println(listofdates.get(i).getText());
            WebElement button2 = listofdates.get(i);
            if (button2.isEnabled()) {
                String button4 = button2.getText();
                System.out.println("here is availble one" + button4);
                button2.click();
                delay(2000);
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(button4 + " is selected"));
                break;
            }
        }
    }

    @And("user verifying available_time slot_for_that_date")
    public void user_verifying_available_time_slot_for_that_date() throws InterruptedException {

        List<WebElement> listofslots = getListElements(CBAPage.slots, "list of available slots");
        for (int i = 0; i < listofslots.size(); i++) {
            System.out.println(listofslots.get(i).getText());
            WebElement button2 = listofslots.get(i);
            if (button2.isEnabled()) {
                String button5 = button2.getText();
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(button5 + " is a available time slot"));
                delay(2000);
                break;
            }
        }
    }

    @And("user able to select available_time")
    public void user_able_to_select_available_time() throws InterruptedException {

        List<WebElement> listofslots = getListElements(CBAPage.slots, "list of available slots");
        for (int i = 0; i < listofslots.size(); i++) {
            System.out.println(listofslots.get(i).getText());
            WebElement button2 = listofslots.get(i);
            if (button2.isEnabled()) {
                button3 = button2.getText();
                button2.click();
                delay(2000);
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(button2 + "is selected"));
                break;
            }
        }
    }

    @And("user validating the selected date")
    public void user_validating_the_selected_date() throws InterruptedException {

        Assert.assertTrue(isWebElementVisible(CBAPage.nextday));
        Assert.assertTrue(isWebElementEnable(CBAPage.selectavailbleslot(button3), button3 + "is selected"));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(button3 + "is selected"));
    }

    @Then("User validating calender view page")
    public void user_validating_calender_view_page() throws InterruptedException {
        delay(3000);
        Assert.assertEquals("Su", getElementTextWithFindElement(CBAPage.calender_sun_day), "validating SunDay");
        Assert.assertEquals("Mo", getElementTextWithFindElement(CBAPage.calender_mon_day), "validating MonDay");
        Assert.assertEquals("Tu", getElementTextWithFindElement(CBAPage.calender_tue_day), "validating TueDay");
        Assert.assertEquals("We", getElementTextWithFindElement(CBAPage.calender_wed_day), "validating Wednesday");
        Assert.assertEquals("Th", getElementTextWithFindElement(CBAPage.calender_thu_day), "validating ThursDay");
        Assert.assertEquals("Fr", getElementTextWithFindElement(CBAPage.calender_fri_day), "validating FriDay");
        Assert.assertEquals("Sa", getElementTextWithFindElement(CBAPage.calender_sat_day), "validating SatDay");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("validating calender view"));
    }

    @Then("User validating week view page")
    public void user_validating_week_view_page() throws InterruptedException {
        delay(3000);
        Assert.assertEquals("SUN", getElementTextWithFindElement(CBAPage.sun_day), "validating SunDay");
        Assert.assertEquals("MON", getElementTextWithFindElement(CBAPage.mon_day), "validating MonDay");
        Assert.assertEquals("TUE", getElementTextWithFindElement(CBAPage.tue_day), "validating TueDay");
        Assert.assertEquals("WED", getElementTextWithFindElement(CBAPage.wed_day), "validating Wednesday");
        Assert.assertEquals("THU", getElementTextWithFindElement(CBAPage.thu_day), "validating ThursDay");
        Assert.assertEquals("FRI", getElementTextWithFindElement(CBAPage.fri_day), "validating FriDay");
        Assert.assertEquals("SAT", getElementTextWithFindElement(CBAPage.sat_day), "validating SatDay");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("validating week view"));
    }

    @And("user verifying stepper mark")
    public void user_verifying_stepper_mark() throws InterruptedException {

        Assert.assertTrue(isWebElementVisible(CBAPage.checked_icon));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is verifying the stepper mark in personal info page"));

    }

    @Then("user is able to see the continue button")
    public void user_is_able_to_see_the_continue_button() {

        Assert.assertTrue(isWebElementVisible(CBAPage.buttonPresent("Continue")));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is able to see the continue button"));

    }

    @Then("user is able to see the previous button")
    public void user_is_able_to_see_the_previous_button() {

        Assert.assertTrue(isWebElementVisible(CBAPage.buttonPresent("Previous")));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is able to see the previous button"));


    }

    @Then("user is able to see the continue button is in disable state un till select year")
    public void user_is_able_to_see_the_continue_button_is_in_disable_state_un_till_select_year() {

        CBAPage.buttonPresentDisabled("Continue");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("continue button is in disable state "));



    }

    @And("user validating  model list drop down")
    public void user_able_to_see_the_model_drop_down() {
        List<WebElement> modelList = getListElements(CBAPage.model_list, "list of models ");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is able to see the models "));
        for (int i = 0; i < modelList.size(); i++) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(modelList.get(i).getText()));

        }
        Assert.assertEquals(modelList.get(0).getText(), "ILX");
        Assert.assertEquals(modelList.get(1).getText(), "NSX");
        Assert.assertEquals(modelList.get(2).getText(), "RDX");
        Assert.assertEquals(modelList.get(3).getText(), "TLX");


    }

    @When("user clicks on the color dropdown")
    public void user_clicks_on_the_color_button() throws InterruptedException {
        isWebElementVisible(CBAPage.color);
        hoverOnElement(CBAPage.color);
        click(CBAPage.color, "click on the color dropdown");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("color dropdown is clicked"));

    }

    @And("user validating  color list drop down")
    public void user_able_to_see_the_color_drop_down() {
        List<WebElement> colorlist = getListElements(CBAPage.color_list, "list of colours ");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is able to see the colours "));
        for (int i = 0; i < colorlist.size(); i++) {
            System.out.println(colorlist.get(i).getText());
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(colorlist.get(i).getText()));

        }
        Assert.assertEquals(colorlist.get(0).getText(), "Beige");
        Assert.assertEquals(colorlist.get(1).getText(), "Black");
        Assert.assertEquals(colorlist.get(2).getText(), "Blue");
        Assert.assertEquals(colorlist.get(3).getText(), "Brown");
        Assert.assertEquals(colorlist.get(4).getText(), "Gold");
        Assert.assertEquals(colorlist.get(5).getText(), "Grey");
        Assert.assertEquals(colorlist.get(6).getText(), "Green");
        Assert.assertEquals(colorlist.get(7).getText(), "Maroon");
        Assert.assertEquals(colorlist.get(8).getText(), "Orange");
        Assert.assertEquals(colorlist.get(9).getText(), "Purple");
        Assert.assertEquals(colorlist.get(10).getText(), "Red");

        Assert.assertEquals(colorlist.get(11).getText(), "Silver");
        Assert.assertEquals(colorlist.get(12).getText(), "White");
        Assert.assertEquals(colorlist.get(13).getText(), "Yellow");
        Assert.assertEquals(colorlist.get(14).getText(), "Other");


    }

    @When("user selects the {string} color")
    public void user_selects_the_color(String color) throws InterruptedException {
        List<WebElement> color_list = getListElements(CBAPage.color_list, "getting the list");
        for (int i = 0; i < color_list.size(); i++) {
//            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(model_list.get(i).getText()));
            if (color_list.get(i).getText().contains(color)) {
                isWebElementVisible(CBAPage.select_color(color));
                hoverOnElement(CBAPage.select_color(color));
                click(CBAPage.select_color(color), "select the color");

            }


        }


    }

    @Then("User validating personal info page")
    public void user_validating_personal_info_page() throws InterruptedException {
        delay(3000);
        Assert.assertEquals("Almost there! Just need a little more info about you.",getElementTextWithFindElement(CBAPage.personal_info_welcome_message), "validating text");
        Assert.assertTrue(isWebElementVisible(CBAPage.personal_info_first_name));
        Assert.assertTrue(isWebElementVisible(CBAPage.personal_info_last_name));
        Assert.assertTrue(isWebElementVisible(CBAPage.personal_info_email));
        Assert.assertTrue(isWebElementVisible(CBAPage.personal_info_zipcode));

        Assert.assertEquals("Is this your first time visiting our South Sarasota store?*",getElementTextWithFindElement(CBAPage.personal_info_is_this_your_text), "validating text");

    }

    @Then("user is able to validating make button un availability")
    public void user_is_able_to_validating_make_button_un_availability() throws InterruptedException {

        Assert.assertTrue(isWebElementVisible(CBAPage.make_disable));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("validating make button un availability"));
    }

    @Then("user is able to validating make button availability")
    public void user_is_able_to_validating_make_button_availability() throws InterruptedException {

        Assert.assertTrue(isWebElementVisible(CBAPage.make));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("validating make button availability"));
    }

    @And("user navigates on the {string} button and validates next days page")
    public void user(String button) throws InterruptedException {
        click(CBAPage.nextday, "Click on the Next Day button");
        Thread.sleep(6000);

        LocalDate date=LocalDate.now();


        LocalDate tommorow= date.plusDays(1);
        String day= String.valueOf(tommorow.getDayOfMonth());
        System.out.println("tommorow date is : " +day);


        Assert.assertTrue(isWebElementEnable(CBAPage.selecdateslot(day), "user is on the  " + day + " date "));



    }

    @And("user add {string} and validating size is not more than 500")
    public void text(String data){
        String maxlength= getAttributevaue(CBAPage.textbox_area,"maxlength");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("The maximum length of the textbox is : " +maxlength));

        inputText(CBAPage.textbox_area, data, "entering the " + data + " in the textbox");
        String enteredtext=getElementValueWithVisibility(CBAPage.textbox_area);


        int size=enteredtext.length();
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the size of the entered text is : " +size));



        if(size<=500){
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Max character functionality is worked fine"));

        }
        else{
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Max character functionality is not  worked fine"));
        }



    }

    @Then("user not able to see {string} in {string}")
    public void not(String service, String type){

        Assert.assertFalse(isWebElementVisible(CBAPage.serviceSelected(service)));
    }

    @And("user able to see the year_model_make")
    public void user_able(){
        String get_year=getElementTextWithFindElement(CBAPage.Year);
        System.out.println("the  current year is : " +get_year);
        String get_make=getElementTextWithFindElement(CBAPage.make);
        System.out.println("the  current make is : " +get_make);
        String get_model=getElementTextWithFindElement(CBAPage.model);
        System.out.println("the  current make is : " +get_model);

    }



}




