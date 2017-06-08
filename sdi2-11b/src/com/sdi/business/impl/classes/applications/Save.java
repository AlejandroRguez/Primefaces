package com.sdi.business.impl.classes.applications;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Application;

public class Save {

	public void save(Application application) {
		Factories.persistence.newApplicationDao().save(application);
	}

}
