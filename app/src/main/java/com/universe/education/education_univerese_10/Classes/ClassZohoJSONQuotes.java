package com.universe.education.education_univerese_10.Classes;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ClassZohoJSONQuotes {

    public static ArrayList<Quote> listQuote;
    private String json;
    private JSONArray arrFL1;
    private JSONArray arrFL2;
    private Quote quote;
    private Product product;
    private ArrayList<Product> listProductTemp;


    public ClassZohoJSONQuotes() {
        listQuote = new ArrayList<>();
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
            ClassConexion.mensaje = "Error al obtener los datos";
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
                    JSONObject obj4 = obj3.getJSONObject("Quotes");
                    JSONObject auxJson = obj4.optJSONObject("row");
                    if (auxJson == null) {
                        JSONArray arrRow = obj4.getJSONArray("row");
                        for (int i = 0; i < arrRow.length(); i++) {
                            JSONObject objRowIntern = arrRow.getJSONObject(i);
                            arrFL1 = objRowIntern.getJSONArray("FL");
                            listProductTemp = new ArrayList<>();
                            quote = new Quote();
                            arrayPres();
                            listQuote.add(quote);
                        }
                    } else {
                        JSONObject objRow = obj4.getJSONObject("row");
                        arrFL1 = objRow.getJSONArray("FL");
                        listProductTemp = new ArrayList<>();
                        quote = new Quote();
                        arrayPres();
                        listQuote.add(quote);
                    }
                } else{
                    ClassConexion.mensaje = "No hay datos para mostrar";
                    ClassConexion.msj = true;
                }
            } catch (Exception e) {
                Log.d("Descricion del error", e.toString());
                ClassConexion.msj = false;
                ClassConexion.mensaje = "Error al obtener los datos";
            }
        }
    }

    private void arrayPres(){
        for (int i = 0; i < arrFL1.length(); i++) {
            try {
                JSONObject obj6 = arrFL1.getJSONObject(i);
                if (obj6.getString("val").equals("QUOTEID")) {
                    quote.setIdPres(obj6.getString("content"));
                } else if (obj6.getString("val").equals("Quote Number")) {
                    quote.setNumPres(obj6.getString("content"));
                } else if (obj6.getString("val").equals("Subject")) {
                    quote.setAsunto(obj6.getString("content"));
                }else if (obj6.getString("val").equals("Quote Stage")) {
                    quote.setFasPres(obj6.getString("content"));
                } else if (obj6.getString("val").equals("Sub Total")) {
                    quote.setSubTotal(obj6.getString("content"));
                } else if (obj6.getString("val").equals("Tax")) {
                    quote.setImpuesto(obj6.getString("content"));
                } else if (obj6.getString("val").equals("Adjustment")) {
                    quote.setAjuste(obj6.getString("content"));
                } else if (obj6.getString("val").equals("Grand Total")) {
                    quote.setTotalGen(obj6.getString("content"));
                } else if (obj6.getString("val").equals("Product Details")) {
                    JSONObject auxJson = obj6.optJSONObject("product");
                    if (auxJson == null){
                        JSONArray arrProd = obj6.getJSONArray("product");
                        for (int j = 0; j < arrProd.length(); j++){
                            JSONObject objProdIntern = arrProd.getJSONObject(j);
                            arrFL2 = objProdIntern.getJSONArray("FL");
                            product = new Product();
                            arrayProduct();
                            listProductTemp.add(product);
                        }
                        quote.setListProduct(listProductTemp);
                    } else {
                        JSONObject objProd = obj6.getJSONObject("product");
                        arrFL2 = objProd.getJSONArray("FL");
                        product = new Product();
                        arrayProduct();
                        listProductTemp.add(product);
                        quote.setListProduct(listProductTemp);
                    }
                } else if (obj6.getString("val").equals("Terms and Conditions")) {
                    quote.setTermAndCond(obj6.getString("content"));
                } else if (obj6.getString("val").equals("Description")) {
                    quote.setDescripcion(obj6.getString("content"));
                } else if (obj6.getString("val").equals("Discount")) {
                    quote.setDescuento(obj6.getString("content"));
                } else if (obj6.getString("val").equals("Vendedor")) {
                    quote.setVend(obj6.getString("content"));
                } else if (obj6.getString("val").equals("Monto Inicial a pagar")) {
                    quote.setMontIni(obj6.getString("content"));
                } else if (obj6.getString("val").equals("Monto restante a pagar")) {
                    quote.setMontRest(obj6.getString("content"));
                }
            } catch (Exception e) {
                Log.d("Descricion del error", e.toString());
                ClassConexion.msj = false;
                ClassConexion.mensaje = "Error al obtener los datos";
            }
        }
    }

    private void arrayProduct(){
        //auxInt = 0;
        for (int i = 0; i < arrFL2.length(); i++) {
            //auxInt++;
            try {
                JSONObject obj6 = arrFL2.getJSONObject(i);
                if (obj6.getString("val").equals("Product Id")) {
                    product.setIdProd(obj6.getString("content"));
                } else if (obj6.getString("val").equals("Product Name")) {
                    product.setNameProd(obj6.getString("content"));
                } else if (obj6.getString("val").equals("Unit Price")) {
                    product.setPrecUnit(obj6.getString("content"));
                } else if (obj6.getString("val").equals("Quantity")) {
                    product.setCant(obj6.getString("content"));
                } else if (obj6.getString("val").equals("Total")) {
                    product.setTotal(obj6.getString("content"));
                } else if (obj6.getString("val").equals("Discount")) {
                    product.setDescu(obj6.getString("content"));
                } else if (obj6.getString("val").equals("Total After Discount")) {
                    product.setTotalAftDesc(obj6.getString("content"));
                } else if (obj6.getString("val").equals("Product Description")) {
                    product.setDescripcion(obj6.getString("content"));
                }
            } catch (Exception e) {
                Log.d("Descricion del error", e.toString());
                ClassConexion.msj = false;
                ClassConexion.mensaje = "Error al obtener los datos";
            }
        }
    }

}

