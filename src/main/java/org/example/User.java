package org.example;

import java.util.Map;

public class User {

    private String userName;

    private String address;
    private double walletAmount;
    private Cart cart = new Cart();

    public User(String userName, String address, double walletAmount) {
        this.userName = userName;
        this.address = address;
        this.walletAmount = walletAmount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getWalletAmount() {
        return walletAmount;
    }

    public void setWalletAmount(int walletAmount) {
        this.walletAmount = walletAmount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // todo add check on qty
    public void addToCart(Item item, int qty) {
        cart.addItem(item, qty);
    }

    public void getCart() {
        cart.getCart();
    }

    public void clearCart() {
        cart.clearCart();
    }

    public Map<Item, Integer> checkout() {
        Map<Item, Integer> existingCart = cart.getCart();
        double totalAmount = cart.getCartValue();
        if (totalAmount <= walletAmount) {
            this.walletAmount -= totalAmount;
        }
        else{
            throw new RuntimeException("Insufficient balance");
        }
        clearCart();
        System.out.println("Successful checkout , new wallet amount: " + this.walletAmount);
        return existingCart;
    }

    public void removeFromCart(Item item) {
        cart.removeFromCart(item);
    }
}
