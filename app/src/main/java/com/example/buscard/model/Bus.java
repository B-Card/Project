package com.example.buscard;

public class Bus {

    String busName, busNO, routeName, driverName, busTime;

    public Bus() {
    }

    public Bus(String busName, String busNO, String routeName, String driverName, String busTime) {
        this.busName = busName;
        this.busNO = busNO;
        this.routeName = routeName;
        this.driverName = driverName;
        this.busTime = busTime;
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

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getBusTime() {
        return busTime;
    }

    public void setBusTime(String busTime) {
        this.busTime = busTime;
    }
}
