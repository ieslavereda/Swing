package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ejemplo3View extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTable table;
	private JSlider slider;
	private JButton btnAdd;
	private JLabel labelEdad;
	private JButton btnDelete;

	/**
	 * Create the frame.
	 */
	public Ejemplo3View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(7))
		);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		btnDelete = new JButton("delete");
		panel_2.add(btnDelete);
		
		btnAdd = new JButton("Add");
		panel_2.add(btnAdd);
		panel.setLayout(new MigLayout("", "[][grow][][36.00,grow][][20][]", "[]"));
		
		JLabel lblNombre = new JLabel("Nombre");
		panel.add(lblNombre, "cell 0 0,alignx trailing");
		
		textFieldNombre = new JTextField();
		panel.add(textFieldNombre, "cell 1 0,growx");
		textFieldNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		panel.add(lblApellidos, "cell 2 0,alignx trailing");
		
		textFieldApellidos = new JTextField();
		panel.add(textFieldApellidos, "cell 3 0,growx");
		textFieldApellidos.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Edad");
		panel.add(lblNewLabel, "cell 4 0");
		
		labelEdad = new JLabel("0");
		panel.add(labelEdad, "cell 5 0,alignx center");
		
		slider = new JSlider();
		panel.add(slider, "cell 6 0,growx");
		contentPane.setLayout(gl_contentPane);
		
		inicializar();
	}
	
	private void inicializar() {
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {				
				labelEdad.setText(String.valueOf(slider.getValue()));				
			}			
		});		
		slider.setValue(25);		
		labelEdad.setText(String.valueOf(slider.getValue()));
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Nombre");
		dtm.addColumn("Apellidos");
		dtm.addColumn("Edad");
		
		table.setModel(dtm);
	}

	protected JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	protected JTextField getTextFieldApellidos() {
		return textFieldApellidos;
	}

	protected JTable getTable() {
		return table;
	}

	protected JSlider getSlider() {
		return slider;
	}

	protected JButton getBtnAdd() {
		return btnAdd;
	}

	protected JButton getBtnDelete() {
		return btnDelete;
	}
		
}
