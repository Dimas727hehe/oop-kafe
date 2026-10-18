package id.ac.polinema.uts.kafe;

import java.io.PrintStream;
import java.util.Scanner;

public class CafeApp {
    private Cafe cafe;
    private Scanner in;
    private PrintStream out;

    public CafeApp(Cafe cafe, Scanner in, PrintStream out){
        this.cafe = cafe;
        this.in = in;
        this.out = out;
    } 

    public boolean validasiAngka(String input){
        char[] x = input.toCharArray();

        for (int y = 0; y < x.length; y++){
            if(!Character.isDigit(x[y])){
                return false;
            }
        }
        return true;
    }

    public void run(){
        boolean running = true;
        while(running ){
            out.print("=== " + cafe.getName() + " ===\n1. Show menu\n2. Add beverage\n3. Add food\n4. Add dessert\n5. Register customer\n6. Sell item\n7. Refund item\n8. Search menu\n9. Show customers\n0. Exit\nSelect: ");
            String choice = "0";
            if (in.hasNextLine()) {
                choice = in.nextLine();
            }
            
            if (choice.isBlank()){
                running = false;
                break;
            } else {
                if (validasiAngka(choice)) {
                    switch (Integer.parseInt(choice)) {
                        case 1:
                            if (cafe.getItems().length == 0) {
                                out.println("Menu is empty");
                            } else {
                                String status;
                                for (int x = 0; x < cafe.getItems().length; x++) {
                                    if (cafe.getItems()[x].isAvailable()) {
                                        status = "In stock";
                                    } else {
                                        status = "Sold out";
                                    }
                                    out.print(cafe.getItems()[x].describe() + " | " + status + " | Rp"
                                            + cafe.getItems()[x].getTotalPrice() + "\n");
                                }
                            }
                            break;
                        case 2:
                            out.print("Code: ");
                            String code = in.nextLine();
                            out.print("Name: ");
                            String name1 = in.nextLine();
                            out.print("Year: ");
                            String year1 = in.nextLine();
                            if (!validasiAngka(year1) || Integer.parseInt(year1) < 2000) {
                                out.println("Invalid number");
                            } else if (code.isEmpty() || name1.isEmpty()) {
                                out.println("Invalid input");
                            } else {
                                out.print("Supplier name (blank for none): ");
                                String supply = in.nextLine();
                                String city;
                                if (supply == null || supply.isBlank()) {
                                    if (cafe.addItem(new Beverage(code, name1, Integer.parseInt(year1)))) {
                                        out.println("Item added");
                                    } else {
                                        out.println("Menu is full");
                                    }
                                } else {
                                    out.print("Supplier city: ");
                                    city = in.nextLine();
                                    if (city.isEmpty()) {
                                        out.println("Invalid input");
                                    } else {
                                        if (cafe.addItem(new Beverage(code, name1, Integer.parseInt(year1),
                                                new Supplier(supply, city)))) {
                                            out.println("Item added");
                                        } else {
                                            out.println("Menu is full");
                                        }
                                    }
                                }
                            }
                            break;
                        case 3:
                            out.print("Name: ");
                            String name2 = in.nextLine();
                            out.print("Year: ");
                            String year2 = in.nextLine();
                            out.print("Prep time (minutes): ");
                            String prep = in.nextLine();
                            if (!validasiAngka(year2) || Integer.parseInt(year2) < 2000 || !validasiAngka(prep)
                                    || Integer.parseInt(prep) < 0) {
                                out.println("Invalid number");
                            } else if (name2.isEmpty()) {
                                out.println("Invalid input");
                            } else {
                                if (cafe.addItem(new Food(name2, Integer.parseInt(year2), Integer.parseInt(prep)))) {
                                    out.println("Item added");
                                } else {
                                    out.println("Menu is full");
                                }
                            }
                            break;
                        case 4:
                            out.print("Name: ");
                            String name3 = in.nextLine();
                            out.print("Year: ");
                            String year3 = in.nextLine();
                            out.print("Calories: ");
                            String calories = in.nextLine();
                            if (!validasiAngka(year3) || Integer.parseInt(year3) < 2000 || !validasiAngka(calories)
                                    || Integer.parseInt(calories) < 0) {
                                out.println("Invalid number");
                            } else if (name3.isEmpty()) {
                                out.println("Invalid input");
                            } else {
                                if (cafe.addItem(
                                        new Dessert(name3, Integer.parseInt(year3), Integer.parseInt(calories)))) {
                                    out.println("Item added");
                                } else {
                                    out.println("Menu is full");
                                }
                            }
                            break;
                        case 5:
                            out.print("Customer ID: ");
                            String customerId = in.nextLine();
                            out.print("Name: ");
                            String name4 = in.nextLine();
                            if (customerId.isEmpty() || name4.isEmpty()) {
                                out.println("Invalid input");
                            } else {
                                if (cafe.findCustomer(customerId) == null) {
                                    if (cafe.addCustomer(new Customer(customerId, name4))) {
                                        out.println("Customer registered");
                                    }
                                } else {
                                    out.println("Customer ID already exists");
                                }
                            }
                            break;
                        case 6:
                            out.print("Customer ID: ");
                            String customerIdSell = in.nextLine();
                            out.print("Item name: ");
                            String nameItem1 = in.nextLine();
                            if (customerIdSell.isEmpty() || nameItem1.isEmpty()) {
                                out.println("Invalid input");
                            } else {
                                if (cafe.sell(customerIdSell, nameItem1)) {
                                    out.println("Sale successful");
                                } else {
                                    out.println("Sale failed");
                                }
                            }
                            break;
                        case 7:
                            out.print("Customer ID: ");
                            String customerIdrefund = in.nextLine();
                            out.print("Item name: ");
                            String nameItem2 = in.nextLine();
                            if (customerIdrefund.isEmpty() || nameItem2.isEmpty()) {
                                out.println("Invalid input");
                            } else {
                                if (cafe.refund(customerIdrefund, nameItem2)) {
                                    out.println("Refund successfull");
                                } else {
                                    out.println("Refund failed");
                                }
                            }
                            break;
                        case 8:
                            out.print("Keyword: ");
                            String keyword = in.nextLine();
                            if (cafe.searchByKeyword(keyword).length == 0) {
                                out.println("No matches");
                            } else {
                                String statuskey;
                                for (int x = 0; x < cafe.searchByKeyword(keyword).length; x++) {
                                    if (cafe.searchByKeyword(keyword)[x].isAvailable()) {
                                        statuskey = "In stock";
                                    } else {
                                        statuskey = "Sold out";
                                    }
                                    out.print(cafe.searchByKeyword(keyword)[x].describe() + " | " + statuskey + " | Rp"
                                            + cafe.searchByKeyword(keyword)[x].getTotalPrice() + "\n");
                                }
                            }
                            break;
                        case 9:
                            if (cafe.getCustomers().length == 0) {
                                out.println("No customers");
                            } else {
                                for (int x = 0; x < cafe.getCustomers().length; x++) {
                                    out.print(cafe.getCustomers()[x].getCustomerId() + " - "
                                            + cafe.getCustomers()[x].getName()
                                            + " (" + cafe.getCustomers()[x].getItemCount() + " items)\n");
                                }
                            }
                            break;
                        case 0:
                            out.println("Thank you");
                            running = false;
                            break;
                        default:
                            out.println("Invalid option");
                            continue;
                    }
                } else {
                    out.println("Invalid option");
                }
            }
        }
    }
}
