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
        Locale locale = Main.locale;
        if (Locale.getDefault().toString().equals("en_US"))
            assertEquals(locale, new Locale.Builder().setLanguage("en").setRegion("US").build());
        if (Locale.getDefault().toString().equals("ru_RU"))
            assertEquals(locale, new Locale.Builder().setLanguage("ru").setRegion("RU").build());
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
