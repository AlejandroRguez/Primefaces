package com.sdi.business.impl.classes.users;

import com.sdi.infrastructure.Factories;
import com.sdi.model.User;

public class Update {

	public void update(User user) {
		Factories.persistence.newUserDao().update(user);
		
	}

}
