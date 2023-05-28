package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.TextField;

public class GeniusView {

	private JFrame frame;
	private final String basePath;

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
		basePath = new File("").getAbsolutePath() + "/";
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1440, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl8jogadores = new JLabel("");
		lbl8jogadores.setEnabled(false);
		lbl8jogadores.setIcon(
				new ImageIcon("C:\\Users\\Alana\\Desktop\\GENIUS\\INF-008-genius\\src\\imagens\\8 jogadores.png"));
		lbl8jogadores.setBounds(935, 573, 321, 108);
		lbl8jogadores.setVisible(false);

		JLabel lbl4jogadores = new JLabel("");
		lbl4jogadores.setEnabled(false);
		lbl4jogadores.setIcon(
				new ImageIcon("C:\\Users\\Alana\\Desktop\\GENIUS\\INF-008-genius\\src\\imagens\\4 jogadores.png"));
		lbl4jogadores.setBounds(581, 573, 321, 108);
		lbl4jogadores.setVisible(false);

		JLabel lblCadastro = new JLabel("");
		lblCadastro.setIcon(
				new ImageIcon("C:\\Users\\Alana\\Desktop\\GENIUS\\INF-008-genius\\src\\imagens\\cadastro.png"));
		lblCadastro.setBounds(406, 330, 662, 531);
		lblCadastro.setVisible(false);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(
				new ImageIcon("C:\\Users\\Alana\\Desktop\\GENIUS\\INF-008-genius\\src\\imagens\\geniuslogo.png"));
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
				.setIcon(new ImageIcon("C:\\Users\\Alana\\Desktop\\GENIUS\\INF-008-genius\\src\\imagens\\Salvar.png"));
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
				new ImageIcon("C:\\Users\\Alana\\Desktop\\GENIUS\\INF-008-genius\\src\\imagens\\2 jogadores.png"));
		lbl2jogadores.setEnabled(false);
		lbl2jogadores.setBounds(238, 573, 321, 108);
		lbl2jogadores.setVisible(false);
		frame.getContentPane().add(lbl2jogadores);
		frame.getContentPane().add(lbl8jogadores);

		JLabel lblbutao = new JLabel("");
		lblbutao.setIcon(
				new ImageIcon("C:\\Users\\Alana\\Desktop\\GENIUS\\INF-008-genius\\src\\imagens\\botão iniciar.png"));
		lblbutao.setBounds(587, 573, 276, 117);
		frame.getContentPane().add(lblbutao);

		JLabel lblCampeonato = new JLabel("");
		lblCampeonato.setEnabled(false);
		lblCampeonato.setIcon(
				new ImageIcon("C:\\Users\\Alana\\Desktop\\GENIUS\\INF-008-genius\\src\\imagens\\VARIOS JOGADORES.png"));
		lblCampeonato.setBounds(759, 573, 264, 95);
		lblCampeonato.setVisible(false);
		frame.getContentPane().add(lblCampeonato);

		JLabel lblindividual = new JLabel("");
		lblindividual.setEnabled(false);
		lblindividual.setIcon(
				new ImageIcon("C:\\Users\\Alana\\Desktop\\GENIUS\\INF-008-genius\\src\\imagens\\SOLO BOTAO.png"));
		lblindividual.setBounds(406, 573, 264, 95);
		lblindividual.setVisible(false);
		frame.getContentPane().add(lblindividual);

		JLabel lbltelaFundo = new JLabel("");
		lbltelaFundo
				.setIcon(new ImageIcon("C:\\Users\\Alana\\Desktop\\GENIUS\\INF-008-genius\\src\\imagens\\tela.png"));
		lbltelaFundo.setBounds(0, 0, 1451, 884);
		frame.getContentPane().add(lbltelaFundo);

		lblbutao.addMouseListener(new MouseAdapter() { // colocar som ao clicar o botão
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lblbutao) {
					return;
				}
				lblbutao.setEnabled(false);
				lblbutao.setVisible(false);
				lblCampeonato.setEnabled(true);
				lblCampeonato.setVisible(true);
				lblindividual.setEnabled(true);
				lblindividual.setVisible(true);
			}
		});

		lblCampeonato.addMouseListener(new MouseAdapter() { // colocar som ao clicar o botão
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lblCampeonato) {
					return;
				}
				lblCampeonato.setEnabled(false);
				lblCampeonato.setVisible(false);
				lblindividual.setEnabled(false);
				lblindividual.setVisible(false);
				lbl2jogadores.setEnabled(true);
				lbl2jogadores.setVisible(true);
				lbl4jogadores.setEnabled(true);
				lbl4jogadores.setVisible(true);
				lbl8jogadores.setEnabled(true);
				lbl8jogadores.setVisible(true);

			}
		});

		lblindividual.addMouseListener(new MouseAdapter() { // colocar som ao clicar o botão
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lblindividual) {
					return;
				}
				lblCampeonato.setEnabled(false);
				lblCampeonato.setVisible(false);
				lblindividual.setEnabled(false);
				lblindividual.setVisible(false);
				lbltelaFundo.setIcon(new ImageIcon(
						"C:\\Users\\Alana\\Desktop\\GENIUS\\INF-008-genius\\src\\imagens\\fundo sem logo.png"));
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

	}
}
