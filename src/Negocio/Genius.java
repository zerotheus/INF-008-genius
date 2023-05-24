package Negocio;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import enums.*;


public class Genius {
    private Data data;// mudar para tipo para Date;
    private String titulodoCampeonato;
    private Dificuldade difuculdade;
    private List<Jogador> jogadores; // para facilitar a alteracao na quantidade de jogadores
    private List<Integer> sequenciaDeCores;
    private int indexJogadorAtual;
    private int tempoParaReagir; // A definir oq poderia ser considerado facil ou dificil
    private Clock relogio = Clock.systemDefaultZone();

    public Genius(String titulodoCampeonato, Dificuldade dificuldade) {
        data = new Data(LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getMonthValue(),
                LocalDateTime.now().getYear());
        this.titulodoCampeonato = titulodoCampeonato;
        this.difuculdade = dificuldade;
    }
    
    public void adicionaJogador(Jogador novoJogador) {
        jogadores.add(novoJogador);
        return;
    }
    public Jogador getJogadorAtual() {
    	return jogadores.get(indexJogadorAtual);
    }
    
    
    public boolean analisaJogada(Long instantedaReacao, int numeroDaJogada, Cor jogada) {
        if (!reagiuEmTempo(instantedaReacao)) {
            return false;
        }
        acertouSequencia(jogada, numeroDaJogada);
        return true;
    }

    public boolean reagiuEmTempo(Long instantedaReacao) {
        Long tempoAtual = relogio.millis();
        if (tempoAtual < instantedaReacao) {
            return true;
        }
        return false;
    }

    public Data getData() {
        return this.data;
    }

    @SuppressWarnings("unlikely-arg-type")
	public void acertouSequencia(Cor jogada, int numeroDaJogada) {
 	   if((jogada.equals(sequenciaDeCores.get(numeroDaJogada)))) {
 		  jogadores.get(indexJogadorAtual).pontua();
 	   }else
 		   perde();
    }

    @SuppressWarnings("unused")
	private void adicionaSequencia() {
        Random numeroAleotoriRandom = new Random();
        sequenciaDeCores.add(numeroAleotoriRandom.nextInt(4));
    }

    public boolean perde() {
    	if(indexJogadorAtual == jogadores.size()) {
    		return false;
    	}else {
    		indexJogadorAtual++;
    		return true;
    	}
    }

}
