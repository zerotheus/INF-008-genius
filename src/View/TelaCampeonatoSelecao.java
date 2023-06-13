package View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TelaCampeonatoSelecao extends MyJPanel {
    private JLabel lblTeladeFundo;

    public TelaCampeonatoSelecao(JTabbedPane tabbedPane) {
        super();

        JLabel lbl2Jogadores = new JLabel("");
        lbl2Jogadores.setIcon(new ImageIcon(this.getImagesPath() + "2 jogadores.png"));
        lbl2Jogadores.setBounds(263, 583, 264, 95);
        this.add(lbl2Jogadores);

        lbl2Jogadores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                JPanel novoJPanel = new TelaCadastro(tabbedPane, 2);
                tabbedPane.insertTab("jogadoresCadastro", null, novoJPanel, TOOL_TIP_TEXT_KEY, 1);
                tabbedPane.removeTabAt(0);

            }
        });

        JLabel lbl4Jogadores = new JLabel("");
        lbl4Jogadores.setIcon(new ImageIcon(this.getImagesPath() + "4 jogadores.png"));
        lbl4Jogadores.setBounds(578, 583, 264, 95);
        this.add(lbl4Jogadores);

        lbl4Jogadores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                JPanel novoJPanel = new TelaCadastro(tabbedPane, 4);
                tabbedPane.insertTab("jogadoresCadastro", null, novoJPanel, TOOL_TIP_TEXT_KEY, 1);
                tabbedPane.removeTabAt(0);

            }
        });

        JLabel lbl8Jogadores = new JLabel("");
        lbl8Jogadores.setIcon(new ImageIcon(this.getImagesPath() + "8 jogadores.png"));
        lbl8Jogadores.setBounds(894, 583, 264, 95);
        this.add(lbl8Jogadores);

        lbl8Jogadores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                JPanel novoJPanel = new TelaCadastro(tabbedPane, 8);
                tabbedPane.insertTab("jogadoresCadastro", null, novoJPanel, TOOL_TIP_TEXT_KEY, 1);
                tabbedPane.removeTabAt(0);

            }
        });

        MyJLabelwithSound lblVoltar = new MyJLabelwithSound();
        lblVoltar.setIcon(new ImageIcon(this.getImagesPath() + "botaoVoltar.png"));
        lblVoltar.setBounds(650, 795, 106, 53);
        lblVoltar.setVisible(true);
        this.add(lblVoltar);

        lblVoltar.addMouseListener(new MouseAdapter() { // colocar som ao clicar o botão
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() != lblVoltar) {
                    return;
                }
                try {
                    lblVoltar.startSound();
                } catch (Exception e1) {
                    System.out.println(e.toString());
                }
                lblVoltar.setEnabled(false);
                lblVoltar.setVisible(false);
                JPanel teladeMododeJogo = new TeladeSelecaoModo(tabbedPane);
                tabbedPane.insertTab("Selecione o modo de Jogo", null, teladeMododeJogo, TOOL_TIP_TEXT_KEY, 1);
                tabbedPane.removeTabAt(0);

            }
        });

        lblTeladeFundo = new JLabeldateladeFundo();
        this.add(lblTeladeFundo);

    }
}
