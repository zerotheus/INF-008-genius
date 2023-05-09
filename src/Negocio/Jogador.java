package Negocio;

public class Jogador {

    private String nome;
    private String apelido;
    private int pontos;
    private int JogadaMaisRapidaEmUnidadedeTempo;
    private int TempoTotalJogado;

    public Jogador(String nome, String apelido) {
        this.nome = nome;
        this.apelido = apelido;
        this.pontos = 0;
        JogadaMaisRapidaEmUnidadedeTempo = 0;
        TempoTotalJogado = 0;
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

    public int getJogadaMaisRapidaEmUnidadedeTempo() {
        return JogadaMaisRapidaEmUnidadedeTempo;
    }

    public int getTempoTotalJogado() {
        return TempoTotalJogado;
    }

}
