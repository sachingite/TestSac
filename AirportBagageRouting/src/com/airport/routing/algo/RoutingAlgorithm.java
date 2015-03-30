package com.airport.routing.algo;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

/**
 * @author Sachin.Gite
 *
 * The interface of the Routing algorithm
 */
public interface RoutingAlgorithm {
	
	/**
	 * @param graph
	 * Initialize the algorithm with the Graph
	 */
	public void initAlog(Graph graph);
	
	/**
	 * Get the shortest path from node1 to node2 in bidirectional tree
	 * @param node1
	 * @param node2
	 * @return
	 */
	public RoutingResult getShortestPath(Node node1, Node node2);

}
