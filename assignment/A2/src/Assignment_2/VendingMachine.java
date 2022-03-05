package Assignment_2;

import java.util.ArrayList;

public class VendingMachine {
    // ArrayList of Integers represents inserted coins in Coin Slot
    private ArrayList<Integer> insertedCoins;

    // ArrayList of Product represents inventories of products
    private ArrayList<Product> products;

    public VendingMachine() {
        insertedCoins = new ArrayList<Integer>();
        products = new ArrayList<Product>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void insertCoin(Integer c) {
        insertedCoins.add(c);
    }

    /* You may add other properties and methods */
}
