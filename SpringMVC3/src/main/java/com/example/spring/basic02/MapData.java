package com.example.spring.basic02;

import java.util.*;

public class MapData  {
    private Map<String, Long> data = new HashMap<String, Long>();

    public MapData() {
        this.data.put("first", 13700000000L);
        this.data.put("second", 326190476L);
    }

    public Long findLong(String entry) {
        return this.data.get(entry);
    }
}