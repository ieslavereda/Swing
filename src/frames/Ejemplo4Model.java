package frames;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

public class Ejemplo4Model {
	

	private Properties properties;
	
	private String FILE = "app.properties";
	
	public Ejemplo4Model() {
		
		properties = new Properties();	
		
		// cargar datos de Properties
		obtenerProperties(FILE);
	}
	
	public boolean comprobarLogin( String login,String passwd) {
	
		return properties.getProperty("login").equals(login) &&  properties.getProperty("passwd").equals(passwd);
	}
	
	public  void obtenerProperties(String FILE) {
		
		InetAddress IP = null;
		Integer port = null;
		String login;
		String passwd;
	
		// Cargamos valores desde fichero
		try {
			properties.load(new FileInputStream(FILE));
			IP = InetAddress.getByName(properties.getProperty("IP"));
			port = Integer.parseInt(properties.getProperty("port"));
			login = properties.getProperty("login");
			passwd = properties.getProperty("passwd");

		} catch (Exception e) {
			// Se ejecuta si el fichero no existe o alguna propiedad es null
		}

		// Mostramos los datos del fichero si existiera
		if (IP == null) {
			System.out.println("No existe el fichero.");
			try {
				IP = InetAddress.getByName("127.0.0.1");
			} catch (UnknownHostException e) {
			}
			port = 5555;
			login = "admin";
			passwd ="admin";
			
			// Guardamos las propiedades en un fichero
			try {
				properties.setProperty("login", login);
				properties.setProperty("passwd", passwd);
				properties.setProperty("IP", IP.getHostAddress());
				properties.setProperty("port", String.valueOf(port));
				
				properties.store(new FileOutputStream(FILE), "Propiedades de mi aplicacion");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
	}

}
