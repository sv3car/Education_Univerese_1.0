package com.universe.education.education_univerese_10.Classes;

/**
 * Created by CARLOS on 16/10/2017.
 */

public class Product {

    private String idProd;
    private String nameProd;
    private String descripcion;
    private String precUnit;
    private String cant;
    private String total;
    private String descu;
    private String totalAftDesc;

    public Product(){
        idProd="";
        nameProd="";
        descripcion="";
        precUnit="";
        cant="";
        total="";
        descu="";
        totalAftDesc="";
    }


    public String getIdProd() {
        return idProd;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }

    public String getNameProd() {
        return nameProd;
    }

    public void setNameProd(String nameProd) {
        this.nameProd = nameProd;
    }

    public String getPrecUnit() {
        return precUnit;
    }

    public void setPrecUnit(String precUnit) {
        this.precUnit = precUnit;
    }

    public String getCant() {
        return cant;
    }

    public void setCant(String cant) {
        this.cant = cant;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDescu() {
        return descu;
    }

    public void setDescu(String descu) {
        this.descu = descu;
    }

    public String getTotalAftDesc() {
        return totalAftDesc;
    }

    public void setTotalAftDesc(String totalAftDesc) {
        this.totalAftDesc = totalAftDesc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
