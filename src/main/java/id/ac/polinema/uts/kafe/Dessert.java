package id.ac.polinema.uts.kafe;

public class Dessert extends MenuItem{
    private int calories;

    public Dessert(String name, int year, int calories) {
        // TODO Bantuan: isi semua field. Minuman baru: apakah sudah terjual atau belum?
        // Bagian 3: aturan validasi nama dan tahun sama dengan setter. Bisakah
        // constructor
        // memakai setter-nya?
        //
        // Kerangka (Bagian 2):
        super(name,year);

        this.calories = calories;
        //
    }

    public Dessert(String name, int year) {
        // TODO Bantuan: isi semua field. Minuman baru: apakah sudah terjual atau belum?
        // Bagian 3: aturan validasi nama dan tahun sama dengan setter. Bisakah
        // constructor
        // memakai setter-nya?
        //
        // Kerangka (Bagian 2):
        super(name, year);

        this.calories = 250;
    }

    public int getCalories(){
        return calories;
    }
}
