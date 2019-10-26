package controler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.bean.SessionScoped;

import model.Categorie;
import model.Forum;
import service.ServiceCategorie;
import service.ServiceForum;
import serviceImp.ImplServiceCategorie;
import serviceImp.ImplServiceForum;

@ManagedBean(name="controllerForumBean")
@SessionScoped
public class ControllerForumBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	ServiceCategorie Scategorie=new ImplServiceCategorie();;
	public Forum forum=new Forum();
	public List<Forum> listeforum;
	public List<Categorie> listecategorie;
	public List<Forum> listeforumuser;
	public String nomcategorie;
	public int id_categorie;

	
	
	public String getNomcategorie() {
		return nomcategorie;
	}
	public void setNomcategorie(String nomcategorie) {
		this.nomcategorie = nomcategorie;
	}
	public String nomCategorie() {
		nomcategorie=Scategorie.getNamebyid(id_categorie);
		return nomcategorie;
	}
	
	
	public Categorie categorie=new Categorie();
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	ServiceForum Sforum=new ImplServiceForum();
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public List<Forum> getListeforum() {
		return Sforum.getall();
	}
	public void setListeforum(List<Forum> listeforum) {
		this.listeforum = listeforum;
	}
	public void creatforum() {
		forum.setId_categorie(Scategorie.getidbyname(nomcategorie));
		Sforum.create(forum);
		
	} 
	
	public void deleteforum(Forum c) {
		
		Sforum.delete(c);
	} 
	public void updeteforum() {
	
		forum.setId_categorie(Scategorie.getidbyname(nomcategorie));
		Sforum.update(forum);
	}

	public List<String> recupererlistecategorie(String query) {
        List<String> results = new ArrayList<String>();
        List<Categorie> listcategorie=new ArrayList<Categorie>();
        listcategorie=Scategorie.getall();
        for(int i=0;i<listcategorie.size();i++) {
        	results.add(listcategorie.get(i).getNom());
        }
       return results;
	}
	public List<Categorie> getListecategorie() {
		return listecategorie;
	}
	public void setListecategorie(List<Categorie> listecategorie) {
		this.listecategorie = listecategorie;
	}
	public void miseenforme(Forum c) {
	
		nomcategorie=Scategorie.getNamebyid(c.getId_categorie());
		forum=c;
	}
	public List<Forum> getListeforumuser() {
		listeforumuser=Sforum.getlistebycategorie(id_categorie);
		return listeforumuser;
	}
	public void setListeforumuser(List<Forum> listeforumuser) {
		this.listeforumuser = listeforumuser;
	}
	public String derectionforum(int id_cate) {
		System.out.println(id_cate);
	id_categorie=id_cate;
	if(id_cate>0) {
		return "listeforumuser";
	}
	return null;

	}
	public String recupererNomcategorie(int id) {
		return Scategorie.getNamebyid(id);
	}

	
}
