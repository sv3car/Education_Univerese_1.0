package com.universe.education.education_univerese_10.Classes;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

public class ClassZohoXMLPotentialPass {

    public void respuesta()
    {
        XmlPullParser parser = Xml.newPullParser();

        try
        {
            parser.setInput(ClassConexion.getInputStream(), null);
            int evento = parser.getEventType();

            while (evento != XmlPullParser.END_DOCUMENT)
            {
                String etiqueta;
                switch (evento)
                {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        etiqueta = parser.getName();
                        if (etiqueta.equals("code")){
                            ClassConexion.mensaje = "Error: " + parser.nextText();
                            ClassConexion.msj = false;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                evento = parser.next();
            }
        }
        catch (Exception ex)
        {
            ClassConexion.msj = false;
            ClassConexion.mensaje = "Error al obtener los datos";
        }
    }

}
