package Negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeniusMedio extends Genius{

    protected GeniusMedio(Data data, String titulodoCampeonato, int ritmo, int dificuldade, List<Jogador> jogadores) {
        super(data, titulodoCampeonato, ritmo, dificuldade, jogadores);
        this.geraSequencia();
    }

    protected void geraSequencia() {
        Random geraNumeroAleatorio = new Random();
        List<Integer> novaSequencia = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            novaSequencia.add(geraNumeroAleatorio.nextInt(4));
        }
        this.sequenciaDeCores = novaSequencia;
        return;
    }

    @Override
    public Genius mudaDificuldade() {
        return new GeniusDificil(getData(), getTitulodoCampeonato(), super.ritmo, this.dificuldade, getListaJogadores());
    }
    
}
