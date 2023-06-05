package View;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Negocio.Genius;

public class TelaPlacar extends MyJPanel {
    public TelaPlacar(JTabbedPane tabbedPane, Genius jogo) {
        this.setLayout(null);

        List<JLabel> labeldosJogadores = new ArrayList<JLabel>();
        labeldosJogadores.add(new JLabel(jogo.getJogadorAtual().getApelido()));
        labeldosJogadores.get(0).setBounds(164, 200, 200, 35);
        this.add(labeldosJogadores.get(0));
        JLabel lblDataJogo = new JLabel(jogo.getData().toString());
        lblDataJogo.setForeground(new Color(255, 255, 255));
        lblDataJogo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 22));
        lblDataJogo.setBounds(675, 10, 180, 48);
        this.add(lblDataJogo);

        JLabel lblTituloJogo = new JLabel(jogo.getTitulodoCampeonato());
        lblTituloJogo.setForeground(new Color(255, 255, 255));
        lblTituloJogo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 22));
        lblTituloJogo.setBounds(675, 65, 640, 48);
        this.add(lblTituloJogo);

        JLabel lblFundoJogo = new JLabel("");
        lblFundoJogo.setIcon(new ImageIcon(this.getImagesPath() + "tela placar.png"));
        lblFundoJogo.setBounds(0, 0, 1444, 881);
        this.add(lblFundoJogo);

        JLabel lblVoltar = new JLabel("");
        lblVoltar.setIcon(new ImageIcon(this.getImagesPath() + "botao voltar.png"));
        lblVoltar.setBounds(680, 771, 133, 68);
        lblVoltar.setVisible(true);

    }
}
