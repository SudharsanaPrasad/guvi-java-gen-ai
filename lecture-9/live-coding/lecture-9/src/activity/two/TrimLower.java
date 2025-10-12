package activity.two;

public class TrimLower implements Normalizer {

    @Override
    public String apply(String str) {
        // check if it's null => return null
        if(str == null) return null;
        // trim the str "  "
        String temp = str.trim();
        // if it's empty => return null
        if(temp.isEmpty()) {
            return null;
        } else {
            // return a lower case version of str
            return temp.toLowerCase();
        }
    }
}
