package lambda;

class Test {
    public Test() {

    }
}

public class Main2 {
    @FunctionalInterface
    interface ItemTest {
        boolean ok(Item it);
    }
    public static void main(String[] args) {
        //final int num = 400;
        //num = 450;

        int max = 200; // effectively final
        ItemTest cheap = it -> it.price <= max;
        System.out.println(cheap.ok(new Item("Tea",150)));
    }


}
