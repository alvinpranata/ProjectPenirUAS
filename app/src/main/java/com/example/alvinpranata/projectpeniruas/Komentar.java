package com.example.alvinpranata.projectpeniruas;

/**
 * Created by AlvinPranata on 07/06/2017.
 */

public class Komentar {
    private String isi;
    private String userId;
    private int id;

    public Komentar(String isi, String userId, int id) {
        this.isi = isi;
        this.userId = userId;
        this.id = id;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
