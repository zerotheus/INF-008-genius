package View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TeladeSelecaoModo extends JPanel {

    private final String basePath;
    private final String imagesBasePath;
    private JLabel lblTeladeFundo;

    public TeladeSelecaoModo(JTabbedPane tabbedPane) {
        this.setLayout(null);
        basePath = new File("").getAbsolutePath() + "\\";
        imagesBasePath = basePath + new File("src\\imagens").getPath() + "\\";
        lblTeladeFundo = new JLabeldateladeFundo();

        JLabel lblCampeonato = new JLabel();
        lblCampeonato.setEnabled(true);
        lblCampeonato.setIcon(
                new ImageIcon(this.imagesBasePath + "VARIOS JOGADORES.png"));
        lblCampeonato.setBounds(759, 573, 264, 95);
        lblCampeonato.setVisible(true);
        this.add(lblCampeonato);

        JLabel lblindividual = new JLabel();
        lblindividual.setEnabled(true);
        lblindividual.setIcon(
                new ImageIcon(this.imagesBasePath + "SOLO BOTAO.png"));
        lblindividual.setBounds(406, 573, 264, 95);
        lblindividual.setVisible(true);
        this.add(lblindividual);
        this.add(lblTeladeFundo);

        lblindividual.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                JPanel novoJPanel = new JPanel();
                tabbedPane.insertTab("Individual", null, novoJPanel, TOOL_TIP_TEXT_KEY, 1);
                tabbedPane.removeTabAt(0);
            }
        });

    }

}
