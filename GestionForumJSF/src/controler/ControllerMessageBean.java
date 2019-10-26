package controler;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Message;
import service.ServiceMessage;
import service.ServiceUser;
import serviceImp.ImplServiceMessage;
import serviceImp.ImplServiceUSer;

@ManagedBean(name = "controllerMessageBean")
@SessionScoped
public class ControllerMessageBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public ControllerUserBean controllerUserBean;
	public Message message = new Message();;
	public List<Message> listemessage;
	public int id_discussion;

	public int getId_discussion() {
		return id_discussion;
	}

	public void setId_discussion(int id_discussion) {
		this.id_discussion = id_discussion;
	}

	public int id_user;
	public int id_dic;
	ServiceMessage Smessage = new ImplServiceMessage();

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public List<Message> getListemessage() {

		listemessage = Smessage.getall(id_discussion);
		return listemessage;
	}

	public void setListemessage(List<Message> listemessage) {
		this.listemessage = listemessage;
	}

	public String afficherMessage(int id) {
		id_discussion = id;

		return "gestionmessage";
	}

	public void createmessage() {
		if(!message.getMessage().equals("") && !message.getMessage().equals("")) {

		FacesContext context = FacesContext.getCurrentInstance();
		int id = Integer.parseInt(String.valueOf(context.getExternalContext().getSessionMap().get("id")));
		System.out.println(id);
	
		Smessage.create(message, id, id_discussion);
		message.setMessage("");
		message.setObject("");}
	}

	public int afficheriddis() {
		return id_discussion;
	}
	
	public String recupererNomUser(int id_message) {
		int id_user=Smessage.afficheriduser(id_message);
		ServiceUser Suser=new ImplServiceUSer();
		String nom_user=Suser.affichernomuser(id_user);
		return nom_user;
}}
