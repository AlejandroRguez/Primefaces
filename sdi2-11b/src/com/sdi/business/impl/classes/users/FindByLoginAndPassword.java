package com.sdi.business.impl.classes.users;

import com.sdi.infrastructure.Factories;
import com.sdi.model.User;

public class FindByLoginAndPassword {

	public User findByLoginAndPassword(String login, String password) {
		return Factories.persistence.newUserDao().findByLoginAndPassword
				(login, password);
	}

}
