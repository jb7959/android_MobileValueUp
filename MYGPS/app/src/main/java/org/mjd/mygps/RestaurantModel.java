package org.mjd.mygps;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by Jerrys on 2015-07-28.
 */
public class RestaurantModel {

    private ArrayList<Restaurant> NE = new ArrayList<>();  //�ϵ�
    private ArrayList<Restaurant> NW = new ArrayList<>();  //�ϼ�
    private ArrayList<Restaurant> SE = new ArrayList<>();  //����
    private ArrayList<Restaurant> SW = new ArrayList<>();  //����

    public RestaurantModel(){
        NE.add(new Restaurant(126.9421816,37.5138589,"Ȩ���׵�","02-825-3359"));
        NE.add(new Restaurant(126.9440458,37.5119953,"�����쵿0410","02-825-0410"));
        NE.add(new Restaurant(126.9454925,37.5132417,"Ÿ����","02-824-2181"));

        NW.add(new Restaurant(126.9380114,37.5130529, "�ϳ��̺�", "02-824-7470"));
        NW.add(new Restaurant(126.9369000,37.5125750, "�鰡���ع�Į����", "02-815-6555"));

        SW.add(new Restaurant(126.9396987, 37.5069320, "ǳ���Ĵ�", "02-812-6447"));
        SW.add(new Restaurant(126.9324260,37.5074360, "�����Ĺ�ݿ���"," "));
        SW.add(new Restaurant(126.9387730,37.5081210, "�����","02-813-3088"));

        SE.add(new Restaurant(126.9477678 ,37.5079397, "������Į����", "02-813-9936"));
        SE.add(new Restaurant(126.9452561 ,37.5075738, "õ��õ", "02-6745-7000"));
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
