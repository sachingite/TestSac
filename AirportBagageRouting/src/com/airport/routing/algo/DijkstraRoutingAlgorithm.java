package com.airport.routing.algo;

import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;

import static com.airport.routing.constants.AirportSystemConstants.PATH_WAIGHT_ATTRIBUTE;

/**
 * @author Sachin.Gite
 * 
 * Initialize the Dijkstra and use it to calculate the shortest path between two nodes
 */
public class DijkstraRoutingAlgorithm implements RoutingAlgorithm {
	
	Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, null, PATH_WAIGHT_ATTRIBUTE);

	@Override
	public void initAlog(Graph graph) {
		dijkstra.init(graph);
	}

	@Override
	public RoutingResult getShortestPath(Node node1, Node node2) {
		dijkstra.setSource(node1);
		dijkstra.compute();
		
		Path path = dijkstra.getPath(node2);
		RoutingResult result = new RoutingResult();
		result.setPath(path.getNodePath());
		result.setPathLength(path.getPathWeight(PATH_WAIGHT_ATTRIBUTE));
		
		return result;
	}

}
