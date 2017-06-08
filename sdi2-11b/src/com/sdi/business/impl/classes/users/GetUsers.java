package com.sdi.business.impl.classes.users;

import java.util.List;

import com.sdi.infrastructure.Factories;
import com.sdi.model.User;

public class GetUsers {

	public List<User> getAll() {
		return Factories.persistence.newUserDao().findAll();
	}

}
