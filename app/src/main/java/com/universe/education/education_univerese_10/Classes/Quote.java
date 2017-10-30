package com.universe.education.education_univerese_10.Classes;

import java.util.ArrayList;
import java.util.List;

public class Quote {

    private ArrayList<Product> listProduct;

    private String idPres;
    private String numPres;
    private String asunto;
    private String fasPres;
    private String subTotal;
    private String impuesto;
    private String ajuste;
    private String totalGen;
    private String termAndCond;
    private String descripcion;
    private String descuento;
    private String vend;
    private String montIni;
    private String montRest;

    public ArrayList<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public String getIdPres() {
        return idPres;
    }

    public void setIdPres(String idPres) {
        this.idPres = idPres;
    }

    public String getNumPres() {
        return numPres;
    }

    public void setNumPres(String numPres) {
        this.numPres = numPres;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getFasPres() {
        return fasPres;
    }

    public void setFasPres(String fasPres) {
        this.fasPres = fasPres;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public String getAjuste() {
        return ajuste;
    }

    public void setAjuste(String ajuste) {
        this.ajuste = ajuste;
    }

    public String getTotalGen() {
        return totalGen;
    }

    public void setTotalGen(String totalGen) {
        this.totalGen = totalGen;
    }

    public String getTermAndCond() {
        return termAndCond;
    }

    public void setTermAndCond(String termAndCond) {
        this.termAndCond = termAndCond;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getVend() {
        return vend;
    }

    public void setVend(String vend) {
        this.vend = vend;
    }

    public String getMontIni() {
        return montIni;
    }

    public void setMontIni(String montIni) {
        this.montIni = montIni;
    }

    public String getMontRest() {
        return montRest;
    }

    public void setMontRest(String montRest) {
        this.montRest = montRest;
    }
}
