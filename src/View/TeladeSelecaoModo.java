package View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TeladeSelecaoModo extends MyJPanel {

    private JLabel lblTeladeFundo;

    public TeladeSelecaoModo(JTabbedPane tabbedPane) {
        super();
        this.setLayout(null);
        lblTeladeFundo = new JLabeldateladeFundo();

        JLabel lblCampeonato = new JLabel();
        lblCampeonato.setEnabled(true);
        lblCampeonato.setIcon(
                new ImageIcon(this.getImagesPath() + "VARIOS JOGADORES.png"));
        lblCampeonato.setBounds(759, 573, 264, 95);
        lblCampeonato.setVisible(true);
        this.add(lblCampeonato);

        JLabel lblindividual = new JLabel();
        lblindividual.setEnabled(true);
        lblindividual.setIcon(
                new ImageIcon(this.getImagesPath() + "SOLO BOTAO.png"));
        lblindividual.setBounds(406, 573, 264, 95);
        lblindividual.setVisible(true);
        this.add(lblindividual);
        this.add(lblTeladeFundo);

        lblindividual.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                JPanel novoJPanel = new TelaIndividual(tabbedPane);
                tabbedPane.insertTab("Individual", null, novoJPanel, TOOL_TIP_TEXT_KEY, 1);
                tabbedPane.removeTabAt(0);

            }
        });

        lblCampeonato.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                JPanel novoJPanel = new TelaCampeonatoSelecao(tabbedPane);
                tabbedPane.insertTab("CampeonatoSelecao", null, novoJPanel, TOOL_TIP_TEXT_KEY, 1);
                tabbedPane.removeTabAt(0);
            }

        });

    }

}
