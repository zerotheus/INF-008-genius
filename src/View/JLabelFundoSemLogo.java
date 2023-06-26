package View;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelFundoSemLogo extends JLabel {
    private final String basePath;
    private final String imagesBasePath;

    public JLabelFundoSemLogo() {
        this.basePath = new File("").getAbsolutePath() + "\\";
        // recebe um diretorio através do "", e pega toda string do caminho e add
        this.imagesBasePath = new File("src\\imagens").getPath() + "\\";
        this.setIcon(new ImageIcon(this.imagesBasePath + "fundo sem logo.png"));
        // devolve o arquivo de imagem que tem o caminho e nome da string
        this.setBounds(0, 0, 1451, 884);
    }
    /* Classe criada para o fundo sem o logo do jogo */
}
