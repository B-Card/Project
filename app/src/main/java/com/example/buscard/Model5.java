package com.example.buscard;

public class Model5 {

    String cardNo, date, distance, endingPoint, fare, startingPoint;

    public Model5() {
    }

    public Model5(String cardNo, String date, String distance, String endingPoint, String fare, String startingPoint) {
        this.cardNo = cardNo;
        this.date = date;
        this.distance = distance;
        this.endingPoint = endingPoint;
        this.fare = fare;
        this.startingPoint = startingPoint;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getEndingPoint() {
        return endingPoint;
    }

    public void setEndingPoint(String endingPoint) {
        this.endingPoint = endingPoint;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }
}
