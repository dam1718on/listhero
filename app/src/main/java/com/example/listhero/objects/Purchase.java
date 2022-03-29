package com.example.listhero.objects;

public class Purchase {

    private int orderPurchase;
    private String product, market, descriptionPurchase;
    private float quantity, price;

    public Purchase() {    }

    public Purchase(int orderPurchase, String product, String market, String descriptionPurchase,
                    float quantity, float price) {

        this.orderPurchase = orderPurchase;
        this.product = product;
        this.market = market;
        this.descriptionPurchase = descriptionPurchase;
        this.quantity = quantity;
        this.price = price;
    }

    public Purchase(Purchase purchase) {

        this.orderPurchase = purchase.getOrderPurchase();
        this.product = purchase.getProduct();
        this.market = purchase.getMarket();
        this.descriptionPurchase = purchase.getDescriptionPurchase();
        this.quantity = purchase.getQuantity();
        this.price = purchase.getPrice();
    }

    public int getOrderPurchase() {  return orderPurchase;  }

    public void setOrderPurchase(int orderPurchase) {  this.orderPurchase = orderPurchase;  }

    public String getProduct() {  return product;  }

    public void setProduct(String product) {  this.product = product;  }

    public String getMarket() {  return market;  }

    public void setMarket(String market) {  this.market = market;  }

    public String getDescriptionPurchase() {  return descriptionPurchase;  }

    public void setDescriptionPurchase(String descriptionPurchase) {
        this.descriptionPurchase = descriptionPurchase;
    }

    public float getQuantity() {  return quantity;  }

    public void setQuantity(float quantity) {  this.quantity = quantity;  }

    public float getPrice() {  return price;  }

    public void setPrice(float price) {  this.price = price;  }

}