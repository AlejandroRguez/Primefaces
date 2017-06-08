package com.sdi.business.impl.classes.seats;

import java.util.List;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Seat;

public class GetSeats {

	public List<Seat> getAll() {
		return Factories.persistence.newSeatDao().findAll();
	}

}
