package Negocio;

import java.io.Serializable;

public class Jogador implements Comparable<Jogador>, Serializable {

    private String nome;
    private String apelido;
    private int pontos;
    private Long jogadaMaisRapidaEmUnidadedeTempo;
    private long tempoInicio;
    private long tempoTotal;
    private int recordPessoal;
    private int pontosganhosnaUltimaRodada = 0;

    public Jogador(String nome, String apelido) throws Exception {
        this.setNome(nome);
        this.setApelido(apelido);
        this.pontos = 0;
        jogadaMaisRapidaEmUnidadedeTempo = Long.MAX_VALUE;
        this.tempoInicio = 0;
        recordPessoal = 0;
    }/*Construtor do jogador */

    public void setNome(String nome) throws Exception {
        if (nome.length() < 2) {
            throw new Exception("Nome tem de ter pelo menos 3 caracteres");
        }
        this.nome = nome;
    }/*Método que coloca o nome do jogador e lança uma exception caso o nome tenha menos que 3 caracteres */

    public void setApelido(String apelido) throws Exception {
        if (apelido.length() < 3) {
            throw new Exception("Apelido tem de ter pelo menos 3 caracteres");
        }
        this.apelido = apelido;
    }/*Método para colocar o apelido do jogador lança uma exception caso o apelido tenha menos que 3 caracteres  */

    public void setTempoInicial() {
        if (this.tempoInicio != 0) {
            return;
        }
        this.tempoInicio = System.currentTimeMillis();
    }/*Método que pega o tempo de inicio do jogo do jogador */

    public void setTempoTotal() {
        this.tempoTotal = System.currentTimeMillis() - this.tempoInicio;
    }/*coloca o tempo total de jogo do jogador */

    public long getTempoTotal() {
        return this.tempoTotal / 1000;
    }/*retorna o tempo total do jogador */

    public String getNome() {
        return nome;
    }/* retorna nome do jogador */

    public String getApelido() {
        return apelido;
    }/* retorna apelido do jogador */

    public int getPontos() {
        return pontos;
    }/* retorna os pontos do jogador */

    public void pontua(int pontos) {
        setPontosGanhosnaUltimaRodada(pontos);
        this.pontos += pontos;
    }/*adiciona pontos */

    private void setPontosGanhosnaUltimaRodada(int pontosGanhos) {
        this.pontosganhosnaUltimaRodada = pontosGanhos;
    }/* guarda os pontos que o jogador ganhou na rodada anterior */

    public int getPontosFeitosnaUltimaRodada() {
        return pontosganhosnaUltimaRodada;
    }/*retorna os pontos ganhos na rodada anterior */

    public long getJogadaMaisRapidaEmUnidadedeTempo() {
        return jogadaMaisRapidaEmUnidadedeTempo;
    }/*retorna a jogada mais rápida */

    public void foiJogadaMaisRapida(Long jogada) {
        if (this.jogadaMaisRapidaEmUnidadedeTempo == null) {
            this.jogadaMaisRapidaEmUnidadedeTempo = jogada;
            return;
        }
        if (this.jogadaMaisRapidaEmUnidadedeTempo > jogada) {
            this.jogadaMaisRapidaEmUnidadedeTempo = jogada;
        }
    }/*método que compara as jogadas e coloca a mais rápida */

    public int getrecordPessoal() {
        return this.recordPessoal;
    }/*retorna o record do jogador */

    @Override
    public int compareTo(Jogador outroJogador) {
        if (this.pontos > outroJogador.pontos) {
            return 1;
        }
        if (this.pontos < outroJogador.pontos) {
            return -1;
        }
        return 0;
    }/*Método que compara os pontos do jogador com outro jogador */

}