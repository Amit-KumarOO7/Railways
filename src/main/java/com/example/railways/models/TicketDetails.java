package com.example.railways.models;


import javax.persistence.*;


@Entity
@Table(name = "tickets")
public class TicketDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int tbId;

    private int uId;

    private int trainNumber;

    private String tbSource;

    private String tbDestination;

    private String tbStatus;
    
    public TicketDetails(int tbId, int uId, int trainNumber, String tbSource, String tbDestination, String tbStatus) {
        this.tbId = tbId;
        this.uId = uId;
        this.trainNumber = trainNumber;
        this.tbSource = tbSource;
        this.tbDestination = tbDestination;
        this.tbStatus = tbStatus;
    }

    public TicketDetails() {
    }
    

    public int getuId() {
        return uId;
    }

    public int getTbId() {
        return tbId;
    }

    public void setTbId(int tbId) {
        this.tbId = tbId;
    }

    public String getTbStatus() {
        return tbStatus;
    }

    public void setTbStatus(String tbStatus) {
        this.tbStatus = tbStatus;
    }

    public String getTbDestination() {
        return tbDestination;
    }

    public void setTbDestination(String tbDestination) {
        this.tbDestination = tbDestination;
    }

    public String getTbSource() {
        return tbSource;
    }

    public void setTbSource(String tbSource) {
        this.tbSource = tbSource;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }
}