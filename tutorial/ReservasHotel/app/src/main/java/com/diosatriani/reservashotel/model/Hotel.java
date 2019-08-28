package com.diosatriani.reservashotel.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hotel {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nama_hotel")
    @Expose
    private String namaHotel;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lng")
    @Expose
    private String lng;
    @SerializedName("alamat_hotel")
    @Expose
    private String alamatHotel;
    @SerializedName("notelp")
    @Expose
    private String notelp;
    @SerializedName("kelas")
    @Expose
    private String kelas;
    @SerializedName("tarif")
    @Expose
    private String tarif;

    public Hotel() {
        this.id = id;
        this.namaHotel = namaHotel;
        this.lat = lat;
        this.lng = lng;
        this.alamatHotel = alamatHotel;
        this.notelp = notelp;
        this.kelas = kelas;
        this.tarif = tarif;
        this.imageHotel = imageHotel;
    }

    @SerializedName("image_hotel")
    @Expose
    private String imageHotel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaHotel() {
        return namaHotel;
    }

    public void setNamaHotel(String namaHotel) {
        this.namaHotel = namaHotel;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getAlamatHotel() {
        return alamatHotel;
    }

    public void setAlamatHotel(String alamatHotel) {
        this.alamatHotel = alamatHotel;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public String getImageHotel() {
        return imageHotel;
    }

    public void setImageHotel(String imageHotel) {
        this.imageHotel = imageHotel;
    }
}
