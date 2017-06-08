package com.sdi.business.impl.classes.users;

import com.sdi.infrastructure.Factories;
import com.sdi.model.User;

public class Save {

	public void save(User user) {
		Factories.persistence.newUserDao().save(user);
		
	}

}
