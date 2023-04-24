Feature: opening google

  Background:
    Given user is on the application


    @tc
  #@CBA_02
  Scenario:  CBA_02_Verify that "i" icon displays with "something's wrong" category information.
    When user clicks on the "Something's Wrong" "2"  button
    Then user is able to see an informative page with description of all the car services

  @tc
  @CBA_03
  Scenario: CBA_03_Verify functionality of toggle arrow button in Common Services
    When user clicks on the "Common Services" "1" toggle button
    Then user is not able to see the services in common services
    When user clicks on the "Common Services" "1" toggle button
    Then user is able to see the services in the common servicess


 # @tc
  @CBA_04
  Scenario: CBA_04_Verify that  user select one or multiple "Common services" options at a time.
    When user selects "Oil Change" in "services"
    When user selects "Alignment" in "services"
    When user selects "Tire Rotation" in "services"

  @tc2
  #@CBA_05
  Scenario: CBA_05_Verify functionality of toggle arrow button in 'Something's wrong'.
    When user clicks on the "Something's Wrong" "2" toggle button
    Then user is not able to see the services in something wrong
    When user clicks on the "Something's Wrong" "2" toggle button
    Then user is able to see the services in the something_s wrongs

  @tc
  #@CBA_06
  Scenario:  CBA_06_Verify when "Common services" up-arrow button is tapped again after selecting services, the services remain selected

    When  user selects "Alignment" in "services"
    When user clicks on the "Common Services" "1" toggle button
    When user clicks on the "Common Services" "1" toggle button
    Then "Alignment" services should be activated


  @tc
  #@CBA_07
  Scenario:  CBA_07_Verify when "Something's wrong" up-arrow button is tapped again after selecting services, the services remain selected.

    When user selects "Brakes" in "services"
    When user clicks on the "Something's Wrong" "2" toggle button
    When user clicks on the "Something's Wrong" "2" toggle button
    Then "Brakes" services should be activated


  @tc
  #@CBA_16
  Scenario: CBA_16_Verify different services present in the common services section
    Then user is able to see the services in the common servicess
    When user selects "Oil Change" in "services"
    When user selects "State Inspection" in "services"
    When user selects "Alignment" in "services"

  @tc
  #@CBA_17
  Scenario: CBA_17_Verify the "I" option present along common services and the functionality
    And  Common services "i" button should be present
    When user clicks on the "Common Services" "1"  button
    Then user is able to see an informative page with description of all the car services



  @tc
  #@CBA_19
  Scenario: CBA_19_Verify "Stay and Wait" functionality
    When user selects "Oil Change" in "services"
    When user selects "State Inspection" in "services"
    When user selects "Tire Rotation" in "services"
    And user click on "Continue" button
    Then user should be able to see the stay and wait button
    And select stay and wait option


  @tc
  #@CBA_20
  Scenario: CBA_20_To verify what happens when we select one stay & wait and one Drop-off services
    When user selects "Oil Change" in "services"
    When user selects "Battery / Electrical" in "services"
    And user click on "Continue" button
    Then Drop Off Vehicle functionality should be enabled
    Then stay and wait option should be disabled

  @tc
  #@CBA_21
  Scenario: CBA_21_Verify if the user hovers over "Stay and Wait" or "Drop Off Vehicle", the option should go into the hover state
    When user selects "Oil Change" in "services"
    When user selects "State Inspection" in "services"
    When user selects "Tire Rotation" in "services"
    And user click on "Continue" button
    And wait for some time to load the page
    And hover on "Stay and Wait" Option
    Then "Stay and Wait" services should be activated


  @tc
  #@CBA_22
  Scenario: CBA_22_Verify when user clicks on the "I" button then whichever service has stay and wait availability, a chair icon is present to the left of "Stay & Wait Available
    When user clicks on the "Common Services" "1"  button
    Then user should be able to see the stay and wait text along with the chair icon

  @tc
  #@CBA_23
  Scenario: CBA_23_Verify when a user hovers over an service square box, a hover state should be activated
    When user hovers the "Oil Change" services
    Then "Oil Change" services should be activated

  @tc
  #@CBA_24
  Scenario: CBA_24_Verify different services present in the "Something's Wrong" section
    And all the services in the Something_s wrong is present
    When user selects "Battery / Electrical" in "services"
    Then "Battery / Electrical" services should be activated
    When user selects "Brakes" in "services"
    Then "Brakes" services should be activated
 @tc
  #@CBA_25
  Scenario:Verify the hover functionality of "Cancel" button

    Then hover on "Cancel" button

  @tc
  #@CBA_36
  Scenario:CBA_36_Verify the presence of the 'Continue' button
    Then  user is able to see "Continue" button

  @tc
  #@CBA_37
  Scenario:CBA_37_Verify the presence of the 'Cancel' button
    Then  user is able to see "Cancel" button

  @tc
  #@CBA_38
  Scenario:CBA_38_Verify the 'Continue' button is disabled until a service has been chosen
    Then  verify "Continue" button is disabled
    When user selects "Other" in "something's wrong"
    Then verify textbox is enabled and message is being displayed

  @tc
  #@CBA_39
  Scenario:CBA_39_Verify the 'Continue' and Cancel' buttons go into the focused state when the user hovers over them
    When user selects "Oil Change" in "services"
    Then hover on "Cancel" button
    Then hover on "Continue" button

  @tc
  #@CBA_41
  Scenario:CBA_41_Verify after selecting services, tapping the 'Continue' button takes the user to the Drop Off/SAW screen
    When user selects "Oil Change" in "services"
    Then click on "Continue" button
    Then user is navigated to "drop off" screen


 @tc
  #@CBA_46
  Scenario:CBA_46_Verify when the user has clicked an icon square, the active state is activated
    When user selects "Oil Change" in "services"
    Then verify "Oil Change" in "services" is "activated"

  @tc
  #@CBA_47
  Scenario:CBA_47_Verify when user select more than one service icon and unselect any service, then box should not be highlighted
    When user selects "Oil Change" in "services"
    When user selects "State Inspection" in "services"
    When user unselects "Oil Change" in "services"
    Then verify "Oil Change" in "services" is "not highlighted"

  @tc
  #@CBA_48
  Scenario:CBA_48_Verify if the user has selected the "Other" service, the text area should become required
    When user selects "Other" in "something's wrong"
    Then verify textbox is mandatory

  @tc
  #@CBA_54
  Scenario:CBA_54_Verify, when open "i" icon, the x icon is located in the upper right corner of the modal
    When user clicks on the "Common Services" "1"  button
    Then verify close button is available on the "informational" modal pop up

  @tc1
  #@CBA_55
  Scenario:CBA_55_Verify the first breadcrumb is highlighted
    When user selects "Oil Change" in "services"
    Then click on "Continue" button
    Then verify the first breadcrumb is highlighted

  @tc1
  #@CBA_56
  Scenario:CBA_56_Verify if one service has been selected, the subject line reads "I would like to visit the [location] store for [service]"
    When user selects "Oil Change" in "services"
    Then click on "Continue" button
    When user is navigated to "dropoff" screen
    Then verify subject line - I would like to visit the "South Sarasota" store for "Oil Change" is displayed

  @tc1
  #@CBA_57
  Scenario:CBA_57_Verify if two services have been selected, the subject line reads "I would like to visit the [location] store for [service1] and [service2]"
    When user selects "Oil Change" in "services"
    When user selects "Pre-Purchase Inspection" in "services"
    Then click on "Continue" button
    When user is navigated to "dropoff" screen
    Then verify subject line - I would like to visit the "South Sarasota" store for "Oil Change and Pre-Purchase Inspection" is displayed

  @tc1
  #@CBA_58
  Scenario:CBA_58_Verify if three or more services have been selected, the subject line reads "I would like to visit the [location] store for multiple services"
    When user selects "Oil Change" in "services"
    When user selects "Pre-Purchase Inspection" in "services"
    When user selects "Fluid Service" in "services"
    Then click on "Continue" button
    When user is navigated to "dropoff" screen
    Then verify subject line - I would like to visit the "South Sarasota" store for "multiple services" is displayed

  @tc1
  #@CBA_59
  Scenario:CBA_59_Verify if the user chooses services with SAW availability, the subheading reads "Based on the services you selected, you can choose to wait while we take care of your vehicle."
    When user selects "Oil Change" in "services"
    Then click on "Continue" button
    When user is navigated to "dropoff" screen
    Then the subheading reads "Based on the services you selected, you can choose to wait while we take care of your vehicle."

  @tc1
  #@CBA_60
  Scenario:CBA_60_Verify if the user chooses services with no SAW availability, the subheading reads "Based on the services you selected, we'll need you to drop off your vehicle."
    When user selects "Fluid Service" in "services"
    Then click on "Continue" button
    When user is navigated to "dropoff" screen
    Then the subheading reads "Based on the services you selected, we’ll need you to drop off your vehicle."






  @tc1
  #@CBA_74
  Scenario:CBA_74_Verify if the user selects "Stay and Wait", the shuttle service option is disabled
    When user selects "Oil Change" in "services"
    And click on "Continue" button
    When user is navigated to "dropoff" screen
    And select stay and wait option
    And shuttle service option is disabled

  @tc1
  #@CBA_79
  Scenario:CBA_79_Verify if the user clicks the "Previous" button, they are taken to the Services screen
    When user selects "Oil Change" in "services"
    Then click on "Continue" button
    When user is navigated to "dropoff" screen
    Then click on "Previous" button
    Then user is navigated to "services" screen

  @tc1
  #@CBA_80
  Scenario:CBA_80_Verify if the user clicks the "Previous" button, they are taken to the Services screen
    When user selects "Oil Change" in "services"
    And click on "Continue" button
    When user is navigated to "dropoff" screen
    Then click on "Previous" button
    When user is navigated to "services" screen
    Then verify "Oil Change" in "services" is "highlighted"

  @tc1
  #@CBA_82
  Scenario:CBA_82_Verify clicking the "Continue" button brings the user to the date/time screen
    When user selects "Oil Change" in "services"
    And click on "Continue" button
    When user is navigated to "dropoff" screen
    And select stay and wait option
    And click on "Continue" button
    Then user is navigated to "date-time" screen

  @tc1
  #@CBA_83
  Scenario: Verify the stepper has 1 checkmark and highlighted calendar icon followed by vehicle icon, person icon, and vehicle with a checkmark icon
    When user selects "Oil Change" in "services"
    And click on "Continue" button
    When user is navigated to "dropoff" screen
    And select stay and wait option
    And click on "Continue" button
    Then user is navigated to "date-time" screen
    Then verify that stepper icon is highlighted

  @tc1
  #@CBA_84
  Scenario:CBA_84_Verify the screen reads "What day and time work best for you?" followed by "Our current availability is listed below. Please select what is most convenient for you."
    When user selects "Oil Change" in "services"
    And click on "Continue" button
    When user is navigated to "dropoff" screen
    And select stay and wait option
    And click on "Continue" button
    Then user is navigated to "date-time" screen
    Then verify "What day and time work best for you?" is displayed
    Then verify "Our current availability is listed below. Please select what is most convenient for you." is displayed

  @tc1
  #@CBA_87
  Scenario:CBA_87_Verify the "Continue" button is disabled until the user selects a time slot.
    When user selects "Oil Change" in "services"
    And click on "Continue" button
    When user is navigated to "dropoff" screen
    And select stay and wait option
    And click on "Continue" button
    Then user is navigated to "date-time" screen
    Then  verify "Continue" button is disabled

  @tc1
  #@CBA_89
  Scenario:CBA_89_Verify the number of time slots available matches the number listed
    When user selects "Oil Change" in "services"
    And click on "Continue" button
    When user is navigated to "dropoff" screen
    And click on "Continue" button
    And user is navigated to "date-time" screen
    Then verify the number of time slots available matches the number listed

    @tc1
  #@CBA_90
  Scenario: Verify the user can select only one slot at at time, which is visually indicated to the userWhen  user selects "Alignment" in "services"
    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    Then user is able to see the available timeslot
    And user select the the available timeslot
    Then user is able to see the available timeslot



  #@tc1
  @CBA_92
  Scenario:CBA_92_Verify if the user has selected the stay and wait option, the "After Hours" time slot option is not available
    When user selects "Oil Change" in "services"
    And click on "Continue" button
    When user is navigated to "dropoff" screen
    And select stay and wait option
    And click on "Continue" button
    And user is navigated to "date-time" screen
    Then verify After Hours time slot is "not available"

  @tc1
  #@CBA_94
  Scenario:Verify if "After Hours" drop off is chosen, a modal appears
    Given user is on the application
    When user selects "Oil Change" in "services"
    And click on "Continue" button
    When user is navigated to "dropoff" screen
    And click on "Continue" button
    And user is navigated to "date-time" screen
    And click on "After Hours" time slot
    Then verify After Hours modal appears

  @tc1
  #@CBA_95
  Scenario:Verify the text for the after hours modal
    Given user is on the application
    When user selects "Oil Change" in "services"
    And click on "Continue" button
    When user is navigated to "dropoff" screen
    And click on "Continue" button
    And user is navigated to "date-time" screen
    And click on "After Hours" time slot
    Then verify After Hours modal appears
    Then verify "You’ve selected After Hours Drop Off." is displayed
    Then verify "What's next?" is displayed
    Then verify "Remove any valuables" is displayed
    Then verify "Lock your vehicle" is displayed
    Then verify "Place only your vehicle key through slot in the door or as instructed (see signage near front door)" is displayed
    Then verify "We will contact you prior to performing any work. Thank you!" is displayed

  @tc1
  #@CBA_96
  Scenario:Verify the after hours modal contains a "Done" button
    Given user is on the application
    When user selects "Oil Change" in "services"
    And click on "Continue" button
    When user is navigated to "dropoff" screen
    And click on "Continue" button
    And user is navigated to "date-time" screen
    And click on "After Hours" time slot
    Then verify After Hours modal appears
    Then user is able to see "Done" button

  @tc1
  #@CBA_97
  Scenario:Verify, when clicked, the after hours "Done" button closes the modal and returns the user to the time/date screen
    Given user is on the application
    When user selects "Oil Change" in "services"
    And click on "Continue" button
    When user is navigated to "dropoff" screen
    And click on "Continue" button
    And user is navigated to "date-time" screen
    And click on "After Hours" time slot
    Then verify After Hours modal appears
    Then click on "Done" button
    Then user is navigated to "date-time" screen
  @tc1
  #@CBA_98
  Scenario:Verify the presence of the X icon in the after hours modal
    Given user is on the application
    When user selects "Oil Change" in "services"
    And click on "Continue" button
    When user is navigated to "dropoff" screen
    And click on "Continue" button
    And user is navigated to "date-time" screen
    And click on "After Hours" time slot
    Then verify After Hours modal appears
    Then verify close button is available on the "After Hours" modal pop up

  @tc1
  #@CBA_99
  Scenario:Verify clicking the X icon in the after hours modal closes the modal and returns the user to the time/date screen
    Given user is on the application
    When user selects "Oil Change" in "services"
    And click on "Continue" button
    When user is navigated to "dropoff" screen
    And click on "Continue" button
    And user is navigated to "date-time" screen
    And click on "After Hours" time slot
    Then verify After Hours modal appears
    Then click on  close button on the "After Hours" modal pop up
    And user is navigated to "date-time" screen


  #@tc1
  @CBA_100
  Scenario:148_Verify tapping the "Previous" button takes the user to the Drop Off/SAW screen with the selected option displayed
    When user selects "Oil Change" in "services"
    And click on "Continue" button
    When user is navigated to "dropoff" screen
    And click on "Continue" button
    And user is navigated to "date-time" screen
    And click on "5:30 PM" time slot
    And click on "Previous" button
    Then user is navigated to "dropoff" screen
    Then verify "drop off" option is selected



  @tc11
  #@CBA_102
  Scenario: CBA_102_Verify the user's time slot selection is present after navigating to the drop off/SAW screen and back
    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And click on the "Previous" button
    And user click on "Continue" button
    And wait for some time to load the page
    Then user is able to see the available timeslot

  @tc11
  #@CBA_103
  Scenario: CBA_103_verify the user can click the "Continue" button after selecting a time slot
    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    And user is navigated to "vehicle-info" screen

  @tc11
  #@CBA_104
  Scenario: CBA_104_Verify the "[MONTH] [YEAR]" of the displayed week is present
    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user click on the "Calender View" button
    Then user is able to see the monthyear

  @tc11
  #@CBA_105
  Scenario: CBA_105_Verify the "Calendar View" option is displayed above and to the right of the appointments section
    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    Then user is able to see the Calender View button

  @tc1
  #@CBA_106
  Scenario: CBA_106_Verify that the  current week is displayed and shows 7 days starting from the current date
    When  user selects "Oil Change" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    Then user is able to see the next 7 dates

  @tc1
  #@CBA_107
  Scenario: CBA_107_Verify that the current day should automatically display as expanded
    When  user selects "Oil Change" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    Then toggle icon is already selected

  @tc1
  #@CBA_111
  Scenario: CBA_111_Verify the user can tap  "Next 7 days", beEasy and to the right of the appointments section, to view the time slots for the folEasying week
    When  user selects "Oil Change" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    When click on "Next 7 days" button
    And wait for some time to load the page
    Then user is able to see the next 7 dates

  @tc1
  #@CBA_112
  Scenario:CBA_112_Verify tapping "Prev 7 days", beEasy and to the left of the appointment section, should take the user to the previous week
    When  user selects "Oil Change" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    When click on "Next 7 days" button
    And wait for some time to load the page
    Then user is able to see the next 7 dates
    When click on "Prev 7 days" button
    And wait for some time to load the page
    Then user is able to see the previous 7 dates


  @tc1
  #@CBA_113
  Scenario:CBA_113_Verify tapping on "Calendar view" should take the user to calendar view
    When user selects "Alignment" in "services"
    And click on "Continue" button
    When user is navigated to "dropoff" screen
    And click on "Continue" button
    And user is navigated to "date-time" screen
    And click on calender view

    @tc2
  #@CBA_115
  Scenario: CBA_115_Verify the user can select a day on the calendar and it will return available times for that date

    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And user click on the "Calender View" button
    And user able to select_available date
    And user verifying available_time slot_for_that_date

      @tc3
  #@CBA_116
  Scenario: CBA_116_Verify if the user has selected a time slot in the week view then tap "Calendar view", the date and time selected in week view are highlighted and displayed in the calendar view

    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And user select the the available timeslot
    And user click on the "Calender View" button
    And user validating the selected date

        @tc3
  #@CBA_117
  Scenario:CBA_117_Verify tapping "Week view" takes the user back to the current weeks view

    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And user click on the "Calender View" button
    Then User validating calender view page
    And user navigates on the "Week view" button
    Then User validating week view page

  @all
  #@CBA_118
  Scenario:CBA_118_Verify the user can tap "Next day" to view the time slots for the following day

    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And user click on the "Calender View" button
    Then User validating calender view page
    And user navigates on the "Next day" button and validates next day page

  #@all
 @CBA_119
  Scenario:CBA_119_Verify tapping on "Prev day" will take the user to the previous day

    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    Then User validating week view page
    And user click on the "Calender View" button
    Then User validating calender view page
    And user able to select nextday date in calender and validating
    And user navigates on the "Previous day" button and validates previous day page

  @all
  #@CBA_120
  Scenario:CBA_120_Verify the user is unable to click on any days that have passed

    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And user click on the "Calender View" button
    Then User validating calender view page
    And user unable to select day that have passed

  @tc3
  #@CBA_123
  Scenario:CBA_123_Verify the stepper has 2 check marks icons and the vehicle icon highlighted followed by the person and  vehicle with a checkmark icons

    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And user select the the available timeslot
    And user click on "Continue" button
    Then user is able to see the vehicle info page
    And user verifying stepper mark

  @tc3
  #@CBA_126
  Scenario:CBA_126_Verify the presence of the "Previous" button

    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And user select the the available timeslot
    And user click on "Continue" button
    Then user is able to see the vehicle info page
    Then user is able to see the previous button

  @tc3
  #@CBA_127
  Scenario:CBA_127_Verify the presence of the "Continue" button

    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And user select the the available timeslot
    And user click on "Continue" button
    Then user is able to see the continue button

  @tc3
 # @CBA_128
  Scenario:CBA_128_Verify that the "Continue" button is disabled until year, make, and model are selected

    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And user select the the available timeslot
    And user click on "Continue" button
    Then user is able to see the continue button is in disable state un till select year

  @tc3
  #@CBA_129
  Scenario:CBA_129_Verify that make is not available until the user has selected a year from the dropdown
    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And user select the the available timeslot
    And user click on "Continue" button
    Then user is able to validating make button un availability
    When user clicks on the year button
    And user validating the year drop down list
    Then user is able to validating make button availability

  @tc3
  #@CBA_130
  Scenario:CBA_130_Verify user can tap on the "Year" field to choose any year from the dropdown

    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    And user validating the year drop down list
    When user selects the "2021" year and verifies page



    @tc3
  #@CBA_132
  Scenario:CBA_132_Verify user can tap on the "Make" field to choose any make from the dropdown once the year has been selected

    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And user select the the available timeslot
    And user click on "Continue" button
    Then user is able to see the vehicle info page
    When user clicks on the year button
    And user validating the year drop down list
    When user selects the "2021" year and verifies page
    When user clicks on the make button
    And user validating makes drop down list
    When user selects the "Acura" make and validating page

  @tc3
  #@CBA_134
  Scenario:CBA_134_Verify the user can tap on the "Model" field to choose a model once the year and make have been selected

    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And user select the the available timeslot
    And user click on "Continue" button
    Then user is able to see the vehicle info page
    When user clicks on the year button
    And user validating the year drop down list
    When user selects the "2021" year and verifies page
    When user clicks on the make button
    And user validating makes drop down list
    When user selects the "Acura" make and validating page
    When user clicks on the model button
    And user validating  model list drop down
    When user selects the "ILX" model

  @tc3
  #@CBA_136
  Scenario:CBA_136_Verify user can tap on the "Color" field to choose any color from the dropdown

    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And user select the the available timeslot
    And user click on "Continue" button
    Then user is able to see the vehicle info page
    When user clicks on the year button
    And user validating the year drop down list
    When user selects the "2021" year and verifies page
    When user clicks on the make button
    And user validating makes drop down list
    When user selects the "Acura" make and validating page
    When user clicks on the model button
    And user validating  model list drop down
    When user selects the "ILX" model
    When user clicks on the color dropdown
    And user validating  color list drop down
    When user selects the "Blue" color


  #@tc3
  @CBA_138
  Scenario:CBA_138_Verify if the user changes the year selection, the appropriate makes are returned for that year

    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And user select the the available timeslot
    And user click on "Continue" button
    Then user is able to see the vehicle info page
    When user clicks on the year button
    And user validating the year drop down list
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    When user clicks on the color dropdown

    When user selects the "Blue" color
    And user able to see the year_model_make

    When user clicks on the year button
    When user selects the "2020" year
    And user able to see the year_model_make


  @tc3
  #@CBA_139
  Scenario:CBA_139_Verify if the user changes the make, the appropriate models are returned for that year and make

    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And user select the the available timeslot
    And user click on "Continue" button
    Then user is able to see the vehicle info page
    When user clicks on the year button
    And user validating the year drop down list
    When user selects the "2021" year and verifies page
    When user clicks on the make button
    And user validating makes drop down list
    When user selects the "Acura" make and validating page
    When user clicks on the model button
    And user validating  model list drop down
    When user selects the "ILX" model
    When user clicks on the color dropdown
    And user validating  color list drop down
    When user selects the "Blue" color
    When user clicks on the make button
    And user validating makes drop down list
    When user selects the "Audi" make and validating page


  @tc3
  #@CBA_140
  Scenario:  CBA_140_Verify clicking the "Previous" button will take the user to the date/time screen


    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And user select the the available timeslot
    And user click on "Continue" button
    Then user is able to see the vehicle info page
    When user clicks on the year button
    And user validating the year drop down list
    When user selects the "2021" year and verifies page
    When user clicks on the make button
    And user validating makes drop down list
    When user selects the "Acura" make and validating page
    When user clicks on the model button
    And user validating  model list drop down
    When user selects the "ILX" model
    When user clicks on the color dropdown
    And user validating  color list drop down
    When user selects the "Blue" color
    And click on the "Previous" button
    Then User validating week view page
  @tc3
  #@CBA_141
  Scenario: Verify when the "Previous" button has been clicked, the selected time/date are still selected
    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    And user click on "Previous" button
    Then user is able to see the available timeslot

  @tc3
  #@CBA_142
  Scenario:  CBA_142_Verify once all of the required fields are selected, clicking the "Continue" button takes the user to the personal info screen


    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
   And user select the the available timeslot
    And user click on "Continue" button
    Then user is able to see the vehicle info page
    When user clicks on the year button
    And user validating the year drop down list
    When user selects the "2021" year and verifies page
    When user clicks on the make button
    And user validating makes drop down list
    When user selects the "Acura" make and validating page
    When user clicks on the model button
    And user validating  model list drop down
    When user selects the "ILX" model
    When user clicks on the color dropdown
    And user validating  color list drop down
    When user selects the "Blue" color
    And user click on "Continue" button
    Then User validating personal info page
  @tc3
  #@CBA_143
  Scenario: CBA_143_Verify the stepper has 3 check icons and the person icon highlighted followed by the vehicle with a check icon in the stepper


    When  user selects "Alignment" in "services"
    And user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And user able to select available_time
    And user click on "Continue" button
    Then user is able to see the vehicle info page
    And Make model colour buttons are not enabled
    When user clicks on the year button
    And user validating the year drop down list
    When user selects the "2021" year and verifies page
    When user clicks on the make button
    And user validating makes drop down list
    When user selects the "Acura" make and validating page
    When user clicks on the model button
    And user validating  model list drop down
    When user selects the "ILX" model
    When user clicks on the color dropdown
    And user validating  color list drop down
    When user selects the "Blue" color
    And user click on "Continue" button
    Then User validating personal info page
    And user verifying stepper mark
  @tc3
  #@CBA_147
  Scenario: Verify the "Continue" button is disabled until the user enters all of the required fields without any errors.
    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    Then "Continue" button is Enabled

  @tc3
  #@CBA_148
  Scenario: CBA_148_Verify the "First name" field is present and required
    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    And "firstName" is present
    And user click on "Continue" button
    Then user is able to see error message "Please enter your first name"


  @tc3
  #@CBA_149
  Scenario: CBA_149_Verify the "Last name" field is present and required
    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    And "lastName" is present
    And user click on "Continue" button
    Then user is able to see error message "Please enter your last name"

  @tc3
  #@CBA_150
  Scenario: CBA_150_Verify the "Email" field is present and required
    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    And "email" is present
    And user click on "Continue" button
    Then user is able to see error message "Please enter a valid email address"

  @tc3
  #@CBA_151
  Scenario: CBA_151_Verify the "Phone number" field is present and required
    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    And "phone" is present
    And user click on "Continue" button
    Then user is able to see error message "Please enter a 10 digit phone number"
  @tc3
  #@CBA_152
  Scenario: CBA_152_Verify the "Zip code" field is present and required
    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    And "zip" is present
    And user click on "Continue" button
    Then user is able to see error message "Please enter a valid zip code"
  @tc3
  #@CBA_153
  Scenario: CBA_153_Verify the "Last name" field is present and required
    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    And "altPhone" is present
    And user click on "Continue" button
    Then user is not  able to see error message
  @tc3
  #@CBA_154
  Scenario: CBA_154_Verify the text "Is this your first time visiting our South Sarasota store?*" radio button is present and required
    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    And Location question is present
    And user click on "Continue" button
    Then user is able to see error message "Please choose Yes or No"
  @tc3
  #@CBA_155
  Scenario: CBA_155_Verify the presence of the "Yes" and "No" radio buttons
    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    And radio buttons are present

  @tc3
  #@CBA_157
  Scenario: CBA_157_Verify if the user attempts to press the "Continue" button without the required fields filled out, inline errors are shown
    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    And user click on "Continue" button
    Then user is able to see the inline error messages
  @tc3
  #@CBA_163
  Scenario: CBA_163_Verify if the user enters an invalid email address format the inline error is displayed
    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    And user enters an invalid "email" "ishrar134gmail.com"
    Then user is able to see error message "Please enter a valid email address"
  @tc3
 #@CBA_166
  Scenario: CBA_166_Verify if the user enters an invalid email address format the inline error is displayed
    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    And user enters an invalid "phone" "7879888"
    Then user is able to see error message "Please enter a 10 digit phone number"
  @tc3
  #@CBA_170
  Scenario: CBA_170_Verify the "Alt. phone number" is capped at 10 digits
    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    And user enters an invalid "altPhone" "123456789012"
    Then getting the value of "altPhone"

  @tc3
  #@CBA_176
  Scenario: CBA_176_Verify tapping the "Previous" button will take the user to the Vehicle Info screen
    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    When user enter "firstName" as "Rahul"
    When user enter "lastName" as "Kumar"
    When user enter "email" as "Rahul12@gmail.com"
    When user enter "phone" as "1234567890"
    When user enter "altPhone" as "0987654321"
    When user enter "zip" as "112223"
    Then click on "Previous" button
    Then user is navigated to "vehicle-info" screen
    Then user is able to see the "2021" year "Acura" make and "ILX" model
  @tc3
  #@CBA_177
  Scenario: CBA_177_Verify tapping the "Continue" button on the vehicle info screen brings the user to the personal information screen with information preserved
    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    When user enter "firstName" as "Rahul"
    When user enter "lastName" as "Kumar"
    When user enter "email" as "Rahul12@gmail.com"
    When user enter "phone" as "1234567890"
    When user enter "altPhone" as "0987654321"
    When user enter "zip" as "112223"
    Then click on "Previous" button
    And user click on "Continue" button
    Then user is navigated to "personal-info" screen

  @tc3
  #@CBA_179
  Scenario: Verify the stepper has 4 check marks  and the vehicle checkmark icon is highlighted
    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    When user enter "firstName" as "Rahul"
    When user enter "lastName" as "Kumar"
    When user enter "email" as "Rahul12@gmail.com"
    When user enter "phone" as "1234567890"
    When user enter "altPhone" as "0987654321"
    When user enter "zip" as "112223"
    When user clicked on the yes button
    And user click on "Continue" button
    Then verify that stepper icon is highlighted

  @tc3
  #@CBA_181
  Scenario: Verify the user sees their selected service(s) in the first sectioned area
    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    When user enter "firstName" as "Rahul"
    When user enter "lastName" as "Kumar"
    When user enter "email" as "Rahul12@gmail.com"
    When user enter "phone" as "1234567890"
    When user enter "altPhone" as "0987654321"
    When user enter "zip" as "112223"
    When user clicked on the yes button
    And user click on "Continue" button
    Then user sees their selected service in the first sectioned area

  @tc3
  #@CBA_182
  Scenario: Verify the user sees their specified drop off/SAW method the selected services in the first sectioned area
    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    When user enter "firstName" as "Rahul"
    When user enter "lastName" as "Kumar"
    When user enter "email" as "rahul12@gmail.com"
    When user enter "phone" as "1234567890"
    When user enter "altPhone" as "0987654321"
    When user enter "zip" as "112223"
    When user clicked on the yes button
    And user click on "Continue" button
    Then user sees their Drop off or Sit and Wait service in the first sectioned area


  @tc3
  #@CBA_183
  Scenario:Verify if the user has chosen an after hours time slot, the "i" icon is present to the right of the appointment type
    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the "After Hours" timeslot
    And user is able to click on the done button
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    When user enter "firstName" as "Rahul"
    When user enter "lastName" as "Kumar"
    When user enter "email" as "Rahul12@gmail.com"
    When user enter "phone" as "1234567890"
    When user enter "altPhone" as "0987654321"
    When user enter "zip" as "112223"
    When user clicked on the yes button
    And user click on "Continue" button
    Then user is able to see the i button in the review page

  @tc3
  #@CBA_184
  Scenario: Verify if the user clicks the "i" icon, the after hours modal appears
    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the "After Hours" timeslot
    And user is able to click on the done button
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    When user enter "firstName" as "Rahul"
    When user enter "lastName" as "Kumar"
    When user enter "email" as "Rahul12@gmail.com"
    When user enter "phone" as "1234567890"
    When user enter "altPhone" as "0987654321"
    When user enter "zip" as "112223"
    When user clicked on the yes button
    And user click on "Continue" button
    Then user click on the i button in the review screen
    Then user is able to see the after model

  @tc3
  #@CBA_185
  Scenario:Verify if the user has chosen an after hours time slot, the "i" icon is present to the right of the appointment type
    When  user selects "Other" in "services"
    And user add "my vehicle name is Appache"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    When user enter "firstName" as "Rahul"
    When user enter "lastName" as "Kumar"
    When user enter "email" as "Rahul12@gmail.com"
    When user enter "phone" as "1234567890"
    When user enter "altPhone" as "0987654321"
    When user enter "zip" as "112223"
    When user clicked on the yes button
    And user click on "Continue" button
    Then see their additional notes in the first sectioned area

  @tc3
  #@CBA_187
  Scenario:Verify if the user has chosen an after hours time slot, the "i" icon is present to the right of the appointment type
    When  user selects "Other" in "services"
    And user add "my vehicle name is Appache"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    When user enter "firstName" as "Rahul"
    When user enter "lastName" as "Kumar"
    When user enter "email" as "Rahul12@gmail.com"
    When user enter "phone" as "1234567890"
    When user enter "altPhone" as "0987654321"
    When user enter "zip" as "112223"
    When user clicked on the yes button
    And user click on "Continue" button
    And user click on  "1" Edit button in "first sectioned area" area
    Then user is navigated to "https://cbascheduler-frontend-dev.azurewebsites.net/south-sarasota/" screen

  @tc3
  #@CBA_202
  Scenario: Verify the chosen location's name, address, and phone number are displayed in the third sectioned area
    When  user selects "Alignment" in "services"
    And user add "my vehicle name is Appache"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    When user enter "firstName" as "Rahul"
    When user enter "lastName" as "Kumar"
    When user enter "email" as "Rahul12@gmail.com"
    When user enter "phone" as "1234567890"
    When user enter "altPhone" as "0987654321"
    When user enter "zip" as "112223"
    When user clicked on the yes button
    And user click on "Continue" button
    Then user is able to see the chosen location's name as "South Sarasota", address as "5869 Derek Ave", and phone number as "(941) 413-3490" in the third sectioned area.

  @tc3
  #@CBA_209
  Scenario: Verify the chosen location's name, address, and phone number are displayed in the third sectioned area
    When  user selects "Alignment" in "services"
    And user add "my vehicle name is Appache"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the available timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    When user enter "firstName" as "Rahul"
    When user enter "lastName" as "Kumar"
    When user enter "email" as "Rahul12@gmail.com"
    When user enter "phone" as "1234567890"
    When user enter "altPhone" as "0987654321"
    When user enter "zip" as "112223"
    When user clicked on the yes button
    And user click on "Continue" button
    And user click on  "4" Edit button in "fourth sectioned area" area
    And user is navigated to "personal-info" screen

  @tc3
  #@CBA_212
  Scenario:CBA_212_Verify shuttle service verification is disabled if the user has chosen a stay and wait appointment

    When user selects "Oil Change" in "services"
    And click on "Continue" button
    When user is navigated to "dropoff" screen
    And select stay and wait option
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the "5:00 PM" timeslot
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    When user enter "firstName" as "Rahul"
    When user enter "lastName" as "Kumar"
    When user enter "email" as "rahul12@gmail.com"
    When user enter "phone" as "1234567890"
    When user enter "altPhone" as "0987654321"
    When user enter "zip" as "112223"
    When user clicked on the yes button
    And user click on "Continue" button
    Then shuttle service option should be disabled

  @tc3
  #@CBA_213
  Scenario:CBA_213_Verify shuttle service verification is disabled if the user has chosen an after hours appointment

    When  user selects "Alignment" in "services"
    And   user click on "Continue" button
    Then "Drop and vehicle" button is already selected
    And user click on "Continue" button
    And wait for some time to load the page
    And user select the the "After Hours" timeslot
    And user is able to click on the done button
    And user click on "Continue" button
    When user clicks on the year button
    When user selects the "2021" year
    When user clicks on the make button
    When user selects the "Acura" make
    When user clicks on the model button
    When user selects the "ILX" model
    And user click on "Continue" button
    When user is on personal info page
    When user enter "firstName" as "Rahul"
    When user enter "lastName" as "Kumar"
    When user enter "email" as "rahul12@gmail.com"
    When user enter "phone" as "1234567890"
    When user enter "altPhone" as "0987654321"
    When user enter "zip" as "112223"
    When user clicked on the yes button
    And user click on "Continue" button
    Then hover on "Previous" button
    Then shuttle service option should be disabled


#    @CBA_nectday
#    Scenario: able to see next day
#      When  user selects "Alignment" in "services"
#      And user click on "Continue" button
#      Then "Drop and vehicle" button is already selected
#      And user click on "Continue" button
#      Then User validating week view page
#      And user click on the "Calender View" button
#      Then User validating calender view page
#      And user navigates on the "Next day" button and validates next days page
#      #And user navigates on the "Previous day" button and validates previous day page

  @CBA_49
  Scenario: Verify when user enter more than 500 characters in the text box (including spaces)
    When  user selects "Other" in "services"
    And user add "my vehicle name is Appache" and validating size is not more than 500

@CBA_51
Scenario: Verify, the modal is open when click on "i" icon, the portion of the screen outside of the modal is blurred
  When user clicks on the "Common Services" "1"  button
  Then user not able to see "Other" in "services"










































































