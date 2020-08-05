package com.hotelbooking.interfaces;

import java.sql.Date;

/*
 * Author: Atanas Kuzmanov
 */
public interface Booking {
	
	/**
	 * Return unique room id
	 * @return int roomId
	 */
	public int getRoomId();

	/**
	 * Set the roomId
	 * @param roomId
	 */
	public void setRoomId(int roomId);

	/**
	 * Return the date of the booking
	 * @return Date bookingDate
	 */
	public Date getBookingDate();

	/**
	 * Set the date of the booking
	 * @param bookingDate
	 */
	public void setBookingDate(Date bookingDate);

	/**
	 * Get the person's unique identifier - person's last name
	 * @return String lastName
	 */
	public String getLastName();

	/**
	 * Set the person's unique identifier - person's last name
	 * @param lastName
	 */
	public void setLastName(String lastName);
}
