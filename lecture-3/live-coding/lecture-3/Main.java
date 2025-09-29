public class Main {
    public static void main(String[] args) {
        int number = 2;
        number = number * 2;
        System.out.println(number);
        number = number / 2;
        System.out.println(number);
        number = number + 100;
        System.out.println(number);
        number = number - 50;
        System.out.println(number);

        number = 100;

        // modulo - %
        System.out.println(number % 10);
        System.out.println(number % 11);

        // post-increment operator
//        number++;
        // pre-increment operator
//        ++number;
//        System.out.println(number);

//        for(int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }

//        int n = 10;
//        for(int i = 0; i < n; i++) {
//            System.out.println(i);
//        }

//        int n = 10;
//        // i-- -> decrementing the value of i by 1
//        for(int i = n; i >= 0; i--) {
//            System.out.println(i);
//        }

//        int n = 100;
//        // i-- -> decrementing the value of i by 1
//        for(int i = 0; i <= n; i = i + 10) {
//            System.out.println(i);
//        }

//        boolean hasUserEnteredDate = false;
//        while(!hasUserEnteredDate) {
//            // ask user to enter a valid date
//        }
//        String name = "Nikhil";
//
//        int j = 0;
//        do {
//            System.out.println(j);
//            j = j + 1;
//        } while(j < 50);

        boolean hasUserEnteredDate = false;
        int score = 30;
        while(score >= 30) {
            if(score > 40) {
                System.out.println("continue");
                score = score + 1;
                break;
            }
            System.out.println(score);
            score = score + 1;
        }
    }
}
