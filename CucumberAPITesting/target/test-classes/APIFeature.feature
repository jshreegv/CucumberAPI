
Feature: Test Tekarch API

  Scenario: Login with valid username and password
		Given Set the EndPoint
		When Send Post HTTP request
		Then Validate the response
		
		 Scenario: Get AllUsers
		Given Set the EndPoint GetData
		When Send Get HTTP request
		Then Validate the response for getData