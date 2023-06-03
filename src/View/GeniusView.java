package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.awt.Font;
import java.awt.TextField;

public class GeniusView {

	private JFrame frame;
	private final String basePath;
	private final String imagesBasePath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeniusView window = new GeniusView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GeniusView() {
		basePath = new File("").getAbsolutePath() + "\\";
		imagesBasePath = basePath + new File("src\\imagens").getPath() + "\\";
		System.out.println(imagesBasePath);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		JTabbedPane tabbedPane = new JTabbedPane();
		// JPanel telaincialPanel = new JPanel(null);

		frame.setBounds(0, 0, 1440, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// System.out.println(frame.getContentPane().getLayout());
		frame.getContentPane().setVisible(true);

		JLabel lbl8jogadores = new JLabel("");
		lbl8jogadores.setEnabled(false);
		lbl8jogadores.setIcon(
				new ImageIcon(this.imagesBasePath + "8 jogadores.png"));
		lbl8jogadores.setBounds(935, 573, 321, 108);
		lbl8jogadores.setVisible(false);

		JLabel lbl4jogadores = new JLabel("");
		lbl4jogadores.setEnabled(false);
		lbl4jogadores.setIcon(
				new ImageIcon(this.imagesBasePath + "4 jogadores.png"));
		lbl4jogadores.setBounds(581, 573, 321, 108);
		lbl4jogadores.setVisible(false);

		JLabel lblCadastro = new JLabel("");
		lblCadastro.setIcon(
				new ImageIcon(this.imagesBasePath + "cadastro.png"));
		lblCadastro.setBounds(406, 330, 662, 531);
		lblCadastro.setVisible(false);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(
				new ImageIcon(this.imagesBasePath + "geniuslogo.png"));
		lblLogo.setBounds(395, 164, 734, 247);
		lblLogo.setVisible(false);
		// CAMPO DE CADASTRO
		JLabel lblJogador = new JLabel("Jogador");
		lblJogador.setFont(new Font("Candara", Font.BOLD, 37));
		lblJogador.setBounds(680, 542, 138, 46);
		lblJogador.setVisible(false);

		TextField textNome = new TextField();
		textNome.setFont(new Font("Dialog", Font.PLAIN, 34));
		textNome.setBounds(482, 645, 515, 39);
		textNome.setVisible(false);

		JLabel lblProximo = new JLabel("");
		lblProximo
				.setIcon(new ImageIcon(this.imagesBasePath + "Salvar.png"));
		lblProximo.setBounds(680, 771, 133, 68);
		lblProximo.setVisible(false);

		TextField textApelido = new TextField();
		textApelido.setFont(new Font("Dialog", Font.PLAIN, 34));
		textApelido.setBounds(482, 737, 515, 39);
		textApelido.setVisible(false);
		frame.getContentPane().add(textApelido);
		frame.getContentPane().add(lblProximo);
		frame.getContentPane().add(textNome);

		TextField textCampeonato = new TextField();
		textCampeonato.setFont(new Font("Dialog", Font.PLAIN, 34));
		textCampeonato.setBounds(482, 483, 515, 39);
		textCampeonato.setVisible(false);
		frame.getContentPane().add(textCampeonato);
		frame.getContentPane().add(lblJogador);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Candara", Font.BOLD, 37));
		lblNome.setBounds(482, 602, 121, 50);
		lblNome.setVisible(false);
		frame.getContentPane().add(lblNome);

		JLabel lblApelido = new JLabel("Apelido");
		lblApelido.setFont(new Font("Candara", Font.BOLD, 37));
		lblApelido.setBounds(482, 694, 138, 55);
		lblApelido.setVisible(false);
		frame.getContentPane().add(lblApelido);

		JLabel lblCampeonatoNome = new JLabel("Campeonato");
		lblCampeonatoNome.setFont(new Font("Candara", Font.BOLD, 37));
		lblCampeonatoNome.setBounds(482, 436, 211, 46);
		lblCampeonatoNome.setVisible(false);
		frame.getContentPane().add(lblCampeonatoNome);
		frame.getContentPane().add(lblLogo);
		frame.getContentPane().add(lblCadastro);
		frame.getContentPane().add(lbl4jogadores);
		// CAMPO DE CADASTRO FIM

		JLabel lbl2jogadores = new JLabel("");
		lbl2jogadores.setIcon(
				new ImageIcon(this.imagesBasePath + "2 jogadores.png"));
		lbl2jogadores.setEnabled(false);
		lbl2jogadores.setBounds(238, 573, 321, 108);
		lbl2jogadores.setVisible(false);
		frame.getContentPane().add(lbl2jogadores);
		frame.getContentPane().add(lbl8jogadores);
		tabbedPane.addTab("Tela Inicial", new TelaInicial(tabbedPane));
		tabbedPane.setEnabled(false);
		frame.setContentPane(tabbedPane);

		lbl2jogadores.addMouseListener(new MouseAdapter() { // colocar som ao clicar o botão
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lbl2jogadores) {
					return;
				}

				lbl2jogadores.setEnabled(false);
				lbl8jogadores.setEnabled(false);
				lbl4jogadores.setEnabled(false);
				lbl2jogadores.setVisible(false);
				lbl8jogadores.setVisible(false);
				lbl4jogadores.setVisible(false);
				lblLogo.setVisible(true);
				lblCadastro.setVisible(true);
				lblJogador.setVisible(true);
				lblNome.setVisible(true);
				lblApelido.setVisible(true);
				lblCampeonatoNome.setVisible(true);
				textCampeonato.setVisible(true);
				textNome.setVisible(true);
				textApelido.setVisible(true);
				lblProximo.setVisible(true);

			}
		});

