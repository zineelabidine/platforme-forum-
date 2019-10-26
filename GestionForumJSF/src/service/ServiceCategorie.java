package service;

import java.util.List;

import model.Categorie;

public interface ServiceCategorie {
//	eviter void 
	public void create(Categorie categorie);
	public void update(Categorie categorie);
	public void delete(Categorie categorie);
	public List<Categorie> getall();
	public String getNamebyid(int id);
	public int getidbyname(String nom);
	

}
