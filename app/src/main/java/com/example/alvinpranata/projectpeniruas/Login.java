package com.example.alvinpranata.projectpeniruas;

/**
 * Created by AlvinPranata on 07/06/2017.
 */

public class Login {
    private String username;
    private String nama;
    private String password;
    private int id;
    private boolean isLogin;

    public Login(int id, String username, String nama, String password, boolean isLogin) {
        this.username = username;
        this.nama = nama;
        this.password = password;
        this.id = id;
        this.isLogin = isLogin;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Login{" +
                "username='" + username + '\'' +
                ", nama='" + nama + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", isLogin=" + isLogin +
                '}';
    }
}
