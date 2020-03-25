package frames;

public class Ejemplo4Model {

	private String login;
	private String passwd;
	
	public Ejemplo4Model() {
		// cargar datos de Properties
	}
	public boolean comprobarLogin( String login,String passwd) {
		return this.login==login && this.passwd==passwd;
	}
	

}
