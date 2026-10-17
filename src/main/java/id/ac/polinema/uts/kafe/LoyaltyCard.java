package id.ac.polinema.uts.kafe;

public class LoyaltyCard {
    private String number;

    public LoyaltyCard(String number){
        this.number = "LC-"+number;
    }

    public String getNumber(){
        return this.number;
    }
}
