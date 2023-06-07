package View;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

public abstract class MyJPanel extends JPanel {

    private final String basePath;
    private final String imagesBasePath;

    protected MyJPanel() {
        this.imagesBasePath = new File("src\\imagens").getPath() + "\\";
        this.basePath = new File("").getAbsolutePath() + "\\";

    }

    protected String getImagesPath() {
        return this.imagesBasePath;
    }

    protected String getBasePath() {
        return this.basePath;
    }

}
