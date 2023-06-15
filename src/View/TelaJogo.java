package View;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import Negocio.Genius;
import Negocio.Jogador;
import View.geniusLabels.*;
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
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

public class TelaJogo extends MyJPanel implements Runnable {

	private Genius genius;
	private List<Integer> sequenciadeCoresaExibir;
	private List<GeniusLabels> geniusLabels = new ArrayList<GeniusLabels>();
	private Thread thread = new Thread(this);
	private JTabbedPane tabbedPane;
	private JLabel lblNomeJogador;
	private JLabel lblPontos;
	private MyJLabelwithSound btnIniciar;
	private final Clock clock = Clock.systemDefaultZone();
	private long instantedofimdaExibicao;
	private boolean modosemcoresAtivado = false;

	public TelaJogo(JTabbedPane tabbedPane, Genius jogo) {
		super();
		this.tabbedPane = tabbedPane;
		this.genius = jogo;
		this.instanciaBotoes();

		MyJLabelwithSound btnRitmSound = new MyJLabelwithSound();
		btnRitmSound.setBounds(714, 405, 44, 45);
		this.add(btnRitmSound);
		btnRitmSound.setVisible(true);

		MyJLabelwithSound btnDificuldade = new MyJLabelwithSound();
		btnDificuldade.setBounds(800, 405, 44, 45);
		this.add(btnDificuldade);
		btnDificuldade.setVisible(true);

		btnDificuldade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnRitmSound.startSound();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
				}
				genius = genius.mudaDificuldade();
				JOptionPane.showMessageDialog(null, "Dificuldade mudada para " + genius.getDificuldade(), "DIFICULDADE",
						1);
			}
		});

		btnRitmSound.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnRitmSound.startSound();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
				}
				genius.setRitmo();
				JOptionPane.showMessageDialog(null, "Ritmo mudado para " + genius.getRitmo(), "RITMO", 1);
			}
		});

		btnIniciar = new MyJLabelwithSound();
		btnIniciar.setBounds(1223, 87, 190, 70);
		btnIniciar.setVisible(true);
		this.add(btnIniciar);

		MyJLabelwithSound btnSalvar = new MyJLabelwithSound();
		btnSalvar.setText("TOOL_TIP_TEXT_KEY");
		btnSalvar.setBounds(1223, 293, 190, 70);
		btnSalvar.setVisible(true);
		this.add(btnSalvar);

		MyJLabelwithSound btnCarregar = new MyJLabelwithSound();
		btnCarregar.setBounds(1212, 716, 190, 70);
		btnCarregar.setVisible(true);
		this.add(btnCarregar);

		MyJLabelwithSound btnExtras = new MyJLabelwithSound();
		btnExtras.setBounds(1212, 506, 190, 70);
		btnExtras.setVisible(true);
		this.add(btnExtras);

		JLabel lblFundoJogo = new JLabel();
		lblFundoJogo.setIcon(new ImageIcon(this.getImagesPath() + "fundojOGO.png"));
		lblFundoJogo.setBounds(0, 0, 1444, 881);
		this.add(lblFundoJogo);

		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!btnIniciar.isEnabled()) {
					return;
				}
				btnIniciar.setEnabled(false);
				genius.inciaRodada();
				genius.getJogadorAtual().setTempoInicial();
				try {
					btnIniciar.startSound();
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
				FileNameExtensionFilter filter = new FileNameExtensionFilter("OBJ file", "obj");
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(lblFundoJogo);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					if (!filter.accept(file)) {
						File newFile = new File(file.toString() + ".obj");
						file = newFile;
					}
					try {
						FileOutputStream fileStream = new FileOutputStream(file);
						ObjectOutputStream os = new ObjectOutputStream(fileStream);
						os.writeObject(genius);
						os.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		btnCarregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnCarregar.startSound();
				} catch (Exception e1) {
					System.out.println(e.toString());
				}
				FileNameExtensionFilter filter = new FileNameExtensionFilter("OBJ file", "obj");
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(lblFundoJogo);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					if (filter.accept(file)) {
						File newFile = new File(file.toString() + ".obj");
						file = newFile;
						try {
							FileInputStream fis = new java.io.FileInputStream(file);
							ObjectInputStream is = new ObjectInputStream(fis);
							genius = (Genius) is.readObject();
							is.close();
						} catch (IOException | ClassNotFoundException e1) {
							e1.printStackTrace();
						}
						atualizaInformacoes();
					} else
						JOptionPane.showMessageDialog(lblFundoJogo, "Arquivo não suportado. Use somente arquivos .obj");
				}
			}
		});
	}

	private void keyAndMouseMapping(GeniusLabels geniusLabel) {
		geniusLabel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(geniusLabel.getKeyChar()),
				geniusLabel.toString());
		geniusLabel.getActionMap().put(geniusLabel.toString(), new KeyButtonMaps(geniusLabel, this));
		geniusLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != geniusLabel) {
					return;
				}
				getInformacoes(geniusLabel);
			}
		});
	}

	private void instanciaBotoes() {

		lblPontos = new JLabel("" + genius.getJogadorAtual().getPontos());
		lblPontos.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 34));
		lblPontos.setForeground(new Color(255, 255, 255));
		lblPontos.setBounds(175, 589, 67, 57);
		this.add(lblPontos);

		lblNomeJogador = new JLabel(genius.getJogadorAtual().getApelido());
		lblNomeJogador.setForeground(new Color(255, 255, 255));
		lblNomeJogador.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 22));
		lblNomeJogador.setBounds(95, 221, 241, 39);
		this.add(lblNomeJogador);

		GeniusLabels lblAzul = new AzulLabel();
		lblAzul.setBounds(447, 78, 322, 316);
		lblAzul.setIcon(new ImageIcon(this.getImagesPath() + "azul.png"));
		GeniusLabels lblVermelho = new VermelhoLabel();
		lblVermelho.setIcon(new ImageIcon(this.getImagesPath() + "vermelho 1.png"));
		lblVermelho.setBounds(447, 474, 322, 316);
		GeniusLabels lblAmarelo = new AmareloLabel();
		lblAmarelo.setIcon(new ImageIcon(this.getImagesPath() + "amarelo 1.png"));
		lblAmarelo.setBounds(807, 78, 322, 316);
		GeniusLabels lblVerde = new VerdeLabel();
		lblVerde.setIcon(new ImageIcon(this.getImagesPath() + "verde 1.png"));
		lblVerde.setBounds(807, 474, 322, 316);

		geniusLabels.add(lblAzul);
		geniusLabels.add(lblAmarelo);
		geniusLabels.add(lblVermelho);
		geniusLabels.add(lblVerde);
		for (int i = 0; i < geniusLabels.size(); i++) {
			this.add(geniusLabels.get(i));
			keyAndMouseMapping(geniusLabels.get(i));
		}
	}

	public void getInformacoes(final GeniusLabels botao) {
		if (thread.isAlive() || !genius.jogoEstaAtivo()) {
			return;
		}
		final Jogador jogador = genius.getJogadorAtual();
		final boolean eraUltimaJogada = genius.ehUltimaJogada();
		final boolean naoPerdeu = genius.analisaJogada(instantedofimdaExibicao, botao.getCor());
		try {
			botao.pisca();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
		this.atualizaInformacoes();
		if (genius.jogofoiEncerado()) {
			jogador.setTempoTotal();
			MyJPanel telaPlacar = new TelaPlacar(tabbedPane, genius);
			JOptionPane.showMessageDialog(null, "Fim de jogo", "Fim de jogo", 2);
			this.tabbedPane.insertTab("Placar", null, telaPlacar, TOOL_TIP_TEXT_KEY, 1);
			this.tabbedPane.remove(0);
			return;
		}
		if (!naoPerdeu) {// ou seja perdeu
			btnIniciar.setEnabled(true);
			this.atualizaInformacoes();
			jogador.setTempoTotal();
			if (genius.ehmododeTreino()) {
				JOptionPane.showMessageDialog(null, "Tente novamente", "Errou a Sequencia",
						2);
				thread.start();
				return;
			}
			JOptionPane.showMessageDialog(null, jogador.getApelido() + " Por favor passe a vez", "Errou a Sequencia",
					2);
			return;
		}
		if (eraUltimaJogada && naoPerdeu) {
			if (!thread.isAlive()) {
				thread.start();
			}
		}
		return;
	};

	private void ativaDesativaModoSemCores() {
		if (modosemcoresAtivado) {
			for (GeniusLabels geniusLabel : geniusLabels) {
				geniusLabel.setImagemParaRosa();
			}
			modosemcoresAtivado = true;
			return;
		}
		for (GeniusLabels geniusLabel : geniusLabels) {
			geniusLabel.setImagemPadrao();
		}
		modosemcoresAtivado = false;
		return;
	}

	private void atualizaInformacoes() {
		lblNomeJogador.setText(genius.getJogadorAtual().getApelido());
		lblPontos.setText("" + genius.getJogadorAtual().getPontos());
	}

	@Override
	public synchronized void run() {
		this.sequenciadeCoresaExibir = genius.getSequencia();
		System.out.println(sequenciadeCoresaExibir);
		try {
			this.thread.join(600);
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
		instantedofimdaExibicao = clock.millis();
		this.thread = new Thread(this);
	}

}
