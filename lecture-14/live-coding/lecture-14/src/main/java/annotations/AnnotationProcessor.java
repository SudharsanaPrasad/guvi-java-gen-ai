package annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void main(String[] args)
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        User user = new User();
//        user.setRole("admin");

        Demo demo = new Demo();
        // demo.createClass();

        Method method = demo.getClass().getMethod("createClass");

        // Reflection
        if(method.isAnnotationPresent(Authenticated.class)) {
            Authenticated annotation = method.getAnnotation(Authenticated.class);
            System.out.println("Annotation value: " + annotation.value());
            // business rules
            // if(user.getRole() == "admin")
            method.invoke(demo);
        }
    }
}
