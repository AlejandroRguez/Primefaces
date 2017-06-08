package com.sdi.business.impl.classes.trips;

import java.util.Date;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Trip;
import com.sdi.persistence.exception.NotPersistedException;

public class FindByPromoterAndArrivalDate {

	public Trip findByPromoterAndArrivalDate(Long id, Date arrivalDate) {
		try {
			return Factories.persistence.newTripDao().findByPromoterIdAndArrivalDate
					(id, arrivalDate);
		} catch (NotPersistedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
