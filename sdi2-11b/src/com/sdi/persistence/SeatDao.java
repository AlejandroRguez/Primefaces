package com.sdi.persistence;

import java.util.List;

import com.sdi.model.Seat;
import com.sdi.persistence.exception.NotPersistedException;
import com.sdi.persistence.util.GenericDao;

public interface SeatDao extends GenericDao<Seat, Long[]> {

	Seat findByUserAndTrip(Long userId, Long tripId) throws NotPersistedException;
	List<Seat> findByTrip(Long tripId);

}
