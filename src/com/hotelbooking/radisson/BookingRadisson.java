package com.hotelbooking.radisson;

import java.sql.Date;

import com.hotelbooking.interfaces.Booking;

/*
 * Author: Atanas Kuzmanov
 */

/*
 * Class for holding the state of a booking.
 * It holds the room id, the booking date and the last name of the person
 * who has booked the room.
 * Has getter and setter methods for data encapsulation.
 */
public class BookingRadisson implements Booking{
	
	private int roomId = 0;
	private Date bookingDate = null;
	private String lastName = "";
	
	public synchronized int getRoomId() {
		return roomId;
	}
	public synchronized void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public synchronized Date getBookingDate() {
		return bookingDate;
	}
	public synchronized void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public synchronized String getLastName() {
		return lastName;
	}
	public synchronized void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
