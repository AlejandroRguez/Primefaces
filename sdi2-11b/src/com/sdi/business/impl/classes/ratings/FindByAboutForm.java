package com.sdi.business.impl.classes.ratings;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Rating;
import com.sdi.persistence.exception.NotPersistedException;

public class FindByAboutForm {

	public Rating findByAboutForm(Long aboutUserId, Long aboutTripId,
			Long fromUserId, Long fromTripId) {
		try {
			return Factories.persistence.newRatingDao().findByAboutFrom
			(aboutUserId, aboutTripId, fromUserId, fromTripId);
		} catch (NotPersistedException e) {
			e.printStackTrace();
			return null;
		}
	}

}
