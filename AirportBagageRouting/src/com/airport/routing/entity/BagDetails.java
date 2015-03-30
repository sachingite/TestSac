package com.airport.routing.entity;

/**
 * @author Sachin.Gite
 * The bag details. This is currently loaded from console or sample file
 */
public class BagDetails implements Comparable<BagDetails> {
	
	public BagDetails(String srNo, String sourceNode, String destinationPlatform) {
		this.srNo = srNo;
		this.sourceNode = sourceNode;
		this.destinationPlatform = destinationPlatform;
	}
	
	public BagDetails() {
		
	}
	
	private String srNo;
	
	private String sourceNode;
	
	private String destinationPlatform;

	public String getSrNo() {
		return srNo;
	}

	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}

	public String getSourceNode() {
		return sourceNode;
	}

	public void setSourceNode(String sourceNode) {
		this.sourceNode = sourceNode;
	}

	public String getDestinationPlatform() {
		return destinationPlatform;
	}

	public void setDestinationPlatform(String destinationPlatform) {
		this.destinationPlatform = destinationPlatform;
	}

	@Override
	public int compareTo(BagDetails o) {
		// TODO Auto-generated method stub
		return this.srNo.compareTo(o.srNo);
	}
	
}
