package serviceImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Forum;
import model.Message;
import service.ServiceForum;

public class ImplServiceForum implements ServiceForum {
	Connection conx;
	public ImplServiceForum () 
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
	public void create(Forum forum) {
		try {
			Statement ste=conx.createStatement();
			String requte ="INSERT INTO forum (titre, description, 	id_categorie) VALUES ('"+forum.getNom()+"','"+forum.getDescription()+"','"+forum.getId_categorie()+"')";
			ste.execute(requte);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void update(Forum forum) {
		try {
			Statement ste=conx.createStatement();
			String requte ="UPDATE forum SET titre='"+forum.getNom()+"',description='"+forum.getDescription()+"',id_categorie='"+forum.getId_categorie()+"' WHERE id="+forum.getId()+";";
			ste.execute(requte);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		// TODO Auto-generated method stub
		
	}
		
	}
	@Override
	public void delete(Forum forum) {
		try {
			Statement ste=conx.createStatement();
			String requte ="DELETE FROM message WHERE message.id_discussion=(SELECT id FROM discussion WHERE discussion.id_forum= "+forum.getId()+");";
			ste.execute(requte);
			requte ="DELETE FROM discussion WHERE discussion.id_forum="+forum.getId()+";";
			ste.execute(requte);
			requte ="DELETE FROM forum WHERE forum.id="+forum.getId()+";"; 
			ste.execute(requte);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Forum> getall() {
		try {
			ArrayList<Forum> forums=new ArrayList<Forum>();
			Statement ste=conx.createStatement();
			
			ResultSet result =ste.executeQuery("select * FROM forum;");
			while(result.next()){
				Forum f=new Forum();
				f.setId(result.getInt("id"));
				f.setNom(result.getString("titre"));
				f.setDescription(result.getString("description"));
				f.setId_categorie(result.getInt(5));
				forums.add(f);}
			return forums;

		} catch (SQLException e) {
			e.printStackTrace();
	}
		return null;
	}
	@Override
	public List<Forum> getlistebycategorie(int id_categorie) {
		try {
			ArrayList<Forum> forums=new ArrayList<Forum>();
			Statement ste=conx.createStatement();
			
			ResultSet result =ste.executeQuery("select * FROM forum where  	id_categorie="+id_categorie+";");
			while(result.next()){
				Forum f=new Forum();
				f.setId(result.getInt("id"));
				f.setNom(result.getString("titre"));
				f.setDescription(result.getString("description"));
				f.setId_categorie(result.getInt(5));
				forums.add(f);}
			return forums;

		} catch (SQLException e) {
			e.printStackTrace();
	}
		return null;
	}
	
}
