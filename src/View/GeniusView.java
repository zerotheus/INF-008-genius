package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import Negocio.Data;
import Negocio.Genius;
import Negocio.Jogador;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;

public class GeniusView {

	private JFrame frame;
	private JTextField textNome;
	private JTextField textApelido;
	private JTextField textFCampeonato;
	private Genius jogo;
	private List<Jogador> jogadores;
	private Data dataAtual;
	private Calendar calendario;

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
	@SuppressWarnings({ "static-access" })
	private void initialize() {
		
		dataAtual = new Data(calendario.DAY_OF_MONTH, calendario.MONTH, calendario.YEAR);
		frame = new JFrame();
		frame.setBounds(100, 100, 1445, 921);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		//PANEL INICIAL
		
		JPanel panelInicial = new JPanel();
		frame.getContentPane().add(panelInicial, "name_169079536566800");
		panelInicial.setLayout(null);
		
		JLabel lblJogar = new JLabel("");
		lblJogar.setBounds(579, 651, 233, 95);
		lblJogar.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botão iniciar.png")));
		panelInicial.add(lblJogar);
		
		JLabel lblTelaFundo = new JLabel("");
		lblTelaFundo.setBounds(0, 0, 1429, 882);
		lblTelaFundo.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/tela.png")));
		lblTelaFundo.setHorizontalAlignment(SwingConstants.TRAILING);
		panelInicial.add(lblTelaFundo);
		
		//PANEL SELEÇÃO DE MODO
		
		JPanel panelSelecaoModo = new JPanel();
		frame.getContentPane().add(panelSelecaoModo, "name_169518041388500");
		panelSelecaoModo.setLayout(null);
		
		JLabel lblIndividual = new JLabel("");
		lblIndividual.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/SOLO BOTAO.png")));
		lblIndividual.setBounds(395, 651, 256, 87);
		panelSelecaoModo.add(lblIndividual);
		
		JLabel lblCampeonato = new JLabel("");
		lblCampeonato.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/VARIOS JOGADORES.png")));
		lblCampeonato.setBounds(764, 651, 265, 95);
		panelSelecaoModo.add(lblCampeonato);
		
		JLabel lblVoltarInicio = new JLabel("VOLTAR");
		lblVoltarInicio.setForeground(Color.RED);
		lblVoltarInicio.setFont(new Font("Candara", Font.BOLD, 37));
		lblVoltarInicio.setBounds(628, 771, 136, 52);
		panelSelecaoModo.add(lblVoltarInicio);
		
		JLabel lblTelaFundo2 = new JLabel("");
		lblTelaFundo2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTelaFundo2.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/tela.png")));
		lblTelaFundo2.setBounds(0, 0, 1429, 882);
		panelSelecaoModo.add(lblTelaFundo2);
		
		
		
		//PANEL CADASTRO JOGADOR
		
		JPanel panelIndividualCadastro = new JPanel();
		frame.getContentPane().add(panelIndividualCadastro, "name_170928722915200");
		panelIndividualCadastro.setLayout(null);
		
		JLabel lblLogoGenius = new JLabel("");
		lblLogoGenius.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/geniuslogo.png")));
		lblLogoGenius.setBounds(346, 173, 723, 268);
		panelIndividualCadastro.add(lblLogoGenius);
		
		JLabel lblNomeTxt = new JLabel("Nome: ");
		lblNomeTxt.setFont(new Font("Candara", Font.BOLD, 37));
		lblNomeTxt.setBounds(403, 452, 113, 46);
		panelIndividualCadastro.add(lblNomeTxt);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Candara", Font.BOLD, 37));
		textNome.setBounds(526, 452, 441, 33);
		panelIndividualCadastro.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblApelidoTxt = new JLabel("Apelido:");
		lblApelidoTxt.setFont(new Font("Candara", Font.BOLD, 37));
		lblApelidoTxt.setBounds(403, 541, 142, 46);
		panelIndividualCadastro.add(lblApelidoTxt);
		
		textApelido = new JTextField();
		textApelido.setFont(new Font("Candara", Font.BOLD, 37));
		textApelido.setColumns(10);
		textApelido.setBounds(555, 541, 412, 33);
		panelIndividualCadastro.add(textApelido);
		
		JLabel lblCampeonatoTXT = new JLabel("Campeonato:");
		lblCampeonatoTXT.setFont(new Font("Candara", Font.BOLD, 37));
		lblCampeonatoTXT.setBounds(403, 620, 218, 46);
		panelIndividualCadastro.add(lblCampeonatoTXT);
		
		textFCampeonato = new JTextField();
		textFCampeonato.setFont(new Font("Candara", Font.BOLD, 37));
		textFCampeonato.setColumns(10);
		textFCampeonato.setBounds(622, 620, 345, 33);
		panelIndividualCadastro.add(textFCampeonato);
		
		
		JLabel lblSalvar = new JLabel("");
		lblSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(lblNomeTxt == null || lblApelidoTxt == null || lblCampeonatoTXT == null)
						throw new Exception();
					jogadores.add(new Jogador(""+lblNomeTxt, ""+lblApelidoTxt));	
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(lblLogoGenius, "Todos os campos devem ser preenchidos!");
				}	
			}
			public void mouseEntered(MouseEvent e) {
				lblSalvar.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/Salvar_selecionado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSalvar.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/Salvar.png")));
			}
		});
		lblSalvar.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/Salvar.png")));
		lblSalvar.setBounds(627, 651, 120, 71);
		panelIndividualCadastro.add(lblSalvar);
		
		JLabel lblVoltarCadastro = new JLabel("VOLTAR");
		lblVoltarCadastro.setForeground(Color.RED);
		lblVoltarCadastro.setFont(new Font("Candara", Font.BOLD, 37));
		lblVoltarCadastro.setBounds(628, 771, 136, 52);
		panelIndividualCadastro.add(lblVoltarCadastro);
		
		JLabel lblCadastro = new JLabel("");
		lblCadastro.setBounds(369, 357, 660, 525);
		lblCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/cadastro.png")));
		panelIndividualCadastro.add(lblCadastro);
		
		JLabel lblTelaFundoSemLogo = new JLabel("");
		lblTelaFundoSemLogo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTelaFundoSemLogo.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/fundo sem logo.png")));
		lblTelaFundoSemLogo.setBounds(0, 0, 1429, 893);
		panelIndividualCadastro.add(lblTelaFundoSemLogo);
		
		
		
		//PANEL MULTIPLAYER 
		
		JPanel panelCampeonato = new JPanel();
		frame.getContentPane().add(panelCampeonato, "name_189379883300700");
		panelCampeonato.setLayout(null);
		
		JLabel lbl2Jogadores = new JLabel("");
		lbl2Jogadores.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/2 jogadores.png")));
		lbl2Jogadores.setBounds(298, 651, 264, 95);
		panelCampeonato.add(lbl2Jogadores);
		
		JLabel lbl4Jogadores = new JLabel("");
		lbl4Jogadores.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/4 jogadores.png")));
		lbl4Jogadores.setBounds(585, 651, 264, 95);
		panelCampeonato.add(lbl4Jogadores);
		
		JLabel lbl8Jogadores = new JLabel("");
		lbl8Jogadores.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/8 jogadores.png")));
		lbl8Jogadores.setBounds(859, 651, 264, 95);
		panelCampeonato.add(lbl8Jogadores);
		
		JLabel lblVoltarMultiplayer = new JLabel("VOLTAR");
		lblVoltarMultiplayer.setFont(new Font("Candara", Font.BOLD, 37));
		lblVoltarMultiplayer.setForeground(Color.RED);
		lblVoltarMultiplayer.setBounds(628, 771, 136, 52);
		panelCampeonato.add(lblVoltarMultiplayer);
		
		JLabel lblTelaFundo2_1 = new JLabel("");
		lblTelaFundo2_1.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/tela.png")));
		lblTelaFundo2_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTelaFundo2_1.setBounds(0, 0, 1429, 882);
		panelCampeonato.add(lblTelaFundo2_1);
		
		
		
		
		//BOTÕES DE NAVEGAÇÃO
		
		lblJogar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelInicial.setVisible(false);
				panelSelecaoModo.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblJogar.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botão_iniciar_selecionado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblJogar.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botão iniciar.png")));
			}
		});
		
		lblVoltarInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelecaoModo.setVisible(false);
				panelInicial.setVisible(true);
			}
			/*public void mouseEntered(MouseEvent e) {
			lblVoltarMultiplayer.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/VARIOS JOGADORES_selecionado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblVoltarMultiplayer.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/VARIOS JOGADORES.png")));
			}*/
		});
		lblIndividual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelecaoModo.setVisible(false);
				panelIndividualCadastro.setVisible(true);
			}
			public void mouseEntered(MouseEvent e) {
				lblIndividual.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/SOLO BOTAO_selecionado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblIndividual.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/SOLO BOTAO.png")));
			}
		});
		lblVoltarCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelIndividualCadastro.setVisible(false);
				panelSelecaoModo.setVisible(true);
			}
			/*public void mouseEntered(MouseEvent e) {
			lblVoltarMultiplayer.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/VARIOS JOGADORES_selecionado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblVoltarMultiplayer.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/VARIOS JOGADORES.png")));
			}*/
		});
		
		lblCampeonato.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelecaoModo.setVisible(false);
				panelCampeonato.setVisible(true);
			}
			public void mouseEntered(MouseEvent e) {
				lblCampeonato.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/VARIOS JOGADORES_selecionado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCampeonato.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/VARIOS JOGADORES.png")));
			}
		});
		lblVoltarMultiplayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelCampeonato.setVisible(false);
				panelSelecaoModo.setVisible(true);
			}
			/*public void mouseEntered(MouseEvent e) {
				lblVoltarMultiplayer.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/VARIOS JOGADORES_selecionado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblVoltarMultiplayer.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/VARIOS JOGADORES.png")));
			}*/
		});
		
	}
}
