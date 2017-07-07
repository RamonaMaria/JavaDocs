package exercise0;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Iterate over the keys of a Map using keySet method (this method returns a Set of all the map keys) and
 *          print all its elements.
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughMap() {

        // Exercise #0 a) Create a Map (HashMap) and add elements to it (using put() method)
        // Exercise #0 a) Hint: Don't forget to specify the types of the key and value when creating the Map
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();
        hmap.put(1, "Banel Nicolita");
        hmap.put(2, "Mirel Radoi");
        hmap.put(3, "Nicolae Dica");
        hmap.put(4, "Tanase Cristian");

        //  Exercise #0 b) Iterate over the Map using keySet() method and print all its elements
        //  Exercise #0 b) The elements could be printed like this: [key1=value1, key2=value2, ...]
        // get keyset value from map

        for (Integer key : hmap.keySet()) {
            System.out.print("[" + key + "= " + hmap.get(key) + "]");
        }

    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}
