package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class Ejemplo1 extends JFrame {

	private JPanel contentPane;
	private JButton btnLeft;
	private JButton btnRemove;
	private JButton btnAdd;
	private JButton btnClear;
	private JButton btnRight;
	private JTextField textFieldApellidos;
	private JTextField textFieldTelefono;
	private JTextField textFieldNombre;
	private Queue<Alumno> alumnos;
	private Nodo<Alumno> aux;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo1 frame = new Ejemplo1();
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
	public Ejemplo1() {

		alumnos = new Queue<Alumno>();
//		alumnos.add(new Alumno("Joaquin", "Alonso", 66666));
//		alumnos.add(new Alumno("Pedro", "Martinez", 77777));
//		alumnos.add(new Alumno("Teresa", "Lopez", 88888));
		aux = alumnos.getHead();

		setTitle("Mi primer Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panelSuperior = new JPanel();
		panelSuperior.setBorder(
				new TitledBorder(null, "Alumno", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));

		JPanel panelInferior = new JPanel();
		panelInferior.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelSuperior, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panelInferior, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 381,
										Short.MAX_VALUE))
						.addGap(8)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addContainerGap()
								.addComponent(panelSuperior, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE).addGap(18)
								.addComponent(panelInferior, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 5));

		btnLeft = new JButton("<");
		btnLeft.setEnabled(false);
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aux = aux.getPrev();
				btnRight.setEnabled(true);
				showNode(aux);
				if (aux.getPrev() == null)
					btnLeft.setEnabled(false);
			}
		});
		panelInferior.add(btnLeft);

		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeNode();
			}
		});
		panelInferior.add(btnRemove);

		btnAdd = new JButton("Add");
		btnAdd.setEnabled(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAlumno();
			}
		});
		panelInferior.add(btnAdd);

		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarFormulario();
			}
		});
		panelInferior.add(btnClear);

		btnRight = new JButton(">");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnLeft.setEnabled(true);

				aux = aux.getNext();
				showNode(aux);

				if (aux.getNext() == null)
					btnRight.setEnabled(false);
			}
		});
		panelInferior.add(btnRight);

		JLabel lblNombre = new JLabel("Nombre");

		JLabel lblApellidos = new JLabel("Apellidos");

		JLabel lblTelefono = new JLabel("Teléfono");

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);

		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);

		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		GroupLayout gl_panelSuperior = new GroupLayout(panelSuperior);
		gl_panelSuperior.setHorizontalGroup(gl_panelSuperior.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSuperior.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelSuperior.createParallelGroup(Alignment.LEADING).addComponent(lblNombre)
								.addComponent(lblApellidos).addComponent(lblTelefono))
						.addGap(28)
						.addGroup(gl_panelSuperior.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelSuperior.createSequentialGroup()
										.addComponent(textFieldTelefono, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE))
								.addComponent(textFieldNombre, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
								.addComponent(textFieldApellidos, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
						.addContainerGap()));
		gl_panelSuperior.setVerticalGroup(gl_panelSuperior.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSuperior.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelSuperior.createParallelGroup(Alignment.BASELINE).addComponent(lblNombre)
								.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelSuperior.createParallelGroup(Alignment.BASELINE).addComponent(lblApellidos)
								.addComponent(textFieldApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelSuperior.createParallelGroup(Alignment.BASELINE).addComponent(lblTelefono)
								.addComponent(textFieldTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(130, Short.MAX_VALUE)));
		panelSuperior.setLayout(gl_panelSuperior);
		contentPane.setLayout(gl_contentPane);

		showNode(aux);
	}

	protected void removeNode() {
		alumnos.remove(aux);
		aux = alumnos.getHead();
		showNode(aux);
	}

	protected void addAlumno() {

		String nombre = textFieldNombre.getText();
		String apellidos = textFieldApellidos.getText();
		int telefono = Integer.parseInt(textFieldTelefono.getText());

		alumnos.add(new Alumno(nombre, apellidos, telefono));

		aux = alumnos.getHead();

		while (aux.getNext() != null)
			aux = aux.getNext();

		showNode(aux);

		btnAdd.setEnabled(false);
		btnClear.setEnabled(true);
		btnRemove.setEnabled(true);

	}

	private void borrarFormulario() {

		btnAdd.setEnabled(true);
		btnClear.setEnabled(false);

		textFieldNombre.setText("");
		textFieldApellidos.setText("");
		textFieldTelefono.setText("");
	}

	private void showNode(Nodo<Alumno> nodo) {

		btnRight.setEnabled(true);
		btnLeft.setEnabled(true);

		if (nodo == null) {
			btnRight.setEnabled(false);
			btnLeft.setEnabled(false);
			btnRemove.setEnabled(false);

			borrarFormulario();

		} else {
			if (nodo.getPrev() == null) {
				btnLeft.setEnabled(false);
			}
			if (nodo.getNext() == null) {
				btnRight.setEnabled(false);
			}
		}

		if (nodo != null) {
			textFieldNombre.setText(nodo.getInfo().getNombre());
			textFieldApellidos.setText(nodo.getInfo().getApellidos());
			textFieldTelefono.setText(String.valueOf(nodo.getInfo().getTelefono()));
		}

	}
}
