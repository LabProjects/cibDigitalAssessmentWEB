# cibDigitalAssessmentWEB

1 Setup instructions

  * JDK 21.0.4
  * Maven 3.6.9 / any latest
  * Git
  * Intellij ( Install pluggin called "Cucumber for Java") 2 How to run the tests
  * jenkins.war
  * Github access

2 How to run the tests

  Tests can be run locally and on Jenkins
  * Locally
    * Open this project using Intellij (Community/ultimate)
    * Let your project build completely, you can confirm this by going to the Main menu > Build > Build Project
    * To run one single test:
    * Go to src > test > java > runners > webRunner and click on Run icon on loc 13
    * To run parallel test:
    * Go to src > test > java > runners > webRunnerParallel and click on Run icon on loc 13
    * If there's a failed test during your execution:
    * Go to src > test > java > runners > TestRunnerFails and click on Run icon on loc 16 Note: you can also open the feature file and run from there but you won't be able to get the report. So run there if you are debugging the code only
  * Jenkins
    * There's two builds i've created on Jenkins for this project:
      * Locally (cibDigitalAssessmentWEB_locally)
      * This will run the project locally if you have jenkins configured and running to allow jobs (Jenkins and Intellij integration)
    * Remote (cibDigitalAssessmentWEB_remote)
      *  This will run the project locally as well but this is an integration between Github and Jenkins and it does require you to have Jenkins server running
      * Note : There are couple of jobs already ran and you can open one maven project created and do your own build and see the stats through the published report    

3 An overview of your project structure

  This project is completely a maven project that supports BDD, below is how the structure looks
  
  * Config : This package contains an xml file to allow one to edit constant values like URL, browsers, Const pass/usernames
  * Report : This package gets driven by the script during execution using runner classes and it will create a detailed extentreports in the form of PDF, Excel and HTML.
  * src/test/java/driverManager : This package contains a class called DriverSetup which setup the drivers and all of these drivers are driven by DriverManager dependency
  * src/test/java/repos : This package contains three classes where each have it functinalities
  * Actions: Inside this class you will find reusable functions that supports WebDriver e.g. driver.findElement/s functionalities
  * utils: Inside this class i pass all reusable functions that will help one to build a flexible data-driven framework e.g. excel reader/writter, dbReader, CSV reader/ writter, JSON reader/writter etc
  * webtablesObj: Inside this class i pass objects that can be used/called inside stepDefinitions classes e.g. xpath/name/id/linktext etc
  * src/test/java/runners : These classes assist with execution of the tests
  * src/test/java/stepDefinitions : The package consists of two class
  * Hooks : They are just there to drive/guide your execution and takescreenshots after each step is executed and to quit the driver
  * src/test/resources/Features: The package is there to allow you to write your testcases in Gherkin language and you can have multiple of them in different packages. More like your QC
  * src/test/resources/extent.properties : Inside this file i just write how my report should look and what folders/features i want after execution
  * src/test/resources/spark-config.xml : This file just set the configs to your report style
  * src/target/rerunFails.txt : This txt file keep the record of only the failures during execution
  * gitignore : This file contains those items i don't want to keep on my cloud repo
  * pom.xml : This is the driver of depencencies that will make the project to be plug and play on different machines

4 Any assumptions or decisions made

   * The above project does run perfectly fine from the runner files but if you go the route of mvn test only parallel exec will run and i've been trying to figure this out as i know for sure it's dependencies along with the builds. Time was something that i didn't have at all and this will be fixed soon.
   * Reports won't be generated using this framework and is because of changes i've made to the pom/dependecies to cater for other things i wanted to achieve for this assessment but i have the below project that can be close and ran from the runner classes to get the report.
     repo : 

5 List of tools and resources used 

  * IDE (Intellij)
  * Selenium BDD approach (Using Java) for Web

