# AP Computer Science Final Project


This program is a simple bank application. It supports creating accounts,
authentication, multiple different roles, and withdrawing and depositing money.

To authenticate, the user must provide their username and password which they
provided when they created their account. Without being logged in they are only
allowed to view a few pages: the main page, and the login and signup pages.

Users are not allowed to deposit or withdraw money on their own. Instead, a bank
teller must log in and perform the deposit or withdrawal for the user.







## Usage
Make sure you have Java 17 - it will not work with Java 20.


```bash
git clone https://github.com/Tallented-Code-bot/apcs_final_project
cd apcs_final_project
./gradlew.bat build
./gradlew.bat bootRun
```


Then go to http://localhost:8080/


