package annotations;

//@FunctionalInterface
public class Demo {

    private int test;

    //@Override
    @Authenticated(value = "admin")
    public void createClass() {
        System.out.println("Hello from annotated method!");
    }
    /*
    annotations
    access modifier
    return type
    name
    body
     */
}
