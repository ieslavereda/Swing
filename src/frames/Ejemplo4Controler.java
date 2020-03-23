package frames;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Ejemplo4Controler implements ActionListener {

	private Ejemplo4Model model;
	private Ejemplo4View view;

	public Ejemplo4Controler(Ejemplo4View view, Ejemplo4Model model) {
		super();
		this.model = model;
		this.view = view;
		
		inicializar();
	}
	public void inicializar() {

		// Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dim = new Dimension(800, 600);

		view.setTitle("Gestion DHCP");
		view.setMaximumSize(dim);
		view.setExtendedState(JFrame.MAXIMIZED_BOTH);
		view.setLocationRelativeTo(null);// centrado en pantalla
		
		// Añadir los ActionListener
		view.getMntmExit().addActionListener(this);
		
		// Añadir los ActionCommand
		view.getMntmExit().setActionCommand("Exit");
		
		
	}

	public void go() {
		view.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		if(command.equals("Exit")) {
			view.dispose();
		}
		
	}

}
