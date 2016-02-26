package com.madislav;

import org.apache.log4j.Logger;

import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class);
    public static ResourceBundle messages;
    private static Locale locale;

    public static void initLocale() {

        locale = Locale.getDefault();
        log.info("System locale: " + locale);
        messages = ResourceBundle.getBundle("messages", locale);

    }

    public static void printGreeting() {

            int now = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            log.info("Current date initialized");

            if (now >= 6 && now < 9) {
                System.out.println(messages.getString("morning"));
            } else if (now >= 9 && now < 19) {
                System.out.println(messages.getString("day"));
            } else if (now >= 19 && now < 23) {
                System.out.println(messages.getString("evening"));
            } else
                System.out.println(messages.getString("night"));
    }

    public static void main(String[] args) {

        initLocale();
        printGreeting();

        log.info("END");

    }
}
