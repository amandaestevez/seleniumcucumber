# Testing Google Search Feature

This documents the full process of testing the Google Search feature for learning purposes.

# Stages

1. Planning
2. Design
3. Development
4. Testing
5. Deployment
6. Maintenance

# Stage #1: Planning (Test Plan)
The first step is to create a `Test Plan document`. 
A test plan is a document that outlines the strategy, objectives, scope, resources, schedule, and approach for testing a software application to ensure it meets its requirements and quality standards. 

Here's the test plan for this project: [Test-Plan](src/Test-Plan.md). 

# Stage #2: Design
After creating the test plan it's time for design. 
In the design phase of the software development life cycle (SDLC), testers are involved in activities such as reviewing design documents, creating high-level test plans, identifying test scenarios, and collaborating with developers to understand the architecture and design decisions. 

This helps them prepare for effective testing later on and ensures that test coverage aligns with the system's design and requirements.

# Stage #3: Development
After reviewing the test plan document, it's time to proceed to write and implement the tests. Here's a comprehensive list of task performed in this stage:

| **Task**                                    | **Deliverable**                                                   |
|---------------------------------------------|-------------------------------------------------------------------|
| Create Detailed Test Cases                  | [Documented test cases or test scripts](features)                 |
| Review and Update Test Plans                | [Updated test plan document](Test-Plan.md)                        |
| Develop Test Data                           | [Prepared test data sets and data generation scripts](main)       |
| Unit Test Support                           | Unit test coverage documentation and feedback reports             |
| Smoke Test Preparation                      | Smoke test scripts and criteria for build acceptance              |
| Automation Script Development               | Automated test scripts for regression testing                     |
| Collaborate and Communicate with Developers | Meeting notes, feedback documentation, and clarified requirements |
| Environment Setup and Configuration         | Configured test environment and setup documentation               |

- `Unit Test Support`: coverage documentation and feedback reports can be automatically generated and published through CI tools like Jenkins and Azure DevOps.
- `Smoke Test Preparation`: in this case, we can consider the GoogleHomePage a smoke test, since it only verifies if the core functionality (the search field) is working—there's no deep validation or complex input-output verification.
- `Environment Set Up and Configuration Documentation`: The test environment requirements should be organized by categories, such as:

1. Hardware,
2. Software,
3. Network,
4. Data,
5. Configuration,
6. Tools,
7. Access. 

The test environment requirements should also include any assumptions, dependencies, constraints, or risks that may affect the test environment or the testing activities. 
The test environment requirements should be reviewed, approved, and updated by the relevant stakeholders, such as the testers, the developers, the business analysts, and the customers.

# Stage #4: Testing

In the testing stage of the SDLC, the testing team validates the software's functionality, performance, and security by executing various test cases (e.g., unit, integration, regression), identifying defects, and ensuring the software meets the specified requirements before release.

| **Deliverable**                           | **Description**                                                                                                                                     |
|-------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|
| **Test Execution**                        | [Test cases are executed.](src)                                                                                                                        |
| **Test Execution Report**                 | [A report capturing the execution status (pass/fail) of all test cases during the testing cycle, including metrics and coverage.](cucumber-reports) |
| **Defect/Bug Reports**                    | Documentation of identified defects or bugs, including their severity, status, and steps to reproduce them.                                         |
| **Regression Test Results**               | Results from regression testing to ensure existing functionality is unaffected by changes or new features.                                          |
| **Performance Test Results**              | Results from performance testing, assessing the application's responsiveness, stability, and scalability under load.                                |
| **User Acceptance Testing (UAT) Results** | Documentation of UAT outcomes, showing whether the software meets end-users' expectations and requirements for release approval.                    |
| **Known Issues List**                     | A list of known, non-critical issues that remain open but do not block deployment, often with plans for future fixes or workarounds.                |
| **Test Summary Report**                   | A comprehensive summary of all testing activities, results, defect statistics, and overall quality assessment.                                      |

- Test Execution Report: TestRails, Azure DevOps, Cucumber (with tools like Pretty or Serenity), Jira with XRay or Zephyr can generate them. In this case, I generated them using "Pretty" with Cucumber.
- Defect/Bug Reports: BugZilla, Jira, Azure DevOps.
- 
# Stage #5: Deployment

In this phase, the software is released and deployed to the production environment, making it available for end-users. 
This process includes configuration, setting up the live environment, and ensuring the software is accessible and functional in the real-world setting.

Here’s a table of testing deliverables in the Deployment phase of the SDLC:

| **Deliverable**                     | **Description**                                                                                                                                        |
|-------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Release Notes**                   | Documentation summarizing the release content, including new features, enhancements, bug fixes, and known limitations.                                 |
| **Deployment Verification Report**  | A report that confirms the successful deployment of the application, including verification of critical functionalities in the production environment. |
| **Configuration Management Report** | Documentation that ensures the test and production environments are correctly configured and match expected setups.                                    |
| **Post-Deployment Testing Results** | Results from any testing performed after deployment (e.g., smoke tests) to verify that the application functions as expected in the live environment.  |
| **Final Test Summary Report**       | A comprehensive report summarizing the overall testing outcomes, including any remaining known issues, and confirming readiness for deployment.        |
| **User Training Materials**         | Documentation and training materials prepared for users to help them understand new features and functionalities introduced in the release.            |

- `Release notes`: Release notes are often compiled by product managers, technical writers, or project leads. 
   However, testers may provide input by sharing details on testing outcomes, known issues, bug fixes, and any testing-related updates that are important for the release.

- `Deployment verification report`: Selenium (wih JUnit or TestNG) for automated UI testing can verify if a web application behaves correctly after deployment, with detailed test reports. 
   Azure DevOps provides deployment pipelines with integrated testing, and reports the success or failure of deployments.


# Stage #6: Maintenance

In this phase, the software is monitored and maintained post-deployment to ensure it continues to function correctly and meets user needs. This includes:

- `Bug Fixing`: Addressing any defects or issues that arise after the software is live.
- `Updates and Enhancements`: Implementing updates to improve functionality or add new features based on user feedback.
- `Performance Monitoring`: Continuously assessing the software's performance and making necessary adjustments.
- `Documentation Updates`: Keeping all related documentation current, including user manuals and technical documentation.
