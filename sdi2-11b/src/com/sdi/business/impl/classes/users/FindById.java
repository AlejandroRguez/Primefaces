package com.sdi.business.impl.classes.users;

import com.sdi.infrastructure.Factories;
import com.sdi.model.User;

public class FindById {

	public User findById(Long id) {
		return Factories.persistence.newUserDao().findById(id);
	}

}
