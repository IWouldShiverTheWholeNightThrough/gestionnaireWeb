package gestionnaire;
import java.util.ArrayList;
import java.util.Observable;

public class GestionnaireDeContact{

	private ArrayList<Contact> contacts;
	private Utilisateur user;

	public GestionnaireDeContact(Utilisateur user) {
		this.contacts = new ArrayList<Contact>();
		this.user = user;
	}

	public boolean ajouteContact(Contact contact) {
		
		if(this.rechercheContactParTel(contact) == -1) {
			this.contacts.add(contact);		
			
			return true;
		}

		return false;		
	}

	public boolean supprimeContact(Contact contact) {

		int indice = rechercheContactParTel(contact);
		if(indice != -1) {
			this.contacts.remove(this.contacts.get(indice));
			
			return true;
		} else {
			
			return false;
		}
	}

	public boolean modifieContact(Contact contact, Contact new_contact) {

		int indice = rechercheContactParTel(contact);

		if(indice != -1 ) {
			
			if(! contact.getTel().equals(new_contact.getTel()))
			{
				if(rechercheContactParTel(new_contact) != -1) {
					
					return false;
				}
			}
			
			this.contacts.get(indice).setNom(new_contact.getNom());
			this.contacts.get(indice).setTel(new_contact.getTel());
			
			return true;
		}

		return false;
	}

	public int rechercheContactParTel(Contact contact) {

		int n = this.contacts.size();
		int i = 0;
		int indice = -1;
		while(indice == -1 && i<n) {
			if(this.contacts.get(i).getTel().equals(contact.getTel())) {
				indice = i;
				break;
			}
			i++;
		}
		
		return indice;
	}
	
	public ArrayList<Contact> getContacts() {
		return this.contacts;
	}
	public void setContacts(ArrayList<Contact> contacts) {
		this.contacts = contacts;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
	

}
