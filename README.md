# README

Please find the .java files for the solution in the "src" folder (part of an Eclipse Indigo x32 project),
in the relevant packages:

```java
com.hotelbooking.interfaces - interfaces
com.hotelbooking.radisson – implementation
```

For the purpose of this exercise I have implemented the Abstract Factory Design Pattern.
Please see the "Abstrac Factory Design Pattern.jpg" and the ReadMe.doc/ReadMe.txt.

## Hotel

Hotel interface is the abstract factory for creating a family of hotels.
Hotel declares a interface for operations that create abstract products.

```java
HotelRadisson
HotelRadisson implements the Hotel interface.
HotelRadisson implements operations to create concrete products.
```

## BookingManager

BookingManager is an abstract product.
BookingManager declares an interface for a type of product objects.

## BookingManagerRadisson

BookingManagerRadisson is a product.
BookingManagerRadisson defines a product to be created by the corresponding ConcreteFactory (`BookingManagerRadisson`); it implements the AbstractProduct interface (`BookingManager`).

## Client

Client (hotel staff) uses the interfaces declared by the AbstractFactory and AbstractProduct classes.
UML diagram:

![1](Abstract%20Factory%20Design%20Pattern.jpg)

## Thread-safe

To ensure a thread-safe operation in a multi-threaded environment I have used Coarse Grained Locking and Fine Grained Locking techniques, using synchronized methods and synchronized blocks locking on an objects internal monitor.

## Exception Handling

The necessary exception handling has been implemented. Some methods are throwing exceptions with custom messages which are passed up the stack and handled appropriately in the relevant class with try catch blocks.

---
