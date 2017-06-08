package com.sdi.business.impl.classes.seats;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Seat;

public class Save {

	public void save(Seat seat) {
		Factories.persistence.newSeatDao().save(seat);
		
	}

}
