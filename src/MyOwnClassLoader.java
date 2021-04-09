import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MyOwnClassLoader extends ClassLoader{

    public MyOwnClassLoader(ClassLoader parent) {
        super(parent);
    }

    // load class from FS
    private Class getClass(String name) throws ClassNotFoundException {
        String file = name.replace('.', File.separatorChar) + ".class";
        byte[] b = null;
        try {
            b = loadClassFileData(file); // load byte code data from file
            Class c = defineClass(name, b, 0, b.length);
            resolveClass(c);
            return c;
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    // if class in FS - use CL else delegate the request to parent CL
//    @Override
//    public Class loadClass(String name) throws ClassNotFoundException {
//        System.out.println("Loading Class '" + name + "'");
//        if(name.startsWith("com.epam.laboratory")){
//            System.out.print(" using own ClassLoader");
//            return getClass(name);
//        }
//        return super.loadClass(name);
//    }

    // reads .class file into a byte array
    private byte[] loadClassFileData(String name) throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(name);
        int size = stream.available();
        byte buff[] = new byte[size];
        DataInputStream in = new DataInputStream(stream);
        in.readFully(buff);
        in.close();
        return buff;
    }

}
