package lt.ku.hotel.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lt.ku.hotel.classes.BookingId;


@Entity
@Table(name = "Bookings")
@IdClass(BookingId.class)
public class Booking {
	
	@Id
	private java.time.LocalDate checkIn;
	
	@Id
	private Integer clientID;
	
	@Id
	private Integer roomID;
	
	@OneToOne
	@MapsId
	@JoinColumn(name="roomID", nullable = false, insertable = false, updatable = false)
	private Room room;
	
	@OneToOne
	@MapsId
	@JoinColumn(name="clientID", nullable = false, insertable = false, updatable = false)
	private Client client;
	
	private java.time.LocalDate checkOut;

	
	public Booking() {
		super();
	}


	public Booking(LocalDate checkIn, Integer clientID, Integer roomID, Room room, Client client, LocalDate checkOut) {
		super();
		this.checkIn = checkIn;
		this.clientID = clientID;
		this.roomID = roomID;
		this.room = room;
		this.client = client;
		this.checkOut = checkOut;
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


	public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public java.time.LocalDate getCheckOut() {
		return checkOut;
	}


	public void setCheckOut(java.time.LocalDate checkOut) {
		this.checkOut = checkOut;
	}
	
	
	
}
