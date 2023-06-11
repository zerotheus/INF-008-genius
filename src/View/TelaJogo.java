package View;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import Negocio.Genius;
import View.geniusLabels.AmareloLabel;
import View.geniusLabels.AzulLabel;
import View.geniusLabels.GeniusLabels;
import View.geniusLabels.VerdeLabel;
import View.geniusLabels.VermelhoLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TelaJogo extends MyJPanel implements Runnable {

	private Genius jogo;
	private List<Integer> sequenciadeCoresaExibir;
	private List<GeniusLabels> geniusLabels = new ArrayList<>();
	private Thread thread = new Thread(this);
	private JTabbedPane tabbedPane;
	private JLabel lblNomeJogador;
	private JLabel lblPontos;
	private MyJLabelwithSound btnIniciar;

	public TelaJogo(JTabbedPane tabbedPane, Genius jogo) {
		super();
		this.tabbedPane = tabbedPane;
		this.jogo = jogo;
		this.instanciabotoes();
		JButton btnDificuldade = new JButton();
		btnDificuldade.setBounds(714, 405, 44, 45);
		this.add(btnDificuldade);
		btnDificuldade.setVisible(false);

		btnIniciar = new MyJLabelwithSound();
		btnIniciar.setBounds(1212, 87, 190, 70);
		btnIniciar.setVisible(true);
		this.add(btnIniciar);

		MyJLabelwithSound btnSalvar = new MyJLabelwithSound();
		btnSalvar.setBounds(1223, 405, 173, 57);
		btnSalvar.setVisible(true);
		this.add(btnSalvar);

		MyJLabelwithSound btnCarregar = new MyJLabelwithSound();
		btnCarregar.setBounds(1206, 716, 190, 70);
		btnCarregar.setVisible(true);
		this.add(btnCarregar);

		JLabel lblFundoJogo = new JLabel();
		lblFundoJogo.setIcon(new ImageIcon(this.getImagesPath() + "fundojOGO.png"));
		lblFundoJogo.setBounds(0, 0, 1444, 881);
		this.add(lblFundoJogo);

		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnIniciar.setEnabled(false);
				try {
					btnIniciar.startSound("Sol.wav");
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
				}
				if (!thread.isAlive()) {
					thread.start();
					return;
				}

			}
		});

		btnSalvar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnSalvar.startSound();
				} catch (Exception e1) {
					System.out.println(e.toString());
				}

				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(lblFundoJogo);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					try {
						FileOutputStream fileStream = new FileOutputStream(file);
						ObjectOutputStream os = new ObjectOutputStream(fileStream);
						os.writeObject(jogo);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// This is where a real application would open the file.
				}
				JPanel telaPlacar = new TelaPlacar(tabbedPane, jogo);
				tabbedPane.insertTab("Genius", null, telaPlacar, TOOL_TIP_TEXT_KEY, 1);
				tabbedPane.removeTabAt(0);

			}
		});

		btnCarregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (jogo.jogoEstaAtivo()) {
					btnCarregar.setEnabled(false);
					btnCarregar.setIcon(
							new ImageIcon((btnCarregar.getImagesBasePath() + "botao carregar_desabilitado.png")));
				}

				else {
					try {
						btnCarregar.startSound();
					} catch (Exception e1) {
						System.out.println(e.toString());
					}
					Genius jogoCarregado = null;
					final JFileChooser fc = new JFileChooser();
					int returnVal = fc.showOpenDialog(lblFundoJogo);

					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						try {
							FileInputStream fis = new java.io.FileInputStream(file);
							ObjectInputStream is = new ObjectInputStream(fis);
							jogoCarregado = (Genius) is.readObject();
						} catch (IOException | ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						// This is where a real application would open the file.
					}
					JPanel telaPlacar = new TelaPlacar(tabbedPane, jogoCarregado);
					tabbedPane.insertTab("Genius", null, telaPlacar, TOOL_TIP_TEXT_KEY, 1);
					tabbedPane.removeTabAt(0);
				}

			}
		});

		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnIniciar.startSound("Sol.wav");
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (!thread.isAlive()) {
					thread.start();
					return;
				}
			}
		});
	}

	private void instanciabotoes() {

		lblPontos = new JLabel("" + jogo.getJogadorAtual().getPontos());
		lblPontos.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 34));
		lblPontos.setForeground(new Color(255, 255, 255));
		lblPontos.setBounds(175, 589, 67, 57);
		this.add(lblPontos);

		lblNomeJogador = new JLabel(jogo.getJogadorAtual().getApelido());
		lblNomeJogador.setForeground(new Color(255, 255, 255));
		lblNomeJogador.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 22));
		lblNomeJogador.setBounds(95, 221, 241, 39);
		this.add(lblNomeJogador);

		GeniusLabels lblAzul = new AzulLabel();
		lblAzul.setBounds(447, 78, 322, 316);
		lblAzul.setIcon(new ImageIcon(this.getImagesPath() + "azul.png"));
		lblAzul.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lblAzul) {
					return;
				}
				getInformacoes(lblAzul);
			}
		});
		GeniusLabels lblVermelho = new VermelhoLabel();
		lblVermelho.setIcon(new ImageIcon(this.getImagesPath() + "vermelho 1.png"));
		lblVermelho.setBounds(447, 474, 322, 316);
		lblVermelho.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lblVermelho) {
					return;
				}
				getInformacoes(lblVermelho);
			}
		});
		GeniusLabels lblAmarelo = new AmareloLabel();
		lblAmarelo.setIcon(new ImageIcon(this.getImagesPath() + "amarelo 1.png"));
		lblAmarelo.setBounds(807, 78, 322, 316);
		lblAmarelo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lblAmarelo) {
					return;
				}
				getInformacoes(lblAmarelo);
			}
		});
		GeniusLabels lblVerde = new VerdeLabel();
		lblVerde.setIcon(new ImageIcon(this.getImagesPath() + "verde 1.png"));
		lblVerde.setBounds(807, 474, 322, 316);
		lblVerde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lblVerde) {
					return;
				}
				getInformacoes(lblVerde);
			}
		});
		// Start key Mapping
		lblAzul.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('w'), "W");
		lblAzul.getActionMap().put("W", new KeyButtonMaps(lblAzul, this));
		lblAmarelo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('a'), "A");
		lblAmarelo.getActionMap().put("A", new KeyButtonMaps(lblAmarelo, this));
		lblVermelho.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('s'), "S");
		lblVermelho.getActionMap().put("S", new KeyButtonMaps(lblVermelho, this));
		lblVerde.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('d'), "D");
		lblVerde.getActionMap().put("D", new KeyButtonMaps(lblVerde, this));
		// end key Mapping
		geniusLabels.add(lblAzul);
		geniusLabels.add(lblAmarelo);
		geniusLabels.add(lblVermelho);
		geniusLabels.add(lblVerde);
		for (int i = 0; i < geniusLabels.size(); i++) {
			this.add(geniusLabels.get(i));
		}

	}

	public void getInformacoes(final GeniusLabels botao) {
		final boolean naoPerdeu;
		final boolean eraUltimaJogada = jogo.ehUltimaJogaga();
		System.out.println("É o último:" + jogo.ehUltimaJogaga());
		naoPerdeu = jogo.analisaJogada((long) 0, (long) 0, botao.getCor());
		try {
			botao.pisca();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
		this.atualizaInformacoes();
		if (!naoPerdeu) {// ou seja perdeu
			btnIniciar.setEnabled(true);
		}
		if (eraUltimaJogada && naoPerdeu) {
			if (!thread.isAlive()) {
				thread.start();
			}
		}
		return;
	};

	private void atualizaInformacoes() {
		lblNomeJogador.setText(jogo.getJogadorAtual().getApelido());
		lblPontos.setText("" + jogo.getJogadorAtual().getPontos());
	}

	public Thread getThread() {
		return this.thread;
	}

	@Override
	public synchronized void run() {
		this.sequenciadeCoresaExibir = jogo.getSequencia();
		System.out.println(sequenciadeCoresaExibir);
		try {
			this.thread.join(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < sequenciadeCoresaExibir.size(); i++) {
			try {
				geniusLabels.get(sequenciadeCoresaExibir.get(i)).pisca();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				e.printStackTrace();
			}
			try {
				this.thread.join(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.thread = new Thread(this);
	}

}
