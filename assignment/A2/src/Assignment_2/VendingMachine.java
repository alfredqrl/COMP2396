package Assignment_2;

import java.util.ArrayList;

public class VendingMachine {
    // ArrayList of Integers represents inserted coins in Coin Slot
    private ArrayList<Integer> insertedCoins;

    // ArrayList of Product represents inventories of products
    private ArrayList<Product> products;
    private Integer totalCoins;

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
    public int getTotalCoins(){
        totalCoins = 0;
        for (Integer insertedCoin : insertedCoins) {
            totalCoins = totalCoins + insertedCoin;
        }
        return totalCoins;
    }

    public ArrayList<Integer> getInsertedCoins(){
        return insertedCoins;
    }

    public void clearInsertedCoins(){
        insertedCoins.clear();
    }

    public int noProductRemain(String productName){
        int num = 0;
        if (products.get(0).getName().equals(productName)){
            num = products.get(0).getQuantity();
        }else if (products.get(1).getName().equals(productName)){
            num = products.get(1).getQuantity();
        }
        return num;
    }

    public int noOfPrice(String productName){
        int num = 0;
        if (products.get(0).getName().equals(productName)){
            num = products.get(0).getPrice();
        }else if (products.get(1).getName().equals(productName)){
            num = products.get(1).getPrice();
        }
        return num;
    }

    public void sellProduct(String productName){
        if (products.get(0).getName().equals(productName)){
            products.get(0).sold();
        }else if (products.get(1).getName().equals(productName)){
            products.get(1).sold();
        }
    }
}
