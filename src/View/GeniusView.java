package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.io.File;

public class GeniusView {

	private JFrame frame;
	private final String basePath;
	private final String imagesBasePath;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {

		// mudança de view

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			System.out.println(ex);
		}

		// mudança de view

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
	 */
	public GeniusView() {
		basePath = new File("").getAbsolutePath() + "\\";
		imagesBasePath = basePath + new File("src\\imagens").getPath() + "\\";
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFocusable(true);
		frame.requestFocusInWindow();
		JTabbedPane tabbedPane = new JTabbedPane();
		frame.setBounds(0, 0, 1440, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setVisible(true);
		tabbedPane.setEnabled(false);
		tabbedPane.setUI(new MyJTabbedPaneUI());
		TelaInicial telaInicial = new TelaInicial(tabbedPane);
		tabbedPane.addTab("Tela Inicial", telaInicial);
		frame.setContentPane(tabbedPane);

	}
}
