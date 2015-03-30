package com.airport.routing.algo;

import java.util.List;

import org.graphstream.graph.Node;

/**
 * @author Sachin.Gite
 *
 * The result of the Shortest  path from node1 to node2 and the bag number
 */
public class RoutingResult {
	
	private double pathLength;
	
	private String bagNumber;
	
	private List<Node> path;

	public double getPathLength() {
		return pathLength;
	}

	public void setPathLength(double pathLength) {
		this.pathLength = pathLength;
	}

	public List<Node> getPath() {
		return path;
	}

	public void setPath(List<Node> path) {
		this.path = path;
	}

	public String getBagNumber() {
		return bagNumber;
	}

	public void setBagNumber(String bagNumber) {
		this.bagNumber = bagNumber;
	}
	
	@Override
	public String toString() {
		return getBagNumber() + " " + getPath() + "  : " + getPathLength();
	}
	
}
