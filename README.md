# **Maven-Junit Selenium Automation Testing Framework**

This repository is a comprehensive **Selenium WebDriver** automation framework built with **JUnit** and **TestNG** for efficient web testing. It supports cross-browser testing on **Chrome**, **Firefox**, and **Edge**, and includes various testing strategies like parallel execution, handling alerts, interacting with iframes, and managing cookies.

The framework is designed to be easy to set up and extend, providing reusable components for your web testing needs.

## **Project Overview**

This project automates testing for a sample web application: **SauceDemo** (https://www.saucedemo.com/), implementing several test cases for:
- Validating page titles
- Logging in
- Verifying page elements (like font size, buttons)
- Handling alerts and pop-ups
- Managing cookies and dropdowns
- Interacting with iframes
- Cross-browser testing using **Selenium** WebDriver

### **Key Features:**
- **Cross-Browser Testing** (Chrome, Firefox, Edge)
- **JUnit** and **TestNG** for flexible test management
- **WebDriverManager** for automatic browser driver setup
- **Implicit and Explicit Waits** for optimized synchronization
- **Action Class** for simulating user actions (mouse events, key events)
- **Alert Handling** and **JavaScript Executor** for custom browser actions
- **Handling of Cookies** for session management
- **Data-driven testing** via parameters in TestNG

## **Technologies Used**

- **Selenium WebDriver**: For browser automation
- **JUnit**: For writing and organizing test cases
- **TestNG**: For advanced test management, grouping, and parallel execution
- **WebDriverManager**: To manage browser drivers automatically
- **Maven**: For dependency management and build automation
- **Java 17+**: Programming language for test scripting

## **Project Structure**

### **Main Files:**
- **File1.java**: Contains basic test functionalities like page title validation and login verification.
- **File2.java**: Extends `File1` with additional tests for validating font size, button text, and window size.
- **File3.java**: Includes XPath tests and implicit wait handling.
- **File4.java**: Demonstrates advanced functionality like the Action Class, handling pop-ups, and cookies management.
- **File5.java**: Shows how to work with iframes and execute JavaScript in the browser.
- **MultiBrowser.java**: Configures and runs tests on multiple browsers (Chrome, Firefox, Edge).
- **TestNG.java**: TestNG suite for managing test execution order and dependencies.

### **Folder Structure:**
- **src/test/java**: Contains all the Java test classes.
- **src/test/resources**: Stores WebDriver binaries (e.g., `chromedriver.exe`, `geckodriver.exe`).
- **testng.xml**: TestNG configuration file for test execution settings and parallelization.

## **Getting Started**

### **Prerequisites:**
1. **Java 17+** (or any compatible version)
2. **Maven** (for dependency management)

### **Setting Up the Project:**

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/pullasj/Maven-Junit.git
   cd Maven-Junit
   ```

2. **Install Maven Dependencies**:
   Ensure Maven is installed. If not, [install Maven](https://maven.apache.org/install.html).
   Then, run:
   ```bash
   mvn clean install
   ```

3. **Running Tests**:
   To run the tests, use the following Maven command:
   ```bash
   mvn test
   ```

4. **Configuring Browser in `testng.xml`**:
   Set the browser type you want to test on (Chrome, Firefox, or Edge) in the `testng.xml` file by updating the `<parameter name="Browser" value="Chrome"/>` tag.

5. **Running Tests in Parallel**:
   The tests are set up for parallel execution in the `testng.xml` file by setting the `parallel` attribute:
   ```xml
   <suite name="Regression" parallel="tests" thread-count="2">
   ```

## **TestNG Annotations Used**
- **@Test**: Marks the method as a test case.
- **@BeforeClass**: Executes before the first test method in the class.
- **@AfterClass**: Executes after all the test methods in the class.
- **@Parameters**: Passes parameters (like browser type) to test methods.
- **@BeforeMethod** and **@AfterMethod**: Set up and clean up for individual test methods.

## **Example TestNG Configuration**:
Here’s an example of how the `testng.xml` is configured for running tests on Chrome and Edge browsers:
```xml
<suite name="Regression" parallel="tests" thread-count="2">
    <test name="ChromeTest">
        <parameter name="Browser" value="Chrome"/>
        <classes>
            <class name="MultiBrowser"/>
        </classes>
    </test>
    <test name="EdgeTest">
        <parameter name="Browser" value="Edge"/>
        <classes>
            <class name="MultiBrowser"/>
        </classes>
    </test>
</suite>
```

## **Contributing**
Feel free to fork the repository, submit pull requests, and open issues for any bugs or feature requests. Contributions are welcome!
