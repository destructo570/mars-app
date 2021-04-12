## Mars App
A simple app that lets you browse latest images taken by various Mars rovers thanks to NASA's API

This app is based on MVVM architecture. And I also used architecture components like navigation components, LiveData, ViewModel.

Goal was to create a simple playground app that I can keep modifying and playing around with the latest available best practices and new API's and libraries for android.

## How to use the code
Make sure to create a config.kt file and define a constant named API_KEY which will be used to make calls to the NASA API

#### Example:

```const val API_KEY = "YOUR_API_KEY_HERE"```

You can signup for a personal API KEY here (It's free) : https://api.nasa.gov/

## Screenshots
<img src="https://imgur.com/yb04MaY.jpg" width=24%><img src="https://imgur.com/B6sML3A.jpg" width=24%>
<img src="https://imgur.com/bPWZkah.jpg" width=24%><img src="https://imgur.com/oqBx6hn.jpg" width=24%>

## Project Structure
* Data
   * This is where network datasource, repository and model classes for responses live.
* DI
   * Dependency injection related code is in this package.
* UI
   * This is where presentation layer logic is.There are different packages separating different sections of the app. All the ui/view related code goes here.
* Utils
   * Contains all the constants and some other utility classes the app needs.

## Libraries Used
* Dagger-Hilt - dependency injection
* Navigation Components - simplify navigation related login in the app
* [Retrofit2](https://square.github.io/retrofit/) - networking
* [Kotlin coroutines](https://github.com/Kotlin/kotlinx.coroutines#user-content-android) - performing backgroundd tasks
* [Coil](https://github.com/coil-kt/coil) - image loading
* [Moshi](https://github.com/square/moshi) - JSON parsing
* [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - find and reference views more easily
* [Material](https://material.io/develop/android/docs/getting-started/) - material components
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - manage ui related data and buisiness logic

## Credits

Thanks to NASA for their [Mars-Rover-Photos API](https://github.com/chrisccerami/mars-photo-api)

## ToDo
* Recreate UI using jetpack compose
* Use Flows instead of livedata
* Use Paging 3 for pagination
* Add tests
* Add Animations
* Add some more features

