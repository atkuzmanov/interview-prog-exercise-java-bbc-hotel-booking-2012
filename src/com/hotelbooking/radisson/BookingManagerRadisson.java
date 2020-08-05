package com.hotelbooking.radisson;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hotelbooking.interfaces.BookingManager;

/*
 * Author: Atanas Kuzmanov
 */
public class BookingManagerRadisson implements BookingManager {
	
	/*
	 * A Collection to keep objects which keep the state of the current bookings.
	 */
	private List<BookingRadisson> bookings;
	/*
	 * A Collection to keep the total number of rooms which the hotel physically has.
	 */
	private List<Integer> totalRooms;

	//Constructor
	public BookingManagerRadisson(){
		bookings = Collections.synchronizedList(new ArrayList<BookingRadisson>());
		totalRooms = Collections.synchronizedList(new ArrayList<Integer>());
	}

	/*
	 * (non-Javadoc)
	 * @see com.hotelbooking.interfaces.BookingManager#isRoomAvailable(java.lang.Integer, java.sql.Date)
	 * The method is NOT synchronized to prevent reentrant deadlock as it has fine grain locking.
	 * There is an additional synchronized block, locking on the bookings ArrayList object monitor
	 * for fine grained locking.
	 * This method goes through all current bookings and checks if the selected room is booked or not
	 * for the selected date.
	 */
	public boolean isRoomAvailable(Integer room, Date date) throws NullPointerException {
		if(bookings != null){
			synchronized (bookings) { //fine grained locking on object monitor
					for(BookingRadisson b : bookings){
						if(b.getRoomId() == room && b.getBookingDate() == date){ //room Integer autounboxing
								return false;
						} 
					}	
				return true;
			}
		} else {
			throw new NullPointerException("Bookings are not available!");
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.hotelbooking.interfaces.BookingManager#addBooking(java.lang.String, java.lang.Integer, java.sql.Date)
	 * The method is NOT synchronized to prevent reentrant deadlock as it has fine grain locking.
	 * There is an additional synchronized block, locking on the bookings ArrayList object monitor
	 * for fine grained locking.
	 * This method adds a new booking for the selected room, on the selected date for the specified
	 * person.
	 */
	public void addBooking(String guest, Integer room, Date date){
		BookingRadisson newBooking = new BookingRadisson();
		newBooking.setLastName(guest);
		newBooking.setRoomId(room);
		newBooking.setBookingDate(date);
		synchronized (bookings) { //fine grained locking on object monitor
			bookings.add(newBooking);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.hotelbooking.interfaces.BookingManager#getAvailableRooms(java.sql.Date)
	 * The method is NOT synchronized to prevent reentrant deadlock as it has fine grain locking.
	 * There is an additional synchronized block, locking on the bookings ArrayList object monitor
	 * for fine grained locking.
	 * This method iterates over all physical rooms which the hotel has and checks for each one
	 * if it is available for the specified date. Then it returns a List with the ids of all
	 * the available rooms for the specified date.
	 */
	public List<Integer> getAvailableRooms(Date date) throws NullPointerException {
		if(totalRooms != null){
			synchronized (totalRooms) { //fine grained locking on object monitor
				List<Integer> availableRooms = Collections.synchronizedList(new ArrayList<Integer>());			
					for(Integer room : totalRooms){
						if(isRoomAvailable(room, date)){
							availableRooms.add(room);
						}
					}
				return availableRooms;	
			}
		} else {
			throw new NullPointerException("Total number of rooms not available!");
		}
	}
	
	//Getter method for data encapsulation. Synchronized for thread-safe use.
	public synchronized List<BookingRadisson> getBookings() {
		synchronized (bookings) { //fine grained locking on object monitor
			return bookings;
		}
	}

	//Setter method for data encapsulation. Synchronized for thread-safe use.
	public synchronized void setBookings(List<BookingRadisson> bookings) {
		synchronized (this.bookings) { //fine grained locking on object monitor
			this.bookings = bookings;
		}
	}
	
	//Getter method for data encapsulation. Synchronized for thread-safe use.
	public synchronized List<Integer> getTotalRooms() {
		synchronized (totalRooms) { //fine grained locking on object monitor
			return totalRooms;	
		}
	}

	//Setter method for data encapsulation. Synchronized for thread-safe use.
	public synchronized void setTotalRooms(List<Integer> totalRooms) {
		synchronized (this.totalRooms) { //fine grained locking on object monitor
			this.totalRooms = totalRooms;
		}
	}

}
