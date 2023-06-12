package View;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import View.geniusLabels.GeniusLabels;

public class KeyButtonMaps extends AbstractAction {

    private final GeniusLabels botao;
    private final TelaJogo teladoJogo;

    public KeyButtonMaps(GeniusLabels botao, TelaJogo telaJogo) {
        this.botao = botao;
        this.teladoJogo = telaJogo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        teladoJogo.getInformacoes(botao);
    }

}