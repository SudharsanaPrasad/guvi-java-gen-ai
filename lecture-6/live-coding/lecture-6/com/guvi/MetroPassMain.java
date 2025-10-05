package com.guvi;

public class MetroPassMain {
    public static void main(String[] args) {
        MetroPass m1 = new MetroPass("Asha", 100);
        MetroPass m2 = new MetroPass("Ravi", 50);

        m1.addMoney(40);       // m1 balance becomes 140
        m1.rideOnce(140);      // true, m1 balance becomes 0
        boolean canRide = m1.rideOnce(50);
        System.out.println(canRide);
        System.out.println(m1.balance);

        System.out.println(m1.ownerName);

        m2.rideOnce(30);       	 // m2 balance becomes 20
        System.out.println(m2.balance);
        boolean ok = m2.addMoney(0); // false, no change

        m1.addMoney(500);
        m2.rideOnce(5);
    }
}
