# Lippia Web sample project

This project has the intention of show in a practical way how to use Lippia Automation Framework to build automated tests using Gherkin and Page-Object pattern. This sample project includes the required components as binaries, docker containers and configuration files to simply download and run a set of sample tests in your local computer, using the Lippia container stack described bellow.

***


## Docker stack

The following project includes the basic Docker Lippia Containers to run this  web sample project. You can choose to run the code from your favourite IDE, run from console or from Jenkins using the Docker Stack.
To install and start a local instalation with Docker containers go to **Getting started** at the end of this guide. 

![Lippia Extent Report](docs/img/architecture_web_lippia.png)

## Project structure

A typical Lippia Test Automation project usually looks like this 

```
	.
├── main
│   ├── java
│   │   └── com
│   │       └── crowdar
│   │           └── practica
│   │               ├── pages
│   │               │   ├── PageBaseSwagLabs.java
│   │               │   ├── SwagLabsHomePage.java
│   │               │   ├── SwagLabsLoginPage.java
│   │               └── steps
│   │                   └── SwagLabsSteps.java
│   └── resources
│       ├── config.properties
│       ├── cucumber.properties
│       └── webdrivermanager.properties
└── test
    ├── java
    │   ├── CrowdTestNgParallelRunner.java
    │   ├── CrowdTestNgRunner.java
    │   └── com
    │       └── crowdar
    │           └── Hooks.java
    └── resources
        └── features
            └── swagLabsLoading.feature
	    └── swagLabsLogin.feature
```

Folder's description:

|Path   |Description    |
|-------|----------------|
|main\java\\...\practica\pages\\\*.java|Folder with all the **PageObjects** matching steps with java code|
|main\java\\...\practica\steps\\\*Steps.java|Folder with all the **steps** wich match with Gherkin Test Scenarios |
|test\resources\features\\\*.feature|Folder with all the **feature files** containing **Test Scenarios** and **Sample Data** |
|main\resources|Folder with all configuration needed to run Lippia |

In this example, *SwagLabs* is the first web page the framework will interact with. The **steps** defined in *SwagLabsSteps.java* to execute the *Test Scenarios* defined in Gherkin language. 


|File   | Description    |
|-------|----------------|
|PageBaseSwagLabs.java    | Define base URL to navigate. |
|SwagLabsLoginPage.java   | PageObject: between each element in the webpage *SwagLabsLoginPage* you want to interact with. You need to add one new file for each page you want to navigate in your tests. |
|SwagLabsSteps.java   | StepOpject: Code to support the behaviour of each **step** coded into the feature files for the *SwagLabsLoginPage* web page. This code executes the interaction between the Framework and the web application and match the steps with the code who run interactions. |
|swagLabsLoading.feature & swagLabs | Feature file: Definition of the **Test Scenarios** with all the **steps** written in Cucumber format (http)|

# Getting started
    
- If you are Linux user 
    [`Getting started - Linux User`](docs/README_Linux.md)
- If you are Windows user
    [`Getting started - Windows User`](docs/README_Windows.md)
    
    
"This project is licensed under the terms of the MIT license."


# Update Version Lippia 3

## Main Features: 
- Added multiple reports of extent reports
- Added the feature to handle the chrome options by a json file
- Include project type properties that allows to decide wich library would need for the project
- Added the dependency for lippia report server 
- Cucumber version updated


## Multiple reports templates:
 - With this version of Lippia the user have the possibility to choose which kind of template for html reports is the best for the project requirements.
   The user only need to turn on the flag in the extent.properties file located in src/test/resources.
   
   
### Some examples of this are
   
#### Avenstack template:
   ![aventstack_report] (https://bitbucket.org/crowdarautomation/lippia-web-sample-project/raw/91f94d530c4b87c88731a59e6285843926543b58/docs/img/aventstack_report.png)
   
#### BDD template:
   ![bbd_report] (https://bitbucket.org/crowdarautomation/lippia-web-sample-project/raw/91f94d530c4b87c88731a59e6285843926543b58/docs/img/bbd_report.png)
   
#### Cards template:
   ![cards_report] (https://bitbucket.org/crowdarautomation/lippia-web-sample-project/raw/91f94d530c4b87c88731a59e6285843926543b58/docs/img/cards_report.png)
   
## Chrome driver options file:   
 - Added the ability to set up the options for the chromedriver in order to have all of the properties setted. For example the user is allowed to set the headless value.

```
 {
  "browserName": "chrome",
  "goog:chromeOptions": {"args": ["disable-infobars","--headless","--window-size=1440x900", "--no-sandbox", "--disable-dev-shm-usage" , "--ignore-certificate-errors", "--start-maximized", "--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36"],
    "extensions": [],
    "prefs": {"printing.enabled": false}
  },
  "platform": "ANY",
  "recordVideo":"false"
}
```

Also as you can see in this file you can set up the record video property to get the evidence of the each flow in a video


## Project type options:
- The project type option allows the user to say Lippia which library would need to download. For this project is setted the WEB_CHROME one that uses the library for this webdriver.
  This option can be changed in the pom.xml file
  You can get more information checking the readme from lippia-core project.
  
  ProjectTypes for web project: 		

 	WEB_CHROME
        crowdar.projectType=WEB_CHROME
        crowdar.projectType.driverCapabilities.jsonFile=src/main/resources/browsers/chromeCapabilities.json
        crowdar.setupStrategy=web.DownloadLatestStrategy

 	WEB_FIREFOX
        crowdar.projectType=WEB_FIREFOX
        crowdar.projectType.driverCapabilities.jsonFile=src/main/resources/browsers/firefoxCapabilities.json
        crowdar.setupStrategy=web.DownloadLatestStrategy

 	WEB_EDGE
        crowdar.projectType=WEB_EDGE
        crowdar.projectType.driverCapabilities.jsonFile=src/main/resources/browsers/edgeCapabilities.json
        crowdar.setupStrategy=web.DownloadLatestStrategy

 	WEB_IE
        crowdar.projectType=WEB_IE
        crowdar.projectType.driverCapabilities.jsonFile=src/main/resources/browsers/ieCapabilities.json
        crowdar.setupStrategy=web.DownloadLatestStrategy

 	WEB_SAFARI
        crowdar.projectType=WEB_SAFARI
        crowdar.projectType.driverCapabilities.jsonFile=src/main/resources/browsers/safariCapabilities.json
        crowdar.setupStrategy=web.DownloadLatestStrategy 

