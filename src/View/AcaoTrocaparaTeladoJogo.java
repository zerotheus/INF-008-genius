package View;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Negocio.Genius;
import Negocio.GeniusBase;
import Negocio.Jogador;

public class AcaoTrocaparaTeladoJogo extends AbstractAction {

    private final JTabbedPane tabbedPane;
    private final MyJLabelwithSound botao;

    public AcaoTrocaparaTeladoJogo(JTabbedPane tabbedPane, MyJLabelwithSound botao) {
        this.tabbedPane = tabbedPane;
        this.botao = botao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            botao.startSound();
        } catch (Exception e1) {
            System.out.println(e1.toString());
        }
        Genius jogo = new GeniusBase();
        try {
            jogo.setTitulo("Rodada Teste");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Jogador jogador;
        try {
            jogador = new Jogador("Jogador Teste", "Teste");
        } catch (Exception e1) {
            e1.printStackTrace();
            return;
        }
        jogo.adicionaJogador(jogador);
        JPanel teladeJogo = new TelaJogo(tabbedPane, jogo);
        tabbedPane.insertTab("Genius", null, teladeJogo, "Texto", 1);
        tabbedPane.removeTabAt(0);
    }

}