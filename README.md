# OkHttp3StackForVolley
OkHttp3 Stack that can be used to replace default Volley's Stack to improve performance

## How to use?
### Step 1. 
Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
  repositories {
  ...
  maven { url 'https://jitpack.io' }
  }
}
```
### Step 2. 
Add the dependency
```gradle
dependencies {
  compile 'com.github.IONsoft-Indonesia:OkHttp3StackForVolley:1.0'
}
```
### Step 3.
Replace `Volley.newRequestQueue(context);` with `Volley.newRequestQueue(context, new OkHttp3Stack());` and you good to go. You might want to keep reference to the OkHttp3Stack if you want to cancel the request.
