package com.hotelbooking.radisson;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.hotelbooking.interfaces.BookingManager;
import com.hotelbooking.interfaces.Hotel;

/*
 * Author: Atanas Kuzmanov
 */
public class HotelRadisson implements Hotel{

	/*
	 * A Collection to keep the number of rooms a hotel physically has, 
	 * the hotel may build more floors
	 * so this is why I've used an ArrayList to allow future development.
	 * This is also a synchronizedList for thread-safe purposes.
	 */
	private static List<Integer> hotelRooms;
	private static Date toBookDate;
	private static BookingManagerRadisson bmr;
	
	public static void main(String[] args) {
		//synchronized ArrayList to allow a number of hotel staff  to use the system at once.
		hotelRooms =  Collections.synchronizedList(new ArrayList<Integer>(Arrays.asList(101, 102, 103, 201, 202, 203)));
		
		try{
			bmr = new BookingManagerRadisson(); //BookingManager instance
			bmr.setTotalRooms(hotelRooms); //loading the physical rooms in the BookingManager
			
			//Task 1 example use:
			toBookDate = Date.valueOf("2012-07-02");
			System.out.println(bmr.isRoomAvailable(101, toBookDate));
			bmr.addBooking("Bond", 101, toBookDate);
			System.out.println(bmr.isRoomAvailable(101, toBookDate));
			
			//Task 2 example use:
			System.out.print("Rooms: ");
			for(Integer i : bmr.getAvailableRooms(toBookDate)){
				System.out.print(i + "; ");
			}
			System.out.println("are available for booking on " + toBookDate +".");
		} catch (NullPointerException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	//Getter method for data encapsulation. Synchronized for thread-safe use.
	public synchronized List<Integer> getHotelRooms() {
		return hotelRooms;
	}

	//Setter method for data encapsulation. Synchronized for thread-safe use.
	public synchronized void setHotelRooms(List<Integer> hotelRooms) {
		HotelRadisson.hotelRooms = hotelRooms;
	}
	
	//Getter method for data encapsulation. Synchronized for thread-safe use.
	public synchronized BookingManager getBookingManager() {
		return bmr;
	}

	//Setter method for data encapsulation. Synchronized for thread-safe use.
	public synchronized void setBookingManager(BookingManager bm) {
		HotelRadisson.bmr = (BookingManagerRadisson) bm;
	}

}
