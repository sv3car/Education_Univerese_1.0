package com.universe.education.education_univerese_10.Classes;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by CARLOS on 27/08/2017.
 */

public class ClassConexion {


    private static HttpsURLConnection con;

    public static boolean isNetworkConnected(Context context)
    {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context
                .CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info == null || !info.isConnected() || !info.isAvailable())
        {
            return false;
        }
        return true;
    }

    public ClassConexion(String myurl)
    {
        try
        {
            myurl = myurl.replace(" ","%20");
            URL url = new URL(myurl);
            con = (HttpsURLConnection) url.openConnection();
            con.disconnect();
            con.connect();
            con.setConnectTimeout(1000000);
            con.setReadTimeout(1000000);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static InputStream getInputStream()
    {
        try
        {
            return con.getInputStream();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }


}
