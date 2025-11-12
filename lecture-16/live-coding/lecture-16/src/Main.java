public class Main {
    public static void main(String[] args) {
        int test = 8;
        int[][] array = new int[3][5];

        // loop over the rows -> O(n)	-> row 1, row 2, row 3, row 4, row 5
        // array.length -> length of the rows
        for(var i = 0; i < array.length; i++) {
            // for a given row, iterate over the columns
            for(var j = 0; j < array[i].length; j++) {
                array[i][j] = i + j;
                System.out.print(array[i][j]);
                if(j < array[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        // 2D matrix of size 3r, 3c -> O(n * n) -> O(n^2) => 9
        // 2D matrix of size n = 3, m = 5 -> O(n * m) => 15


    }
}
