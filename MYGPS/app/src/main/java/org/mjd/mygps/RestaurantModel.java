package org.mjd.mygps;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by Jerrys on 2015-07-28.
 */
public class RestaurantModel {

    private ArrayList<Restaurant> NE = new ArrayList<>();  //북동
    private ArrayList<Restaurant> NW = new ArrayList<>();  //북서
    private ArrayList<Restaurant> SE = new ArrayList<>();  //남동
    private ArrayList<Restaurant> SW = new ArrayList<>();  //남서

    public RestaurantModel(){
        NE.add(new Restaurant(126.9421816,37.5138589,"홈스테드","02-825-3359"));
        NE.add(new Restaurant(126.9440458,37.5119953,"역전우동0410","02-825-0410"));
        NE.add(new Restaurant(126.9454925,37.5132417,"타이팟","02-824-2181"));

        NW.add(new Restaurant(126.9380114,37.5130529, "하노이별", "02-824-7470"));
        NW.add(new Restaurant(126.9369000,37.5125750, "백가네해물칼국수", "02-815-6555"));

        SW.add(new Restaurant(126.9396987, 37.5069320, "풍성식당", "02-812-6447"));
        SW.add(new Restaurant(126.9324260,37.5074360, "가정식백반옛골"," "));
        SW.add(new Restaurant(126.9387730,37.5081210, "영빈관","02-813-3088"));

        SE.add(new Restaurant(126.9477678 ,37.5079397, "바지락칼국수", "02-813-9936"));
        SE.add(new Restaurant(126.9452561 ,37.5075738, "천외천", "02-6745-7000"));
    }


    public ArrayList getNE(){
        return this.NE;
    }
    public ArrayList getNW(){
        return this.NW;
    }
    public ArrayList getSW(){
        return this.SW;
    }
    public ArrayList getSE(){
        return this.SE;
    }

}
