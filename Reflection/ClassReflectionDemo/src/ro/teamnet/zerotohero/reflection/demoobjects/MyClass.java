package ro.teamnet.zerotohero.reflection.demoobjects;

/**
 * Created by Ramona.Raducu on 7/12/2017.
 */
public class MyClass extends MySuperClass {

    public int a;
    private int b;

    public MyClass() {
    }

    public MyClass(int a) {
        this.a = a;
    }

    class Ana {
        public int a = 1;

    }


    public int suma (int a, int  b) {
        return a + b;
    }


}
