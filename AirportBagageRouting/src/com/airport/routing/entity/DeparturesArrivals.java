package com.airport.routing.entity;

/**
 * @author Sachin.Gite
 *
 * The departure points in the airport. This is currently loaded from console or sample file
 */
public class DeparturesArrivals {
	
	
	public DeparturesArrivals(String name, String node, String destinationAirport, String departureTime) {
		this.name = name;
		this.node = node;
		this.destinationAirport = destinationAirport;
		this.departueTime = departureTime;
	}
	
	public DeparturesArrivals() {
		
	}
	
	private String name;
	
	private String node;
	
	private String destinationAirport;
	
	private String departueTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public String getDepartueTime() {
		return departueTime;
	}

	public void setDepartueTime(String departueTime) {
		this.departueTime = departueTime;
	}
	
}
