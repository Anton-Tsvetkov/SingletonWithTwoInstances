import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader{

    public CustomClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(!name.equals("Singleton")){
            return super.loadClass(name);
        }
        try {
            InputStream in = ClassLoader.getSystemResourceAsStream("Singleton.class");
            byte[] a = new byte[10000];
            int len = in.read(a);
            in.close();
            return defineClass(name, a, 0, len);
        } catch (IOException e){
            throw new ClassNotFoundException();
        }
    }

}
