package Negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeniusDificil extends Genius {

    protected GeniusDificil(Data data, String titulodoCampeonato, int ritmo, int dificuldade, List<Jogador> jogadores) {
        super(data, titulodoCampeonato, ritmo, dificuldade, jogadores);
        setDificuldade(3);
        this.geraSequencia();
    }

    @Override
    public Genius mudaDificuldade() {
        return new GeniusBase(getData(), getTitulodoCampeonato(), super.ritmo, 1, getListaJogadores());
    }

    protected void adicionanaSequencia() {
        Random geraNumeroAleatorio = new Random();
        for (int i = 0; i < geraNumeroAleatorio.nextInt(3) + 3; i++) {
            this.sequenciaDeCores.add(geraNumeroAleatorio.nextInt(4));
        }
    }/* Método que adiciona a sequencia do jogo na lista */

    protected void geraSequencia() {
        Random geraNumeroAleatorio = new Random();
        List<Integer> novaSequencia = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            novaSequencia.add(geraNumeroAleatorio.nextInt(4));
        }
        this.sequenciaDeCores = novaSequencia;
        return;
    }/* método q gera sequencia de 3 numeros */

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