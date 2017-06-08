package com.sdi.business.impl.classes.trips;

import com.sdi.infrastructure.Factories;

public class Delete {

	public void delete(Long id) {
		Factories.persistence.newTripDao().delete(id);
		
	}

}
