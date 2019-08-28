package com.bersama.databasefirebase;
import java.io.Serializable;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Barang implements Serializable {

    private String nama;
    private String merk;
    private String harga;
    private String jumlah;
    private String total;

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    private String key;

    public Barang(){

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return " "+nama+"\n" +
                " "+merk +"\n" +
                " "+harga+"\n" +" "+jumlah+"\n"+" "+total;
    }

    public Barang(String nm, String mrk, String hrg, String jml, String ttl){
        nama = nm;
        merk = mrk;
        harga = hrg;
        jumlah = jml;
        total = ttl;
    }
}
