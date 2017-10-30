package com.universe.education.education_univerese_10.Classes;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by CARLOS on 10/09/2017.
 */

public class ClassZohoXMLPotential {

    public static String correoBusc = "";
    public  static String passBusc = "";


    //para parsea los xml
    public String IdOrMes()
    {
        String IdOrMes = "XML_VACIO";
        XmlPullParser parser = Xml.newPullParser();

        try
        {
            parser.setInput(ClassConexion.getInputStream(), null);
            int evento = parser.getEventType();
            Potential potentialActual = null;

            while (evento != XmlPullParser.END_DOCUMENT)
            {
                String etiqueta = null;
                String atributo = null;
                switch (evento)
                {
                    case XmlPullParser.START_DOCUMENT:

                        //ListReg = new ArrayList<Class_ZohoVar>();
                        break;

                    case XmlPullParser.START_TAG:
                        etiqueta = parser.getName();
                        if (etiqueta.equals("row"))
                        {
                            potentialActual = new Potential();
                        }
                        else if (potentialActual != null)
                        {
                            if (etiqueta.equals("FL"))
                            {
                                atributo = parser.getAttributeValue(0);
                                if (atributo.equals("POTENTIALID"))
                                {
                                    IdOrMes = parser.nextText();
                                    potentialActual.setIdPot(IdOrMes);
                                }
                                if (atributo.equals("Potential Name"))
                                {
                                    potentialActual.setName(parser.nextText());
                                }
                                if (atributo.equals("Correo electronico"))
                                {
                                    correoBusc = parser.nextText();
                                    potentialActual.setCorreo(correoBusc);
                                }
                                else if (atributo.equals("Codigo"))
                                {
                                    passBusc = parser.nextText();
                                }
                                else if (atributo.equals("Nivel de ingles"))
                                {
                                    potentialActual.setIngles(parser.nextText());
                                }
                                else if (atributo.equals("Viaja"))
                                {
                                    potentialActual.setViaja(parser.nextText());
                                }
                                else if (atributo.equals("Nivel de estudios"))
                                {
                                    potentialActual.setNEst(parser.nextText());
                                }
                                else if (atributo.equals("Numero pasaporte estudiante"))
                                {
                                    potentialActual.setNPass(parser.nextText());
                                }
                                else if (atributo.equals("Nacionalidad estudiante"))
                                {
                                    potentialActual.setNacEst(parser.nextText());
                                }
                                else if (atributo.equals("Fecha Aprox desea viajar"))
                                {
                                    potentialActual.setFecAp(parser.nextText());
                                }
                                else if (atributo.equals("Estado de aplicacion visa"))
                                {
                                    potentialActual.setEstVisa(parser.nextText());
                                }
                            }
                        }
                        else if (etiqueta.equals("message"))
                        {
                            IdOrMes = parser.nextText();
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
        return IdOrMes;
    }

}
