package com.base.helper;

import android.content.SharedPreferences;

import com.ferhatergun.javamvp.home.model.SampleModel;
import com.google.gson.Gson;

import kotlin.jvm.Synchronized;

/**
 * Created by ferhat on 11/21/2017.
 */

public class SharedPrefHelper {

    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;
    private Gson gson;

    public SharedPrefHelper(SharedPreferences sharedPreferences,Gson gson){
        this.sharedPref = sharedPreferences;
        this.editor = sharedPreferences.edit();
        this.gson = gson;
    }

    @Synchronized public void setSampleObject(SampleModel data){
        putObjectToSharedPref(gson.toJson(data,SampleModel.class),String.class,"sampleModel");
    }

    @Synchronized public SampleModel getSampleObject(){
        return gson.fromJson((String)getObjectFromSharedPref(String.class,"sampleModel"),SampleModel.class);
    }

    @Synchronized private void putObjectToSharedPref(Object data,Class dataType,String key){
        if (dataType == Integer.class){
            editor.putInt(key,(Integer)data);
        } else if (dataType == String.class){
            editor.putString(key,(String)data);
        } else if (dataType == Boolean.class){
            editor.putBoolean(key,(boolean) data);
        } else if (dataType == Long.class){
            editor.putLong(key,(Long)data);
        } else if (dataType == Float.class){
            editor.putFloat(key,(Float)data);
        }
        editor.commit();
    }

    @Synchronized private Object getObjectFromSharedPref(Class dataType,String key){
        if (dataType == Integer.class){
            return sharedPref.getInt(key,0);
        } else if (dataType == String.class){
            return sharedPref.getString(key,null);
        } else if (dataType == Boolean.class){
            return sharedPref.getBoolean(key,false);
        } else if (dataType == Long.class){
            return sharedPref.getLong(key,0L);
        } else if (dataType == Float.class){
            return sharedPref.getFloat(key,0.0f);
        }
        return null;
    }
}
