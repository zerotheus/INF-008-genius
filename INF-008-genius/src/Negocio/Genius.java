package Negocio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Enums.Cor;

public class Genius {
    private Data data;// mudar para tipo para Date;
    private String titulodoCampeonato;
    private int dificuldade;
    private List<Jogador> jogadores; // para facilitar a alteracao na quantidade de jogadores
    private List<Integer> sequenciaDeCores;
    private int indexJogadorAtual;
    private int tempoParaReagir; // A definir oq poderia ser considerado facil ou dificil

    public Genius(Data data, String titulodoCampeonato, int dificuldade, List<Jogador> jogadores,
            List<Integer> sequenciaDeCores, int indexJogadorAtual, int tempoParaReagir) {
        this.data = data;
        this.titulodoCampeonato = titulodoCampeonato;
        this.dificuldade = dificuldade = 0; // 1 easy // 2 medio // 3 dificil
        this.jogadores = jogadores;
        this.sequenciaDeCores = sequenciaDeCores;
        this.indexJogadorAtual = indexJogadorAtual;
        this.tempoParaReagir = tempoParaReagir;
    }

    public Genius(String titulodoCampeonato, int dificuldade) {
        data = new Data(LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getMonthValue(),
                LocalDateTime.now().getYear());
        this.titulodoCampeonato = titulodoCampeonato;
        setDificuldade(1);
        this.jogadores = new ArrayList<Jogador>();
        this.indexJogadorAtual = 0;
        geraSequencia();
    }

    public void setDificuldade(int mudanca) {
        if (mudanca + this.dificuldade < 1 || mudanca + this.dificuldade > 3) {
            return;
        }
        this.dificuldade += mudanca;
        setTempodeReacao(this.dificuldade);
    }

    private void setTempodeReacao(int dificuldade) {
        if (dificuldade == 1) {
            tempoParaReagir = 180000;
            return;
        }
        if (dificuldade == 2) {
            tempoParaReagir = 3000;
            return;
        }
        if (dificuldade == 3) {
            tempoParaReagir = 1000;
            return;
        }
    }

    public Data getData() {
        return this.data;
    }

    public Jogador getJogadorAtual() {
        return jogadores.get(indexJogadorAtual);
    }

    public String getTitulodoCampeonato() {
        return this.titulodoCampeonato;
    }

    private void alteraJogadorAtual() {
        if (this.indexJogadorAtual < this.jogadores.size()) {
            geraSequencia();
            this.indexJogadorAtual++;
        }
    }

    public void adicionaJogador(Jogador novoJogador) {
        jogadores.add(novoJogador);
        return;
    }

    private void pontua(int numeroDaJogada) {
        this.jogadores.get(this.indexJogadorAtual).pontua(numeroDaJogada);
    }

    public boolean analisaJogada(Long instantedaExibicao, Long instantedaReacao, int numeroDaJogada, Cor jogada) {
        if (!reagiuEmTempo(instantedaExibicao, instantedaReacao)) {
            this.alteraJogadorAtual();
            return false;
        }

        return acertouaSequencia(numeroDaJogada, jogada);
    }

    private boolean reagiuEmTempo(Long instantedaExibicao, Long instantedaReacao) {
        if (instantedaExibicao + tempoParaReagir > instantedaReacao) {
            return true;
        }
        return false;
    }

    private boolean acertouaSequencia(int numerodaJogada, Cor cor) {

        if (cor.ordinal() != this.sequenciaDeCores.get(numerodaJogada)) {
            this.alteraJogadorAtual();
            return false;
        }
        if (numerodaJogada == this.sequenciaDeCores.size()) {
            pontua(numerodaJogada);
            adicionanaSequencia();
        }

        return true;
    }

    private void geraSequencia() {
        Random geraNumeroAleatorio = new Random();
        List<Integer> novaSequencia = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            novaSequencia.add(geraNumeroAleatorio.nextInt(4));
        }
        this.sequenciaDeCores = novaSequencia;
        return;
    }

    private void adicionanaSequencia() {
        Random geraNumeroAleatorio = new Random();
        this.sequenciaDeCores.add(geraNumeroAleatorio.nextInt(4));
    }

}
