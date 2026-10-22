package id.ac.polinema.uts.kafe;

public class Food extends MenuItem{
    private int prepMinutes;

    public Food(String name, int year, int prepMinutes) {
        // TODO Bantuan: isi semua field. Minuman baru: apakah sudah terjual atau belum?
        // Bagian 3: aturan validasi nama dan tahun sama dengan setter. Bisakah
        // constructor
        // memakai setter-nya?
        //
        // Kerangka (Bagian 2):
        super(name,year);

        this.prepMinutes = prepMinutes;
        //
    }

    public int getPrepMinutes() {
        return prepMinutes;
    }

    @Override
    public int price() {
        return 35000;
    }

    @Override 
    public String describe() {
        return (super.describe()+" ["+prepMinutes+" min]");
    }
}
