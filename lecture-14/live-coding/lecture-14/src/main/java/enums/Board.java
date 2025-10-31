package enums;

enum Status {
    NEW { String label() { return "New"; } },
    IN_PROGRESS { String label() { return "In progress"; } },
    DONE { String label() { return "Done"; } };
    abstract String label();
}

public class Board {
    static void print(Status s){
        System.out.println("Status " + s.label());
    }
    public static void main(String[] a){
        print(Status.NEW);
    }
}
