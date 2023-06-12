package Negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeniusDificil extends Genius {

    protected GeniusDificil(Data data, String titulodoCampeonato, int ritmo, int dificuldade, List<Jogador> jogadores) {
        super(data, titulodoCampeonato, ritmo, dificuldade, jogadores);
        this.geraSequencia();
    }

    @Override
    public Genius mudaDificuldade() {
        return new GeniusBase(getData(), getTitulodoCampeonato(), super.ritmo, 1, getListaJogadores());
    }

    protected void adicionanaSequencia() {
        Random geraNumeroAleatorio = new Random();
        for (int i = 0; i < 3; i++) {
            this.sequenciaDeCores.add(geraNumeroAleatorio.nextInt(4));
        }
    }

    protected void geraSequencia() {
        Random geraNumeroAleatorio = new Random();
        List<Integer> novaSequencia = new ArrayList<Integer>();
        for (int i = 0; i < geraNumeroAleatorio.nextInt(6); i++) {
            novaSequencia.add(geraNumeroAleatorio.nextInt(4));
        }
        this.sequenciaDeCores = novaSequencia;
        return;
    }
}