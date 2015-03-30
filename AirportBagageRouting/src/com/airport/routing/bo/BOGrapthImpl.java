package com.airport.routing.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.DefaultGraph;

import com.airport.routing.algo.RoutingAlgorithm;
import com.airport.routing.algo.RoutingResult;
import com.airport.routing.entity.BagDetails;
import com.airport.routing.entity.ConveyorSystem;
import com.airport.routing.entity.DeparturesArrivals;

import static com.airport.routing.constants.AirportSystemConstants.PATH_WAIGHT_ATTRIBUTE;;

/**
 * @author Sachin.Gite
 *
 * Create the Graph and traverse the shortest distance
 */
public class BOGrapthImpl {
	
	private static BOGrapthImpl instance = new BOGrapthImpl();
	
	private BOGrapthImpl() {
		
	}
	
	public static BOGrapthImpl getInstance() {
		return instance;
	}
	
	/**
	 * Create the graph out of the Nodes and distance between them
	 * 
	 * @param listConveyorSystems Total Conveyor system nodes and there path and length
	 * @return
	 */
	public Graph createGraph(List<ConveyorSystem> listConveyorSystems) {
		Graph graph = new DefaultGraph("ConveyorSystems");
		
		// Traverse the Convener system to create the graph
		for (ConveyorSystem conveyorSystem : listConveyorSystems) {
			String source = conveyorSystem.getSourceNode();
			String destination = conveyorSystem.getDestNode();
			double pathlength = conveyorSystem.getPathLength();
			
			Node node1 = graph.getNode(source) == null ? graph.addNode(source) : graph.getNode(source);
			Node node2 = graph.getNode(destination) == null ? graph.addNode(destination) : graph.getNode(destination);
			
			Edge edge = graph.addEdge(source+destination, node1, node2);
			edge.setAttribute(PATH_WAIGHT_ATTRIBUTE, pathlength);
		}
		
		return graph;
	}
	
	/**
	 * This method returns the Shortest path for all the bags inputed
	 * 
	 * @param algorithm Instance of the Routing Algorithm type
	 * @param graph The populated graph
	 * @param bagDetails The Bag details to be routed
	 * @param platforms The Platform details
	 * @return List of Routing results to caller
	 */
	public List<RoutingResult> getBagRoutingResults(RoutingAlgorithm algorithm, Graph graph, Set<BagDetails> bagDetails, Map<String, DeparturesArrivals> platforms) {
		
		List<RoutingResult> routingResults = new ArrayList<RoutingResult>();
		algorithm.initAlog(graph);
		
		for (BagDetails bagDetail : bagDetails) {
			String node1 = bagDetail.getSourceNode();
			String node2 = platforms.get(bagDetail.getDestinationPlatform()) != null ? platforms.get(bagDetail.getDestinationPlatform()).getNode() : null;
			
			if (node1 != null && node2 != null) {
				RoutingResult routingResult = algorithm.getShortestPath(graph.getNode(node1), graph.getNode(node2));
				routingResult.setBagNumber(bagDetail.getSrNo());
				routingResults.add(routingResult);
			}
		}
		
		return routingResults;
	}
	
	

}
