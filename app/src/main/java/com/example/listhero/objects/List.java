package com.example.listhero.objects;

public class List {

    private int idList, orderList;
    private String nameList, descriptionList;

    public List() {    }

    public List(int idList, int orderList, String nameList, String descriptionList) {

        this.idList = idList;
        this.orderList = orderList;
        this.nameList = nameList;
        this.descriptionList = descriptionList;
    }

    public List(List list) {

        this.idList = list.getIdList();
        this.orderList = list.getOrderList();
        this.nameList = list.getNameList();
        this.descriptionList = list.getDescriptionList();
    }

    public int getIdList() {  return idList;  }

    public void setIdList(int idList) {  this.idList = idList;  }

    public int getOrderList() {  return orderList;  }

    public void setOrderList(int orderList) {  this.orderList = orderList;  }

    public String getNameList() {  return nameList;  }

    public void setNameList(String nameList) {  this.nameList = nameList;  }

    public String getDescriptionList() {  return descriptionList;  }

    public void setDescriptionList(String descriptionList) {  this.descriptionList = descriptionList;  }

}