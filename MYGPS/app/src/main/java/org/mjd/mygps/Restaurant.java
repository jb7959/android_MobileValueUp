package org.mjd.mygps;

/**
 * Created by Jerrys on 2015-07-28.
 */
public class Restaurant {
    private  Double latitude, longitude;
    private String title, phoneNumber;

    public Restaurant(Double longitude ,Double latitude, String title, String phoneNumber){
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
        this.phoneNumber = phoneNumber;
    }

    public Double getLatitude(){
        return this.latitude;
    }
    public Double getLongitude(){
        return this.longitude;
    }
    public String gettitle(){
        return this.title;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }

}
