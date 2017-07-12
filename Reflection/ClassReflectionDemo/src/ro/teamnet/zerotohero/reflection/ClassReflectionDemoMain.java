package ro.teamnet.zerotohero.reflection;

import ro.teamnet.zerotohero.reflection.demoobjects.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * TODO
 * in order to resolve the exercises below, you will have to create
 * all the needed clasees, with their members and methods
 * (in ro.teamnet.zerotohero.reflection.demoobjects package)
 */
public class ClassReflectionDemoMain {



    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // get the class for a String object, and print it
        String s = "ana";
        System.out.println(s.getClass().getName());
        System.out.println(s.getClass().getCanonicalName());
        System.out.println(s.getClass().getSimpleName());

        // get the class of an Enum, and print it
        Enum e = EnumClass.SUNDAY;
        System.out.println(e.getClass().getSimpleName());

        // get the class of a collection, and print it
        HashMap h = new HashMap();
        System.out.println(h.getClass().getSimpleName());

        // get the class of a primitive type, and print it
        int a = 1;
        System.out.println(int.class.getSimpleName());

        // get and print the class for a field of primitive type

        System.out.println(FieldClass.class.getDeclaredField("a").getType());

        //get and print the class for a primitive type, using the wrapper class
        Integer b = new Integer(12);
        System.out.println("b = " + b.getClass().getSimpleName());
        

        //get the class for a specified class name
        System.out.println(MyClass.class.getSimpleName());
        

        // get the superclass of a class, and print it
        System.out.println(MyClass.class.getSuperclass().getSimpleName());

        // get the superclass of the superclass above, and print it
        System.out.println(MyClass.class.getSuperclass().getSuperclass().getSimpleName());

        // get and print the declared classes within some other class
        Class[] c = MyClass.class.getDeclaredClasses();
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }

        // print the number of constructors of a class
        Constructor<?>[] d = MyClass.class.getDeclaredConstructors();
        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
        }

        // get and invoke a public constructor of a class
        MyClass obj = new MyClass();
        Constructor myC = obj.getClass().getConstructor(int.class);
        System.out.println(myC.newInstance(2).toString());

        //get and print the class of one private field
        MyClass myCls = new MyClass();
        Field f1 = MyClass.class.getDeclaredField("b");
        f1.setAccessible(true);
        System.out.println(f1.getType());

        // set and print the value of one private field for an object
        Field f2 = MyClass.class.getDeclaredField("b");
        f2.setAccessible(true);
        f2.setInt(myCls, 3);
        System.out.println(f2.get(myCls));

        f1.setAccessible(false);
        f2.setAccessible(false);

        // get and print only the public fields class
        Field[] ff = MyClass.class.getFields();
        System.out.println(ff.length);
        for (int i = 0; i < ff.length; i++) {
            System.out.println(ff[i]);
        }

        //get and invoke one public method of a class
        Method method = obj.getClass().getMethod("suma", int.class, int.class);
        System.out.println(method.invoke(obj, 5, 6));

        //get and invoke one inherited method of a class
        Method in = obj.getClass().getSuperclass().getMethod("diferenta", int.class, int.class);
        System.out.println(in.invoke(obj, 5, 6));


        //invoke a method of a class the classic way for ten times, and print the timestamp (System.currentTimeMillis())
       // System.out.println( System.currentTimeMillis());
        for (int i = 0; i < 10; i++)
            myCls.suma(i,i + 1);
        System.out.println( System.currentTimeMillis());

		//invoke a method of a class by Reflection for 100 times, and print the timestamp
        for (int i = 0; i < 10; i++) {
            in = obj.getClass().getMethod("suma", int.class, int.class);
            in.invoke(obj, i, i+1);
        }
        System.out.println( System.currentTimeMillis());

        //what do you observe?
		
    }
}
