package View;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        String path = new File("").getCanonicalPath() + "\\";// forma de pegar o caminho relativo para o
                                                             // diretorio;
        String teladeFundoPath = new File("src/imagens/tela.png").getCanonicalPath();

        String resultado = teladeFundoPath.replace("\\", "\\\\");
        System.out.println(resultado);
    }
}
