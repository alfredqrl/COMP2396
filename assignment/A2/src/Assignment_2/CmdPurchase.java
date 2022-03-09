package Assignment_2;

import java.util.ArrayList;
import java.util.Collections;

public class CmdPurchase implements Command{
    @Override
    public String execute(VendingMachine v, String cmdPart) {

        if (v.getTotalCoins() < v.noOfPrice(cmdPart)){
            String reVal = "";
            reVal = reVal + "Not enough credit to buy " + cmdPart + "! Inserted $";
            reVal = reVal + v.getTotalCoins() + " but needs $" + v.noOfPrice(cmdPart) + ".";
            return reVal;
        }

        if (v.noProductRemain(cmdPart) <= 0){
            return cmdPart + " is out of stock!";
        }

        if (v.getTotalCoins() == v.noOfPrice(cmdPart)){
            v.clearInsertedCoins();
            v.sellProduct(cmdPart);
            return "Dropped " + cmdPart + ". Paid $" + v.noOfPrice(cmdPart) + ". No change.";
        }

        if (v.getTotalCoins() > v.noOfPrice(cmdPart)){
            String reVal = "Dropped " + cmdPart + ". Paid $" + v.getTotalCoins() + ".";
            reVal = reVal + " Your change: ";
            int difference;
            ArrayList<Integer> exchangeArr = new ArrayList<Integer>();
            v.sellProduct(cmdPart);
            // TODO exchange
            difference = v.getTotalCoins() - v.noOfPrice(cmdPart);
            while (difference - 10 >= 0){
                exchangeArr.add(10);
                difference = difference - 10;
            }
            while (difference - 5 >= 0){
                exchangeArr.add(5);
                difference = difference - 5;
            }
            while (difference - 2 >= 0){
                exchangeArr.add(2);
                difference = difference - 2;
            }
            while (difference - 1 >= 0){
                exchangeArr.add(1);
                difference = difference - 1;
            }
            Collections.sort(exchangeArr);
            for (int i = 0; i < exchangeArr.size() - 1; i++){
                reVal = reVal + "$" + exchangeArr.get(i) + ", ";
            }
            reVal = reVal + "$" + exchangeArr.get(exchangeArr.size() - 1) + ".";
            v.clearInsertedCoins();
            return reVal;
        }
        return null;
    }
}
