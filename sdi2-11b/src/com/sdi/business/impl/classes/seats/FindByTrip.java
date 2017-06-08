package com.sdi.business.impl.classes.seats;

import java.util.List;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Seat;

public class FindByTrip {
	
	public List<Seat> findByTrip(Long tripId) {
		return Factories.persistence.newSeatDao().findByTrip(tripId);
	}

}
