@TP2-29
Feature: Test as an Admin I can create a new account successfully

	@TEST_TP2-27
	Scenario Outline: Verify that users can login successfully
		Given Open chrome and start application
		When I enter valid '<username>','<password>' fields
		Then user should be able to login successfully
		Examples:
		|username|password|
		|E1125316|Plm12345|
	@TEST_TP2-28
	Scenario Outline: Verify that users can create a new account successfully
		Given I have already accessed to create part page
		When I enter valid '<type>','<partfamily>' values
		And I clicked on Save button
		Then I created a part successfully
		Examples:
		| TypeActualDisplay|PartFamilyId|VPMProductName1|
		| Battery and Accessory Part|Batteries|Test Data sel|
	@TEST_TP2-30
	Scenario: close a browser
		Given I close a browser
