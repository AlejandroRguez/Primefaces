package com.sdi.business.impl.classes.trips;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Trip;

public class Save {

	public void save(Trip trip) {
		//try{
		Factories.persistence.newTripDao().save(trip);
		//}catch(PersistenceException e){
			
		//}
		
	}

}
