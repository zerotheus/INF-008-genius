package Negocio;

import java.util.ArrayList;
import java.util.List;

public class GeniusBase extends Genius {

    ic Geni super();
    }/* Construtor para inicializar o modo */

    protected GeniusBase(Data data, String titulodoCampeonato, int ritmo, int dificuldade, List<Jogador> jogadores) {
        super(data, titulodoCampeonato, ritmo, dificuldade, jogadores);
        setDificuldade(1);
        this.geraSequencia();
    }/* Construtor que inicia o modo com os dados salvos */

    @Override
    public Genius mudaDificuldade() {
        return new GeniusMedio(getData(), getTitulodoCampeonato(), super.ritmo, this.dificuldade, getListaJogadores());
    }/* Método que muda a dificuldade para médio */

    
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
/*
      * função que faz uma lista com os jogadores que tiveram empate e retorna um
      * novo jogo para desempate com os empatados
      */

    @Override
    public void ativaDesativaTreino() throws Exception {
        if (this.jogoEstaAtivo() || sequenciaDeCores.size() > 1) {
            throw new Exception("Nao é possivel iniciar o Treino com Rodada iniciada");
        }
        if (mododeTreinoAtivo) {// ativo
            mododeTreinoAtivo = false;
            geraSequencia();
            return;
        }
        geraSequencia();
        mododeTreinoAtivo = true;// quando esta desativo
    }
    
}

