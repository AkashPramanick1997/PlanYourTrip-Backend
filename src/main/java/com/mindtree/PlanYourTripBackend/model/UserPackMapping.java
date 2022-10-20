package com.mindtree.PlanYourTripBackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userpack")
public class UserPackMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userPackId;
	private Date checkIn;
	private Date checkOut;
	private int numberOfPeople;
	private int numberOfRooms;
	private double totalAmmount;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "pack_id")
	private Pack pack;

	public UserPackMapping() {

	}

	public int getUserPackId() {
		return userPackId;
	}

	public void setUserPackId(int userPackId) {
		this.userPackId = userPackId;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public double getTotalAmmount() {
		return totalAmmount;
	}

	public void setTotalAmmount(double totalAmmount) {
		this.totalAmmount = totalAmmount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Pack getPack() {
		return pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

	@Override
	public String toString() {
		return "UserPackMapping [userPackId=" + userPackId + ", checkIn=" + checkIn + ", checkOut=" + checkOut
				+ ", numberOfPeople=" + numberOfPeople + ", numberOfRooms=" + numberOfRooms + ", totalAmmount="
				+ totalAmmount + ", user=" + user + ", pack=" + pack + "]";
	}

	public UserPackMapping(int userPackId, Date checkIn, Date checkOut, int numberOfPeople, int numberOfRooms,
			double totalAmmount, User user, Pack pack) {
		super();
		this.userPackId = userPackId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numberOfPeople = numberOfPeople;
		this.numberOfRooms = numberOfRooms;
		this.totalAmmount = totalAmmount;
		this.user = user;
		this.pack = pack;
	}

	
}
