package frames;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Ejemplo4Controler {

	private Ejemplo4Model model;
	private Ejemplo4View view;

	public Ejemplo4Controler(Ejemplo4View view, Ejemplo4Model model) {
		super();
		this.model = model;
		this.view = view;
		
		iniciar();
	}
	public void iniciar() {

		// Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dim = new Dimension(800, 600);

		view.setTitle("Gestion IES");
		view.setMaximumSize(dim);
		view.setExtendedState(JFrame.MAXIMIZED_BOTH);
		view.setLocationRelativeTo(null);// centrado en pantalla
		
	}

	public void go() {
		view.setVisible(true);
	}

}
