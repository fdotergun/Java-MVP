JAVA MVP
=============
Java MVP ( Dagger2 - Retrofit + OkHttp+ Shared Pref)


This is boilerplate code for new projects. Project has Dagger2 , Retrofit, OkHttp ,Gson and Shared Pref ready to use.
Just change your packagename and ready to go *(you might need to ***Build Project*** for Dagger2)*

#### Shared Pref
Sample Method added for showing how to use Shared Pref for your projects.
Your models are stored in json string format inside shared pref so we can simply use Gson to fetch-store it.
 - For Storing data you need to call 
 ```
putObjectToSharedPref(gson.toJson(data,SampleModel.class),String.class,"sampleModel")
 ```
 as you see we are converting model into string.
 - Accessing data you can call 
 ```
gson.fromJson((String)getObjectFromSharedPref(String.class,"sampleModel"),SampleModel.class);
```
