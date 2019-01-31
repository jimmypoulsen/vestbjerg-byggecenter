package Models;

import java.util.HashMap;


public class LoanContainer {
    public static LoanContainer instance = null;
    private HashMap<Integer, Loan> loans;
    
    private LoanContainer() {
        loans = new HashMap<>();
    }
    
    public static LoanContainer getInstance() {
        if(instance == null) {
            instance = new LoanContainer();
        }
        return instance;
    }
}
