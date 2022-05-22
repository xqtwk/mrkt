package lt.ku.hotel.classes;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;

public class BookingId implements Serializable{
	
	@Column
	private java.time.LocalDate checkIn;
	
	@Column
	private Integer clientID;
	
	@Column
	private Integer roomID;

	
	public BookingId() {
		super();
	}

	public BookingId(LocalDate checkIn, Integer clientID, Integer roomID) {
		super();
		this.checkIn = checkIn;
		this.clientID = clientID;
		this.roomID = roomID;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public java.time.LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(java.time.LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public Integer getClientID() {
		return clientID;
	}

	public void setClientID(Integer clientID) {
		this.clientID = clientID;
	}

	public Integer getRoomID() {
		return roomID;
	}

	public void setRoomID(Integer roomID) {
		this.roomID = roomID;
	}
	
	
}
