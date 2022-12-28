# WeatherApplication
This is a simple desktop weather forecast application in Java and JavaFX. Application enables you to get five days forecast for searched city, and compares it with weather in other city. To do this WeatherApplication use [AccuWeather API](https://developer.accuweather.com/), so you should create a unique api key for free if you want to use this application.

## Starting application using Maven
If you don’t have Maven or Java on your computer yet, you may be interest in this tutorials: [How to install Apache Maven](https://www.youtube.com/watch?v=RJZOVUA0vY8) and [How to install Java](https://www.youtube.com/watch?v=JtaO44dvDCQ).
1. First, download the framework, either directly or by cloning the repo.
1. Open console and type mvn clean package javafx:run - this will install all dependencies, create jar file, and run application.
2. (The jar file: weather-application-1.0.jar will be automatically created in target folder, so next time to run WeatherApplication double click on it)
3. Type your unique api key in WeatherApplication welcome window and check forecast for any city you want.


## Technologies
Project is created with:
* Java version: 11.0.2
* JavaFX version: 11.0.2
* Gson version 2.9.1
* JUnit version: 5.0.0
* Mockito version 2.24.0

## 
![welcome](https://user-images.githubusercontent.com/94690429/209123172-9ad908ba-3e74-4788-89dd-5e6582af8302.PNG)

![search](https://user-images.githubusercontent.com/94690429/209124261-b0ea6144-a505-4a76-be83-a7a5d8d48cac.png)
