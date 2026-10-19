
NIT3213 Assignment 2 – Android Application
Project Overview
This project is an Android application developed in Kotlin using Android Studio and XML layouts for NIT3213 Assignment 2. It connects to the NIT3213 REST API to authenticate a user, retrieve a list of entities, and display the full details of a selected entity.

Features
Login screen with username and password fields
Authentication using a REST API
Error handling for unsuccessful login attempts
Dashboard displaying API entities in a RecyclerView
Entity selection and navigation to a Details screen
Details screen showing information about the selected entity
MVVM architecture for separating UI and application logic
Dependency injection using Koin
Unit tests using JUnit and MockWebServer
Git version control
Technologies Used
Kotlin – application logic
XML – user interface layouts
Android Studio – development environment
Retrofit and Gson – REST API requests and JSON conversion
RecyclerView – dashboard list
Koin – dependency injection
JUnit and MockWebServer – testing
Git and GitHub – version control and submission
Application Screens
1. Login Screen
The user enters their student ID (without the s) and first name (case-sensitive) to log in. The app sends the credentials to the relevant NIT3213 authentication endpoint. On successful authentication, it opens the Dashboard. If authentication fails, it displays an error message.

2. Dashboard Screen
The Dashboard requests entity data from the API using the keypass received at login. Entities are displayed in a RecyclerView. Selecting an item opens its Details screen.

3. Details Screen
The Details screen displays the selected entity's available information, including its description.

MVVM Architecture
The application is organized using the Model-View-ViewModel (MVVM) pattern:

LoginViewModel – manages login-related data and state.
DashboardViewModel – manages the entity list and dashboard state.
DetailsViewModel – stores and exposes the selected entity for the Details screen.
Repository – handles data access and API communication.
Activities and XML layouts – display the interface and handle user interaction.
This separation helps make the code easier to maintain and test.

API Integration
Base URL: https://nit3213apinew.onrender.com/

The application uses Retrofit for API communication.

Purpose	Method	Endpoint
Authentication	POST	/sydney/auth
Dashboard entities	GET	/dashboard/{keypass}
The login endpoint shown above is for the Sydney class location. The authentication response provides a keypass, which is used to request the dashboard entities.

Dependency Injection
Koin provides application dependencies, including Retrofit, the API service, and the repository. It supports a more modular application structure and reduces direct dependency creation in UI components.

Unit Testing
Unit tests are included for application components such as ViewModels and repository functionality. The project uses JUnit, with MockWebServer available for testing API-related behavior.

To run tests in Android Studio:

Open the project and wait for Gradle sync.
Open the relevant test file under app/src/test.
Right-click the test class or method and select Run.
Review the results in the Run window.
How to Build and Run
Clone or download this repository.
Open the project folder in Android Studio.
Allow Gradle to sync and download dependencies.
Start an Android emulator or connect an Android device with USB debugging enabled.
Select the app run configuration and click Run.
Log in using the assignment credentials: your student ID without the s as the username, and your case-sensitive first name as the password.
After logging in, select an entity on the Dashboard to view its details.
Requirements: Android Studio, an Android SDK installed through Android Studio, and an internet connection for the API requests.

Version Control
Git is used to track development changes, and GitHub hosts the project repository. Commit history records updates to the application's code and configuration.

Repository
View the project on GitHub

Assignment Information
Unit: NIT3213
Assessment: Assignment 2 – Android Application Development
Project: Android application using REST API integration, MVVM, and dependency injection
⋮⋮⋮⋮
