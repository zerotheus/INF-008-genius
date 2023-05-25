package View;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

import Enums.Cor;

public class App {
    public static void main(String[] args) throws Exception {
        Clock clock = Clock.systemDefaultZone();
        Calendar datadodia = Calendar.getInstance(TimeZone.getTimeZone("GMT-3"));

        System.out.println("Antes" + clock.millis() % 10000);
        long x = clock.millis() % 10000 + 1000;
        Clock relogio = clock.systemDefaultZone();
        System.out.println(LocalDateTime.now().getYear()/* relogio.millis() % 10000 + ">?" + x */);
        System.out.println(Cor.getCor(0));
        // System.out.println(Cor.valueOf(Integer.toString(2)));
        /*
         * while (clock.millis() <= x) {
         * System.out.println(clock.millis());
         * }
         */
        // System.out.println();
    }
}
