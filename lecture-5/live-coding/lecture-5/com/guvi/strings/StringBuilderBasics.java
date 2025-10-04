package com.guvi.strings;

public class StringBuilderBasics {
    public static void main(String[] args) {
        // declaring + instantiating
        java.lang.StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(",");
        sb.append(" world");

        // variation 1
        String greeting = sb.toString();
//        System.out.println(greeting);

        // variation 2
//        System.out.println(sb);

        String[] names = new String[3];
        names[0] = "Sudharsana";
        names[1] = "Malini";
        names[2] = "Thirumani";

        sb = new StringBuilder("Name: ");
//        System.out.println(sb);

        for(int i = 0; i < names.length; i++) {
            if(i > 0) sb.append(", ");
            sb.append(names[i]);
        }

//        System.out.println(sb);

//        String nameStr = "Names: ";
//        for(int i = 0; i < names.length; i++) {
//            System.out.println(nameStr);
//            nameStr += names[i];
//        }

        sb = new StringBuilder("Java is fun");
        sb.insert(5, "really ");
        System.out.println(sb);

        System.out.println(sb.reverse());

        // declaring a variable num
        // initializing it with a value, 1
        int num = 1;
        if(num == 5) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

        // instantiation - go ahead and create a new string on the heap
        // even if "temp" exists
        // 123456
        String str = new String("temp2");

        // string literal
        // initialization
        // if a "temp" string exists, reuse
        // 123457
        String str2 = "temp2";
        String str3 = "temp2";

        // 123456 == 123457
        if(str == str2) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

        // 123457 == 123457
        if(str2 == str3) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

        boolean equal = str.equals(str3);
        System.out.println(equal);
    }


}
