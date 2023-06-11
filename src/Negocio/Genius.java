package Negocio;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Enums.Cor;

public class Genius implements Serializable {
    private Data data;// mudar para tipo para Date;
    private String titulodoCampeonato;
    private int ritmo;
    private List<Jogador> jogadores; // para facilitar a alteracao na quantidade de jogadores
    private List<Integer> sequenciaDeCores;
    private int indexJogadorAtual;
    private int indexdaJogadaAtual = 0;
    private int tempoParaReagir; // A definir oq poderia ser considerado facil ou dificil

    public Genius(Data data, String titulodoCampeonato, int ritmo, List<Jogador> jogadores,
            List<Integer> sequenciaDeCores, int indexJogadorAtual, int tempoParaReagir) {
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

    public void setTitulo(String tituloNovo) {
        this.titulodoCampeonato = tituloNovo;
    }

    public void setRitmo(int mudanca) {
        if (mudanca + this.ritmo < 1 || mudanca + this.ritmo > 3) {
            this.ritmo = 0;
        }
        this.ritmo += mudanca;
        System.out.println(this.ritmo);
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
        if (jogoEstaAtivo()) {
            jogadores.get(indexJogadorAtual);
        }
        return jogadores.get(indexJogadorAtual - 1);
    }

    public int qtdJogadores() {
        return this.jogadores.size();
    }

    public List<Jogador> getListaJogadores() {
        return List.copyOf(this.jogadores);
    }

    public List<Integer> getSequencia() {
        return this.sequenciaDeCores;
    }

    public String getTitulodoCampeonato() {
        return this.titulodoCampeonato;
    }

    private void alteraJogadorAtual() {
        if (this.indexJogadorAtual + 1 < this.jogadores.size()) {
            geraSequencia();
            this.indexdaJogadaAtual = 0;
            this.indexJogadorAtual++;
            return;
        }
        this.encerraJogo();
        return;
    }

    private void encerraJogo() {
        indexJogadorAtual++;
    }

    public boolean jogoEstaAtivo() {
        if (indexJogadorAtual == this.jogadores.size()) {
            return false;
        }
        return true;
    }

    public boolean ehUltimaJogaga() {
        System.out.println("sequenciaDeCores.size(): " + sequenciaDeCores.size());
        if (this.indexdaJogadaAtual == sequenciaDeCores.size() - 1) {
            return true;
        }
        return false;
    }

    public void adicionaJogador(Jogador novoJogador) {
        jogadores.add(novoJogador);
        return;
    }

    private void pontua() {
        this.jogadores.get(this.indexJogadorAtual).pontua(this.indexdaJogadaAtual);
    }

    public boolean analisaJogada(Long instantedaExibicao, Long instantedaReacao, Cor jogada) {
        if (!jogoEstaAtivo()) {
            return false;
        }
        this.getJogadorAtual().foiJogadaMaisRapida(instantedaExibicao - instantedaReacao);

        if (!reagiuEmTempo(instantedaExibicao, instantedaReacao)) {
            this.alteraJogadorAtual();
            System.out.println("perdeu!");
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
            System.out.println("perdeu!");
            return false;
        }
        if (this.indexdaJogadaAtual + 1 == this.sequenciaDeCores.size()) {
            pontua();
            this.indexdaJogadaAtual = 0;
            adicionanaSequencia();
            System.out.println("Acertou");
            return true;
        }
        System.out.println("Acertou");
        this.indexdaJogadaAtual++;
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
        System.out.println(this.sequenciaDeCores.get(this.sequenciaDeCores.size() - 1));
    }

}
