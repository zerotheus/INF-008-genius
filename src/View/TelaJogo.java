package View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Enums.Cor;
import Negocio.Genius;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Clock;
import java.util.List;

public class TelaJogo extends MyJPanel {

	private final String imagensPath;
	private Clock clock = Clock.systemDefaultZone();
	private Genius jogo;
	private boolean eraUltimaJogada;
	private List<Integer> sequenciadeCoresaExibir;
	private List<JLabel> geniusLabels;
	private GeniusLabels lblAzul;

	public TelaJogo(JTabbedPane tabbedPane, Genius jogo) {
		super();

		imagensPath = this.getImagesPath();
		this.setLayout(null);
		this.jogo = jogo;

		lblAzul = new GeniusLabels("azul.png", "azul branco.png");
		lblAzul.setBounds(447, 78, 322, 316);
		lblAzul.setIcon(new ImageIcon(this.getImagesPath() + "azul.png"));
		this.add(lblAzul);

		JLabel lblVermelho = new JLabel();

		lblVermelho.setIcon(new ImageIcon(this.getImagesPath() + "vermelho 1.png"));
		lblVermelho.setBounds(447, 474, 311, 316);
		this.add(lblVermelho);

		JLabel lblAmarelo = new JLabel();
		lblAmarelo.setIcon(new ImageIcon(this.getImagesPath() + "amarelo 1.png"));
		lblAmarelo.setBounds(807, 78, 322, 321);
		this.add(lblAmarelo);

		JLabel lblVerde = new JLabel();
		lblVerde.setIcon(new ImageIcon(this.getImagesPath() + "verde 1.png"));
		lblVerde.setBounds(800, 474, 329, 316);
		this.add(lblVerde);

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
		this.add(btnSalvar);
		btnSalvar.setVisible(false);

		JLabel lblPontos = new JLabel();
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

		JLabel btnIniciar = new JLabel();
		btnIniciar.setBounds(1223, 89, 173, 55);
		this.add(btnIniciar);
		btnIniciar.setEnabled(true);
		btnIniciar.setVisible(true);

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

		lblVermelho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lblVermelho) {
					return;
				}
				System.out.println(jogo.analisaJogada((long) 0, (long) 0, Cor.vermelho));
				lblVermelho.setIcon(new ImageIcon(imagensPath + "vermelho branco.png"));
				new java.util.Timer().schedule(
						new java.util.TimerTask() {
							@Override
							public void run() {
								lblVermelho.setIcon(new ImageIcon(imagensPath + "vermelho 1.png"));
							}
						},
						250);
			}
		});

		lblAmarelo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lblAmarelo) {
					return;
				}
				System.out.println(jogo.analisaJogada((long) 0, (long) 0, Cor.amarelo));
				lblAmarelo.setIcon(new ImageIcon(imagensPath + "amarelo branco.png"));
				new java.util.Timer().schedule(
						new java.util.TimerTask() {
							@Override
							public void run() {
								lblAmarelo.setIcon(new ImageIcon(imagensPath + "amarelo 1.png"));
							}
						},
						250);

			}
		});

		lblVerde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lblVerde) {
					return;
				}
				System.out.println(jogo.analisaJogada((long) 0, (long) 0, Cor.verde));
				lblVerde.setIcon(new ImageIcon(imagensPath + "verde branco.png"));
				new java.util.Timer().schedule(
						new java.util.TimerTask() {
							@Override
							public void run() {
								lblVerde.setIcon(new ImageIcon(imagensPath + "verde 1.png"));
							}
						},
						250);
			}
		});

		btnCarregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel telaPlacar = new TelaPlacar(tabbedPane, jogo);
				tabbedPane.insertTab("Genius", null, telaPlacar, TOOL_TIP_TEXT_KEY, 1);
				tabbedPane.removeTabAt(0);
			}
		});

		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibeSequencia();
			}
		});

	}

	public void exibeSequencia() {
		this.sequenciadeCoresaExibir = jogo.getSequencia();
		for (int i = 0; i < sequenciadeCoresaExibir.size(); i++) {
			if (sequenciadeCoresaExibir.get(i) == 0) {
				lblAzul.pisca();
			}
		}
	}

}
