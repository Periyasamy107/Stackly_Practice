package com.demo.lombokExample1.model;

import jdk.jfr.DataAmount;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Restaurant {
    private int restaurantId;
    private String restaurantName;
    private String location;
}
