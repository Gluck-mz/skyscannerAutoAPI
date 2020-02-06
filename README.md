# API Automation Tests for Skyscanner RAPID API

Here you can find a API automation test example and api tests to get all carriers between Sydney and Melbourne.


## How to use
Required packages and basic setup is done.


## Tech Stack
1) Java 1.8
2) TestNG
3) Rest-Assured
4) Maven
5) Maven Sure Fire plugin


## CI integration
All the tests are configured to run automatically in CI - Azure Devops whenever a new commit is made to the git repository.
You can see the results here:
https://dev.azure.com/vysakhav0887/TestAutomation-Demo/_build?definitionId=1&_a=summary&view=runs

It will also generate a report based on Sure Fire. A sample report can be seen here:
https://dev.azure.com/vysakhav0887/TestAutomation-Demo/_build/results?buildId=9&view=ms.vss-test-web.build-test-results-tab


## To Run Tests
You can run the tests with by running the pom.xml file with maven build.
Packages configured in the testng.xml file will run once the maven triggers with configurations in pom.xml


