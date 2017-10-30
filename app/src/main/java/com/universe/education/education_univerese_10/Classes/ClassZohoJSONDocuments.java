package com.universe.education.education_univerese_10.Classes;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ClassZohoJSONDocuments {

    public static List<Document> listDocument;
    private String json;
    private JSONArray arrFL1;
    private Document document;

    public ClassZohoJSONDocuments() {
        listDocument = new ArrayList<>();
        //aux = "no";
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
            Log.d("Descricion del error", e.toString());
            ClassConexion.msj = false;
            ClassConexion.mensaje = "Error al obtener los datos1";
        }
    }

    private void  JsonParsing() throws Exception {
        if (json != null)
        {
            try {
                JSONObject obj1 = new JSONObject(json);
                JSONObject obj2 = obj1.getJSONObject("response");

                JSONObject resOrNot = obj2.optJSONObject("result");

                if (resOrNot != null) {
                    JSONObject obj3 = obj2.getJSONObject("result");
                    JSONObject obj4 = obj3.getJSONObject("Attachments");
                    JSONObject auxJson = obj4.optJSONObject("row");
                    if (auxJson == null) {
                        JSONArray arrRow = obj4.getJSONArray("row");
                        for (int i = 0; i < arrRow.length(); i++) {
                            JSONObject objRowIntern = arrRow.getJSONObject(i);
                            arrFL1 = objRowIntern.getJSONArray("FL");
                            document = new Document();
                            arrayPres();
                            listDocument.add(document);
                        }
                    } else {
                        JSONObject objRow = obj4.getJSONObject("row");
                        arrFL1 = objRow.getJSONArray("FL");
                        document = new Document();
                        arrayPres();
                        listDocument.add(document);
                    }
                } else{
                    ClassConexion.mensaje = "No hay datos para mostrar";
                    ClassConexion.msj = true;
                }
            } catch (Exception e) {
                Log.d("Descricion del error", e.toString());
                ClassConexion.msj = false;
                ClassConexion.mensaje = "Error al obtener los datos2";
            }
        }
    }

    private void arrayPres(){
        for (int i = 0; i < arrFL1.length(); i++) {
            try {
                JSONObject obj6 = arrFL1.getJSONObject(i);
                if (obj6.getString("val").equals("id")) {
                    document.setIdDoc(obj6.getString("content"));
                } else if (obj6.getString("val").equals("File Name")) {
                    document.setDocName(obj6.getString("content"));
                } else if (obj6.getString("val").equals("Size")) {
                    document.setDocSize(obj6.getString("content"));
                }
            } catch (Exception e) {
                Log.d("Descricion del error", e.toString());
                ClassConexion.msj = false;
                ClassConexion.mensaje = "Error al obtener los datos3";
            }
        }
    }





}