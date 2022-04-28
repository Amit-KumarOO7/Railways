package com.example.railways.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "train")
public class Train {
  @Id
  private int trainNumber;
  @Column
  private String source;
  @Column
  private String destination;
  @Column
  private Date arrivalTime;
  @Column
  private Date departureTime;
	public Train() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Train(int trainNumber, String source, String destination, Date arrivalTime, Date departureTime) {
		super();
		this.trainNumber = trainNumber;
		this.source = source;
		this.destination = destination;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	public int getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	@Override
	public String toString() {
		return "Train [trainNumber=" + trainNumber + ", source=" + source + ", destination=" + destination
				+ ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + "]";
	}
}