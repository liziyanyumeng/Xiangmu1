package com.bawei.movie.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.bawei.movie.App;

public class SpUtil {
    private static String sp_name = "app_config";
    public static void savrString(String key,String values){
        final SharedPreferences sharedPreferences = App.context.getSharedPreferences(sp_name, Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(key,values);
        edit.commit();
    }
    public static void saveInt(String key,int values){
        final SharedPreferences sharedPreferences = App.context.getSharedPreferences(sp_name, Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(key,values);
        edit.commit();
    }
    public static String getString(String key){
        final SharedPreferences sharedPreferences = App.context.getSharedPreferences(sp_name, Context.MODE_PRIVATE);
        final String string = sharedPreferences.getString(key, "");
        return string;
    }
    public static int getInt(String key){
        final SharedPreferences sharedPreferences = App.context.getSharedPreferences(sp_name, Context.MODE_PRIVATE);
        final int anInt = sharedPreferences.getInt(key, -1);
        return anInt;
    }
}
