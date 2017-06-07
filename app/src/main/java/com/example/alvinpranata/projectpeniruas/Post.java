package com.example.alvinpranata.projectpeniruas;

/**
 * Created by AlvinPranata on 07/06/2017.
 */

public class Post {
    private String nama;
    private int id;
    private String title;
    private String tanggal;
    private String gambar;
    private int kategoriId;

    public Post(String nama, int id, String title, String tanggal, String gambar, int kategoriId) {
        this.nama = nama;
        this.id = id;
        this.title = title;
        this.tanggal = tanggal;
        this.gambar = gambar;
        this.kategoriId = kategoriId;
    }
    public int getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(int kategoriId) {
        this.kategoriId = kategoriId;
    }
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    /*@Override
    public String toString() {
        return "ID : "+id+"\nNama : "+nama+"\nHarga : "+harga+"\nDeskripsi : "+deskripsi;
    }*/

}
