package gestionnaire;

public class Contact  {

	private int id;
	
	private String nom;
	
	private String tel;
	
	private byte[] image;
	
	private Utilisateur user;
	

	public Contact() {
	}
	
	public Contact(String nom, String tel) {
		this.nom = nom;
		this.tel = tel;
	}
	
	public String toString() {
		
		return "Nom: "+this.nom+" "+" Tél: " + this.tel;
	}
	
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getTel() {
		return this.tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
}
