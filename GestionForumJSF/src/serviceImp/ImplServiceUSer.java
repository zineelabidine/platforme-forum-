package serviceImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



import model.User;
import service.ServiceUser;

public class ImplServiceUSer implements ServiceUser {
	Connection conx;
	public ImplServiceUSer () 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conx=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionforum","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void create(User user) {
		try {
			Statement ste=conx.createStatement();
			String requte ="INSERT INTO user_forum (nom, password_user, type) VALUES ('"+user.getNom()+"','"+user.getPass()+"','"+user.getType()+"')";
			ste.execute(requte);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void update(User user) {
		try {
			Statement ste=conx.createStatement();
			String requte ="UPDATE user_forum SET nom='"+user.getNom()+"',password_user='"+user.getPass()+"',type='"+user.getType()+"' WHERE id="+user.getId()+";";
			ste.execute(requte);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		// TODO Auto-generated method stub
		
	}
		
	}
	@Override
	public void delete(User user) {
		try {
			Statement ste=conx.createStatement();
			String requte ="DELETE FROM message WHERE id_user="+user.getId()+";";
			ste.execute(requte);
			requte ="DELETE FROM discussion WHERE id_user="+user.getId()+";";
			ste.execute(requte);
			requte ="DELETE FROM forum WHERE id_admin="+user.getId()+";";
			ste.execute(requte);
			requte ="DELETE FROM categorie WHERE id_admin="+user.getId()+";";
			ste.execute(requte);
			requte ="DELETE FROM user_forum WHERE id="+user.getId()+";";
			ste.execute(requte);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	
	@Override
	public List<User> getall() {
		try {
			ArrayList<User> users=new ArrayList<User>();
			Statement ste=conx.createStatement();
			
			ResultSet result =ste.executeQuery("select * FROM user_forum;");
			while(result.next()){
				User u=new User();
				u.setId(result.getInt("id"));
				u.setNom(result.getString("nom"));
				u.setPass(result.getString("password_user"));
				u.setType(result.getString("type"));
				users.add(u);}
			return users;

		} catch (SQLException e) {
			e.printStackTrace();
	}
		return null;
	}
	@Override
	public User logine(User user) {
		User u = null;
		try {
			
			Statement ste=conx.createStatement();
	
			ResultSet result =ste.executeQuery("select * FROM user_forum where nom='"+user.getNom()+"';");
			while(result.next()){
				u=new User();
				u.setId(result.getInt("id"));
				u.setNom(result.getString("nom"));
				u.setPass(tools.tools.decrypt(result.getString("password_user")));
				u.setType(result.getString("type"));}
				return u;
		} catch (SQLException e) {
			e.printStackTrace();
	}
		return u;
	}
	@Override
	public String affichernomuser(int id) {
		String nom = "";
		try {
			Statement ste=conx.createStatement();
			ResultSet result =ste.executeQuery("select * FROM user_forum where id="+id+";");
			while(result.next()) {
				nom =result.getString("nom");
			}
				return nom;
		}catch (SQLException e) {
			e.printStackTrace();
	}
		return null;
	}
	@Override
	public void ajoutertimein(int id) {
		LocalTime myObj = LocalTime.now();
		try {
			Statement ste=conx.createStatement();
			String requte ="INSERT INTO utilisation_forum (user_id , heure_enter) VALUES ("+id+",'"+myObj+"')" ;
			ste.execute(requte);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void ajoutertimeout(int id) {
		LocalTime myObj = LocalTime.now();
		try {
			Statement ste=conx.createStatement();
			String requte ="UPDATE utilisation_forum SET heure_sortie='"+myObj+"' WHERE user_id ="+id+";";
			ste.execute(requte);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public ArrayList<Integer> utilisateur_login() {
		try {
			ArrayList<Integer> users=new ArrayList<Integer>();
			Statement ste=conx.createStatement();
			ResultSet result =ste.executeQuery("select user_id FROM utilisation_forum;");
			while(result.next()){
				int i;
				i=result.getInt("user_id");
				System.out.println(i);
				users.add(i);}
			return users;

		} catch (SQLException e) {
			e.printStackTrace();
	}
		return null;
	}
	


}
