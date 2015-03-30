package com.airport.routing.population;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.airport.routing.entity.BagDetails;
import com.airport.routing.entity.ConveyorSystem;
import com.airport.routing.entity.DeparturesArrivals;

/**
 * @author Sachin.Gite
 *
 * The class to load the Entities for which we will find the shortest paths
 * 
 */
public class AirportEntityLoader {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static AirportEntityLoader instance = new AirportEntityLoader();
	
	private AirportEntityLoader() {
		
	}
	
	public static AirportEntityLoader getInstance() {
		return instance;
	}
	
	
	public Set<BagDetails> loadBagdetails(boolean loadFromFile) throws IOException  {
		Set<BagDetails> bags = new TreeSet<BagDetails>();
		
		if (loadFromFile) {
			// Load from pre-parsed File
			bags = FileUtil.getInstance().getBagDetails();
		} else {
			System.out.println("Please enter the bag details (1 to Exit): <Bag Details> <Entry Point> <Flight Id> ");
			String bagDetails = null;
			while (!(bagDetails = br.readLine()).equals("1")) {
				String[] bagDetailTokens = bagDetails.split(" ");
				if (bagDetailTokens != null && bagDetailTokens.length >= 3) {
					BagDetails bagDetails2 = new BagDetails(bagDetailTokens[0], bagDetailTokens[1], bagDetailTokens[2]);
					bags.add(bagDetails2);
				} else {
					System.out.println("The Bag Details are not valid.");
				}
			}
		}
		return bags;
	}
	
	public List<ConveyorSystem> loadConveyorSystems(boolean loadFromFile) throws IOException  {
		List<ConveyorSystem> nodeDetails = new ArrayList<ConveyorSystem>();
		
		if (loadFromFile) {
			// Load from pre-parsed File
			nodeDetails = FileUtil.getInstance().getConveyorSystems();
		} else {
			System.out.println("Please enter the Conveyor System details (1 to Exit): <Node 1> <Node 2> <Travel Time> ");
			String conveyorSystem = null;
			while (!(conveyorSystem = br.readLine()).equals("1")) {
				String[] conveyorSystemTokens = conveyorSystem.split(" ");
				if (conveyorSystemTokens != null && conveyorSystemTokens.length >= 3) {
					ConveyorSystem conveyorSystem2 = new ConveyorSystem(conveyorSystemTokens[0], conveyorSystemTokens[1], conveyorSystemTokens[2]);
					nodeDetails.add(conveyorSystem2);
				} else {
					System.out.println("The Conveyor System details are not valid.");
				}
			}
		}
		return nodeDetails;
	}
	
	public Map<String,DeparturesArrivals> loadDeparturesArrivals(boolean loadFromFile) throws IOException  {
		
		
		Map<String,DeparturesArrivals> platforms = new HashMap<String,DeparturesArrivals>();
		
		if (loadFromFile) {
			// Load from pre-parsed File
			platforms = FileUtil.getInstance().getPlatforms();
		} else {
			System.out.println("Please enter the Departures Arrival Details details (1 to Exit): <flight_id> <flight_gate> <destination> <flight_time> ");
			String departuresArrivals = null;
			while (!(departuresArrivals = br.readLine()).equals("1")) {
				String[] departuresArrivalsTokens = departuresArrivals.split(" ");
				if (departuresArrivalsTokens != null && departuresArrivalsTokens.length >= 4) {
					DeparturesArrivals departuresArrivals2 = new DeparturesArrivals(departuresArrivalsTokens[0], departuresArrivalsTokens[1], departuresArrivalsTokens[2], departuresArrivalsTokens[3]);
					platforms.put(departuresArrivalsTokens[0],departuresArrivals2);
				} else {
					System.out.println("The Departures Arrival Details are not valid.");
				}
			}
		}
		return platforms;
	}


	@Override
	protected void finalize() throws Throwable {
		br.close();
		super.finalize();
	}
	
	
}
