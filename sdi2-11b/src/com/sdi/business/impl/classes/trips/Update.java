package com.sdi.business.impl.classes.trips;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Trip;

public class Update {

	public void update(Trip trip) {
		Factories.persistence.newTripDao().update(trip);
		
	}

}
