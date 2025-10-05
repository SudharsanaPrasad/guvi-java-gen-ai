package com.guvi;

public class UPIWalletMain {
    public static void main(String[] args) {
        UPIWallet wallet = new UPIWallet();
        boolean isPinUpdated = wallet.changePin("1234", "12345");
        System.out.println(isPinUpdated);
    }
}
