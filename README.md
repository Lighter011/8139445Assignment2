
# NIT3213 Assignment 2 - Android Application

## Project Overview

This project is an Android application developed using Kotlin and XML in Android Studio for NIT3213 Assignment 2.

The application connects to a REST API to authenticate users and retrieve information about different languages.

## Features

- Login screen with username and password fields
- REST API integration using Retrofit
- Dashboard displaying language information
- RecyclerView with individual cards for each language
- Entity Details screen displaying additional information
- Navigation between the Dashboard and Details screens
- Dependency injection using Koin
- Unit testing using JUnit and MockWebServer

## Technologies Used

- Kotlin
- Android Studio
- XML layouts
- Retrofit and Gson
- RecyclerView
- Koin
- JUnit
- MockWebServer
- Git

## Application Screens

### Login Screen

The user enters their username and password. The application sends the login request to the authentication API.

### Dashboard Screen

After successful authentication, the application retrieves a list of language entities from the API and displays them in a RecyclerView.

Each card displays the language name, family, branch, and number of speakers.

### Entity Details Screen

When the user selects a language, the application opens a details screen showing additional information, including its writing system, official countries, and description.

## How to Run the Application

1. Download or clone this repository.
2. Open the project in Android Studio.
3. Allow Gradle to sync and download the required dependencies.
4. Start an Android emulator or connect an Android device.
5. Click Run to install and launch the application.
6. Enter the credentials provided for the assignment.
7. Log in to view the Dashboard and select a language to view its details.

## API Integration

The application uses Retrofit to communicate with the NIT3213 REST API.

API requests are used for authentication and retrieving dashboard entities.

## Dependency Injection

Koin is used to provide dependencies such as Retrofit, ApiService, and EntityRepository.

## Unit Testing

Unit tests are included to check login request and response models and repository functionality.

To run the tests, open the test files in Android Studio and select Run Tests.

## Version Control

Git is used to track project development through meaningful commits.
