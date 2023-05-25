package Negocio;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Enums.Dificuldade;
import Enums.Cor;

public class Genius {
    private Data data;// mudar para tipo para Date;
    private String titulodoCampeonato;
    private Dificuldade difuculdade;
    private List<Jogador> jogadores; // para facilitar a alteracao na quantidade de jogadores
    private List<Integer> sequenciaDeCores;
    private int indexJogadorAtual;
    private int tempoParaReagir; // A definir oq poderia ser considerado facil ou dificil
    private Clock relogio = Clock.systemDefaultZone();

    public Genius(String titulodoCampeonato, Dificuldade dificuldade) {
        data = new Data(LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getMonthValue(),
                LocalDateTime.now().getYear());
        this.titulodoCampeonato = titulodoCampeonato;
        this.difuculdade = dificuldade;
    }

    public Genius(Data data, String titulodoCampeonato, Dificuldade difuculdade, List<Jogador> jogadores,
            List<Integer> sequenciaDeCores, int indexJogadorAtual, int tempoParaReagir, Clock relogio) {
        this.data = data;
        this.titulodoCampeonato = titulodoCampeonato;
        this.difuculdade = difuculdade;
        this.jogadores = jogadores;
        this.sequenciaDeCores = sequenciaDeCores;
        this.indexJogadorAtual = indexJogadorAtual;
        this.tempoParaReagir = tempoParaReagir;
        this.relogio = relogio;
    }

    public void adicionaJogador(Jogador novoJogador) {
        jogadores.add(novoJogador);
        return;
    }

    public Jogador getJogadorAtual() {
        return jogadores.get(indexJogadorAtual);
    }

    public boolean analisaJogada(Long instantedaReacao, int numeroDaJogada, Cor jogada) {
        if (!reagiuEmTempo(instantedaReacao)) {
            return false;
        }

        return acertouaSequencia(numeroDaJogada, jogada);
    }

    public boolean reagiuEmTempo(Long instantedaReacao) {
        Long tempoAtual = relogio.millis();
        if (tempoAtual < instantedaReacao) {
            return true;
        }
        return false;
    }

    public Data getData() {
        return this.data;
    }

    public boolean acertouSequencia(Cor jogada, int numeroDaJogada) {
        if (jogada.ordinal() != sequenciaDeCores.get(numeroDaJogada)) {
            return false;
        }
        return true;
    }

    private void adicionaSequencia() {
        Random numeroAleotoriRandom = new Random();
        this.sequenciaDeCores.add(numeroAleotoriRandom.nextInt(4));
    }

    public boolean acertouaSequencia(int numerodaJogada, Cor cor) {

        if (cor.ordinal() != this.sequenciaDeCores.get(numerodaJogada)) {
            return false;
        }

        return true;
    }

}
