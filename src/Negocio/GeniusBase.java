package Negocio;

import java.util.ArrayList;
import java.util.List;

public class GeniusBase extends Genius {

    public GeniusBase(String titulodoCampeonato) {
        super(titulodoCampeonato);
    }

    protected GeniusBase(Data data, String titulodoCampeonato, int ritmo, int dificuldade, List<Jogador> jogadores) {
        super(data, titulodoCampeonato, ritmo, dificuldade, jogadores);
        this.geraSequencia();
    }

    @Override
    public Genius mudaDificuldade() {
        setDificuldade();
        return new GeniusMedio(getData(), getTitulodoCampeonato(), super.ritmo, this.dificuldade, getListaJogadores());
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
