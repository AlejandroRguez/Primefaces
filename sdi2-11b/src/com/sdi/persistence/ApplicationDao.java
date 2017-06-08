package com.sdi.persistence;

import java.util.List;

import com.sdi.model.Application;
import com.sdi.persistence.exception.AlreadyPersistedException;
import com.sdi.persistence.util.GenericDao;

public interface ApplicationDao extends GenericDao<Application, Long[]> {
	
	
	List<Application> findByUserId( Long userId ) throws AlreadyPersistedException;
	List<Application> findByTripId( Long tripId ) throws AlreadyPersistedException;
	
}
