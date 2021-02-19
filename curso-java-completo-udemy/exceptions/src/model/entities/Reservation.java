package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat simpleDateFormated = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		
		this.validateDate(checkIn, checkOut);
		
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
//		calcula a diferença em milisegundos
		long diff = checkOut.getTime() - checkIn.getTime();

//		converte milesegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
				
		this.validateDate(checkIn, checkOut);
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public void validateDate(Date checkIn, Date checkOut) throws DomainException {
		Date now = new Date();

		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		}
		
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", check-in: " + simpleDateFormated.format(checkIn) + ", check-out: "
				+ simpleDateFormated.format(checkOut) + ", " + duration() + " nights";
	}

}
