package Negocio;

import java.util.ArrayList;
import java.util.List;

public class Genius {
    private int data;// mudar para tipo para Date;
    private String titulodoCampeonato;
    private String difuculdade;
    private List<Jogador> jogadores; // para facilitar a alteracao na quantidade de jogadores
    private List<Integer> sequenciadeCores;
    private int tempoParaReagir; // A definir oq poderia ser considerado facil ou dificil

    public Genius(int data, String titulodoCampeonato, String dificuldade) {
        this.data = data;
        this.titulodoCampeonato = titulodoCampeonato;
        this.difuculdade = dificuldade;
    }

    public void adicionaJogador(Jogador novoJogador) {
        jogadores.add(novoJogador);
        return;
    }

    public boolean analisaJogada() {
        if (pontua()) {
            return true;
        }
        return false;
    }

    public boolean pontua() {
        if (!reagiuemTempo()) {
            return false;
        }
        return acertouaSequencia(0, 0);
    }

    public boolean reagiuemTempo(/* tipo de tempo tempodeReacao */) {
        if (true/* Se reagiu a tempo */) {
            // return true
        }
        return false;
    }

    public boolean acertouaSequencia(int numerodaJogada, int codigodaCor) {

        if (codigodaCor != sequenciadeCores.get(numerodaJogada)) {
            return false;
        }

        return true;
    }

}
