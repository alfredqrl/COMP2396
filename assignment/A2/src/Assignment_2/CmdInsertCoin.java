package Assignment_2;

public class CmdInsertCoin implements Command{

    @Override
    public String execute(VendingMachine v, String cmdPart) {

        String reVal;
        Integer c = Integer.valueOf(cmdPart);
        // Add the coin to Coin Slot
        v.insertCoin(c);
        // Do something
        int totalInserted = v.getTotalCoins();
        // return something. Format: "Inserted a $x coin. $y in total."
        reVal = "Inserted a $" + c + " coin. $" + totalInserted + " in total.";
        return reVal;
    }
}
