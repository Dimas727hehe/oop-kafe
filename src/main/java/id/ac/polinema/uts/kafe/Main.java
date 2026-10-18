package id.ac.polinema.uts.kafe;

import java.util.Scanner;

/**
 * Titik awal program (satu-satunya method main di proyek ini).
 *
 * Bagian 1: baris PERTAMA output harus persis "Welcome to Polinema Cafe".
 * Setelah itu kamu bebas menambah baris lain untuk bereksperimen.
 *
 * Bagian 7: di bawah baris sapaan, kamu akan membuat Cafe, mengisi data
 * contoh, lalu menjalankan CafeApp. Kerangkanya ada di README.
 */
public class Main {

    public static void main(String[] args) {
        Cafe cafe = new Cafe("Polinema Cafe");
        // TODO: Tampilkan sebuah teks ke layar.
        // Di Java, perintahnya berbentuk: System.out.println("teks kamu");
        // Ganti teks di dalam tanda kutip dengan teks dari soal. Huruf besar-kecil dan
        // spasi harus persis sama. Tulis perintahnya di dalam kurung kurawal main ini,
        // lalu jalankan programnya.
        //
        // Kerangka:
        System.out.println("Welcome to Polinema Cafe");

        cafe.addItem(new Beverage("1", "Americano", 2015, new Supplier("Dimas", "Malang")));
        cafe.addItem(new Food("Nasgor Komplit", 2017, 15));
        cafe.addItem(new Dessert("Pisang Coklat", 2012, 205));
        cafe.addCustomer(new Customer("C001", "Budi"));

        CafeApp aplikasi = new CafeApp(cafe, new Scanner(System.in), System.out);
        aplikasi.run();

        // Bagian 7: lanjutkan di sini (buat Cafe, isi data contoh, jalankan CafeApp).
    }
}
