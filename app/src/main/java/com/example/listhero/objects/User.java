package com.example.listhero.objects;

import java.io.Serializable;

public class User implements Serializable {

    private final int idUser;
    private final String nameUser, email;
    private String passUser;

    public User(int idUser, String nameUser, String email, String passUser) {

        this.idUser = idUser;
        this.nameUser = nameUser;
        this.email = email;
        this.passUser = passUser;
    }

    public User(User user) {

        this.idUser = user.getIdUser();
        this.nameUser = user.getNameUser();
        this.email = user.getEmail();
        this.passUser = user.getPassUser();
    }

    public int getIdUser() {  return idUser;  }

    public String getNameUser() {  return nameUser;  }

    public String getEmail() {  return email;  }

    public String getPassUser() {  return passUser;  }

    public void setPassUser(String passUser) {  this.passUser = passUser;  }

}