package Negocio;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

import Exception.CorNaoExisteException;
import Exception.DificuldadeNaoExisteException;

public class Genius {
    private Data data;// mudar para tipo para Date;
    private String titulodoCampeonato;
    private dificuldade dificuldadeJogo;
    private List<Jogador> jogadores; // para facilitar a alteracao na quantidade de jogadores
    private List<cor> sequenciaDeCores;
    private static int corAtualDaSequencia; //pra localizar fácil na lista de cores a jogada atual
    private static int indexJogadorAtual;
    private int tempoParaReagir; // A definir oq poderia ser considerado facil ou dificil
    
    private enum dificuldade{
    	facil("facil"),
    	medio("medio"),
    	dificil("dificil");
    	private String valor;
    	dificuldade(String valor) {
    		this.valor = valor;
    	}
    	public String getValor() {
    		return valor;
    	}
    	public static dificuldade findByValue(String valor) throws DificuldadeNaoExisteException  { 
    		dificuldade result = null;
    	    for (dificuldade dificuldade : values()) {
    	        if (dificuldade.getValor().equalsIgnoreCase(valor)) {
    	            result = dificuldade;
    	            break;
    	        }else
    	        	throw new DificuldadeNaoExisteException();
    	    }
    	    return result;
    	}
    }
    private enum cor{
    	vermelho("vermelho"),
    	azul("azul"),
    	amarelo("amarelo"),
    	verde("verde");
    	private String valor;
    	cor(String valor){
    		this.valor = valor;
    	}
    	public String getValor() {
    		return valor;
    	}
    	public static cor findByValue(String valor) throws CorNaoExisteException  { 
    		cor result = null;
    	    for (cor cor : values()) {
    	        if (cor.getValor().equalsIgnoreCase(valor)) {
    	            result = cor;
    	            break;
    	        }else
    	        	throw new CorNaoExisteException();
    	    }
    	    return result;
    	}
    }
    public Genius(String titulodoCampeonato, String dif) throws DificuldadeNaoExisteException {
        data = new Data(LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getMonthValue(),
                LocalDateTime.now().getYear());
        this.titulodoCampeonato = titulodoCampeonato;
        this.dificuldadeJogo = dificuldade.findByValue(dif);
    }

    
    public void adicionaJogador(Jogador novoJogador) {
        jogadores.add(novoJogador);
        return;
    }
    
    public boolean reagiuEmTempo(/* tipo de tempo tempodeReacao */) {
        if (true/* Se reagiu a tempo */) {
            // return true
        }
        return false;
    }

    public void acertouSequencia(cor jogada) {
    	
	   if((jogada.equals(sequenciaDeCores.get(corAtualDaSequencia)))&&(reagiuEmTempo() == true)) {
		  jogadores.get(indexJogadorAtual).pontua();
	   }else
		   jogadores.get(indexJogadorAtual).perde();
   }
    
    
    public Data geData() {
        return this.data;
    }

   

}
