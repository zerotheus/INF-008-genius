package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GeniusView {

	private JFrame frame;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1445, 921);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panelInicial = new JPanel();
		frame.getContentPane().add(panelInicial, "name_169079536566800");
		panelInicial.setLayout(null);
		
		JLabel lblJogar = new JLabel("");
		
		lblJogar.setBounds(579, 600, 233, 95);
		lblJogar.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botão iniciar.png")));
		panelInicial.add(lblJogar);
		
		JLabel lblTelaFundo = new JLabel("");
		lblTelaFundo.setBounds(-21, -13, 1440, 900);
		lblTelaFundo.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/tela.png")));
		lblTelaFundo.setHorizontalAlignment(SwingConstants.CENTER);
		panelInicial.add(lblTelaFundo);
		
		JPanel panelSelecaoModo = new JPanel();
		frame.getContentPane().add(panelSelecaoModo, "name_169518041388500");
		panelSelecaoModo.setLayout(null);
		
		lblJogar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelInicial.setVisible(false);
				panelSelecaoModo.setVisible(true);
			}
		});
		
		JLabel lblIndividual = new JLabel("");
		lblIndividual.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/SOLO BOTAO.png")));
		lblIndividual.setBounds(395, 600, 256, 87);
		panelSelecaoModo.add(lblIndividual);
		
		JLabel lblCampeonato = new JLabel("");
		lblCampeonato.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/VARIOS JOGADORES.png")));
		lblCampeonato.setBounds(779, 600, 256, 87);
		panelSelecaoModo.add(lblCampeonato);
		
		JLabel lblTelaFundo2 = new JLabel("");
		lblTelaFundo2.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/tela.png")));
		lblTelaFundo2.setBounds(0, 0, 1429, 882);
		panelSelecaoModo.add(lblTelaFundo2);
		
		JPanel panelIndividualCadastro = new JPanel();
		frame.getContentPane().add(panelIndividualCadastro, "name_170928722915200");
		panelIndividualCadastro.setLayout(null);
		
		lblIndividual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelecaoModo.setVisible(false);
				panelIndividualCadastro.setVisible(true);
			}
		});
		
		JLabel lblLogoGenius = new JLabel("");
		lblLogoGenius.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/geniuslogo.png")));
		lblLogoGenius.setBounds(346, 173, 723, 268);
		panelIndividualCadastro.add(lblLogoGenius);
		
		JLabel lblCadastro = new JLabel("");
		lblCadastro.setBounds(375, 357, 660, 525);
		lblCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/cadastro.png")));
		panelIndividualCadastro.add(lblCadastro);
		
		JLabel lblTelaFundoSemLogo = new JLabel("");
		lblTelaFundoSemLogo.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/fundo sem logo.png")));
		lblTelaFundoSemLogo.setBounds(0, 0, 1429, 882);
		panelIndividualCadastro.add(lblTelaFundoSemLogo);
		
		
		
		
	}
}
