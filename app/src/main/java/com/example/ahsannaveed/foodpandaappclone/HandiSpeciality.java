
package com.example.ahsannaveed.foodpandaappclone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HandiSpeciality {

    @SerializedName("iamge")
    @Expose
    private String iamge;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("title")
    @Expose
    private String title;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
