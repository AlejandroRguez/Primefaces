package com.sdi.business.impl;

import java.util.List;

import com.sdi.business.SeatService;
import com.sdi.business.impl.classes.seats.Delete;
import com.sdi.business.impl.classes.seats.FindByTrip;
import com.sdi.business.impl.classes.seats.FindByUserAndTrip;
import com.sdi.business.impl.classes.seats.GetSeats;
import com.sdi.business.impl.classes.seats.Save;
import com.sdi.business.impl.classes.seats.Update;
import com.sdi.model.Seat;
import com.sdi.persistence.exception.AlreadyPersistedException;
import com.sdi.persistence.exception.NotPersistedException;

public class SimpleSeatService implements SeatService {

	@Override
	public void saveSeat(Seat seat) throws AlreadyPersistedException {
		new Save().save(seat);
		
	}

	@Override
	public void deleteSeat(Long idUser, Long idTrip) throws NotPersistedException {
		new Delete().delete(idUser, idTrip);
		
	}

	@Override
	public Seat findByUserAndTrip(Long userId, Long tripId) {
		return new FindByUserAndTrip().findByUserAndTrip(userId, tripId);
		
	}
	
	@Override
	public List<Seat> findByTrip(Long tripId) {
		return new FindByTrip().findByTrip(tripId);
		
	}

	@Override
	public void updateSeat(Seat seat) throws NotPersistedException {
		new Update().update(seat);
		
	}

	@Override
	public List<Seat> getSeats() {
		return new GetSeats().getAll();
	}

	

}
