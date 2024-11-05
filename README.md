# Test Automation Project

This project is a test automation suite developed using Selenium, Java, and Cucumber.

## Getting Started

To get started with the project, clone the repository and load the project into IntelliJ IDEA or another IDE of your choice.

```bash
git clone https://github.com/maxchernohor/cucumber-java-selenium
```

Once cloned, navigate into the project directory.

## Prerequisites

Ensure you have the following installed on your system:

- **Java 17**
- **Maven 3.6 or higher**
- **Internet connection for downloading dependencies**
- **IntelliJ IDEA or any other preferred IDE**

### Installing Java 17

1. **Download Java 17:**
    - Visit the official Oracle website or an open-source alternative like AdoptOpenJDK to download Java 17:
        - [Oracle JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
        - [AdoptOpenJDK 17](https://adoptopenjdk.net/)

2. **Install Java 17:**
    - Follow the installation instructions for your Operating System.

3. **Verify the Installation:**
    ```bash
    java -version
    ```

   Expected output:
    ```bash
    java version "17.0.1" 2021-10-19 LTS
    Java(TM) SE Runtime Environment (build 17.0.1+12-LTS-39)
    Java HotSpot(TM) 64-Bit Server VM (build 17.0.1+12-LTS-39, mixed mode, sharing)
    ```

### Installing Maven 3.6 or higher

1. **Download Maven:**
    - Visit the official Maven website to download the latest version:
        - [Maven Download](https://maven.apache.org/download.cgi)

2. **Install Maven:**
    - Follow the installation instructions for your Operating System.

3. **Verify the Installation:**
    ```bash
    mvn -version
    ```

   Expected output:
    ```bash
    Apache Maven 3.8.4 (NON-CANONICAL_553257b52e4d1b0ba023fa1b86b68b2e7fc491df)
    Maven home: /path/to/maven
    Java version: 17.0.1, vendor: Oracle Corporation, runtime: /path/to/java
    Default locale: en_US, platform encoding: UTF-8
    OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
    ```

### Verify Internet Connection

Ensure you have an active internet connection to download project dependencies when running Maven commands.

## Installation

1. **Clone the Repository:**
    ```bash
    git clone https://github.com/maxchernohor/cucumber-java-selenium
    cd cucumber-java-selenium
    ```

2. **Install Dependencies:**
    ```bash
    mvn clean install
    ```

## Running the Tests

You can execute the series of automation tests using a single Maven command from your IDE or terminal.

```bash
mvn clean compile test
```

The project is set up to run tests with different browser profiles. The profiles provided in the `pom.xml` are:

- `edge`
- `edgeheadless`
- `chrome`
- `chromeheadless`

### Run with Default Profile

To run the tests with the default Maven profile, use:
```bash
mvn test
```

### Run with a Specific Profile

To run the tests with a specific profile, use the `-P` flag:
```bash
# Running with Edge browser
mvn test -Pedge

# Running with Edge browser in headless mode
mvn test -Pedgeheadless

# Running with Chrome browser
mvn test -Pchrome

# Running with Chrome browser in headless mode
mvn test -Pchromeheadless
```

## Adding and Managing Dependencies

If you need to add additional dependencies, update the `pom.xml` file as needed. Ensure to specify versions for all dependencies to maintain consistency.

Example:
```xml
<dependency>
    <groupId>group.id</groupId>
    <artifactId>artifact-id</artifactId>
    <version>1.0.0</version>
</dependency>
```

After updating the `pom.xml`, run the following command to update the project dependencies:
```bash
mvn clean install
```

## Setting Up Custom WebDriver Manager

The `CustomWebDriverManager` class is used to manage WebDriver instances. Ensure the class is correctly accessible and properly configured. The constructor must be public to allow dependency injection.

Example:
```java
package executionConfig;

public class CustomWebDriverManager {
    
    public CustomWebDriverManager() {
        // constructor implementation here
    }
}
```

## Troubleshooting

### Common Issues

- **Dependencies Not Found:**
  Ensure you have an active internet connection and that the repositories in `pom.xml` are correct.

- **Tests Failing:**
  Make sure your WebDriver binaries are compatible with the browsers installed on your system.

### Logs and Error Reporting

Refer to the Maven build logs for detailed error messages and stack traces to help troubleshoot issues.

## Contributing

Feel free to submit issues and enhancement requests.

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit and push changes to your branch (`git commit -m "Description of changes"`).
5. Create a Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.