package com.airport.routing.factory;

import com.airport.routing.algo.APSPRoutingAlgorithm;
import com.airport.routing.algo.DijkstraRoutingAlgorithm;
import com.airport.routing.algo.RoutingAlgorithm;

/**
 * @author Sachin.Gite
 *
 * Factory to get the Algorithm type
 */
public class RoutingAlgorithmFactory {
	private static RoutingAlgorithmFactory instance = new RoutingAlgorithmFactory();
	
	private RoutingAlgorithmFactory() {
		
	}
	
	public static RoutingAlgorithmFactory getInstance() {
		return instance;
	}
	
	public RoutingAlgorithm getRoutingAlgorithm(String algoNumber) {
		RoutingAlgorithm routingAlgorithm = null;
		if ("1".equals(algoNumber)) {
			routingAlgorithm = new DijkstraRoutingAlgorithm();
		} else if ("2".equals(algoNumber)) {
			routingAlgorithm = new APSPRoutingAlgorithm();
		}
		
		return routingAlgorithm;
	}

}