		lbl4jogadores.addMouseListener(new MouseAdapter() { // colocar som ao clicar o botão
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lbl4jogadores) {
					return;
				}

				lbl2jogadores.setEnabled(false);
				lbl8jogadores.setEnabled(false);
				lbl4jogadores.setEnabled(false);
				lbl2jogadores.setVisible(false);
				lbl8jogadores.setVisible(false);
				lbl4jogadores.setVisible(false);
				lblLogo.setVisible(true);
				lblCadastro.setVisible(true);
				lblJogador.setVisible(true);
				lblNome.setVisible(true);
				lblApelido.setVisible(true);
				lblCampeonatoNome.setVisible(true);
				textCampeonato.setVisible(true);
				textNome.setVisible(true);
				textApelido.setVisible(true);
				lblProximo.setVisible(true);

			}
		});

		lbl8jogadores.addMouseListener(new MouseAdapter() { // colocar som ao clicar o botão
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lbl8jogadores) {
					return;
				}

				lbl2jogadores.setEnabled(false);
				lbl8jogadores.setEnabled(false);
				lbl4jogadores.setEnabled(false);
				lbl2jogadores.setVisible(false);
				lbl8jogadores.setVisible(false);
				lbl4jogadores.setVisible(false);
				lblLogo.setVisible(true);
				lblCadastro.setVisible(true);
				lblJogador.setVisible(true);
				lblNome.setVisible(true);
				lblApelido.setVisible(true);
				lblCampeonatoNome.setVisible(true);
				textCampeonato.setVisible(true);
				textNome.setVisible(true);
				textApelido.setVisible(true);
				lblProximo.setVisible(true);

			}
		});

		lblProximo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lblProximo) {
					return;
				}
				lblLogo.setVisible(false);
				lblCadastro.setVisible(false);
				lblJogador.setVisible(false);
				lblNome.setVisible(false);
				lblApelido.setVisible(false);
				lblCampeonatoNome.setVisible(false);
				textCampeonato.setVisible(false);
				textNome.setVisible(false);
				textApelido.setVisible(false);
				lblProximo.setVisible(false);

			}
		});

	}
}
