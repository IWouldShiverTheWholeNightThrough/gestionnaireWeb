package gestionnaire;
import java.util.List;


public class Utilisateur {
	
	private int id;
	
	private String name;
	
	private List<Contact> contacts;
	
	private GestionnaireUtilisateurs gestionnaireUser;
	
	private GestionnaireDeContact gestionnaire;

	//private DaoImplementationModel dao;
	
	public Utilisateur() {
		
	}
	
	public Utilisateur(String name, GestionnaireUtilisateurs gestUser) {
		this.name = name;
		this.gestionnaireUser = gestUser;
	}
	
	public void login() {
		this.gestionnaire = new GestionnaireDeContact(this);
		//this.dao = new DaoImplementationModel(this.gestionnaire, this, this.gestionnaireUser.getDao().getFactory());
		
		//vue.lancerVueUser(gestionnaire, dao);
	}
	

	public String toString() {
		return this.name;
	}


	public GestionnaireDeContact getGestionnaire() {
		return this.gestionnaire;
	}

	public void setGestionnaire(GestionnaireDeContact gestionnaire) {
		this.gestionnaire = gestionnaire;
	}	

	public GestionnaireUtilisateurs getGestionnaireUser() {
		return this.gestionnaireUser;
	}
	public void setGestionnaireUser(GestionnaireUtilisateurs gestionnaireUser) {
		this.gestionnaireUser = gestionnaireUser;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Contact> getContacts() {
		return contacts;
	}


	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}



}
