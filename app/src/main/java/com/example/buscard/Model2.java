package com.example.buscard;

public class Model2 {

    String routeName, busName, busNO, busTime, driverName;

    public Model2() {
    }

    public Model2(String routeName, String busName, String busNO, String busTime, String driverName) {
        this.routeName = routeName;
        this.busName = busName;
        this.busNO = busNO;
        this.busTime = busTime;
        this.driverName = driverName;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getBusNO() {
        return busNO;
    }

    public void setBusNO(String busNO) {
        this.busNO = busNO;
    }

    public String getBusTime() {
        return busTime;
    }

    public void setBusTime(String busTime) {
        this.busTime = busTime;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}
