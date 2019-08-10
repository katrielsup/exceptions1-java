package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.println("Room number: ");
			int number = sc.nextInt();
			System.out.println("Check in date (dd/MM/yyyy) : ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check out date (dd/MM/yyyy) : ");
			Date checkOut = sdf.parse(sc.next());

			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation : " + reservation);

			System.out.println();
			System.out.println("Enter data to Update the resevation: ");
			System.out.println("Check in date (dd/MM/yyyy) : ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check out date (dd/MM/yyyy) : ");
			checkOut = sdf.parse(sc.next());

			reservation.updateDates(checkIn, checkOut);

			System.out.println("Reservation : " + reservation);

		} catch (ParseException e) {
			System.out.println("Data invalida seu otario filho da puta disgra�ado , maldito fa�a data certo caralho.");
		} catch (IllegalAccessError e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}

}
