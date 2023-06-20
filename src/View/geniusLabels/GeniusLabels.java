package View.geniusLabels;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

import Enums.Cor;
import View.MyJLabelwithSound;

public abstract class GeniusLabels extends MyJLabelwithSound {

    private String nomedaImagemBase;
    private final String nomedaImagemBranca;
    private final String arquivoSom;
    private final Cor cor;
    private char keyChar;

    public GeniusLabels(String nomedaImagemBase, String nomedaImagemBranca, String arquivoSom, Cor cor, char keyChar) {
        this.nomedaImagemBase = nomedaImagemBase;
        this.nomedaImagemBranca = nomedaImagemBranca;
        this.arquivoSom = arquivoSom;
        this.cor = cor;
        this.keyChar = keyChar;
    }

    public synchronized void pisca() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String imagensPath = this.getImagesBasePath();
        this.setIcon(new ImageIcon(this.getImagesBasePath() + this.nomedaImagemBranca));
        this.startSound(arquivoSom);
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public synchronized void run() {
                        setIcon(new ImageIcon(imagensPath + nomedaImagemBase));
                    }
                },
                250);
    }

    protected void setImagem(String nomeDaImagem) {
        this.nomedaImagemBase = nomeDaImagem;
        this.setIcon(new ImageIcon(this.getImagesBasePath() + nomedaImagemBase));
    }

    public abstract void setImagemParaRosa();

    public abstract void setImagemPadrao();

    public Cor getCor() {
        return this.cor;
    }

    public char getKeyChar() {
        return keyChar;
    }

}
