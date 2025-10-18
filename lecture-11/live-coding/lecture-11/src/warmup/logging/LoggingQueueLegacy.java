package warmup.logging;

import java.util.ArrayList;
import java.util.List;

public class LoggingQueueLegacy {
    public static void main(String[] args) {
        List queue = new ArrayList();
        queue.add("User logged in");
        queue.add(404); // accidentally added an Integer

        for (Object event : queue) {
            String log = (String) event; // Consider: what happens here?
            System.out.println(log.toUpperCase());
        }
    }
}