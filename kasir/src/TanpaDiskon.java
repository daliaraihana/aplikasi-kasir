/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package kasir;

public class TanpaDiskon implements Diskon {
    @Override
    public double hitungDiskon(double total) { return 0; }

    @Override
    public String getNama() { return "Tanpa Diskon"; }
}
