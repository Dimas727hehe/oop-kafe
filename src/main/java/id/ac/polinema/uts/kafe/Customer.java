package id.ac.polinema.uts.kafe;

/**
 * Bagian 3: pelanggan kafe.
 *
 * Jangan ubah nama kelas, nama method, atau signature-nya. Autograder
 * memanggilnya persis seperti yang tertulis di sini.
 *
 * Field tidak dideklarasikan di sini: baca diagram kelas di README
 * (semua field harus private).
 *
 * Kerangka field (lengkapi dari diagram), letakkan di atas constructor:
 * private ____ customerId;
 * private ____ name;
 * private int itemCount; // nilai awal 0
 */
public class Customer {

    /**
     * Membuat pelanggan yang belum punya pesanan.
     * customerId dan name tidak boleh null atau kosong: lempar
     * IllegalArgumentException jika tidak valid.
     */
    private String customerId;
    private String name;
    private int itemCount = 0;
    private LoyaltyCard card;

    public Customer(String customerId, String name) {
        // TODO Bantuan: validasi dulu sebelum mengisi field. Aturan nama sama dengan
        // setName.
        // Bagian 4: kartu loyalty juga dibuat di sini (lihat diagram Bagian 4).
        //
        // Kerangka:
        if (customerId == null || customerId.isBlank()) {
            throw new IllegalArgumentException("Customer ID tak boleh null");
        }
        this.customerId = customerId;
        setName(name);
        this.card = new LoyaltyCard(customerId);
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    /**
     * Nama tidak boleh null atau kosong: lempar IllegalArgumentException dan
     * biarkan nama lama.
     */
    public void setName(String name) {
        // TODO Bantuan: periksa dulu, baru isi field.
        //
        // Kerangka:
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nama tak boleh null");
        }
        this.name = name;
    }

    public int getItemCount() {
        return itemCount;
    }

    public LoyaltyCard getCard(){
        return card;
    }

    /** True jika pelanggan masih boleh memesan (batasnya 5 item per pesanan). */
    public boolean canOrder() {
        if (itemCount >= 5) {
            return false;
        }
        return true;
    }

    /**
     * Menambah jumlah item pesanan. Jika sudah di batas, tidak berubah dan hasilnya
     * false.
     */
    public boolean addOrder() {
        // TODO Bantuan: periksa batas dulu. Adakah method lain di kelas ini yang sudah
        // menjawab pertanyaan "boleh atau tidak"?
        //
        // Kerangka:
        if (!canOrder()) {
        return false;
        }
        itemCount++;
        return true;
    }

    /**
     * Mengurangi jumlah item pesanan. Jika sudah tidak ada pesanan, tidak berubah
     * dan hasilnya false.
     */
    public boolean removeOrder() {
        // TODO Bantuan: batas bawah jumlah item adalah berapa?
        //
        // Kerangka:
        if (itemCount <= 0) {
        return false;
        }
        itemCount--;
        return true;
    }
}
