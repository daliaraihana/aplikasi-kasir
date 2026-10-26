/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package kasir;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Produk> daftarProduk = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // Polymorphism: list bertipe Produk berisi Makanan & Minuman
        daftarProduk.add(new Makanan("M01", "Nasi Goreng Instan", 10000, 20));
        daftarProduk.add(new Makanan("M02", "Mie Instan", 3000, 20));
        daftarProduk.add(new Makanan("M03", "Roti", 10000, 15));
        daftarProduk.add(new Minuman("N01", "Teh Celup", 5000, 30));
        daftarProduk.add(new Minuman("N02", "Kopi Sashet", 2000, 30));
        daftarProduk.add(new Minuman("N03", "Susu Kotak", 5000, 25));

        int pilih;
        do {
            System.out.println("\n=== APLIKASI KASIR ===");
            System.out.println("1. Lihat Produk");
            System.out.println("2. Transaksi Baru");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = Integer.parseInt(in.nextLine());

            switch (pilih) {
                case 1: tampilProduk(); break;
                case 2: transaksiBaru(); break;
                case 0: System.out.println("Sampai jumpa!"); break;
                default: System.out.println("Menu tidak valid.");
            }
        } while (pilih != 0);
    }

    static void tampilProduk() {
        System.out.println("\n--- DAFTAR PRODUK ---");
        for (Produk p : daftarProduk) System.out.println(p);
    }

    static Produk cariProduk(String kode) {
        for (Produk p : daftarProduk)
            if (p.getKode().equalsIgnoreCase(kode)) return p;
        return null;
    }

    static void transaksiBaru() {
        Transaksi trx = new Transaksi();
        tampilProduk();

        while (true) {
            System.out.print("\nKode produk (0 = selesai): ");
            String kode = in.nextLine();
            if (kode.equals("0")) break;

            Produk p = cariProduk(kode);
            if (p == null) { System.out.println("Produk tidak ditemukan!"); continue; }

            System.out.print("Jumlah: ");
            int qty = Integer.parseInt(in.nextLine());
            if (qty <= 0 || qty > p.getStok()) {
                System.out.println("Jumlah tidak valid / stok kurang (stok: " + p.getStok() + ")");
                continue;
            }
            trx.tambahItem(p, qty);
            System.out.println(p.getNama() + " x" + qty + " ditambahkan.");
        }

        if (trx.kosong()) { System.out.println("Transaksi dibatalkan."); return; }

        System.out.print("Member? (y/n): ");
        trx.setDiskon(in.nextLine().equalsIgnoreCase("y") ? new DiskonMember() : new TanpaDiskon());

        System.out.printf("Total bayar: Rp%,.0f%n", trx.hitungTotalBayar());
        double bayar;
        do {
            System.out.print("Uang dibayar: ");
            bayar = Double.parseDouble(in.nextLine());
            if (bayar < trx.hitungTotalBayar()) System.out.println("Uang kurang!");
        } while (bayar < trx.hitungTotalBayar());

        trx.cetakStruk(bayar);
    }
}
