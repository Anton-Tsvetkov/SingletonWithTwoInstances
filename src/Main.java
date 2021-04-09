import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {

//     ClassLoader classLoader;
//     for (;;){
//         classLoader = new MyClassLoader(new String[]{"."});
//         // текущий каталог "." будет единственным
//         // каталог поиска
//         Class clazz = Class.forName("Singleton", true, classLoader);
//         Object object = clazz.getConstructor().newInstance();
//         System.out.println(object);
//         new BufferedReader(new InputStreamReader(System.in)).readLine();


//        javac -cp . Singleton.java
//        javac MyOwnClassLoader.java
//        javac Main.java


//     }

//        String progClass = args[0];
//        String[] progArgs = new String[args.length - 1];
//        System.arraycopy(args, 1, progArgs, 0, progArgs.length);
//        MyOwnClassLoader ownClassLoader = new MyOwnClassLoader(Main.class.getClassLoader());
//        Class clas = ownClassLoader.loadClass(progClass);
//        Class mainArgType[] = { (new String[0]).getClass() };
//        Method main = clas.getMethod("main", mainArgType);
//        Object argsArray[] = { progArgs };
//        main.invoke(null, argsArray);
//
//        Method printCL = clas.getMethod("printCL", null);
//        printCL.invoke(null, new Object[0]);



//        MyOwnClassLoader myOwnClassLoader = new MyOwnClassLoader(Main.class.getClassLoader());
//        Class<?> singletonClass = myOwnClassLoader.loadClass("Singleton");
//        Object someSingleton = singletonClass.newInstance();
//        System.out.println(singletonClass.getMethod("getInstance").invoke(someSingleton));

        Singleton singleton = Singleton.getInstance();
        System.out.println("SYSTEM CL object: " + singleton);
        System.out.println("SYSTEM CL: " + singleton.getClass().getClassLoader());

        System.out.println("\n");


        MyOwnClassLoader classLoader = new MyOwnClassLoader(Main.class.getClassLoader()); // текущий каталог является единственным каталогом поиска
        // Class clazz = Class.forName("Singleton", true, classLoader);
        Class singletonClass = classLoader.loadClass("Singleton");
        Singleton singleton1 = (Singleton) singletonClass.getMethod("getInstance").invoke(Singleton.class);
        System.out.println("OWN CL object: " + singleton1);
        System.out.println("OWN CL object: " + singletonClass.getMethod("getInstance").invoke(Singleton.class));
        System.out.println("OWN CL: " + classLoader);



    }
}
