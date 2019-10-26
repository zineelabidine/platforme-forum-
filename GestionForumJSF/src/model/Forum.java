package model;

public class Forum {
	int id;
	String nom;
	String description;
	int id_categorie;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId_categorie() {
		return id_categorie;
	}
	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}
	public Forum() {
		super();
	}
	public Forum(int id, String nom, String description, int id_categorie) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.id_categorie = id_categorie;
	}
	@Override
	public String toString() {
		return "Forum [id=" + id + ", nom=" + nom + ", description=" + description + ", id_categorie=" + id_categorie
				+ "]";
	}

}
