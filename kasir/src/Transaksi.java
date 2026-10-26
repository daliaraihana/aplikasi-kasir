/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package kasir;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Transaksi {
    private ArrayList<ItemTransaksi> items = new ArrayList<>();
    private Diskon diskon = new TanpaDiskon();

    public void tambahItem(Produk p, int jumlah) {
        items.add(new ItemTransaksi(p, jumlah));
        p.kurangiStok(jumlah);
    }

    public void setDiskon(Diskon diskon) { this.diskon = diskon; }
    public boolean kosong() { return items.isEmpty(); }

   
    public double hitungSubtotal() {
        double total = 0;
        for (ItemTransaksi i : items) total += i.getSubtotal();
        return total;
    }

    public double hitungPajak() {
        double total = 0;
        for (ItemTransaksi i : items) total += i.getPajak();
        return total;
    }

    public double hitungTotalBayar() {
        double sub = hitungSubtotal();
        return sub - diskon.hitungDiskon(sub) + hitungPajak();
    }

    public void cetakStruk(double bayar) {
        String waktu = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        System.out.println("\n===============================");
        System.out.println("        TOKO SERBA ADA");
        System.out.println("      " + waktu);
        System.out.println("===============================");
        for (ItemTransaksi i : items) {
            System.out.printf("%-14s %2d x %,8.0f = %,9.0f%n",
                    i.getProduk().getNama(), i.getJumlah(),
                    i.getProduk().getHarga(), i.getSubtotal());
        }
        System.out.println("-------------------------------");
        double sub = hitungSubtotal();
        System.out.printf("Subtotal   : Rp%,12.0f%n", sub);
        System.out.printf("%-11s: Rp%,12.0f%n", "Diskon", diskon.hitungDiskon(sub));
        System.out.printf("Pajak      : Rp%,12.0f%n", hitungPajak());
        System.out.printf("TOTAL      : Rp%,12.0f%n", hitungTotalBayar());
        System.out.printf("Bayar      : Rp%,12.0f%n", bayar);
        System.out.printf("Kembalian  : Rp%,12.0f%n", bayar - hitungTotalBayar());
        System.out.println("===============================");
        System.out.println("   Terima kasih sudah berbelanja!");
    }
}
