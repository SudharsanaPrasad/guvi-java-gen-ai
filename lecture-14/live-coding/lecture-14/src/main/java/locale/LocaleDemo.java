package locale;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleDemo {
    public static void main(String[] args) {
        Locale enUS = Locale.forLanguageTag("en-US");
        Locale hiIn = new Locale("hi", "IN");

        System.out.println(enUS.getCountry() + "  " + enUS.getLanguage());
        System.out.println(hiIn.getCountry() + "  " + hiIn.getLanguage());

        ResourceBundle rb = ResourceBundle.getBundle("Messages", hiIn);
        System.out.println(rb.getString("greeting"));

        Enumeration<String> enums = rb.getKeys();
        while(enums.hasMoreElements()) {
            System.out.println(enums.nextElement());
        }

    }
}
