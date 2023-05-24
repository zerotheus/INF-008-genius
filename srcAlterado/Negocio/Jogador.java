package Negocio;

public class Jogador {
	
	private enum estado{
    	jogando("jogando"),
    	perdeu("perdeu"); //para poder verificar se o jogador já perdeu a vez
    	private String valor;
		estado(String valor) {
			this.valor = valor;
		}
    }
	
    private String nome;
    private String apelido;
    private estado status = estado.jogando;
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

    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }

    public int getPontos() {
        return pontos;
    }
    public void pontua() {
    	this.pontos++;
    }
    public void perde() {
    	this.status = estado.perdeu;
    }
    
    public void reiniciaJogador() {
    	this.status = estado.jogando;
    	if(pontos>recordPessoal)
    		recordPessoal = pontos;
    	pontos = 0;
    }
    
    public int getJogadaMaisRapidaEmUnidadedeTempo() {
        return JogadaMaisRapidaEmUnidadedeTempo;
    }

    public int getTempoTotalJogado() {
        return TempoTotalJogado;
    }

}
