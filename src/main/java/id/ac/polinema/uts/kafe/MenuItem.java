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
public class MenuItem {
    protected String name;
    protected int year;
    private boolean available;
    private int extraPrice;

    /**
     * Membuat minuman baru yang masih ada stoknya (belum terjual).
     * Bagian 3: code tidak boleh kosong; name dan year divalidasi seperti
     * setter-nya.
     */
    public MenuItem(String name, int year) {
        // TODO Bantuan: isi semua field. Minuman baru: apakah sudah terjual atau belum?
        // Bagian 3: aturan validasi nama dan tahun sama dengan setter. Bisakah
        // constructor
        // memakai setter-nya?
        //
        // Kerangka (Bagian 2):
        this.available = true;
        //
        // Kerangka (Bagian 3): ganti dua baris name dan year dengan pemanggilan setter.
        setName(name);
        setYear(year);
    }

    public int price(){
        return 20000;
    }

    public void addExtra(){
        extraPrice += 5000;
    }

    public void addExtra(int amount) {
        if(amount <= 0){
            throw new IllegalArgumentException("Tidak boleh nol atau negatif");
        } else {
            extraPrice += amount;
        }
    }

    public String getName() {
        return name;
    }

    public int getTotalPrice() {
        return price() + extraPrice;
    }

    public int getYear() {
        // TODO Bantuan: sama seperti getCode.
        return year;
    }

    /** True jika minuman masih ada stok (belum terjual). */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Menjual minuman. Berhasil (true) jika masih ada stok. Jika sudah
     * terjual, hasilnya false dan keadaan minuman tidak berubah.
     */
    public boolean sell() {
        // TODO Bantuan: apa yang harus kamu periksa lebih dulu sebelum mengubah status?
        // Method ini punya dua jalur return yang berbeda.
        //
        // Kerangka:
        if (!available) {            
            return false;
        }
        available = false;
        return true;
    }

    /** Mengembalikan stok (misalnya karena refund): minuman bisa dijual lagi. */
    public void restock() {
        // TODO Bantuan: satu baris saja. Status apa yang berubah?
        //
        // Kerangka:
        available = true;
    }

    /**
     * Bagian 3. Mengubah nama. Nama null, kosong, atau hanya spasi ditolak
     * dengan IllegalArgumentException, dan nama lama tetap.
     */
    public void setName(String name) {
        // TODO Bantuan: periksa dulu, baru isi field. Class String punya method untuk
        // memeriksa teks kosong atau hanya spasi. Jangan lupa kemungkinan null.
        //
        // Kerangka:
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nama tak boleh null");
        }
        this.name = name;
    }

    /**
     * Bagian 3. Mengubah tahun peluncuran. Tahun di bawah 2000 ditolak dengan
     * IllegalArgumentException, dan tahun lama tetap.
     */
    public void setYear(int year) {
        // TODO Bantuan: pola yang sama dengan setName. Apa syarat tahun yang valid?
        //
        // Kerangka:
        if (year < 2000) {
            throw new IllegalArgumentException("Tahun tidak bisa dibawah 2000");
        }
        this.year = year;
    }

    public String describe(){
        return (name+" ("+year+")");
    }
    
    public String toString() {
        return describe();
    }
}
