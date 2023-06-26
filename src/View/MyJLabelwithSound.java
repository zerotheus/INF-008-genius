package View;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;

public class MyJLabelwithSound extends JLabel {

    private final String sfxBotaoMenuBasePath;
    private final String imagesBasePath;
    private AudioInputStream audioInputStream;
    private Clip clip;

    public MyJLabelwithSound() {
        this.sfxBotaoMenuBasePath = new File("src\\sfx").getPath() + "\\";
        this.imagesBasePath = new File("src\\imagens").getPath() + "\\";
    }/* Construtor para definir o som e a imagem */

    protected void startSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        audioInputStream = AudioSystem.getAudioInputStream(new File((this.sfxBotaoMenuBasePath + "MenuBotao.Wav")));
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }/*Método que pega o arquivo áudio abre e executa */

    protected void startSound(String nomedoArquivo)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(new File((this.sfxBotaoMenuBasePath + nomedoArquivo)));
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }/*Método que pega o arquivo áudio abre e executa */

    public String getImagesBasePath() {
        return imagesBasePath;
    }/*Retorna o caminho da imagem */

}
