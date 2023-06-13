package Negocio;

import java.util.List;

public class GeniusInfinito extends Genius {

    // private Genius genius; ??

    protected GeniusInfinito(Data data, String titulodoCampeonato, int ritmo, int dificuldade,
            List<Jogador> jogadores) {
        super(data, titulodoCampeonato, ritmo, dificuldade, jogadores);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Genius mudaDificuldade() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mudaDificuldade'");
    }

}
