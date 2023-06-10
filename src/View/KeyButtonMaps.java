package View;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTabbedPane;

public class KeyButtonMaps extends AbstractAction {

    private final JTabbedPane tabbedPane;
    private final GeniusLabels botao;
    private MyJPanel panel;

    KeyButtonMaps(JTabbedPane tabbedPane, GeniusLabels botao, MyJPanel panel) {
        this.tabbedPane = tabbedPane;
        this.botao = botao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.botao.pisca();
    }

}
