package com.guvi;

public class FastTagAccountMain {
    public static void main(String[] args) {
        FastTagAccount fta = new FastTagAccount("123123", -500);
        System.out.println(fta.getBalance());
        System.out.println(fta.getVehicleNumber());
//        fta.addMoney(500);
        fta.payToll(200);
        System.out.println(fta.getBalance());

    }
}
