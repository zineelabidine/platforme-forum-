package controler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

import model.Categorie;
import service.ServiceCategorie;
import serviceImp.ImplServiceCategorie;

@ManagedBean
@SessionScoped
public class ControllerCategorieBean implements Serializable{

	private static final long serialVersionUID = 1L;
	ServiceCategorie Scategorie = new ImplServiceCategorie();
	public Categorie categorie=new Categorie();
	public List<Categorie> listecategorie;
	public ControllerCategorieBean() {
		super();
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Categorie> getListecategorie() {
		return Scategorie.getall();
	}

	public void setListecategorie(List<Categorie> listecategorie) {
		this.listecategorie = listecategorie;
	}

	public void creatcategrorie() {

		Scategorie.create(categorie);
		categorie.setDescription("");
		categorie.setNom("");
		
	}

	public void deletecategrorie(Categorie c) {
		Scategorie.delete(c);
	}

	public void updatecategrorie() {
		Scategorie.update(categorie);
		categorie.setDescription("");
		categorie.setNom("");
	}
	public void miseenforme(Categorie c) {
		categorie=c;
		System.out.println(categorie);
	}
	public String NomCategorie(int id) {
		String nom=Scategorie.getNamebyid(id);
		return nom;
	}
	public int idCategorie(String nom) {
		int i=Scategorie.getidbyname(nom);
		return i;
	}
	

}
