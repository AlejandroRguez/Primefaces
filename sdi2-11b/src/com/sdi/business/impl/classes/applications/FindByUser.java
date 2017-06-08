package com.sdi.business.impl.classes.applications;

import java.util.List;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Application;
import com.sdi.persistence.exception.AlreadyPersistedException;

public class FindByUser {

	public List<Application> findByUser(Long userId) {
		try {
			return Factories.persistence.newApplicationDao().findByUserId(userId);
		} catch (AlreadyPersistedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
