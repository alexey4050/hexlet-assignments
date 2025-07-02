package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        Method[] methods = Address.class.getDeclaredMethods();

        for (var method : methods) {
            if (method.isAnnotationPresent(Inspect.class)) {
                String returnType = method.getReturnType().getSimpleName();
                String methodName = method.getName();

                System.out.println("Method" + methodName + " return a value of type "
                        + returnType);
            }
        }
        // END
    }
}
