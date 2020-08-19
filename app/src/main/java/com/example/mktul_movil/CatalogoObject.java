package com.example.mktul_movil;

public class CatalogoObject {
    private String nombreCat, vendCat;
    private int imgCat;
//objeto catalogo
    public CatalogoObject() {
    }

    public CatalogoObject(String nombreCat, String vendCat, int imgCat) {
        this.nombreCat = nombreCat;
        this.vendCat = vendCat;
        this.imgCat = imgCat;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombrreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

    public String getVendCat() {
        return vendCat;
    }

    public void setVendCat(String vendCat) {
        this.vendCat = vendCat;
    }

    public int getImgCat() {
        return imgCat;
    }

    public void setImgCat(int imgCat) {
        this.imgCat = imgCat;
    }
}
