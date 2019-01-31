package TUI;

import Controllers.*;
import Models.*;
import java.util.HashMap;

public class MainMenuUI {
    
    public static void main(String args[]) {
        new MainMenuUI().start();
    }
    
    private void start() {
        SessionsController sCtrl = new SessionsController();
        testMe();
        while(sCtrl.getCurrentLoggedInEmployee() == null) {
            performLogin();
        }
        printMenu();
        boolean run = true;
        while(run) {
            String command = Helper.readInput("What is your command?");
            switch(command.toLowerCase()) {
                case "exit":
                case "quit":
                case "q":
                    run = false;
                    break;
                case "all customers":
                    allCustomers();
                    break;
                case "all orders":
                    allOrders();
                    break;
                case "create order":
                    createOrder();
                    break;
                default:
                    System.out.println("Command not recognized ... Try again!");
                    break;
            }
        }
    }

    private void performLogin() {
        SessionsController sCtrl = new SessionsController();
        int employeeNo = Helper.readInt("Enter your employee no.");
        String password = Helper.readInput("Enter your password");
        if(sCtrl.loginEmployee(employeeNo, password))
            System.out.println(sCtrl.getCurrentLoggedInEmployee().getFirstName() + " was logged in!");
        else
            System.out.println("Wrong employee no / password. Try again!");
    }
    
    private void createOrder() {
        CustomerController cCtrl = new CustomerController();
        OrderController oCtrl = new OrderController();
        ItemController iCtrl = new ItemController();
        int customerNo = Helper.readInt("Enter customer number");
        System.out.println("Customer selected:\n" + cCtrl.getCustomer(customerNo).getFirstName());
        
        Order o = oCtrl.newOrder(cCtrl.getCustomer(customerNo));
        
        boolean run = true;
        while(run) {
            System.out.println("Start adding items");
            System.out.println("Type :done when you er done, or :cancel to cancel");
            
            String barcode = Helper.readInput("Enter barcode");
            switch(barcode.toLowerCase()) {
                case ":done":
                    run = false;

                    System.out.println("Done! " + o.getOrderLines().size() + " different items was added.");
                    System.out.println("How will the customer pay?");
                    System.out.println("Options: 'cash', 'creditcard', 'invoice'");
                    String paymentType = Helper.readInput("Enter payment type");
                    oCtrl.createOrder(o, PaymentType.valueOf(paymentType.toUpperCase()));
                    System.out.println(o);
                    break;
                case ":cancel":
                    run = false;
                    System.out.println("Order cancelled... No order was created.");
                    break;
                default:
                    try {
                        Item i = iCtrl.getItem(barcode);
                        System.out.println("Item found: " + i.getName() + ": " + i.getPrice());
                        int quantity = Helper.readInt("Enter quantity");
                        o = oCtrl.createOrderLine(o, i, quantity);
                        System.out.println("Item added!");
                    } catch(NullPointerException e) {
                        System.out.println("Item could not be found!");
                    }
                    break;
            }    
            if(barcode.equals("quit") || barcode.equals("q") || barcode.equals("exit"))
                run = false;
        }
    }

    private void allCustomers() {
        CustomerController cCtrl = new CustomerController();
        HashMap<Integer, Customer> customers = new HashMap<Integer, Customer>(cCtrl.getCustomers());
        System.out.println(customers.size() + " was found");
        for(Customer c : customers.values()) {
            System.out.println(c);
        }
    }
    
    private void allOrders() {
        OrderController oCtrl = new OrderController();
        HashMap<Integer, Order> orders = new HashMap<Integer, Order>(oCtrl.getOrders());
        System.out.println(orders.size() + " was found");
        for(Order o : orders.values()) {
            System.out.println(o);
        }
    }
    
    private void printMenu() {
        System.out.println("You have these options:");
        System.out.println(" - 'all customers': Show customers");
        System.out.println(" - 'all orders': Show orders");
        System.out.println(" - 'create order': Create a new order");
    }
    
    private void testMe() {
        EmployeeController eCtrl = new EmployeeController();
        BranchController bCtrl = new BranchController();
        LocationController lCtrl = new LocationController();
        ItemController iCtrl = new ItemController();
        
        Employee e = eCtrl.createEmployee("Knægt", "Knægtessen", "2828282828", "31337135", "Langagervej 4", 9220, "Aalborg Øst", "dengodekode123", "Master of Disaster", "Direktør");
        Employee ea = eCtrl.createEmployee("Konge", "Kongessen", "2828282828", "31337135", "Langagervej 4", 9220, "Aalborg Øst", "dengodekode123", "Master of Disaster", "Direktør");
        Employee eb = eCtrl.createEmployee("Dronning", "Dronningsen", "2828282828", "31337135", "Langagervej 4", 9220, "Aalborg Øst", "dengodekode123", "Master of Disaster", "Direktør");
        Branch b = bCtrl.createBranch("Afdeling Q", "Sejvej 1", 9000, "Aalborg", "22222222");
        Location l = lCtrl.createLocation("Department A", 1, b);

        bCtrl.addEmployee("Afdeling Q", e);
        bCtrl.addEmployee("Afdeling Q", ea);
        bCtrl.addEmployee("Afdeling Q", eb);
        bCtrl.addLocation("Afdeling Q", l);
        
        CustomerController cCtrl = new CustomerController();
        CompanyController coCtrl = new CompanyController();
    
        Customer c = cCtrl.createCustomer("Kongen", "Kongesen", "1234567890", "12345678", "Havvej", "Havby", 8000, "Erhverv");
        Company co = coCtrl.createCompany("UCN",1234567890, "Vejen", 9000, "Aalborg", c);
        cCtrl.setCompany(c, co);
        
        Item i = iCtrl.createItem(l, "123456", "Damprenser", "Gør rent nemt", 500, 10, 5, 15, 5, true);
    }
    
  
}
