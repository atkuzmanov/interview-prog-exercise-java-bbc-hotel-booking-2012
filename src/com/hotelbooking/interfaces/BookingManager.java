package com.hotelbooking.interfaces;

import java.sql.Date;

public interface BookingManager {

	/**
	 * Return true if there is no booking for the given room on the date,
	 * otherwise false
	 * @return boolean
	 */
	public boolean isRoomAvailable(Integer room, Date date);

	/**
	 * Add a booking for the given guest in the given room on the given date.
	 * @param String guest
	 * @param Integer room
	 * @param Date date
	 */
	public void addBooking(String guest, Integer room, Date date);

	/**
	 * Return a collection of all the available room numbers for the given date
	 * @param Date date
	 * @return Iterable<Integer>
	 */
	public Iterable<Integer> getAvailableRooms(Date date);
}
