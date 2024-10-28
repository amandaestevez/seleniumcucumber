# Automate Tests With Selenium and Cucumber in Java.

**Introduction:** 
This document outlines the step-by-step for automating tests with Cucumber and Selenium, using JUnit as test runner in Java. 

**Tools Used:**
- IntelliJ Idea Community Version;
- JDK;
- Windows OS.

## Stages

### 1. Build a Maven Project in IntelliJ Idea Community Edition
### 2. Create the Directories Structure
### 3. Install Dependencies and Plugins
### 4. Create Package 01: Page Object Model (POM) Package
### 5. Create Package 02: features
### 6. Create Package 03: hooks
### 7. Create Package 04: stepsDefinition
### 8. Create Package 05: testRunner
### 9. (Depricated) Cucumber Configuration Files


### 1. Build a Maven Project in IntelliJ Idea Community Edition

Maven: `build automation` and `dependency management tool for Java projects`.
It simplifies project setup, builds, and configurations using a standardized project structure.
To build a Maven project in IntelliJ, select `New Project`, then `Maven`. 
Language - `Java`.

### 2. Create the Directories Structure

seleniumcucumber/
├── .idea/
├── demo/
│   └── src/
│       ├── main/
│       │   ├── java/
│       │   │   ├── pages/ 
│       │   └── resources/
│       └── test/
│           ├── java/
│           │   ├── hooks/ 
│           │   ├── stepsDefinition/ 
│           │   └── testRunner/ 
│           └── resources/
│               └── features/
│   └── target/
│   └── pom.xml/

### 3. Install Dependencies and Plugins

In the `pom.xml` file, open the `<dependencies>` block to include all the dependencies.

> `pom.xml`(Project Object Model): Maven file that defines the project's dependencies, build configuration, plugins, and other project-related information.

The order below provides a logical structure, but doesn't impact in the script functioning.

You may need more dependencies later, but these are the main ones to start.

#### 3.1. DEPENDENCIES

> `External libraries or modules` that a project requires to function, providing additional functionality or resources not included in the core framework. Required for running or testing code.

**3.1.1. CORE DEPENDENCY:**

- `Selenium`: **MANDATORY**. Dependency to import Selenium Java classes to automate browser testing.


**3.1.2. TESTING FRAMEWORKS DEPENDENCY:**

- `JUnit Jupiter`: **MANDATORY**. Runtime component of JUnit 5 that `discovers and executes tests` written using the JUnit Jupiter API OR Cucumber.


- `JUnit Jupiter API`: **OPTIONAL**. Contains the set of `annotations`, `assertions`, and `classes` used to write tests. 


- `JUnit Platform Suite Engine`: **MANDATORY**. Component of JUnit 5 that allows to run tests from multiple test frameworks (like JUnit and Cucumber) within the same test suite. 


**3.1.3. CUCUMBER DEPENDENCIES:**

- `Cucumber Java Dependency`: **MANDATORY**. component with classes and annotations needed to write step definitions in Java.


- `Cucumber JUnit Platform Engine`: **MANDATORY**. Tool to run Cucumber tests using JUnit 5, integrating Cucumber scenarios with the JUnit 5 testing framework.


Close the dependencies block with `</dependencies>`.

#### 3.2. PLUGINS

> `Extensions` or `components` that enhance the functionality of a build tool, enabling specific tasks or actions within the build process. Used during the build process itself.

Open the following blocks:

- `<build>`: Where will include the plugins block.

- `<plugins>`: where I'll include each plugin separately.

**MAVEN PLUGINS**:

- `Maven Surefire`: **MANDATORY**. Runs unit and integration tests with JUnit or TestNG in the build phase, ensuring that the code is tested before being integrated or deployed in the CI/CD pipeline.

- `Maven Compiler`: **MANDATORY**.Compiles Java code in a Maven project, specifying the Java version compatibility and other compiler options.

#### 4. Create Package 01: Page Object Model (POM) Package

In the `src/main/java directory`, create the `pages` package in the Page Object Model (POM) design pattern to contain classes representing web pages. 
These classes encapsulate the elements and actions for each page, like UI interactions with Selenium.

POM is not relevant in `API testing`because there is no user interface to model.

[See pages classes](https://github.com/amandaestevez/00-JAVA-PROGRAMMING/blob/d78f6ced40ae7501ef9b8aaf79bb57dcfea0f398/seleniumcucumber/demo/src/main/java/pages)

#### 5. Create Package 02: features

**FEATURE FILES:**

* FEATURE DEFINITION: A standalone unit or functionality within a project, often containing a list of scenarios that need to be tested.

* FEATURE FILE DEFINITION: A file that stores a feature, its descriptions, scenarios, and their steps. One can create as many feature files as needed. One feature file can have many scenarios.

* SCENARIOS: Cucumber test cases that describe specific user interactions and expected outcomes, written in a Gherkin format.

**FEATURE FILES STEPS:**

1. In the `src/test/resources` directory, create a `features` package.
2. Create a separate feature file for each feature being tested using Gherkin syntax and save them with the `.feature` extension.

[See feature files](features)

#### 6. Create Package 03: hooks

Hooks are blocks of code that run before or after each scenario, annotated with `@Before` and `@After`. 
They help manage the code workflow and reduce redundancy.

Typically, one hooks class is sufficient for a Cucumber project, unless it requires different setups or teardowns for distinct features or scenarios.

**HOOKS CLASS CREATION:**

1. In `src/test/java`, set up a new package called `hooks` and create a class called `Hooks.java`.
2. Import Cucumber's hooks and the relevant Selenium classes.
3. Write methods to set up and tear down the driver.
4. Import the Hooks class in the `steps definition` classes so the later will interact with the initialized elements.

[Hooks Class](src/test/java/hooks)

#### 7. Create Package 04: stepsDefinition

Step Definition files contain the code to execute the steps written in Gherkin scenarios. 
They map each scenario step in the feature file to the corresponding function - focused on scenario behavior. 

**HOW IT WORKS:**
* When Cucumber runs a step from the feature file, it looks through the step definition file to determine which function to call.
* It locates the step definition file using the `GLUE_PROPERTY_NAME` with the specified with `@ConfigurationParameters`.

**STEPS DEFINITION FILES CREATION:**

1. In the `src/test/java` directory, create a `stepsDefinition` package.
2. Create step definition classes for each script in the pages package and map them to the steps in the corresponding feature file.

[Steps Definition classes](stepsDefinition)

#### Package 05: testRunner

* DEFINITION: The TestRunner.java class links and executes Cucumber feature files with their step definitions. 
This class is annotated with `@Suite` to indicate that it is a test suite.

The annotation `@IncludeEngines("cucumber)` ensures that tests are run using the Cucumber framework, which is essential for interpreting Gherkin feature files.

**RUNNER CLASS STEPS:**

1. In the `src/test/java` directory, create a `testRunner` package. 
2. Create a class called `TestRunner.java` and annotate it with `@SelectClasspathResource("features")`. 
3. Annotate it with `@ConfigurationParameter` to specify the package(s) containing step definitions, hooks, and reports.

[Test Runner](testRunner)

### Package 06 (Deprecated): Configuration Files

JUnit 5 doesn't support Cucumber's `configuration.properties` files anymore.
Instead, it is recommended to add the configurations in the runner class through the `@ConfigurationParameter` annotation, or in the `Maven Surefire` plugin, under `<properties>`, inside the `<Configuration Parameters>` block.

[See JUnit 05 documentation HERE](https://junit.org/junit5/docs/current/user-guide/#running-tests-config-params)

# Conclusion
With this set up, your cucumber tests should run normally and will see the results through the "Pretty" report.
