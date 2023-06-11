package View;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractAction;
import javax.swing.JTabbedPane;

import View.geniusLabels.GeniusLabels;

public class KeyButtonMaps extends AbstractAction {

    private final JTabbedPane tabbedPane;
    private final GeniusLabels botao;
    private Thread thread;

    KeyButtonMaps(JTabbedPane tabbedPane, GeniusLabels botao, MyJPanel panel) {
        this.tabbedPane = tabbedPane;
        this.botao = botao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.botao.pisca();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
            e1.printStackTrace();
        }
        System.out.println("pisquei");
    }

}
