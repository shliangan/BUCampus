package com.example.shnliang.bucampus;

/**
 * Created by shnliang on 4/23/15.
 */
public class BUBuildings {
    private String building;
    private String description;
    private String address;

    public BUBuildings(String building, String description, String address){
        this.building=building;
        this.description=description;
        this.address=address;


    }

    public String getBuilding(){
        return this.building;
    }

    public String getDescription(){
        return this.description;
    }

    public String getAddress(){
        return this.address;
    }


}

