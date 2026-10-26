/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package kasir;

public class DiskonMember implements Diskon {
    @Override
    public double hitungDiskon(double total) { return total * 0.10; } // 10%

    @Override
    public String getNama() { return "Diskon Member 10%"; }
}
