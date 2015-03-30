package com.airport.routing.algo;

import org.graphstream.algorithm.APSP;
import org.graphstream.algorithm.APSP.APSPInfo;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;

import static com.airport.routing.constants.AirportSystemConstants.PATH_WAIGHT_ATTRIBUTE;


/**
 * @author Sachin.Gite
 * 
 * APSP (All Path Shortest Path Algorithm)
 */
public class APSPRoutingAlgorithm implements RoutingAlgorithm {
	APSP apsp = new APSP();

	@Override
	public void initAlog(Graph graph) {
		APSP apsp = new APSP();
		apsp.init(graph);
		apsp.setDirected(false);
		apsp.setWeightAttributeName(PATH_WAIGHT_ATTRIBUTE);
		apsp.compute();
	}

	@Override
	public RoutingResult getShortestPath(Node node1, Node node2) {
		APSPInfo info = node1.getAttribute(APSPInfo.ATTRIBUTE_NAME);
		Path path = info.getShortestPathTo(node2.getId());
		
		RoutingResult result = new RoutingResult();
		result.setPathLength(path.getPathWeight(PATH_WAIGHT_ATTRIBUTE));
		result.setPath(path.getNodePath());
		
		return result;
	}

}
