package com.airport.routing.entity;

/**
 * @author Sachin.Gite
 *
 * Conveyor system Entity which stores the details of the paths between the nodes
 * This will be populated with the node and paths
 * 
 */
public class ConveyorSystem {
	
	public ConveyorSystem(String sourceNode, String destNode, String pathLength) {
		this.sourceNode = sourceNode;
		this.destNode = destNode;
		this.pathLength = Double.parseDouble(pathLength);
	}
	
	public ConveyorSystem() {
		
	}
	
	private String sourceNode;
	
	private String destNode;
	
	private double pathLength;

	public String getSourceNode() {
		return sourceNode;
	}

	public void setSourceNode(String sourceNode) {
		this.sourceNode = sourceNode;
	}

	public String getDestNode() {
		return destNode;
	}

	public void setDestNode(String destNode) {
		this.destNode = destNode;
	}

	public double getPathLength() {
		return pathLength;
	}

	public void setPathLength(double pathLength) {
		this.pathLength = pathLength;
	}
}
