package activity.one;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List fruits;

    public Cart() {
        fruits = new ArrayList();
    }

    public boolean addItems(String item) {
        // fruits.contains(item) => item exists in fruits => true/false
        // !fruits.contains(item)
        if(item != null && !item.isEmpty() && !fruits.contains(item)) {
            fruits.add(item);
            System.out.println("Item added successfully");
            return true;
        }
        return false;
    }

    public List getFruits() {
        List fruitsCopy = new ArrayList();
        // copy over all values from fruits
        return fruitsCopy;
    }
}
