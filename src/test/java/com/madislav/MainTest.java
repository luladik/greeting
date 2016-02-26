package com.madislav;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Random;

import static org.junit.Assert.*;

public class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(null);
    }

    @Test
    public void testInitLocale() {
        Locale locale = new Locale("ru", "RU");
        assertEquals(locale.toString(), "ru_RU");
        locale = new Locale("en", "US");
        assertEquals(locale.toString(), "en_US");
    }

    @Test
    public void testPrintGreeting() {
        Main.initLocale();
        for (int i = 0; i < 50; i++) {

            int time = new Random(24).nextInt();
            Main.printGreeting();

            switch (time) {
                case 24:
                    assertTrue(outContent.toString().contains(Main.messages.getString("night")));
                    break;
                case 13:
                    assertTrue(outContent.toString().contains(Main.messages.getString("day")));
                    break;
                case 21:
                    assertTrue(outContent.toString().contains(Main.messages.getString("evening")));
                    break;
                case 8:
                    assertTrue(outContent.toString().contains(Main.messages.getString("morning")));
                    break;
            }

        }
    }
}
