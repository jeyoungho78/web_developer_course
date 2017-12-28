package com.example.spring.basic02;

public class Calculate {
    private MapData mapData;

    public String devide() {
        Long first = this.mapData.findLong("first");
        Long second = this.mapData.findLong("second");
        return String.valueOf(first / second);
    }

    public void setMapData(MapData mapData) {
        this.mapData = mapData;
    }
}