package id.ac.polinema.uts.kafe;

public class Counter {
    private String code;
    private Beverage[] beverages = new Beverage[5];
    private int count = 0;

    public Counter(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }

    public int getBeverageCount() {
        return count;
    }

    public boolean addBeverage(Beverage beverage){
        if (count == beverages.length || beverage == null){
            return false;
        }
        this.beverages[count] = beverage;
        count++;
        return true;
    }

    public Beverage findByCode(String code){
        for (int x = 0; x < count; x ++){
            if(code.equals(beverages[x].getCode())){
                return beverages[x];
            }
        }
        return null;
    }

    public int countAvailable() {
        int hitung = 0;
        for (int x = 0; x < count; x++){
            if (beverages[x].isAvailable()){
                hitung++;
            }
        }
        return hitung;
    }
}
