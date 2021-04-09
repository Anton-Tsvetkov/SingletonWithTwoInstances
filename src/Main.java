import java.lang.reflect.InvocationTargetException;


public class Main {

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {

        Singleton singleton = Singleton.getInstance();
        System.out.println("SYSTEM CL object: " + singleton);
        System.out.println("SYSTEM CL: " + singleton.getClass().getClassLoader());

        System.out.println("\n");


        CustomClassLoader classLoader = new CustomClassLoader(Main.class.getClassLoader());
        Class singletonClass = classLoader.loadClass("Singleton");
        System.out.println("OWN CL object: " + singletonClass.getMethod("getInstance").invoke(Singleton.class));
        System.out.println("OWN CL: " + classLoader);



    }
}
