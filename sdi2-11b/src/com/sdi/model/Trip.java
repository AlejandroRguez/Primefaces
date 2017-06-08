package com.sdi.model;

import java.util.Date;
import javax.xml.crypto.Data;

/**
 * This class is not an entity, it is a DTO with the same fields as a row in the
 * table
 * 
 * @see Data Transfer Object pattern
 * @author alb
 * 
 */
public class Trip {

	protected Long id;

	protected AddressPoint departure;
	protected AddressPoint destination;
	protected Date arrivalDate;
	protected Date departureDate;
	protected Date closingDate;
	protected Integer availablePax = 0;
	protected Integer maxPax = 0;
	protected Double estimatedCost = 0.0;
	protected String comments;
	protected TripStatus status;
	protected Long promoterId;

	public AddressPoint getDeparture() {
		return departure;
	}

	public void setDeparture(AddressPoint departure) {
		this.departure = departure;
	}

	public TripStatus getStatus() {
		return status;
	}

	public void setStatus(TripStatus status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AddressPoint getDestination() {
		return destination;
	}

	public void setDestination(AddressPoint destination) {
		this.destination = destination;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
		
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
		
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
		
	}

	public Integer getAvailablePax() {
		return availablePax;
	}

	public void setAvailablePax(Integer availablePax) {
		this.availablePax = availablePax;
	}

	public Integer getMaxPax() {
		return maxPax;
	}

	public void setMaxPax(Integer maxPax) {
		this.maxPax = maxPax;
	}

	public Double getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(Double estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Long getPromoterId() {
		return promoterId;
	}

	public void setPromoterId(Long promoterId) {
		this.promoterId = promoterId;
	}

	

	@Override
	public String toString() {
		return "Trip [id=" + id + ", departure=" + departure + ", destination="
				+ destination + ", arrivalDate=" + arrivalDate
				+ ", departureDate=" + departureDate + ", closingDate="
				+ closingDate + ", availablePax=" + availablePax + ", maxPax="
				+ maxPax + ", estimatedCost=" + estimatedCost + ", comments="
				+ comments + ", status=" + status + ", promoterId="
				+ promoterId + "]";
	}

}
