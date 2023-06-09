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

public class TelaJogo extends MyJPanel {

	private final String imagensPath;
	private Clock clock = Clock.systemDefaultZone();
	private Genius jogo;
	private boolean eraUltimaJogada;
	MyJLabelwithSound lblAzul = new MyJLabelwithSound();
	MyJLabelwithSound lblVermelho = new MyJLabelwithSound();
	MyJLabelwithSound lblAmarelo = new MyJLabelwithSound();
	MyJLabelwithSound lblVerde = new MyJLabelwithSound();

	public TelaJogo(JTabbedPane tabbedPane, Genius jogo) {
		super();

		imagensPath = this.getImagesPath();
		this.setLayout(null);
		this.jogo = jogo;

		lblAzul.setBounds(447, 78, 322, 316);
		lblAzul.setIcon(new ImageIcon(this.getImagesPath() + "azul.png"));
		this.add(lblAzul);


		lblVermelho.setIcon(new ImageIcon(this.getImagesPath() + "vermelho 1.png"));
		lblVermelho.setBounds(447, 474, 311, 316);
		this.add(lblVermelho);


		lblAmarelo.setIcon(new ImageIcon(this.getImagesPath() + "amarelo 1.png"));
		lblAmarelo.setBounds(807, 78, 322, 321);
		this.add(lblAmarelo);


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
				try {
					lblAzul.startSound("La.wav");
                } catch (Exception e1) {
                    System.out.println(e.toString());
                }
				System.out.println(jogo.analisaJogada((long) 0, (long) 0, Cor.azul));
				lblAzul.setIcon(new ImageIcon(imagensPath + "azul branco.png"));
				// inicia uma thread que recebe uma funcao para executar
				new java.util.Timer().schedule(
						new java.util.TimerTask() {
							@Override
							public void run() {
								lblAzul.setIcon(new ImageIcon(imagensPath + "azul.png"));
							}
						},
						250);
			}
		});

		lblVermelho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lblVermelho) {
					return;
				}
				try {
					lblVermelho.startSound("Si.wav");
                } catch (Exception e1) {
                    System.out.println(e.toString());
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
				try {
					lblAmarelo.startSound("Re.wav");
                } catch (Exception e1) {
                    System.out.println(e.toString());
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
				try {
					lblVerde.startSound("Mi.wav");
                } catch (Exception e1) {
                    System.out.println(e.toString());
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

		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel telaPlacar = new TelaPlacar(tabbedPane, jogo);
				tabbedPane.insertTab("Genius", null, telaPlacar, TOOL_TIP_TEXT_KEY, 1);
				tabbedPane.removeTabAt(0);
			}
		});

	}

	public void exibeSequencia() {
		System.out.println(jogo.getSequencia());
	}

}
