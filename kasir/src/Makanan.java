/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package kasir;

// INHERITANCE
public class Makanan extends Produk {
    public Makanan(String kode, String nama, double harga, int stok) {
        super(kode, nama, harga, stok);
    }

    @Override
    public double hitungPajak() { return getHarga() * 0.05; } // pajak 5%

    @Override
    public String getKategori() { return "Makanan"; }
}