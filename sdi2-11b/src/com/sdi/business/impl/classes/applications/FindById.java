package com.sdi.business.impl.classes.applications;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Application;

public class FindById {

	public Application findById(Long userId, Long tripId) {
		return Factories.persistence.newApplicationDao().findById
				(new Long[]{userId, tripId});
	}

}
