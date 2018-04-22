package com.eurezzolve.eucorretor.model;

/**
 * Created by viana_2 on 17/04/2018.
 */

public class Config {

    private String item;
    private int vector;
    private int order;

    public Config() {
    }

    public Config(String item, int vector, int order) {
        this.item = item;
        this.vector = vector;
        this.order = order;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getVector() {
        return vector;
    }

    public void setVector(int vector) {
        this.vector = vector;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
