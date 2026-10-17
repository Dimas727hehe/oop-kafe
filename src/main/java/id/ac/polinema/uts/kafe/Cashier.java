package id.ac.polinema.uts.kafe;

public class Cashier {
    public boolean sell(Customer customer, Beverage beverage){
        if(customer.canOrder() && beverage.isAvailable()){
            beverage.sell();
            customer.addOrder();
            return true;
        }
        return false;
    }

    public boolean refund(Customer customer, Beverage beverage){
        if(customer.getItemCount() != 0 && beverage.isAvailable() == false){
            beverage.restock();
            customer.removeOrder();
            return true;
        }
        return false;
    }
}
