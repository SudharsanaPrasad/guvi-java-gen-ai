package gc;

public class LeakDemo {
    static final java.util.List<byte[]> cache = new java.util.ArrayList<>();

    static void process() {
        for(int i=0;i<10;i++) {
            cache.add(new byte[100_000]);
        }
    }

    static void simulateWork() {
        for(int i=0;i<1_000;i++) {
            process();
            System.gc();
        }
    }
    public static void main(String[] a){
        simulateWork();
        System.out.println(cache.size());
    }
}
