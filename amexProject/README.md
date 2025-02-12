# Selenium TestNG Automation Suite with Extent Reports  

This is an automation suite for Amex Gold Card Application Page. The framework is designed with best practices, including logging, reporting, and assertions.  

## 🔧 Technologies Used  

- **Selenium WebDriver** - UI Automation  
- **TestNG** - Test Execution & Assertions  
- **Extent Reports** - Test Reporting  
- **Maven** - Build Management  
- **Java** - Programming Language  

## 📌 Prerequisites  

Ensure you have the following installed:  

- Java (JDK 8 or later)  
- Maven  
- Git bash
- ChromeDriver - version 133.0.6943.53
- IDE (IntelliJ IDEA, Eclipse, or VS Code) 
- Chrome - version 133.0.6943.53  

## 🛠️ Installation & Setup  
Clone the repository:  
Open a terminal or Git Bash and run:
git clone https://github.com/MuthukumarM1997/amex.git
cd amexProject

## 📌 Import the Project into an IDE:
Open IntelliJ IDEA, Eclipse, or VS Code.
Select "Open Project" and navigate to the cloned folder.
Ensure Maven dependencies are resolved (pom.xml should load automatically).

## 📌 Execute Test Cases:
You can run the test suite using TestNG XML or Maven:

## 📌 Folder Structure
|-- src/main/java
    |-- BaseUtils
       |-- commonSetup   # Driver Initialization and Teardown
       |-- ExtentManager # Report manager
    |-- Pages        # Test pages        
|-- src/test/java
    |-- tests        # Test Classes   
|-- src/test/resources
    |-- testng.xml   # TestNG suite Configuration  
|-- pom.xml          # Maven Dependencies 
|-- test-output      # Extent Reports
|-- README.md       # Project Documentation

Important Notes: 
Cookies are handled properly by ChromeOptions class in CommonSetup class file.
Sometimes in other system it is not working. Just rerun and check if needed. 
