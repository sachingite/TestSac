package com.airport.routing.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.graphstream.graph.Graph;

import com.airport.routing.algo.RoutingAlgorithm;
import com.airport.routing.algo.RoutingResult;
import com.airport.routing.bo.BOGrapthImpl;
import com.airport.routing.entity.BagDetails;
import com.airport.routing.entity.ConveyorSystem;
import com.airport.routing.entity.DeparturesArrivals;
import com.airport.routing.factory.RoutingAlgorithmFactory;
import com.airport.routing.population.AirportEntityLoader;
import com.airport.routing.population.FileUtil;

/**
 * @author Sachin.Gite
 * 
 * The main program taking the input from file or Command prompt
 */
public class AirportRoutingExecutor {

	public static void main(String[] args) throws IOException {
		
		AirportEntityLoader entityLoader = AirportEntityLoader.getInstance();
		boolean inputFromfile;
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			
			while (true) {
				System.out.println("Please select input source \n 1 : Smaple File \n 2 : Command Line \n 3 : Exit ");
				String line = reader.readLine();
				if (line.equals("1")) {
					inputFromfile = true;
					boolean validFile = FileUtil.getInstance().parse("textInput.txt");
					if (!validFile) {
						System.out.println("The Input file is not valid or has insufficient data");
						return;						
					}
					break;
				} else if (line.equals("2")) {
					inputFromfile = false;
					break;
					
				} else if (line.equals("3")) {
					System.out.println("Existing as per request");
					return;  /// Stop the mail program
				}
			}
			
			List<ConveyorSystem> nodes = entityLoader.loadConveyorSystems(inputFromfile);
			Map<String, DeparturesArrivals> platforms = entityLoader.loadDeparturesArrivals(inputFromfile);
			Set<BagDetails> bags = entityLoader.loadBagdetails(inputFromfile);
			
			Graph graph = BOGrapthImpl.getInstance().createGraph(nodes);
			
			RoutingAlgorithmFactory factory = RoutingAlgorithmFactory.getInstance();
			
			System.out.println("Please select Shortest Path algorithm \n 1 : Dijkstra \n 2 : APSP (All Shortest Path)");
			String line = reader.readLine();
			if (!line.equals("1") && !line.equals("2")) {
				System.out.println("Invalid Algorithm Input. Exiting...");
				return;
			}
			
			RoutingAlgorithm algo = factory.getRoutingAlgorithm(line);
			
			List<RoutingResult> results = BOGrapthImpl.getInstance().getBagRoutingResults(algo, graph, bags, platforms);
			
			System.out.println("The Bagage Routing Details");
			for (RoutingResult routingResult : results) {
				System.out.println(routingResult);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (reader != null)
				reader.close();
		}
		
	}

}
