package activity.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Given
 *  Raw inputs with spaces, case differences, and a few invalid entries; inputs: " Asha ", "asha",
 *      "Ravi", "ravi", "Meena", "", null
 * Build
 *      A small interface named Normalizer with one method, apply
 *      One concrete strategy (think - class) that trims and lowercases a given name
 *      A LinkedHashSet to store normalized names while keeping first seen order
 * Rules
 * Normalizer.apply returns null if name is null or empty after trim; only nonnull results are
 * added to the LinkedHashSet
 * Expected Outcome
 *  Final set: ["asha", "ravi", "meena"]; Skipped count: 2
 */
public class Main {
    public static void main(String[] args) {
        // " Asha " -> "asha"
        //  "Ravi" -> "ravi"
        List list = Arrays.asList(" Asha ", "asha", "Ravi", "ravi", "Meena", "", null);
        Set set1 = new LinkedHashSet();

        int skipped = 0;
        Normalizer n = new TrimLower();
        for(Object o : list) {
            // "asha", "asha", "ravi", "ravi"
            String response = n.apply((String) o);
            if(response == null) {
                skipped++;
            } else {
                set1.add(response);
            }
        }
        System.out.println(set1);
        System.out.println("Skipped count: "+ skipped);

    }
}
