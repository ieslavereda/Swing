package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.awt.event.ActionEvent;

public class Ejemplo2Table extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private ArrayList<Alumno> alumnos;
	private JComboBox comboBox;

	/**
	 * Create the frame.
	 */
	public Ejemplo2Table(ArrayList<Alumno> alumnos) {

		this.alumnos = alumnos;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 707, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panelSuperior = new JPanel();

		JPanel panelCentral = new JPanel();

		JPanel panelInferior = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_contentPane.createSequentialGroup().addContainerGap().addGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelCentral, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
						.addComponent(panelSuperior, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
						.addComponent(panelInferior, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(panelSuperior, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panelCentral, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panelInferior, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)));
		panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Nombre", "Apellidos" }));
		panelSuperior.add(comboBox);

		JButton btnNewButton = new JButton("Sort");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort();
			}
		});
		panelSuperior.add(btnNewButton);
		panelInferior.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAlumno();
			}
		});
		panelInferior.add(btnDelete);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ejemplo2Add frame = new Ejemplo2Add(alumnos);
				frame.setVisible(true);
			}
		});
		panelInferior.add(btnAdd);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panelInferior.add(btnCancelar);
		panelCentral.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelCentral.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);

		rellenarTabla(alumnos);
	}

	protected void deleteAlumno() {
		
		alumnos.remove(table.getSelectedRow());
		rellenarTabla(alumnos);
		
	}

	protected void sort() {
		String sortValue = comboBox.getSelectedItem().toString();
		
		if(sortValue.compareToIgnoreCase("Nombre")==0)
			Collections.sort(alumnos,new Comparator<Alumno>() {
				public int compare(Alumno o1, Alumno o2) {
					return o1.getNombre().compareTo(o2.getNombre());
				}
			});
		else {
			Collections.sort(alumnos);
		}			
		rellenarTabla(alumnos);
	}

	private void rellenarTabla(ArrayList<Alumno> alumnos) {

		DefaultTableModel dtm = new DefaultTableModel();
		
		dtm.addColumn("Nombre");
		dtm.addColumn("Apellidos");
		dtm.addColumn("Telefono");

		Object[] row;

		for (Alumno a : alumnos) {

			row = new Object[3];

			row[0] = a.getNombre();
			row[1] = a.getApellidos();
			row[2] = a.getTelefono();

			dtm.addRow(row);
		}

		table.setModel(dtm);

	}

}
