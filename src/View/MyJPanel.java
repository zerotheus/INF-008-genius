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
    private final String sfxBotaoMenuBasePath;
    private AudioInputStream audioInputStream;
	private Clip clip;

    protected MyJPanel() {
        this.imagesBasePath = new File("src\\imagens").getPath() + "\\";
        this.sfxBotaoMenuBasePath = new File("src\\sfx").getPath() +"\\MenuBotao.Wav";
        this.basePath = new File("").getAbsolutePath() + "\\";
        
    }
    
    protected void StartSound(String URL) {
    	try {
			audioInputStream = AudioSystem.getAudioInputStream(new File((URL)));//"/sfx/MenuBotão.wav" 
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1 ) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		clip.start();
    }
    protected void StopSound() {
    	clip.stop();
    	clip.close();
    }

    protected String getImagesPath() {
        return this.imagesBasePath;
    }

    protected String getBasePath() {
        return this.basePath;
    }

}
