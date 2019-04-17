
package com.example.ahsannaveed.foodpandaappclone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainModel {

    @SerializedName("delivery")
    @Expose
    private String delivery;
    @SerializedName("iamge")
    @Expose
    private String iamge;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("delviery")
    @Expose
    private String delviery;

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getIamge() {
        return iamge;
    }

    public void setIamge(String iamge) {
        this.iamge = iamge;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDelviery() {
        return delviery;
    }

    public void setDelviery(String delviery) {
        this.delviery = delviery;
    }

}
