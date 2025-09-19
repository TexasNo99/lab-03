package com.example.listycitylab3;

import java.io.Serializable;

// The following class is from OpenAI, ChatGPT,
// "How to implement City class?", 2025-09-19
public class City implements Serializable {
    private String name;
    private String province;
    public City(String name, String province) {
        this.name = name;
        this.province = province;
    }
    public String getName() {
        return name;
    }
    public String getProvince() {
        return province;
    }
    public void setName(String name) { this.name = name; }
    public void setProvince(String province) { this.province = province; }
}