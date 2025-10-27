package activity.one;

import java.util.ArrayList;
import java.util.List;

class Image {
    public byte[] data;
    public Image(byte[] d) {
        data = d;
    }
}

public class MemoryCheck {
    public static List<Image> processed = new ArrayList<>();

    public static Image load() {
        byte[] raw = new byte[512];
        return new Image(raw);
    }

    public static void process(Image img) {
        processed.add(img); // keep track of processed images
        // write back to some location -> file
    }

    public static void main(String[] args) {
        // local variable
        Image img = load();
        process(img);
//        processed.clear();

        // static variable
        processed = new ArrayList<>();
        img = null;
        System.out.println("done");
    }
}
