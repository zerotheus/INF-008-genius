package View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class TelaJogo extends JPanel {
    private final String basePath;
    private final String imagesBasePath;


    public TelaJogo() {
        this.basePath = " ";
        this.imagesBasePath = " ";

        JLabel lblAzul = new JLabel("");
		lblAzul.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblAzul.setIcon(new ImageIcon("C:\\Users\\Alana\\Downloads\\azul branco.png"));			
			}
		});
		
		lblAzul.setIcon(new ImageIcon("C:\\Users\\Alana\\Downloads\\azul.png"));
		lblAzul.setBounds(447, 78, 322, 316);
		this.add(lblAzul);
		
		JLabel lblVermelho = new JLabel("");
		lblVermelho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblVermelho.setIcon(new ImageIcon("C:\\Users\\Alana\\Downloads\\vermelho branco.png"));
			}
		});
		lblVermelho.setIcon(new ImageIcon("C:\\Users\\Alana\\Downloads\\vermelho 1.png"));
		lblVermelho.setBounds(447, 474, 311, 316);
		this.add(lblVermelho);
		
		JLabel lblAmarelo = new JLabel("");
		lblAmarelo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblAmarelo.setIcon(new ImageIcon("C:\\Users\\Alana\\Downloads\\amarelo branco.png"));
			}
		});
		lblAmarelo.setIcon(new ImageIcon("C:\\Users\\Alana\\Downloads\\amarelo 1.png"));
		lblAmarelo.setBounds(807, 78, 322, 321);
		this.add(lblAmarelo);
		
		JLabel lblVerde = new JLabel("");
		lblVerde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblVerde.setIcon(new ImageIcon("C:\\Users\\Alana\\Downloads\\verde branco.png"));
			}
		});
		lblVerde.setIcon(new ImageIcon("C:\\Users\\Alana\\Downloads\\verde 1.png"));
		lblVerde.setBounds(800, 474, 329, 316);
		this.add(lblVerde);
		
		JButton btnDificuldade = new JButton("");
		btnDificuldade.setBounds(714, 405, 44, 45);
		this.add(btnDificuldade);
		btnDificuldade.setVisible(false);
		
		JButton btnCarregar = new JButton("");
		btnCarregar.setBounds(1223, 720, 164, 57);
		this.add(btnCarregar);
		btnCarregar.setVisible(false);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setBounds(1223, 405, 173, 57);
		this.add(btnSalvar);
		btnSalvar.setVisible(false);
		
		JButton btnIniciar = new JButton("");
		btnIniciar.setBounds(1223, 89, 173, 57);
		this.add(btnIniciar);
		btnIniciar.setVisible(false);
		
		JLabel lblPontos = new JLabel("");
		lblPontos.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 34));
		lblPontos.setForeground(new Color(255, 255, 255));
		lblPontos.setBounds(175, 589, 67, 57);
		this.add(lblPontos);
		
		JLabel lblNomeJogador = new JLabel("");
		lblNomeJogador.setForeground(new Color(255, 255, 255));
		lblNomeJogador.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 22));
		lblNomeJogador.setBounds(95, 221, 241, 39);
		this.add(lblNomeJogador);
		
		JLabel lblFundoJogo = new JLabel("");
		lblFundoJogo.setIcon(new ImageIcon("C:\\Users\\Alana\\Downloads\\fundojOGO.png"));
		lblFundoJogo.setBounds(0, 0, 1444, 881);
		this.add(lblFundoJogo);

    }

    

}
