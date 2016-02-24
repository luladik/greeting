package com.madislav;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainTest {

    @Test
    public void testInitLocale() {
        Locale locale = new Locale("ru", "RU");
        Assert.assertEquals(locale.toString(), "ru_RU");
        locale = new Locale("en", "US");
        Assert.assertEquals(locale.toString(), "en_US");
    }

    @Test(expected = ParseException.class)
    public void testPrintGreeting() throws ParseException {

        new SimpleDateFormat("HH:mm").parse("20 00");

    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

}
