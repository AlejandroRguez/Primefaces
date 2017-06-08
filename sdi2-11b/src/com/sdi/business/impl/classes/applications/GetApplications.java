package com.sdi.business.impl.classes.applications;

import java.util.List;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Application;

public class GetApplications {

	public List<Application> getAll() {
		return Factories.persistence.newApplicationDao().findAll();
	}

}
