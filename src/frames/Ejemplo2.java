package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Ejemplo2 extends JFrame {

	private JPanel contentPane;
	public ArrayList<Alumno> alumnos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo2 frame = new Ejemplo2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejemplo2() {
		
		alumnos = new ArrayList<Alumno>();
		alumnos.add(new Alumno("Joaquin", "Alonso", 66666));
		alumnos.add(new Alumno("Pedro", "Martinez", 77777));
		alumnos.add(new Alumno("Teresa", "Lopez", 88888));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 190, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[47.00,grow]", "[][][]"));
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ejemplo2Add frame = new Ejemplo2Add(alumnos);
				frame.setVisible(true);
			}
		});
		contentPane.add(btnAdd, "cell 0 0,growx");
		
		JButton btnTable = new JButton("Table");
		btnTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ejemplo2Table frameTable = new Ejemplo2Table(alumnos);
				frameTable.setVisible(true);
			}
		});
		contentPane.add(btnTable, "cell 0 1,growx");
		
		JButton btnNewButton = new JButton("Text");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(alumnos);
			}
		});
		contentPane.add(btnNewButton, "cell 0 2,growx");
	}

}
