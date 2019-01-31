package Models;

import java.util.HashSet;
import java.util.Iterator;

public class LocationContainer
{
    private static LocationContainer instance = null;
    private HashSet<Location> locations;
    
    private LocationContainer() {
        locations = new HashSet<>();
    }
    
    public static LocationContainer getInstance() {
        if(instance == null) {
            instance = new LocationContainer();
        }
        return instance;
    }
    
    public Location addLocation(Location l) {
        locations.add(l);
        return l;
    }
    
    public Location findFirstLocation() {
    	Iterator<Location> lIterator = locations.iterator();
    	return lIterator.next();
    }
}
