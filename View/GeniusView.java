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
		
		
		//PAINEL CADASTRO JOGADOR
		
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
		
		
		JLabel lblSalvarCadastro = new JLabel("");
		lblSalvarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao_salvar_maior.png")));
		lblSalvarCadastro.setBounds(610, 596, 192, 71);
		panelCadastro.add(lblSalvarCadastro);
		
		JLabel lbCarregarCadastro = new JLabel("");
		lbCarregarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao carregar.png")));
		lbCarregarCadastro.setBounds(610, 678, 192, 71);
		panelCadastro.add(lbCarregarCadastro);
		
		JLabel lblJogadorTxt = new JLabel("Jogador");
		lblJogadorTxt.setFont(new Font("Candara", Font.BOLD, 37));
		lblJogadorTxt.setBounds(602, 379, 136, 46);
		panelCadastro.add(lblJogadorTxt);
		
		JLabel lblAvancarCadastro = new JLabel("");
		lblAvancarCadastro.setBounds(579, 760, 256, 95);
		lblAvancarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/Avançar_desabilitado.png")));
		panelCadastro.add(lblAvancarCadastro);
		
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
		lblVoltarCadastro.setBounds(392, 819, 136, 52);
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
		
		
		//PAINEL MULTIPLAYER 
		
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
		
		//PAINEL JOGO
		
		JPanel panelJogo = new JPanel();
		frame.getContentPane().add(panelJogo, "name_254001722167300");
		panelJogo.setLayout(null);
		
		JLabel lblSalvarJogo = new JLabel("");
		lblSalvarJogo.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao_salvar_maior.png")));
		lblSalvarJogo.setBounds(0, 753, 192, 71);
		panelJogo.add(lblSalvarJogo);
		
		JLabel lblCarregarJogo = new JLabel("");
		lblCarregarJogo.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao carregar.png")));
		lblCarregarJogo.setBounds(1227, 753, 192, 71);
		panelJogo.add(lblCarregarJogo);
		
		JLabel lblIniciarJogo = new JLabel("");
		lblIniciarJogo.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao inicar.png")));
		lblIniciarJogo.setBounds(1227, 72, 192, 71);
		panelJogo.add(lblIniciarJogo);
		
		JLabel lblBtnVerde = new JLabel("");
		lblBtnVerde.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/verde.png")));
		lblBtnVerde.setBounds(716, 458, 308, 341);
		panelJogo.add(lblBtnVerde);
		
		JLabel lblBtnVermelho = new JLabel("");
		lblBtnVermelho.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/vermelho.png")));
		lblBtnVermelho.setBounds(366, 458, 308, 341);
		panelJogo.add(lblBtnVermelho);
		
		JLabel lblBtnAmarelo = new JLabel("");
		lblBtnAmarelo.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/amarelo.png")));
		lblBtnAmarelo.setBounds(716, 91, 308, 341);
		panelJogo.add(lblBtnAmarelo);
		
		JLabel lblBtnAzul = new JLabel("");
		lblBtnAzul.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/azul.png")));
		lblBtnAzul.setBounds(364, 91, 321, 341);
		panelJogo.add(lblBtnAzul);
		
		JLabel lblBtnCentral_1 = new JLabel("");
		lblBtnCentral_1.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/icons8-esfera-96 1.png")));
		lblBtnCentral_1.setBounds(623, 419, 51, 50);
		panelJogo.add(lblBtnCentral_1);
		
		JLabel lblBtnCentral_2 = new JLabel("");
		lblBtnCentral_2.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/icons8-esfera-96 2.png")));
		lblBtnCentral_2.setBounds(706, 419, 51, 50);
		panelJogo.add(lblBtnCentral_2);
		
		JLabel lblBtnCentral = new JLabel("");
		lblBtnCentral.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/Iniciar.png")));
		lblBtnCentral.setBounds(577, 334, 233, 236);
		panelJogo.add(lblBtnCentral);
		
		JLabel lblFundoGenius = new JLabel("");
		lblFundoGenius.setHorizontalAlignment(SwingConstants.CENTER);
		lblFundoGenius.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/genius.png")));
		lblFundoGenius.setBounds(341, 72, 715, 761);
		panelJogo.add(lblFundoGenius);
		
		JLabel lblTelaFundoJogo = new JLabel("");
		lblTelaFundoJogo.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/Tela_Fundo_Jogo.png")));
		lblTelaFundoJogo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTelaFundoJogo.setBounds(0, 0, 1429, 893);
		panelJogo.add(lblTelaFundoJogo);
		
		
		
		//AÇÕES BOTÕES DE OBJETO
		
		lblSalvarCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent click) {
					if(textNome.getText().isEmpty()|| textApelido.getText().isEmpty())
						JOptionPane.showMessageDialog(lblLogoGenius, "Todos os campos devem ser preenchidos!");
					else if(jogadores.size() >= qtdJogadores)
						lblSalvarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao_salvar_maior_desabilitado.png")));
					else {
						jogadores.add(new Jogador(""+textNome.getText(), ""+textApelido.getText()));	
						JOptionPane.showMessageDialog(lblLogoGenius, "Cadastrado com Sucesso!");
						textNome.setText(null);
						textApelido.setText(null);
						if(jogadores.size() < qtdJogadores) {
							numeroJogador = jogadores.size()+1;
							textJogador.setText(""+numeroJogador);
						}else {
							lblAvancarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/Avançar.png")));
							lbCarregarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao carregar_desabilitado.png")));
							lblSalvarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao_salvar_maior_desabilitado.png")));
						}
							
					}
			}
			public void mouseEntered(MouseEvent e) {
				if(jogadores.size() < qtdJogadores)
					lblSalvarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao_salvar_maior_selecionado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(jogadores.size() < qtdJogadores)
					lblSalvarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao_salvar_maior.png")));
			}
		});
		lbCarregarCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
				if(jogadores.size() < qtdJogadores)
					lbCarregarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao carregar_selecionado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(jogadores.size() < qtdJogadores)
					lbCarregarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao carregar.png")));
			}
		});
		
		
		//AÇÕES BOTÕES DE NAVEGAÇÃO
		
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
				jogadores.clear();
				qtdJogadores = 1;
				numeroJogador = 1;
				textJogador.setText(""+numeroJogador);
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
		lbl2Jogadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				qtdJogadores = 2;
				if(jogadores.size()<qtdJogadores) {
					lblAvancarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/Avançar_desabilitado.png")));
					lblSalvarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao_salvar_maior.png")));
					lbCarregarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao carregar.png")));
				}else {
					lblAvancarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/Avançar.png")));
					lbCarregarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao carregar_desabilitado.png")));
					lblSalvarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao_salvar_maior_desabilitado.png")));
				}
				panelCampeonato.setVisible(false);
				panelCadastro.setVisible(true);
			}
			public void mouseEntered(MouseEvent e) {
				lbl2Jogadores.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/2 jogadores_selecionado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl2Jogadores.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/2 jogadores.png")));
			}
		});
		lbl4Jogadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				qtdJogadores = 4;
				if(jogadores.size()<qtdJogadores) {
					lblAvancarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/Avançar_desabilitado.png")));
					lblSalvarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao_salvar_maior.png")));
					lbCarregarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao carregar.png")));
				}else {
					lblAvancarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/Avançar.png")));
					lbCarregarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao carregar_desabilitado.png")));
					lblSalvarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao_salvar_maior_desabilitado.png")));
				}
				panelCampeonato.setVisible(false);
				panelCadastro.setVisible(true);
			}
			public void mouseEntered(MouseEvent e) {
				lbl4Jogadores.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/4 jogadores_selecionado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl4Jogadores.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/4 jogadores.png")));
			}
		});
		lbl8Jogadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				qtdJogadores = 8;
				if(jogadores.size()<qtdJogadores) {
					lblAvancarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/Avançar_desabilitado.png")));
					lblSalvarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao_salvar_maior.png")));
					lbCarregarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao carregar.png")));
				}else {
					lblAvancarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/Avançar.png")));
					lbCarregarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao carregar_desabilitado.png")));
					lblSalvarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao_salvar_maior_desabilitado.png")));
				}
				panelCampeonato.setVisible(false);
				panelCadastro.setVisible(true);
			}
			public void mouseEntered(MouseEvent e) {
				lbl8Jogadores.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/8 jogadores_selecionado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl8Jogadores.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/8 jogadores.png")));
			}
		});
		lblAvancarCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(jogadores.size() == qtdJogadores) {
					clip.start();
					panelCadastro.setVisible(false);
					panelJogo.setVisible(true);
				}
			}
			public void mouseEntered(MouseEvent e) {
				if(jogadores.size() == qtdJogadores)
					lblAvancarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/Avançar_selecionado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(jogadores.size() == qtdJogadores)
					lblAvancarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/Avançar.png")));

			}
		});
		lblVoltarCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int opcao = JOptionPane.showConfirmDialog(lblLogoGenius, "Deseja descartar o(s) jogador(es) cadastrado(s)?");
				if(opcao== 0) {
					jogadores.clear();
					numeroJogador = 1;
					textJogador.setText(""+numeroJogador);
					lbCarregarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao carregar.png")));
					lblSalvarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/botao_salvar_maior.png")));
					lblAvancarCadastro.setIcon(new ImageIcon(GeniusView.class.getResource("/imagens/Avançar_desabilitado.png")));
					panelCadastro.setVisible(false);
					panelSelecaoModo.setVisible(true);
				}else if(opcao == 1) {
					panelCadastro.setVisible(false);
					panelSelecaoModo.setVisible(true);
				}
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
		
		//AÇÕES BOTÕES DE JOGO
		
	}
}
