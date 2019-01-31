package Controllers;

import Models.*;
import Controllers.*;
import java.util.*;

public class SaleController {
	public Sale newSale() {
		SessionsController sessionsCtrl = new SessionsController();
		Sale sale = SaleContainer.getInstance().newSale(sessionsCtrl.getCurrentLoggedInEmployee());
		sale.setSalesId(SaleContainer.getInstance().getLastOrderId() + 1);
		return sale;
	}
	
	public Sale createSale(Sale sale, PaymentType pt) {
		sale.setState(OrderState.COMPLETED);
		SaleContainer.getInstance().createSale(sale, pt);
		return sale;
	}
	
	public HashMap<Integer, Sale> getSales() {
        return SaleContainer.getInstance().findAllSales();
    }
}
