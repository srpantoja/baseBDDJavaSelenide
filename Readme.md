# Selenium Test Automation Project

This project is an example of test automation using Java with OpenJDK 20, Maven 3.9.1, Cucumber 7 and Selenium 4, as well as using the Page Object Model (POM) and Page Factory design pattern.
## 🛠️ Technologies Used

- Java openJDK 20
- Maven 3.9.1
- Cucumber 7
- Selenide 6.13.1

## 📂 Project Structure

- `src/test/java/runners`: Contains the classes that execute the automated tests.
- `src/test/java/steps`: Contains the classes that define the steps of the automated tests.
- `src/test/resources/features`: Contains the resource files used by Cucumber.
- `src/main/java/cucumber`: Contains the classes that define the Test Context of Cucumber to share information between classes.
- `src/main/java/data`: Contains the classes that define the data objects used by the tests.
- `src/main/java/dataProviders`: Contains the classes that provide data for the tests.
- `src/main/java/enums`: Contains the classes that define the enumerations used by the project.
- `src/main/java/managers`: Contains the classes that manage the instances of the objects used by the tests, example: `DriverManager`, `FileReaderManager` and `PageObjectManager`.
- `src/main/java/pages`: Contains the classes that define the pages of the system that will be automated.
- `config/Config.properties`: Contains the properties of the project.



## 🚀 How to Install

1. Clone this repository to your local machine.
2. Make sure you have Java JDK 20 and Maven 3.9.1 installed on your system.
3. Open the project in your favorite IDE.
4. Run `mvn clean install` to download the project dependencies.

## 💻 IDEs to Use

We recommend using either IntelliJ IDEA or Eclipse as your IDE.

## 🏃‍♀️ How to Run Tests

1. Open the project in your favorite IDE.
2. Go to the `src/test/java/runners` package.
3. Run the `RunCucumberTest.java` file as a JUnit test.

## 🔧 How to Configure Properties

The project properties are defined in the `config/Config.properties` file. In this file, you can define the system URLs, access credentials, the browser that will be used to run the tests, among other settings.

To configure the project properties, follow these steps:

1. Open the `config/Config.properties` file.
2. Set the `environment` property to either `local` or `remote`.
3. Set the `browser` property to `chrome`, `firefox`, `safari`, or `edge`.
4. Set the `headlessMode` property to `true` if you want to run the tests in headless mode. This property is optional and its default value is `false`.
5. Set the `windowMaximize` property to `true` if you want to maximize the browser window before running the tests. This property is optional and its default value is `true`.
6. Set the `implicitlyWait` property to the number of seconds that you want Selenium to wait for an element to be found before throwing a `NoSuchElementException`. This property is optional and its default value is `30`.
7. Set the `url` property to the URL of the system that you want to test. The URL should start with `https://`.

Here's an example of what the `config/Config.properties` file should look like:

``` 
environment=local
browser=chrome
headlessMode=true
windowMaximize=true
implicitlyWait=20
url=https://seubarriga.wcaquino.me
```

Make sure to update the properties according to the environment and URL you want to test.
