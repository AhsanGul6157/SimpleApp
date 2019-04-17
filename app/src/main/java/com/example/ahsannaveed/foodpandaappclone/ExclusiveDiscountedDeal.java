
package com.example.ahsannaveed.foodpandaappclone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExclusiveDiscountedDeal {

    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("title")
    @Expose
    private String title;

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

}
