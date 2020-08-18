package com.barlocator.datastructures;

public class Vertex {
    private int value,weight;
    private String barName;

    public Vertex(int value, String barName) {
        this.value = value;
        this.barName = barName;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "value=" + value +
                ", weight=" + weight +
                ", barName='" + barName + '\'' +
                '}';
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
    }
}
