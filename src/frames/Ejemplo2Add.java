package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Ejemplo2Add extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldTelefono;
	
	private ArrayList<Alumno> alumnos;


	/**
	 * Create the frame.
	 */
	public Ejemplo2Add(ArrayList<Alumno> alumnos) {
		
		this.alumnos=alumnos;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 375, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(4)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAlumno();
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_1.add(btnCancel);
		panel.setLayout(new MigLayout("", "[][grow]", "[][][][][][]"));
		
		JLabel lblNombre = new JLabel("Nombre");
		panel.add(lblNombre, "cell 0 1,alignx trailing");
		
		textFieldNombre = new JTextField();
		panel.add(textFieldNombre, "cell 1 1,growx");
		textFieldNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		panel.add(lblApellidos, "cell 0 3,alignx trailing");
		
		textFieldApellidos = new JTextField();
		panel.add(textFieldApellidos, "cell 1 3,growx");
		textFieldApellidos.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		panel.add(lblTelefono, "cell 0 5,alignx trailing");
		
		textFieldTelefono = new JTextField();
		panel.add(textFieldTelefono, "cell 1 5,growx");
		textFieldTelefono.setColumns(10);
		contentPane.setLayout(gl_contentPane);
	}



	private void addAlumno() {
		
		String nombre = textFieldNombre.getText();
		String apellidos = textFieldApellidos.getText();
		int telefono = Integer.parseInt(textFieldTelefono.getText());
		
		Alumno a = new Alumno(nombre,apellidos,telefono);
		
		alumnos.add(a);
		
		clean();
	}
	
	private void clean() {
		textFieldNombre.setText("");
		textFieldApellidos.setText("");
		textFieldTelefono.setText("");
	}
	
}
