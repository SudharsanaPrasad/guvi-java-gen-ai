package bounds;

import java.util.List;

public class Main {
    // List<Number> dst -> 10, 20, 50.5
    public static void addInts(List<? super Number> dst) {
        dst.add(1);
        dst.add(2);
        // 10, 20, 50.5, 1, 2
    }

    public static void main(String[] args) {
        List<Number> numbers = List.of(10, 20, 50.5);
        List<String> text = List.of("hi", "hello", "hey");
        addInts(numbers);
    }
}
