package Negocio;

import java.io.Serializable;
import java.util.List;

public class GeniusBase extends Genius implements Serializable{

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
    
}
