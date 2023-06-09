package View;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import Negocio.Genius;
import Negocio.GeniusBase;
import Negocio.Jogador;

public class TelaCadastro extends MyJPanel {
	private int qtdJogadores;
	private Genius jogo = new GeniusBase();

	public TelaCadastro(JTabbedPane tabbedPane, int qtdJogadores) {

		super();
		this.setLayout(null);
		this.qtdJogadores = qtdJogadores;

		// CAMPO DE CADASTRO
		JLabel lblJogador = new JLabel("Jogador");
		lblJogador.setFont(new Font("Candara", Font.BOLD, 37));
		lblJogador.setBounds(680, 542, 138, 46);
		lblJogador.setVisible(true);

		TextField textNome = new TextField();
		textNome.setFont(new Font("Dialog", Font.PLAIN, 34));
		textNome.setBounds(482, 645, 515, 39);
		textNome.setVisible(true);

		MyJLabelwithSound lblSalvar = new MyJLabelwithSound();
		lblSalvar.setIcon(new ImageIcon(this.getImagesPath() + "Salvar.png"));
		lblSalvar.setBounds(550, 780, 117, 60);
		lblSalvar.setBounds(550, 780, 117, 60);
		lblSalvar.setVisible(true);

		TextField textApelido = new TextField();
		textApelido.setFont(new Font("Dialog", Font.PLAIN, 34));
		textApelido.setBounds(482, 737, 515, 39);
		textApelido.setVisible(true);
		this.add(textApelido);
		this.add(lblSalvar);
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

		JLabel lblCadastro = new JLabel();
		lblCadastro.setIcon(
				new ImageIcon(this.getImagesPath() + "cadastro.png"));
		lblCadastro.setBounds(430, 339, 662, 531);
		lblCadastro.setVisible(true);

		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(
				new ImageIcon(this.getImagesPath() + "geniuslogo.png"));
		lblLogo.setBounds(395, 164, 734, 247);
		lblLogo.setVisible(true);

		MyJLabelwithSound lblVoltar = new MyJLabelwithSound();
		lblVoltar.setIcon(new ImageIcon(this.getImagesPath() + "botaoVoltarMenor.png"));
		lblVoltar.setBounds(813, 795, 106, 53);
		lblVoltar.setVisible(true);
		this.add(lblVoltar);

		lblVoltar.addMouseListener(new MouseAdapter() {

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

		JLabel FundoSemLogo = new JLabelFundoSemLogo();
		this.add(lblCampeonatoNome);
		this.add(lblLogo);
		this.add(lblCadastro);
		this.add(FundoSemLogo);

		lblSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					lblSalvar.startSound();
				} catch (Exception e1) {
					System.out.println(e1.toString());
				}
				try {
					jogo.adicionaJogador(new Jogador(textNome.getText(), textApelido.getText()));
					jogo.setTitulo(textCampeonato.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(FundoSemLogo, "Nome/apelido tem que ter pelo menos 3 letras!");
					return;
				}
				if (jogo.getListaJogadores().size() < qtdJogadores) {
					JOptionPane.showMessageDialog(FundoSemLogo, "Jogador salvo! Faltam "
							+ (qtdJogadores - jogo.getListaJogadores().size()) + " Jogadores.");
					textCampeonato.setEditable(false);
					textNome.setText(null);
					textApelido.setText(null);
					return;
				}
				JPanel teladeJogo = new TelaJogo(tabbedPane, jogo);
				tabbedPane.insertTab("Genius", null, teladeJogo, TOOL_TIP_TEXT_KEY, 1);
				tabbedPane.removeTabAt(0);

			}
		});
	}
}
