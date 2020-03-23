package frames;

import java.awt.EventQueue;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;



public class Ejemplo4App {
public static void main( String[] args ) {
		
    	EventQueue.invokeLater(new Runnable() {
			public void run() {

				// se crean los objetos MODELO y VISTA
				Ejemplo4Model modelo = new Ejemplo4Model();
				Ejemplo4View vista = new Ejemplo4View();
				
				// Para colocar un skin propio de java
				try {
					
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							SwingUtilities.updateComponentTreeUI(vista);
							break;
						}
					}

					new Ejemplo4Controler(vista, modelo).go();
					
				} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
					ex.printStackTrace();
				} 
			}
    	});
	}
}
