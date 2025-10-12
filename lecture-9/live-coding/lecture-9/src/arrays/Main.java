package arrays;

public class Main {
    public static void main(String[] args) {
        String[] array = { "A", "B", "C" }; // ith element
        System.out.println(java.util.Arrays.toString(array));

        String[] array2 = new String[array.length + 1]; // array2[i]
//        for(int i = 0; i < array.length; i++) {
//            array2[i] = array[i];
//        }
        System.arraycopy(array, 0, array2, 0, array.length );
        System.out.println(java.util.Arrays.toString(array2));
        array2[3] = "D";

    }
}
