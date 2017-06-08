package com.sdi.business.impl.classes.applications;

import java.util.List;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Application;
import com.sdi.persistence.exception.AlreadyPersistedException;

public class FindByTrip {

	public List<Application> findByTrip(Long tripId) {
		try {
			return Factories.persistence.newApplicationDao().findByTripId(tripId);
		} catch (AlreadyPersistedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
