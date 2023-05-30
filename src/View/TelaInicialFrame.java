package View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaInicialFrame extends JFrame {

    private String basePath;

    TelaInicialFrame() {
        basePath = new File("").getAbsolutePath() + "\\";
        final String teladeFundoPath = this.basePath + new File("src/imagens/tela.png").getPath();
        JLabel lbltelaFundo = new JLabel("");
        lbltelaFundo
                .setIcon(new ImageIcon(teladeFundoPath));
        lbltelaFundo.setBounds(0, 0, 1451, 884);
        this.getContentPane().add(lbltelaFundo);

        final String botaoIniciarPath = this.basePath + new File("src/imagens/botão iniciar.png").getPath();

        JLabel lblbutao = new JLabel("AAAAAAAA");
        lblbutao.setIcon(
                new ImageIcon("C:\\Users\\Mathe\\Desktop\\Vsprojects\\GeniusPOO\\src\\imagens\\Salvar.png"));
        lblbutao.setBounds(587, 573, 276, 117);
        this.getContentPane().add(lblbutao);

        lblbutao.addMouseListener(new MouseAdapter() { // colocar som ao clicar o botão
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() != lblbutao) {
                    return;
                }
                lblbutao.setEnabled(false);
                // lblbutao.setVisible(false);
                System.out.println("click");
                /*
                 * lblCampeonato.setEnabled(true);
                 * lblCampeonato.setVisible(true);
                 * lblindividual.setEnabled(true);
                 * lblindividual.setVisible(true);
                 */
            }
        });
    }

}
