package com.universe.education.education_univerese_10.Classes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by CARLOS on 27/08/2017.
 */

public class ClassConexion {

    public static String mensaje;
    public static Boolean msj = true;
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
            mensaje = "Sin mensaje";
            msj = true;
            myurl = myurl.replace(" ","%20");
            URL url = new URL(myurl);
            con = (HttpsURLConnection) url.openConnection();
            con.connect();
            con.setConnectTimeout(10000);
            con.setReadTimeout(10000);
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            //con.disconnect();
            msj = false;
            mensaje = "Error de conexión";
        }
    }

    public static InputStream getInputStream()
    {
        InputStream is;
        try
        {
            is = con.getInputStream();
        }
        catch (Exception e)
        {
            is = null;
            msj = false;
            mensaje = "Error al obtener los datos";
        }

        return is;
    }




}
