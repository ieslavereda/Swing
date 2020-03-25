package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import frames.Alumno.SEXO;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

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
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JComboBox comboBoxProvincia;
	private final String[] provincias = {"Álava","Albacete","Alicante","Almería","Asturias","Ávila","Badajoz","Barcelona","Burgos","Cáceres","Cádiz","Cantabria","Castellón","Ciudad Real","Córdoba","La Coruña","Cuenca","Gerona","Granada","Guadalajara","Guipúzcoa","Huelva","Huesca","Islas Baleares","Jaén","León","Lérida","Lugo","Madrid","Málaga","Murcia","Navarra","Orense","Palencia","Las Palmas","Pontevedra","La Rioja","Salamanca","Segovia","Sevilla","Soria","Tarragona","Santa Cruz de Tenerife","Teruel","Toledo","Valencia","Valladolid","Vizcaya","Zamora","Zaragoza"};
	private JRadioButton rdbtnM;
	private JRadioButton rdbtnH;
	private JTextField textFieldDNI;
	private JComboBox comboBoxYear;

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
		setResizable(false);

		alumnos = new Queue<Alumno>();
//		alumnos.add(new Alumno("Joaquin", "Alonso", 66666));
//		alumnos.add(new Alumno("Pedro", "Martinez", 77777));
//		alumnos.add(new Alumno("Teresa", "Lopez", 88888));
		aux = alumnos.getHead();

		setTitle("Mi primer Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 411);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatos();
			}
		});
		mnFile.add(mntmOpen);
		
		mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		
		mnFile.add(mntmSave);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		mnFile.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panelSuperior = new JPanel();
		panelSuperior.setBorder(
				new TitledBorder(null, "Alumno", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));

		JPanel panelInferior = new JPanel();
		panelInferior.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelInferior, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
						.addComponent(panelSuperior, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(8))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelSuperior, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelInferior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(119, Short.MAX_VALUE))
		);
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
		
		JButton btnTest = new JButton("test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Has selecionado M: " + rdbtnM.isSelected());
				System.out.println("Has selecionado H: " + rdbtnH.isSelected());
				
				System.out.println("Seleccionado el objeto de la posicion: " + comboBoxProvincia.getSelectedIndex());
				System.out.println("Seleccionado el objeto: " + comboBoxProvincia.getSelectedItem());
				
			}
		});
		panelInferior.add(btnTest);

		JLabel lblNombre = new JLabel("Nombre");

		JLabel lblApellidos = new JLabel("Apellidos");

		JLabel lblTelefono = new JLabel("Teléfono");

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);

		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);

		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		
		comboBoxProvincia = new JComboBox();
		comboBoxProvincia.setMaximumRowCount(10);
		
		JLabel lblDni = new JLabel("DNI");
		
		JLabel lblYear = new JLabel("Year");
		
		comboBoxYear = new JComboBox();
		
		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		
		JLabel lblProvincia = new JLabel("Provincia");
		
		rdbtnM = new JRadioButton("M");
		
		rdbtnM.setSelected(true);
			
		rdbtnH = new JRadioButton("H");
		
		JLabel lblSexo = new JLabel("Sexo");
		GroupLayout gl_panelSuperior = new GroupLayout(panelSuperior);
		gl_panelSuperior.setHorizontalGroup(
			gl_panelSuperior.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSuperior.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelSuperior.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombre)
						.addComponent(lblApellidos)
						.addComponent(lblTelefono)
						.addComponent(lblProvincia)
						.addComponent(lblDni)
						.addComponent(lblSexo))
					.addGap(25)
					.addGroup(gl_panelSuperior.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxProvincia, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelSuperior.createSequentialGroup()
							.addComponent(rdbtnM)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnH))
						.addGroup(gl_panelSuperior.createSequentialGroup()
							.addComponent(textFieldDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblYear)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBoxYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelSuperior.createSequentialGroup()
							.addComponent(textFieldTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 436, Short.MAX_VALUE))
						.addComponent(textFieldNombre, GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
						.addComponent(textFieldApellidos, GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelSuperior.setVerticalGroup(
			gl_panelSuperior.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSuperior.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelSuperior.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelSuperior.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidos)
						.addComponent(textFieldApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelSuperior.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefono)
						.addComponent(textFieldTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panelSuperior.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProvincia)
						.addComponent(comboBoxProvincia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelSuperior.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(lblYear)
						.addComponent(comboBoxYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addGroup(gl_panelSuperior.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSexo)
						.addComponent(rdbtnM)
						.addComponent(rdbtnH))
					.addGap(116))
		);
		
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Valencia", "Madrid"}));
		for(String provincia : provincias)
			comboBoxProvincia.addItem(provincia);
		
		comboBoxProvincia.setSelectedItem("Valencia");
		
		for(int i=1;i<=100;i++)
			comboBoxYear.addItem(i);
		
		comboBoxYear.setSelectedItem(18);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnH);
		bg.add(rdbtnM);	
		panelSuperior.setLayout(gl_panelSuperior);
		contentPane.setLayout(gl_contentPane);

		showNode(aux);
	}



	protected void cargarDatos() {
		
		JFileChooser fc = new JFileChooser();
		int option = fc.showOpenDialog(this);
		
		if(option==JFileChooser.APPROVE_OPTION) {
			
			try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fc.getSelectedFile())))){
				
				alumnos = (Queue<Alumno>)in.readObject();
				JOptionPane.showMessageDialog(this, "El fichero se ha cargado con exito", "Info", JOptionPane.INFORMATION_MESSAGE);
				
				aux=alumnos.getHead();
				showNode(aux);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
		}
		
		
	}

	protected void save() {
		
		JFileChooser fc = new JFileChooser();
		
		int opcion=fc.showSaveDialog(this);
		
		if(opcion == JFileChooser.APPROVE_OPTION) {
			
			try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fc.getSelectedFile())))){
				
				out.writeObject(alumnos);
				JOptionPane.showMessageDialog(this, "El proceso de grabacion se ha realizado correctamente", "Info", JOptionPane.INFORMATION_MESSAGE);
				
			} catch (Exception e) {
				
				JOptionPane.showMessageDialog(this, "Se ha producido un error", "Error", JOptionPane.ERROR_MESSAGE);				
				e.printStackTrace();
			}
			
		}
		
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
		String provincia = comboBoxProvincia.getSelectedItem().toString();
		Alumno.SEXO sexo = (rdbtnH.isSelected())?SEXO.HOMBRE:SEXO.MUJER;
//		if (rdbtnH.isSelected())
//			sexo= SEXO.HOMBRE;
//		else
//			sexo=SEXO.MUJER;
		String dni = textFieldDNI.getText();
		int years = (int)comboBoxYear.getSelectedItem();

		alumnos.add(new Alumno(nombre, apellidos, telefono,provincia,sexo,dni,years));

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

			Alumno a = nodo.getInfo();
			
			textFieldNombre.setText(a.getNombre());
			textFieldApellidos.setText(a.getApellidos());
			textFieldTelefono.setText(String.valueOf(a.getTelefono()));
			comboBoxProvincia.setSelectedItem(a.getProvincia());
			rdbtnH.setSelected((a.getSexo()==SEXO.HOMBRE)?true:false);
			rdbtnM.setSelected((a.getSexo()==SEXO.MUJER)?true:false);
			textFieldDNI.setText(a.getDni());
			comboBoxYear.setSelectedItem(a.getYears());
			
		}

	}
}
