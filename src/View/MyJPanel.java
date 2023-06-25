package View;

import java.io.File;
import javax.swing.JPanel;

public abstract class MyJPanel extends JPanel {

    private final String basePath;
    private final String imagesBasePath;

    protected MyJPanel() {
        this.imagesBasePath = new File("src\\imagens").getPath() + "\\";
        this.basePath = new File("").getAbsolutePath() + "\\";
        this.setLayout(null);
    } 

    protected String getImagesPath() {
        return this.imagesBasePath;
    }

    protected String getBasePath() {
        return this.basePath;
    }
/* Essa classe foi criada para instanciar MYJapanel e começar com layout definido e um caminho para as imagens*/
}
