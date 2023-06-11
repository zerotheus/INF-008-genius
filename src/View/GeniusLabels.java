package View;

import javax.swing.ImageIcon;

public class GeniusLabels extends MyJLabelwithSound implements Runnable {

    private final String nomedaImagemBase;
    private final String nomedaImagemBranca;
    

    public GeniusLabels(String nomedaImagemBase, String nomedaImagemBranca) {
        this.nomedaImagemBase = nomedaImagemBase;
        this.nomedaImagemBranca = nomedaImagemBranca;
    }

    public synchronized void pisca() {
        String imagensPath = this.getImagesBasePath();
        this.setIcon(new ImageIcon(this.getImagesBasePath() + this.nomedaImagemBranca));
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public synchronized void run() {
                        setIcon(new ImageIcon(imagensPath + nomedaImagemBase));
                    }
                },
                250);
    }

    @Override
    public void run() {
        String imagensPath = this.getImagesBasePath();
        this.setIcon(new ImageIcon(this.getImagesBasePath() + this.nomedaImagemBranca));
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public synchronized void run() {
                        setIcon(new ImageIcon(imagensPath + nomedaImagemBase));
                    }
                },
                250);
        System.out.println("a");
    }

}
