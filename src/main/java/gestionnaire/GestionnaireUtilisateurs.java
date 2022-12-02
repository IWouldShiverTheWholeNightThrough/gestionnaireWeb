package gestionnaire;
import java.util.ArrayList;

public class GestionnaireUtilisateurs {
	private ArrayList<Utilisateur> users;
	//private DaoImplUser dao;
	
	public GestionnaireUtilisateurs() {
		this.users = new ArrayList<Utilisateur>();
		
		//DaoImplUser dao = new DaoImplUser(this);
		//this.dao = dao;
		
	}
	
	public boolean creerUser(Utilisateur user) {
		if(this.rechercheUserparName(user) == -1) {
			this.users.add(user);
			return true;
		}

		return false;		
	}
	
	public int rechercheUserparName(Utilisateur user) {
		
		int n = this.users.size();
		int i = 0;
		int indice = -1;
		while(indice == -1 && i<n) {
			if(this.users.get(i).getName().equals(user.getName())) {
				indice = i;
				break;
			}
			i++;
		}
		return indice;
	}
	
	public ArrayList<Utilisateur> getUsers() {
		return this.users;
	}
	public void setUsers(ArrayList<Utilisateur> users) {
		this.users = users;
	}	
}
