package Negocio;

import java.io.Serializable;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import Enums.Cor;

public abstract class Genius implements Serializable {
    private Data data;// mudar para tipo para Date;
    private String titulodoCampeonato;
    protected int ritmo;
    protected int dificuldade;
    protected List<Jogador> jogadores; // para facilitar a alteracao na quantidade de jogadores
    protected List<Integer> sequenciaDeCores;
    private int indexJogadorAtual;
    private int indexdaJogadaAtual = 0;
    protected int maiorPontuacao;
    private int tempoParaReagir; // A definir oq poderia ser considerado facil ou dificil
    private final Clock clock = Clock.systemDefaultZone();
    private long instantedaUltimaReacaodoJogadorAtual;
    private boolean oinstanteEstaValido;
    private boolean mododeTreinoAtivo = false;
    private boolean aRodadaFoiIniciada = false;

    protected Genius(Data data, String titulodoCampeonato, int ritmo, int dificuldade, List<Jogador> jogadores) {
        this.data = data;
        this.titulodoCampeonato = titulodoCampeonato;
        this.ritmo = ritmo;
        setTempodeReacao(ritmo);
        this.dificuldade = dificuldade;
        this.jogadores = jogadores;
        geraSequencia();

    }

    public Genius(String titulodoCampeonato) {
        data = new Data();
        this.titulodoCampeonato = titulodoCampeonato;
        this.setRitmo();
        this.jogadores = new ArrayList<Jogador>();
        this.indexJogadorAtual = 0;
        this.instantedaUltimaReacaodoJogadorAtual = 0;
        this.oinstanteEstaValido = false;
        this.setDificuldade();
        this.geraSequencia();
    }

    public void setTitulo(String tituloNovo) {
        this.titulodoCampeonato = tituloNovo;
    }

    public void setRitmo() {
        if (this.ritmo < 1 || this.ritmo > 2) {
            this.ritmo = 0;
        }
        this.ritmo++;
        System.out.println(this.ritmo);
        setTempodeReacao(this.ritmo);
    }

    public void setDificuldade() {
        if (this.dificuldade < 1 || this.dificuldade > 2) {
            this.dificuldade = 0;
        }
        this.dificuldade++;
    }

    public String getDificuldade() {
        return Integer.toString(this.dificuldade);
    }

    public String getRitmo() {
        return Integer.toString(ritmo);
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
        if (!jogofoiEncerado()) {
            return jogadores.get(indexJogadorAtual);
        }
        return jogadores.get(indexJogadorAtual - 1);
    }

    public int qtdJogadores() {
        return this.jogadores.size();
    }

    public List<Jogador> getListaJogadores() {
        return List.copyOf(this.jogadores);
    }

    public List<Jogador> getVencedores() {
        final List<Jogador> ordenadosPorPontos = getListaJogadores();
        Collections.sort(ordenadosPorPontos);
        return ordenadosPorPontos;
    }

    public List<Integer> getSequencia() {
        return this.sequenciaDeCores;
    }

    public String getTitulodoCampeonato() {
        return this.titulodoCampeonato;
    }

    private void alteraJogadorAtual() {
        if (mododeTreinoAtivo) {
            return;
        }
        this.ehAmaiorPontuacao();
        this.invalidaInstante();
        this.finalizaRodada();
        if (this.indexJogadorAtual + 1 < this.jogadores.size()) {
            geraSequencia();
            this.indexdaJogadaAtual = 0;
            this.indexJogadorAtual++;
            return;
        }
        this.encerraJogo();
        return;
    }

    private void validaInstante() {
        this.oinstanteEstaValido = true;
    }

    private void invalidaInstante() {
        this.oinstanteEstaValido = false;
    }

    private void encerraJogo() {
        indexJogadorAtual++;
    }

    public boolean jogofoiEncerado() {
        if (indexJogadorAtual == this.jogadores.size()) {
            return true;
        }
        return false;
    }

    public boolean jogoEstaAtivo() {
        return this.aRodadaFoiIniciada;
    }

