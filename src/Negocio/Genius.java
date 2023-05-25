package Negocio;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Enums.Cor;

public class Genius {
    private Data data;// mudar para tipo para Date;
    private String titulodoCampeonato;
    private String difuculdade;
    private List<Jogador> jogadores; // para facilitar a alteracao na quantidade de jogadores
    private List<Integer> sequenciadeCores;
    private int tempoParaReagir; // A definir oq poderia ser considerado facil ou dificil
    private Clock relogio = Clock.systemDefaultZone();

    public Genius(String titulodoCampeonato, String dificuldade) {
        data = new Data(LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getMonthValue(),
                LocalDateTime.now().getYear());
        this.titulodoCampeonato = titulodoCampeonato;
        this.difuculdade = dificuldade;
    }

    public void adicionaJogador(Jogador novoJogador) {
        jogadores.add(novoJogador);
        return;
    }

    public boolean analisaJogada(Long instantedaReacao, int numerodaJogada, Cor cor) {
        if (!reagiuemTempo(instantedaReacao)) {
            return false;
        }
        acertouaSequencia(numerodaJogada, cor);
        return true;
    }

    public boolean reagiuemTempo(Long instantedaReacao) {
        Long tempoAtual = relogio.millis();
        if (tempoAtual < instantedaReacao) {
            return true;
        }
        return false;
    }

    public Data getData() {
        return this.data;
    }

    private void geraSequenciaInicial() {
        List<Integer> sequenciaInicialdeCores = new ArrayList<Integer>();
        Random numeroAleotoriRandom = new Random();
        for (int i = 0; i < 3; i++) {
            sequenciaInicialdeCores.add(numeroAleotoriRandom.nextInt(4));
        }
    }

    private void adicionanaSequencia() {
        List<Integer> sequenciaInicialdeCores = new ArrayList<Integer>();
        Random numeroAleotoriRandom = new Random();
        sequenciaInicialdeCores.add(numeroAleotoriRandom.nextInt(4));
    }

    public boolean acertouaSequencia(int numerodaJogada, Cor cor) {

        if (cor.ordinal() != sequenciadeCores.get(numerodaJogada)) {
            return false;
        }

        return true;
    }

}
