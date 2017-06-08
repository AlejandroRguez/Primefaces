package com.sdi.business.impl.classes.applications;

import com.sdi.infrastructure.Factories;
import com.sdi.persistence.ApplicationDao;

public class Delete {

	public void delete(Long idUser , Long idTrip){
		ApplicationDao dao = Factories.persistence.newApplicationDao();
			dao.delete(new Long[]{idUser,idTrip});
		
	}

}
