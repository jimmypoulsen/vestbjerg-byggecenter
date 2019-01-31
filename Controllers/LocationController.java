package Controllers;

import Models.*;

public class LocationController {
    public Location createLocation(String department, int shelfNo, Branch b) {
        Location l = new Location(department, shelfNo, b);
        return LocationContainer.getInstance().addLocation(l);
    }
    
    public Location getFirstLocation() {
    	return LocationContainer.getInstance().findFirstLocation();
    }
}
