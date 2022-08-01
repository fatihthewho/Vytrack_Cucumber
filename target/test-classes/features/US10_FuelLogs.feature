Feature: Vehicle Fuel Logs
  User Story: Truck Driver should be able to access vehicle fuel logs


  Background:
    Given I am on home page  as a truck driver user
    When I click the vehicle fuel logs under the Fleet button
    Then I should be able to on vehicle fuel logs page

    @smoke @regression
    Scenario: Truck driver should access fuel logs
      When I am on vehicle fuel logs as a truck driver
      Then I should be able to  access to vehicle fuel logs page


      @smoke @regression @datainput
      Scenario: Truck driver should be able to create fuel logs
      When I click create a vehicle fuel logs button on the top right
      And Create Vehicle Fuel Logs page opens
      And I enter valid informations for new vehicle
        |Odometer Value     |  100000        |
        |Liter              |   100          |
        |Price Per Liter ($)|   2            |
        |Total Price ($)    |   200          |
        |Date               |   Jul 7, 2022  |
        |Purchaser          |   Holden       |
        |Invoice Reference  |   126654654    |
        |Vendor             |    Carmax      |
        |Info               |     Paid cash  |
        And click save and close button
      Then I should be able to creat vehicle fuel logs


        @smoke @regression
        Scenario:User should be able to cancel on vehicle create page
          When I click create a vehicle fuel logs button on the top right
          And Create Vehicle Fuel Logs page opens
          And I click cancel button
          Then I should be able cancel

          @smoke @regression
          Scenario: User should be able to edit any vehicle fuel logs
          When I click any vehicle on the fuel logs
          And information page about that vehicle should open
          And I click edit button
          Then I should be able to edit/change any information on the page


          @regression
          Scenario: User should be able to delete
              When I click any vehicle on the fuel logs
              And information page about that vehicle should open
              And I click delete button
              Then I should be able to delete

            @regression
            Scenario: User should be able attach valid file
              When I click any vehicle on the fuel logs
              And information page about that vehicle should open
              And I click add attachment button
              And I click the choose file button and choose file
              And I click save
              Then I should be able to attach file

              @regression
              Scenario: User should be able to add event
                When I click any vehicle on the fuel logs
                And information page about that vehicle should open
                And I click add event button
                And I enter valid informations into text areas
                And I click save button
                Then I should be able to see add an event.

                @regression
                Scenario: User should be able to reset
                  When I click grid settings button
                  And I unselect all checkboxes on the settings
                  And when I click reset button
                  Then all changes I made before should be resetted






