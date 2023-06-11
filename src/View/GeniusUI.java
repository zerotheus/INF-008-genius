package View;
    
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.io.File;


public class GeniusUI {
	private JFrame frame;
	private final String basePath;
	private final String imagesBasePath;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeniusUI window = new GeniusUI();
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
	public GeniusUI() {
		basePath = new File("").getAbsolutePath() + "\\";
		imagesBasePath = basePath + new File("src\\imagens").getPath() + "\\";
		System.out.println(imagesBasePath);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFocusable(true);
		frame.requestFocusInWindow();
		System.out.println(frame.isFocused());
		JTabbedPane tabbedPane = new JTabbedPane();
		frame.setBounds(0, 0, 1440, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setVisible(true);
		tabbedPane.setEnabled(false);
		tabbedPane.setUI(new MyJTabbedPaneUI());
		TelaInicial telaInicial = new TelaInicial(tabbedPane);
		tabbedPane.addTab("Tela Inicial", telaInicial);
		System.out.println(tabbedPane.getUI());
		System.out.println(tabbedPane.getUI().getClass());
		frame.setContentPane(tabbedPane);

	}
}