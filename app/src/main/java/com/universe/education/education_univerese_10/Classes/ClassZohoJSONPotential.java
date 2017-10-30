package com.universe.education.education_univerese_10.Classes;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ClassZohoJSONPotential {

    private String json;
    public static String correoBusc;
    public static String passBusc;
    public static Boolean compPot;

    public ClassZohoJSONPotential() {
        compPot = true;
        json = null;
        correoBusc = "";
        passBusc = "";
        StringBuilder sb;
        try {
            InputStream is = ClassConexion.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null){
                sb.append(line);
            }
            json =  sb.toString();
            JsonParsing();
        } catch (Exception e) {
            ClassConexion.msj = false;
            ClassConexion.mensaje = "Error al obtener los datos";
        }
    }


    private void  JsonParsing(){
        if (json != null)
        {
            try {
                Potential potential = new Potential();
                JSONObject obj1 = new JSONObject(json);
                JSONObject obj2 = obj1.getJSONObject("response");

                JSONObject resOrNot = obj2.optJSONObject("result");

                if (resOrNot != null) {
                    JSONObject obj3 = obj2.getJSONObject("result");
                    JSONObject obj4 = obj3.getJSONObject("Potentials");
                    JSONObject obj5 = obj4.getJSONObject("row");
                    JSONArray arr1 = obj5.getJSONArray("FL");
                    for (int i = 0; i < arr1.length(); i++) {
                        try {
                            JSONObject obj6 = arr1.getJSONObject(i);
                            if (obj6.getString("val").equals("POTENTIALID")) {
                                potential.setIdPot(obj6.getString("content"));
                            } else if (obj6.getString("val").equals("Potential Name")) {
                                potential.setName(obj6.getString("content"));
                            } else if (obj6.getString("val").equals("Stage")) {
                                potential.setFase(obj6.getString("content"));
                            } else if (obj6.getString("val").equals("Correo electronico")) {
                                correoBusc = obj6.getString("content");
                                potential.setCorreo(correoBusc);
                            } else if (obj6.getString("val").equals("Nivel de ingles")) {
                                potential.setIngles(obj6.getString("content"));
                            } else if (obj6.getString("val").equals("Viaja")) {
                                potential.setViaja(obj6.getString("content"));
                            } else if (obj6.getString("val").equals("Nivel de estudios")) {
                                potential.setNEst(obj6.getString("content"));
                            } else if (obj6.getString("val").equals("Numero pasaporte estudiante")) {
                                potential.setNPass(obj6.getString("content"));
                            } else if (obj6.getString("val").equals("Nacionalidad estudiante")) {
                                potential.setNacEst(obj6.getString("content"));
                            } else if (obj6.getString("val").equals("Fecha Aprox desea viajar")) {
                                potential.setFecAp(obj6.getString("content"));
                            } else if (obj6.getString("val").equals("Estado de aplicacion visa")) {
                                potential.setEstVisa(obj6.getString("content"));
                            } else if (obj6.getString("val").equals("Codigo")) {
                                passBusc = obj6.getString("content");
                            }
                        } catch (Exception e) {
                            ClassConexion.msj = false;
                            ClassConexion.mensaje = "Error al obtener los datos";
                        }
                    }
                } else{
                    ClassConexion.mensaje = "El correo electrónico y la contraseña no coinciden";
                    ClassConexion.msj = false;
                    compPot = false;
                }


            } catch (Exception e) {
                ClassConexion.msj = false;
                ClassConexion.mensaje = "Error al obtener los datos";
            }
        }
    }


}
