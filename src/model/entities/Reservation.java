package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut){
		if (!checkOut.after(checkIn)) {
			throw new DomainException(
					"Datas informadas s�o invalidas caralho , filho da puta disgra�ado que n�o sabe digitar seu bosta , se mate loCo.");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut)  {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException(
					"Erro da reserva seu otario , disgra�ado digita esta porra certo , seu merdinha ");
		}

		if (!checkOut.after(checkIn)) {
			throw new DomainException(
					"Datas informadas s�o invalidas caralho , filho da puta disgra�ado que n�o sabe digitar seu bosta , se mate loCo.");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;

	}

	@Override
	public String toString() {

		return "  Romm   " + roomNumber + "   Check-in :  " + sdf.format(checkIn) + "  Check-out:   "
				+ sdf.format(checkOut) + " Duration: " + duration() + " noites";
	}

}
