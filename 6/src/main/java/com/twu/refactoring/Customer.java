package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {
	private static final int REGULAREACHDAYRENT = 2;
	private static final int NEW_RELEASEEACHDAYRENT = 3;
	private static final int CHILDRENSEACHDAYRENT = 3;


	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = rentalList.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental each = rentals.next();

			// determine amounts for each line
			switch (each.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				thisAmount = getThisAmount(thisAmount, each, REGULAREACHDAYRENT);
				break;
			case Movie.NEW_RELEASE:
				thisAmount += each.getDaysRented() * NEW_RELEASEEACHDAYRENT;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				thisAmount = getThisAmount(thisAmount, each, CHILDRENSEACHDAYRENT);
				break;

			}

			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&& each.getDaysRented() > 1)
				frequentRenterPoints++;

			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;

		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}

	private double getThisAmount(double thisAmount, Rental each, int i) {
		if (each.getDaysRented() > i)
			thisAmount += (each.getDaysRented() - i) * 1.5;
		return thisAmount;
	}

}
