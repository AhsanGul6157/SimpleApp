
package com.example.ahsannaveed.foodpandaappclone;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("Exclusive Discounted Deals")
    @Expose
    private List<ExclusiveDiscountedDeal> exclusiveDiscountedDeals = null;
    //    @SerializedName("Handi Specialities")
//    @Expose
//    private List<HandiSpeciality> handiSpecialities = null;
    @SerializedName("Salad")
    @Expose
    private List<Salad> salad = null;
    @SerializedName("Soup")
    @Expose
    private List<Soup> soup = null;
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

    public List<ExclusiveDiscountedDeal> getExclusiveDiscountedDeals() {
        return exclusiveDiscountedDeals;
    }

    public void setExclusiveDiscountedDeals(List<ExclusiveDiscountedDeal> exclusiveDiscountedDeals) {
        this.exclusiveDiscountedDeals = exclusiveDiscountedDeals;
    }

//    public List<HandiSpeciality> getHandiSpecialities() {
//        return handiSpecialities;
//    }
//
//    public void setHandiSpecialities(List<HandiSpeciality> handiSpecialities) {
//        this.handiSpecialities = handiSpecialities;
//    }

    public List<Salad> getSalad() {
        return salad;
    }

    public void setSalad(List<Salad> salad) {
        this.salad = salad;
    }

    public List<Soup> getSoup() {
        return soup;
    }

    public void setSoup(List<Soup> soup) {
        this.soup = soup;
    }

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

}
