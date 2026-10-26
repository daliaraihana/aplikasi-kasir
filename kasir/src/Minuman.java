/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package kasir;

public class Minuman extends Produk {
    public Minuman(String kode, String nama, double harga, int stok) {
        super(kode, nama, harga, stok);
    }

    @Override
    public double hitungPajak() { return getHarga() * 0.10; } // pajak 10%

    @Override
    public String getKategori() { return "Minuman"; }
}
