package com.matera.pizzaria.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class StandardPasswordEncoderDemo {
    @Test
    public void testCannotReproduceHashFromConfigFile() {
        StandardPasswordEncoder encoder = new StandardPasswordEncoder();
        String password = "flavia";
        String encoded = encoder.encode(password);
        String encodedFromXML = "6d3b81630883bc54a92cfea42b1cea1a54e7fce7569a9ebdb94db3953e08705ca45db1a3f49afedb";

        // What we generated is not what's in the XML
        assertTrue(encodedFromXML != encoded);

        // But both what's in the XML and what we generated match the password.
        assertTrue(encoder.matches(password, encoded));
        assertTrue(encoder.matches(password, encodedFromXML));

        System.out.println(encoded);
   }

    @Test
    public void testAnotherRunWillAlsoYieldDifferentHashes() {
        StandardPasswordEncoder encoder = new StandardPasswordEncoder();
        String password = "willian";
        String encoded = encoder.encode(password);
        String encoded2 = encoder.encode(password);
        assertTrue(encoded2 != encoded);

        System.out.println(encoded);
        System.out.println(encoded2);
    }
}
