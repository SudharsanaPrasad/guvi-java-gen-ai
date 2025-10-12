package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       // Interface List; Class: ArrayList
        List list = new ArrayList();
        list.add(45);       // index 0
        list.add(25);       // index 1
        list.add(60);       // 2
        list.add("B");      // 3

        list.add(2, "X");

        Integer integer = (Integer) list.get(0);
        System.out.println(integer);
        String str = (String) list.get(3);
        System.out.println(str);
        // 45, 25, 60, "B"
        // 0 , 1 , 2 , 3
        // 45, 25, "X", 60, "B"
        for(int i = 0; i < list.size(); i++) {
            //System.out.println(array[i]);
            System.out.print(list.get(i) + "\t");
        }

    }
}
