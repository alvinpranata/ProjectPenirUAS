package com.example.alvinpranata.projectpeniruas;

/**
 * Created by AlvinPranata on 07/06/2017.
 */

public class Komentar {
    private String isi;
    private String userId;
    private int id;
    private int post_id;

    public Komentar(int id, String isi, String userId, int post_id) {
        this.isi = isi;
        this.userId = userId;
        this.id = id;
        this.post_id =post_id;
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

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    @Override
    public String toString() {
        return "Komentar{" +
                "isi='" + isi + '\'' +
                ", userId='" + userId + '\'' +
                ", id=" + id +
                ", post_id=" + post_id +
                '}';
    }
}
