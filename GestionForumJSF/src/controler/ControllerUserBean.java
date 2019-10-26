package controler;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Message;
import model.User;
import service.ServiceMessage;
import service.ServiceUser;
import serviceImp.ImplServiceMessage;
import serviceImp.ImplServiceUSer;
import tools.tools;

@ManagedBean
@SessionScoped
public class ControllerUserBean {
	
	

	public ControllerMessageBean getControllerMessageBean() {
		return controllerMessageBean;
	}

	public void setControllerMessageBean(ControllerMessageBean controllerMessageBean) {
		this.controllerMessageBean = controllerMessageBean;
	}

	ServiceUser Suser = new ImplServiceUSer();
	public User user = new User();
	public List<User> listeuser;
	public  User userv=new User();
	public Message message= new Message();
	ServiceMessage Smessage=new ImplServiceMessage();
	public int id_disc;
	public int nombre_authentification;
	public double resultat;
	
	public double getResultat() {
		resultat=tools.pourcentage();
		resultat=Math.round(resultat);
		return resultat;
	}

	public void setResultat(double resultat) {
		this.resultat = resultat;
	}

	public int getNombre_authentification() {
		nombre_authentification=tools.pourcentageUser();
		return nombre_authentification;
	}

	public void setNombre_authentification(int nombre_authentification) {
		this.nombre_authentification = nombre_authentification;
	}

	public int getId_disc() {
		return id_disc;
	}

	public void setId_disc(int id_disc) {
		this.id_disc = id_disc;
	}

	public ControllerMessageBean controllerMessageBean;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getListeuser() {
		return Suser.getall();
	}

	public void setListeuser(List<User> listeuser) {
		this.listeuser = listeuser;

	}

	public void createuser() {
		user.setPass(tools.encrypt(user.getPass()));
		Suser.create(user);
		System.out.println(user.getNom());
		user.setNom("");
		user.setPass("");
	}

	public void deleteuser(User u) {
		
		Suser.delete(u);
	}

	public void miseenforme(User u) {
		user = u;
	}

	public void updateuser() {
		user.setPass(tools.encrypt(user.getPass()));
		Suser.update(user);
	}

	public String loginuser() {
		System.out.println(user);
	
		 FacesContext context = FacesContext.getCurrentInstance();
		 
		
		userv = Suser.logine(user);
		System.out.println(userv);


		System.out.println(userv);
System.out.println(userv);
		if(userv==null) {

          
			return ("index");
		}
		else if( userv.getType().equals("admin") && userv.getPass().equals(user.getPass())) {
			context.getExternalContext().getSessionMap().put("id", userv.getId());
			Suser.ajoutertimein(userv.getId());
			user.setNom("");
			user.setPass("");
			return ("admin");
		}
		else if(userv.getType().equals("user") && userv.getPass().equals(user.getPass())) {
			context.getExternalContext().getSessionMap().put("id", userv.getId());
			Suser.ajoutertimein(userv.getId());
			user.setNom("");
			user.setPass("");
			return ("user");
		
		}

		return "index";


	}
	  public List<String> completeText(String query) {
	        List<String> results = new ArrayList<String>();
	        results.add("admin");
	        results.add("user");
	        return results;
	        }

	public User getUserv() {
		return userv;
	}

	public void setUserv(User userv) {
		this.userv = userv;
	}
	public int afficheriduser() {
		return userv.getId();
	}
	public void createmessage() {
		

		Smessage.create(message,userv.getId(),id_disc);
		
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	public String timegoout() {
		Suser.ajoutertimeout(userv.getId());
		return "index";
	}
	public String inscription() {
		if(!user.getNom().equals("") && !user.getPass().equals("")) {
		user.setType("user");
		Suser.create(user);
		user.setNom("");
		user.setPass("");
		return "index";}
		else {
			return "inscription";
		}
	
	}


	  
}
