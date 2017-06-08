package com.sdi.business.impl.classes.trips;

import java.util.List;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Trip;

public class GetTrips {

	public List<Trip> getAll() {
		return Factories.persistence.newTripDao().findAll();
	}

}
