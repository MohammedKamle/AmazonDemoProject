# Test Automation Framework for Mobile Application Testing
&#8594;This is a sample project to demonstrate what is Page Object Model framework and how it can used with appium to automate any mobile application.\
&#8594;TestNG is used as test framework.
## System Requirements
```
Windows or Mac
Java
Appium 
Appium desktop
Android studio
node.js
npm
```
## Application under test
Amazon

## Libraries used
```
Selenium
Appium
TestNG
log4j
Extent Reports
```
## Build Management Tool
Maven

## How to run the test ?
&#8594;Clone the project from https://github.com/MohammedKamle/AmazonDemoProject \
&#8594;Give the device name and device udid in global.properties file. \
&#8594;You can either run your test on real device or on an emulator but make sure in emulator name there should be "emulator" string present. \
&#8594;Give your emulator path in startEmulator.bat file in \\src\\main\\java\\com\\resources. \
&#8594;Go to the project directory on command propmt or termmianl. \
&#8594;Type mvn test
## TEST RESULTS
&#8594;ExtentReports is used to obatin the test results which is stored under the "Reports" folder at project level. \
&#8594;The logs of the test is stored under the "logs" folder which is obtained using log4j library.
