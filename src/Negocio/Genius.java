package Negocio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Enums.Dificuldade;
import Enums.Cor;

public class Genius {
    private Data data;// mudar para tipo para Date;
    private String titulodoCampeonato;
    private Dificuldade dificuldade;
    private List<Jogador> jogadores; // para facilitar a alteracao na quantidade de jogadores
    private List<Integer> sequenciaDeCores;
    private int indexJogadorAtual;
    private int tempoParaReagir; // A definir oq poderia ser considerado facil ou dificil

    public Genius(Data data, String titulodoCampeonato, Dificuldade dificuldade, List<Jogador> jogadores,
            List<Integer> sequenciaDeCores, int indexJogadorAtual, int tempoParaReagir) {
        this.data = data;
        this.titulodoCampeonato = titulodoCampeonato;
        this.dificuldade = dificuldade;
        this.jogadores = jogadores;
        this.sequenciaDeCores = sequenciaDeCores;
        this.indexJogadorAtual = indexJogadorAtual;
        this.tempoParaReagir = tempoParaReagir;
    }

    public Genius(String titulodoCampeonato, Dificuldade dificuldade) {
        data = new Data(LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getMonthValue(),
                LocalDateTime.now().getYear());
        this.titulodoCampeonato = titulodoCampeonato;
        setDificuldade(dificuldade);
        this.jogadores = new ArrayList<Jogador>();
        this.indexJogadorAtual = 0;
        geraSequencia();
    }

    private void setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
        setTempodeReacao(this.dificuldade);
    }

    private void setTempodeReacao(Dificuldade dificuldade) {
        if (dificuldade == Dificuldade.facil) {
            tempoParaReagir = 180000;
            return;
        }
        if (dificuldade == Dificuldade.medio) {
            tempoParaReagir = 3000;
            return;
        }
        if (dificuldade == Dificuldade.dificil) {
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
