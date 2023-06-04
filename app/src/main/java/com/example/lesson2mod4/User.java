package com.example.lesson2mod4;

import java.io.Serializable;

public class User implements Serializable {

    //поля
    private String id;
    private int age;
    private String departurePoint;
    private String arrivalPoint;
    private String departureDate;
    private int cost;

    //конструктор


    public User(String id, int age, String departurePoint, String arrivalPoint, String departureDate, int cost) {
        this.id = id;
        this.age = age;
        this.departurePoint = departurePoint;
        this.arrivalPoint = arrivalPoint;
        this.departureDate = departureDate;
        this.cost = cost;
    }

    //геттеры

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public String getArrivalPoint() {
        return arrivalPoint;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public int getCost() {
        return cost;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

