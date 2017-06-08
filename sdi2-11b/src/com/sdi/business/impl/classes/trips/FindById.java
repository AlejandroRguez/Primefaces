package com.sdi.business.impl.classes.trips;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Trip;

public class FindById {

	public Trip findById(Long id) {
		return Factories.persistence.newTripDao().findById(id);
	}

}
