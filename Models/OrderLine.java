package Models;

public class OrderLine {
    private Item item;
    private int quantity;
    private double subtotal;

    public OrderLine(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.subtotal = item.getPrice() * quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return item.getPrice() * quantity;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "OrderLine{" +
                "item=" + item +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                '}';
    }
}