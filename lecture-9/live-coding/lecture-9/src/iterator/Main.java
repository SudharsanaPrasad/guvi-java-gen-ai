package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List list = new ArrayList(50);
        list.add("A");
        list.add("B");
        list.add("A");
        Iterator it = list.iterator();
        // for each loop
//        for(Object str : list) {
//            if(str.equals("A")) {
//                list.remove(str);
//            }
//        }

        System.out.println(list.size());
        System.out.println(list);
        while(it.hasNext()) {
            String str = (String) it.next();
            System.out.println(str);
            if(str.equals("A")) {
                it.remove();
            }
        }
        System.out.println(list);
        System.out.println(list.size());

    }
}
