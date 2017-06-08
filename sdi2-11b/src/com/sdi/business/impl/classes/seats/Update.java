package com.sdi.business.impl.classes.seats;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Seat;

public class Update {

	public void update(Seat seat) {
		Factories.persistence.newSeatDao().update(seat);
		
	}

}
