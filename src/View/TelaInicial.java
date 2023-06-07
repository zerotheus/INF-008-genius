package View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TelaInicial extends MyJPanel {
    private JLabel lbltelaFundo;

    public TelaInicial(JTabbedPane tabbedPane) {

        this.setLayout(null);

        MyJLabelwithSound lblbutao = new MyJLabelwithSound();
        lblbutao.setIcon(
                new ImageIcon(this.getImagesPath() + "botão iniciar.png"));
        lblbutao.setBounds(587, 573, 276, 117);
        this.add(lblbutao);
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
    }

}
