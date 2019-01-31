package Models;
import java.util.*;

public class Loan {
    private Date borrowDate;
    private int borrowPeriod;
    private int conditionAfterLoan = 10; // between 1-10
    private double total = 0;
    private Customer customer;
    private HashSet<ItemCopy> copies;

    public Loan(int borrowPeriod, Customer customer) {
        this.borrowDate = new Date();
        this.borrowPeriod = borrowPeriod;
        this.customer = customer;
        this.copies = new HashSet<ItemCopy>();
    }

    public boolean addCopy(ItemCopy copy) {
        return this.copies.add(copy);
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public int getBorrowPeriod() {
        return borrowPeriod;
    }

    public void setBorrowPeriod(int borrowPeriod) {
        this.borrowPeriod = borrowPeriod;
    }

    public int getConditionAfterLoan() {
        return conditionAfterLoan;
    }

    public void setConditionAfterLoan(int conditionAfterLoan) {
        this.conditionAfterLoan = conditionAfterLoan;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Loan{" +
                "borrowDate=" + borrowDate +
                ", borrowPeriod=" + borrowPeriod +
                ", conditionAfterLoan=" + conditionAfterLoan +
                ", total=" + total +
                ", customer=" + customer +
                ", copies=" + copies +
                '}';
    }
}