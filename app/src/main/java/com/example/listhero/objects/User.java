package com.example.listhero.objects;

public class User {

    private int idUser;
    private String nameUser, email, passUser;

    public User() {    }

    public User(String nameUser, String email, String passUser) {

        this.nameUser = nameUser;
        this.email = email;
        this.passUser = passUser;
    }

    public User(int idUser, String nameUser, String email, String passUser) {

        this.idUser = idUser;
        this.nameUser = nameUser;
        this.email = email;
        this.passUser = passUser;
    }

    public int getIdUser() {  return idUser;  }

    public void setIdUser(int idUser) {  this.idUser = idUser;  }

    public String getNameUser() {  return nameUser;  }

    public void setNameUser(String nameUser) {  this.nameUser = nameUser;  }

    public String getEmail() {  return email;  }

    public void setEmail(String email) {  this.email = email;  }

    public String getPassUser() {  return passUser;  }

    public void setPassUser(String passUser) {  this.passUser = passUser;  }

}