package modern;

record User(int id, String name) {
    public String tag() {
        // "#7-Nikhil"
        return "#" + id + "-" + name;
    }
}
public class RecordDemo {
    public static void main(String[] args) {
        var u = new User(7, "Nikhil");  // User@1
        System.out.println(u.id());
        System.out.println(u.name());
        boolean isEqual = u.equals(new User(7, "Nikhil"));      // User@2
        System.out.println(isEqual);
        System.out.println(u.tag());
    }
}