    public boolean ehUltimaJogada() {
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

    public boolean analisaJogada(Long instantedaExibicao, Cor jogada) {
        if (!jogofoiEncerado()) {
            return false;
        }
        if (!reagiuEmTempo(instantedaExibicao)) {
            this.alteraJogadorAtual();
            System.out.println("perdeu!");
            return false;
        }
        return acertouaSequencia(jogada);
    }

    private boolean reagiuEmTempo(Long instantedaExibicao) {
        final Long instantedeReacao = clock.millis();
        System.out.println(tempoParaReagir);
        if (!oinstanteEstaValido) {// se nao esta valido
            if (instantedaExibicao + tempoParaReagir > instantedeReacao) {
                instantedaUltimaReacaodoJogadorAtual = instantedeReacao;
                validaInstante();
                this.getJogadorAtual().foiJogadaMaisRapida(instantedeReacao - instantedaExibicao);
                return true;
            }
        }
        if (instantedaUltimaReacaodoJogadorAtual + tempoParaReagir > instantedeReacao) {
            instantedaUltimaReacaodoJogadorAtual = instantedeReacao;
            this.getJogadorAtual().foiJogadaMaisRapida(instantedeReacao - instantedaExibicao);
            return true;
        }
        return false;
    }

    private boolean acertouaSequencia(Cor cor) {
        System.out.println(sequenciaDeCores);
        if (cor.ordinal() != this.sequenciaDeCores.get(this.indexdaJogadaAtual)) {
            this.alteraJogadorAtual();
            this.indexdaJogadaAtual = 0;
            System.out.println("Sequencia");
            return false;
        }
        if (!ehmododeTreino()) {
            pontua();
        }
        if (this.indexdaJogadaAtual + 1 == this.sequenciaDeCores.size()) {
            this.indexdaJogadaAtual = 0;
            adicionanaSequencia();
            System.out.println("invalidaInstante");
            this.invalidaInstante();
            return true;
        }
        System.out.println("Acertou");
        this.indexdaJogadaAtual++;
        return true;
    }

    protected void geraSequencia() {
        Random geraNumeroAleatorio = new Random();
        List<Integer> novaSequencia = new ArrayList<Integer>();
        for (int i = 0; i < 1; i++) {
            novaSequencia.add(geraNumeroAleatorio.nextInt(4));
        }
        this.sequenciaDeCores = novaSequencia;
        return;
    }

    protected void adicionanaSequencia() {
        Random geraNumeroAleatorio = new Random();
        this.sequenciaDeCores.add(geraNumeroAleatorio.nextInt(4));
        System.out.println(this.sequenciaDeCores.get(this.sequenciaDeCores.size() - 1));
    }

    private boolean ehAmaiorPontuacao() {
        final int pontuacaodoJogoador = this.getJogadorAtual().getPontos();
        if (pontuacaodoJogoador > maiorPontuacao) {
            maiorPontuacao = pontuacaodoJogoador;
            return true;
        }
        return false;
    }

    public boolean temEmpate() {
        int contaMaiorPontucao = 0;
        for (int i = 0; i < jogadores.size(); i++) {
            if (jogadores.get(i).getPontos() == this.maiorPontuacao) {
                contaMaiorPontucao++;
            }
        }
        if (contaMaiorPontucao > 1) {
            Collections.sort(jogadores);
            return true;
        }
        return false;
    }

    public void ativaDesativaTreino() {
        if (mododeTreinoAtivo) {// ativo
            mododeTreinoAtivo = false;
            geraSequencia();
            return;
        }
        geraSequencia();
        mododeTreinoAtivo = true;// quando esta desativo
    }

    public boolean ehmododeTreino() {
        return this.mododeTreinoAtivo;
    }

    public void inciaRodada() {
        this.aRodadaFoiIniciada = true;
    }

    private void finalizaRodada() {
        this.aRodadaFoiIniciada = false;
    }

    public abstract Genius mudaDificuldade();

    public abstract Genius getRodadadeDesempate() throws Exception;

}
