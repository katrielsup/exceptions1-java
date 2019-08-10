package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room number: ");
		int number = sc.nextInt();
		System.out.println("Check in date (dd/MM/yyyy) : ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check out date (dd/MM/yyyy) : ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println(
					"Datas informadas s�o invalidas caralho , filho da puta disgra�ado que n�o sabe digitar seu bosta , se mate loCo.");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation : " + reservation);

			System.out.println();
			System.out.println("Enter data to Update the resevation: ");
			System.out.println("Check in date (dd/MM/yyyy) : ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check out date (dd/MM/yyyy) : ");
			checkOut = sdf.parse(sc.next());
			
			String error =reservation.updateDates(checkIn, checkOut);
			if(error != null) {
				System.out.println("Seu filha da puta digita direito caralho. o erro � teu seu petista maldito");
			}else {
				System.out.println();
				System.out.println("Reservation : " + reservation);
			}
				
		}

		sc.close();
	}

}
