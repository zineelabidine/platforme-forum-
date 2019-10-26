package tools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import service.ServiceCategorie;
import service.ServiceDiscussion;
import service.ServiceForum;
import service.ServiceMessage;
import service.ServiceUser;
import serviceImp.ImplServiceCategorie;
import serviceImp.ImplServiceDiscussion;
import serviceImp.ImplServiceForum;
import serviceImp.ImplServiceMessage;
import serviceImp.ImplServiceUSer;

public class tools {
	
	
	public static int nomberuser() {
		
		ServiceUser Suser=new ImplServiceUSer();
		int i=Suser.getall().size();
		return i;
	}
	public static int nombercategorie() {
		ServiceCategorie Scategorie=new ImplServiceCategorie();
		int i=Scategorie.getall().size();
		return i;
	}
	public static int nomberforum() {
		ServiceForum Sforum=new ImplServiceForum();
		int i=Sforum.getall().size();
		return i;
	}
	
	public static int nomberdiscussion() {
		ServiceDiscussion Sdiscussion=new ImplServiceDiscussion();
		int i=Sdiscussion.afficher().size();
		return i;
	}
	public static int nombermessage() {
		ServiceMessage Smessage=new ImplServiceMessage();
		int i=Smessage.afficher().size();
		return i;
	}
	 public static String encrypt(String password){
	        String crypte="";
	        for (int i=0; i<password.length();i++)  {
	            int c=password.charAt(i)^48; 
	            crypte=crypte+(char)c;
	        }
	        return crypte;
	    }
	   public static String decrypt(String password){
	        String aCrypter="";
	        for (int i=0; i<password.length();i++)  {
	            int c=password.charAt(i)^48; 
	            aCrypter=aCrypter+(char)c;
	        }
	        return aCrypter;
	    }
	   public static int pourcentageUser() {
		   ServiceUser Suser=new ImplServiceUSer();
		   ArrayList<Integer> users=new ArrayList<Integer>();
		  int number;
		   users=Suser.utilisateur_login();
		   number=users.size();
		   return number;
	   }

	   public static double pourcentage() {
		   ServiceUser Suser=new ImplServiceUSer();
		   ArrayList<Integer> users=new ArrayList<Integer>();
			   users=Suser.utilisateur_login();
			   HashSet<Integer> h = new HashSet<Integer>(users); 
			   System.out.println(h.size());
			   System.out.println(users);
			   System.out.println(h);
		   int i=h.size();
		   int j=nomberuser();
		   double resultat;
		   resultat= (double) i/j;
		   resultat=resultat*100;
		   System.out.println(resultat);
		   return (resultat);
		   
	   }
	

}
