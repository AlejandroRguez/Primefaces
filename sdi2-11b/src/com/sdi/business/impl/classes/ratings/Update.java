package com.sdi.business.impl.classes.ratings;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Rating;

public class Update {

	public void update(Rating rating) {
		Factories.persistence.newRatingDao().update(rating);
		
	}

}
