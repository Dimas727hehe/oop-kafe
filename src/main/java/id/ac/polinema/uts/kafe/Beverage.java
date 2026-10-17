package id.ac.polinema.uts.kafe;

/**
 * Bagian 2 dan 3: minuman di menu kafe.
 *
 * Jangan ubah nama kelas, nama method, atau signature-nya. Autograder
 * memanggilnya persis seperti yang tertulis di sini.
 *
 * Field tidak dideklarasikan di sini: baca diagram kelas di README.
 * Method untuk bagian berikutnya (setSupplier, getSupplier, dan seterusnya)
 * kamu
 * tambahkan sendiri sesuai diagram di bagian tersebut.
 *
 * Kerangka field (lengkapi tipe dan nama dari diagram), letakkan di atas
 * constructor:
 * public String code;
 * public ____ name;
 * public ____ year;
 * public ____ available;
 */
public class Beverage extends MenuItem {
    private String code;
    private Supplier supplier;

    /**
     * Membuat minuman baru yang masih ada stoknya (belum terjual).
     * Bagian 3: code tidak boleh kosong; name dan year divalidasi seperti
     * setter-nya.
     */
    public Beverage(String code, String name, int year) {
        // TODO Bantuan: isi semua field. Minuman baru: apakah sudah terjual atau belum?
        // Bagian 3: aturan validasi nama dan tahun sama dengan setter. Bisakah
        // constructor
        // memakai setter-nya?
        //
        // Kerangka (Bagian 2):
        super(name,year);
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Code tak boleh null");
        }
        this.code = code;
        //
    }
    
    public Beverage(String code, String name, int year, Supplier supplier) {
        // TODO Bantuan: isi semua field. Minuman baru: apakah sudah terjual atau belum?
        // Bagian 3: aturan validasi nama dan tahun sama dengan setter. Bisakah
        // constructor
        // memakai setter-nya?
        //
        // Kerangka (Bagian 2):
        super(name, year);
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Code tak boleh null");
        }
        this.code = code;
        this.supplier = supplier;
    }

    public String getCode() {
        return code;
    }

    public Supplier getSupplier(){
        return supplier;
    }

    @Override
    public int price() {
        return 25000;
    }

    public String describe() {
        if (supplier == null){
            return super.describe() + " from Unkown";
        } else {
            return super.describe() + " from " + supplier;
        }
    }
}
