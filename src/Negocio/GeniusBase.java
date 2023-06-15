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
        List<Jogador> empatados = new ArrayList<Jogador>();
        for (int i = 0; i < super.jogadores.size(); i++) {
            if (super.jogadores.get(i).getPontos() == this.maiorPontuacao) {
                empatados.add(jogadores.get(i));
            }
        }
        return new GeniusBase(new Data(), "Desempate " + getTitulodoCampeonato(), super.ritmo, super.dificuldade,
                empatados);
    }

}
