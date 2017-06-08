package com.sdi.business.impl.classes.seats;

import com.sdi.infrastructure.Factories;

public class Delete {

	public void delete(Long idUser , Long idTrip) {
		Factories.persistence.newSeatDao().delete(new Long[]{idUser, idTrip});
		
	}

}
