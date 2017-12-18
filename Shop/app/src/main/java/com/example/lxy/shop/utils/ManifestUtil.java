package com.example.lxy.shop.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;


public class ManifestUtil {


    public static String getMetaDataValue(Context context,String name, String def) {

        String value = getMetaDataValue(context,name);
        return (value == null) ? def : value;

    }

    public static String getMetaDataValue(Context context, String name) {

        Object value = null;

        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo;

        try {
            Log.d("", "getMetaDataValue1: "+value);
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                value = applicationInfo.metaData.get(name);
                Log.d("", "getMetaDataValue2: "+value);
            }

        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Could not read the name in the manifest file.", e);
        }

        if (value == null) {
            throw new RuntimeException("The name '" + name+ "' is not defined in the manifest file's meta data.");
        }

        return value.toString();

    }
}
