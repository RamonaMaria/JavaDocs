package exercise3;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Ramona.Raducu on 7/7/2017.
 */
public class Main {
    public static void main(String[] args) {
        HashMap<Student2, BigDecimal> map2 = new HashMap<Student2, BigDecimal>();
        HashMap<Student3, BigDecimal> map3 = new HashMap<Student3, BigDecimal>();
        HashMap<Student4, BigDecimal> map4 = new HashMap<Student4, BigDecimal>();
        HashMap<Student5, BigDecimal> map5 = new HashMap<Student5, BigDecimal>();

        // verificare student2
        Student2 s1 = new Student2("Nicolita", "Banel");
        Student2 s2 = new Student2("Nicolita", "ioana");

        Student3 s3 = new Student3("Gigi", "Becali");
        Student3 s4 = new Student3("Gigi", "Becali");


        Student4 s5 = new Student4("Gigi", "Becali");
        Student4 s6 = new Student4("Gigi", "Becali");

        Student5 s7 = new Student5("Gigi", "Becali");
        Student5 s8 = new Student5("Gigi", "Becali");


        map2.put(s1, new BigDecimal(0.35));
        map2.put(s2,new BigDecimal(0.35));

        map3.put(s3,new BigDecimal(0.35));
        map3.put(s4,new BigDecimal(0.35));

        map4.put(s5,new BigDecimal(0.35));
        map4.put(s6,new BigDecimal(0.35));

        map5.put(s7,new BigDecimal(0.35));
        map5.put(s8,new BigDecimal(0.35));


        System.out.println(map2.keySet());
        for (Student2 key : map2.keySet()) {
            System.out.print("[" + key.getFirstName() + key.getLastName()+ "]");

        }





    }
}
