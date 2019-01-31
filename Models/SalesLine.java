package Models;


public class SalesLine {
    private int quantity;
    private double subtotal;
    private Item item;
    
    public SalesLine(Item item, int quantity) {
        this.quantity = quantity;
        this.subtotal = item.getPrice() * quantity;
        this.item = item;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    public double getSubtotal() {
        return item.getPrice() * quantity;
    }
    
    public Item getItem() {
    	return item;
    }
    
    public void setItem(Item item) {
    	this.item = item;
    }
}
