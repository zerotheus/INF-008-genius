package Negocio;

import java.io.Serializable;

public class Jogador implements Serializable{

    private String nome;
    private String apelido;
    private int pontos;
    private long JogadaMaisRapidaEmUnidadedeTempo;
    private int TempoTotalJogado;
    private int recordPessoal;

    public Jogador(String nome, String apelido) throws Exception {
        this.setNome(nome);
        this.setApelido(apelido);
        this.pontos = 0;
        JogadaMaisRapidaEmUnidadedeTempo = 0;
        TempoTotalJogado = 0;
        sequenciaMaisLongadeAcertos = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }

    public int getPontos() {
        return pontos;
    }

    public void pontua(int pontos) {
        this.pontos += pontos;
    }

    public long getJogadaMaisRapidaEmUnidadedeTempo() {
        return JogadaMaisRapidaEmUnidadedeTempo;
    }

    public void foiJogadaMaisRapida( Long jogada){
    if (JogadaMaisRapidaEmUnidadedeTempo > jogada){
    JogadaMaisRapidaEmUnidadedeTempo = jogada;
    }
    }

    public int getTempoTotalJogado() {
        return TempoTotalJogado;
    }

    public int getrecordPessoal() {
        return this.recordPessoal;
    }

}
