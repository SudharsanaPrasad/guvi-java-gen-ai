package modern;

import java.util.HashMap;
import java.util.Map;

public class VarUsage {
    public static void main(String[] args) {
        // hashmap requires keys and values
        // Map<Integer, String> byId = new HashMap<Integer, String>();
        var byId = new HashMap<Integer, String>();
        var who = "Nikhil";
        byId.put(7, who);
        for(var temp: byId.entrySet()) {
            System.out.println(temp.getKey() + " -> " + temp.getValue());
        }
    }
}
