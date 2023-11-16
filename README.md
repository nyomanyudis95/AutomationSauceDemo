# AutomationSauceDemo

## Overview
This is project java for assignment JayJay Module 21. This is project java for automation Website Testing using Selenium, JUnit, and Cucumber. Also using gradle 
for build tool. API url for automation task is https://www.saucedemo.com/

## Getting Started 
These instructions will guide you on how to set up the project on your local machine for development and testing purposes.

### Prerequites 
Before getting started, ensure that you have the following software installed on your machine:

1. Java JDK: download and install the latest version of Java JDK from the official Oracle website (https://www.oracle.com/id/java/technologies/downloads/).
2. Gradle: Install Gradle by following the official Gradle installation guide (https://gradle.org/install/), but in this case, we are using 'gradlew'.

### Installing 
To set up the development environment, follow these steps:

1. Clone this repository to your local machine using Git or download the ZIP file and extract it.
2. Open the project in your preferred Java IDE (e.g., IntelliJ or Eclipse).
3. Build the project and download dependencies using Gradle by running the following command in the terminal: ./gradlew clean build

## Running the test
To execute the automated website test , run this custom task gradle on terminal: ./gradlew cucumber 
Make sure your terminal file path already in folder project, or you can run this automation test in file cucumber runner that located at src/test/java/com/saucedemo/runner/CucumberRunnerTest.java. 

## Test Result 
<img width="1440" alt="image" src="https://github.com/nyomanyudis95/AutomationSauceDemo/assets/44666702/1f81a804-afab-4c41-8298-a5074fed0029">

<img width="1440" alt="image" src="https://github.com/nyomanyudis95/AutomationSauceDemo/assets/44666702/660054f5-deea-43a3-b896-93b99271f193">



