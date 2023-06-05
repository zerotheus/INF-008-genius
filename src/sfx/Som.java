import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Som {

	private String soundName;    
	private AudioInputStream audioInputStream;
	private Clip clip;
	
	//soundName = new File("INF-008-genius-caian\\src\\sfx").getAbsolutePath() + "\\MenuBotao.wav";
	
	
	/*try {
					audioInputStream = AudioSystem.getAudioInputStream(new File((soundName)));//"/sfx/MenuBotão.wav"
				} catch (UnsupportedAudioFileException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					clip = AudioSystem.getClip();
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					clip.open(audioInputStream);
				} catch (LineUnavailableException | IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				clip.start();
				
		*/
}
