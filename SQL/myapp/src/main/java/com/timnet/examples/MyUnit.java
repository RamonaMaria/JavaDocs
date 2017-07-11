package com.timnet.examples;

/**
 * Created by Ramona.Raducu on 7/10/2017.
 */
public class MyUnit {


    public String concatenate (String one, String two) {
        if (one == null && two == null)
            return null;

        if (one == null)
            return two;

        if (two == null)
            return one;
        return one  + two;
    }

    public boolean getBoolean() {
        return new java.util.Random().nextBoolean();
    }
}
