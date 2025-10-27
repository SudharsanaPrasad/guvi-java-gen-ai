package warmup.logging;

import java.util.ArrayList;
import java.util.List;

public class LoggingQueueLegacy {
    public static void main(String[] args) {
        List<String> queue = new ArrayList<>();
        queue.add("User logged in");
        // 404 => "404"
        queue.add(String.valueOf(404)); // accidentally added an Integer

        // Integer temp = new Integer(404);
        // queue.add(temp.toString());

        //queue.add(Integer.toString(404));

        for (String event : queue) {
            /*
            "User logged in" -> casting to String is fine
            404 -> will this get cast to String? Eg: "404"
            404 (Object) -> Integer -> String
             */
            //String log = event; // Consider: what happens here?
            System.out.println(event.toUpperCase());
        }
    }
}