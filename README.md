## Mars App
A simple app that lets you browse latest images taken by various Mars rovers thanks to NASA's API

This app is based on MVVM architexture. And I also used architecture components like navigation components, LiveData, ViewModel

## How to use the code
Make sure to create a config.kt file and define a constant API_KEY which will be used to make calls to the NASA API

Ex. const val API_KEY = "YOUR_API_KEY_HERE"

You can signup for a personal API KEY here (It's free) : https://api.nasa.gov/

## Project Structure

* Data
    This is where network datasource, repository and model classes for responses live.
* DI
    Dependency injection related code is in this package.
* UI
    This is where presentation layer logic is.There are different packages separating different sections of the app. All the ui/view related code goes here.
* Utils
    Contains all the constants and some other utility classes the app needs.

## Libraries Used
* Hilt - dependency injection
* [Retrofit2](https://square.github.io/retrofit/) - networking
* Navigation Components 
* [Kotlin coroutines](https://github.com/Kotlin/kotlinx.coroutines#user-content-android) - performing backgroundd tasks
* [Coil](https://github.com/coil-kt/coil) - image loading
* [Moshi](https://github.com/square/moshi) - JSON parsing
* [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - find and reference views more easily
* [Material](https://material.io/develop/android/docs/getting-started/) - material components
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - manage ui related data and buisiness logic

## ToDo
* Add tests
* Add Animations
* Add some more features

