package Negocio;

import java.io.Serializable;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import Enums.Cor;

public abstract class Genius implements Serializable {
    private Data data;
    private String titulodoCampeonato;
    protected int ritmo;
    protected int dificuldade;
    protected List<Jogador> jogadores; // para facilitar a alteracao na quantidade de jogadores
    protected List<Integer> sequenciaDeCores;
    private int indexJogadorAtual;
    private int indexdaJogadaAtual = 0;
    protected int maiorPontuacao;
    private int tempoParaReagir;
    private final Clock clock = Clock.systemDefaultZone();
    private long instantedaUltimaReacaodoJogadorAtual;
    private boolean instanteValidado;
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

    }/*
      * construtor que inicializa o jogo mantendo as informações principais do jogo
      * já salvo
      */

    protected Genius() {
        data = new Data();
        this.setRitmo();
        this.jogadores = new ArrayList<Jogador>();
        this.indexJogadorAtual = 0;
        this.instantedaUltimaReacaodoJogadorAtual = 0;
        this.instanteValidado = false;
        this.geraSequencia();
    }/* Construtor utilizado para inicializar o jogo a primeira vez */

    public void setTitulo(String tituloNovo) throws Exception {
        if (tituloNovo.length() < 3)
            throw new Exception("Titulo deve ter mais de 2 letras");
        this.titulodoCampeonato = tituloNovo;
    }/*
      * método que define um titulo para o jogo e alança uma exceção se tiver menos
      * que 2 letras
      */

    public void setRitmo() {
        if (this.ritmo < 1 || this.ritmo > 2) {
            this.ritmo = 0;
        }
        this.ritmo++;
        setTempodeReacao(this.ritmo);
    }/* Método que muda o ritmo do jogo e muda o tempo de reação */

    protected void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }/* Método que muda o valor da dificuldade do jogo */

    public String getDificuldade() {
        return Integer.toString(this.dificuldade);
    }/* método que retorna o valor da dificuldade como string. */

    public String getRitmo() {
        return Integer.toString(ritmo);
    }/* método que retorna o valor do ritmo como string */

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
    }/*
      * método que modifica o tempo que o jogador tem para reagir ao clicar o botão
      * de acordo com o ritmo que foi passado como parâmetro.
      */

    public Data getData() {
        return this.data;
    }/* método que retorna a data do jogo */

    public Jogador getJogadorAtual() {
        if (!jogofoiEncerrado()) {
            return jogadores.get(indexJogadorAtual);
        }
        return jogadores.get(indexJogadorAtual - 1);
    }/* Método para pegar o jogador atual da rodada */

    public int qtdJogadores() {
        return this.jogadores.size();
    }/* Método que retorna o tamanho da lista de jogadores do campeonato */

    public List<Jogador> getListaJogadores() {
        return List.copyOf(this.jogadores);
    }/* Método que retorna uma cópia da lista de jogadores */

    public List<Jogador> getVencedores() {
        List<Jogador> ordenadosPorPontos = this.jogadores;
        Collections.sort(ordenadosPorPontos);
        return ordenadosPorPontos;
    }/* Método que retorna os jogadores ordenado por pontos */

    public List<Integer> getSequencia() {
        return this.sequenciaDeCores;
    }/* Método que retorna a lista da sequencia dos botões do jogo */

    public String getTitulodoCampeonato() {
        return this.titulodoCampeonato;
    }/* Método que retorna o titulo do campeonato */

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
    }/*
      * Método que altera o jogador atual se não estiver no modo treinio, e verifica
      * se o jogador que perdeu tem a maior
      * pontuação, reseta o instante da sequencia e finaliza a rodada, encerra o jogo
      * caso não tenha mais jogadores
      */

    private void validaInstante() {
        this.instanteValidado = true;
    }/* Método que valida o ultimo instante */

    private void invalidaInstante() {
        this.instanteValidado = false;
    }/* Método que invalida tempo do ultimo instante apertado pelo jogadodor */

    private void encerraJogo() {
        indexJogadorAtual++;
    }/* muda para o próximo jogador caso o ultimo perder */

    public boolean jogofoiEncerrado() {
        if (indexJogadorAtual == this.jogadores.size()) {
            return true;
        }
        return false;
    }/* retorna se o jogo foi encerrado */

    public boolean jogoEstaAtivo() {
        return this.aRodadaFoiIniciada;
    }/* retorna se a rodada foi iniciada */

    public boolean ehUltimaJogada() {
        System.out.println("sequenciaDeCores.size(): " + sequenciaDeCores.size());
        if (this.indexdaJogadaAtual == sequenciaDeCores.size() - 1) {
            return true;
        }
        return false;
    }/* retorna se a jogada é a ultima jogada da sequencia */

    public void adicionaJogador(Jogador novoJogador) {
        jogadores.add(novoJogador);
        return;
    }/* Método que adiciona novos jogadores na lista */

    private void pontua() {
        this.jogadores.get(this.indexJogadorAtual).pontua(this.indexdaJogadaAtual);
    }/* Método que chama o método de pontuar do jogador atual */

    public boolean analisaJogada(Long instantedaExibicao, Cor jogada) throws Exception {
        if (titulodoCampeonato == null) {
            throw new Exception("O jogo quer um titulo");
        }
        if (this.qtdJogadores() == 0) {
            throw new Exception("Jogo requer jogadores");
        }
        if (jogofoiEncerrado()) {
            return false;
        }
        if (!reagiuEmTempo(instantedaExibicao)) {
            this.alteraJogadorAtual();
            System.out.println("perdeu!");
            return false;
        }
        return acertouaSequencia(jogada);
    }/* Método que retorna se o jogador acertou a sequencia dentro do tempo */

    private boolean reagiuEmTempo(Long instantedaExibicao) {
        final Long instantedeReacao = clock.millis();
        System.out.println(tempoParaReagir);
        if (!instanteValidado) {// se nao esta valido
            if (instantedaExibicao + tempoParaReagir > instantedeReacao) {
                instantedaUltimaReacaodoJogadorAtual = instantedeReacao;
                validaInstante();
                this.getJogadorAtual().foiJogadaMaisRapida(instantedeReacao - instantedaExibicao);
                return true;
            }
        } // verifica se o instante da ultima jogada não foi resetado, depois compara os
          // instantes se reagiu em tempo, valida o instante
          // e verifica se fiu a jogada mais rápida
        if (instantedaUltimaReacaodoJogadorAtual + tempoParaReagir > instantedeReacao) {
            instantedaUltimaReacaodoJogadorAtual = instantedeReacao;
            this.getJogadorAtual().foiJogadaMaisRapida(instantedeReacao - instantedaExibicao);
            return true;
        } // faz a mesma coisa soq com o instante não resetado.
        return false;
    }/* Método que verifica se o jogador reagiu em tempo */

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
    }/*
      * Método que retorna se o jogador acertou a cor da sequencia e também pontua
      * caso acerte e não seja modo treino
      */

    protected void geraSequencia() {
        Random geraNumeroAleatorio = new Random();
        List<Integer> novaSequencia = new ArrayList<Integer>();
        novaSequencia.add(geraNumeroAleatorio.nextInt(4));
        this.sequenciaDeCores = novaSequencia;
        return;
    }/*
      * Método que gera numeros aleátorios entre 0 e 3 na primeira rodada de cada
      * jogador
      */

    protected void adicionanaSequencia() {
        Random geraNumeroAleatorio = new Random();
        this.sequenciaDeCores.add(geraNumeroAleatorio.nextInt(4));
    }/*
      * Método que gera numeros aleátorios entre 0 e 3 e guarda na lista
      * sequenciaDeCores caso você acerte, cada cor representa um numero
      */

    private boolean ehAmaiorPontuacao() {
        final int pontuacaodoJogoador = this.getJogadorAtual().getPontos();
        if (pontuacaodoJogoador > maiorPontuacao) {
            maiorPontuacao = pontuacaodoJogoador;
            return true;
        }
        return false;
    }/* Método que verifica se a pontuação do jogador é a maior */

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
    }/*
      * método que verifica se os pontos dos jogadores são iguais se sim ele ordena e
      * retorna que há empate
      */

    public void ativaDesativaTreino() throws Exception {
        if (this.jogoEstaAtivo() || sequenciaDeCores.size() > 3) {
            throw new Exception("Nao é possivel iniciar o Treino com Rodada iniciada");
        }
        if (mododeTreinoAtivo) {// ativo
            mododeTreinoAtivo = false;
            geraSequencia();
            return;
        }
        geraSequencia();
        mododeTreinoAtivo = true;// quando esta desativo
    }/* Método para ativar ou desativar o modo treino e gerar uma nova sequencia */

    public boolean ehmododeTreino() {
        return this.mododeTreinoAtivo;
    }/* Método retorna se está no modo treino */

    public void inciaRodada() {
        this.aRodadaFoiIniciada = true;
    }/* Método que diz que a rodada foi iniciada */

    private void finalizaRodada() {
        this.aRodadaFoiIniciada = false;
    }/* Método que diz que a rodada foi finalizada */

    public abstract Genius mudaDificuldade();/* Método que retorna um jogo de acordo com a dificuldade */

    public abstract Genius getRodadadeDesempate() throws Exception; /* Método que retorna um jogo de desempate */

}
