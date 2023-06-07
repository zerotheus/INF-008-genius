package Negocio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Enums.Cor;

public class Genius {
    private Data data;// mudar para tipo para Date;
    private String titulodoCampeonato;
    private int ritmo;
    private int dificuldade;
    private List<Jogador> jogadores; // para facilitar a alteracao na quantidade de jogadores
    private List<Integer> sequenciaDeCores;
    private int indexJogadorAtual;
    private int indexdaJogadaAtual;
    private int tempoParaReagir; // A definir oq poderia ser considerado facil ou dificil

    public Genius(Data data, String titulodoCampeonato, int ritmo, List<Jogador> jogadores,
            List<Integer> sequenciaDeCores, int indexJogadorAtual, int tempoParaReagir, int indexdaJogadaAtual) {
        this.data = data;
        this.titulodoCampeonato = titulodoCampeonato;
        this.setRitmo(ritmo); // 1 lento // 2 cadenciado // 3 rapido
        this.jogadores = jogadores;
        this.sequenciaDeCores = sequenciaDeCores;
        this.indexJogadorAtual = indexJogadorAtual;
        this.tempoParaReagir = tempoParaReagir;
    }

    public Genius(String titulodoCampeonato) {
        data = new Data(LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getMonthValue(),
                LocalDateTime.now().getYear());
        this.titulodoCampeonato = titulodoCampeonato;
        setRitmo(1);
        this.jogadores = new ArrayList<Jogador>();
        this.indexJogadorAtual = 0;
        geraSequencia();
    }

    public void setRitmo(int mudanca) {
        if (mudanca + this.ritmo < 1 || mudanca + this.ritmo > 3) {
            return;
        }
        this.ritmo += mudanca;
        setTempodeReacao(this.ritmo);
    }

    private void setTempodeReacao(int ritmo) {
        if (ritmo == 1) {
            tempoParaReagir = 180000;
            return;
        }
        if (ritmo == 2) {
            tempoParaReagir = 3000;
            return;
        }
        if (ritmo == 3) {
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
        if (this.indexJogadorAtual + 1 < this.jogadores.size()) {
            geraSequencia();
            this.indexdaJogadaAtual = 0;
            this.indexJogadorAtual++;
        }
    }

    public void adicionaJogador(Jogador novoJogador) {
        jogadores.add(novoJogador);
        return;
    }

    private void pontua() {
        this.jogadores.get(this.indexJogadorAtual).pontua(this.indexdaJogadaAtual);
    }

    public boolean analisaJogada(Long instantedaExibicao, Long instantedaReacao, Cor jogada) {
        if (!reagiuEmTempo(instantedaExibicao, instantedaReacao)) {
            this.alteraJogadorAtual();
            return false;
        }

        return acertouaSequencia(jogada);
    }

    private boolean reagiuEmTempo(Long instantedaExibicao, Long instantedaReacao) {
        if (instantedaExibicao + tempoParaReagir > instantedaReacao) {
            return true;
        }
        return false;
    }

    private boolean acertouaSequencia(Cor cor) {

        if (cor.ordinal() != this.sequenciaDeCores.get(this.indexdaJogadaAtual)) {
            this.alteraJogadorAtual();
            this.indexdaJogadaAtual = 0;
            return false;
        }
        if (this.indexdaJogadaAtual + 1 == this.sequenciaDeCores.size()) {
            pontua();
            this.indexdaJogadaAtual = 0;
            adicionanaSequencia();
            return true;
        }
        this.indexdaJogadaAtual++;
        return true;
    }

    private void geraSequencia() {
        Random geraNumeroAleatorio = new Random();
        List<Integer> novaSequencia = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            novaSequencia.add(geraNumeroAleatorio.nextInt(4));
            System.out.println(novaSequencia.get(i));
        }
        this.sequenciaDeCores = novaSequencia;
        return;
    }

    private void adicionanaSequencia() {
        Random geraNumeroAleatorio = new Random();
        this.sequenciaDeCores.add(geraNumeroAleatorio.nextInt(4));
        System.out.println(this.sequenciaDeCores.get(this.sequenciaDeCores.size() - 1));
    }

}
