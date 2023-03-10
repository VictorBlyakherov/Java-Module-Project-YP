import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private double currentSum = 0;
    final private List<Item> itemList = new ArrayList<>();

    public double getCurrentSum() {
        return currentSum;
    }

    public boolean addItem(Item item) {
        if (findItem(item)) {
            return false;
        } else {
            itemList.add(item);
            currentSum = currentSum + item.getPrice();
            return true;
        }
    }

    private boolean findItem(Item lookingItem) {
        for (Item item : itemList) {
            if (item.equals(lookingItem)) {
                return true;
            }
        }
        return false;
    }

    public String getItemList() {
        String resultString = "";
        for (Item item : itemList) {
            resultString = resultString + item.getName() + ",   "
                    + Formatter.formatDoubleToString(item.getPrice()) + "\n";
        }
        return resultString;
    }
}
