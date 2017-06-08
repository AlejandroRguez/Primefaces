package com.sdi.business.impl.classes.seats;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Seat;
import com.sdi.persistence.exception.NotPersistedException;

public class FindByUserAndTrip {

	public Seat findByUserAndTrip(Long userId, Long tripId) {
		try {
			return Factories.persistence.newSeatDao().findByUserAndTrip(userId, tripId);
		} catch (NotPersistedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
