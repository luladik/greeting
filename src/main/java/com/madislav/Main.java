package com.madislav;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class);
    private static ResourceBundle messages;
    private static Locale locale;

    private static void initLocale() {

            locale = Locale.getDefault();
            log.info("System locale: " + locale);

            messages = ResourceBundle.getBundle("messages", locale);

    }

    public static void printGreeting() {
        try {
            SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
            Date now = parser.parse(parser.format(new Date()));
            log.info("Current date initialized");

            if (parser.parse("06:00").before(now) && parser.parse("09:00").after(now)) {
                System.out.println(messages.getString("morning"));
            } else if (parser.parse("09:00").before(now) && parser.parse("19:00").after(now)) {
                System.out.println(messages.getString("day"));
            } else if (parser.parse("19:00").before(now) && parser.parse("23:00").after(now)) {
                System.out.println(messages.getString("evening"));
            } else
                System.out.println(messages.getString("night"));
        } catch (ParseException e) {
            log.log(Level.ERROR, "Exception in greeting method: ", e);
        }

    }

    public static void main(String[] args) {

        initLocale();
        printGreeting();

        log.info("END");

    }
}
