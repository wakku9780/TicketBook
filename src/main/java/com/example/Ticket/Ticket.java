package com.example.Ticket;

public class Ticket {

    public String ticketId;
    public String passengerName;
    public String trainNo;
    public String trainName;
    public String departureStation;
    public String arrivalStation;
    public String departureTime;
    public String arrivalTime;
    public String classType;
    public String seatNumber;

    public Ticket(String passengerName, String trainNo, String trainName, String departureStation, String arrivalStation, String departureTime, String arrivalTime, String classType, String seatNumber) {
        this.passengerName = passengerName;
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.classType = classType;
        this.seatNumber = seatNumber;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}
