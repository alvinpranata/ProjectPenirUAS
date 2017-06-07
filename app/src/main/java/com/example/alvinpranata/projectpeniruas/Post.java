package com.example.alvinpranata.projectpeniruas;

/**
 * Created by AlvinPranata on 07/06/2017.
 */

public class Post {
    private int id;
    private String title;
    private String timestamp;
    private String gambar;
    private String kategori;
    private int jumlah_like;

    public Post(int id, String title, String timestamp, String gambar, String kategori,int jumlah_like) {
        this.id = id;
        this.title = title;
        this.timestamp = timestamp;
        this.gambar = gambar;
        this.kategori = kategori;
        this.jumlah_like = jumlah_like;
    }

    public int getJumlah_like() {
        return jumlah_like;
    }

    public void setJumlah_like(int jumlah_like) {
        this.jumlah_like = jumlah_like;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategoriId(String kategori) {
        this.kategori = kategori;
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
        return timestamp;
    }

    public void setTanggal(String tanggal) {
        this.timestamp = tanggal;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }


    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", gambar='" + gambar + '\'' +
                ", kategori='" + kategori + '\'' +
                ", jumlah_like=" + jumlah_like +
                '}';
    }
}
