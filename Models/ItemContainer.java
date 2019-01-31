package Models;
import java.util.ArrayList;

public class ItemContainer {
    private static ItemContainer instance = null;
    private ArrayList<Item> items;

    public ItemContainer() {
        items = new ArrayList<>();
    }

    public static ItemContainer getInstance() {
        if(instance == null) {
            instance = new ItemContainer();
        }
        return instance;
    }
    
    public Item addItem(Item i) {
        items.add(i);
        return i;
    }
    
    public boolean updateItem(Item i) {
    	// find and remove item in list
    	int itemToBeRemoved = findItemIndex(i.getBarcode());
    	items.remove(itemToBeRemoved);
    	
    	// add the updated item
    	return items.add(i);
    }
    
    public Item findItem(String barcode) {
        Item current = null;
        Item res = null;
        int index = 0;
        boolean found = false;
        int size = items.size();
        while (index < size && !found) {
            current = items.get(index);
            if(current.getBarcode().equals(barcode)) {
                found = true;
            } else {
                index++;
            }
        }
        if (found) {
            res = items.get(index);
        }
        return res;
    }
    
    public int findItemIndex(String barcode) {
        Item current = null;
        int res = 0;
        int index = 0;
        boolean found = false;
        int size = items.size();
        while (index < size && !found) {
            current = items.get(index);
            if(current.getBarcode().equals(barcode)) {
                found = true;
            } else {
                index++;
            }
        }
        if (found) {
            res = index;
        }
        return res;
    }
    
    public Item findItemByName(String name) {
    	Item current = null;
    	Item res = null;
    	int index = 0;
    	boolean found = false;
    	int size = items.size();
    	while(index < size && !found) {
    		current = items.get(index);
    		if(current.getName().equals(name)) {
    			found = true;
    		} else {
    			index++;
    		}
    	}
    	if(found)
    		res = items.get(index);
    	return res;
    }
    
    public ArrayList<Item> findAllItems() {
    	return new ArrayList<Item>(items);
    }
}