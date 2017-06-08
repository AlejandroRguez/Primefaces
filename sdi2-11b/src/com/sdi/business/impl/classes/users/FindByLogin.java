package com.sdi.business.impl.classes.users;

import com.sdi.infrastructure.Factories;
import com.sdi.model.User;

public class FindByLogin {

	public User findByLogin(String login) {
		return Factories.persistence.newUserDao().findByLogin(login);
	}

}
