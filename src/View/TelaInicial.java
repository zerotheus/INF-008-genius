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

        lbltelaFundo = new JLabeldateladeFundo();
        this.add(lbltelaFundo);

        lblbutao.addMouseListener(new MouseAdapter() { 
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
                JPanel teladeMododeJogo = new TeladeSelecaoModo(tabbedPane);
                tabbedPane.insertTab("Selecione o modo de Jogo", null, teladeMododeJogo, TOOL_TIP_TEXT_KEY, 1);
                tabbedPane.removeTabAt(0);
            }
        });/*Innerclass que adiciona interação de click ao botão, muda de tela, remove a atual e inicia som */

        lblbutao.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('.'), "A");
        lblbutao.getActionMap().put("A", new AcaoTrocaparaTeladoJogo(tabbedPane, lblbutao));

    }

}
