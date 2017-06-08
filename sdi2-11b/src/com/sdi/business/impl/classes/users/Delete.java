package com.sdi.business.impl.classes.users;

import com.sdi.infrastructure.Factories;

public class Delete {

	public void delete(Long id) {
		Factories.persistence.newUserDao().delete(id);
		
	}

}
