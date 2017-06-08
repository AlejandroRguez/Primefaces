package com.sdi.business.impl.classes.ratings;

import java.util.List;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Rating;

public class GetRatings {

	public List<Rating> getAll() {
		return Factories.persistence.newRatingDao().findAll();
	}

}
