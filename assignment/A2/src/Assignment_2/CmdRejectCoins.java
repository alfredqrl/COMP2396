package Assignment_2;

import java.util.ArrayList;
import java.util.Collections;

public class CmdRejectCoins implements Command{
    @Override
    public String execute(VendingMachine v, String cmdPart) {
        ArrayList<Integer> storedCoins = v.getInsertedCoins();
        if (storedCoins.size() <= 0){
            return "Rejected no coin!";
        }
        Collections.sort(storedCoins);
        String reVal = "Rejected ";
        int total = 0;
        for (int i = 0; i < storedCoins.size() - 1; i++){
            reVal = reVal + "$" + storedCoins.get(i) +", ";
            total = total + storedCoins.get(i);
        }
        reVal = reVal + "$" + storedCoins.get(storedCoins.size()-1) + ".";
        total = total + storedCoins.get(storedCoins.size()-1);
        reVal = reVal + " $" + total + " in total.";
        v.clearInsertedCoins();
        return reVal;
    }
}
