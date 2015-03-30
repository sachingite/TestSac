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
 * The file util to read the file and Populate the airport Entities
 */
public class FileUtil {
	
	private List<ConveyorSystem> conveyorSystem = new ArrayList<ConveyorSystem>();
	private Set<BagDetails> bagageDetails = new TreeSet<BagDetails>();
	private Map<String, DeparturesArrivals> plaforms = new HashMap<String,DeparturesArrivals>();
	private static Map<String, EntityCommand> map;
	static {
		map = new HashMap<String, EntityCommand>();
	}
	private static FileUtil instance = new FileUtil();
	
	private FileUtil() {
		map.put("#Section: Conveyor System", new ConveyorSystemCommand());
		map.put("#Section: Departures", new PlatformCommand());
		map.put("#Section: Bags", new BagageDetailCommand());
	}

	public static FileUtil getInstance() {
		return instance;
	}
	
	public boolean parse(String fileName) throws IOException {
		boolean validInput = true;
		
		//Define the Command to Read the next line
		EntityCommand command = null;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader()
                                .getResourceAsStream(fileName)));
		String line;
		
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
			if (line.startsWith("#")) {
				command = map.get(line);
			} else {
				if (command != null) {
					command.execute(line);
				}
			}
		}
		if (conveyorSystem.size() == 0 || bagageDetails.size() == 0 || plaforms.size() == 0) {
			validInput = false;
		}
		
		return validInput; 
	}
	
	public List<ConveyorSystem> getConveyorSystems() {
		return conveyorSystem;
	}
	
	public Set<BagDetails> getBagDetails() {
		return bagageDetails;
	}
	
	public Map<String, DeparturesArrivals> getPlatforms() {
		return plaforms;
	}
	
	interface EntityCommand {
		public void execute(String line);
	}
	
	class ConveyorSystemCommand implements EntityCommand {

		@Override
		public void execute(String line) {
			String[] conveyorSystemTokens = line.split(" ");
			if (conveyorSystemTokens != null && conveyorSystemTokens.length >= 3) {
				ConveyorSystem conveyorSystem2 = new ConveyorSystem(conveyorSystemTokens[0], conveyorSystemTokens[1], conveyorSystemTokens[2]);
				conveyorSystem.add(conveyorSystem2);
			} else {
				System.out.println("The Conveyor System details are not valid.");
			}
		}
		
	}
	
	class BagageDetailCommand implements EntityCommand {

		@Override
		public void execute(String line) {
			String[] bagDetailTokens = line.split(" ");
			if (bagDetailTokens != null && bagDetailTokens.length >= 3) {
				BagDetails bagDetails2 = new BagDetails(bagDetailTokens[0], bagDetailTokens[1], bagDetailTokens[2]);
				bagageDetails.add(bagDetails2);
			} else {
				System.out.println("The Bag Details are not valid.");
			}
		}
		
	}
	
	class PlatformCommand implements EntityCommand {

		@Override
		public void execute(String line) {
			String[] departuresArrivalsTokens = line.split(" ");
			if (departuresArrivalsTokens != null && departuresArrivalsTokens.length >= 4) {
				DeparturesArrivals departuresArrivals2 = new DeparturesArrivals(departuresArrivalsTokens[0], departuresArrivalsTokens[1], departuresArrivalsTokens[2], departuresArrivalsTokens[3]);
				plaforms.put(departuresArrivalsTokens[0],departuresArrivals2);
			} else {
				System.out.println("The Departures Arrival Details are not valid.");
			}
		}
		
	}
}
