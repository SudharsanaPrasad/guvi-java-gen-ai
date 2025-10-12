package set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set setA = new HashSet();
        setA.add("A");
        setA.add("AB");
        setA.add("B");
        setA.add("A");
        System.out.println(setA);
        LinkedHashSet setB = new LinkedHashSet();
        setB.add("AA");
        setB.add("AB");
        setB.add("BA");
        setB.add("AA");
        System.out.println(setB);

    }
}
