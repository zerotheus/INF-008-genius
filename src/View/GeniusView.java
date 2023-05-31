package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import Negocio.*;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import javax.sound.sampled.*;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;


public class GeniusView {

	private JFrame frame;
	private JTextField textNome;
	private JTextField textApelido;
	private Genius jogo;
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	private Data dataAtual;
	private Calendar calendario;
	private String soundName = "C:\\Users\\caian\\git\\INF-008-genius\\src\\sfx\\MenuBotão.wav";    
	private AudioInputStream audioInputStream;
	private Clip clip;
	private JTextField textJogador;
	private Integer numeroJogador;
	private int qtdJogadores;
	
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
	 * @throws LineUnavailableException 
	 */
	public GeniusView() throws LineUnavailableException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "static-access" })
	private void initialize() throws LineUnavailableException {
		
		dataAtual = new Data(calendario.DAY_OF_MONTH, calendario.MONTH, calendario.YEAR);
		frame = new JFrame();
		frame.setBounds(100, 100, 1445, 921);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File((soundName)));//"/sfx/MenuBotão.wav"
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clip = AudioSystem.getClip();
		try {
			clip.open(audioInputStream);
		} catch (LineUnavailableException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		JPanel panelCadastro = new JPanel();
		frame.getContentPane().add(panelCadastro, "name_170928722915200");
		panelCadastro.setLayout(null);
		
		JLabel lblLogoGenius = new JLabel("");
		lblLogoGenius.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/geniuslogo.png")));
		lblLogoGenius.setBounds(332, 173, 723, 268);
		panelCadastro.add(lblLogoGenius);
		
		JLabel lblNomeTxt = new JLabel("Nome: ");
		lblNomeTxt.setFont(new Font("Candara", Font.BOLD, 37));
		lblNomeTxt.setBounds(403, 452, 113, 46);
		panelCadastro.add(lblNomeTxt);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Candara", Font.BOLD, 37));
		textNome.setBounds(526, 452, 441, 33);
		panelCadastro.add(textNome);
		
		JLabel lblApelidoTxt = new JLabel("Apelido:");
		lblApelidoTxt.setFont(new Font("Candara", Font.BOLD, 37));
		lblApelidoTxt.setBounds(403, 541, 142, 46);
		panelCadastro.add(lblApelidoTxt);
		
		textApelido = new JTextField();
		textApelido.setFont(new Font("Candara", Font.BOLD, 37));
		textApelido.setColumns(10);
		textApelido.setBounds(555, 541, 412, 33);
		panelCadastro.add(textApelido);
		
		
		JLabel lblSalvar = new JLabel("");
		lblSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent click) {
					if(textNome.getText().isEmpty()|| textApelido.getText().isEmpty())
						JOptionPane.showMessageDialog(lblLogoGenius, "Todos os campos devem ser preenchidos!");
					else if(jogadores.size() >= qtdJogadores)
						lblSalvar.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao_salvar_maior_desabilitado.png")));
					else {
						jogadores.add(new Jogador(""+textNome.getText(), ""+textApelido.getText()));	
						JOptionPane.showMessageDialog(lblLogoGenius, "Cadastrado com Sucesso!");
						textNome.setText(null);
						textApelido.setText(null);
						numeroJogador = jogadores.size()+1;
						textJogador.setText(""+numeroJogador);
					}
			}
			public void mouseEntered(MouseEvent e) {
				if(jogadores.size() >= qtdJogadores)
					lblSalvar.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao_salvar_maior_desabilitado.png")));
				else
					lblSalvar.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao_salvar_maior_selecionado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(jogadores.size() >= qtdJogadores)
					lblSalvar.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao_salvar_maior_desabilitado.png")));
				else
					lblSalvar.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao_salvar_maior.png")));
			}
		});
		lblSalvar.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao_salvar_maior.png")));
		lblSalvar.setBounds(478, 678, 192, 71);
		panelCadastro.add(lblSalvar);
		
		JLabel lbCarregar = new JLabel("");
		lbCarregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			
			public void mouseEntered(MouseEvent e) {
				lbCarregar.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao carregar_selecionado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbCarregar.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao carregar.png")));
			}
		});
		lbCarregar.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao carregar.png")));
		lbCarregar.setBounds(715, 678, 192, 71);
		panelCadastro.add(lbCarregar);
		
		JLabel lblJogadorTxt = new JLabel("Jogador");
		lblJogadorTxt.setFont(new Font("Candara", Font.BOLD, 37));
		lblJogadorTxt.setBounds(602, 379, 136, 46);
		panelCadastro.add(lblJogadorTxt);
		
		textJogador = new JTextField();
		textJogador.setBackground(new Color(253, 232, 108));
		textJogador.setFont(new Font("Candara", Font.BOLD, 37));
		textJogador.setEditable(false);
		textJogador.setBounds(736, 385, 32, 33);
		textJogador.setBorder(null);
		panelCadastro.add(textJogador);
		textJogador.setColumns(10); 
		if(jogadores.isEmpty() == true)
			numeroJogador = 1;
		textJogador.setText(""+numeroJogador);
		
		JLabel lblVoltarCadastro = new JLabel("VOLTAR");
		lblVoltarCadastro.setForeground(Color.RED);
		lblVoltarCadastro.setFont(new Font("Candara", Font.BOLD, 37));
		lblVoltarCadastro.setBounds(628, 771, 136, 52);
		panelCadastro.add(lblVoltarCadastro);
		
		JLabel lblCadastro = new JLabel("");
		lblCadastro.setBounds(369, 357, 660, 525);
		lblCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/cadastro.png")));
		panelCadastro.add(lblCadastro);
		
		JLabel lblTelaFundoSemLogo = new JLabel("");
		lblTelaFundoSemLogo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTelaFundoSemLogo.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/fundo sem logo.png")));
		lblTelaFundoSemLogo.setBounds(0, 0, 1429, 893);
		panelCadastro.add(lblTelaFundoSemLogo);
		
		
		
		
		
		
		
		
		
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
				clip.start();
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
				qtdJogadores = 1;
				panelSelecaoModo.setVisible(false);
				panelCadastro.setVisible(true);
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
				panelCadastro.setVisible(false);
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
