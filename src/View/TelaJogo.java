package View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import Enums.Cor;
import Negocio.Genius;
import Negocio.Jogador;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TelaJogo extends MyJPanel {

	private final String imagensPath;
	long millis = 0;
	long segundos = 0;
	private Genius jogo;
	private boolean eraUltimaJogada;
	private List<Integer> sequenciadeCoresaExibir;
	private List<GeniusLabels> geniusLabels = new ArrayList<>();

	public TelaJogo(JTabbedPane tabbedPane, Genius jogo) {
		super();

		imagensPath = this.getImagesPath();
		this.setLayout(null);
		this.jogo = jogo;

		// this.add(lblAzul);
		this.instanciabotoes();

		JButton btnDificuldade = new JButton();
		btnDificuldade.setBounds(714, 405, 44, 45);
		this.add(btnDificuldade);
		btnDificuldade.setVisible(false);

		JButton btnCarregar = new JButton();
		btnCarregar.setBounds(1223, 720, 164, 57);
		this.add(btnCarregar);
		btnCarregar.setVisible(false);

		JButton btnSalvar = new JButton();
		btnSalvar.setBounds(1223, 405, 173, 57);
		btnSalvar.setVisible(false);
		this.add(btnSalvar);

		JLabel lblPontos = new JLabel("" + jogo.getJogadorAtual().getPontos());
		lblPontos.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 34));
		lblPontos.setForeground(new Color(255, 255, 255));
		lblPontos.setBounds(175, 589, 67, 57);
		this.add(lblPontos);

		JLabel lblNomeJogador = new JLabel(jogo.getJogadorAtual().getApelido());
		lblNomeJogador.setForeground(new Color(255, 255, 255));
		lblNomeJogador.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 22));
		lblNomeJogador.setBounds(95, 221, 241, 39);
		this.add(lblNomeJogador);

		JLabel lblFundoJogo = new JLabel();
		lblFundoJogo.setIcon(new ImageIcon(this.getImagesPath() + "fundojOGO.png"));
		lblFundoJogo.setBounds(0, 0, 1444, 881);
		this.add(lblFundoJogo);

		MyJLabelwithSound btnIniciar = new MyJLabelwithSound();
		btnIniciar.setBounds(1223, 89, 173, 55);
		this.add(btnIniciar);
		btnIniciar.setEnabled(true);
		btnIniciar.setVisible(true);

		btnCarregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnIniciar.startSound("Sol.wav");
				} catch (Exception e1) {
					System.out.println(e.toString());
				}

				JPanel telaPlacar = new TelaPlacar(tabbedPane, jogo);
				tabbedPane.insertTab("Genius", null, telaPlacar, TOOL_TIP_TEXT_KEY, 1);
				tabbedPane.removeTabAt(0);

			}
		});

		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("teste");
				exibeSequencia();
			}
		});

	}

	public void instanciabotoes() {

		GeniusLabels lblAzul = new GeniusLabels("azul.png", "azul branco.png");
		lblAzul.setBounds(447, 78, 322, 316);
		lblAzul.setIcon(new ImageIcon(this.getImagesPath() + "azul.png"));
		lblAzul.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lblAzul) {
					return;
				}
				System.out.println(jogo.analisaJogada((long) 0, (long) 0, Cor.azul));
				lblAzul.pisca();
			}
		});
		GeniusLabels lblVermelho = new GeniusLabels("vermelho 1.png", "vermelho branco.png");
		lblVermelho.setIcon(new ImageIcon(this.getImagesPath() + "vermelho 1.png"));
		lblVermelho.setBounds(447, 474, 322, 316);
		lblVermelho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lblVermelho) {
					return;
				}
				System.out.println(jogo.analisaJogada((long) 0, (long) 0, Cor.vermelho));
				lblVermelho.pisca();
			}
		});
		GeniusLabels lblAmarelo = new GeniusLabels("amarelo 1.png", "amarelo branco.png");
		lblAmarelo.setIcon(new ImageIcon(this.getImagesPath() + "amarelo 1.png"));
		lblAmarelo.setBounds(807, 78, 322, 316);
		GeniusLabels lblVerde = new GeniusLabels("verde 1.png", "verde branco.png");
		lblAmarelo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lblAmarelo) {
					return;
				}
				try {
					lblAmarelo.startSound("Re.wav");
				} catch (Exception e1) {
					System.out.println(e.toString());
				}
				lblAmarelo.pisca();

			}
		});
		lblVerde.setIcon(new ImageIcon(this.getImagesPath() + "verde 1.png"));
		lblVerde.setBounds(807, 474, 322, 316);
		lblVerde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lblVerde) {
					return;
				}
				try {
					lblVerde.startSound("Mi.wav");
				} catch (Exception e1) {
					System.out.println(e.toString());
				}
				lblVerde.pisca();
			}
		});
		geniusLabels.add(lblAzul);
		geniusLabels.add(lblAmarelo);
		geniusLabels.add(lblVermelho);
		geniusLabels.add(lblVerde);
		for (int i = 0; i < geniusLabels.size(); i++) {
			this.add(geniusLabels.get(i));
		}

	}

	public void exibeSequencia() {
		this.sequenciadeCoresaExibir = jogo.getSequencia();
		for (int i = 0; i < sequenciadeCoresaExibir.size(); i++) {
			final int j = i;
			new java.util.Timer().schedule(
					new TimerTask() {
						@Override
						public void run() {
							geniusLabels.get(sequenciadeCoresaExibir.get(j)).pisca();
						}
					}, 250, 250);

		}
	}

}
