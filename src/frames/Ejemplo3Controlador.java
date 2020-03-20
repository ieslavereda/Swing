package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class Ejemplo3Controlador implements ActionListener {
	
	private Ejemplo3View view;
	private ArrayList<Alumno> alumnos;

	public static void main(String[] args) {
		
		
		Ejemplo3View view = new Ejemplo3View();
		Ejemplo3Controlador controlador = new Ejemplo3Controlador(view);
		
		controlador.start();		
	}
	
	public Ejemplo3Controlador(Ejemplo3View view) {
		
		this.view=view;	
		
		alumnos = new ArrayList<Alumno>();
		
		inicializar();
	}
	
	private void inicializar() {
		
		view.getBtnAdd().addActionListener(this);
		view.getBtnDelete().addActionListener(this);
		
		view.getBtnAdd().setActionCommand("Add");
		view.getBtnDelete().setActionCommand("Delete");
				
	}

	private void start() {
		view.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Add")) {
			add();
		}else if (e.getActionCommand().equals("Delete")) {
			System.out.println("Delete");
		}
		
	}

	private void add() {
		
		String nombre = view.getTextFieldNombre().getText();
		String apellidos = view.getTextFieldApellidos().getText();
		int edad = view.getSlider().getValue();
		
		// Add alumno a arraylist
		Alumno alumno = new Alumno(nombre,apellidos,edad);
		alumnos.add(alumno);
		
		// Visualizar Tabla
		DefaultTableModel dtm = (DefaultTableModel)view.getTable().getModel();
		dtm.addRow(new String[] {nombre,apellidos,String.valueOf(edad)});
		
	}


	

}
