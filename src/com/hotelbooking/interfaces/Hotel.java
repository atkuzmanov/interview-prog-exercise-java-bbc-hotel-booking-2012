package com.hotelbooking.interfaces;

import java.util.List;

/*
 * Author: Atanas Kuzmanov
 */
public interface Hotel {

	/**
	 * Get the number of rooms which the hotel physically contains
	 * @return List<Integer>
	 */
	public List<Integer> getHotelRooms();

	/**
	 * Set the number of rooms which the hotel physically contains
	 * @param hotelRooms
	 */
	public void setHotelRooms(List<Integer> hotelRooms);

	/**
	 * Get the instance of the BookingManager
	 * @return BookingManager
	 */
	public BookingManager getBookingManager();

	/**
	 * Set the BookingManager instance
	 * @param bm
	 */
	public void setBookingManager(BookingManager bm);
}
