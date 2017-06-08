package com.sdi.business.impl.classes.ratings;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Rating;

public class FindById {

	public Rating findById(Long id) {
		return Factories.persistence.newRatingDao().findById(id);
	}

}
