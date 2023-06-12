package View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

public class TelaInicial extends MyJPanel {
    private JLabel lbltelaFundo;

    public TelaInicial(JTabbedPane tabbedPane) {

        MyJLabelwithSound lblbutao = new MyJLabelwithSound();
        lblbutao.setIcon(
                new ImageIcon(this.getImagesPath() + "botão iniciar.png"));
        lblbutao.setBounds(587, 573, 276, 117);
        this.add(lblbutao);

        MyJLabelwithSound lblFechar = new MyJLabelwithSound();
        lblFechar.setIcon(new ImageIcon(this.getImagesPath() + "botaoVoltar.png"));
        lblFechar.setBounds(650, 795, 106, 53);
        lblFechar.setVisible(true);
        this.add(lblFechar);

        lbltelaFundo = new JLabeldateladeFundo();
        this.add(lbltelaFundo);

        lblbutao.addMouseListener(new MouseAdapter() { // colocar som ao clicar o botão
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() != lblbutao) {
                    return;
                }
                try {
                    lblbutao.startSound();
                } catch (Exception e1) {
                    System.out.println(e.toString());
                }
                lblbutao.setEnabled(false);
                lblbutao.setVisible(false);
                JPanel teladeMododeJogo = new TeladeSelecaoModo(tabbedPane);
                tabbedPane.insertTab("Selecione o modo de Jogo", null, teladeMododeJogo, TOOL_TIP_TEXT_KEY, 1);
                tabbedPane.removeTabAt(0);
            }
        });

        lblbutao.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('.'), "A");
        lblbutao.getActionMap().put("A", new AcaoTrocaparaTeladoJogo(tabbedPane, lblbutao));

        lblFechar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() != lblFechar) {
                    return;
                }
                try {
                    lblFechar.startSound();
                } catch (Exception e1) {
                    System.out.println(e1.toString());
                }

                System.exit(0);

            }
        });

    }

}
