package View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTabbedPane;

import View.geniusLabels.GeniusLabels;

public class AcaodoGenius extends MouseAdapter {

    private GeniusLabels botao;
    private TelaJogo teladoJogo;

    AcaodoGenius(GeniusLabels botao, TelaJogo teladoJogo) {
        this.teladoJogo = teladoJogo;
        this.botao = botao;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() != this.botao) {
            return;
        }
        teladoJogo.getInformacoes(this.botao);
    }

}
