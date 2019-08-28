package com.diosatriani.kppn_ii.Model;

public class DummyData {

    private String nominal;
    private String nomerSpm;
    private String tanggal;

    public DummyData(String nominal, String nomerSpm, String tanggal) {
        this.nominal = nominal;
        this.nomerSpm = nomerSpm;
        this.tanggal = tanggal;
    }

    public DummyData() {

    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public String getNomerSpm() {
        return nomerSpm;
    }

    public void setNomerSpm(String nomerSpm) {
        this.nomerSpm = nomerSpm;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
