package View;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import View.geniusLabels.GeniusLabels;

public class KeyButtonMaps extends AbstractAction {

    private final JTabbedPane tabbedPane;
    private final GeniusLabels botao;
    private Thread thread;

    public KeyButtonMaps(JTabbedPane tabbedPane, GeniusLabels botao, Thread thread) {
        this.tabbedPane = tabbedPane;
        this.botao = botao;
        this.thread = thread;
    }

    public KeyButtonMaps(JTabbedPane tabbedPane, GeniusLabels botao, JPanel panel) {
        this.tabbedPane = tabbedPane;
        this.botao = botao;
        // this.thread = thread;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            botao.pisca();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
            e1.printStackTrace();
        }
        System.out.println("pisquei");
    }

}