package Negocio;

public class Jogador {

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

    public void setNome(String nome) throws Exception {
        if (nome.length() < 2) {
            throw new Exception("Nome tem de ter pelo menos 3 caracteres");
        }
        this.nome = nome;
    }

    public void setApelido(String apelido) throws Exception {
        if (apelido.length() < 3) {
            throw new Exception("Apelido tem de ter pelo menos 3 caracteres");
        }
        this.apelido = apelido;
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
