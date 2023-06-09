package View;

import javax.swing.ImageIcon;

public class GeniusLabels extends MyJLabelwithSound {

    private final String nomedaImagemBase;
    private final String nomedaImagemBranca;

    public GeniusLabels(String nomedaImagemBase, String nomedaImagemBranca) {
        this.nomedaImagemBase = nomedaImagemBase;
        this.nomedaImagemBranca = nomedaImagemBranca;
    }

    public void pisca() {
        String imagensPath = this.getImagesBasePath();
        this.setIcon(new ImageIcon(this.getImagesBasePath() + this.nomedaImagemBranca));
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        setIcon(new ImageIcon(imagensPath + nomedaImagemBase));
                    }
                },
                250);
    }

}
