package controler;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Discussion;
import service.ServiceDiscussion;
import serviceImp.ImplServiceDiscussion;

@ManagedBean(name = "contollerDiscussionBean")
@SessionScoped
public class ContollerDiscussionBean implements Serializable {

	private static final long serialVersionUID = 1L;
	ServiceDiscussion Sdiscussion = new ImplServiceDiscussion();
	public List<Discussion> listediscussion;
	public Discussion discussion = new Discussion();
	public int id_forum;

	public int getId_forum() {
		return id_forum;
	}

	public void setId_forum(int id_forum) {
		this.id_forum = id_forum;
	}

	public List<Discussion> getListediscussion() {

		listediscussion = Sdiscussion.getall(id_forum);
		System.out.println(listediscussion);
		return listediscussion;
	}

	public void setListediscussion(List<Discussion> listediscussion) {
		this.listediscussion = listediscussion;
	}

	public Discussion getDiscussion() {
		return discussion;
	}

	public void setDiscussion(Discussion discussion) {
		this.discussion = discussion;
	}

	public String affichediscussion(int id) {
		id_forum = id;
		return "gestiondiscussion";

	}

	public int afficheriddiscussion() {
		return discussion.getId();
	}

	public void creatediscussion() {
		if(!discussion.getDescription().equals("") && !discussion.getNom().equals("")) {
		FacesContext context = FacesContext.getCurrentInstance();
		int id = Integer.parseInt(String.valueOf(context.getExternalContext().getSessionMap().get("id")));
		System.out.println(id);
		Sdiscussion.create(discussion, id_forum,id);
		discussion.setDescription("");
		discussion.setNom("");}
	}

}
