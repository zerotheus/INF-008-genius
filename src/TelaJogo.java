package View;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.plaf.FileChooserUI;

import Enums.Cor;
import Negocio.Genius;
import Negocio.Jogador;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TelaJogo extends MyJPanel implements Runnable {

	private final String imagensPath;
	long millis = 0;
	long segundos = 0;
	private Genius jogo;
	private boolean eraUltimaJogada;
	private boolean naoPerdeu = true;
	private List<Integer> sequenciadeCoresaExibir;
	private List<GeniusLabels> geniusLabels = new ArrayList<>();
	private Thread thread = new Thread(this);
	private JTabbedPane tabbedPane;

	public TelaJogo(JTabbedPane tabbedPane, Genius jogo) {
		super();
		this.tabbedPane = tabbedPane;
		imagensPath = this.getImagesPath();
		this.setLayout(null);
		this.jogo = jogo;

		this.instanciabotoes();

		JButton btnDificuldade = new JButton();
		btnDificuldade.setBounds(714, 405, 44, 45);
		this.add(btnDificuldade);
		btnDificuldade.setVisible(false);

		MyJLabelwithSound btnSalvar = new MyJLabelwithSound();
		btnSalvar.setBounds(1223, 405, 173, 57);
		btnSalvar.setVisible(true);
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
		
		MyJLabelwithSound btnCarregar = new MyJLabelwithSound();
		btnCarregar.setBounds(1223, 720, 164, 57);
		this.add(btnCarregar);
		btnCarregar.setVisible(true);

		MyJLabelwithSound btnIniciar = new MyJLabelwithSound();
		btnIniciar.setBounds(1223, 89, 173, 55);
		this.add(btnIniciar);
		btnIniciar.setEnabled(true);
		btnIniciar.setVisible(true);
		
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
		             
		            //This is where a real application would open the file.
		        }
		        JPanel telaPlacar = new TelaPlacar(tabbedPane, jogo);
				tabbedPane.insertTab("Genius", null, telaPlacar, TOOL_TIP_TEXT_KEY, 1);
				tabbedPane.removeTabAt(0);

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
				Genius jogoCarregado = null;
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(lblFundoJogo);

		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            try {
						FileInputStream  fis = new java.io.FileInputStream(file);
						ObjectInputStream is = new ObjectInputStream(fis);
						jogoCarregado = (Genius) is.readObject();
					} catch (IOException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		             
		            //This is where a real application would open the file.
		        }
				JPanel telaPlacar = new TelaPlacar(tabbedPane, jogoCarregado);
				tabbedPane.insertTab("Genius", null, telaPlacar, TOOL_TIP_TEXT_KEY, 1);
				tabbedPane.removeTabAt(0);

			}
		});

		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!thread.isAlive()) {
					thread.start();
					return;
				}		
				thread.run();
				
			}
		});
	}

	public void instanciabotoes() {

		GeniusLabels lblAzul = new GeniusLabels("azul.png", "azul branco.png", "La.wav");
		lblAzul.setBounds(447, 78, 322, 316);
		lblAzul.setIcon(new ImageIcon(this.getImagesPath() + "azul.png"));
		lblAzul.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lblAzul) {
					return;
				}
				naoPerdeu = jogo.analisaJogada((long) 0, (long) 0, Cor.azul);
				lblAzul.pisca();
				System.out.println("É o último:"+jogo.ehUltimaJogaga());
				if(jogo.ehUltimaJogaga() == true && naoPerdeu == true) {
					if(Cor.azul.ordinal() == jogo.getUltimoElemento()) {
						if (!thread.isAlive()) {
							thread.start();
							return;
						}	
						try {
							thread.wait(300);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog( lblAzul, "Acertou!");
						thread.run();
					}
				}
			}
		});
		GeniusLabels lblVermelho = new GeniusLabels("vermelho 1.png", "vermelho branco.png", "Si.wav");
		lblVermelho.setIcon(new ImageIcon(this.getImagesPath() + "vermelho 1.png"));
		lblVermelho.setBounds(447, 474, 322, 316);
		lblVermelho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lblVermelho) {
					return;
				}
				naoPerdeu = jogo.analisaJogada((long) 0, (long) 0, Cor.vermelho);
				lblVermelho.pisca();
				System.out.println("É o último:"+jogo.ehUltimaJogaga());
				if(jogo.ehUltimaJogaga() == true && naoPerdeu == true) {
					if(Cor.vermelho.ordinal() == jogo.getUltimoElemento()) {
						if (!thread.isAlive()) {
							thread.start();
							return;
						}	
						try {
							thread.wait(300);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog( lblVermelho, "Acertou!");
						thread.run();
					}
				}
			}
		});
		GeniusLabels lblAmarelo = new GeniusLabels("amarelo 1.png", "amarelo branco.png", "Re.wav");
		lblAmarelo.setIcon(new ImageIcon(this.getImagesPath() + "amarelo 1.png"));
		lblAmarelo.setBounds(807, 78, 322, 316);
		GeniusLabels lblVerde = new GeniusLabels("verde 1.png", "verde branco.png", "Mi.wav");
		lblAmarelo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != lblAmarelo) {
					return;
				}
				lblAmarelo.pisca();
				System.out.println("É o último:"+jogo.ehUltimaJogaga());
				naoPerdeu = jogo.analisaJogada((long) 0, (long) 0, Cor.amarelo);
				if(jogo.ehUltimaJogaga() == true && naoPerdeu == true) {
					if(Cor.amarelo.ordinal() == jogo.getUltimoElemento()) {
						thread.start();
						return;
					}	
					try {
						thread.wait(200);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog( lblAmarelo, "Acertou!");
					thread.run();
				}
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
				naoPerdeu = jogo.analisaJogada((long) 0, (long) 0, Cor.verde);
				lblVerde.pisca();
				System.out.println("É o último:"+jogo.ehUltimaJogaga());
				if(jogo.ehUltimaJogaga() == true && naoPerdeu == true) {
					if(Cor.verde.ordinal() == jogo.getUltimoElemento()) {
						if (!thread.isAlive()) {
							thread.start();
							return;
						}	
						try {
							thread.wait(300);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog( lblVerde, "Acertou!");
						thread.run();
					}
				}
			}
		});
		lblAzul.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('w'), "W");
		lblAzul.getActionMap().put("W", new KeyButtonMaps(this.tabbedPane, lblAzul, this));

		geniusLabels.add(lblAzul);
		geniusLabels.add(lblAmarelo);
		geniusLabels.add(lblVermelho);
		geniusLabels.add(lblVerde);
		for (int i = 0; i < geniusLabels.size(); i++) {
			this.add(geniusLabels.get(i));

		}

	}

	public synchronized void exibeSequencia() {
		this.sequenciadeCoresaExibir = jogo.getSequencia();
		for (int i = 0; i < sequenciadeCoresaExibir.size(); i++) {
			// geniusLabels.get(sequenciadeCoresaExibir.get(i)).pisca();
			final Thread thread = new Thread(geniusLabels.get(i));
			try {
				thread.start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public synchronized void run() {
		this.sequenciadeCoresaExibir = jogo.getSequencia();
		System.out.println(sequenciadeCoresaExibir);
		for (int i = 0; i < sequenciadeCoresaExibir.size(); i++) {
			geniusLabels.get(sequenciadeCoresaExibir.get(i)).pisca();
			try {
				this.thread.join(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.thread = new Thread(this);
	}

	public Thread getThread() {
		return this.thread;
	}

}
