package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JButton;

public class Ejemplo4View extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Ejemplo4View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 512);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setIcon(new ImageIcon(Ejemplo4View.class.getResource("/images/file40.png")));
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon(Ejemplo4View.class.getResource("/images/exit40.png")));
		mnFile.add(mntmExit);
		
		JMenu mnNewMenu = new JMenu("Sesion");
		menuBar.add(mnNewMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}
}
