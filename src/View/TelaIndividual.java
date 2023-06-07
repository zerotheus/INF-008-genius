package View;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Negocio.Genius;
import Negocio.Jogador;

public class TelaIndividual extends MyJPanel {

	public TelaIndividual(JTabbedPane tabbedPane) {
		super();
		this.setLayout(null);

		// CAMPO DE CADASTRO
		JLabel lblJogador = new JLabel("Jogador");
		lblJogador.setFont(new Font("Candara", Font.BOLD, 37));
		lblJogador.setBounds(680, 542, 138, 46);
		lblJogador.setVisible(true);

		TextField textNome = new TextField();
		textNome.setFont(new Font("Dialog", Font.PLAIN, 34));
		textNome.setBounds(482, 645, 515, 39);
		textNome.setVisible(true);

		JLabel lblProximo = new JLabel("");
		lblProximo.setIcon(new ImageIcon(this.getImagesPath() + "Salvar.png"));
		lblProximo.setBounds(680, 771, 133, 68);
		lblProximo.setVisible(true);

		TextField textApelido = new TextField();
		textApelido.setFont(new Font("Dialog", Font.PLAIN, 34));
		textApelido.setBounds(482, 737, 515, 39);
		textApelido.setVisible(true);
		this.add(textApelido);
		this.add(lblProximo);
		this.add(textNome);

		TextField textCampeonato = new TextField();
		textCampeonato.setFont(new Font("Dialog", Font.PLAIN, 34));
		textCampeonato.setBounds(482, 483, 515, 39);
		textCampeonato.setVisible(true);
		this.add(textCampeonato);
		this.add(lblJogador);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Candara", Font.BOLD, 37));
		lblNome.setBounds(482, 602, 121, 50);
		lblNome.setVisible(true);
		this.add(lblNome);

		JLabel lblApelido = new JLabel("Apelido");
		lblApelido.setFont(new Font("Candara", Font.BOLD, 37));
		lblApelido.setBounds(482, 694, 138, 55);
		lblApelido.setVisible(true);
		this.add(lblApelido);

		JLabel lblCampeonatoNome = new JLabel("Campeonato");
		lblCampeonatoNome.setFont(new Font("Candara", Font.BOLD, 37));
		lblCampeonatoNome.setBounds(482, 436, 211, 46);
		lblCampeonatoNome.setVisible(true);

		JLabel lblCadastro = new JLabel("");
		lblCadastro.setIcon(
				new ImageIcon(this.getImagesPath() + "cadastro.png"));
		lblCadastro.setBounds(430, 339, 662, 531);
		lblCadastro.setVisible(true);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(
				new ImageIcon(this.getImagesPath() + "geniuslogo.png"));
		lblLogo.setBounds(395, 164, 734, 247);
		lblLogo.setVisible(true);

		JLabel FundoSemLogo = new JLabelFundoSemLogo();
		this.add(lblCampeonatoNome);
		this.add(lblLogo);
		this.add(lblCadastro);
		this.add(FundoSemLogo);

		lblProximo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO validar campos
				Genius jogo = new Genius("Teste");
				Jogador jogador;
				try {
					jogador = new Jogador("Irineu", "Sla");
				} catch (Exception e1) {
					e1.printStackTrace();
					return;
				}
				jogo.adicionaJogador(jogador);
				JPanel teladeJogo = new TelaJogo(tabbedPane, jogo);
				tabbedPane.insertTab("Genius", null, teladeJogo, TOOL_TIP_TEXT_KEY, 1);
				tabbedPane.removeTabAt(0);
			}
		});

	}
}
