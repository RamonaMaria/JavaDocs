import com.timnet.examples.MyUnit;
import org.junit.Test;

import javax.management.QueryExp;
import javax.sound.sampled.BooleanControl;

import static javax.management.Query.not;
import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertThat;
import static sun.nio.cs.Surrogate.is;

/**
 * Created by Ramona.Raducu on 7/10/2017.
 */
public class MyUnitTest {
    @Test
    public void testConcatenate () {
        MyUnit myUnit = new MyUnit();
        String result = myUnit.concatenate("one", "two");
        assertEquals("onetwo",result);
    }

    @Test
    public void testConcatNulls () {
            MyUnit o = new MyUnit();
            String r = o.concatenate(null, "ana");
            assertEquals("ana", r);
    }

    @Test
    public void testGetBoolean () {
        MyUnit o = new MyUnit();
     //   assertTrue (o.getBoolean());
     //   assertTrue((Boolean)o.getBoolean() instanceof Boolean);
     //   assertTrue(o.getBoolean().);
        assertThat("a", not(is("b")));
    }

    private QueryExp is(String b) {
    }


}
