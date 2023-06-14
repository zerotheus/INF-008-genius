package Negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeniusMedio extends Genius {

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
    protected void adicionanaSequencia() {
        Random geraNumeroAleatorio = new Random();
        for (int i = 0; i < 3; i++) {
            this.sequenciaDeCores.add(geraNumeroAleatorio.nextInt(4));
        }
        System.out.println(this.sequenciaDeCores.get(this.sequenciaDeCores.size() - 1));
    }

    @Override
    public Genius mudaDificuldade() {
        setDificuldade();
        return new GeniusDificil(getData(), getTitulodoCampeonato(), super.ritmo, this.dificuldade,
                getListaJogadores());
    }

    @Override
    public Genius getRodadadeDesempate() throws Exception {
        if (!temEmpate()) {
            throw new Exception("Nao ha empate");
        }
        int i = 0;
        List<Jogador> empatados = new ArrayList<Jogador>();
        while (super.jogadores.get(i).getPontos() == maiorPontuacao) {
            empatados.add((jogadores.get(i)));
        }
        return new GeniusBase(new Data(), getTitulodoCampeonato(), super.ritmo, super.dificuldade, empatados);
    }

}
