package Models;
import java.util.HashSet;

public class Item {
    private String barcode;
    private String name;
    private String description;
    private double price;
    private double offerPrice;
    private int stock;
    private int minStock;
    private int maxStock;
    private int kolli;
    private boolean lendable;
    private HashSet<ItemCopy> itemCopies;
    private Location location;
    
    public Item(String barcode, String name, String description, double price, int stock, int minStock, int maxStock, int kolli, boolean lendable) {
        this.barcode = barcode;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.minStock = minStock;
        this.maxStock = maxStock;
        this.kolli = kolli;
        this.lendable = lendable;
        this.itemCopies = new HashSet<ItemCopy>();
        this.location = location;
    }
    
    public Item(Location l) {
        this.location = l;
    }
    
    public boolean addItemCopy(ItemCopy itemCopy) {
        return this.itemCopies.add(itemCopy);
    }
    
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    
    public String getBarcode() {
        return barcode;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    } 
    
    public String getDescription() {
        return description;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setOfferPrice(double offerPrice) {
        this.offerPrice = offerPrice;
    }
    
    public double getOfferPrice() {
        return offerPrice;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public int getStock() {
        return stock;
    }
    
    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }
    
    public int getMinStock() {
        return minStock;
    }
    
    public void setMaxStock(int maxStock) {
        this.maxStock = maxStock;
    }
    
    public int getMaxStock() {
        return maxStock;
    }
    
    public void setKolli(int kolli) {
        this.kolli = kolli;
    }
    
    public int getKolli() {
        return kolli;
    }
    
    public void setLendable(boolean lendable) {
        this.lendable = lendable;
    }
    
    public boolean getLendable() {
        return lendable;
    }
}
