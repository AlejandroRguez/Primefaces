package com.sdi.business.impl.classes.ratings;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Rating;

public class Save {

	public void save(Rating rating) {
		Factories.persistence.newRatingDao().save(rating);
		
	}

}
