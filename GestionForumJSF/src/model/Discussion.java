package model;

public class Discussion {
	int id ;
	String nom;
	String description;
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
	public Discussion() {
		super();
	}
	public Discussion(int id, String nom, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Discussion [id=" + id + ", nom=" + nom + ", description=" + description + "]";
	}
	

}
