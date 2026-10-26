/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package kasir;

// ABSTRACTION + ENCAPSULATION
public abstract class Produk {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }

    public void kurangiStok(int jumlah) { this.stok -= jumlah; }

    // Method abstrak: wajib di-override oleh subclass (POLYMORPHISM)
    public abstract double hitungPajak();
    public abstract String getKategori();

    @Override
    public String toString() {
        return String.format("%-6s %-18s %-10s Rp%,10.0f  Stok: %d",
                kode, nama, getKategori(), harga, stok);
    }
}
