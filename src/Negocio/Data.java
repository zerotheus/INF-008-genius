package Negocio;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Data implements Serializable {
    private int dia;
    private int mes;
    private int ano;

    public Data() {
        this.dia = LocalDateTime.now().getDayOfMonth();
        this.mes = LocalDateTime.now().getMonthValue();
        this.ano = LocalDateTime.now().getYear();
    }

    @Override
    public String toString() {
        return "Data: " + dia + "/" + mes + "/" + ano;
    }

}
