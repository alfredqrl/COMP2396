package Assignment_2;

public class CmdInsertCoin implements Command{
    @Override
    public String execute(VendingMachine v, String cmdPart) {

        Integer c = Integer.valueOf(cmdPart);
        // Add the coin to Coin Slot
        v.insertCoin(c);
        // Do something
        // return something. Format: "Inserted a $x coin. $y in total."
        return null;
    }
}
