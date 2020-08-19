package com.example.mktul_movil;
//objeto producto para cards
public class Producto {
    private String nombreProd, precioProd;
    private int idProd, imageProd;

    //constructor y constructor vacion
    public Producto(String nombreProd, String precioProd, int idProd, int imageProd) {
        this.nombreProd = nombreProd;
        this.precioProd = precioProd;
        this.idProd = idProd;
        this.imageProd = imageProd;
    }

    public Producto() {
    }


    //getters y setters
    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public String getPrecioProd() {
        return precioProd;
    }

    public void setPrecioProd(String precioProd) {
        this.precioProd = precioProd;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public int getImageProd() {
        return imageProd;
    }

    public void setImageProd(int imageProd) {
        this.imageProd = imageProd;
    }
}
