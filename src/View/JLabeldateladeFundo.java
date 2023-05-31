package View;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabeldateladeFundo extends JLabel {

    private final String basePath;
    private final String imagesBasePath;

    JLabeldateladeFundo() {

        basePath = new File("").getAbsolutePath() + "\\";
        imagesBasePath = basePath + new File("src\\imagens").getPath() + "\\";
        this.setIcon(new ImageIcon(this.imagesBasePath + "tela.png"));
        this.setBounds(0, 0, 1451, 884);
    }

}
