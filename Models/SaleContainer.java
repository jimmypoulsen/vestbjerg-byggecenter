package Models;
import java.util.HashMap;
import java.util.Iterator;

public class SaleContainer {
    private static SaleContainer instance = null;
    private HashMap<Integer, Sale> sales;

    private SaleContainer() {
        sales = new HashMap<>();
    }

    public static SaleContainer getInstance() {
        if(instance == null) {
            instance = new SaleContainer();
        }
        return instance;
    }
    
    public Sale newSale(Employee e) {
    	return new Sale(e);
    }
    
    public Sale createSale(Sale sale, PaymentType pt) {
    	sale.setPaymentType(pt);
    	double total = 0;
    	Iterator<SalesLine> sLines = sale.getSalesLines().iterator();
    	while(sLines.hasNext()) {
    		SalesLine curr = sLines.next();
    		total += curr.getSubtotal();
    	}
    	sale.setTotal(total);
    	sales.put(sale.getSalesId(), sale);
    	return sale;
    }
    
    public HashMap<Integer, Sale> findAllSales() {
        return sales;
    }
    
    public int getLastOrderId() {
        int res = 0;
        Sale s;
        if (!sales.isEmpty()) {
            s = sales.get(sales.size());
            res = s.getSalesId();
        }
        return res;
    }
}