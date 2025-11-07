
public class Test {
    public static void main(String[] args) {
        // Input: 10 45 60
        // ["10", "45", "60"]
        // O(1)
//        for(var i = 0; i < 5; i++) {
//            System.out.println(i);
//        }
        System.out.println(args[0]);
        // Memory allocation for 5 integers
        // Space Complexity: O(n)
        int n = Integer.parseInt(args[0]);
        int[] pref = new int[n];
        for(var i = 0; i < pref.length; i++) {
            System.out.println(i);
        }
    }
}
