# API Automation Tests

## Description

This project contains automated tests for validating:

- The current time returned by the server.
- The TV schedule for the next 24 hours.

## Technologies

- **Java**: Version 21
- **TestNG**: Test framework
- **Rest Assured**: API testing
- **Maven**: Build tool
- **Allure**: Reporting tool

## Prerequisites

- Java 21
- Maven
- Docker

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/mcsymka/megogo.git

2. Run Tests:
   ```bash
   mvn clean test -DsuiteXmlFile=testng.xml


3. Generate Allure Report:
   ```bash
   mvn allure:report
   mvn allure:serve

4. Build Docker image
   ```bash
   docker build -t epg.megogo .
   docker run epg.megogo