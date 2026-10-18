package id.ac.polinema.uts.kafe;

public class Cafe {
    private String name;
    private MenuItem[] items = new MenuItem[20];
    private int itemCount;
    private Customer[] customers = new Customer[10];
    private int customerCount;

    public Cafe(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public boolean addItem(MenuItem item){
        if (item == null || itemCount == items.length) {
            return false;
        } else {
            this.items[itemCount] = item;
            itemCount++;
            return true;
        }
    }

    public boolean addCustomer(Customer customer) {
        if (customer == null){
            return false;
        }
        boolean idAda = true;
        if (findCustomer(customer.getCustomerId()) == null) {
            idAda = false;
        }
        if (customerCount == customers.length || idAda) {
            return false;
        } else {
            this.customers[customerCount] = customer;
            customerCount++;
            return true;
        }
    }

    public MenuItem[] getItems(){
        MenuItem[] y = new MenuItem[itemCount];
        for (int x = 0; x < itemCount; x++){
            y[x] = items[x];
        }
        return y;
    }

    public Customer[] getCustomers(){
        Customer[] y = new Customer[customerCount];
        for (int x = 0; x < customerCount; x++) {
            y[x] = customers[x];
        }
        return y;
    }

    public MenuItem findItemByName(String name) {
        for (int x = 0; x < itemCount; x++) {
            if (name.equalsIgnoreCase(items[x].getName())) {
                return items[x];
            }
        }
        return null;
    }

    public Customer findCustomer(String customerId) {
        for (int x = 0; x < customerCount; x++) {
            if (customerId.equals(customers[x].getCustomerId())) {
                return customers[x];
            }
        }
        return null;
    }

    public MenuItem[] searchByKeyword(String keyword) {
        int z = 0;
        for (int x = 0; x < itemCount; x++) {
            if(items[x].getName().toLowerCase().contains(keyword.toLowerCase())){
                z++;
            }
        }
        MenuItem[] y = new MenuItem[z];
        z = 0;
        for (int x = 0; x < itemCount; x++) {
            if (items[x].getName().toLowerCase().contains(keyword.toLowerCase())) {
                y[z] = items[x];
                z++;
            }
        }
        return y;
    }

    public boolean sell(String customerId, String itemName) {
        Customer customer = findCustomer(customerId);
        MenuItem item = findItemByName(itemName);
        if (customer == null || item == null) {
            return false;
        }
        if (customer.canOrder() && item.isAvailable()) {
            item.sell();
            customer.addOrder();
            return true;
        }
        return false;
    }

    public boolean refund(String customerId, String itemName) {
        Customer customer = findCustomer(customerId);
        MenuItem item = findItemByName(itemName);
        if(customer == null || item == null){
            return false;
        }
        if (customer.getItemCount() != 0 && item.isAvailable() == false) {
            item.restock();
            customer.removeOrder();
            return true;
        }
        return false;
    }
}
