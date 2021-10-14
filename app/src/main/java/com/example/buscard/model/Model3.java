package com.example.buscard;

public class Model3 {

    String date, cardNo, fare, distance, startingPoint, endingPoint;

    public Model3() {
    }

    public Model3(String date, String cardNo, String fare, String distance, String startingPoint, String endingPoint) {
        this.date = date;
        this.cardNo = cardNo;
        this.fare = fare;
        this.distance = distance;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getEndingPoint() {
        return endingPoint;
    }

    public void setEndingPoint(String endingPoint) {
        this.endingPoint = endingPoint;
    }
}
