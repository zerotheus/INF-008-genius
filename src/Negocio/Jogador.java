package Negocio;

public class Jogador {

    private String nome;
    private String apelido;
    private int pontos;
    private int JogadaMaisRapidaEmUnidadedeTempo;
    private int TempoTotalJogado;
    private int recordPessoal;

    public Jogador(String nome, String apelido) {
        this.nome = nome;
        this.apelido = apelido;
        this.pontos = 0;
        JogadaMaisRapidaEmUnidadedeTempo = 0;
        TempoTotalJogado = 0;
        recordPessoal = 0;
    }

    public Jogador(String nome, String apelido, int pontos, int jogadaMaisRapidaEmUnidadedeTempo, int tempoTotalJogado,
            int recordPessoal) {
        this.nome = nome;
        this.apelido = apelido;
        this.pontos = pontos;
        JogadaMaisRapidaEmUnidadedeTempo = jogadaMaisRapidaEmUnidadedeTempo;
        TempoTotalJogado = tempoTotalJogado;
        this.recordPessoal = recordPessoal;
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

    public int getJogadaMaisRapidaEmUnidadedeTempo() {
        return JogadaMaisRapidaEmUnidadedeTempo;
    }

    public int getTempoTotalJogado() {
        return TempoTotalJogado;
    }

    public int getrecordPessoal() {
        return this.recordPessoal;
    }

}
