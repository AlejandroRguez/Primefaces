package com.sdi.business;

public interface ServicesFactory {
		
	SeatService createSeatsService();
	
	ApplicationService createApplicationsService();
	
	UserService createUsersService();
	
	TripService createTripsService();

}
