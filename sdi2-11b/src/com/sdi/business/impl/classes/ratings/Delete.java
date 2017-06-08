package com.sdi.business.impl.classes.ratings;

import com.sdi.infrastructure.Factories;

public class Delete {

	public void delete(Long id) {
		Factories.persistence.newRatingDao().delete(id);
		
	}

}
