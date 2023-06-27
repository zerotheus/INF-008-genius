package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
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

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

import Negocio.Genius;
import Negocio.Jogador;
import View.geniusLabels.AmareloLabel;
import View.geniusLabels.AzulLabel;
import View.geniusLabels.GeniusLabels;
import View.geniusLabels.VerdeLabel;
import View.geniusLabels.VermelhoLabel;

public class TelaJogo extends MyJPanel implements Runnable {

	private Genius genius;
	private List<Integer> sequenciadeCoresaExibir;
	private List<GeniusLabels> geniusLabels = new ArrayList<GeniusLabels>();
	private Thread thread = new Thread(this);
	private JTabbedPane tabbedPane;
	private JLabel lblNomeJogador;
	private JLabel lblPontos;
	private JLabel lblPontosGanhosnaRodada;
	private MyJLabelwithSound btnIniciar;
	private MyJLabelwithSound btnExtras;
	private final Clock clock = Clock.systemDefaultZone();
	private long instantedofimdaExibicao;
	private boolean modoMonoCorAtivado = false;

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
				try {
					genius = genius.mudaDificuldade();
				} catch (Exception e1) {
					e1.printStackTrace();
					return;
				}
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
		btnSalvar.setBounds(1223, 293, 190, 70);
		btnSalvar.setVisible(true);
		this.add(btnSalvar);

		MyJLabelwithSound btnCarregar = new MyJLabelwithSound();
		btnCarregar.setBounds(1212, 716, 190, 70);
		btnCarregar.setVisible(true);
		this.add(btnCarregar);

		btnExtras = new MyJLabelwithSound();
		btnExtras.setBounds(1212, 506, 190, 70);
		btnExtras.setVisible(true);
		this.add(btnExtras);

		JLabel lblFundoJogo = new JLabel();
		lblFundoJogo.setIcon(new ImageIcon(this.getImagesPath() + "fundojOGO.png"));
		lblFundoJogo.setBounds(0, 0, 1444, 881);
		this.add(lblFundoJogo);

		btnExtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnExtras != e.getSource()) {
					return;
				}
				final String[] modos = { "MonoCor", "Treinar" };
				final String retorno;
				retorno = (String) JOptionPane.showInputDialog(null,
						"Ative ou desative modos de Jogo",
						"Modos Extras",
						-1,
						null,
						modos, modos[0]);
				if (retorno == null) {
					return;
				}
				if (retorno.equals("MonoCor")) {
					ativaDesativaModoMonoCor();
					return;
				}
				if (retorno.equals("Treinar")) {
					try {
						jogo.ativaDesativaTreino();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					return;
				}
			}
		});/* Adiciona ação de mudar para os modos extras do jogo */

		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!btnIniciar.isEnabled()) {
					return;
				}
				btnIniciar.setEnabled(false);
				btnExtras.setEnabled(false);
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
				File saves = new File("src\\Saves");
				fc.setCurrentDirectory(saves);
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
		});/*
			 * Método utilizado para salvar um jogo quando apertar o botão "Salvar".
			 * O método salva somente arquivos .obj. Ele possui um filtro para que não seja
			 * possível salvar ".obj.obj".
			 * Se já possuir .obj, ele salva sem adicionar o .obj de novo
			 */

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

				File saves = new File("src\\Saves");
				fc.setCurrentDirectory(saves);
				int returnVal = fc.showOpenDialog(lblFundoJogo);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					if (filter.accept(file)) {
						try {
							FileInputStream fis = new java.io.FileInputStream(file);
							ObjectInputStream is = new ObjectInputStream(fis);
							genius = (Genius) is.readObject();
							is.close();
						} catch (IOException | ClassNotFoundException e1) {
							e1.printStackTrace();
						}
						atualizaInformacoes();
						btnIniciar.setEnabled(true);
						MyJPanel telaJogoCarregado = new TelaJogo(tabbedPane, genius);
						tabbedPane.insertTab("Placar", null, telaJogoCarregado, TOOL_TIP_TEXT_KEY, 1);
						tabbedPane.remove(0);
					} else
						JOptionPane.showMessageDialog(lblFundoJogo, "Arquivo não suportado. Use somente arquivos .obj");
				}
			}
		});
	}/*
		 * Método utilizado para carregar um jogo quando apertar o botão "Carregar".
		 * O método utiliza um filter para poder carregar somente arquivos .obj
		 */
	private void keyAndMouseMapping(GeniusLabels geniusLabel) {
		geniusLabel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(geniusLabel.getKeyChar()),
				geniusLabel.toString());
		geniusLabel.getActionMap().put(geniusLabel.toString(), new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					getInformacoes(geniusLabel);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		geniusLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != geniusLabel) {
					return;
				}
				try {
					getInformacoes(geniusLabel);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		atualizaInformacoes();
	}/*
		 * método que é utilizado para selecionar o botão do jogo com mouse ou teclado
		 */

	private void instanciaBotoes() {

		lblPontos = new JLabel("" + genius.getJogadorAtual().getPontos());
		lblPontos.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 34));
		lblPontos.setForeground(new Color(255, 255, 255));
		lblPontos.setBounds(175, 589, 67, 57);
		this.add(lblPontos);

		lblPontosGanhosnaRodada = new JLabel("+" + genius.getJogadorAtual().getPontos());
		lblPontosGanhosnaRodada.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 34));
		lblPontosGanhosnaRodada.setForeground(new Color(255, 255, 255));
		lblPontosGanhosnaRodada.setBounds(175, 629, 67, 57);
		// lblPontosGanhosnaRodada.setVisible(false);
		this.add(lblPontosGanhosnaRodada);

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

	private void getInformacoes(final GeniusLabels botao) throws Exception {

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
		if (genius.jogofoiEncerrado()) {
			jogador.setTempoTotal();
			MyJPanel telaPlacar = new TelaPlacar(tabbedPane, genius);
			JOptionPane.showMessageDialog(null, "Fim de jogo", "Fim de jogo", 2);
			this.tabbedPane.insertTab("Placar", null, telaPlacar, TOOL_TIP_TEXT_KEY, 1);
			this.tabbedPane.remove(0);
			return;
		}
		if (!naoPerdeu) {// ou seja perdeu
			btnIniciar.setEnabled(true);
			btnExtras.setEnabled(true);
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
	};/*
		 * método que pega o jogador atual, verifica se ele perdeu, faz o botão
		 * pressionado piscar, faz o placar do jogo caso
		 * finalizado, atualiza informações na tela do jogo
		 */

	private void ativaDesativaModoMonoCor() {
		if (!modoMonoCorAtivado) {
			for (GeniusLabels geniusLabel : geniusLabels) {
				geniusLabel.setImagemParaRosa();
			}
			modoMonoCorAtivado = true;
			return;
		}
		for (GeniusLabels geniusLabel : geniusLabels) {
			geniusLabel.setImagemPadrao();
		}
		System.out.println("ativou");
		modoMonoCorAtivado = false;
		return;
	}/* Método que modifica as cores dos botões do jogo */

	private void atualizaInformacoes() {
		lblNomeJogador.setText(genius.getJogadorAtual().getApelido());
		lblPontos.setText("" + genius.getJogadorAtual().getPontos());
		lblPontosGanhosnaRodada.setText("+" + (genius.getJogadorAtual().getPontosFeitosnaUltimaRodada()));
	}/* mini placar da tela de jogo */

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
	}/* método que guarda a sequencia de cores e exibe na tela */

}
